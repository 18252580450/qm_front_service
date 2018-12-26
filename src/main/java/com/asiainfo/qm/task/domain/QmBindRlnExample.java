package com.asiainfo.qm.task.domain;

import java.util.ArrayList;
import java.util.List;

public class QmBindRlnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QmBindRlnExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andCheckedObjectIdIsNull() {
            addCriterion("CHECKED_OBJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andCheckedObjectIdIsNotNull() {
            addCriterion("CHECKED_OBJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCheckedObjectIdEqualTo(String value) {
            addCriterion("CHECKED_OBJECT_ID =", value, "checkedObjectId");
            return (Criteria) this;
        }

        public Criteria andCheckedObjectIdNotEqualTo(String value) {
            addCriterion("CHECKED_OBJECT_ID <>", value, "checkedObjectId");
            return (Criteria) this;
        }

        public Criteria andCheckedObjectIdGreaterThan(String value) {
            addCriterion("CHECKED_OBJECT_ID >", value, "checkedObjectId");
            return (Criteria) this;
        }

        public Criteria andCheckedObjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKED_OBJECT_ID >=", value, "checkedObjectId");
            return (Criteria) this;
        }

        public Criteria andCheckedObjectIdLessThan(String value) {
            addCriterion("CHECKED_OBJECT_ID <", value, "checkedObjectId");
            return (Criteria) this;
        }

        public Criteria andCheckedObjectIdLessThanOrEqualTo(String value) {
            addCriterion("CHECKED_OBJECT_ID <=", value, "checkedObjectId");
            return (Criteria) this;
        }

        public Criteria andCheckedObjectIdLike(String value) {
            addCriterion("CHECKED_OBJECT_ID like", value, "checkedObjectId");
            return (Criteria) this;
        }

        public Criteria andCheckedObjectIdNotLike(String value) {
            addCriterion("CHECKED_OBJECT_ID not like", value, "checkedObjectId");
            return (Criteria) this;
        }

        public Criteria andCheckedObjectIdIn(List<String> values) {
            addCriterion("CHECKED_OBJECT_ID in", values, "checkedObjectId");
            return (Criteria) this;
        }

        public Criteria andCheckedObjectIdNotIn(List<String> values) {
            addCriterion("CHECKED_OBJECT_ID not in", values, "checkedObjectId");
            return (Criteria) this;
        }

        public Criteria andCheckedObjectIdBetween(String value1, String value2) {
            addCriterion("CHECKED_OBJECT_ID between", value1, value2, "checkedObjectId");
            return (Criteria) this;
        }

        public Criteria andCheckedObjectIdNotBetween(String value1, String value2) {
            addCriterion("CHECKED_OBJECT_ID not between", value1, value2, "checkedObjectId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNull() {
            addCriterion("PLAN_ID is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("PLAN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(String value) {
            addCriterion("PLAN_ID =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(String value) {
            addCriterion("PLAN_ID <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(String value) {
            addCriterion("PLAN_ID >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(String value) {
            addCriterion("PLAN_ID >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(String value) {
            addCriterion("PLAN_ID <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(String value) {
            addCriterion("PLAN_ID <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLike(String value) {
            addCriterion("PLAN_ID like", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotLike(String value) {
            addCriterion("PLAN_ID not like", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<String> values) {
            addCriterion("PLAN_ID in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<String> values) {
            addCriterion("PLAN_ID not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(String value1, String value2) {
            addCriterion("PLAN_ID between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(String value1, String value2) {
            addCriterion("PLAN_ID not between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andCheckStaffIdIsNull() {
            addCriterion("CHECK_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andCheckStaffIdIsNotNull() {
            addCriterion("CHECK_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStaffIdEqualTo(String value) {
            addCriterion("CHECK_STAFF_ID =", value, "checkStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckStaffIdNotEqualTo(String value) {
            addCriterion("CHECK_STAFF_ID <>", value, "checkStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckStaffIdGreaterThan(String value) {
            addCriterion("CHECK_STAFF_ID >", value, "checkStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_STAFF_ID >=", value, "checkStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckStaffIdLessThan(String value) {
            addCriterion("CHECK_STAFF_ID <", value, "checkStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckStaffIdLessThanOrEqualTo(String value) {
            addCriterion("CHECK_STAFF_ID <=", value, "checkStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckStaffIdLike(String value) {
            addCriterion("CHECK_STAFF_ID like", value, "checkStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckStaffIdNotLike(String value) {
            addCriterion("CHECK_STAFF_ID not like", value, "checkStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckStaffIdIn(List<String> values) {
            addCriterion("CHECK_STAFF_ID in", values, "checkStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckStaffIdNotIn(List<String> values) {
            addCriterion("CHECK_STAFF_ID not in", values, "checkStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckStaffIdBetween(String value1, String value2) {
            addCriterion("CHECK_STAFF_ID between", value1, value2, "checkStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckStaffIdNotBetween(String value1, String value2) {
            addCriterion("CHECK_STAFF_ID not between", value1, value2, "checkStaffId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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