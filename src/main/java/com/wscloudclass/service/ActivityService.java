package com.wscloudclass.service;

import com.wscloudclass.dto.ActivityDTO;
import com.wscloudclass.mapper.ActivityMapper;
import com.wscloudclass.mapper.PartiActivityMapper;
import com.wscloudclass.mapper.SelectActivityMapper;
import com.wscloudclass.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    PartiActivityMapper partiActivityMapper;
    @Autowired
    SelectActivityMapper selectActivityMapper;
    public List<ActivityDTO> getActivity(Long cid) {
        List<ActivityDTO> list=new ArrayList<>();
        ActivityExample example = new ActivityExample();
        example.createCriteria().andCidEqualTo(cid);
        List<Activity> activities = activityMapper.selectByExample(example);
        for (Activity activity:activities){
            ActivityDTO activityDTO=new ActivityDTO();
            BeanUtils.copyProperties(activity,activityDTO);
            PartiActivityExample partiActivityExample = new PartiActivityExample();
            partiActivityExample.createCriteria().andActIdEqualTo(activity.getActId());
            long count = partiActivityMapper.countByExample(partiActivityExample);//查询参与人数
            if (activity.getActType()==1){
                //选择题活动
                SelectActivityExample selectActivityExample = new SelectActivityExample();
                selectActivityExample.createCriteria().andActIdEqualTo(activity.getActId());
                long selectcount = selectActivityMapper.countByExample(selectActivityExample);//查询题目总数
                activityDTO.setTotalItem(selectcount);
            }else {
                //描述题活动
                activityDTO.setTotalItem((long) 1);
            }
            activityDTO.setSumPati(count);
            Date date=new Date();
            if (date.before(activity.getEndTime())){
                activityDTO.setStatus(1);//活动进行中
            }else {
                activityDTO.setStatus(0);
            }
            list.add(activityDTO);
        }
        return list;
    }

    public boolean isParti(Long actId, Long uid) {
        PartiActivityExample example = new PartiActivityExample();
        example.createCriteria().andActIdEqualTo(actId).andUidEqualTo(uid);
        long count = partiActivityMapper.countByExample(example);
        if (count==0){
            return false;//未参与过该活动
        }
        return true;
    }
}
