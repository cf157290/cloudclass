package com.wscloudclass.model;

import java.util.Date;

public class Resources {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resources.resource_id
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    private Long resourceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resources.resource_name
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    private String resourceName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resources.resource_url
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    private String resourceUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resources.upload_time
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    private Date uploadTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resources.resource_size
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    private Integer resourceSize;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resources.resource_id
     *
     * @return the value of resources.resource_id
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resources.resource_id
     *
     * @param resourceId the value for resources.resource_id
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resources.resource_name
     *
     * @return the value of resources.resource_name
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resources.resource_name
     *
     * @param resourceName the value for resources.resource_name
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resources.resource_url
     *
     * @return the value of resources.resource_url
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resources.resource_url
     *
     * @param resourceUrl the value for resources.resource_url
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resources.upload_time
     *
     * @return the value of resources.upload_time
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resources.upload_time
     *
     * @param uploadTime the value for resources.upload_time
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resources.resource_size
     *
     * @return the value of resources.resource_size
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    public Integer getResourceSize() {
        return resourceSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resources.resource_size
     *
     * @param resourceSize the value for resources.resource_size
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    public void setResourceSize(Integer resourceSize) {
        this.resourceSize = resourceSize;
    }
}