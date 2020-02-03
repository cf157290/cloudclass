package com.wscloudclass.mapper;

import com.wscloudclass.model.SubmitFile;
import com.wscloudclass.model.SubmitFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubmitFileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table submit_file
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    long countByExample(SubmitFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table submit_file
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int deleteByExample(SubmitFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table submit_file
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int deleteByPrimaryKey(Long fileId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table submit_file
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int insert(SubmitFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table submit_file
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int insertSelective(SubmitFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table submit_file
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    List<SubmitFile> selectByExample(SubmitFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table submit_file
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    SubmitFile selectByPrimaryKey(Long fileId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table submit_file
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int updateByExampleSelective(@Param("record") SubmitFile record, @Param("example") SubmitFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table submit_file
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int updateByExample(@Param("record") SubmitFile record, @Param("example") SubmitFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table submit_file
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int updateByPrimaryKeySelective(SubmitFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table submit_file
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int updateByPrimaryKey(SubmitFile record);
}