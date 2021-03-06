package com.wscloudclass.mapper;

import com.wscloudclass.model.Selection;
import com.wscloudclass.model.SelectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SelectionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    long countByExample(SelectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int deleteByExample(SelectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int deleteByPrimaryKey(Long selId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int insert(Selection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int insertSelective(Selection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    List<Selection> selectByExample(SelectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    Selection selectByPrimaryKey(Long selId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByExampleSelective(@Param("record") Selection record, @Param("example") SelectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByExample(@Param("record") Selection record, @Param("example") SelectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByPrimaryKeySelective(Selection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByPrimaryKey(Selection record);
}