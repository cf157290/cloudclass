package com.wscloudclass.model;

import java.util.Date;

public class Course {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.cid
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private Long cid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.invit_code
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private String invitCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.course_url
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private String courseUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.course_name
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private String courseName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.class_name
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private String className;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.college_dapartments
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private String collegeDapartments;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.school
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private String school;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.start_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private Date startTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.end_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private Date endTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.teacherid
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    private Long teacherid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.cid
     *
     * @return the value of course.cid
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public Long getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.cid
     *
     * @param cid the value for course.cid
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.invit_code
     *
     * @return the value of course.invit_code
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public String getInvitCode() {
        return invitCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.invit_code
     *
     * @param invitCode the value for course.invit_code
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setInvitCode(String invitCode) {
        this.invitCode = invitCode == null ? null : invitCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.course_url
     *
     * @return the value of course.course_url
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public String getCourseUrl() {
        return courseUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.course_url
     *
     * @param courseUrl the value for course.course_url
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setCourseUrl(String courseUrl) {
        this.courseUrl = courseUrl == null ? null : courseUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.course_name
     *
     * @return the value of course.course_name
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.course_name
     *
     * @param courseName the value for course.course_name
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.class_name
     *
     * @return the value of course.class_name
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public String getClassName() {
        return className;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.class_name
     *
     * @param className the value for course.class_name
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.college_dapartments
     *
     * @return the value of course.college_dapartments
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public String getCollegeDapartments() {
        return collegeDapartments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.college_dapartments
     *
     * @param collegeDapartments the value for course.college_dapartments
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setCollegeDapartments(String collegeDapartments) {
        this.collegeDapartments = collegeDapartments == null ? null : collegeDapartments.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.school
     *
     * @return the value of course.school
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public String getSchool() {
        return school;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.school
     *
     * @param school the value for course.school
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.start_time
     *
     * @return the value of course.start_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.start_time
     *
     * @param startTime the value for course.start_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.end_time
     *
     * @return the value of course.end_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.end_time
     *
     * @param endTime the value for course.end_time
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.teacherid
     *
     * @return the value of course.teacherid
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public Long getTeacherid() {
        return teacherid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.teacherid
     *
     * @param teacherid the value for course.teacherid
     *
     * @mbg.generated Sun Feb 02 17:00:28 CST 2020
     */
    public void setTeacherid(Long teacherid) {
        this.teacherid = teacherid;
    }
}