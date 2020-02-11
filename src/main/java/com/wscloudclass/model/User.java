package com.wscloudclass.model;

import java.util.Date;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.uid
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    private Long uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.username
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_number
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    private Long userNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.img_url
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    private String imgUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.birthday
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    private Date birthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.college_department
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    private String collegeDepartment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.school
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    private String school;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.create_time
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.uid
     *
     * @return the value of user.uid
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.uid
     *
     * @param uid the value for user.uid
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email
     *
     * @return the value of user.email
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email
     *
     * @param email the value for user.email
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.username
     *
     * @return the value of user.username
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.username
     *
     * @param username the value for user.username
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_number
     *
     * @return the value of user.user_number
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public Long getUserNumber() {
        return userNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_number
     *
     * @param userNumber the value for user.user_number
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.img_url
     *
     * @return the value of user.img_url
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.img_url
     *
     * @param imgUrl the value for user.img_url
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.birthday
     *
     * @return the value of user.birthday
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.birthday
     *
     * @param birthday the value for user.birthday
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.college_department
     *
     * @return the value of user.college_department
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public String getCollegeDepartment() {
        return collegeDepartment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.college_department
     *
     * @param collegeDepartment the value for user.college_department
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public void setCollegeDepartment(String collegeDepartment) {
        this.collegeDepartment = collegeDepartment == null ? null : collegeDepartment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.school
     *
     * @return the value of user.school
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public String getSchool() {
        return school;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.school
     *
     * @param school the value for user.school
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.create_time
     *
     * @return the value of user.create_time
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.create_time
     *
     * @param createTime the value for user.create_time
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}