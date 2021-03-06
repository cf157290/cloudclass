package com.wscloudclass.mapper;

import com.wscloudclass.model.FileScore;
import com.wscloudclass.model.FileScoreExample;
import com.wscloudclass.model.FileScoreKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileScoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_score
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    long countByExample(FileScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_score
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int deleteByExample(FileScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_score
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int deleteByPrimaryKey(FileScoreKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_score
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int insert(FileScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_score
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int insertSelective(FileScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_score
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    List<FileScore> selectByExample(FileScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_score
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    FileScore selectByPrimaryKey(FileScoreKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_score
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByExampleSelective(@Param("record") FileScore record, @Param("example") FileScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_score
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByExample(@Param("record") FileScore record, @Param("example") FileScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_score
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByPrimaryKeySelective(FileScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_score
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByPrimaryKey(FileScore record);
}