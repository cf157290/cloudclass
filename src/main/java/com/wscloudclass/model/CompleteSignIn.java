package com.wscloudclass.model;

import java.util.Date;

public class CompleteSignIn extends CompleteSignInKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column complete_sign_in.sign_date
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    private Date signDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column complete_sign_in.sign_date
     *
     * @return the value of complete_sign_in.sign_date
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public Date getSignDate() {
        return signDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column complete_sign_in.sign_date
     *
     * @param signDate the value for complete_sign_in.sign_date
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }
}