package com.wscloudclass.model;

import java.util.ArrayList;
import java.util.List;

public class SelectionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    public SelectionExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSelIdIsNull() {
            addCriterion("sel_id is null");
            return (Criteria) this;
        }

        public Criteria andSelIdIsNotNull() {
            addCriterion("sel_id is not null");
            return (Criteria) this;
        }

        public Criteria andSelIdEqualTo(Long value) {
            addCriterion("sel_id =", value, "selId");
            return (Criteria) this;
        }

        public Criteria andSelIdNotEqualTo(Long value) {
            addCriterion("sel_id <>", value, "selId");
            return (Criteria) this;
        }

        public Criteria andSelIdGreaterThan(Long value) {
            addCriterion("sel_id >", value, "selId");
            return (Criteria) this;
        }

        public Criteria andSelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sel_id >=", value, "selId");
            return (Criteria) this;
        }

        public Criteria andSelIdLessThan(Long value) {
            addCriterion("sel_id <", value, "selId");
            return (Criteria) this;
        }

        public Criteria andSelIdLessThanOrEqualTo(Long value) {
            addCriterion("sel_id <=", value, "selId");
            return (Criteria) this;
        }

        public Criteria andSelIdIn(List<Long> values) {
            addCriterion("sel_id in", values, "selId");
            return (Criteria) this;
        }

        public Criteria andSelIdNotIn(List<Long> values) {
            addCriterion("sel_id not in", values, "selId");
            return (Criteria) this;
        }

        public Criteria andSelIdBetween(Long value1, Long value2) {
            addCriterion("sel_id between", value1, value2, "selId");
            return (Criteria) this;
        }

        public Criteria andSelIdNotBetween(Long value1, Long value2) {
            addCriterion("sel_id not between", value1, value2, "selId");
            return (Criteria) this;
        }

        public Criteria andSelContentIsNull() {
            addCriterion("sel_content is null");
            return (Criteria) this;
        }

        public Criteria andSelContentIsNotNull() {
            addCriterion("sel_content is not null");
            return (Criteria) this;
        }

        public Criteria andSelContentEqualTo(String value) {
            addCriterion("sel_content =", value, "selContent");
            return (Criteria) this;
        }

        public Criteria andSelContentNotEqualTo(String value) {
            addCriterion("sel_content <>", value, "selContent");
            return (Criteria) this;
        }

        public Criteria andSelContentGreaterThan(String value) {
            addCriterion("sel_content >", value, "selContent");
            return (Criteria) this;
        }

        public Criteria andSelContentGreaterThanOrEqualTo(String value) {
            addCriterion("sel_content >=", value, "selContent");
            return (Criteria) this;
        }

        public Criteria andSelContentLessThan(String value) {
            addCriterion("sel_content <", value, "selContent");
            return (Criteria) this;
        }

        public Criteria andSelContentLessThanOrEqualTo(String value) {
            addCriterion("sel_content <=", value, "selContent");
            return (Criteria) this;
        }

        public Criteria andSelContentLike(String value) {
            addCriterion("sel_content like", value, "selContent");
            return (Criteria) this;
        }

        public Criteria andSelContentNotLike(String value) {
            addCriterion("sel_content not like", value, "selContent");
            return (Criteria) this;
        }

        public Criteria andSelContentIn(List<String> values) {
            addCriterion("sel_content in", values, "selContent");
            return (Criteria) this;
        }

        public Criteria andSelContentNotIn(List<String> values) {
            addCriterion("sel_content not in", values, "selContent");
            return (Criteria) this;
        }

        public Criteria andSelContentBetween(String value1, String value2) {
            addCriterion("sel_content between", value1, value2, "selContent");
            return (Criteria) this;
        }

        public Criteria andSelContentNotBetween(String value1, String value2) {
            addCriterion("sel_content not between", value1, value2, "selContent");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andAIsNull() {
            addCriterion("a is null");
            return (Criteria) this;
        }

        public Criteria andAIsNotNull() {
            addCriterion("a is not null");
            return (Criteria) this;
        }

        public Criteria andAEqualTo(String value) {
            addCriterion("a =", value, "a");
            return (Criteria) this;
        }

        public Criteria andANotEqualTo(String value) {
            addCriterion("a <>", value, "a");
            return (Criteria) this;
        }

        public Criteria andAGreaterThan(String value) {
            addCriterion("a >", value, "a");
            return (Criteria) this;
        }

        public Criteria andAGreaterThanOrEqualTo(String value) {
            addCriterion("a >=", value, "a");
            return (Criteria) this;
        }

        public Criteria andALessThan(String value) {
            addCriterion("a <", value, "a");
            return (Criteria) this;
        }

        public Criteria andALessThanOrEqualTo(String value) {
            addCriterion("a <=", value, "a");
            return (Criteria) this;
        }

        public Criteria andALike(String value) {
            addCriterion("a like", value, "a");
            return (Criteria) this;
        }

        public Criteria andANotLike(String value) {
            addCriterion("a not like", value, "a");
            return (Criteria) this;
        }

        public Criteria andAIn(List<String> values) {
            addCriterion("a in", values, "a");
            return (Criteria) this;
        }

        public Criteria andANotIn(List<String> values) {
            addCriterion("a not in", values, "a");
            return (Criteria) this;
        }

        public Criteria andABetween(String value1, String value2) {
            addCriterion("a between", value1, value2, "a");
            return (Criteria) this;
        }

        public Criteria andANotBetween(String value1, String value2) {
            addCriterion("a not between", value1, value2, "a");
            return (Criteria) this;
        }

        public Criteria andBIsNull() {
            addCriterion("b is null");
            return (Criteria) this;
        }

        public Criteria andBIsNotNull() {
            addCriterion("b is not null");
            return (Criteria) this;
        }

        public Criteria andBEqualTo(String value) {
            addCriterion("b =", value, "b");
            return (Criteria) this;
        }

        public Criteria andBNotEqualTo(String value) {
            addCriterion("b <>", value, "b");
            return (Criteria) this;
        }

        public Criteria andBGreaterThan(String value) {
            addCriterion("b >", value, "b");
            return (Criteria) this;
        }

        public Criteria andBGreaterThanOrEqualTo(String value) {
            addCriterion("b >=", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLessThan(String value) {
            addCriterion("b <", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLessThanOrEqualTo(String value) {
            addCriterion("b <=", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLike(String value) {
            addCriterion("b like", value, "b");
            return (Criteria) this;
        }

        public Criteria andBNotLike(String value) {
            addCriterion("b not like", value, "b");
            return (Criteria) this;
        }

        public Criteria andBIn(List<String> values) {
            addCriterion("b in", values, "b");
            return (Criteria) this;
        }

        public Criteria andBNotIn(List<String> values) {
            addCriterion("b not in", values, "b");
            return (Criteria) this;
        }

        public Criteria andBBetween(String value1, String value2) {
            addCriterion("b between", value1, value2, "b");
            return (Criteria) this;
        }

        public Criteria andBNotBetween(String value1, String value2) {
            addCriterion("b not between", value1, value2, "b");
            return (Criteria) this;
        }

        public Criteria andCIsNull() {
            addCriterion("c is null");
            return (Criteria) this;
        }

        public Criteria andCIsNotNull() {
            addCriterion("c is not null");
            return (Criteria) this;
        }

        public Criteria andCEqualTo(String value) {
            addCriterion("c =", value, "c");
            return (Criteria) this;
        }

        public Criteria andCNotEqualTo(String value) {
            addCriterion("c <>", value, "c");
            return (Criteria) this;
        }

        public Criteria andCGreaterThan(String value) {
            addCriterion("c >", value, "c");
            return (Criteria) this;
        }

        public Criteria andCGreaterThanOrEqualTo(String value) {
            addCriterion("c >=", value, "c");
            return (Criteria) this;
        }

        public Criteria andCLessThan(String value) {
            addCriterion("c <", value, "c");
            return (Criteria) this;
        }

        public Criteria andCLessThanOrEqualTo(String value) {
            addCriterion("c <=", value, "c");
            return (Criteria) this;
        }

        public Criteria andCLike(String value) {
            addCriterion("c like", value, "c");
            return (Criteria) this;
        }

        public Criteria andCNotLike(String value) {
            addCriterion("c not like", value, "c");
            return (Criteria) this;
        }

        public Criteria andCIn(List<String> values) {
            addCriterion("c in", values, "c");
            return (Criteria) this;
        }

        public Criteria andCNotIn(List<String> values) {
            addCriterion("c not in", values, "c");
            return (Criteria) this;
        }

        public Criteria andCBetween(String value1, String value2) {
            addCriterion("c between", value1, value2, "c");
            return (Criteria) this;
        }

        public Criteria andCNotBetween(String value1, String value2) {
            addCriterion("c not between", value1, value2, "c");
            return (Criteria) this;
        }

        public Criteria andDIsNull() {
            addCriterion("d is null");
            return (Criteria) this;
        }

        public Criteria andDIsNotNull() {
            addCriterion("d is not null");
            return (Criteria) this;
        }

        public Criteria andDEqualTo(String value) {
            addCriterion("d =", value, "d");
            return (Criteria) this;
        }

        public Criteria andDNotEqualTo(String value) {
            addCriterion("d <>", value, "d");
            return (Criteria) this;
        }

        public Criteria andDGreaterThan(String value) {
            addCriterion("d >", value, "d");
            return (Criteria) this;
        }

        public Criteria andDGreaterThanOrEqualTo(String value) {
            addCriterion("d >=", value, "d");
            return (Criteria) this;
        }

        public Criteria andDLessThan(String value) {
            addCriterion("d <", value, "d");
            return (Criteria) this;
        }

        public Criteria andDLessThanOrEqualTo(String value) {
            addCriterion("d <=", value, "d");
            return (Criteria) this;
        }

        public Criteria andDLike(String value) {
            addCriterion("d like", value, "d");
            return (Criteria) this;
        }

        public Criteria andDNotLike(String value) {
            addCriterion("d not like", value, "d");
            return (Criteria) this;
        }

        public Criteria andDIn(List<String> values) {
            addCriterion("d in", values, "d");
            return (Criteria) this;
        }

        public Criteria andDNotIn(List<String> values) {
            addCriterion("d not in", values, "d");
            return (Criteria) this;
        }

        public Criteria andDBetween(String value1, String value2) {
            addCriterion("d between", value1, value2, "d");
            return (Criteria) this;
        }

        public Criteria andDNotBetween(String value1, String value2) {
            addCriterion("d not between", value1, value2, "d");
            return (Criteria) this;
        }

        public Criteria andSelAnaIsNull() {
            addCriterion("sel_ana is null");
            return (Criteria) this;
        }

        public Criteria andSelAnaIsNotNull() {
            addCriterion("sel_ana is not null");
            return (Criteria) this;
        }

        public Criteria andSelAnaEqualTo(String value) {
            addCriterion("sel_ana =", value, "selAna");
            return (Criteria) this;
        }

        public Criteria andSelAnaNotEqualTo(String value) {
            addCriterion("sel_ana <>", value, "selAna");
            return (Criteria) this;
        }

        public Criteria andSelAnaGreaterThan(String value) {
            addCriterion("sel_ana >", value, "selAna");
            return (Criteria) this;
        }

        public Criteria andSelAnaGreaterThanOrEqualTo(String value) {
            addCriterion("sel_ana >=", value, "selAna");
            return (Criteria) this;
        }

        public Criteria andSelAnaLessThan(String value) {
            addCriterion("sel_ana <", value, "selAna");
            return (Criteria) this;
        }

        public Criteria andSelAnaLessThanOrEqualTo(String value) {
            addCriterion("sel_ana <=", value, "selAna");
            return (Criteria) this;
        }

        public Criteria andSelAnaLike(String value) {
            addCriterion("sel_ana like", value, "selAna");
            return (Criteria) this;
        }

        public Criteria andSelAnaNotLike(String value) {
            addCriterion("sel_ana not like", value, "selAna");
            return (Criteria) this;
        }

        public Criteria andSelAnaIn(List<String> values) {
            addCriterion("sel_ana in", values, "selAna");
            return (Criteria) this;
        }

        public Criteria andSelAnaNotIn(List<String> values) {
            addCriterion("sel_ana not in", values, "selAna");
            return (Criteria) this;
        }

        public Criteria andSelAnaBetween(String value1, String value2) {
            addCriterion("sel_ana between", value1, value2, "selAna");
            return (Criteria) this;
        }

        public Criteria andSelAnaNotBetween(String value1, String value2) {
            addCriterion("sel_ana not between", value1, value2, "selAna");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andCorrectOptionIsNull() {
            addCriterion("correct_option is null");
            return (Criteria) this;
        }

        public Criteria andCorrectOptionIsNotNull() {
            addCriterion("correct_option is not null");
            return (Criteria) this;
        }

        public Criteria andCorrectOptionEqualTo(String value) {
            addCriterion("correct_option =", value, "correctOption");
            return (Criteria) this;
        }

        public Criteria andCorrectOptionNotEqualTo(String value) {
            addCriterion("correct_option <>", value, "correctOption");
            return (Criteria) this;
        }

        public Criteria andCorrectOptionGreaterThan(String value) {
            addCriterion("correct_option >", value, "correctOption");
            return (Criteria) this;
        }

        public Criteria andCorrectOptionGreaterThanOrEqualTo(String value) {
            addCriterion("correct_option >=", value, "correctOption");
            return (Criteria) this;
        }

        public Criteria andCorrectOptionLessThan(String value) {
            addCriterion("correct_option <", value, "correctOption");
            return (Criteria) this;
        }

        public Criteria andCorrectOptionLessThanOrEqualTo(String value) {
            addCriterion("correct_option <=", value, "correctOption");
            return (Criteria) this;
        }

        public Criteria andCorrectOptionLike(String value) {
            addCriterion("correct_option like", value, "correctOption");
            return (Criteria) this;
        }

        public Criteria andCorrectOptionNotLike(String value) {
            addCriterion("correct_option not like", value, "correctOption");
            return (Criteria) this;
        }

        public Criteria andCorrectOptionIn(List<String> values) {
            addCriterion("correct_option in", values, "correctOption");
            return (Criteria) this;
        }

        public Criteria andCorrectOptionNotIn(List<String> values) {
            addCriterion("correct_option not in", values, "correctOption");
            return (Criteria) this;
        }

        public Criteria andCorrectOptionBetween(String value1, String value2) {
            addCriterion("correct_option between", value1, value2, "correctOption");
            return (Criteria) this;
        }

        public Criteria andCorrectOptionNotBetween(String value1, String value2) {
            addCriterion("correct_option not between", value1, value2, "correctOption");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table selection
     *
     * @mbg.generated do_not_delete_during_merge Wed Feb 12 19:25:47 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table selection
     *
     * @mbg.generated Wed Feb 12 19:25:47 CST 2020
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}