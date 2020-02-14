package com.wscloudclass.service;

import com.wscloudclass.dto.MemberDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.mapper.*;
import com.wscloudclass.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    JoinCourseMapper joinCourseMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    SignInMapper signInMapper;
    @Autowired
    CompleteSignInMapper completeSignInMapper;
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    SubmitFileMapper submitFileMapper;
    @Autowired
    FileScoreMapper fileScoreMapper;
    @Autowired
    DescriptionMapper descriptionMapper;
    @Autowired
    SelectActivityMapper selectActivityMapper;
    @Autowired
    SelectionMapper selectionMapper;
    @Autowired
    UserAnswersMapper userAnswersMapper;
    @Autowired
    PartiActivityMapper partiActivityMapper;
    @Autowired
    CourseResourcesMapper courseResourcesMapper;
    @Autowired
    DownloadResourcesMapper downloadResourcesMapper;
    public MemberDTO getMemberRecords(Long cid, Long uid) {
        //查询班课中的成员
        MemberDTO memberDTO=new MemberDTO();
        List<UserDTO> list=new ArrayList<>();
        JoinCourseExample example = new JoinCourseExample();
        example.createCriteria().andCidEqualTo(cid);
        List<JoinCourseKey> joinCourseKeys = joinCourseMapper.selectByExample(example);//班课成员
//        获取班课成员id列表
        List<Long> uids=new ArrayList<>();
        for (JoinCourseKey joinCourseKey:joinCourseKeys){
            uids.add(joinCourseKey.getUid());
        }
        //查询成员具体信息
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUidIn(uids);
        List<User> users = userMapper.selectByExample(userExample);
        for (User user:users){
            //遍历成员信息
            UserDTO userDTO=new UserDTO();
            BeanUtils.copyProperties(user,userDTO);
            userDTO.setUserName(user.getUsername());
            list.add(userDTO);
        }
        Comparator<UserDTO>byUserNumber=Comparator.comparing(UserDTO::getUserNumber);
        list.sort(byUserNumber);
        memberDTO.setUsers(list);
        //查询当前用户信息
        User user = userMapper.selectByPrimaryKey(uid);
        UserDTO userDTO=new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        userDTO.setUserName(user.getUsername());
        memberDTO.setUser(userDTO);
        //查询用户总成绩
        int score=0;
        //查询签到成绩
        //查询班课发起的签到
        SignInExample signInExample = new SignInExample();
        signInExample.createCriteria().andCidEqualTo(cid);
        List<SignIn> signIns = signInMapper.selectByExample(signInExample);
        int totalSignIn=signIns.size();
        memberDTO.setTotalSignIn(totalSignIn);
        //获取签到id列表
        List<Long> signIds=new ArrayList<>();
        for (SignIn signIn:signIns){
            signIds.add(signIn.getSignId());
        }
        int completeSignInNum=0;
        if (signIds.size()>0){//存在签到
            //查询该用户参与的签到
            CompleteSignInExample completeSignInExample = new CompleteSignInExample();
            completeSignInExample.createCriteria().andUidEqualTo(uid).andSignIdIn(signIds);
            List<CompleteSignIn> completeSignIns = completeSignInMapper.selectByExample(completeSignInExample);
            completeSignInNum=completeSignIns.size();
            memberDTO.setCompleteSignIn(completeSignInNum);
            //获取该用户参与的签到id
            List<Long> completeSignInIds=new ArrayList<>();
            for (CompleteSignIn completeSignIn:completeSignIns){
                completeSignInIds.add(completeSignIn.getSignId());
            }
            //查询该用户参与的签到
            SignInExample signInExample1 = new SignInExample();
            signInExample1.createCriteria().andSignIdIn(completeSignInIds);
            List<SignIn> signIns1 = signInMapper.selectByExample(signInExample1);//该用户参与的签到
            //获取签到成绩
            for (SignIn signIn:signIns1){
                score+=signIn.getScore();
            }
        }else {
            memberDTO.setCompleteSignIn(0);
            memberDTO.setTotalSignIn(0);
        }
        //查询活动成绩
        //查询该班课发起的活动
        //查询该班课发起的描述题
        ActivityExample activityExample = new ActivityExample();
        activityExample.createCriteria().andCidEqualTo(cid);
        List<Activity> activities = activityMapper.selectByExample(activityExample);
        int totalActivity=activities.size();
        memberDTO.setTotalActivity(totalActivity);
        //获取描述题id列表
        List<Long> desIds=new ArrayList<>();
        for (Activity activity:activities){
            if (activity.getDesId()!=null){
                desIds.add(activity.getDesId());
            }
        }
        if (desIds.size()>0){//有描述题
            //获取该用户参与的描述题
            //查找该用户提交的文件
            SubmitFileExample submitFileExample = new SubmitFileExample();
            submitFileExample.createCriteria().andUidEqualTo(uid);
            List<SubmitFile> submitFiles = submitFileMapper.selectByExample(submitFileExample);
            //获取文件id集合
            List<Long> fileIds=new ArrayList<>();
            for (SubmitFile submitFile:submitFiles){
                fileIds.add(submitFile.getFileId());
            }
            if (fileIds.size()>0){//该用户提交过文件
                for (Long desId:desIds){
                    //查询当前描述题提交的文件
                    FileScoreExample fileScoreExample = new FileScoreExample();
                    fileScoreExample.createCriteria().andDesIdEqualTo(desId);
                    List<FileScore> fileScores = fileScoreMapper.selectByExample(fileScoreExample);
                    for (FileScore fileScore:fileScores){
                        for (Long fileId:fileIds){
                            if (fileId.equals(fileScore.getFileId())){
                                score+=fileScore.getScore();//该题目评分
                                //获取题目提交得分
                                Description description = descriptionMapper.selectByPrimaryKey(fileScore.getDesId());
                                score+=description.getScore();
                            }
                        }
                    }
                }
            }
        }
        //选择题
        //获取活动活动id列表
        List<Long> activityIds=new ArrayList<>();
        for (Activity activity:activities){
            if (activity.getActType()==1){
                activityIds.add(activity.getActId());
            }
        }
        //查询活动中包含的选择题
        if (activityIds.size()>0){
            //查询活动中包含的选择题
            for (Long activityId:activityIds){
                SelectActivityExample selectActivityExample = new SelectActivityExample();
                selectActivityExample.createCriteria().andActIdEqualTo(activityId);
                List<SelectActivity> selectActivities = selectActivityMapper.selectByExample(selectActivityExample);
                for (SelectActivity selectActivity:selectActivities){
                    //查询该用户是否作答过该题目
                    UserAnswersKey key = new UserAnswersKey();
                    key.setUid(uid);
                    key.setSelId(selectActivity.getSelId());
                    UserAnswers userAnswers = userAnswersMapper.selectByPrimaryKey(key);
                    if (userAnswers!=null){
                        //回答过,查询题目正确选项及分数
                        Selection selection = selectionMapper.selectByPrimaryKey(selectActivity.getSelId());
                        if (selection.getCorrectOption().equals(userAnswers.getUserSelect())){
                            score+=selection.getScore();
                        }
                    }
                }
            }
        }
        memberDTO.setScore(score);
        //查询用户参与的活动
        PartiActivityExample partiActivityExample = new PartiActivityExample();
        partiActivityExample.createCriteria().andUidEqualTo(uid).andActIdIn(activityIds);
        long completeActivity = partiActivityMapper.countByExample(partiActivityExample);
        memberDTO.setCompleteActivity((int) completeActivity);
        //查询班课中的资源
        CourseResourcesExample courseResourcesExample = new CourseResourcesExample();
        courseResourcesExample.createCriteria().andCidEqualTo(cid);
        List<CourseResourcesKey> courseResourcesKeys = courseResourcesMapper.selectByExample(courseResourcesExample);
        int totalResources=courseResourcesKeys.size();
        memberDTO.setTotalResources(totalResources);
        //查找用户下载过的资源
        DownloadResourcesExample downloadResourcesExample = new DownloadResourcesExample();
        downloadResourcesExample.createCriteria().andUidEqualTo(uid);
        List<DownloadResources> downloadResources = downloadResourcesMapper.selectByExample(downloadResourcesExample);
        int downloadResourcesNum=0;
        for (DownloadResources downloadResources1:downloadResources){
            for (CourseResourcesKey courseResourcesKey:courseResourcesKeys){
                if (downloadResources1.getResourceId().equals(courseResourcesKey.getResourceId())){
                    downloadResourcesNum++;
                }
            }
        }
        memberDTO.setDownloadResources(downloadResourcesNum);
        //进度设置
        if (totalSignIn!=0){
            double signInProgress=(double) completeSignInNum/totalSignIn;
            BigDecimal bigDecimal=new BigDecimal(signInProgress);
            signInProgress=bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            memberDTO.setSignInProgress((int) (signInProgress*100));
        }else {
            memberDTO.setSignInProgress(100);
        }
        if (totalActivity!=0){
            double activityProgress=(double) completeActivity/totalActivity;
            BigDecimal bigDecimal1=new BigDecimal(activityProgress);
            activityProgress=bigDecimal1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            memberDTO.setActivityProgress((int) (activityProgress*100));
        }else {
            memberDTO.setActivityProgress(100);
        }
        if (totalResources!=0){
            double resourceProgress=(double) downloadResourcesNum/totalResources;
            BigDecimal bigDecimal2=new BigDecimal(resourceProgress);
            resourceProgress=bigDecimal2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            memberDTO.setResourceProgress((int) (resourceProgress*100));
        }else {
            memberDTO.setResourceProgress(100);
        }
        return memberDTO;
    }
}
