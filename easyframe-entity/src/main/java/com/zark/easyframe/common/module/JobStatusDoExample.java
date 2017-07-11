package com.zark.easyframe.common.module;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobStatusDoExample {
    /**
     * zk_job_status
     */
    protected String orderByClause;

    /**
     * zk_job_status
     */
    protected boolean distinct;

    /**
     * zk_job_status
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated 2017-07-08
     */
    public JobStatusDoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated 2017-07-08
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated 2017-07-08
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated 2017-07-08
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated 2017-07-08
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated 2017-07-08
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated 2017-07-08
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated 2017-07-08
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated 2017-07-08
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbggenerated 2017-07-08
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated 2017-07-08
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * zk_job_status 2017-07-08
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(String value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(String value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(String value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(String value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(String value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLike(String value) {
            addCriterion("is_deleted like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotLike(String value) {
            addCriterion("is_deleted not like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<String> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<String> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(String value1, String value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(String value1, String value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("modifier is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("modifier is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("modifier =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("modifier <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("modifier >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("modifier >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("modifier <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("modifier <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("modifier like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("modifier not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("modifier in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("modifier not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("modifier between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("modifier not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCurrentStageIsNull() {
            addCriterion("current_stage is null");
            return (Criteria) this;
        }

        public Criteria andCurrentStageIsNotNull() {
            addCriterion("current_stage is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentStageEqualTo(String value) {
            addCriterion("current_stage =", value, "currentStage");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNotEqualTo(String value) {
            addCriterion("current_stage <>", value, "currentStage");
            return (Criteria) this;
        }

        public Criteria andCurrentStageGreaterThan(String value) {
            addCriterion("current_stage >", value, "currentStage");
            return (Criteria) this;
        }

        public Criteria andCurrentStageGreaterThanOrEqualTo(String value) {
            addCriterion("current_stage >=", value, "currentStage");
            return (Criteria) this;
        }

        public Criteria andCurrentStageLessThan(String value) {
            addCriterion("current_stage <", value, "currentStage");
            return (Criteria) this;
        }

        public Criteria andCurrentStageLessThanOrEqualTo(String value) {
            addCriterion("current_stage <=", value, "currentStage");
            return (Criteria) this;
        }

        public Criteria andCurrentStageLike(String value) {
            addCriterion("current_stage like", value, "currentStage");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNotLike(String value) {
            addCriterion("current_stage not like", value, "currentStage");
            return (Criteria) this;
        }

        public Criteria andCurrentStageIn(List<String> values) {
            addCriterion("current_stage in", values, "currentStage");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNotIn(List<String> values) {
            addCriterion("current_stage not in", values, "currentStage");
            return (Criteria) this;
        }

        public Criteria andCurrentStageBetween(String value1, String value2) {
            addCriterion("current_stage between", value1, value2, "currentStage");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNotBetween(String value1, String value2) {
            addCriterion("current_stage not between", value1, value2, "currentStage");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNumIsNull() {
            addCriterion("current_stage_num is null");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNumIsNotNull() {
            addCriterion("current_stage_num is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNumEqualTo(Integer value) {
            addCriterion("current_stage_num =", value, "currentStageNum");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNumNotEqualTo(Integer value) {
            addCriterion("current_stage_num <>", value, "currentStageNum");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNumGreaterThan(Integer value) {
            addCriterion("current_stage_num >", value, "currentStageNum");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_stage_num >=", value, "currentStageNum");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNumLessThan(Integer value) {
            addCriterion("current_stage_num <", value, "currentStageNum");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNumLessThanOrEqualTo(Integer value) {
            addCriterion("current_stage_num <=", value, "currentStageNum");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNumIn(List<Integer> values) {
            addCriterion("current_stage_num in", values, "currentStageNum");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNumNotIn(List<Integer> values) {
            addCriterion("current_stage_num not in", values, "currentStageNum");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNumBetween(Integer value1, Integer value2) {
            addCriterion("current_stage_num between", value1, value2, "currentStageNum");
            return (Criteria) this;
        }

        public Criteria andCurrentStageNumNotBetween(Integer value1, Integer value2) {
            addCriterion("current_stage_num not between", value1, value2, "currentStageNum");
            return (Criteria) this;
        }

        public Criteria andTotalStageNumIsNull() {
            addCriterion("total_stage_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalStageNumIsNotNull() {
            addCriterion("total_stage_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalStageNumEqualTo(Integer value) {
            addCriterion("total_stage_num =", value, "totalStageNum");
            return (Criteria) this;
        }

        public Criteria andTotalStageNumNotEqualTo(Integer value) {
            addCriterion("total_stage_num <>", value, "totalStageNum");
            return (Criteria) this;
        }

        public Criteria andTotalStageNumGreaterThan(Integer value) {
            addCriterion("total_stage_num >", value, "totalStageNum");
            return (Criteria) this;
        }

        public Criteria andTotalStageNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_stage_num >=", value, "totalStageNum");
            return (Criteria) this;
        }

        public Criteria andTotalStageNumLessThan(Integer value) {
            addCriterion("total_stage_num <", value, "totalStageNum");
            return (Criteria) this;
        }

        public Criteria andTotalStageNumLessThanOrEqualTo(Integer value) {
            addCriterion("total_stage_num <=", value, "totalStageNum");
            return (Criteria) this;
        }

        public Criteria andTotalStageNumIn(List<Integer> values) {
            addCriterion("total_stage_num in", values, "totalStageNum");
            return (Criteria) this;
        }

        public Criteria andTotalStageNumNotIn(List<Integer> values) {
            addCriterion("total_stage_num not in", values, "totalStageNum");
            return (Criteria) this;
        }

        public Criteria andTotalStageNumBetween(Integer value1, Integer value2) {
            addCriterion("total_stage_num between", value1, value2, "totalStageNum");
            return (Criteria) this;
        }

        public Criteria andTotalStageNumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_stage_num not between", value1, value2, "totalStageNum");
            return (Criteria) this;
        }

        public Criteria andCurrentDealedNumIsNull() {
            addCriterion("current_dealed_num is null");
            return (Criteria) this;
        }

        public Criteria andCurrentDealedNumIsNotNull() {
            addCriterion("current_dealed_num is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentDealedNumEqualTo(Integer value) {
            addCriterion("current_dealed_num =", value, "currentDealedNum");
            return (Criteria) this;
        }

        public Criteria andCurrentDealedNumNotEqualTo(Integer value) {
            addCriterion("current_dealed_num <>", value, "currentDealedNum");
            return (Criteria) this;
        }

        public Criteria andCurrentDealedNumGreaterThan(Integer value) {
            addCriterion("current_dealed_num >", value, "currentDealedNum");
            return (Criteria) this;
        }

        public Criteria andCurrentDealedNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_dealed_num >=", value, "currentDealedNum");
            return (Criteria) this;
        }

        public Criteria andCurrentDealedNumLessThan(Integer value) {
            addCriterion("current_dealed_num <", value, "currentDealedNum");
            return (Criteria) this;
        }

        public Criteria andCurrentDealedNumLessThanOrEqualTo(Integer value) {
            addCriterion("current_dealed_num <=", value, "currentDealedNum");
            return (Criteria) this;
        }

        public Criteria andCurrentDealedNumIn(List<Integer> values) {
            addCriterion("current_dealed_num in", values, "currentDealedNum");
            return (Criteria) this;
        }

        public Criteria andCurrentDealedNumNotIn(List<Integer> values) {
            addCriterion("current_dealed_num not in", values, "currentDealedNum");
            return (Criteria) this;
        }

        public Criteria andCurrentDealedNumBetween(Integer value1, Integer value2) {
            addCriterion("current_dealed_num between", value1, value2, "currentDealedNum");
            return (Criteria) this;
        }

        public Criteria andCurrentDealedNumNotBetween(Integer value1, Integer value2) {
            addCriterion("current_dealed_num not between", value1, value2, "currentDealedNum");
            return (Criteria) this;
        }

        public Criteria andCurrentTotalNumIsNull() {
            addCriterion("current_total_num is null");
            return (Criteria) this;
        }

        public Criteria andCurrentTotalNumIsNotNull() {
            addCriterion("current_total_num is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentTotalNumEqualTo(Integer value) {
            addCriterion("current_total_num =", value, "currentTotalNum");
            return (Criteria) this;
        }

        public Criteria andCurrentTotalNumNotEqualTo(Integer value) {
            addCriterion("current_total_num <>", value, "currentTotalNum");
            return (Criteria) this;
        }

        public Criteria andCurrentTotalNumGreaterThan(Integer value) {
            addCriterion("current_total_num >", value, "currentTotalNum");
            return (Criteria) this;
        }

        public Criteria andCurrentTotalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_total_num >=", value, "currentTotalNum");
            return (Criteria) this;
        }

        public Criteria andCurrentTotalNumLessThan(Integer value) {
            addCriterion("current_total_num <", value, "currentTotalNum");
            return (Criteria) this;
        }

        public Criteria andCurrentTotalNumLessThanOrEqualTo(Integer value) {
            addCriterion("current_total_num <=", value, "currentTotalNum");
            return (Criteria) this;
        }

        public Criteria andCurrentTotalNumIn(List<Integer> values) {
            addCriterion("current_total_num in", values, "currentTotalNum");
            return (Criteria) this;
        }

        public Criteria andCurrentTotalNumNotIn(List<Integer> values) {
            addCriterion("current_total_num not in", values, "currentTotalNum");
            return (Criteria) this;
        }

        public Criteria andCurrentTotalNumBetween(Integer value1, Integer value2) {
            addCriterion("current_total_num between", value1, value2, "currentTotalNum");
            return (Criteria) this;
        }

        public Criteria andCurrentTotalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("current_total_num not between", value1, value2, "currentTotalNum");
            return (Criteria) this;
        }

        public Criteria andHasErrorIsNull() {
            addCriterion("has_error is null");
            return (Criteria) this;
        }

        public Criteria andHasErrorIsNotNull() {
            addCriterion("has_error is not null");
            return (Criteria) this;
        }

        public Criteria andHasErrorEqualTo(String value) {
            addCriterion("has_error =", value, "hasError");
            return (Criteria) this;
        }

        public Criteria andHasErrorNotEqualTo(String value) {
            addCriterion("has_error <>", value, "hasError");
            return (Criteria) this;
        }

        public Criteria andHasErrorGreaterThan(String value) {
            addCriterion("has_error >", value, "hasError");
            return (Criteria) this;
        }

        public Criteria andHasErrorGreaterThanOrEqualTo(String value) {
            addCriterion("has_error >=", value, "hasError");
            return (Criteria) this;
        }

        public Criteria andHasErrorLessThan(String value) {
            addCriterion("has_error <", value, "hasError");
            return (Criteria) this;
        }

        public Criteria andHasErrorLessThanOrEqualTo(String value) {
            addCriterion("has_error <=", value, "hasError");
            return (Criteria) this;
        }

        public Criteria andHasErrorLike(String value) {
            addCriterion("has_error like", value, "hasError");
            return (Criteria) this;
        }

        public Criteria andHasErrorNotLike(String value) {
            addCriterion("has_error not like", value, "hasError");
            return (Criteria) this;
        }

        public Criteria andHasErrorIn(List<String> values) {
            addCriterion("has_error in", values, "hasError");
            return (Criteria) this;
        }

        public Criteria andHasErrorNotIn(List<String> values) {
            addCriterion("has_error not in", values, "hasError");
            return (Criteria) this;
        }

        public Criteria andHasErrorBetween(String value1, String value2) {
            addCriterion("has_error between", value1, value2, "hasError");
            return (Criteria) this;
        }

        public Criteria andHasErrorNotBetween(String value1, String value2) {
            addCriterion("has_error not between", value1, value2, "hasError");
            return (Criteria) this;
        }

        public Criteria andReturnValueIsNull() {
            addCriterion("return_value is null");
            return (Criteria) this;
        }

        public Criteria andReturnValueIsNotNull() {
            addCriterion("return_value is not null");
            return (Criteria) this;
        }

        public Criteria andReturnValueEqualTo(String value) {
            addCriterion("return_value =", value, "returnValue");
            return (Criteria) this;
        }

        public Criteria andReturnValueNotEqualTo(String value) {
            addCriterion("return_value <>", value, "returnValue");
            return (Criteria) this;
        }

        public Criteria andReturnValueGreaterThan(String value) {
            addCriterion("return_value >", value, "returnValue");
            return (Criteria) this;
        }

        public Criteria andReturnValueGreaterThanOrEqualTo(String value) {
            addCriterion("return_value >=", value, "returnValue");
            return (Criteria) this;
        }

        public Criteria andReturnValueLessThan(String value) {
            addCriterion("return_value <", value, "returnValue");
            return (Criteria) this;
        }

        public Criteria andReturnValueLessThanOrEqualTo(String value) {
            addCriterion("return_value <=", value, "returnValue");
            return (Criteria) this;
        }

        public Criteria andReturnValueLike(String value) {
            addCriterion("return_value like", value, "returnValue");
            return (Criteria) this;
        }

        public Criteria andReturnValueNotLike(String value) {
            addCriterion("return_value not like", value, "returnValue");
            return (Criteria) this;
        }

        public Criteria andReturnValueIn(List<String> values) {
            addCriterion("return_value in", values, "returnValue");
            return (Criteria) this;
        }

        public Criteria andReturnValueNotIn(List<String> values) {
            addCriterion("return_value not in", values, "returnValue");
            return (Criteria) this;
        }

        public Criteria andReturnValueBetween(String value1, String value2) {
            addCriterion("return_value between", value1, value2, "returnValue");
            return (Criteria) this;
        }

        public Criteria andReturnValueNotBetween(String value1, String value2) {
            addCriterion("return_value not between", value1, value2, "returnValue");
            return (Criteria) this;
        }

        public Criteria andExceptionClassIsNull() {
            addCriterion("exception_class is null");
            return (Criteria) this;
        }

        public Criteria andExceptionClassIsNotNull() {
            addCriterion("exception_class is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionClassEqualTo(String value) {
            addCriterion("exception_class =", value, "exceptionClass");
            return (Criteria) this;
        }

        public Criteria andExceptionClassNotEqualTo(String value) {
            addCriterion("exception_class <>", value, "exceptionClass");
            return (Criteria) this;
        }

        public Criteria andExceptionClassGreaterThan(String value) {
            addCriterion("exception_class >", value, "exceptionClass");
            return (Criteria) this;
        }

        public Criteria andExceptionClassGreaterThanOrEqualTo(String value) {
            addCriterion("exception_class >=", value, "exceptionClass");
            return (Criteria) this;
        }

        public Criteria andExceptionClassLessThan(String value) {
            addCriterion("exception_class <", value, "exceptionClass");
            return (Criteria) this;
        }

        public Criteria andExceptionClassLessThanOrEqualTo(String value) {
            addCriterion("exception_class <=", value, "exceptionClass");
            return (Criteria) this;
        }

        public Criteria andExceptionClassLike(String value) {
            addCriterion("exception_class like", value, "exceptionClass");
            return (Criteria) this;
        }

        public Criteria andExceptionClassNotLike(String value) {
            addCriterion("exception_class not like", value, "exceptionClass");
            return (Criteria) this;
        }

        public Criteria andExceptionClassIn(List<String> values) {
            addCriterion("exception_class in", values, "exceptionClass");
            return (Criteria) this;
        }

        public Criteria andExceptionClassNotIn(List<String> values) {
            addCriterion("exception_class not in", values, "exceptionClass");
            return (Criteria) this;
        }

        public Criteria andExceptionClassBetween(String value1, String value2) {
            addCriterion("exception_class between", value1, value2, "exceptionClass");
            return (Criteria) this;
        }

        public Criteria andExceptionClassNotBetween(String value1, String value2) {
            addCriterion("exception_class not between", value1, value2, "exceptionClass");
            return (Criteria) this;
        }

        public Criteria andErrorMessageIsNull() {
            addCriterion("error_message is null");
            return (Criteria) this;
        }

        public Criteria andErrorMessageIsNotNull() {
            addCriterion("error_message is not null");
            return (Criteria) this;
        }

        public Criteria andErrorMessageEqualTo(String value) {
            addCriterion("error_message =", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotEqualTo(String value) {
            addCriterion("error_message <>", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageGreaterThan(String value) {
            addCriterion("error_message >", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageGreaterThanOrEqualTo(String value) {
            addCriterion("error_message >=", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLessThan(String value) {
            addCriterion("error_message <", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLessThanOrEqualTo(String value) {
            addCriterion("error_message <=", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLike(String value) {
            addCriterion("error_message like", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotLike(String value) {
            addCriterion("error_message not like", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageIn(List<String> values) {
            addCriterion("error_message in", values, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotIn(List<String> values) {
            addCriterion("error_message not in", values, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageBetween(String value1, String value2) {
            addCriterion("error_message between", value1, value2, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotBetween(String value1, String value2) {
            addCriterion("error_message not between", value1, value2, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andExceptionPropertiesIsNull() {
            addCriterion("exception_properties is null");
            return (Criteria) this;
        }

        public Criteria andExceptionPropertiesIsNotNull() {
            addCriterion("exception_properties is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionPropertiesEqualTo(String value) {
            addCriterion("exception_properties =", value, "exceptionProperties");
            return (Criteria) this;
        }

        public Criteria andExceptionPropertiesNotEqualTo(String value) {
            addCriterion("exception_properties <>", value, "exceptionProperties");
            return (Criteria) this;
        }

        public Criteria andExceptionPropertiesGreaterThan(String value) {
            addCriterion("exception_properties >", value, "exceptionProperties");
            return (Criteria) this;
        }

        public Criteria andExceptionPropertiesGreaterThanOrEqualTo(String value) {
            addCriterion("exception_properties >=", value, "exceptionProperties");
            return (Criteria) this;
        }

        public Criteria andExceptionPropertiesLessThan(String value) {
            addCriterion("exception_properties <", value, "exceptionProperties");
            return (Criteria) this;
        }

        public Criteria andExceptionPropertiesLessThanOrEqualTo(String value) {
            addCriterion("exception_properties <=", value, "exceptionProperties");
            return (Criteria) this;
        }

        public Criteria andExceptionPropertiesLike(String value) {
            addCriterion("exception_properties like", value, "exceptionProperties");
            return (Criteria) this;
        }

        public Criteria andExceptionPropertiesNotLike(String value) {
            addCriterion("exception_properties not like", value, "exceptionProperties");
            return (Criteria) this;
        }

        public Criteria andExceptionPropertiesIn(List<String> values) {
            addCriterion("exception_properties in", values, "exceptionProperties");
            return (Criteria) this;
        }

        public Criteria andExceptionPropertiesNotIn(List<String> values) {
            addCriterion("exception_properties not in", values, "exceptionProperties");
            return (Criteria) this;
        }

        public Criteria andExceptionPropertiesBetween(String value1, String value2) {
            addCriterion("exception_properties between", value1, value2, "exceptionProperties");
            return (Criteria) this;
        }

        public Criteria andExceptionPropertiesNotBetween(String value1, String value2) {
            addCriterion("exception_properties not between", value1, value2, "exceptionProperties");
            return (Criteria) this;
        }

        public Criteria andFinshDateIsNull() {
            addCriterion("finsh_date is null");
            return (Criteria) this;
        }

        public Criteria andFinshDateIsNotNull() {
            addCriterion("finsh_date is not null");
            return (Criteria) this;
        }

        public Criteria andFinshDateEqualTo(Date value) {
            addCriterion("finsh_date =", value, "finshDate");
            return (Criteria) this;
        }

        public Criteria andFinshDateNotEqualTo(Date value) {
            addCriterion("finsh_date <>", value, "finshDate");
            return (Criteria) this;
        }

        public Criteria andFinshDateGreaterThan(Date value) {
            addCriterion("finsh_date >", value, "finshDate");
            return (Criteria) this;
        }

        public Criteria andFinshDateGreaterThanOrEqualTo(Date value) {
            addCriterion("finsh_date >=", value, "finshDate");
            return (Criteria) this;
        }

        public Criteria andFinshDateLessThan(Date value) {
            addCriterion("finsh_date <", value, "finshDate");
            return (Criteria) this;
        }

        public Criteria andFinshDateLessThanOrEqualTo(Date value) {
            addCriterion("finsh_date <=", value, "finshDate");
            return (Criteria) this;
        }

        public Criteria andFinshDateIn(List<Date> values) {
            addCriterion("finsh_date in", values, "finshDate");
            return (Criteria) this;
        }

        public Criteria andFinshDateNotIn(List<Date> values) {
            addCriterion("finsh_date not in", values, "finshDate");
            return (Criteria) this;
        }

        public Criteria andFinshDateBetween(Date value1, Date value2) {
            addCriterion("finsh_date between", value1, value2, "finshDate");
            return (Criteria) this;
        }

        public Criteria andFinshDateNotBetween(Date value1, Date value2) {
            addCriterion("finsh_date not between", value1, value2, "finshDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andJobUuidIsNull() {
            addCriterion("job_uuid is null");
            return (Criteria) this;
        }

        public Criteria andJobUuidIsNotNull() {
            addCriterion("job_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andJobUuidEqualTo(String value) {
            addCriterion("job_uuid =", value, "jobUuid");
            return (Criteria) this;
        }

        public Criteria andJobUuidNotEqualTo(String value) {
            addCriterion("job_uuid <>", value, "jobUuid");
            return (Criteria) this;
        }

        public Criteria andJobUuidGreaterThan(String value) {
            addCriterion("job_uuid >", value, "jobUuid");
            return (Criteria) this;
        }

        public Criteria andJobUuidGreaterThanOrEqualTo(String value) {
            addCriterion("job_uuid >=", value, "jobUuid");
            return (Criteria) this;
        }

        public Criteria andJobUuidLessThan(String value) {
            addCriterion("job_uuid <", value, "jobUuid");
            return (Criteria) this;
        }

        public Criteria andJobUuidLessThanOrEqualTo(String value) {
            addCriterion("job_uuid <=", value, "jobUuid");
            return (Criteria) this;
        }

        public Criteria andJobUuidLike(String value) {
            addCriterion("job_uuid like", value, "jobUuid");
            return (Criteria) this;
        }

        public Criteria andJobUuidNotLike(String value) {
            addCriterion("job_uuid not like", value, "jobUuid");
            return (Criteria) this;
        }

        public Criteria andJobUuidIn(List<String> values) {
            addCriterion("job_uuid in", values, "jobUuid");
            return (Criteria) this;
        }

        public Criteria andJobUuidNotIn(List<String> values) {
            addCriterion("job_uuid not in", values, "jobUuid");
            return (Criteria) this;
        }

        public Criteria andJobUuidBetween(String value1, String value2) {
            addCriterion("job_uuid between", value1, value2, "jobUuid");
            return (Criteria) this;
        }

        public Criteria andJobUuidNotBetween(String value1, String value2) {
            addCriterion("job_uuid not between", value1, value2, "jobUuid");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeClassIsNull() {
            addCriterion("exception_code_class is null");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeClassIsNotNull() {
            addCriterion("exception_code_class is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeClassEqualTo(String value) {
            addCriterion("exception_code_class =", value, "exceptionCodeClass");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeClassNotEqualTo(String value) {
            addCriterion("exception_code_class <>", value, "exceptionCodeClass");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeClassGreaterThan(String value) {
            addCriterion("exception_code_class >", value, "exceptionCodeClass");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeClassGreaterThanOrEqualTo(String value) {
            addCriterion("exception_code_class >=", value, "exceptionCodeClass");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeClassLessThan(String value) {
            addCriterion("exception_code_class <", value, "exceptionCodeClass");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeClassLessThanOrEqualTo(String value) {
            addCriterion("exception_code_class <=", value, "exceptionCodeClass");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeClassLike(String value) {
            addCriterion("exception_code_class like", value, "exceptionCodeClass");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeClassNotLike(String value) {
            addCriterion("exception_code_class not like", value, "exceptionCodeClass");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeClassIn(List<String> values) {
            addCriterion("exception_code_class in", values, "exceptionCodeClass");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeClassNotIn(List<String> values) {
            addCriterion("exception_code_class not in", values, "exceptionCodeClass");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeClassBetween(String value1, String value2) {
            addCriterion("exception_code_class between", value1, value2, "exceptionCodeClass");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeClassNotBetween(String value1, String value2) {
            addCriterion("exception_code_class not between", value1, value2, "exceptionCodeClass");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeEnumNameIsNull() {
            addCriterion("exception_code_enum_name is null");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeEnumNameIsNotNull() {
            addCriterion("exception_code_enum_name is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeEnumNameEqualTo(String value) {
            addCriterion("exception_code_enum_name =", value, "exceptionCodeEnumName");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeEnumNameNotEqualTo(String value) {
            addCriterion("exception_code_enum_name <>", value, "exceptionCodeEnumName");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeEnumNameGreaterThan(String value) {
            addCriterion("exception_code_enum_name >", value, "exceptionCodeEnumName");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeEnumNameGreaterThanOrEqualTo(String value) {
            addCriterion("exception_code_enum_name >=", value, "exceptionCodeEnumName");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeEnumNameLessThan(String value) {
            addCriterion("exception_code_enum_name <", value, "exceptionCodeEnumName");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeEnumNameLessThanOrEqualTo(String value) {
            addCriterion("exception_code_enum_name <=", value, "exceptionCodeEnumName");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeEnumNameLike(String value) {
            addCriterion("exception_code_enum_name like", value, "exceptionCodeEnumName");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeEnumNameNotLike(String value) {
            addCriterion("exception_code_enum_name not like", value, "exceptionCodeEnumName");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeEnumNameIn(List<String> values) {
            addCriterion("exception_code_enum_name in", values, "exceptionCodeEnumName");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeEnumNameNotIn(List<String> values) {
            addCriterion("exception_code_enum_name not in", values, "exceptionCodeEnumName");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeEnumNameBetween(String value1, String value2) {
            addCriterion("exception_code_enum_name between", value1, value2, "exceptionCodeEnumName");
            return (Criteria) this;
        }

        public Criteria andExceptionCodeEnumNameNotBetween(String value1, String value2) {
            addCriterion("exception_code_enum_name not between", value1, value2, "exceptionCodeEnumName");
            return (Criteria) this;
        }
    }

    /**
     * zk_job_status
     *
     * @mbggenerated do_not_delete_during_merge 2017-07-08
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * zk_job_status 2017-07-08
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