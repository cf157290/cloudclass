package com.wscloudclass.model;

public class UserAnswers extends UserAnswersKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_answers.user_select
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    private String userSelect;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_answers.user_select
     *
     * @return the value of user_answers.user_select
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public String getUserSelect() {
        return userSelect;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_answers.user_select
     *
     * @param userSelect the value for user_answers.user_select
     *
     * @mbg.generated Tue Feb 11 11:31:18 CST 2020
     */
    public void setUserSelect(String userSelect) {
        this.userSelect = userSelect == null ? null : userSelect.trim();
    }
}