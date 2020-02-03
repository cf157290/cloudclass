package com.wscloudclass.mapper;

import com.wscloudclass.model.UserAnswers;
import com.wscloudclass.model.UserAnswersExample;
import com.wscloudclass.model.UserAnswersKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAnswersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_answers
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    long countByExample(UserAnswersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_answers
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int deleteByExample(UserAnswersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_answers
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int deleteByPrimaryKey(UserAnswersKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_answers
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int insert(UserAnswers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_answers
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int insertSelective(UserAnswers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_answers
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    List<UserAnswers> selectByExample(UserAnswersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_answers
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    UserAnswers selectByPrimaryKey(UserAnswersKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_answers
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int updateByExampleSelective(@Param("record") UserAnswers record, @Param("example") UserAnswersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_answers
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int updateByExample(@Param("record") UserAnswers record, @Param("example") UserAnswersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_answers
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int updateByPrimaryKeySelective(UserAnswers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_answers
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    int updateByPrimaryKey(UserAnswers record);
}