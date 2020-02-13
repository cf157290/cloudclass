package com.wscloudclass.service;

import com.wscloudclass.dto.CompleteSignInDTO;
import com.wscloudclass.dto.SignInDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.mapper.CompleteSignInMapper;
import com.wscloudclass.mapper.SignInMapper;
import com.wscloudclass.mapper.UserMapper;
import com.wscloudclass.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SignInService {
    @Autowired
    SignInMapper signInMapper;
    @Autowired
    CompleteSignInMapper completeSignInMapper;
    @Autowired
    UserMapper userMapper;
    public boolean haveSignIn(Long cid) {
        SignInExample example = new SignInExample();
        example.createCriteria().andCidEqualTo(cid);
        List<SignIn> signIns = signInMapper.selectByExample(example);
        Date nowTime=new Date();
        for (SignIn signIn:signIns){
            if (signIn.getEndTime().after(nowTime)){
                return true;
            }
        }
        return false;
    }

    @Transactional
    public boolean createSignIn(Long cid, SignInDTO signInDTO) {
        SignIn record = new SignIn();
        record.setCid(cid);
        Calendar calendar=Calendar.getInstance();
        Date startTime=calendar.getTime();
        record.setStartTime(startTime);
        calendar.add(Calendar.MINUTE,signInDTO.getMinute());
        Date endTime= calendar.getTime();
        record.setEndTime(endTime);
        record.setSignCode(signInDTO.getSignCode());
        record.setScore(signInDTO.getScore());
        int insert = signInMapper.insert(record);
        if (insert==1){
            return true;
        }
        return false;
    }

    public int signIn(Long cid, Long uid, String code) {
        //查找该班课创建过的签到
        SignInExample example = new SignInExample();
        example.createCriteria().andCidEqualTo(cid);
        List<SignIn> signIns = signInMapper.selectByExample(example);
        //查询正在进行的签到
        Date nowDate=new Date();
        for (SignIn signIn:signIns){
            if (signIn.getEndTime().after(nowDate)){//正在进行的签到
                if (!code.equals(signIn.getSignCode())){
                    //签到码错误
                    return 2;
                }else {
                    //签到码正确，查询是否重复签到
                    CompleteSignInExample completeSignInExample = new CompleteSignInExample();
                    completeSignInExample.createCriteria().andUidEqualTo(uid).andSignIdEqualTo(signIn.getSignId());
                    long count = completeSignInMapper.countByExample(completeSignInExample);
                    if (count==1){
                        //重复签到
                        return 3;
                    }else {
                        //进行签到
                        CompleteSignIn record = new CompleteSignIn();
                        record.setUid(uid);
                        record.setSignId(signIn.getSignId());
                        record.setSignDate(new Date());
                        int insert = completeSignInMapper.insert(record);
                        return insert;//1代表签到成功
                    }
                }
            }
        }
        return 4;//签到已结束
    }

    public List<CompleteSignInDTO> lookSignIn(Long cid) {
        //查询正在进行的签到
        List<CompleteSignInDTO> list=new ArrayList<>();
        SignInExample example = new SignInExample();
        example.createCriteria().andCidEqualTo(cid);
        List<SignIn> signIns = signInMapper.selectByExample(example);
        for (SignIn signIn:signIns){
            if (signIn.getEndTime().after(new Date())){
                //正在进行的签到
                CompleteSignInExample completeSignInExample = new CompleteSignInExample();
                completeSignInExample.createCriteria().andSignIdEqualTo(signIn.getSignId());
                List<CompleteSignIn> completeSignIns = completeSignInMapper.selectByExample(completeSignInExample);//完成签到列表
                List<Long> uids=new ArrayList<>();
                for (CompleteSignIn completeSignIn:completeSignIns){
                    //获取签到完成成员的id
                    uids.add(completeSignIn.getUid());
                }
                if (uids.size()!=0){
                    //有人进行过签到
                    UserExample userExample = new UserExample();
                    userExample.createCriteria().andUidIn(uids);
                    List<User> users = userMapper.selectByExample(userExample);
                    for (User user:users){
                        for (CompleteSignIn completeSignIn:completeSignIns){
                            if (user.getUid().equals(completeSignIn.getUid())){//寻找当前用户的签到时间
                                CompleteSignInDTO completeSignInDTO=new CompleteSignInDTO();
                                completeSignInDTO.setSignDate(completeSignIn.getSignDate());
                                UserDTO userDTO=new UserDTO();
                                BeanUtils.copyProperties(user,userDTO);
                                userDTO.setUserName(user.getUsername());
                                completeSignInDTO.setUser(userDTO);
                                list.add(completeSignInDTO);
                            }
                        }
                    }
                }
            }
        }
        Comparator<CompleteSignInDTO> bySignDate=Comparator.comparing(CompleteSignInDTO::getSignDate);
        list.sort(bySignDate);
        return list;
    }

    public String findSignInCode(Long cid) {
        SignInExample example = new SignInExample();
        example.createCriteria().andCidEqualTo(cid);
        List<SignIn> signIns = signInMapper.selectByExample(example);
        for (SignIn signIn:signIns){
            if (signIn.getEndTime().after(new Date())){
                return signIn.getSignCode();
            }
        }
        return null;
    }

    public boolean endSignIn(Long cid) {
        SignInExample example = new SignInExample();
        example.createCriteria().andCidEqualTo(cid);
        List<SignIn> signIns = signInMapper.selectByExample(example);
        for (SignIn signIn:signIns){
            if (signIn.getEndTime().after(new Date())){
                SignIn record = new SignIn();
                record.setEndTime(new Date());
                SignInExample signInExample = new SignInExample();
                signInExample.createCriteria().andSignIdEqualTo(signIn.getSignId());
                signInMapper.updateByExampleSelective(record, signInExample);//更新结束时间
            }
        }
        return true;
    }
}
