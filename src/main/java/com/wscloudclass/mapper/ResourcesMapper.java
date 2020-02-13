package com.wscloudclass.mapper;

import com.wscloudclass.model.Resources;
import com.wscloudclass.model.ResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourcesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    long countByExample(ResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int deleteByExample(ResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int deleteByPrimaryKey(Long resourceId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int insert(Resources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int insertSelective(Resources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    List<Resources> selectByExample(ResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    Resources selectByPrimaryKey(Long resourceId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByExampleSelective(@Param("record") Resources record, @Param("example") ResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByExample(@Param("record") Resources record, @Param("example") ResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByPrimaryKeySelective(Resources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByPrimaryKey(Resources record);
}