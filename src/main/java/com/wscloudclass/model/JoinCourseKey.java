package com.wscloudclass.model;

public class JoinCourseKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column join_course.uid
     *
     * @mbg.generated Sun Feb 09 14:40:33 CST 2020
     */
    private Long uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column join_course.cid
     *
     * @mbg.generated Sun Feb 09 14:40:33 CST 2020
     */
    private Long cid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column join_course.uid
     *
     * @return the value of join_course.uid
     *
     * @mbg.generated Sun Feb 09 14:40:33 CST 2020
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column join_course.uid
     *
     * @param uid the value for join_course.uid
     *
     * @mbg.generated Sun Feb 09 14:40:33 CST 2020
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column join_course.cid
     *
     * @return the value of join_course.cid
     *
     * @mbg.generated Sun Feb 09 14:40:33 CST 2020
     */
    public Long getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column join_course.cid
     *
     * @param cid the value for join_course.cid
     *
     * @mbg.generated Sun Feb 09 14:40:33 CST 2020
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }
}