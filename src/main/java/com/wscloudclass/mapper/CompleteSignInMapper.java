package com.wscloudclass.mapper;

import com.wscloudclass.model.CompleteSignIn;
import com.wscloudclass.model.CompleteSignInExample;
import com.wscloudclass.model.CompleteSignInKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompleteSignInMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complete_sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    long countByExample(CompleteSignInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complete_sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int deleteByExample(CompleteSignInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complete_sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int deleteByPrimaryKey(CompleteSignInKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complete_sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int insert(CompleteSignIn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complete_sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int insertSelective(CompleteSignIn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complete_sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    List<CompleteSignIn> selectByExample(CompleteSignInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complete_sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    CompleteSignIn selectByPrimaryKey(CompleteSignInKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complete_sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByExampleSelective(@Param("record") CompleteSignIn record, @Param("example") CompleteSignInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complete_sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByExample(@Param("record") CompleteSignIn record, @Param("example") CompleteSignInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complete_sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByPrimaryKeySelective(CompleteSignIn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complete_sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByPrimaryKey(CompleteSignIn record);
}