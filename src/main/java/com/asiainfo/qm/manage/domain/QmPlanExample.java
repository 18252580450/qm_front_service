package com.asiainfo.qm.manage.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class QmPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QmPlanExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andPlanNameIsNull() {
            addCriterion("PLAN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPlanNameIsNotNull() {
            addCriterion("PLAN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNameEqualTo(String value) {
            addCriterion("PLAN_NAME =", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotEqualTo(String value) {
            addCriterion("PLAN_NAME <>", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThan(String value) {
            addCriterion("PLAN_NAME >", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThanOrEqualTo(String value) {
            addCriterion("PLAN_NAME >=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThan(String value) {
            addCriterion("PLAN_NAME <", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThanOrEqualTo(String value) {
            addCriterion("PLAN_NAME <=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLike(String value) {
            addCriterion("PLAN_NAME like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotLike(String value) {
            addCriterion("PLAN_NAME not like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameIn(List<String> values) {
            addCriterion("PLAN_NAME in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotIn(List<String> values) {
            addCriterion("PLAN_NAME not in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameBetween(String value1, String value2) {
            addCriterion("PLAN_NAME between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotBetween(String value1, String value2) {
            addCriterion("PLAN_NAME not between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdIsNull() {
            addCriterion("CREATE_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdIsNotNull() {
            addCriterion("CREATE_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdEqualTo(String value) {
            addCriterion("CREATE_STAFF_ID =", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotEqualTo(String value) {
            addCriterion("CREATE_STAFF_ID <>", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdGreaterThan(String value) {
            addCriterion("CREATE_STAFF_ID >", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_STAFF_ID >=", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdLessThan(String value) {
            addCriterion("CREATE_STAFF_ID <", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_STAFF_ID <=", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdLike(String value) {
            addCriterion("CREATE_STAFF_ID like", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotLike(String value) {
            addCriterion("CREATE_STAFF_ID not like", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdIn(List<String> values) {
            addCriterion("CREATE_STAFF_ID in", values, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotIn(List<String> values) {
            addCriterion("CREATE_STAFF_ID not in", values, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdBetween(String value1, String value2) {
            addCriterion("CREATE_STAFF_ID between", value1, value2, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_STAFF_ID not between", value1, value2, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("MODIFIED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("MODIFIED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("MODIFIED_TIME =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("MODIFIED_TIME <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("MODIFIED_TIME >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFIED_TIME >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("MODIFIED_TIME <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFIED_TIME <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("MODIFIED_TIME in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("MODIFIED_TIME not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFIED_TIME between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFIED_TIME not between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedStaffIdIsNull() {
            addCriterion("MODIFIED_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andModifiedStaffIdIsNotNull() {
            addCriterion("MODIFIED_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedStaffIdEqualTo(String value) {
            addCriterion("MODIFIED_STAFF_ID =", value, "modifiedStaffId");
            return (Criteria) this;
        }

        public Criteria andModifiedStaffIdNotEqualTo(String value) {
            addCriterion("MODIFIED_STAFF_ID <>", value, "modifiedStaffId");
            return (Criteria) this;
        }

        public Criteria andModifiedStaffIdGreaterThan(String value) {
            addCriterion("MODIFIED_STAFF_ID >", value, "modifiedStaffId");
            return (Criteria) this;
        }

        public Criteria andModifiedStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIED_STAFF_ID >=", value, "modifiedStaffId");
            return (Criteria) this;
        }

        public Criteria andModifiedStaffIdLessThan(String value) {
            addCriterion("MODIFIED_STAFF_ID <", value, "modifiedStaffId");
            return (Criteria) this;
        }

        public Criteria andModifiedStaffIdLessThanOrEqualTo(String value) {
            addCriterion("MODIFIED_STAFF_ID <=", value, "modifiedStaffId");
            return (Criteria) this;
        }

        public Criteria andModifiedStaffIdLike(String value) {
            addCriterion("MODIFIED_STAFF_ID like", value, "modifiedStaffId");
            return (Criteria) this;
        }

        public Criteria andModifiedStaffIdNotLike(String value) {
            addCriterion("MODIFIED_STAFF_ID not like", value, "modifiedStaffId");
            return (Criteria) this;
        }

        public Criteria andModifiedStaffIdIn(List<String> values) {
            addCriterion("MODIFIED_STAFF_ID in", values, "modifiedStaffId");
            return (Criteria) this;
        }

        public Criteria andModifiedStaffIdNotIn(List<String> values) {
            addCriterion("MODIFIED_STAFF_ID not in", values, "modifiedStaffId");
            return (Criteria) this;
        }

        public Criteria andModifiedStaffIdBetween(String value1, String value2) {
            addCriterion("MODIFIED_STAFF_ID between", value1, value2, "modifiedStaffId");
            return (Criteria) this;
        }

        public Criteria andModifiedStaffIdNotBetween(String value1, String value2) {
            addCriterion("MODIFIED_STAFF_ID not between", value1, value2, "modifiedStaffId");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeIsNull() {
            addCriterion("PLAN_STARTTIME is null");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeIsNotNull() {
            addCriterion("PLAN_STARTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeEqualTo(Date value) {
            addCriterion("PLAN_STARTTIME =", value, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeNotEqualTo(Date value) {
            addCriterion("PLAN_STARTTIME <>", value, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeGreaterThan(Date value) {
            addCriterion("PLAN_STARTTIME >", value, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PLAN_STARTTIME >=", value, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeLessThan(Date value) {
            addCriterion("PLAN_STARTTIME <", value, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("PLAN_STARTTIME <=", value, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeIn(List<Date> values) {
            addCriterion("PLAN_STARTTIME in", values, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeNotIn(List<Date> values) {
            addCriterion("PLAN_STARTTIME not in", values, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeBetween(Date value1, Date value2) {
            addCriterion("PLAN_STARTTIME between", value1, value2, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("PLAN_STARTTIME not between", value1, value2, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeIsNull() {
            addCriterion("PLAN_ENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeIsNotNull() {
            addCriterion("PLAN_ENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeEqualTo(Date value) {
            addCriterion("PLAN_ENDTIME =", value, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeNotEqualTo(Date value) {
            addCriterion("PLAN_ENDTIME <>", value, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeGreaterThan(Date value) {
            addCriterion("PLAN_ENDTIME >", value, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PLAN_ENDTIME >=", value, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeLessThan(Date value) {
            addCriterion("PLAN_ENDTIME <", value, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("PLAN_ENDTIME <=", value, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeIn(List<Date> values) {
            addCriterion("PLAN_ENDTIME in", values, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeNotIn(List<Date> values) {
            addCriterion("PLAN_ENDTIME not in", values, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeBetween(Date value1, Date value2) {
            addCriterion("PLAN_ENDTIME between", value1, value2, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("PLAN_ENDTIME not between", value1, value2, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNull() {
            addCriterion("PLAN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNotNull() {
            addCriterion("PLAN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeEqualTo(String value) {
            addCriterion("PLAN_TYPE =", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotEqualTo(String value) {
            addCriterion("PLAN_TYPE <>", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThan(String value) {
            addCriterion("PLAN_TYPE >", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PLAN_TYPE >=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThan(String value) {
            addCriterion("PLAN_TYPE <", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThanOrEqualTo(String value) {
            addCriterion("PLAN_TYPE <=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLike(String value) {
            addCriterion("PLAN_TYPE like", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotLike(String value) {
            addCriterion("PLAN_TYPE not like", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIn(List<String> values) {
            addCriterion("PLAN_TYPE in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotIn(List<String> values) {
            addCriterion("PLAN_TYPE not in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeBetween(String value1, String value2) {
            addCriterion("PLAN_TYPE between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotBetween(String value1, String value2) {
            addCriterion("PLAN_TYPE not between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIsNull() {
            addCriterion("TEMPLATE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIsNotNull() {
            addCriterion("TEMPLATE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameEqualTo(String value) {
            addCriterion("TEMPLATE_NAME =", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotEqualTo(String value) {
            addCriterion("TEMPLATE_NAME <>", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThan(String value) {
            addCriterion("TEMPLATE_NAME >", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPLATE_NAME >=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThan(String value) {
            addCriterion("TEMPLATE_NAME <", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThanOrEqualTo(String value) {
            addCriterion("TEMPLATE_NAME <=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLike(String value) {
            addCriterion("TEMPLATE_NAME like", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotLike(String value) {
            addCriterion("TEMPLATE_NAME not like", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIn(List<String> values) {
            addCriterion("TEMPLATE_NAME in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotIn(List<String> values) {
            addCriterion("TEMPLATE_NAME not in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameBetween(String value1, String value2) {
            addCriterion("TEMPLATE_NAME between", value1, value2, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotBetween(String value1, String value2) {
            addCriterion("TEMPLATE_NAME not between", value1, value2, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNull() {
            addCriterion("TEMPLATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("TEMPLATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(String value) {
            addCriterion("TEMPLATE_ID =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(String value) {
            addCriterion("TEMPLATE_ID <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(String value) {
            addCriterion("TEMPLATE_ID >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPLATE_ID >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(String value) {
            addCriterion("TEMPLATE_ID <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(String value) {
            addCriterion("TEMPLATE_ID <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLike(String value) {
            addCriterion("TEMPLATE_ID like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotLike(String value) {
            addCriterion("TEMPLATE_ID not like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<String> values) {
            addCriterion("TEMPLATE_ID in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<String> values) {
            addCriterion("TEMPLATE_ID not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(String value1, String value2) {
            addCriterion("TEMPLATE_ID between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(String value1, String value2) {
            addCriterion("TEMPLATE_ID not between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andPNameIsNull() {
            addCriterion("P_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("P_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("P_NAME =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("P_NAME <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("P_NAME >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("P_NAME >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("P_NAME <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("P_NAME <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("P_NAME like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("P_NAME not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("P_NAME in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("P_NAME not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("P_NAME between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("P_NAME not between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("P_ID is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("P_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(String value) {
            addCriterion("P_ID =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(String value) {
            addCriterion("P_ID <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(String value) {
            addCriterion("P_ID >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(String value) {
            addCriterion("P_ID >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(String value) {
            addCriterion("P_ID <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(String value) {
            addCriterion("P_ID <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLike(String value) {
            addCriterion("P_ID like", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotLike(String value) {
            addCriterion("P_ID not like", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<String> values) {
            addCriterion("P_ID in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<String> values) {
            addCriterion("P_ID not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(String value1, String value2) {
            addCriterion("P_ID between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(String value1, String value2) {
            addCriterion("P_ID not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andManOrAutoIsNull() {
            addCriterion("MAN_OR_AUTO is null");
            return (Criteria) this;
        }

        public Criteria andManOrAutoIsNotNull() {
            addCriterion("MAN_OR_AUTO is not null");
            return (Criteria) this;
        }

        public Criteria andManOrAutoEqualTo(String value) {
            addCriterion("MAN_OR_AUTO =", value, "manOrAuto");
            return (Criteria) this;
        }

        public Criteria andManOrAutoNotEqualTo(String value) {
            addCriterion("MAN_OR_AUTO <>", value, "manOrAuto");
            return (Criteria) this;
        }

        public Criteria andManOrAutoGreaterThan(String value) {
            addCriterion("MAN_OR_AUTO >", value, "manOrAuto");
            return (Criteria) this;
        }

        public Criteria andManOrAutoGreaterThanOrEqualTo(String value) {
            addCriterion("MAN_OR_AUTO >=", value, "manOrAuto");
            return (Criteria) this;
        }

        public Criteria andManOrAutoLessThan(String value) {
            addCriterion("MAN_OR_AUTO <", value, "manOrAuto");
            return (Criteria) this;
        }

        public Criteria andManOrAutoLessThanOrEqualTo(String value) {
            addCriterion("MAN_OR_AUTO <=", value, "manOrAuto");
            return (Criteria) this;
        }

        public Criteria andManOrAutoLike(String value) {
            addCriterion("MAN_OR_AUTO like", value, "manOrAuto");
            return (Criteria) this;
        }

        public Criteria andManOrAutoNotLike(String value) {
            addCriterion("MAN_OR_AUTO not like", value, "manOrAuto");
            return (Criteria) this;
        }

        public Criteria andManOrAutoIn(List<String> values) {
            addCriterion("MAN_OR_AUTO in", values, "manOrAuto");
            return (Criteria) this;
        }

        public Criteria andManOrAutoNotIn(List<String> values) {
            addCriterion("MAN_OR_AUTO not in", values, "manOrAuto");
            return (Criteria) this;
        }

        public Criteria andManOrAutoBetween(String value1, String value2) {
            addCriterion("MAN_OR_AUTO between", value1, value2, "manOrAuto");
            return (Criteria) this;
        }

        public Criteria andManOrAutoNotBetween(String value1, String value2) {
            addCriterion("MAN_OR_AUTO not between", value1, value2, "manOrAuto");
            return (Criteria) this;
        }

        public Criteria andBindRelationIsNull() {
            addCriterion("BIND_RELATION is null");
            return (Criteria) this;
        }

        public Criteria andBindRelationIsNotNull() {
            addCriterion("BIND_RELATION is not null");
            return (Criteria) this;
        }

        public Criteria andBindRelationEqualTo(String value) {
            addCriterion("BIND_RELATION =", value, "bindRelation");
            return (Criteria) this;
        }

        public Criteria andBindRelationNotEqualTo(String value) {
            addCriterion("BIND_RELATION <>", value, "bindRelation");
            return (Criteria) this;
        }

        public Criteria andBindRelationGreaterThan(String value) {
            addCriterion("BIND_RELATION >", value, "bindRelation");
            return (Criteria) this;
        }

        public Criteria andBindRelationGreaterThanOrEqualTo(String value) {
            addCriterion("BIND_RELATION >=", value, "bindRelation");
            return (Criteria) this;
        }

        public Criteria andBindRelationLessThan(String value) {
            addCriterion("BIND_RELATION <", value, "bindRelation");
            return (Criteria) this;
        }

        public Criteria andBindRelationLessThanOrEqualTo(String value) {
            addCriterion("BIND_RELATION <=", value, "bindRelation");
            return (Criteria) this;
        }

        public Criteria andBindRelationLike(String value) {
            addCriterion("BIND_RELATION like", value, "bindRelation");
            return (Criteria) this;
        }

        public Criteria andBindRelationNotLike(String value) {
            addCriterion("BIND_RELATION not like", value, "bindRelation");
            return (Criteria) this;
        }

        public Criteria andBindRelationIn(List<String> values) {
            addCriterion("BIND_RELATION in", values, "bindRelation");
            return (Criteria) this;
        }

        public Criteria andBindRelationNotIn(List<String> values) {
            addCriterion("BIND_RELATION not in", values, "bindRelation");
            return (Criteria) this;
        }

        public Criteria andBindRelationBetween(String value1, String value2) {
            addCriterion("BIND_RELATION between", value1, value2, "bindRelation");
            return (Criteria) this;
        }

        public Criteria andBindRelationNotBetween(String value1, String value2) {
            addCriterion("BIND_RELATION not between", value1, value2, "bindRelation");
            return (Criteria) this;
        }

        public Criteria andHaltFlagIsNull() {
            addCriterion("HALT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andHaltFlagIsNotNull() {
            addCriterion("HALT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andHaltFlagEqualTo(String value) {
            addCriterion("HALT_FLAG =", value, "haltFlag");
            return (Criteria) this;
        }

        public Criteria andHaltFlagNotEqualTo(String value) {
            addCriterion("HALT_FLAG <>", value, "haltFlag");
            return (Criteria) this;
        }

        public Criteria andHaltFlagGreaterThan(String value) {
            addCriterion("HALT_FLAG >", value, "haltFlag");
            return (Criteria) this;
        }

        public Criteria andHaltFlagGreaterThanOrEqualTo(String value) {
            addCriterion("HALT_FLAG >=", value, "haltFlag");
            return (Criteria) this;
        }

        public Criteria andHaltFlagLessThan(String value) {
            addCriterion("HALT_FLAG <", value, "haltFlag");
            return (Criteria) this;
        }

        public Criteria andHaltFlagLessThanOrEqualTo(String value) {
            addCriterion("HALT_FLAG <=", value, "haltFlag");
            return (Criteria) this;
        }

        public Criteria andHaltFlagLike(String value) {
            addCriterion("HALT_FLAG like", value, "haltFlag");
            return (Criteria) this;
        }

        public Criteria andHaltFlagNotLike(String value) {
            addCriterion("HALT_FLAG not like", value, "haltFlag");
            return (Criteria) this;
        }

        public Criteria andHaltFlagIn(List<String> values) {
            addCriterion("HALT_FLAG in", values, "haltFlag");
            return (Criteria) this;
        }

        public Criteria andHaltFlagNotIn(List<String> values) {
            addCriterion("HALT_FLAG not in", values, "haltFlag");
            return (Criteria) this;
        }

        public Criteria andHaltFlagBetween(String value1, String value2) {
            addCriterion("HALT_FLAG between", value1, value2, "haltFlag");
            return (Criteria) this;
        }

        public Criteria andHaltFlagNotBetween(String value1, String value2) {
            addCriterion("HALT_FLAG not between", value1, value2, "haltFlag");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIsNull() {
            addCriterion("PLAN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIsNotNull() {
            addCriterion("PLAN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStatusEqualTo(String value) {
            addCriterion("PLAN_STATUS =", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotEqualTo(String value) {
            addCriterion("PLAN_STATUS <>", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusGreaterThan(String value) {
            addCriterion("PLAN_STATUS >", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PLAN_STATUS >=", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLessThan(String value) {
            addCriterion("PLAN_STATUS <", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLessThanOrEqualTo(String value) {
            addCriterion("PLAN_STATUS <=", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLike(String value) {
            addCriterion("PLAN_STATUS like", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotLike(String value) {
            addCriterion("PLAN_STATUS not like", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIn(List<String> values) {
            addCriterion("PLAN_STATUS in", values, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotIn(List<String> values) {
            addCriterion("PLAN_STATUS not in", values, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusBetween(String value1, String value2) {
            addCriterion("PLAN_STATUS between", value1, value2, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotBetween(String value1, String value2) {
            addCriterion("PLAN_STATUS not between", value1, value2, "planStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("DELETE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("DELETE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Byte value) {
            addCriterion("DELETE_FLAG =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Byte value) {
            addCriterion("DELETE_FLAG <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Byte value) {
            addCriterion("DELETE_FLAG >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("DELETE_FLAG >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Byte value) {
            addCriterion("DELETE_FLAG <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Byte value) {
            addCriterion("DELETE_FLAG <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Byte> values) {
            addCriterion("DELETE_FLAG in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Byte> values) {
            addCriterion("DELETE_FLAG not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Byte value1, Byte value2) {
            addCriterion("DELETE_FLAG between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("DELETE_FLAG not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPlanCountIsNull() {
            addCriterion("PLAN_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andPlanCountIsNotNull() {
            addCriterion("PLAN_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPlanCountEqualTo(Integer value) {
            addCriterion("PLAN_COUNT =", value, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountNotEqualTo(Integer value) {
            addCriterion("PLAN_COUNT <>", value, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountGreaterThan(Integer value) {
            addCriterion("PLAN_COUNT >", value, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLAN_COUNT >=", value, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountLessThan(Integer value) {
            addCriterion("PLAN_COUNT <", value, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountLessThanOrEqualTo(Integer value) {
            addCriterion("PLAN_COUNT <=", value, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountIn(List<Integer> values) {
            addCriterion("PLAN_COUNT in", values, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountNotIn(List<Integer> values) {
            addCriterion("PLAN_COUNT not in", values, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_COUNT between", value1, value2, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountNotBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_COUNT not between", value1, value2, "planCount");
            return (Criteria) this;
        }

        public Criteria andExtractCountIsNull() {
            addCriterion("EXTRACT_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andExtractCountIsNotNull() {
            addCriterion("EXTRACT_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andExtractCountEqualTo(Integer value) {
            addCriterion("EXTRACT_COUNT =", value, "extractCount");
            return (Criteria) this;
        }

        public Criteria andExtractCountNotEqualTo(Integer value) {
            addCriterion("EXTRACT_COUNT <>", value, "extractCount");
            return (Criteria) this;
        }

        public Criteria andExtractCountGreaterThan(Integer value) {
            addCriterion("EXTRACT_COUNT >", value, "extractCount");
            return (Criteria) this;
        }

        public Criteria andExtractCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXTRACT_COUNT >=", value, "extractCount");
            return (Criteria) this;
        }

        public Criteria andExtractCountLessThan(Integer value) {
            addCriterion("EXTRACT_COUNT <", value, "extractCount");
            return (Criteria) this;
        }

        public Criteria andExtractCountLessThanOrEqualTo(Integer value) {
            addCriterion("EXTRACT_COUNT <=", value, "extractCount");
            return (Criteria) this;
        }

        public Criteria andExtractCountIn(List<Integer> values) {
            addCriterion("EXTRACT_COUNT in", values, "extractCount");
            return (Criteria) this;
        }

        public Criteria andExtractCountNotIn(List<Integer> values) {
            addCriterion("EXTRACT_COUNT not in", values, "extractCount");
            return (Criteria) this;
        }

        public Criteria andExtractCountBetween(Integer value1, Integer value2) {
            addCriterion("EXTRACT_COUNT between", value1, value2, "extractCount");
            return (Criteria) this;
        }

        public Criteria andExtractCountNotBetween(Integer value1, Integer value2) {
            addCriterion("EXTRACT_COUNT not between", value1, value2, "extractCount");
            return (Criteria) this;
        }

        public Criteria andPlanRuntimeIsNull() {
            addCriterion("PLAN_RUNTIME is null");
            return (Criteria) this;
        }

        public Criteria andPlanRuntimeIsNotNull() {
            addCriterion("PLAN_RUNTIME is not null");
            return (Criteria) this;
        }

        public Criteria andPlanRuntimeEqualTo(Date value) {
            addCriterionForJDBCTime("PLAN_RUNTIME =", value, "planRuntime");
            return (Criteria) this;
        }

        public Criteria andPlanRuntimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("PLAN_RUNTIME <>", value, "planRuntime");
            return (Criteria) this;
        }

        public Criteria andPlanRuntimeGreaterThan(Date value) {
            addCriterionForJDBCTime("PLAN_RUNTIME >", value, "planRuntime");
            return (Criteria) this;
        }

        public Criteria andPlanRuntimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("PLAN_RUNTIME >=", value, "planRuntime");
            return (Criteria) this;
        }

        public Criteria andPlanRuntimeLessThan(Date value) {
            addCriterionForJDBCTime("PLAN_RUNTIME <", value, "planRuntime");
            return (Criteria) this;
        }

        public Criteria andPlanRuntimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("PLAN_RUNTIME <=", value, "planRuntime");
            return (Criteria) this;
        }

        public Criteria andPlanRuntimeIn(List<Date> values) {
            addCriterionForJDBCTime("PLAN_RUNTIME in", values, "planRuntime");
            return (Criteria) this;
        }

        public Criteria andPlanRuntimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("PLAN_RUNTIME not in", values, "planRuntime");
            return (Criteria) this;
        }

        public Criteria andPlanRuntimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("PLAN_RUNTIME between", value1, value2, "planRuntime");
            return (Criteria) this;
        }

        public Criteria andPlanRuntimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("PLAN_RUNTIME not between", value1, value2, "planRuntime");
            return (Criteria) this;
        }

        public Criteria andPlanRuntypeIsNull() {
            addCriterion("PLAN_RUNTYPE is null");
            return (Criteria) this;
        }

        public Criteria andPlanRuntypeIsNotNull() {
            addCriterion("PLAN_RUNTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPlanRuntypeEqualTo(String value) {
            addCriterion("PLAN_RUNTYPE =", value, "planRuntype");
            return (Criteria) this;
        }

        public Criteria andPlanRuntypeNotEqualTo(String value) {
            addCriterion("PLAN_RUNTYPE <>", value, "planRuntype");
            return (Criteria) this;
        }

        public Criteria andPlanRuntypeGreaterThan(String value) {
            addCriterion("PLAN_RUNTYPE >", value, "planRuntype");
            return (Criteria) this;
        }

        public Criteria andPlanRuntypeGreaterThanOrEqualTo(String value) {
            addCriterion("PLAN_RUNTYPE >=", value, "planRuntype");
            return (Criteria) this;
        }

        public Criteria andPlanRuntypeLessThan(String value) {
            addCriterion("PLAN_RUNTYPE <", value, "planRuntype");
            return (Criteria) this;
        }

        public Criteria andPlanRuntypeLessThanOrEqualTo(String value) {
            addCriterion("PLAN_RUNTYPE <=", value, "planRuntype");
            return (Criteria) this;
        }

        public Criteria andPlanRuntypeLike(String value) {
            addCriterion("PLAN_RUNTYPE like", value, "planRuntype");
            return (Criteria) this;
        }

        public Criteria andPlanRuntypeNotLike(String value) {
            addCriterion("PLAN_RUNTYPE not like", value, "planRuntype");
            return (Criteria) this;
        }

        public Criteria andPlanRuntypeIn(List<String> values) {
            addCriterion("PLAN_RUNTYPE in", values, "planRuntype");
            return (Criteria) this;
        }

        public Criteria andPlanRuntypeNotIn(List<String> values) {
            addCriterion("PLAN_RUNTYPE not in", values, "planRuntype");
            return (Criteria) this;
        }

        public Criteria andPlanRuntypeBetween(String value1, String value2) {
            addCriterion("PLAN_RUNTYPE between", value1, value2, "planRuntype");
            return (Criteria) this;
        }

        public Criteria andPlanRuntypeNotBetween(String value1, String value2) {
            addCriterion("PLAN_RUNTYPE not between", value1, value2, "planRuntype");
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