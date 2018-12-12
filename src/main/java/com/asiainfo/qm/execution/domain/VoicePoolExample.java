package com.asiainfo.qm.execution.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VoicePoolExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VoicePoolExample() {
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

        public Criteria andTenantIdIsNull() {
            addCriterion("TENANT_ID is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("TENANT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("TENANT_ID =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("TENANT_ID <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("TENANT_ID >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("TENANT_ID >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("TENANT_ID <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("TENANT_ID <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("TENANT_ID like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("TENANT_ID not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("TENANT_ID in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("TENANT_ID not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("TENANT_ID between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("TENANT_ID not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("PROVINCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("PROVINCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(String value) {
            addCriterion("PROVINCE_ID =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(String value) {
            addCriterion("PROVINCE_ID <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(String value) {
            addCriterion("PROVINCE_ID >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_ID >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(String value) {
            addCriterion("PROVINCE_ID <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_ID <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLike(String value) {
            addCriterion("PROVINCE_ID like", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotLike(String value) {
            addCriterion("PROVINCE_ID not like", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<String> values) {
            addCriterion("PROVINCE_ID in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<String> values) {
            addCriterion("PROVINCE_ID not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(String value1, String value2) {
            addCriterion("PROVINCE_ID between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_ID not between", value1, value2, "provinceId");
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

        public Criteria andCheckStaffNameIsNull() {
            addCriterion("CHECK_STAFF_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCheckStaffNameIsNotNull() {
            addCriterion("CHECK_STAFF_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStaffNameEqualTo(String value) {
            addCriterion("CHECK_STAFF_NAME =", value, "checkStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckStaffNameNotEqualTo(String value) {
            addCriterion("CHECK_STAFF_NAME <>", value, "checkStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckStaffNameGreaterThan(String value) {
            addCriterion("CHECK_STAFF_NAME >", value, "checkStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_STAFF_NAME >=", value, "checkStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckStaffNameLessThan(String value) {
            addCriterion("CHECK_STAFF_NAME <", value, "checkStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckStaffNameLessThanOrEqualTo(String value) {
            addCriterion("CHECK_STAFF_NAME <=", value, "checkStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckStaffNameLike(String value) {
            addCriterion("CHECK_STAFF_NAME like", value, "checkStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckStaffNameNotLike(String value) {
            addCriterion("CHECK_STAFF_NAME not like", value, "checkStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckStaffNameIn(List<String> values) {
            addCriterion("CHECK_STAFF_NAME in", values, "checkStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckStaffNameNotIn(List<String> values) {
            addCriterion("CHECK_STAFF_NAME not in", values, "checkStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckStaffNameBetween(String value1, String value2) {
            addCriterion("CHECK_STAFF_NAME between", value1, value2, "checkStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckStaffNameNotBetween(String value1, String value2) {
            addCriterion("CHECK_STAFF_NAME not between", value1, value2, "checkStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffIdIsNull() {
            addCriterion("CHECKED_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffIdIsNotNull() {
            addCriterion("CHECKED_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffIdEqualTo(String value) {
            addCriterion("CHECKED_STAFF_ID =", value, "checkedStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffIdNotEqualTo(String value) {
            addCriterion("CHECKED_STAFF_ID <>", value, "checkedStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffIdGreaterThan(String value) {
            addCriterion("CHECKED_STAFF_ID >", value, "checkedStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKED_STAFF_ID >=", value, "checkedStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffIdLessThan(String value) {
            addCriterion("CHECKED_STAFF_ID <", value, "checkedStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffIdLessThanOrEqualTo(String value) {
            addCriterion("CHECKED_STAFF_ID <=", value, "checkedStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffIdLike(String value) {
            addCriterion("CHECKED_STAFF_ID like", value, "checkedStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffIdNotLike(String value) {
            addCriterion("CHECKED_STAFF_ID not like", value, "checkedStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffIdIn(List<String> values) {
            addCriterion("CHECKED_STAFF_ID in", values, "checkedStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffIdNotIn(List<String> values) {
            addCriterion("CHECKED_STAFF_ID not in", values, "checkedStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffIdBetween(String value1, String value2) {
            addCriterion("CHECKED_STAFF_ID between", value1, value2, "checkedStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffIdNotBetween(String value1, String value2) {
            addCriterion("CHECKED_STAFF_ID not between", value1, value2, "checkedStaffId");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffNameIsNull() {
            addCriterion("CHECKED_STAFF_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffNameIsNotNull() {
            addCriterion("CHECKED_STAFF_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffNameEqualTo(String value) {
            addCriterion("CHECKED_STAFF_NAME =", value, "checkedStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffNameNotEqualTo(String value) {
            addCriterion("CHECKED_STAFF_NAME <>", value, "checkedStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffNameGreaterThan(String value) {
            addCriterion("CHECKED_STAFF_NAME >", value, "checkedStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKED_STAFF_NAME >=", value, "checkedStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffNameLessThan(String value) {
            addCriterion("CHECKED_STAFF_NAME <", value, "checkedStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffNameLessThanOrEqualTo(String value) {
            addCriterion("CHECKED_STAFF_NAME <=", value, "checkedStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffNameLike(String value) {
            addCriterion("CHECKED_STAFF_NAME like", value, "checkedStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffNameNotLike(String value) {
            addCriterion("CHECKED_STAFF_NAME not like", value, "checkedStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffNameIn(List<String> values) {
            addCriterion("CHECKED_STAFF_NAME in", values, "checkedStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffNameNotIn(List<String> values) {
            addCriterion("CHECKED_STAFF_NAME not in", values, "checkedStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffNameBetween(String value1, String value2) {
            addCriterion("CHECKED_STAFF_NAME between", value1, value2, "checkedStaffName");
            return (Criteria) this;
        }

        public Criteria andCheckedStaffNameNotBetween(String value1, String value2) {
            addCriterion("CHECKED_STAFF_NAME not between", value1, value2, "checkedStaffName");
            return (Criteria) this;
        }

        public Criteria andIsOperateIsNull() {
            addCriterion("IS_OPERATE is null");
            return (Criteria) this;
        }

        public Criteria andIsOperateIsNotNull() {
            addCriterion("IS_OPERATE is not null");
            return (Criteria) this;
        }

        public Criteria andIsOperateEqualTo(String value) {
            addCriterion("IS_OPERATE =", value, "isOperate");
            return (Criteria) this;
        }

        public Criteria andIsOperateNotEqualTo(String value) {
            addCriterion("IS_OPERATE <>", value, "isOperate");
            return (Criteria) this;
        }

        public Criteria andIsOperateGreaterThan(String value) {
            addCriterion("IS_OPERATE >", value, "isOperate");
            return (Criteria) this;
        }

        public Criteria andIsOperateGreaterThanOrEqualTo(String value) {
            addCriterion("IS_OPERATE >=", value, "isOperate");
            return (Criteria) this;
        }

        public Criteria andIsOperateLessThan(String value) {
            addCriterion("IS_OPERATE <", value, "isOperate");
            return (Criteria) this;
        }

        public Criteria andIsOperateLessThanOrEqualTo(String value) {
            addCriterion("IS_OPERATE <=", value, "isOperate");
            return (Criteria) this;
        }

        public Criteria andIsOperateLike(String value) {
            addCriterion("IS_OPERATE like", value, "isOperate");
            return (Criteria) this;
        }

        public Criteria andIsOperateNotLike(String value) {
            addCriterion("IS_OPERATE not like", value, "isOperate");
            return (Criteria) this;
        }

        public Criteria andIsOperateIn(List<String> values) {
            addCriterion("IS_OPERATE in", values, "isOperate");
            return (Criteria) this;
        }

        public Criteria andIsOperateNotIn(List<String> values) {
            addCriterion("IS_OPERATE not in", values, "isOperate");
            return (Criteria) this;
        }

        public Criteria andIsOperateBetween(String value1, String value2) {
            addCriterion("IS_OPERATE between", value1, value2, "isOperate");
            return (Criteria) this;
        }

        public Criteria andIsOperateNotBetween(String value1, String value2) {
            addCriterion("IS_OPERATE not between", value1, value2, "isOperate");
            return (Criteria) this;
        }

        public Criteria andHungupTypeIsNull() {
            addCriterion("HUNGUP_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andHungupTypeIsNotNull() {
            addCriterion("HUNGUP_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andHungupTypeEqualTo(String value) {
            addCriterion("HUNGUP_TYPE =", value, "hungupType");
            return (Criteria) this;
        }

        public Criteria andHungupTypeNotEqualTo(String value) {
            addCriterion("HUNGUP_TYPE <>", value, "hungupType");
            return (Criteria) this;
        }

        public Criteria andHungupTypeGreaterThan(String value) {
            addCriterion("HUNGUP_TYPE >", value, "hungupType");
            return (Criteria) this;
        }

        public Criteria andHungupTypeGreaterThanOrEqualTo(String value) {
            addCriterion("HUNGUP_TYPE >=", value, "hungupType");
            return (Criteria) this;
        }

        public Criteria andHungupTypeLessThan(String value) {
            addCriterion("HUNGUP_TYPE <", value, "hungupType");
            return (Criteria) this;
        }

        public Criteria andHungupTypeLessThanOrEqualTo(String value) {
            addCriterion("HUNGUP_TYPE <=", value, "hungupType");
            return (Criteria) this;
        }

        public Criteria andHungupTypeLike(String value) {
            addCriterion("HUNGUP_TYPE like", value, "hungupType");
            return (Criteria) this;
        }

        public Criteria andHungupTypeNotLike(String value) {
            addCriterion("HUNGUP_TYPE not like", value, "hungupType");
            return (Criteria) this;
        }

        public Criteria andHungupTypeIn(List<String> values) {
            addCriterion("HUNGUP_TYPE in", values, "hungupType");
            return (Criteria) this;
        }

        public Criteria andHungupTypeNotIn(List<String> values) {
            addCriterion("HUNGUP_TYPE not in", values, "hungupType");
            return (Criteria) this;
        }

        public Criteria andHungupTypeBetween(String value1, String value2) {
            addCriterion("HUNGUP_TYPE between", value1, value2, "hungupType");
            return (Criteria) this;
        }

        public Criteria andHungupTypeNotBetween(String value1, String value2) {
            addCriterion("HUNGUP_TYPE not between", value1, value2, "hungupType");
            return (Criteria) this;
        }

        public Criteria andCallTypeIsNull() {
            addCriterion("CALL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCallTypeIsNotNull() {
            addCriterion("CALL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCallTypeEqualTo(String value) {
            addCriterion("CALL_TYPE =", value, "callType");
            return (Criteria) this;
        }

        public Criteria andCallTypeNotEqualTo(String value) {
            addCriterion("CALL_TYPE <>", value, "callType");
            return (Criteria) this;
        }

        public Criteria andCallTypeGreaterThan(String value) {
            addCriterion("CALL_TYPE >", value, "callType");
            return (Criteria) this;
        }

        public Criteria andCallTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CALL_TYPE >=", value, "callType");
            return (Criteria) this;
        }

        public Criteria andCallTypeLessThan(String value) {
            addCriterion("CALL_TYPE <", value, "callType");
            return (Criteria) this;
        }

        public Criteria andCallTypeLessThanOrEqualTo(String value) {
            addCriterion("CALL_TYPE <=", value, "callType");
            return (Criteria) this;
        }

        public Criteria andCallTypeLike(String value) {
            addCriterion("CALL_TYPE like", value, "callType");
            return (Criteria) this;
        }

        public Criteria andCallTypeNotLike(String value) {
            addCriterion("CALL_TYPE not like", value, "callType");
            return (Criteria) this;
        }

        public Criteria andCallTypeIn(List<String> values) {
            addCriterion("CALL_TYPE in", values, "callType");
            return (Criteria) this;
        }

        public Criteria andCallTypeNotIn(List<String> values) {
            addCriterion("CALL_TYPE not in", values, "callType");
            return (Criteria) this;
        }

        public Criteria andCallTypeBetween(String value1, String value2) {
            addCriterion("CALL_TYPE between", value1, value2, "callType");
            return (Criteria) this;
        }

        public Criteria andCallTypeNotBetween(String value1, String value2) {
            addCriterion("CALL_TYPE not between", value1, value2, "callType");
            return (Criteria) this;
        }

        public Criteria andVoiceSatisfyExtentIsNull() {
            addCriterion("VOICE_SATISFY_EXTENT is null");
            return (Criteria) this;
        }

        public Criteria andVoiceSatisfyExtentIsNotNull() {
            addCriterion("VOICE_SATISFY_EXTENT is not null");
            return (Criteria) this;
        }

        public Criteria andVoiceSatisfyExtentEqualTo(String value) {
            addCriterion("VOICE_SATISFY_EXTENT =", value, "voiceSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVoiceSatisfyExtentNotEqualTo(String value) {
            addCriterion("VOICE_SATISFY_EXTENT <>", value, "voiceSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVoiceSatisfyExtentGreaterThan(String value) {
            addCriterion("VOICE_SATISFY_EXTENT >", value, "voiceSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVoiceSatisfyExtentGreaterThanOrEqualTo(String value) {
            addCriterion("VOICE_SATISFY_EXTENT >=", value, "voiceSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVoiceSatisfyExtentLessThan(String value) {
            addCriterion("VOICE_SATISFY_EXTENT <", value, "voiceSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVoiceSatisfyExtentLessThanOrEqualTo(String value) {
            addCriterion("VOICE_SATISFY_EXTENT <=", value, "voiceSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVoiceSatisfyExtentLike(String value) {
            addCriterion("VOICE_SATISFY_EXTENT like", value, "voiceSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVoiceSatisfyExtentNotLike(String value) {
            addCriterion("VOICE_SATISFY_EXTENT not like", value, "voiceSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVoiceSatisfyExtentIn(List<String> values) {
            addCriterion("VOICE_SATISFY_EXTENT in", values, "voiceSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVoiceSatisfyExtentNotIn(List<String> values) {
            addCriterion("VOICE_SATISFY_EXTENT not in", values, "voiceSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVoiceSatisfyExtentBetween(String value1, String value2) {
            addCriterion("VOICE_SATISFY_EXTENT between", value1, value2, "voiceSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVoiceSatisfyExtentNotBetween(String value1, String value2) {
            addCriterion("VOICE_SATISFY_EXTENT not between", value1, value2, "voiceSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNull() {
            addCriterion("RECORD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("RECORD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(Integer value) {
            addCriterion("RECORD_TIME =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(Integer value) {
            addCriterion("RECORD_TIME <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(Integer value) {
            addCriterion("RECORD_TIME >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECORD_TIME >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(Integer value) {
            addCriterion("RECORD_TIME <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(Integer value) {
            addCriterion("RECORD_TIME <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<Integer> values) {
            addCriterion("RECORD_TIME in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<Integer> values) {
            addCriterion("RECORD_TIME not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(Integer value1, Integer value2) {
            addCriterion("RECORD_TIME between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("RECORD_TIME not between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andCallingNumberIsNull() {
            addCriterion("CALLING_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andCallingNumberIsNotNull() {
            addCriterion("CALLING_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andCallingNumberEqualTo(String value) {
            addCriterion("CALLING_NUMBER =", value, "callingNumber");
            return (Criteria) this;
        }

        public Criteria andCallingNumberNotEqualTo(String value) {
            addCriterion("CALLING_NUMBER <>", value, "callingNumber");
            return (Criteria) this;
        }

        public Criteria andCallingNumberGreaterThan(String value) {
            addCriterion("CALLING_NUMBER >", value, "callingNumber");
            return (Criteria) this;
        }

        public Criteria andCallingNumberGreaterThanOrEqualTo(String value) {
            addCriterion("CALLING_NUMBER >=", value, "callingNumber");
            return (Criteria) this;
        }

        public Criteria andCallingNumberLessThan(String value) {
            addCriterion("CALLING_NUMBER <", value, "callingNumber");
            return (Criteria) this;
        }

        public Criteria andCallingNumberLessThanOrEqualTo(String value) {
            addCriterion("CALLING_NUMBER <=", value, "callingNumber");
            return (Criteria) this;
        }

        public Criteria andCallingNumberLike(String value) {
            addCriterion("CALLING_NUMBER like", value, "callingNumber");
            return (Criteria) this;
        }

        public Criteria andCallingNumberNotLike(String value) {
            addCriterion("CALLING_NUMBER not like", value, "callingNumber");
            return (Criteria) this;
        }

        public Criteria andCallingNumberIn(List<String> values) {
            addCriterion("CALLING_NUMBER in", values, "callingNumber");
            return (Criteria) this;
        }

        public Criteria andCallingNumberNotIn(List<String> values) {
            addCriterion("CALLING_NUMBER not in", values, "callingNumber");
            return (Criteria) this;
        }

        public Criteria andCallingNumberBetween(String value1, String value2) {
            addCriterion("CALLING_NUMBER between", value1, value2, "callingNumber");
            return (Criteria) this;
        }

        public Criteria andCallingNumberNotBetween(String value1, String value2) {
            addCriterion("CALLING_NUMBER not between", value1, value2, "callingNumber");
            return (Criteria) this;
        }

        public Criteria andCalledNumberIsNull() {
            addCriterion("CALLED_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andCalledNumberIsNotNull() {
            addCriterion("CALLED_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andCalledNumberEqualTo(String value) {
            addCriterion("CALLED_NUMBER =", value, "calledNumber");
            return (Criteria) this;
        }

        public Criteria andCalledNumberNotEqualTo(String value) {
            addCriterion("CALLED_NUMBER <>", value, "calledNumber");
            return (Criteria) this;
        }

        public Criteria andCalledNumberGreaterThan(String value) {
            addCriterion("CALLED_NUMBER >", value, "calledNumber");
            return (Criteria) this;
        }

        public Criteria andCalledNumberGreaterThanOrEqualTo(String value) {
            addCriterion("CALLED_NUMBER >=", value, "calledNumber");
            return (Criteria) this;
        }

        public Criteria andCalledNumberLessThan(String value) {
            addCriterion("CALLED_NUMBER <", value, "calledNumber");
            return (Criteria) this;
        }

        public Criteria andCalledNumberLessThanOrEqualTo(String value) {
            addCriterion("CALLED_NUMBER <=", value, "calledNumber");
            return (Criteria) this;
        }

        public Criteria andCalledNumberLike(String value) {
            addCriterion("CALLED_NUMBER like", value, "calledNumber");
            return (Criteria) this;
        }

        public Criteria andCalledNumberNotLike(String value) {
            addCriterion("CALLED_NUMBER not like", value, "calledNumber");
            return (Criteria) this;
        }

        public Criteria andCalledNumberIn(List<String> values) {
            addCriterion("CALLED_NUMBER in", values, "calledNumber");
            return (Criteria) this;
        }

        public Criteria andCalledNumberNotIn(List<String> values) {
            addCriterion("CALLED_NUMBER not in", values, "calledNumber");
            return (Criteria) this;
        }

        public Criteria andCalledNumberBetween(String value1, String value2) {
            addCriterion("CALLED_NUMBER between", value1, value2, "calledNumber");
            return (Criteria) this;
        }

        public Criteria andCalledNumberNotBetween(String value1, String value2) {
            addCriterion("CALLED_NUMBER not between", value1, value2, "calledNumber");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentTypeIsNull() {
            addCriterion("SATISFY_EXTENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentTypeIsNotNull() {
            addCriterion("SATISFY_EXTENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentTypeEqualTo(String value) {
            addCriterion("SATISFY_EXTENT_TYPE =", value, "satisfyExtentType");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentTypeNotEqualTo(String value) {
            addCriterion("SATISFY_EXTENT_TYPE <>", value, "satisfyExtentType");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentTypeGreaterThan(String value) {
            addCriterion("SATISFY_EXTENT_TYPE >", value, "satisfyExtentType");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SATISFY_EXTENT_TYPE >=", value, "satisfyExtentType");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentTypeLessThan(String value) {
            addCriterion("SATISFY_EXTENT_TYPE <", value, "satisfyExtentType");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentTypeLessThanOrEqualTo(String value) {
            addCriterion("SATISFY_EXTENT_TYPE <=", value, "satisfyExtentType");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentTypeLike(String value) {
            addCriterion("SATISFY_EXTENT_TYPE like", value, "satisfyExtentType");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentTypeNotLike(String value) {
            addCriterion("SATISFY_EXTENT_TYPE not like", value, "satisfyExtentType");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentTypeIn(List<String> values) {
            addCriterion("SATISFY_EXTENT_TYPE in", values, "satisfyExtentType");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentTypeNotIn(List<String> values) {
            addCriterion("SATISFY_EXTENT_TYPE not in", values, "satisfyExtentType");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentTypeBetween(String value1, String value2) {
            addCriterion("SATISFY_EXTENT_TYPE between", value1, value2, "satisfyExtentType");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentTypeNotBetween(String value1, String value2) {
            addCriterion("SATISFY_EXTENT_TYPE not between", value1, value2, "satisfyExtentType");
            return (Criteria) this;
        }

        public Criteria andVipSatisfyExtentIsNull() {
            addCriterion("VIP_SATISFY_EXTENT is null");
            return (Criteria) this;
        }

        public Criteria andVipSatisfyExtentIsNotNull() {
            addCriterion("VIP_SATISFY_EXTENT is not null");
            return (Criteria) this;
        }

        public Criteria andVipSatisfyExtentEqualTo(String value) {
            addCriterion("VIP_SATISFY_EXTENT =", value, "vipSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVipSatisfyExtentNotEqualTo(String value) {
            addCriterion("VIP_SATISFY_EXTENT <>", value, "vipSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVipSatisfyExtentGreaterThan(String value) {
            addCriterion("VIP_SATISFY_EXTENT >", value, "vipSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVipSatisfyExtentGreaterThanOrEqualTo(String value) {
            addCriterion("VIP_SATISFY_EXTENT >=", value, "vipSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVipSatisfyExtentLessThan(String value) {
            addCriterion("VIP_SATISFY_EXTENT <", value, "vipSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVipSatisfyExtentLessThanOrEqualTo(String value) {
            addCriterion("VIP_SATISFY_EXTENT <=", value, "vipSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVipSatisfyExtentLike(String value) {
            addCriterion("VIP_SATISFY_EXTENT like", value, "vipSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVipSatisfyExtentNotLike(String value) {
            addCriterion("VIP_SATISFY_EXTENT not like", value, "vipSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVipSatisfyExtentIn(List<String> values) {
            addCriterion("VIP_SATISFY_EXTENT in", values, "vipSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVipSatisfyExtentNotIn(List<String> values) {
            addCriterion("VIP_SATISFY_EXTENT not in", values, "vipSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVipSatisfyExtentBetween(String value1, String value2) {
            addCriterion("VIP_SATISFY_EXTENT between", value1, value2, "vipSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andVipSatisfyExtentNotBetween(String value1, String value2) {
            addCriterion("VIP_SATISFY_EXTENT not between", value1, value2, "vipSatisfyExtent");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIsNull() {
            addCriterion("MEDIA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIsNotNull() {
            addCriterion("MEDIA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMediaTypeEqualTo(String value) {
            addCriterion("MEDIA_TYPE =", value, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeNotEqualTo(String value) {
            addCriterion("MEDIA_TYPE <>", value, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeGreaterThan(String value) {
            addCriterion("MEDIA_TYPE >", value, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MEDIA_TYPE >=", value, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeLessThan(String value) {
            addCriterion("MEDIA_TYPE <", value, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeLessThanOrEqualTo(String value) {
            addCriterion("MEDIA_TYPE <=", value, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeLike(String value) {
            addCriterion("MEDIA_TYPE like", value, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeNotLike(String value) {
            addCriterion("MEDIA_TYPE not like", value, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIn(List<String> values) {
            addCriterion("MEDIA_TYPE in", values, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeNotIn(List<String> values) {
            addCriterion("MEDIA_TYPE not in", values, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeBetween(String value1, String value2) {
            addCriterion("MEDIA_TYPE between", value1, value2, "mediaType");
            return (Criteria) this;
        }

        public Criteria andMediaTypeNotBetween(String value1, String value2) {
            addCriterion("MEDIA_TYPE not between", value1, value2, "mediaType");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeIdIsNull() {
            addCriterion("SRV_REQST_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeIdIsNotNull() {
            addCriterion("SRV_REQST_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeIdEqualTo(String value) {
            addCriterion("SRV_REQST_TYPE_ID =", value, "srvReqstTypeId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeIdNotEqualTo(String value) {
            addCriterion("SRV_REQST_TYPE_ID <>", value, "srvReqstTypeId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeIdGreaterThan(String value) {
            addCriterion("SRV_REQST_TYPE_ID >", value, "srvReqstTypeId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("SRV_REQST_TYPE_ID >=", value, "srvReqstTypeId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeIdLessThan(String value) {
            addCriterion("SRV_REQST_TYPE_ID <", value, "srvReqstTypeId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeIdLessThanOrEqualTo(String value) {
            addCriterion("SRV_REQST_TYPE_ID <=", value, "srvReqstTypeId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeIdLike(String value) {
            addCriterion("SRV_REQST_TYPE_ID like", value, "srvReqstTypeId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeIdNotLike(String value) {
            addCriterion("SRV_REQST_TYPE_ID not like", value, "srvReqstTypeId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeIdIn(List<String> values) {
            addCriterion("SRV_REQST_TYPE_ID in", values, "srvReqstTypeId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeIdNotIn(List<String> values) {
            addCriterion("SRV_REQST_TYPE_ID not in", values, "srvReqstTypeId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeIdBetween(String value1, String value2) {
            addCriterion("SRV_REQST_TYPE_ID between", value1, value2, "srvReqstTypeId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeIdNotBetween(String value1, String value2) {
            addCriterion("SRV_REQST_TYPE_ID not between", value1, value2, "srvReqstTypeId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeNmIsNull() {
            addCriterion("SRV_REQST_TYPE_NM is null");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeNmIsNotNull() {
            addCriterion("SRV_REQST_TYPE_NM is not null");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeNmEqualTo(String value) {
            addCriterion("SRV_REQST_TYPE_NM =", value, "srvReqstTypeNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeNmNotEqualTo(String value) {
            addCriterion("SRV_REQST_TYPE_NM <>", value, "srvReqstTypeNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeNmGreaterThan(String value) {
            addCriterion("SRV_REQST_TYPE_NM >", value, "srvReqstTypeNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeNmGreaterThanOrEqualTo(String value) {
            addCriterion("SRV_REQST_TYPE_NM >=", value, "srvReqstTypeNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeNmLessThan(String value) {
            addCriterion("SRV_REQST_TYPE_NM <", value, "srvReqstTypeNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeNmLessThanOrEqualTo(String value) {
            addCriterion("SRV_REQST_TYPE_NM <=", value, "srvReqstTypeNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeNmLike(String value) {
            addCriterion("SRV_REQST_TYPE_NM like", value, "srvReqstTypeNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeNmNotLike(String value) {
            addCriterion("SRV_REQST_TYPE_NM not like", value, "srvReqstTypeNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeNmIn(List<String> values) {
            addCriterion("SRV_REQST_TYPE_NM in", values, "srvReqstTypeNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeNmNotIn(List<String> values) {
            addCriterion("SRV_REQST_TYPE_NM not in", values, "srvReqstTypeNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeNmBetween(String value1, String value2) {
            addCriterion("SRV_REQST_TYPE_NM between", value1, value2, "srvReqstTypeNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeNmNotBetween(String value1, String value2) {
            addCriterion("SRV_REQST_TYPE_NM not between", value1, value2, "srvReqstTypeNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeFullNmIsNull() {
            addCriterion("SRV_REQST_TYPE_FULL_NM is null");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeFullNmIsNotNull() {
            addCriterion("SRV_REQST_TYPE_FULL_NM is not null");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeFullNmEqualTo(String value) {
            addCriterion("SRV_REQST_TYPE_FULL_NM =", value, "srvReqstTypeFullNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeFullNmNotEqualTo(String value) {
            addCriterion("SRV_REQST_TYPE_FULL_NM <>", value, "srvReqstTypeFullNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeFullNmGreaterThan(String value) {
            addCriterion("SRV_REQST_TYPE_FULL_NM >", value, "srvReqstTypeFullNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeFullNmGreaterThanOrEqualTo(String value) {
            addCriterion("SRV_REQST_TYPE_FULL_NM >=", value, "srvReqstTypeFullNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeFullNmLessThan(String value) {
            addCriterion("SRV_REQST_TYPE_FULL_NM <", value, "srvReqstTypeFullNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeFullNmLessThanOrEqualTo(String value) {
            addCriterion("SRV_REQST_TYPE_FULL_NM <=", value, "srvReqstTypeFullNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeFullNmLike(String value) {
            addCriterion("SRV_REQST_TYPE_FULL_NM like", value, "srvReqstTypeFullNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeFullNmNotLike(String value) {
            addCriterion("SRV_REQST_TYPE_FULL_NM not like", value, "srvReqstTypeFullNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeFullNmIn(List<String> values) {
            addCriterion("SRV_REQST_TYPE_FULL_NM in", values, "srvReqstTypeFullNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeFullNmNotIn(List<String> values) {
            addCriterion("SRV_REQST_TYPE_FULL_NM not in", values, "srvReqstTypeFullNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeFullNmBetween(String value1, String value2) {
            addCriterion("SRV_REQST_TYPE_FULL_NM between", value1, value2, "srvReqstTypeFullNm");
            return (Criteria) this;
        }

        public Criteria andSrvReqstTypeFullNmNotBetween(String value1, String value2) {
            addCriterion("SRV_REQST_TYPE_FULL_NM not between", value1, value2, "srvReqstTypeFullNm");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeIsNull() {
            addCriterion("CHECKED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeIsNotNull() {
            addCriterion("CHECKED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeEqualTo(Date value) {
            addCriterion("CHECKED_TIME =", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeNotEqualTo(Date value) {
            addCriterion("CHECKED_TIME <>", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeGreaterThan(Date value) {
            addCriterion("CHECKED_TIME >", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECKED_TIME >=", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeLessThan(Date value) {
            addCriterion("CHECKED_TIME <", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHECKED_TIME <=", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeIn(List<Date> values) {
            addCriterion("CHECKED_TIME in", values, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeNotIn(List<Date> values) {
            addCriterion("CHECKED_TIME not in", values, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeBetween(Date value1, Date value2) {
            addCriterion("CHECKED_TIME between", value1, value2, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHECKED_TIME not between", value1, value2, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNull() {
            addCriterion("OPERATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNotNull() {
            addCriterion("OPERATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeEqualTo(Date value) {
            addCriterion("OPERATE_TIME =", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotEqualTo(Date value) {
            addCriterion("OPERATE_TIME <>", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThan(Date value) {
            addCriterion("OPERATE_TIME >", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OPERATE_TIME >=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThan(Date value) {
            addCriterion("OPERATE_TIME <", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("OPERATE_TIME <=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIn(List<Date> values) {
            addCriterion("OPERATE_TIME in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotIn(List<Date> values) {
            addCriterion("OPERATE_TIME not in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeBetween(Date value1, Date value2) {
            addCriterion("OPERATE_TIME between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("OPERATE_TIME not between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andStrategyNameIsNull() {
            addCriterion("STRATEGY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStrategyNameIsNotNull() {
            addCriterion("STRATEGY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyNameEqualTo(String value) {
            addCriterion("STRATEGY_NAME =", value, "strategyName");
            return (Criteria) this;
        }

        public Criteria andStrategyNameNotEqualTo(String value) {
            addCriterion("STRATEGY_NAME <>", value, "strategyName");
            return (Criteria) this;
        }

        public Criteria andStrategyNameGreaterThan(String value) {
            addCriterion("STRATEGY_NAME >", value, "strategyName");
            return (Criteria) this;
        }

        public Criteria andStrategyNameGreaterThanOrEqualTo(String value) {
            addCriterion("STRATEGY_NAME >=", value, "strategyName");
            return (Criteria) this;
        }

        public Criteria andStrategyNameLessThan(String value) {
            addCriterion("STRATEGY_NAME <", value, "strategyName");
            return (Criteria) this;
        }

        public Criteria andStrategyNameLessThanOrEqualTo(String value) {
            addCriterion("STRATEGY_NAME <=", value, "strategyName");
            return (Criteria) this;
        }

        public Criteria andStrategyNameLike(String value) {
            addCriterion("STRATEGY_NAME like", value, "strategyName");
            return (Criteria) this;
        }

        public Criteria andStrategyNameNotLike(String value) {
            addCriterion("STRATEGY_NAME not like", value, "strategyName");
            return (Criteria) this;
        }

        public Criteria andStrategyNameIn(List<String> values) {
            addCriterion("STRATEGY_NAME in", values, "strategyName");
            return (Criteria) this;
        }

        public Criteria andStrategyNameNotIn(List<String> values) {
            addCriterion("STRATEGY_NAME not in", values, "strategyName");
            return (Criteria) this;
        }

        public Criteria andStrategyNameBetween(String value1, String value2) {
            addCriterion("STRATEGY_NAME between", value1, value2, "strategyName");
            return (Criteria) this;
        }

        public Criteria andStrategyNameNotBetween(String value1, String value2) {
            addCriterion("STRATEGY_NAME not between", value1, value2, "strategyName");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNull() {
            addCriterion("ORG_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNotNull() {
            addCriterion("ORG_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeEqualTo(String value) {
            addCriterion("ORG_TYPE =", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotEqualTo(String value) {
            addCriterion("ORG_TYPE <>", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThan(String value) {
            addCriterion("ORG_TYPE >", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_TYPE >=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThan(String value) {
            addCriterion("ORG_TYPE <", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThanOrEqualTo(String value) {
            addCriterion("ORG_TYPE <=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLike(String value) {
            addCriterion("ORG_TYPE like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotLike(String value) {
            addCriterion("ORG_TYPE not like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIn(List<String> values) {
            addCriterion("ORG_TYPE in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotIn(List<String> values) {
            addCriterion("ORG_TYPE not in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeBetween(String value1, String value2) {
            addCriterion("ORG_TYPE between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotBetween(String value1, String value2) {
            addCriterion("ORG_TYPE not between", value1, value2, "orgType");
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