package com.wscloudclass.model;

import java.util.Date;

public class DownloadResources extends DownloadResourcesKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column download_resources.download_date
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    private Date downloadDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column download_resources.download_date
     *
     * @return the value of download_resources.download_date
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    public Date getDownloadDate() {
        return downloadDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column download_resources.download_date
     *
     * @param downloadDate the value for download_resources.download_date
     *
     * @mbg.generated Tue Feb 04 14:42:21 CST 2020
     */
    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }
}