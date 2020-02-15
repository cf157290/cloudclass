package com.wscloudclass.service;

import com.wscloudclass.component.AliyunOSSUtils;
import com.wscloudclass.dto.ResourceDTO;
import com.wscloudclass.mapper.CourseResourcesMapper;
import com.wscloudclass.mapper.ResourcesMapper;
import com.wscloudclass.model.CourseResourcesExample;
import com.wscloudclass.model.CourseResourcesKey;
import com.wscloudclass.model.Resources;
import com.wscloudclass.model.ResourcesExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ResourceService {
    @Autowired
    ResourcesMapper resourcesMapper;
    @Autowired
    AliyunOSSUtils aliyunOSSUtils;
    @Autowired
    CourseResourcesMapper courseResourcesMapper;
    @Transactional
    public boolean uploadResource(String fileName, MultipartFile file, Long cid) throws IOException {
        Resources record = new Resources();
        boolean flag=true;
        Long resourceId=null;
        while (flag){
            resourceId= Long.valueOf(getRandomString(15));
            ResourcesExample example = new ResourcesExample();
            example.createCriteria().andResourceIdEqualTo(resourceId);
            long count = resourcesMapper.countByExample(example);
            if (count==0){
                record.setResourceId(resourceId);
                flag=false;
            }
        }
        if (fileName==null){
            record.setResourceName(file.getOriginalFilename());
        }else {
            record.setResourceName(fileName);
        }
        record.setResourceUrl(aliyunOSSUtils.uploadFile(file));
        record.setResourceSize((int) file.getSize());
        record.setUploadTime(new Date());
        resourcesMapper.insertSelective(record);
        //资源关联班课
        CourseResourcesKey courseResourcesKey = new CourseResourcesKey();
        courseResourcesKey.setCid(cid);
        courseResourcesKey.setResourceId(resourceId);
        int insert = courseResourcesMapper.insert(courseResourcesKey);
        if (insert==1){
            return true;
        }
        return false;
    }
    public List<ResourceDTO> getResources(Long cid) {
        List<ResourceDTO> list=new ArrayList<>();
        CourseResourcesExample example = new CourseResourcesExample();
        example.createCriteria().andCidEqualTo(cid);
        List<CourseResourcesKey> courseResourcesKeys = courseResourcesMapper.selectByExample(example);//班课资源
        List<Long> resourceIds=new ArrayList<>();
        for (CourseResourcesKey courseResourcesKey:courseResourcesKeys){
            resourceIds.add(courseResourcesKey.getResourceId());
        }
        if (resourceIds.size()>0){
            ResourcesExample resourcesExample = new ResourcesExample();
            resourcesExample.createCriteria().andResourceIdIn(resourceIds);
            List<Resources> resources = resourcesMapper.selectByExample(resourcesExample);
            for (Resources resources1:resources){
                ResourceDTO resourceDTO=new ResourceDTO();
                BeanUtils.copyProperties(resources1,resourceDTO);
                list.add(resourceDTO);
            }
        }
        return list;
    }
    //随机生成id
    private String getRandomString(int length){

        String str="0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(10);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
