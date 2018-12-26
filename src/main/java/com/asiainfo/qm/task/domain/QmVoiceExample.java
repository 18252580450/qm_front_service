package com.asiainfo.qm.task.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QmVoiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QmVoiceExample() {
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

        public Criteria andCityIdIsNull() {
            addCriterion("CITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("CITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(String value) {
            addCriterion("CITY_ID =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(String value) {
            addCriterion("CITY_ID <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(String value) {
            addCriterion("CITY_ID >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_ID >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(String value) {
            addCriterion("CITY_ID <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(String value) {
            addCriterion("CITY_ID <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLike(String value) {
            addCriterion("CITY_ID like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotLike(String value) {
            addCriterion("CITY_ID not like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<String> values) {
            addCriterion("CITY_ID in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<String> values) {
            addCriterion("CITY_ID not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(String value1, String value2) {
            addCriterion("CITY_ID between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(String value1, String value2) {
            addCriterion("CITY_ID not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNull() {
            addCriterion("STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(String value) {
            addCriterion("STAFF_ID =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(String value) {
            addCriterion("STAFF_ID <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(String value) {
            addCriterion("STAFF_ID >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("STAFF_ID >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(String value) {
            addCriterion("STAFF_ID <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(String value) {
            addCriterion("STAFF_ID <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLike(String value) {
            addCriterion("STAFF_ID like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotLike(String value) {
            addCriterion("STAFF_ID not like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<String> values) {
            addCriterion("STAFF_ID in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<String> values) {
            addCriterion("STAFF_ID not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(String value1, String value2) {
            addCriterion("STAFF_ID between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(String value1, String value2) {
            addCriterion("STAFF_ID not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andDepartIdIsNull() {
            addCriterion("DEPART_ID is null");
            return (Criteria) this;
        }

        public Criteria andDepartIdIsNotNull() {
            addCriterion("DEPART_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDepartIdEqualTo(String value) {
            addCriterion("DEPART_ID =", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotEqualTo(String value) {
            addCriterion("DEPART_ID <>", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdGreaterThan(String value) {
            addCriterion("DEPART_ID >", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEPART_ID >=", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdLessThan(String value) {
            addCriterion("DEPART_ID <", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdLessThanOrEqualTo(String value) {
            addCriterion("DEPART_ID <=", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdLike(String value) {
            addCriterion("DEPART_ID like", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotLike(String value) {
            addCriterion("DEPART_ID not like", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdIn(List<String> values) {
            addCriterion("DEPART_ID in", values, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotIn(List<String> values) {
            addCriterion("DEPART_ID not in", values, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdBetween(String value1, String value2) {
            addCriterion("DEPART_ID between", value1, value2, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotBetween(String value1, String value2) {
            addCriterion("DEPART_ID not between", value1, value2, "departId");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNull() {
            addCriterion("STAFF_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("STAFF_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("STAFF_NAME =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("STAFF_NAME <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("STAFF_NAME >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("STAFF_NAME >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("STAFF_NAME <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("STAFF_NAME <=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("STAFF_NAME like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("STAFF_NAME not like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("STAFF_NAME in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("STAFF_NAME not in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("STAFF_NAME between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("STAFF_NAME not between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andDepartNameIsNull() {
            addCriterion("DEPART_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDepartNameIsNotNull() {
            addCriterion("DEPART_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDepartNameEqualTo(String value) {
            addCriterion("DEPART_NAME =", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotEqualTo(String value) {
            addCriterion("DEPART_NAME <>", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameGreaterThan(String value) {
            addCriterion("DEPART_NAME >", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEPART_NAME >=", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLessThan(String value) {
            addCriterion("DEPART_NAME <", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLessThanOrEqualTo(String value) {
            addCriterion("DEPART_NAME <=", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLike(String value) {
            addCriterion("DEPART_NAME like", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotLike(String value) {
            addCriterion("DEPART_NAME not like", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameIn(List<String> values) {
            addCriterion("DEPART_NAME in", values, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotIn(List<String> values) {
            addCriterion("DEPART_NAME not in", values, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameBetween(String value1, String value2) {
            addCriterion("DEPART_NAME between", value1, value2, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotBetween(String value1, String value2) {
            addCriterion("DEPART_NAME not between", value1, value2, "departName");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("BEGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("BEGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("BEGIN_TIME =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("BEGIN_TIME <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("BEGIN_TIME >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BEGIN_TIME >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("BEGIN_TIME <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("BEGIN_TIME <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("BEGIN_TIME in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("BEGIN_TIME not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("BEGIN_TIME between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("BEGIN_TIME not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
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

        public Criteria andIvrDurationIsNull() {
            addCriterion("IVR_DURATION is null");
            return (Criteria) this;
        }

        public Criteria andIvrDurationIsNotNull() {
            addCriterion("IVR_DURATION is not null");
            return (Criteria) this;
        }

        public Criteria andIvrDurationEqualTo(Integer value) {
            addCriterion("IVR_DURATION =", value, "ivrDuration");
            return (Criteria) this;
        }

        public Criteria andIvrDurationNotEqualTo(Integer value) {
            addCriterion("IVR_DURATION <>", value, "ivrDuration");
            return (Criteria) this;
        }

        public Criteria andIvrDurationGreaterThan(Integer value) {
            addCriterion("IVR_DURATION >", value, "ivrDuration");
            return (Criteria) this;
        }

        public Criteria andIvrDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("IVR_DURATION >=", value, "ivrDuration");
            return (Criteria) this;
        }

        public Criteria andIvrDurationLessThan(Integer value) {
            addCriterion("IVR_DURATION <", value, "ivrDuration");
            return (Criteria) this;
        }

        public Criteria andIvrDurationLessThanOrEqualTo(Integer value) {
            addCriterion("IVR_DURATION <=", value, "ivrDuration");
            return (Criteria) this;
        }

        public Criteria andIvrDurationIn(List<Integer> values) {
            addCriterion("IVR_DURATION in", values, "ivrDuration");
            return (Criteria) this;
        }

        public Criteria andIvrDurationNotIn(List<Integer> values) {
            addCriterion("IVR_DURATION not in", values, "ivrDuration");
            return (Criteria) this;
        }

        public Criteria andIvrDurationBetween(Integer value1, Integer value2) {
            addCriterion("IVR_DURATION between", value1, value2, "ivrDuration");
            return (Criteria) this;
        }

        public Criteria andIvrDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("IVR_DURATION not between", value1, value2, "ivrDuration");
            return (Criteria) this;
        }

        public Criteria andAlertDurationIsNull() {
            addCriterion("ALERT_DURATION is null");
            return (Criteria) this;
        }

        public Criteria andAlertDurationIsNotNull() {
            addCriterion("ALERT_DURATION is not null");
            return (Criteria) this;
        }

        public Criteria andAlertDurationEqualTo(Integer value) {
            addCriterion("ALERT_DURATION =", value, "alertDuration");
            return (Criteria) this;
        }

        public Criteria andAlertDurationNotEqualTo(Integer value) {
            addCriterion("ALERT_DURATION <>", value, "alertDuration");
            return (Criteria) this;
        }

        public Criteria andAlertDurationGreaterThan(Integer value) {
            addCriterion("ALERT_DURATION >", value, "alertDuration");
            return (Criteria) this;
        }

        public Criteria andAlertDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("ALERT_DURATION >=", value, "alertDuration");
            return (Criteria) this;
        }

        public Criteria andAlertDurationLessThan(Integer value) {
            addCriterion("ALERT_DURATION <", value, "alertDuration");
            return (Criteria) this;
        }

        public Criteria andAlertDurationLessThanOrEqualTo(Integer value) {
            addCriterion("ALERT_DURATION <=", value, "alertDuration");
            return (Criteria) this;
        }

        public Criteria andAlertDurationIn(List<Integer> values) {
            addCriterion("ALERT_DURATION in", values, "alertDuration");
            return (Criteria) this;
        }

        public Criteria andAlertDurationNotIn(List<Integer> values) {
            addCriterion("ALERT_DURATION not in", values, "alertDuration");
            return (Criteria) this;
        }

        public Criteria andAlertDurationBetween(Integer value1, Integer value2) {
            addCriterion("ALERT_DURATION between", value1, value2, "alertDuration");
            return (Criteria) this;
        }

        public Criteria andAlertDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("ALERT_DURATION not between", value1, value2, "alertDuration");
            return (Criteria) this;
        }

        public Criteria andQueueDurationIsNull() {
            addCriterion("QUEUE_DURATION is null");
            return (Criteria) this;
        }

        public Criteria andQueueDurationIsNotNull() {
            addCriterion("QUEUE_DURATION is not null");
            return (Criteria) this;
        }

        public Criteria andQueueDurationEqualTo(Integer value) {
            addCriterion("QUEUE_DURATION =", value, "queueDuration");
            return (Criteria) this;
        }

        public Criteria andQueueDurationNotEqualTo(Integer value) {
            addCriterion("QUEUE_DURATION <>", value, "queueDuration");
            return (Criteria) this;
        }

        public Criteria andQueueDurationGreaterThan(Integer value) {
            addCriterion("QUEUE_DURATION >", value, "queueDuration");
            return (Criteria) this;
        }

        public Criteria andQueueDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("QUEUE_DURATION >=", value, "queueDuration");
            return (Criteria) this;
        }

        public Criteria andQueueDurationLessThan(Integer value) {
            addCriterion("QUEUE_DURATION <", value, "queueDuration");
            return (Criteria) this;
        }

        public Criteria andQueueDurationLessThanOrEqualTo(Integer value) {
            addCriterion("QUEUE_DURATION <=", value, "queueDuration");
            return (Criteria) this;
        }

        public Criteria andQueueDurationIn(List<Integer> values) {
            addCriterion("QUEUE_DURATION in", values, "queueDuration");
            return (Criteria) this;
        }

        public Criteria andQueueDurationNotIn(List<Integer> values) {
            addCriterion("QUEUE_DURATION not in", values, "queueDuration");
            return (Criteria) this;
        }

        public Criteria andQueueDurationBetween(Integer value1, Integer value2) {
            addCriterion("QUEUE_DURATION between", value1, value2, "queueDuration");
            return (Criteria) this;
        }

        public Criteria andQueueDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("QUEUE_DURATION not between", value1, value2, "queueDuration");
            return (Criteria) this;
        }

        public Criteria andTalkDurationIsNull() {
            addCriterion("TALK_DURATION is null");
            return (Criteria) this;
        }

        public Criteria andTalkDurationIsNotNull() {
            addCriterion("TALK_DURATION is not null");
            return (Criteria) this;
        }

        public Criteria andTalkDurationEqualTo(Integer value) {
            addCriterion("TALK_DURATION =", value, "talkDuration");
            return (Criteria) this;
        }

        public Criteria andTalkDurationNotEqualTo(Integer value) {
            addCriterion("TALK_DURATION <>", value, "talkDuration");
            return (Criteria) this;
        }

        public Criteria andTalkDurationGreaterThan(Integer value) {
            addCriterion("TALK_DURATION >", value, "talkDuration");
            return (Criteria) this;
        }

        public Criteria andTalkDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("TALK_DURATION >=", value, "talkDuration");
            return (Criteria) this;
        }

        public Criteria andTalkDurationLessThan(Integer value) {
            addCriterion("TALK_DURATION <", value, "talkDuration");
            return (Criteria) this;
        }

        public Criteria andTalkDurationLessThanOrEqualTo(Integer value) {
            addCriterion("TALK_DURATION <=", value, "talkDuration");
            return (Criteria) this;
        }

        public Criteria andTalkDurationIn(List<Integer> values) {
            addCriterion("TALK_DURATION in", values, "talkDuration");
            return (Criteria) this;
        }

        public Criteria andTalkDurationNotIn(List<Integer> values) {
            addCriterion("TALK_DURATION not in", values, "talkDuration");
            return (Criteria) this;
        }

        public Criteria andTalkDurationBetween(Integer value1, Integer value2) {
            addCriterion("TALK_DURATION between", value1, value2, "talkDuration");
            return (Criteria) this;
        }

        public Criteria andTalkDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("TALK_DURATION not between", value1, value2, "talkDuration");
            return (Criteria) this;
        }

        public Criteria andAcwDurationIsNull() {
            addCriterion("ACW_DURATION is null");
            return (Criteria) this;
        }

        public Criteria andAcwDurationIsNotNull() {
            addCriterion("ACW_DURATION is not null");
            return (Criteria) this;
        }

        public Criteria andAcwDurationEqualTo(Integer value) {
            addCriterion("ACW_DURATION =", value, "acwDuration");
            return (Criteria) this;
        }

        public Criteria andAcwDurationNotEqualTo(Integer value) {
            addCriterion("ACW_DURATION <>", value, "acwDuration");
            return (Criteria) this;
        }

        public Criteria andAcwDurationGreaterThan(Integer value) {
            addCriterion("ACW_DURATION >", value, "acwDuration");
            return (Criteria) this;
        }

        public Criteria andAcwDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACW_DURATION >=", value, "acwDuration");
            return (Criteria) this;
        }

        public Criteria andAcwDurationLessThan(Integer value) {
            addCriterion("ACW_DURATION <", value, "acwDuration");
            return (Criteria) this;
        }

        public Criteria andAcwDurationLessThanOrEqualTo(Integer value) {
            addCriterion("ACW_DURATION <=", value, "acwDuration");
            return (Criteria) this;
        }

        public Criteria andAcwDurationIn(List<Integer> values) {
            addCriterion("ACW_DURATION in", values, "acwDuration");
            return (Criteria) this;
        }

        public Criteria andAcwDurationNotIn(List<Integer> values) {
            addCriterion("ACW_DURATION not in", values, "acwDuration");
            return (Criteria) this;
        }

        public Criteria andAcwDurationBetween(Integer value1, Integer value2) {
            addCriterion("ACW_DURATION between", value1, value2, "acwDuration");
            return (Criteria) this;
        }

        public Criteria andAcwDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("ACW_DURATION not between", value1, value2, "acwDuration");
            return (Criteria) this;
        }

        public Criteria andEndTypeIsNull() {
            addCriterion("END_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEndTypeIsNotNull() {
            addCriterion("END_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEndTypeEqualTo(String value) {
            addCriterion("END_TYPE =", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeNotEqualTo(String value) {
            addCriterion("END_TYPE <>", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeGreaterThan(String value) {
            addCriterion("END_TYPE >", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeGreaterThanOrEqualTo(String value) {
            addCriterion("END_TYPE >=", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeLessThan(String value) {
            addCriterion("END_TYPE <", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeLessThanOrEqualTo(String value) {
            addCriterion("END_TYPE <=", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeLike(String value) {
            addCriterion("END_TYPE like", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeNotLike(String value) {
            addCriterion("END_TYPE not like", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeIn(List<String> values) {
            addCriterion("END_TYPE in", values, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeNotIn(List<String> values) {
            addCriterion("END_TYPE not in", values, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeBetween(String value1, String value2) {
            addCriterion("END_TYPE between", value1, value2, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeNotBetween(String value1, String value2) {
            addCriterion("END_TYPE not between", value1, value2, "endType");
            return (Criteria) this;
        }

        public Criteria andStaffNumberIsNull() {
            addCriterion("STAFF_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andStaffNumberIsNotNull() {
            addCriterion("STAFF_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNumberEqualTo(String value) {
            addCriterion("STAFF_NUMBER =", value, "staffNumber");
            return (Criteria) this;
        }

        public Criteria andStaffNumberNotEqualTo(String value) {
            addCriterion("STAFF_NUMBER <>", value, "staffNumber");
            return (Criteria) this;
        }

        public Criteria andStaffNumberGreaterThan(String value) {
            addCriterion("STAFF_NUMBER >", value, "staffNumber");
            return (Criteria) this;
        }

        public Criteria andStaffNumberGreaterThanOrEqualTo(String value) {
            addCriterion("STAFF_NUMBER >=", value, "staffNumber");
            return (Criteria) this;
        }

        public Criteria andStaffNumberLessThan(String value) {
            addCriterion("STAFF_NUMBER <", value, "staffNumber");
            return (Criteria) this;
        }

        public Criteria andStaffNumberLessThanOrEqualTo(String value) {
            addCriterion("STAFF_NUMBER <=", value, "staffNumber");
            return (Criteria) this;
        }

        public Criteria andStaffNumberLike(String value) {
            addCriterion("STAFF_NUMBER like", value, "staffNumber");
            return (Criteria) this;
        }

        public Criteria andStaffNumberNotLike(String value) {
            addCriterion("STAFF_NUMBER not like", value, "staffNumber");
            return (Criteria) this;
        }

        public Criteria andStaffNumberIn(List<String> values) {
            addCriterion("STAFF_NUMBER in", values, "staffNumber");
            return (Criteria) this;
        }

        public Criteria andStaffNumberNotIn(List<String> values) {
            addCriterion("STAFF_NUMBER not in", values, "staffNumber");
            return (Criteria) this;
        }

        public Criteria andStaffNumberBetween(String value1, String value2) {
            addCriterion("STAFF_NUMBER between", value1, value2, "staffNumber");
            return (Criteria) this;
        }

        public Criteria andStaffNumberNotBetween(String value1, String value2) {
            addCriterion("STAFF_NUMBER not between", value1, value2, "staffNumber");
            return (Criteria) this;
        }

        public Criteria andCustomerNumberIsNull() {
            addCriterion("CUSTOMER_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNumberIsNotNull() {
            addCriterion("CUSTOMER_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNumberEqualTo(String value) {
            addCriterion("CUSTOMER_NUMBER =", value, "customerNumber");
            return (Criteria) this;
        }

        public Criteria andCustomerNumberNotEqualTo(String value) {
            addCriterion("CUSTOMER_NUMBER <>", value, "customerNumber");
            return (Criteria) this;
        }

        public Criteria andCustomerNumberGreaterThan(String value) {
            addCriterion("CUSTOMER_NUMBER >", value, "customerNumber");
            return (Criteria) this;
        }

        public Criteria andCustomerNumberGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_NUMBER >=", value, "customerNumber");
            return (Criteria) this;
        }

        public Criteria andCustomerNumberLessThan(String value) {
            addCriterion("CUSTOMER_NUMBER <", value, "customerNumber");
            return (Criteria) this;
        }

        public Criteria andCustomerNumberLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_NUMBER <=", value, "customerNumber");
            return (Criteria) this;
        }

        public Criteria andCustomerNumberLike(String value) {
            addCriterion("CUSTOMER_NUMBER like", value, "customerNumber");
            return (Criteria) this;
        }

        public Criteria andCustomerNumberNotLike(String value) {
            addCriterion("CUSTOMER_NUMBER not like", value, "customerNumber");
            return (Criteria) this;
        }

        public Criteria andCustomerNumberIn(List<String> values) {
            addCriterion("CUSTOMER_NUMBER in", values, "customerNumber");
            return (Criteria) this;
        }

        public Criteria andCustomerNumberNotIn(List<String> values) {
            addCriterion("CUSTOMER_NUMBER not in", values, "customerNumber");
            return (Criteria) this;
        }

        public Criteria andCustomerNumberBetween(String value1, String value2) {
            addCriterion("CUSTOMER_NUMBER between", value1, value2, "customerNumber");
            return (Criteria) this;
        }

        public Criteria andCustomerNumberNotBetween(String value1, String value2) {
            addCriterion("CUSTOMER_NUMBER not between", value1, value2, "customerNumber");
            return (Criteria) this;
        }

        public Criteria andRecordPathIsNull() {
            addCriterion("RECORD_PATH is null");
            return (Criteria) this;
        }

        public Criteria andRecordPathIsNotNull() {
            addCriterion("RECORD_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andRecordPathEqualTo(String value) {
            addCriterion("RECORD_PATH =", value, "recordPath");
            return (Criteria) this;
        }

        public Criteria andRecordPathNotEqualTo(String value) {
            addCriterion("RECORD_PATH <>", value, "recordPath");
            return (Criteria) this;
        }

        public Criteria andRecordPathGreaterThan(String value) {
            addCriterion("RECORD_PATH >", value, "recordPath");
            return (Criteria) this;
        }

        public Criteria andRecordPathGreaterThanOrEqualTo(String value) {
            addCriterion("RECORD_PATH >=", value, "recordPath");
            return (Criteria) this;
        }

        public Criteria andRecordPathLessThan(String value) {
            addCriterion("RECORD_PATH <", value, "recordPath");
            return (Criteria) this;
        }

        public Criteria andRecordPathLessThanOrEqualTo(String value) {
            addCriterion("RECORD_PATH <=", value, "recordPath");
            return (Criteria) this;
        }

        public Criteria andRecordPathLike(String value) {
            addCriterion("RECORD_PATH like", value, "recordPath");
            return (Criteria) this;
        }

        public Criteria andRecordPathNotLike(String value) {
            addCriterion("RECORD_PATH not like", value, "recordPath");
            return (Criteria) this;
        }

        public Criteria andRecordPathIn(List<String> values) {
            addCriterion("RECORD_PATH in", values, "recordPath");
            return (Criteria) this;
        }

        public Criteria andRecordPathNotIn(List<String> values) {
            addCriterion("RECORD_PATH not in", values, "recordPath");
            return (Criteria) this;
        }

        public Criteria andRecordPathBetween(String value1, String value2) {
            addCriterion("RECORD_PATH between", value1, value2, "recordPath");
            return (Criteria) this;
        }

        public Criteria andRecordPathNotBetween(String value1, String value2) {
            addCriterion("RECORD_PATH not between", value1, value2, "recordPath");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentIsNull() {
            addCriterion("SATISFY_EXTENT is null");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentIsNotNull() {
            addCriterion("SATISFY_EXTENT is not null");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentEqualTo(String value) {
            addCriterion("SATISFY_EXTENT =", value, "satisfyExtent");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentNotEqualTo(String value) {
            addCriterion("SATISFY_EXTENT <>", value, "satisfyExtent");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentGreaterThan(String value) {
            addCriterion("SATISFY_EXTENT >", value, "satisfyExtent");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentGreaterThanOrEqualTo(String value) {
            addCriterion("SATISFY_EXTENT >=", value, "satisfyExtent");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentLessThan(String value) {
            addCriterion("SATISFY_EXTENT <", value, "satisfyExtent");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentLessThanOrEqualTo(String value) {
            addCriterion("SATISFY_EXTENT <=", value, "satisfyExtent");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentLike(String value) {
            addCriterion("SATISFY_EXTENT like", value, "satisfyExtent");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentNotLike(String value) {
            addCriterion("SATISFY_EXTENT not like", value, "satisfyExtent");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentIn(List<String> values) {
            addCriterion("SATISFY_EXTENT in", values, "satisfyExtent");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentNotIn(List<String> values) {
            addCriterion("SATISFY_EXTENT not in", values, "satisfyExtent");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentBetween(String value1, String value2) {
            addCriterion("SATISFY_EXTENT between", value1, value2, "satisfyExtent");
            return (Criteria) this;
        }

        public Criteria andSatisfyExtentNotBetween(String value1, String value2) {
            addCriterion("SATISFY_EXTENT not between", value1, value2, "satisfyExtent");
            return (Criteria) this;
        }

        public Criteria andDisconReasonIsNull() {
            addCriterion("DISCON_REASON is null");
            return (Criteria) this;
        }

        public Criteria andDisconReasonIsNotNull() {
            addCriterion("DISCON_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andDisconReasonEqualTo(String value) {
            addCriterion("DISCON_REASON =", value, "disconReason");
            return (Criteria) this;
        }

        public Criteria andDisconReasonNotEqualTo(String value) {
            addCriterion("DISCON_REASON <>", value, "disconReason");
            return (Criteria) this;
        }

        public Criteria andDisconReasonGreaterThan(String value) {
            addCriterion("DISCON_REASON >", value, "disconReason");
            return (Criteria) this;
        }

        public Criteria andDisconReasonGreaterThanOrEqualTo(String value) {
            addCriterion("DISCON_REASON >=", value, "disconReason");
            return (Criteria) this;
        }

        public Criteria andDisconReasonLessThan(String value) {
            addCriterion("DISCON_REASON <", value, "disconReason");
            return (Criteria) this;
        }

        public Criteria andDisconReasonLessThanOrEqualTo(String value) {
            addCriterion("DISCON_REASON <=", value, "disconReason");
            return (Criteria) this;
        }

        public Criteria andDisconReasonLike(String value) {
            addCriterion("DISCON_REASON like", value, "disconReason");
            return (Criteria) this;
        }

        public Criteria andDisconReasonNotLike(String value) {
            addCriterion("DISCON_REASON not like", value, "disconReason");
            return (Criteria) this;
        }

        public Criteria andDisconReasonIn(List<String> values) {
            addCriterion("DISCON_REASON in", values, "disconReason");
            return (Criteria) this;
        }

        public Criteria andDisconReasonNotIn(List<String> values) {
            addCriterion("DISCON_REASON not in", values, "disconReason");
            return (Criteria) this;
        }

        public Criteria andDisconReasonBetween(String value1, String value2) {
            addCriterion("DISCON_REASON between", value1, value2, "disconReason");
            return (Criteria) this;
        }

        public Criteria andDisconReasonNotBetween(String value1, String value2) {
            addCriterion("DISCON_REASON not between", value1, value2, "disconReason");
            return (Criteria) this;
        }

        public Criteria andCallReasonIsNull() {
            addCriterion("CALL_REASON is null");
            return (Criteria) this;
        }

        public Criteria andCallReasonIsNotNull() {
            addCriterion("CALL_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andCallReasonEqualTo(String value) {
            addCriterion("CALL_REASON =", value, "callReason");
            return (Criteria) this;
        }

        public Criteria andCallReasonNotEqualTo(String value) {
            addCriterion("CALL_REASON <>", value, "callReason");
            return (Criteria) this;
        }

        public Criteria andCallReasonGreaterThan(String value) {
            addCriterion("CALL_REASON >", value, "callReason");
            return (Criteria) this;
        }

        public Criteria andCallReasonGreaterThanOrEqualTo(String value) {
            addCriterion("CALL_REASON >=", value, "callReason");
            return (Criteria) this;
        }

        public Criteria andCallReasonLessThan(String value) {
            addCriterion("CALL_REASON <", value, "callReason");
            return (Criteria) this;
        }

        public Criteria andCallReasonLessThanOrEqualTo(String value) {
            addCriterion("CALL_REASON <=", value, "callReason");
            return (Criteria) this;
        }

        public Criteria andCallReasonLike(String value) {
            addCriterion("CALL_REASON like", value, "callReason");
            return (Criteria) this;
        }

        public Criteria andCallReasonNotLike(String value) {
            addCriterion("CALL_REASON not like", value, "callReason");
            return (Criteria) this;
        }

        public Criteria andCallReasonIn(List<String> values) {
            addCriterion("CALL_REASON in", values, "callReason");
            return (Criteria) this;
        }

        public Criteria andCallReasonNotIn(List<String> values) {
            addCriterion("CALL_REASON not in", values, "callReason");
            return (Criteria) this;
        }

        public Criteria andCallReasonBetween(String value1, String value2) {
            addCriterion("CALL_REASON between", value1, value2, "callReason");
            return (Criteria) this;
        }

        public Criteria andCallReasonNotBetween(String value1, String value2) {
            addCriterion("CALL_REASON not between", value1, value2, "callReason");
            return (Criteria) this;
        }

        public Criteria andNotOneSltIsNull() {
            addCriterion("NOT_ONE_SLT is null");
            return (Criteria) this;
        }

        public Criteria andNotOneSltIsNotNull() {
            addCriterion("NOT_ONE_SLT is not null");
            return (Criteria) this;
        }

        public Criteria andNotOneSltEqualTo(String value) {
            addCriterion("NOT_ONE_SLT =", value, "notOneSlt");
            return (Criteria) this;
        }

        public Criteria andNotOneSltNotEqualTo(String value) {
            addCriterion("NOT_ONE_SLT <>", value, "notOneSlt");
            return (Criteria) this;
        }

        public Criteria andNotOneSltGreaterThan(String value) {
            addCriterion("NOT_ONE_SLT >", value, "notOneSlt");
            return (Criteria) this;
        }

        public Criteria andNotOneSltGreaterThanOrEqualTo(String value) {
            addCriterion("NOT_ONE_SLT >=", value, "notOneSlt");
            return (Criteria) this;
        }

        public Criteria andNotOneSltLessThan(String value) {
            addCriterion("NOT_ONE_SLT <", value, "notOneSlt");
            return (Criteria) this;
        }

        public Criteria andNotOneSltLessThanOrEqualTo(String value) {
            addCriterion("NOT_ONE_SLT <=", value, "notOneSlt");
            return (Criteria) this;
        }

        public Criteria andNotOneSltLike(String value) {
            addCriterion("NOT_ONE_SLT like", value, "notOneSlt");
            return (Criteria) this;
        }

        public Criteria andNotOneSltNotLike(String value) {
            addCriterion("NOT_ONE_SLT not like", value, "notOneSlt");
            return (Criteria) this;
        }

        public Criteria andNotOneSltIn(List<String> values) {
            addCriterion("NOT_ONE_SLT in", values, "notOneSlt");
            return (Criteria) this;
        }

        public Criteria andNotOneSltNotIn(List<String> values) {
            addCriterion("NOT_ONE_SLT not in", values, "notOneSlt");
            return (Criteria) this;
        }

        public Criteria andNotOneSltBetween(String value1, String value2) {
            addCriterion("NOT_ONE_SLT between", value1, value2, "notOneSlt");
            return (Criteria) this;
        }

        public Criteria andNotOneSltNotBetween(String value1, String value2) {
            addCriterion("NOT_ONE_SLT not between", value1, value2, "notOneSlt");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("BUSINESS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("BUSINESS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(String value) {
            addCriterion("BUSINESS_TYPE =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(String value) {
            addCriterion("BUSINESS_TYPE <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(String value) {
            addCriterion("BUSINESS_TYPE >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(String value) {
            addCriterion("BUSINESS_TYPE <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLike(String value) {
            addCriterion("BUSINESS_TYPE like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotLike(String value) {
            addCriterion("BUSINESS_TYPE not like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<String> values) {
            addCriterion("BUSINESS_TYPE in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<String> values) {
            addCriterion("BUSINESS_TYPE not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE not between", value1, value2, "businessType");
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