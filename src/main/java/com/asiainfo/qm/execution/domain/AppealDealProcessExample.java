package com.asiainfo.qm.execution.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppealDealProcessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppealDealProcessExample() {
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

        public Criteria andAppealIdIsNull() {
            addCriterion("APPEAL_ID is null");
            return (Criteria) this;
        }

        public Criteria andAppealIdIsNotNull() {
            addCriterion("APPEAL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAppealIdEqualTo(String value) {
            addCriterion("APPEAL_ID =", value, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdNotEqualTo(String value) {
            addCriterion("APPEAL_ID <>", value, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdGreaterThan(String value) {
            addCriterion("APPEAL_ID >", value, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdGreaterThanOrEqualTo(String value) {
            addCriterion("APPEAL_ID >=", value, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdLessThan(String value) {
            addCriterion("APPEAL_ID <", value, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdLessThanOrEqualTo(String value) {
            addCriterion("APPEAL_ID <=", value, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdLike(String value) {
            addCriterion("APPEAL_ID like", value, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdNotLike(String value) {
            addCriterion("APPEAL_ID not like", value, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdIn(List<String> values) {
            addCriterion("APPEAL_ID in", values, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdNotIn(List<String> values) {
            addCriterion("APPEAL_ID not in", values, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdBetween(String value1, String value2) {
            addCriterion("APPEAL_ID between", value1, value2, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdNotBetween(String value1, String value2) {
            addCriterion("APPEAL_ID not between", value1, value2, "appealId");
            return (Criteria) this;
        }

        public Criteria andCheckTypeIsNull() {
            addCriterion("CHECK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCheckTypeIsNotNull() {
            addCriterion("CHECK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTypeEqualTo(String value) {
            addCriterion("CHECK_TYPE =", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeNotEqualTo(String value) {
            addCriterion("CHECK_TYPE <>", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeGreaterThan(String value) {
            addCriterion("CHECK_TYPE >", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_TYPE >=", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeLessThan(String value) {
            addCriterion("CHECK_TYPE <", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeLessThanOrEqualTo(String value) {
            addCriterion("CHECK_TYPE <=", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeLike(String value) {
            addCriterion("CHECK_TYPE like", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeNotLike(String value) {
            addCriterion("CHECK_TYPE not like", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeIn(List<String> values) {
            addCriterion("CHECK_TYPE in", values, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeNotIn(List<String> values) {
            addCriterion("CHECK_TYPE not in", values, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeBetween(String value1, String value2) {
            addCriterion("CHECK_TYPE between", value1, value2, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeNotBetween(String value1, String value2) {
            addCriterion("CHECK_TYPE not between", value1, value2, "checkType");
            return (Criteria) this;
        }

        public Criteria andTouchIdIsNull() {
            addCriterion("TOUCH_ID is null");
            return (Criteria) this;
        }

        public Criteria andTouchIdIsNotNull() {
            addCriterion("TOUCH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTouchIdEqualTo(String value) {
            addCriterion("TOUCH_ID =", value, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdNotEqualTo(String value) {
            addCriterion("TOUCH_ID <>", value, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdGreaterThan(String value) {
            addCriterion("TOUCH_ID >", value, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdGreaterThanOrEqualTo(String value) {
            addCriterion("TOUCH_ID >=", value, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdLessThan(String value) {
            addCriterion("TOUCH_ID <", value, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdLessThanOrEqualTo(String value) {
            addCriterion("TOUCH_ID <=", value, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdLike(String value) {
            addCriterion("TOUCH_ID like", value, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdNotLike(String value) {
            addCriterion("TOUCH_ID not like", value, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdIn(List<String> values) {
            addCriterion("TOUCH_ID in", values, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdNotIn(List<String> values) {
            addCriterion("TOUCH_ID not in", values, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdBetween(String value1, String value2) {
            addCriterion("TOUCH_ID between", value1, value2, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdNotBetween(String value1, String value2) {
            addCriterion("TOUCH_ID not between", value1, value2, "touchId");
            return (Criteria) this;
        }

        public Criteria andInspectionIdIsNull() {
            addCriterion("INSPECTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andInspectionIdIsNotNull() {
            addCriterion("INSPECTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionIdEqualTo(String value) {
            addCriterion("INSPECTION_ID =", value, "inspectionId");
            return (Criteria) this;
        }

        public Criteria andInspectionIdNotEqualTo(String value) {
            addCriterion("INSPECTION_ID <>", value, "inspectionId");
            return (Criteria) this;
        }

        public Criteria andInspectionIdGreaterThan(String value) {
            addCriterion("INSPECTION_ID >", value, "inspectionId");
            return (Criteria) this;
        }

        public Criteria andInspectionIdGreaterThanOrEqualTo(String value) {
            addCriterion("INSPECTION_ID >=", value, "inspectionId");
            return (Criteria) this;
        }

        public Criteria andInspectionIdLessThan(String value) {
            addCriterion("INSPECTION_ID <", value, "inspectionId");
            return (Criteria) this;
        }

        public Criteria andInspectionIdLessThanOrEqualTo(String value) {
            addCriterion("INSPECTION_ID <=", value, "inspectionId");
            return (Criteria) this;
        }

        public Criteria andInspectionIdLike(String value) {
            addCriterion("INSPECTION_ID like", value, "inspectionId");
            return (Criteria) this;
        }

        public Criteria andInspectionIdNotLike(String value) {
            addCriterion("INSPECTION_ID not like", value, "inspectionId");
            return (Criteria) this;
        }

        public Criteria andInspectionIdIn(List<String> values) {
            addCriterion("INSPECTION_ID in", values, "inspectionId");
            return (Criteria) this;
        }

        public Criteria andInspectionIdNotIn(List<String> values) {
            addCriterion("INSPECTION_ID not in", values, "inspectionId");
            return (Criteria) this;
        }

        public Criteria andInspectionIdBetween(String value1, String value2) {
            addCriterion("INSPECTION_ID between", value1, value2, "inspectionId");
            return (Criteria) this;
        }

        public Criteria andInspectionIdNotBetween(String value1, String value2) {
            addCriterion("INSPECTION_ID not between", value1, value2, "inspectionId");
            return (Criteria) this;
        }

        public Criteria andAppealStaffIdIsNull() {
            addCriterion("APPEAL_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andAppealStaffIdIsNotNull() {
            addCriterion("APPEAL_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAppealStaffIdEqualTo(String value) {
            addCriterion("APPEAL_STAFF_ID =", value, "appealStaffId");
            return (Criteria) this;
        }

        public Criteria andAppealStaffIdNotEqualTo(String value) {
            addCriterion("APPEAL_STAFF_ID <>", value, "appealStaffId");
            return (Criteria) this;
        }

        public Criteria andAppealStaffIdGreaterThan(String value) {
            addCriterion("APPEAL_STAFF_ID >", value, "appealStaffId");
            return (Criteria) this;
        }

        public Criteria andAppealStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("APPEAL_STAFF_ID >=", value, "appealStaffId");
            return (Criteria) this;
        }

        public Criteria andAppealStaffIdLessThan(String value) {
            addCriterion("APPEAL_STAFF_ID <", value, "appealStaffId");
            return (Criteria) this;
        }

        public Criteria andAppealStaffIdLessThanOrEqualTo(String value) {
            addCriterion("APPEAL_STAFF_ID <=", value, "appealStaffId");
            return (Criteria) this;
        }

        public Criteria andAppealStaffIdLike(String value) {
            addCriterion("APPEAL_STAFF_ID like", value, "appealStaffId");
            return (Criteria) this;
        }

        public Criteria andAppealStaffIdNotLike(String value) {
            addCriterion("APPEAL_STAFF_ID not like", value, "appealStaffId");
            return (Criteria) this;
        }

        public Criteria andAppealStaffIdIn(List<String> values) {
            addCriterion("APPEAL_STAFF_ID in", values, "appealStaffId");
            return (Criteria) this;
        }

        public Criteria andAppealStaffIdNotIn(List<String> values) {
            addCriterion("APPEAL_STAFF_ID not in", values, "appealStaffId");
            return (Criteria) this;
        }

        public Criteria andAppealStaffIdBetween(String value1, String value2) {
            addCriterion("APPEAL_STAFF_ID between", value1, value2, "appealStaffId");
            return (Criteria) this;
        }

        public Criteria andAppealStaffIdNotBetween(String value1, String value2) {
            addCriterion("APPEAL_STAFF_ID not between", value1, value2, "appealStaffId");
            return (Criteria) this;
        }

        public Criteria andAppealStaffNameIsNull() {
            addCriterion("APPEAL_STAFF_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAppealStaffNameIsNotNull() {
            addCriterion("APPEAL_STAFF_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAppealStaffNameEqualTo(String value) {
            addCriterion("APPEAL_STAFF_NAME =", value, "appealStaffName");
            return (Criteria) this;
        }

        public Criteria andAppealStaffNameNotEqualTo(String value) {
            addCriterion("APPEAL_STAFF_NAME <>", value, "appealStaffName");
            return (Criteria) this;
        }

        public Criteria andAppealStaffNameGreaterThan(String value) {
            addCriterion("APPEAL_STAFF_NAME >", value, "appealStaffName");
            return (Criteria) this;
        }

        public Criteria andAppealStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("APPEAL_STAFF_NAME >=", value, "appealStaffName");
            return (Criteria) this;
        }

        public Criteria andAppealStaffNameLessThan(String value) {
            addCriterion("APPEAL_STAFF_NAME <", value, "appealStaffName");
            return (Criteria) this;
        }

        public Criteria andAppealStaffNameLessThanOrEqualTo(String value) {
            addCriterion("APPEAL_STAFF_NAME <=", value, "appealStaffName");
            return (Criteria) this;
        }

        public Criteria andAppealStaffNameLike(String value) {
            addCriterion("APPEAL_STAFF_NAME like", value, "appealStaffName");
            return (Criteria) this;
        }

        public Criteria andAppealStaffNameNotLike(String value) {
            addCriterion("APPEAL_STAFF_NAME not like", value, "appealStaffName");
            return (Criteria) this;
        }

        public Criteria andAppealStaffNameIn(List<String> values) {
            addCriterion("APPEAL_STAFF_NAME in", values, "appealStaffName");
            return (Criteria) this;
        }

        public Criteria andAppealStaffNameNotIn(List<String> values) {
            addCriterion("APPEAL_STAFF_NAME not in", values, "appealStaffName");
            return (Criteria) this;
        }

        public Criteria andAppealStaffNameBetween(String value1, String value2) {
            addCriterion("APPEAL_STAFF_NAME between", value1, value2, "appealStaffName");
            return (Criteria) this;
        }

        public Criteria andAppealStaffNameNotBetween(String value1, String value2) {
            addCriterion("APPEAL_STAFF_NAME not between", value1, value2, "appealStaffName");
            return (Criteria) this;
        }

        public Criteria andAppealReasonIsNull() {
            addCriterion("APPEAL_REASON is null");
            return (Criteria) this;
        }

        public Criteria andAppealReasonIsNotNull() {
            addCriterion("APPEAL_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andAppealReasonEqualTo(String value) {
            addCriterion("APPEAL_REASON =", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonNotEqualTo(String value) {
            addCriterion("APPEAL_REASON <>", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonGreaterThan(String value) {
            addCriterion("APPEAL_REASON >", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonGreaterThanOrEqualTo(String value) {
            addCriterion("APPEAL_REASON >=", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonLessThan(String value) {
            addCriterion("APPEAL_REASON <", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonLessThanOrEqualTo(String value) {
            addCriterion("APPEAL_REASON <=", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonLike(String value) {
            addCriterion("APPEAL_REASON like", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonNotLike(String value) {
            addCriterion("APPEAL_REASON not like", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonIn(List<String> values) {
            addCriterion("APPEAL_REASON in", values, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonNotIn(List<String> values) {
            addCriterion("APPEAL_REASON not in", values, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonBetween(String value1, String value2) {
            addCriterion("APPEAL_REASON between", value1, value2, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonNotBetween(String value1, String value2) {
            addCriterion("APPEAL_REASON not between", value1, value2, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealTimeIsNull() {
            addCriterion("APPEAL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAppealTimeIsNotNull() {
            addCriterion("APPEAL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAppealTimeEqualTo(Date value) {
            addCriterion("APPEAL_TIME =", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeNotEqualTo(Date value) {
            addCriterion("APPEAL_TIME <>", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeGreaterThan(Date value) {
            addCriterion("APPEAL_TIME >", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("APPEAL_TIME >=", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeLessThan(Date value) {
            addCriterion("APPEAL_TIME <", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeLessThanOrEqualTo(Date value) {
            addCriterion("APPEAL_TIME <=", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeIn(List<Date> values) {
            addCriterion("APPEAL_TIME in", values, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeNotIn(List<Date> values) {
            addCriterion("APPEAL_TIME not in", values, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeBetween(Date value1, Date value2) {
            addCriterion("APPEAL_TIME between", value1, value2, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeNotBetween(Date value1, Date value2) {
            addCriterion("APPEAL_TIME not between", value1, value2, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealStatusIsNull() {
            addCriterion("APPEAL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAppealStatusIsNotNull() {
            addCriterion("APPEAL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAppealStatusEqualTo(String value) {
            addCriterion("APPEAL_STATUS =", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusNotEqualTo(String value) {
            addCriterion("APPEAL_STATUS <>", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusGreaterThan(String value) {
            addCriterion("APPEAL_STATUS >", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusGreaterThanOrEqualTo(String value) {
            addCriterion("APPEAL_STATUS >=", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusLessThan(String value) {
            addCriterion("APPEAL_STATUS <", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusLessThanOrEqualTo(String value) {
            addCriterion("APPEAL_STATUS <=", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusLike(String value) {
            addCriterion("APPEAL_STATUS like", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusNotLike(String value) {
            addCriterion("APPEAL_STATUS not like", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusIn(List<String> values) {
            addCriterion("APPEAL_STATUS in", values, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusNotIn(List<String> values) {
            addCriterion("APPEAL_STATUS not in", values, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusBetween(String value1, String value2) {
            addCriterion("APPEAL_STATUS between", value1, value2, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusNotBetween(String value1, String value2) {
            addCriterion("APPEAL_STATUS not between", value1, value2, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andMainProcessIdIsNull() {
            addCriterion("MAIN_PROCESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andMainProcessIdIsNotNull() {
            addCriterion("MAIN_PROCESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMainProcessIdEqualTo(String value) {
            addCriterion("MAIN_PROCESS_ID =", value, "mainProcessId");
            return (Criteria) this;
        }

        public Criteria andMainProcessIdNotEqualTo(String value) {
            addCriterion("MAIN_PROCESS_ID <>", value, "mainProcessId");
            return (Criteria) this;
        }

        public Criteria andMainProcessIdGreaterThan(String value) {
            addCriterion("MAIN_PROCESS_ID >", value, "mainProcessId");
            return (Criteria) this;
        }

        public Criteria andMainProcessIdGreaterThanOrEqualTo(String value) {
            addCriterion("MAIN_PROCESS_ID >=", value, "mainProcessId");
            return (Criteria) this;
        }

        public Criteria andMainProcessIdLessThan(String value) {
            addCriterion("MAIN_PROCESS_ID <", value, "mainProcessId");
            return (Criteria) this;
        }

        public Criteria andMainProcessIdLessThanOrEqualTo(String value) {
            addCriterion("MAIN_PROCESS_ID <=", value, "mainProcessId");
            return (Criteria) this;
        }

        public Criteria andMainProcessIdLike(String value) {
            addCriterion("MAIN_PROCESS_ID like", value, "mainProcessId");
            return (Criteria) this;
        }

        public Criteria andMainProcessIdNotLike(String value) {
            addCriterion("MAIN_PROCESS_ID not like", value, "mainProcessId");
            return (Criteria) this;
        }

        public Criteria andMainProcessIdIn(List<String> values) {
            addCriterion("MAIN_PROCESS_ID in", values, "mainProcessId");
            return (Criteria) this;
        }

        public Criteria andMainProcessIdNotIn(List<String> values) {
            addCriterion("MAIN_PROCESS_ID not in", values, "mainProcessId");
            return (Criteria) this;
        }

        public Criteria andMainProcessIdBetween(String value1, String value2) {
            addCriterion("MAIN_PROCESS_ID between", value1, value2, "mainProcessId");
            return (Criteria) this;
        }

        public Criteria andMainProcessIdNotBetween(String value1, String value2) {
            addCriterion("MAIN_PROCESS_ID not between", value1, value2, "mainProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdIsNull() {
            addCriterion("CURRENT_PROCESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdIsNotNull() {
            addCriterion("CURRENT_PROCESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdEqualTo(String value) {
            addCriterion("CURRENT_PROCESS_ID =", value, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdNotEqualTo(String value) {
            addCriterion("CURRENT_PROCESS_ID <>", value, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdGreaterThan(String value) {
            addCriterion("CURRENT_PROCESS_ID >", value, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENT_PROCESS_ID >=", value, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdLessThan(String value) {
            addCriterion("CURRENT_PROCESS_ID <", value, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdLessThanOrEqualTo(String value) {
            addCriterion("CURRENT_PROCESS_ID <=", value, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdLike(String value) {
            addCriterion("CURRENT_PROCESS_ID like", value, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdNotLike(String value) {
            addCriterion("CURRENT_PROCESS_ID not like", value, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdIn(List<String> values) {
            addCriterion("CURRENT_PROCESS_ID in", values, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdNotIn(List<String> values) {
            addCriterion("CURRENT_PROCESS_ID not in", values, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdBetween(String value1, String value2) {
            addCriterion("CURRENT_PROCESS_ID between", value1, value2, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdNotBetween(String value1, String value2) {
            addCriterion("CURRENT_PROCESS_ID not between", value1, value2, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIdIsNull() {
            addCriterion("CURRENT_NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIdIsNotNull() {
            addCriterion("CURRENT_NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIdEqualTo(Integer value) {
            addCriterion("CURRENT_NODE_ID =", value, "currentNodeId");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIdNotEqualTo(Integer value) {
            addCriterion("CURRENT_NODE_ID <>", value, "currentNodeId");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIdGreaterThan(Integer value) {
            addCriterion("CURRENT_NODE_ID >", value, "currentNodeId");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CURRENT_NODE_ID >=", value, "currentNodeId");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIdLessThan(Integer value) {
            addCriterion("CURRENT_NODE_ID <", value, "currentNodeId");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("CURRENT_NODE_ID <=", value, "currentNodeId");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIdIn(List<Integer> values) {
            addCriterion("CURRENT_NODE_ID in", values, "currentNodeId");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIdNotIn(List<Integer> values) {
            addCriterion("CURRENT_NODE_ID not in", values, "currentNodeId");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("CURRENT_NODE_ID between", value1, value2, "currentNodeId");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CURRENT_NODE_ID not between", value1, value2, "currentNodeId");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameIsNull() {
            addCriterion("CURRENT_NODE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameIsNotNull() {
            addCriterion("CURRENT_NODE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameEqualTo(Integer value) {
            addCriterion("CURRENT_NODE_NAME =", value, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameNotEqualTo(Integer value) {
            addCriterion("CURRENT_NODE_NAME <>", value, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameGreaterThan(Integer value) {
            addCriterion("CURRENT_NODE_NAME >", value, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("CURRENT_NODE_NAME >=", value, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameLessThan(Integer value) {
            addCriterion("CURRENT_NODE_NAME <", value, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameLessThanOrEqualTo(Integer value) {
            addCriterion("CURRENT_NODE_NAME <=", value, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameIn(List<Integer> values) {
            addCriterion("CURRENT_NODE_NAME in", values, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameNotIn(List<Integer> values) {
            addCriterion("CURRENT_NODE_NAME not in", values, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameBetween(Integer value1, Integer value2) {
            addCriterion("CURRENT_NODE_NAME between", value1, value2, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameNotBetween(Integer value1, Integer value2) {
            addCriterion("CURRENT_NODE_NAME not between", value1, value2, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andPreProcessIdIsNull() {
            addCriterion("PRE_PROCESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andPreProcessIdIsNotNull() {
            addCriterion("PRE_PROCESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPreProcessIdEqualTo(String value) {
            addCriterion("PRE_PROCESS_ID =", value, "preProcessId");
            return (Criteria) this;
        }

        public Criteria andPreProcessIdNotEqualTo(String value) {
            addCriterion("PRE_PROCESS_ID <>", value, "preProcessId");
            return (Criteria) this;
        }

        public Criteria andPreProcessIdGreaterThan(String value) {
            addCriterion("PRE_PROCESS_ID >", value, "preProcessId");
            return (Criteria) this;
        }

        public Criteria andPreProcessIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRE_PROCESS_ID >=", value, "preProcessId");
            return (Criteria) this;
        }

        public Criteria andPreProcessIdLessThan(String value) {
            addCriterion("PRE_PROCESS_ID <", value, "preProcessId");
            return (Criteria) this;
        }

        public Criteria andPreProcessIdLessThanOrEqualTo(String value) {
            addCriterion("PRE_PROCESS_ID <=", value, "preProcessId");
            return (Criteria) this;
        }

        public Criteria andPreProcessIdLike(String value) {
            addCriterion("PRE_PROCESS_ID like", value, "preProcessId");
            return (Criteria) this;
        }

        public Criteria andPreProcessIdNotLike(String value) {
            addCriterion("PRE_PROCESS_ID not like", value, "preProcessId");
            return (Criteria) this;
        }

        public Criteria andPreProcessIdIn(List<String> values) {
            addCriterion("PRE_PROCESS_ID in", values, "preProcessId");
            return (Criteria) this;
        }

        public Criteria andPreProcessIdNotIn(List<String> values) {
            addCriterion("PRE_PROCESS_ID not in", values, "preProcessId");
            return (Criteria) this;
        }

        public Criteria andPreProcessIdBetween(String value1, String value2) {
            addCriterion("PRE_PROCESS_ID between", value1, value2, "preProcessId");
            return (Criteria) this;
        }

        public Criteria andPreProcessIdNotBetween(String value1, String value2) {
            addCriterion("PRE_PROCESS_ID not between", value1, value2, "preProcessId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdIsNull() {
            addCriterion("PRE_NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdIsNotNull() {
            addCriterion("PRE_NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdEqualTo(Integer value) {
            addCriterion("PRE_NODE_ID =", value, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdNotEqualTo(Integer value) {
            addCriterion("PRE_NODE_ID <>", value, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdGreaterThan(Integer value) {
            addCriterion("PRE_NODE_ID >", value, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRE_NODE_ID >=", value, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdLessThan(Integer value) {
            addCriterion("PRE_NODE_ID <", value, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("PRE_NODE_ID <=", value, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdIn(List<Integer> values) {
            addCriterion("PRE_NODE_ID in", values, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdNotIn(List<Integer> values) {
            addCriterion("PRE_NODE_ID not in", values, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("PRE_NODE_ID between", value1, value2, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PRE_NODE_ID not between", value1, value2, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeDealStaffIdIsNull() {
            addCriterion("PRE_NODE_DEAL_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andPreNodeDealStaffIdIsNotNull() {
            addCriterion("PRE_NODE_DEAL_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPreNodeDealStaffIdEqualTo(String value) {
            addCriterion("PRE_NODE_DEAL_STAFF_ID =", value, "preNodeDealStaffId");
            return (Criteria) this;
        }

        public Criteria andPreNodeDealStaffIdNotEqualTo(String value) {
            addCriterion("PRE_NODE_DEAL_STAFF_ID <>", value, "preNodeDealStaffId");
            return (Criteria) this;
        }

        public Criteria andPreNodeDealStaffIdGreaterThan(String value) {
            addCriterion("PRE_NODE_DEAL_STAFF_ID >", value, "preNodeDealStaffId");
            return (Criteria) this;
        }

        public Criteria andPreNodeDealStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRE_NODE_DEAL_STAFF_ID >=", value, "preNodeDealStaffId");
            return (Criteria) this;
        }

        public Criteria andPreNodeDealStaffIdLessThan(String value) {
            addCriterion("PRE_NODE_DEAL_STAFF_ID <", value, "preNodeDealStaffId");
            return (Criteria) this;
        }

        public Criteria andPreNodeDealStaffIdLessThanOrEqualTo(String value) {
            addCriterion("PRE_NODE_DEAL_STAFF_ID <=", value, "preNodeDealStaffId");
            return (Criteria) this;
        }

        public Criteria andPreNodeDealStaffIdLike(String value) {
            addCriterion("PRE_NODE_DEAL_STAFF_ID like", value, "preNodeDealStaffId");
            return (Criteria) this;
        }

        public Criteria andPreNodeDealStaffIdNotLike(String value) {
            addCriterion("PRE_NODE_DEAL_STAFF_ID not like", value, "preNodeDealStaffId");
            return (Criteria) this;
        }

        public Criteria andPreNodeDealStaffIdIn(List<String> values) {
            addCriterion("PRE_NODE_DEAL_STAFF_ID in", values, "preNodeDealStaffId");
            return (Criteria) this;
        }

        public Criteria andPreNodeDealStaffIdNotIn(List<String> values) {
            addCriterion("PRE_NODE_DEAL_STAFF_ID not in", values, "preNodeDealStaffId");
            return (Criteria) this;
        }

        public Criteria andPreNodeDealStaffIdBetween(String value1, String value2) {
            addCriterion("PRE_NODE_DEAL_STAFF_ID between", value1, value2, "preNodeDealStaffId");
            return (Criteria) this;
        }

        public Criteria andPreNodeDealStaffIdNotBetween(String value1, String value2) {
            addCriterion("PRE_NODE_DEAL_STAFF_ID not between", value1, value2, "preNodeDealStaffId");
            return (Criteria) this;
        }

        public Criteria andNextProcessIdIsNull() {
            addCriterion("NEXT_PROCESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andNextProcessIdIsNotNull() {
            addCriterion("NEXT_PROCESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNextProcessIdEqualTo(String value) {
            addCriterion("NEXT_PROCESS_ID =", value, "nextProcessId");
            return (Criteria) this;
        }

        public Criteria andNextProcessIdNotEqualTo(String value) {
            addCriterion("NEXT_PROCESS_ID <>", value, "nextProcessId");
            return (Criteria) this;
        }

        public Criteria andNextProcessIdGreaterThan(String value) {
            addCriterion("NEXT_PROCESS_ID >", value, "nextProcessId");
            return (Criteria) this;
        }

        public Criteria andNextProcessIdGreaterThanOrEqualTo(String value) {
            addCriterion("NEXT_PROCESS_ID >=", value, "nextProcessId");
            return (Criteria) this;
        }

        public Criteria andNextProcessIdLessThan(String value) {
            addCriterion("NEXT_PROCESS_ID <", value, "nextProcessId");
            return (Criteria) this;
        }

        public Criteria andNextProcessIdLessThanOrEqualTo(String value) {
            addCriterion("NEXT_PROCESS_ID <=", value, "nextProcessId");
            return (Criteria) this;
        }

        public Criteria andNextProcessIdLike(String value) {
            addCriterion("NEXT_PROCESS_ID like", value, "nextProcessId");
            return (Criteria) this;
        }

        public Criteria andNextProcessIdNotLike(String value) {
            addCriterion("NEXT_PROCESS_ID not like", value, "nextProcessId");
            return (Criteria) this;
        }

        public Criteria andNextProcessIdIn(List<String> values) {
            addCriterion("NEXT_PROCESS_ID in", values, "nextProcessId");
            return (Criteria) this;
        }

        public Criteria andNextProcessIdNotIn(List<String> values) {
            addCriterion("NEXT_PROCESS_ID not in", values, "nextProcessId");
            return (Criteria) this;
        }

        public Criteria andNextProcessIdBetween(String value1, String value2) {
            addCriterion("NEXT_PROCESS_ID between", value1, value2, "nextProcessId");
            return (Criteria) this;
        }

        public Criteria andNextProcessIdNotBetween(String value1, String value2) {
            addCriterion("NEXT_PROCESS_ID not between", value1, value2, "nextProcessId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdIsNull() {
            addCriterion("NEXT_NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdIsNotNull() {
            addCriterion("NEXT_NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdEqualTo(Integer value) {
            addCriterion("NEXT_NODE_ID =", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdNotEqualTo(Integer value) {
            addCriterion("NEXT_NODE_ID <>", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdGreaterThan(Integer value) {
            addCriterion("NEXT_NODE_ID >", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("NEXT_NODE_ID >=", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdLessThan(Integer value) {
            addCriterion("NEXT_NODE_ID <", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("NEXT_NODE_ID <=", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdIn(List<Integer> values) {
            addCriterion("NEXT_NODE_ID in", values, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdNotIn(List<Integer> values) {
            addCriterion("NEXT_NODE_ID not in", values, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("NEXT_NODE_ID between", value1, value2, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("NEXT_NODE_ID not between", value1, value2, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNull() {
            addCriterion("RESERVE_1 is null");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNotNull() {
            addCriterion("RESERVE_1 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve1EqualTo(String value) {
            addCriterion("RESERVE_1 =", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotEqualTo(String value) {
            addCriterion("RESERVE_1 <>", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThan(String value) {
            addCriterion("RESERVE_1 >", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE_1 >=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThan(String value) {
            addCriterion("RESERVE_1 <", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThanOrEqualTo(String value) {
            addCriterion("RESERVE_1 <=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Like(String value) {
            addCriterion("RESERVE_1 like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotLike(String value) {
            addCriterion("RESERVE_1 not like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1In(List<String> values) {
            addCriterion("RESERVE_1 in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotIn(List<String> values) {
            addCriterion("RESERVE_1 not in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Between(String value1, String value2) {
            addCriterion("RESERVE_1 between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotBetween(String value1, String value2) {
            addCriterion("RESERVE_1 not between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNull() {
            addCriterion("RESERVE_2 is null");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNotNull() {
            addCriterion("RESERVE_2 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve2EqualTo(String value) {
            addCriterion("RESERVE_2 =", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotEqualTo(String value) {
            addCriterion("RESERVE_2 <>", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThan(String value) {
            addCriterion("RESERVE_2 >", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE_2 >=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThan(String value) {
            addCriterion("RESERVE_2 <", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThanOrEqualTo(String value) {
            addCriterion("RESERVE_2 <=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Like(String value) {
            addCriterion("RESERVE_2 like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotLike(String value) {
            addCriterion("RESERVE_2 not like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2In(List<String> values) {
            addCriterion("RESERVE_2 in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotIn(List<String> values) {
            addCriterion("RESERVE_2 not in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Between(String value1, String value2) {
            addCriterion("RESERVE_2 between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotBetween(String value1, String value2) {
            addCriterion("RESERVE_2 not between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNull() {
            addCriterion("RESERVE_3 is null");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNotNull() {
            addCriterion("RESERVE_3 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve3EqualTo(String value) {
            addCriterion("RESERVE_3 =", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotEqualTo(String value) {
            addCriterion("RESERVE_3 <>", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThan(String value) {
            addCriterion("RESERVE_3 >", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE_3 >=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThan(String value) {
            addCriterion("RESERVE_3 <", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThanOrEqualTo(String value) {
            addCriterion("RESERVE_3 <=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Like(String value) {
            addCriterion("RESERVE_3 like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotLike(String value) {
            addCriterion("RESERVE_3 not like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3In(List<String> values) {
            addCriterion("RESERVE_3 in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotIn(List<String> values) {
            addCriterion("RESERVE_3 not in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Between(String value1, String value2) {
            addCriterion("RESERVE_3 between", value1, value2, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotBetween(String value1, String value2) {
            addCriterion("RESERVE_3 not between", value1, value2, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve4IsNull() {
            addCriterion("RESERVE_4 is null");
            return (Criteria) this;
        }

        public Criteria andReserve4IsNotNull() {
            addCriterion("RESERVE_4 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve4EqualTo(String value) {
            addCriterion("RESERVE_4 =", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotEqualTo(String value) {
            addCriterion("RESERVE_4 <>", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4GreaterThan(String value) {
            addCriterion("RESERVE_4 >", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE_4 >=", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4LessThan(String value) {
            addCriterion("RESERVE_4 <", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4LessThanOrEqualTo(String value) {
            addCriterion("RESERVE_4 <=", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4Like(String value) {
            addCriterion("RESERVE_4 like", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotLike(String value) {
            addCriterion("RESERVE_4 not like", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4In(List<String> values) {
            addCriterion("RESERVE_4 in", values, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotIn(List<String> values) {
            addCriterion("RESERVE_4 not in", values, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4Between(String value1, String value2) {
            addCriterion("RESERVE_4 between", value1, value2, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotBetween(String value1, String value2) {
            addCriterion("RESERVE_4 not between", value1, value2, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve5IsNull() {
            addCriterion("RESERVE_5 is null");
            return (Criteria) this;
        }

        public Criteria andReserve5IsNotNull() {
            addCriterion("RESERVE_5 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve5EqualTo(String value) {
            addCriterion("RESERVE_5 =", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotEqualTo(String value) {
            addCriterion("RESERVE_5 <>", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5GreaterThan(String value) {
            addCriterion("RESERVE_5 >", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE_5 >=", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5LessThan(String value) {
            addCriterion("RESERVE_5 <", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5LessThanOrEqualTo(String value) {
            addCriterion("RESERVE_5 <=", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5Like(String value) {
            addCriterion("RESERVE_5 like", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotLike(String value) {
            addCriterion("RESERVE_5 not like", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5In(List<String> values) {
            addCriterion("RESERVE_5 in", values, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotIn(List<String> values) {
            addCriterion("RESERVE_5 not in", values, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5Between(String value1, String value2) {
            addCriterion("RESERVE_5 between", value1, value2, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotBetween(String value1, String value2) {
            addCriterion("RESERVE_5 not between", value1, value2, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve6IsNull() {
            addCriterion("RESERVE_6 is null");
            return (Criteria) this;
        }

        public Criteria andReserve6IsNotNull() {
            addCriterion("RESERVE_6 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve6EqualTo(String value) {
            addCriterion("RESERVE_6 =", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6NotEqualTo(String value) {
            addCriterion("RESERVE_6 <>", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6GreaterThan(String value) {
            addCriterion("RESERVE_6 >", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE_6 >=", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6LessThan(String value) {
            addCriterion("RESERVE_6 <", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6LessThanOrEqualTo(String value) {
            addCriterion("RESERVE_6 <=", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6Like(String value) {
            addCriterion("RESERVE_6 like", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6NotLike(String value) {
            addCriterion("RESERVE_6 not like", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6In(List<String> values) {
            addCriterion("RESERVE_6 in", values, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6NotIn(List<String> values) {
            addCriterion("RESERVE_6 not in", values, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6Between(String value1, String value2) {
            addCriterion("RESERVE_6 between", value1, value2, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6NotBetween(String value1, String value2) {
            addCriterion("RESERVE_6 not between", value1, value2, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve7IsNull() {
            addCriterion("RESERVE_7 is null");
            return (Criteria) this;
        }

        public Criteria andReserve7IsNotNull() {
            addCriterion("RESERVE_7 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve7EqualTo(String value) {
            addCriterion("RESERVE_7 =", value, "reserve7");
            return (Criteria) this;
        }

        public Criteria andReserve7NotEqualTo(String value) {
            addCriterion("RESERVE_7 <>", value, "reserve7");
            return (Criteria) this;
        }

        public Criteria andReserve7GreaterThan(String value) {
            addCriterion("RESERVE_7 >", value, "reserve7");
            return (Criteria) this;
        }

        public Criteria andReserve7GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE_7 >=", value, "reserve7");
            return (Criteria) this;
        }

        public Criteria andReserve7LessThan(String value) {
            addCriterion("RESERVE_7 <", value, "reserve7");
            return (Criteria) this;
        }

        public Criteria andReserve7LessThanOrEqualTo(String value) {
            addCriterion("RESERVE_7 <=", value, "reserve7");
            return (Criteria) this;
        }

        public Criteria andReserve7Like(String value) {
            addCriterion("RESERVE_7 like", value, "reserve7");
            return (Criteria) this;
        }

        public Criteria andReserve7NotLike(String value) {
            addCriterion("RESERVE_7 not like", value, "reserve7");
            return (Criteria) this;
        }

        public Criteria andReserve7In(List<String> values) {
            addCriterion("RESERVE_7 in", values, "reserve7");
            return (Criteria) this;
        }

        public Criteria andReserve7NotIn(List<String> values) {
            addCriterion("RESERVE_7 not in", values, "reserve7");
            return (Criteria) this;
        }

        public Criteria andReserve7Between(String value1, String value2) {
            addCriterion("RESERVE_7 between", value1, value2, "reserve7");
            return (Criteria) this;
        }

        public Criteria andReserve7NotBetween(String value1, String value2) {
            addCriterion("RESERVE_7 not between", value1, value2, "reserve7");
            return (Criteria) this;
        }

        public Criteria andReserve8IsNull() {
            addCriterion("RESERVE_8 is null");
            return (Criteria) this;
        }

        public Criteria andReserve8IsNotNull() {
            addCriterion("RESERVE_8 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve8EqualTo(String value) {
            addCriterion("RESERVE_8 =", value, "reserve8");
            return (Criteria) this;
        }

        public Criteria andReserve8NotEqualTo(String value) {
            addCriterion("RESERVE_8 <>", value, "reserve8");
            return (Criteria) this;
        }

        public Criteria andReserve8GreaterThan(String value) {
            addCriterion("RESERVE_8 >", value, "reserve8");
            return (Criteria) this;
        }

        public Criteria andReserve8GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE_8 >=", value, "reserve8");
            return (Criteria) this;
        }

        public Criteria andReserve8LessThan(String value) {
            addCriterion("RESERVE_8 <", value, "reserve8");
            return (Criteria) this;
        }

        public Criteria andReserve8LessThanOrEqualTo(String value) {
            addCriterion("RESERVE_8 <=", value, "reserve8");
            return (Criteria) this;
        }

        public Criteria andReserve8Like(String value) {
            addCriterion("RESERVE_8 like", value, "reserve8");
            return (Criteria) this;
        }

        public Criteria andReserve8NotLike(String value) {
            addCriterion("RESERVE_8 not like", value, "reserve8");
            return (Criteria) this;
        }

        public Criteria andReserve8In(List<String> values) {
            addCriterion("RESERVE_8 in", values, "reserve8");
            return (Criteria) this;
        }

        public Criteria andReserve8NotIn(List<String> values) {
            addCriterion("RESERVE_8 not in", values, "reserve8");
            return (Criteria) this;
        }

        public Criteria andReserve8Between(String value1, String value2) {
            addCriterion("RESERVE_8 between", value1, value2, "reserve8");
            return (Criteria) this;
        }

        public Criteria andReserve8NotBetween(String value1, String value2) {
            addCriterion("RESERVE_8 not between", value1, value2, "reserve8");
            return (Criteria) this;
        }

        public Criteria andReserve9IsNull() {
            addCriterion("RESERVE_9 is null");
            return (Criteria) this;
        }

        public Criteria andReserve9IsNotNull() {
            addCriterion("RESERVE_9 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve9EqualTo(String value) {
            addCriterion("RESERVE_9 =", value, "reserve9");
            return (Criteria) this;
        }

        public Criteria andReserve9NotEqualTo(String value) {
            addCriterion("RESERVE_9 <>", value, "reserve9");
            return (Criteria) this;
        }

        public Criteria andReserve9GreaterThan(String value) {
            addCriterion("RESERVE_9 >", value, "reserve9");
            return (Criteria) this;
        }

        public Criteria andReserve9GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE_9 >=", value, "reserve9");
            return (Criteria) this;
        }

        public Criteria andReserve9LessThan(String value) {
            addCriterion("RESERVE_9 <", value, "reserve9");
            return (Criteria) this;
        }

        public Criteria andReserve9LessThanOrEqualTo(String value) {
            addCriterion("RESERVE_9 <=", value, "reserve9");
            return (Criteria) this;
        }

        public Criteria andReserve9Like(String value) {
            addCriterion("RESERVE_9 like", value, "reserve9");
            return (Criteria) this;
        }

        public Criteria andReserve9NotLike(String value) {
            addCriterion("RESERVE_9 not like", value, "reserve9");
            return (Criteria) this;
        }

        public Criteria andReserve9In(List<String> values) {
            addCriterion("RESERVE_9 in", values, "reserve9");
            return (Criteria) this;
        }

        public Criteria andReserve9NotIn(List<String> values) {
            addCriterion("RESERVE_9 not in", values, "reserve9");
            return (Criteria) this;
        }

        public Criteria andReserve9Between(String value1, String value2) {
            addCriterion("RESERVE_9 between", value1, value2, "reserve9");
            return (Criteria) this;
        }

        public Criteria andReserve9NotBetween(String value1, String value2) {
            addCriterion("RESERVE_9 not between", value1, value2, "reserve9");
            return (Criteria) this;
        }

        public Criteria andReserve10IsNull() {
            addCriterion("RESERVE_10 is null");
            return (Criteria) this;
        }

        public Criteria andReserve10IsNotNull() {
            addCriterion("RESERVE_10 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve10EqualTo(String value) {
            addCriterion("RESERVE_10 =", value, "reserve10");
            return (Criteria) this;
        }

        public Criteria andReserve10NotEqualTo(String value) {
            addCriterion("RESERVE_10 <>", value, "reserve10");
            return (Criteria) this;
        }

        public Criteria andReserve10GreaterThan(String value) {
            addCriterion("RESERVE_10 >", value, "reserve10");
            return (Criteria) this;
        }

        public Criteria andReserve10GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE_10 >=", value, "reserve10");
            return (Criteria) this;
        }

        public Criteria andReserve10LessThan(String value) {
            addCriterion("RESERVE_10 <", value, "reserve10");
            return (Criteria) this;
        }

        public Criteria andReserve10LessThanOrEqualTo(String value) {
            addCriterion("RESERVE_10 <=", value, "reserve10");
            return (Criteria) this;
        }

        public Criteria andReserve10Like(String value) {
            addCriterion("RESERVE_10 like", value, "reserve10");
            return (Criteria) this;
        }

        public Criteria andReserve10NotLike(String value) {
            addCriterion("RESERVE_10 not like", value, "reserve10");
            return (Criteria) this;
        }

        public Criteria andReserve10In(List<String> values) {
            addCriterion("RESERVE_10 in", values, "reserve10");
            return (Criteria) this;
        }

        public Criteria andReserve10NotIn(List<String> values) {
            addCriterion("RESERVE_10 not in", values, "reserve10");
            return (Criteria) this;
        }

        public Criteria andReserve10Between(String value1, String value2) {
            addCriterion("RESERVE_10 between", value1, value2, "reserve10");
            return (Criteria) this;
        }

        public Criteria andReserve10NotBetween(String value1, String value2) {
            addCriterion("RESERVE_10 not between", value1, value2, "reserve10");
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