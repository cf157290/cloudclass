package com.wscloudclass.mapper;

import com.wscloudclass.model.Description;
import com.wscloudclass.model.DescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DescriptionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table description
     *
     * @mbg.generated Sat Feb 01 19:12:34 CST 2020
     */
    long countByExample(DescriptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table description
     *
     * @mbg.generated Sat Feb 01 19:12:34 CST 2020
     */
    int deleteByExample(DescriptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table description
     *
     * @mbg.generated Sat Feb 01 19:12:34 CST 2020
     */
    int deleteByPrimaryKey(Long desId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table description
     *
     * @mbg.generated Sat Feb 01 19:12:34 CST 2020
     */
    int insert(Description record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table description
     *
     * @mbg.generated Sat Feb 01 19:12:34 CST 2020
     */
    int insertSelective(Description record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table description
     *
     * @mbg.generated Sat Feb 01 19:12:34 CST 2020
     */
    List<Description> selectByExampleWithRowbounds(DescriptionExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table description
     *
     * @mbg.generated Sat Feb 01 19:12:34 CST 2020
     */
    List<Description> selectByExample(DescriptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table description
     *
     * @mbg.generated Sat Feb 01 19:12:34 CST 2020
     */
    Description selectByPrimaryKey(Long desId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table description
     *
     * @mbg.generated Sat Feb 01 19:12:34 CST 2020
     */
    int updateByExampleSelective(@Param("record") Description record, @Param("example") DescriptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table description
     *
     * @mbg.generated Sat Feb 01 19:12:34 CST 2020
     */
    int updateByExample(@Param("record") Description record, @Param("example") DescriptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table description
     *
     * @mbg.generated Sat Feb 01 19:12:34 CST 2020
     */
    int updateByPrimaryKeySelective(Description record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table description
     *
     * @mbg.generated Sat Feb 01 19:12:34 CST 2020
     */
    int updateByPrimaryKey(Description record);
}