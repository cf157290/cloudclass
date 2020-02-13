package com.wscloudclass.mapper;

import com.wscloudclass.model.SignIn;
import com.wscloudclass.model.SignInExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SignInMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    long countByExample(SignInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int deleteByExample(SignInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int deleteByPrimaryKey(Long signId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int insert(SignIn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int insertSelective(SignIn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    List<SignIn> selectByExample(SignInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    SignIn selectByPrimaryKey(Long signId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByExampleSelective(@Param("record") SignIn record, @Param("example") SignInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByExample(@Param("record") SignIn record, @Param("example") SignInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByPrimaryKeySelective(SignIn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sign_in
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    int updateByPrimaryKey(SignIn record);
}