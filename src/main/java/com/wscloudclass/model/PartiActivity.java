package com.wscloudclass.model;

import java.util.Date;

public class PartiActivity extends PartiActivityKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column parti_activity.parti_time
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    private Date partiTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column parti_activity.parti_time
     *
     * @return the value of parti_activity.parti_time
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    public Date getPartiTime() {
        return partiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column parti_activity.parti_time
     *
     * @param partiTime the value for parti_activity.parti_time
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    public void setPartiTime(Date partiTime) {
        this.partiTime = partiTime;
    }
}