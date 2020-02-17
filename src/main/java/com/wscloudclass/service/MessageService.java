package com.wscloudclass.service;

import com.wscloudclass.dto.CourseInfoDTO;
import com.wscloudclass.dto.MessageContentDTO;
import com.wscloudclass.dto.MessageMemberDTO;
import com.wscloudclass.mapper.CourseInfoMapper;
import com.wscloudclass.mapper.JoinCourseMapper;
import com.wscloudclass.mapper.MessageMapper;
import com.wscloudclass.mapper.UserMapper;
import com.wscloudclass.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageService {
    @Autowired
    CourseInfoMapper courseInfoMapper;
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    JoinCourseMapper joinCourseMapper;
    public void createCourseInfo(Long cid, CourseInfoDTO courseInfoDTO) {
        CourseInfo record = new CourseInfo();
        record.setCid(cid);
        record.setInfoContent(courseInfoDTO.getInfoContent());
        record.setInfoTitle(courseInfoDTO.getInfoTitle());
        record.setReleaseTime(new Date());
        courseInfoMapper.insert(record);
    }

    public List<CourseInfoDTO> getCourseInfo(Long cid) {
        List<CourseInfoDTO> list=new ArrayList<>();
        CourseInfoExample example = new CourseInfoExample();
        example.createCriteria().andCidEqualTo(cid);
        List<CourseInfo> courseInfos = courseInfoMapper.selectByExample(example);
        for (CourseInfo courseInfo:courseInfos){
            CourseInfoDTO courseInfoDTO=new CourseInfoDTO();
            courseInfoDTO.setInfoId(courseInfo.getInfoId());
            courseInfoDTO.setInfoTitle(courseInfo.getInfoTitle());
            courseInfoDTO.setInfoContent(courseInfo.getInfoContent());
            courseInfoDTO.setReleaseTime(courseInfo.getReleaseTime());
            Comparator<CourseInfoDTO>byTime=Comparator.comparing(CourseInfoDTO::getReleaseTime).reversed();
            list.sort(byTime);
            list.add(courseInfoDTO);
        }
        return list;
    }

    public List<MessageContentDTO> getMessage(Long uid, Long toId) {
        //更新消息状态，将消息设为为已经查看
        Message record = new Message();
        record.setIsCheck(2);
        MessageExample messageExample1 = new MessageExample();
        messageExample1.createCriteria().andSendIdEqualTo(toId);
        messageMapper.updateByExampleSelective(record, messageExample1);
        List<MessageContentDTO> list=new ArrayList<>();
        //查询两个用户的信息
        User user = userMapper.selectByPrimaryKey(uid);
        User toUser = userMapper.selectByPrimaryKey(toId);
        //用户发送给对方的信息
        MessageExample example = new MessageExample();
        example.createCriteria().andSendIdEqualTo(uid).andToIdEqualTo(toId);
        List<Message> sendMessages = messageMapper.selectByExample(example);//用户发送给对方的消息列表
        //对方发送给用户的消息
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andSendIdEqualTo(toId).andToIdEqualTo(uid);
        List<Message> receiveMessages = messageMapper.selectByExample(messageExample);//对方发送给该用户的消息
        receiveMessages.addAll(sendMessages);//合并消息
        for (Message message:receiveMessages){
            MessageContentDTO messageContentDTO=new MessageContentDTO();
            messageContentDTO.setSendId(message.getSendId());
            messageContentDTO.setMessageContent(message.getMessageContent());
            messageContentDTO.setSendTime(message.getSendTime());
            messageContentDTO.setToId(message.getToId());
            if (message.getSendId().equals(uid)){
                messageContentDTO.setImgUrl(user.getImgUrl());
                messageContentDTO.setUserName(user.getUsername());
            }else {
                messageContentDTO.setImgUrl(toUser.getImgUrl());
                messageContentDTO.setUserName(toUser.getUsername());
            }
            list.add(messageContentDTO);
        }
        Comparator<MessageContentDTO>byTime=Comparator.comparing(MessageContentDTO::getSendTime);//按发送时间排序
        list.sort(byTime);
        return list;
    }

    public List<MessageMemberDTO> getMembers(Long cid,Long uid) {
        List<MessageMemberDTO> list=new ArrayList<>();
        JoinCourseExample example = new JoinCourseExample();
        example.createCriteria().andCidEqualTo(cid);
        List<JoinCourseKey> joinCourseKeys = joinCourseMapper.selectByExample(example);
        List<Long> uids=new ArrayList<>();
        for (JoinCourseKey joinCourseKey:joinCourseKeys){
            uids.add(joinCourseKey.getUid());
        }
        if (uids.size()>0){
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUidIn(uids);
            List<User> users = userMapper.selectByExample(userExample);
            for (User user:users){
                MessageMemberDTO messageMemberDTO=new MessageMemberDTO();
                messageMemberDTO.setImgUrl(user.getImgUrl());
                messageMemberDTO.setUid(user.getUid());
                messageMemberDTO.setUserName(user.getUsername());
                messageMemberDTO.setUserNumber(user.getUserNumber());
                MessageExample messageExample = new MessageExample();
                messageExample.createCriteria().andSendIdEqualTo(user.getUid()).andToIdEqualTo(uid).andIsCheckEqualTo(1);
                long count = messageMapper.countByExample(messageExample);
                messageMemberDTO.setMessageCount((int) count);
                list.add(messageMemberDTO);
            }
        }
        Comparator<MessageMemberDTO>byuserNumber=Comparator.comparing(MessageMemberDTO::getUserNumber);
        list.sort(byuserNumber);
        return list;
    }

    public void submitUserMessage(Long sendId, Long toId, Map map) {
        Message record = new Message();
        record.setIsCheck(1);
        record.setMessageContent((String) map.get("message"));
        record.setSendId(sendId);
        record.setToId(toId);
        record.setSendTime(new Date());
        messageMapper.insert(record);
    }
}
