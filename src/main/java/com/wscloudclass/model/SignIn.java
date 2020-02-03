package com.wscloudclass.model;

import java.util.Date;

public class SignIn {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign_in.sign_id
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private Long signId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign_in.sign_code
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private String signCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign_in.start_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private Date startTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign_in.end_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private Date endTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign_in.score
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private Integer score;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign_in.cid
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private Long cid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign_in.sign_id
     *
     * @return the value of sign_in.sign_id
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public Long getSignId() {
        return signId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign_in.sign_id
     *
     * @param signId the value for sign_in.sign_id
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setSignId(Long signId) {
        this.signId = signId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign_in.sign_code
     *
     * @return the value of sign_in.sign_code
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public String getSignCode() {
        return signCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign_in.sign_code
     *
     * @param signCode the value for sign_in.sign_code
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setSignCode(String signCode) {
        this.signCode = signCode == null ? null : signCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign_in.start_time
     *
     * @return the value of sign_in.start_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign_in.start_time
     *
     * @param startTime the value for sign_in.start_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign_in.end_time
     *
     * @return the value of sign_in.end_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign_in.end_time
     *
     * @param endTime the value for sign_in.end_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign_in.score
     *
     * @return the value of sign_in.score
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign_in.score
     *
     * @param score the value for sign_in.score
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign_in.cid
     *
     * @return the value of sign_in.cid
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public Long getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign_in.cid
     *
     * @param cid the value for sign_in.cid
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }
}