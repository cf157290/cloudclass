package com.wscloudclass.model;

import java.util.Date;

public class CourseInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_info.info_id
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private Long infoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_info.info_title
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private String infoTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_info.release_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private Date releaseTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_info.info_content
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private String infoContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_info.cid
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private Long cid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_info.info_id
     *
     * @return the value of course_info.info_id
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public Long getInfoId() {
        return infoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_info.info_id
     *
     * @param infoId the value for course_info.info_id
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_info.info_title
     *
     * @return the value of course_info.info_title
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public String getInfoTitle() {
        return infoTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_info.info_title
     *
     * @param infoTitle the value for course_info.info_title
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle == null ? null : infoTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_info.release_time
     *
     * @return the value of course_info.release_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_info.release_time
     *
     * @param releaseTime the value for course_info.release_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_info.info_content
     *
     * @return the value of course_info.info_content
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public String getInfoContent() {
        return infoContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_info.info_content
     *
     * @param infoContent the value for course_info.info_content
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent == null ? null : infoContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_info.cid
     *
     * @return the value of course_info.cid
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public Long getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_info.cid
     *
     * @param cid the value for course_info.cid
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }
}