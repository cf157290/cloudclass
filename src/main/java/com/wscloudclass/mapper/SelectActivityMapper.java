package com.wscloudclass.mapper;

import com.wscloudclass.model.SelectActivityExample;
import com.wscloudclass.model.SelectActivityKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SelectActivityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_activity
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    long countByExample(SelectActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_activity
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    int deleteByExample(SelectActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_activity
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    int deleteByPrimaryKey(SelectActivityKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_activity
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    int insert(SelectActivityKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_activity
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    int insertSelective(SelectActivityKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_activity
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    List<SelectActivityKey> selectByExample(SelectActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_activity
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    int updateByExampleSelective(@Param("record") SelectActivityKey record, @Param("example") SelectActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_activity
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    int updateByExample(@Param("record") SelectActivityKey record, @Param("example") SelectActivityExample example);
}