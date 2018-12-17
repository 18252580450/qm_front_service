package com.asiainfo.qm.manage.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderCheckResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderCheckResultExample() {
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

        public Criteria andCheckLinkIsNull() {
            addCriterion("CHECK_LINK is null");
            return (Criteria) this;
        }

        public Criteria andCheckLinkIsNotNull() {
            addCriterion("CHECK_LINK is not null");
            return (Criteria) this;
        }

        public Criteria andCheckLinkEqualTo(String value) {
            addCriterion("CHECK_LINK =", value, "checkLink");
            return (Criteria) this;
        }

        public Criteria andCheckLinkNotEqualTo(String value) {
            addCriterion("CHECK_LINK <>", value, "checkLink");
            return (Criteria) this;
        }

        public Criteria andCheckLinkGreaterThan(String value) {
            addCriterion("CHECK_LINK >", value, "checkLink");
            return (Criteria) this;
        }

        public Criteria andCheckLinkGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_LINK >=", value, "checkLink");
            return (Criteria) this;
        }

        public Criteria andCheckLinkLessThan(String value) {
            addCriterion("CHECK_LINK <", value, "checkLink");
            return (Criteria) this;
        }

        public Criteria andCheckLinkLessThanOrEqualTo(String value) {
            addCriterion("CHECK_LINK <=", value, "checkLink");
            return (Criteria) this;
        }

        public Criteria andCheckLinkLike(String value) {
            addCriterion("CHECK_LINK like", value, "checkLink");
            return (Criteria) this;
        }

        public Criteria andCheckLinkNotLike(String value) {
            addCriterion("CHECK_LINK not like", value, "checkLink");
            return (Criteria) this;
        }

        public Criteria andCheckLinkIn(List<String> values) {
            addCriterion("CHECK_LINK in", values, "checkLink");
            return (Criteria) this;
        }

        public Criteria andCheckLinkNotIn(List<String> values) {
            addCriterion("CHECK_LINK not in", values, "checkLink");
            return (Criteria) this;
        }

        public Criteria andCheckLinkBetween(String value1, String value2) {
            addCriterion("CHECK_LINK between", value1, value2, "checkLink");
            return (Criteria) this;
        }

        public Criteria andCheckLinkNotBetween(String value1, String value2) {
            addCriterion("CHECK_LINK not between", value1, value2, "checkLink");
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

        public Criteria andAcceptMonthIsNull() {
            addCriterion("ACCEPT_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andAcceptMonthIsNotNull() {
            addCriterion("ACCEPT_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptMonthEqualTo(String value) {
            addCriterion("ACCEPT_MONTH =", value, "acceptMonth");
            return (Criteria) this;
        }

        public Criteria andAcceptMonthNotEqualTo(String value) {
            addCriterion("ACCEPT_MONTH <>", value, "acceptMonth");
            return (Criteria) this;
        }

        public Criteria andAcceptMonthGreaterThan(String value) {
            addCriterion("ACCEPT_MONTH >", value, "acceptMonth");
            return (Criteria) this;
        }

        public Criteria andAcceptMonthGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPT_MONTH >=", value, "acceptMonth");
            return (Criteria) this;
        }

        public Criteria andAcceptMonthLessThan(String value) {
            addCriterion("ACCEPT_MONTH <", value, "acceptMonth");
            return (Criteria) this;
        }

        public Criteria andAcceptMonthLessThanOrEqualTo(String value) {
            addCriterion("ACCEPT_MONTH <=", value, "acceptMonth");
            return (Criteria) this;
        }

        public Criteria andAcceptMonthLike(String value) {
            addCriterion("ACCEPT_MONTH like", value, "acceptMonth");
            return (Criteria) this;
        }

        public Criteria andAcceptMonthNotLike(String value) {
            addCriterion("ACCEPT_MONTH not like", value, "acceptMonth");
            return (Criteria) this;
        }

        public Criteria andAcceptMonthIn(List<String> values) {
            addCriterion("ACCEPT_MONTH in", values, "acceptMonth");
            return (Criteria) this;
        }

        public Criteria andAcceptMonthNotIn(List<String> values) {
            addCriterion("ACCEPT_MONTH not in", values, "acceptMonth");
            return (Criteria) this;
        }

        public Criteria andAcceptMonthBetween(String value1, String value2) {
            addCriterion("ACCEPT_MONTH between", value1, value2, "acceptMonth");
            return (Criteria) this;
        }

        public Criteria andAcceptMonthNotBetween(String value1, String value2) {
            addCriterion("ACCEPT_MONTH not between", value1, value2, "acceptMonth");
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

        public Criteria andAcceptNumberIsNull() {
            addCriterion("ACCEPT_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberIsNotNull() {
            addCriterion("ACCEPT_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberEqualTo(String value) {
            addCriterion("ACCEPT_NUMBER =", value, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberNotEqualTo(String value) {
            addCriterion("ACCEPT_NUMBER <>", value, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberGreaterThan(String value) {
            addCriterion("ACCEPT_NUMBER >", value, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPT_NUMBER >=", value, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberLessThan(String value) {
            addCriterion("ACCEPT_NUMBER <", value, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberLessThanOrEqualTo(String value) {
            addCriterion("ACCEPT_NUMBER <=", value, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberLike(String value) {
            addCriterion("ACCEPT_NUMBER like", value, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberNotLike(String value) {
            addCriterion("ACCEPT_NUMBER not like", value, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberIn(List<String> values) {
            addCriterion("ACCEPT_NUMBER in", values, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberNotIn(List<String> values) {
            addCriterion("ACCEPT_NUMBER not in", values, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberBetween(String value1, String value2) {
            addCriterion("ACCEPT_NUMBER between", value1, value2, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptNumberNotBetween(String value1, String value2) {
            addCriterion("ACCEPT_NUMBER not between", value1, value2, "acceptNumber");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelIsNull() {
            addCriterion("CUSTOMER_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelIsNotNull() {
            addCriterion("CUSTOMER_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelEqualTo(String value) {
            addCriterion("CUSTOMER_LEVEL =", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelNotEqualTo(String value) {
            addCriterion("CUSTOMER_LEVEL <>", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelGreaterThan(String value) {
            addCriterion("CUSTOMER_LEVEL >", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_LEVEL >=", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelLessThan(String value) {
            addCriterion("CUSTOMER_LEVEL <", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_LEVEL <=", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelLike(String value) {
            addCriterion("CUSTOMER_LEVEL like", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelNotLike(String value) {
            addCriterion("CUSTOMER_LEVEL not like", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelIn(List<String> values) {
            addCriterion("CUSTOMER_LEVEL in", values, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelNotIn(List<String> values) {
            addCriterion("CUSTOMER_LEVEL not in", values, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelBetween(String value1, String value2) {
            addCriterion("CUSTOMER_LEVEL between", value1, value2, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelNotBetween(String value1, String value2) {
            addCriterion("CUSTOMER_LEVEL not between", value1, value2, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andOriginInspectionIdIsNull() {
            addCriterion("ORIGIN_INSPECTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andOriginInspectionIdIsNotNull() {
            addCriterion("ORIGIN_INSPECTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOriginInspectionIdEqualTo(String value) {
            addCriterion("ORIGIN_INSPECTION_ID =", value, "originInspectionId");
            return (Criteria) this;
        }

        public Criteria andOriginInspectionIdNotEqualTo(String value) {
            addCriterion("ORIGIN_INSPECTION_ID <>", value, "originInspectionId");
            return (Criteria) this;
        }

        public Criteria andOriginInspectionIdGreaterThan(String value) {
            addCriterion("ORIGIN_INSPECTION_ID >", value, "originInspectionId");
            return (Criteria) this;
        }

        public Criteria andOriginInspectionIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORIGIN_INSPECTION_ID >=", value, "originInspectionId");
            return (Criteria) this;
        }

        public Criteria andOriginInspectionIdLessThan(String value) {
            addCriterion("ORIGIN_INSPECTION_ID <", value, "originInspectionId");
            return (Criteria) this;
        }

        public Criteria andOriginInspectionIdLessThanOrEqualTo(String value) {
            addCriterion("ORIGIN_INSPECTION_ID <=", value, "originInspectionId");
            return (Criteria) this;
        }

        public Criteria andOriginInspectionIdLike(String value) {
            addCriterion("ORIGIN_INSPECTION_ID like", value, "originInspectionId");
            return (Criteria) this;
        }

        public Criteria andOriginInspectionIdNotLike(String value) {
            addCriterion("ORIGIN_INSPECTION_ID not like", value, "originInspectionId");
            return (Criteria) this;
        }

        public Criteria andOriginInspectionIdIn(List<String> values) {
            addCriterion("ORIGIN_INSPECTION_ID in", values, "originInspectionId");
            return (Criteria) this;
        }

        public Criteria andOriginInspectionIdNotIn(List<String> values) {
            addCriterion("ORIGIN_INSPECTION_ID not in", values, "originInspectionId");
            return (Criteria) this;
        }

        public Criteria andOriginInspectionIdBetween(String value1, String value2) {
            addCriterion("ORIGIN_INSPECTION_ID between", value1, value2, "originInspectionId");
            return (Criteria) this;
        }

        public Criteria andOriginInspectionIdNotBetween(String value1, String value2) {
            addCriterion("ORIGIN_INSPECTION_ID not between", value1, value2, "originInspectionId");
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

        public Criteria andCheckModelIsNull() {
            addCriterion("CHECK_MODEL is null");
            return (Criteria) this;
        }

        public Criteria andCheckModelIsNotNull() {
            addCriterion("CHECK_MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andCheckModelEqualTo(String value) {
            addCriterion("CHECK_MODEL =", value, "checkModel");
            return (Criteria) this;
        }

        public Criteria andCheckModelNotEqualTo(String value) {
            addCriterion("CHECK_MODEL <>", value, "checkModel");
            return (Criteria) this;
        }

        public Criteria andCheckModelGreaterThan(String value) {
            addCriterion("CHECK_MODEL >", value, "checkModel");
            return (Criteria) this;
        }

        public Criteria andCheckModelGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_MODEL >=", value, "checkModel");
            return (Criteria) this;
        }

        public Criteria andCheckModelLessThan(String value) {
            addCriterion("CHECK_MODEL <", value, "checkModel");
            return (Criteria) this;
        }

        public Criteria andCheckModelLessThanOrEqualTo(String value) {
            addCriterion("CHECK_MODEL <=", value, "checkModel");
            return (Criteria) this;
        }

        public Criteria andCheckModelLike(String value) {
            addCriterion("CHECK_MODEL like", value, "checkModel");
            return (Criteria) this;
        }

        public Criteria andCheckModelNotLike(String value) {
            addCriterion("CHECK_MODEL not like", value, "checkModel");
            return (Criteria) this;
        }

        public Criteria andCheckModelIn(List<String> values) {
            addCriterion("CHECK_MODEL in", values, "checkModel");
            return (Criteria) this;
        }

        public Criteria andCheckModelNotIn(List<String> values) {
            addCriterion("CHECK_MODEL not in", values, "checkModel");
            return (Criteria) this;
        }

        public Criteria andCheckModelBetween(String value1, String value2) {
            addCriterion("CHECK_MODEL between", value1, value2, "checkModel");
            return (Criteria) this;
        }

        public Criteria andCheckModelNotBetween(String value1, String value2) {
            addCriterion("CHECK_MODEL not between", value1, value2, "checkModel");
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

        public Criteria andCheckedDepartIdIsNull() {
            addCriterion("CHECKED_DEPART_ID is null");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartIdIsNotNull() {
            addCriterion("CHECKED_DEPART_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartIdEqualTo(String value) {
            addCriterion("CHECKED_DEPART_ID =", value, "checkedDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartIdNotEqualTo(String value) {
            addCriterion("CHECKED_DEPART_ID <>", value, "checkedDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartIdGreaterThan(String value) {
            addCriterion("CHECKED_DEPART_ID >", value, "checkedDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKED_DEPART_ID >=", value, "checkedDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartIdLessThan(String value) {
            addCriterion("CHECKED_DEPART_ID <", value, "checkedDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartIdLessThanOrEqualTo(String value) {
            addCriterion("CHECKED_DEPART_ID <=", value, "checkedDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartIdLike(String value) {
            addCriterion("CHECKED_DEPART_ID like", value, "checkedDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartIdNotLike(String value) {
            addCriterion("CHECKED_DEPART_ID not like", value, "checkedDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartIdIn(List<String> values) {
            addCriterion("CHECKED_DEPART_ID in", values, "checkedDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartIdNotIn(List<String> values) {
            addCriterion("CHECKED_DEPART_ID not in", values, "checkedDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartIdBetween(String value1, String value2) {
            addCriterion("CHECKED_DEPART_ID between", value1, value2, "checkedDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartIdNotBetween(String value1, String value2) {
            addCriterion("CHECKED_DEPART_ID not between", value1, value2, "checkedDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartNameIsNull() {
            addCriterion("CHECKED_DEPART_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartNameIsNotNull() {
            addCriterion("CHECKED_DEPART_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartNameEqualTo(String value) {
            addCriterion("CHECKED_DEPART_NAME =", value, "checkedDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartNameNotEqualTo(String value) {
            addCriterion("CHECKED_DEPART_NAME <>", value, "checkedDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartNameGreaterThan(String value) {
            addCriterion("CHECKED_DEPART_NAME >", value, "checkedDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKED_DEPART_NAME >=", value, "checkedDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartNameLessThan(String value) {
            addCriterion("CHECKED_DEPART_NAME <", value, "checkedDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartNameLessThanOrEqualTo(String value) {
            addCriterion("CHECKED_DEPART_NAME <=", value, "checkedDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartNameLike(String value) {
            addCriterion("CHECKED_DEPART_NAME like", value, "checkedDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartNameNotLike(String value) {
            addCriterion("CHECKED_DEPART_NAME not like", value, "checkedDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartNameIn(List<String> values) {
            addCriterion("CHECKED_DEPART_NAME in", values, "checkedDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartNameNotIn(List<String> values) {
            addCriterion("CHECKED_DEPART_NAME not in", values, "checkedDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartNameBetween(String value1, String value2) {
            addCriterion("CHECKED_DEPART_NAME between", value1, value2, "checkedDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckedDepartNameNotBetween(String value1, String value2) {
            addCriterion("CHECKED_DEPART_NAME not between", value1, value2, "checkedDepartName");
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

        public Criteria andCheckDepartIdIsNull() {
            addCriterion("CHECK_DEPART_ID is null");
            return (Criteria) this;
        }

        public Criteria andCheckDepartIdIsNotNull() {
            addCriterion("CHECK_DEPART_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDepartIdEqualTo(String value) {
            addCriterion("CHECK_DEPART_ID =", value, "checkDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckDepartIdNotEqualTo(String value) {
            addCriterion("CHECK_DEPART_ID <>", value, "checkDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckDepartIdGreaterThan(String value) {
            addCriterion("CHECK_DEPART_ID >", value, "checkDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckDepartIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_DEPART_ID >=", value, "checkDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckDepartIdLessThan(String value) {
            addCriterion("CHECK_DEPART_ID <", value, "checkDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckDepartIdLessThanOrEqualTo(String value) {
            addCriterion("CHECK_DEPART_ID <=", value, "checkDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckDepartIdLike(String value) {
            addCriterion("CHECK_DEPART_ID like", value, "checkDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckDepartIdNotLike(String value) {
            addCriterion("CHECK_DEPART_ID not like", value, "checkDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckDepartIdIn(List<String> values) {
            addCriterion("CHECK_DEPART_ID in", values, "checkDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckDepartIdNotIn(List<String> values) {
            addCriterion("CHECK_DEPART_ID not in", values, "checkDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckDepartIdBetween(String value1, String value2) {
            addCriterion("CHECK_DEPART_ID between", value1, value2, "checkDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckDepartIdNotBetween(String value1, String value2) {
            addCriterion("CHECK_DEPART_ID not between", value1, value2, "checkDepartId");
            return (Criteria) this;
        }

        public Criteria andCheckDepartNameIsNull() {
            addCriterion("CHECK_DEPART_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCheckDepartNameIsNotNull() {
            addCriterion("CHECK_DEPART_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDepartNameEqualTo(String value) {
            addCriterion("CHECK_DEPART_NAME =", value, "checkDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckDepartNameNotEqualTo(String value) {
            addCriterion("CHECK_DEPART_NAME <>", value, "checkDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckDepartNameGreaterThan(String value) {
            addCriterion("CHECK_DEPART_NAME >", value, "checkDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckDepartNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_DEPART_NAME >=", value, "checkDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckDepartNameLessThan(String value) {
            addCriterion("CHECK_DEPART_NAME <", value, "checkDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckDepartNameLessThanOrEqualTo(String value) {
            addCriterion("CHECK_DEPART_NAME <=", value, "checkDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckDepartNameLike(String value) {
            addCriterion("CHECK_DEPART_NAME like", value, "checkDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckDepartNameNotLike(String value) {
            addCriterion("CHECK_DEPART_NAME not like", value, "checkDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckDepartNameIn(List<String> values) {
            addCriterion("CHECK_DEPART_NAME in", values, "checkDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckDepartNameNotIn(List<String> values) {
            addCriterion("CHECK_DEPART_NAME not in", values, "checkDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckDepartNameBetween(String value1, String value2) {
            addCriterion("CHECK_DEPART_NAME between", value1, value2, "checkDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckDepartNameNotBetween(String value1, String value2) {
            addCriterion("CHECK_DEPART_NAME not between", value1, value2, "checkDepartName");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIsNull() {
            addCriterion("CHECK_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIsNotNull() {
            addCriterion("CHECK_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeEqualTo(Date value) {
            addCriterion("CHECK_START_TIME =", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotEqualTo(Date value) {
            addCriterion("CHECK_START_TIME <>", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeGreaterThan(Date value) {
            addCriterion("CHECK_START_TIME >", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_START_TIME >=", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeLessThan(Date value) {
            addCriterion("CHECK_START_TIME <", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_START_TIME <=", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIn(List<Date> values) {
            addCriterion("CHECK_START_TIME in", values, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotIn(List<Date> values) {
            addCriterion("CHECK_START_TIME not in", values, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeBetween(Date value1, Date value2) {
            addCriterion("CHECK_START_TIME between", value1, value2, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_START_TIME not between", value1, value2, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIsNull() {
            addCriterion("CHECK_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIsNotNull() {
            addCriterion("CHECK_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeEqualTo(Date value) {
            addCriterion("CHECK_END_TIME =", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotEqualTo(Date value) {
            addCriterion("CHECK_END_TIME <>", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeGreaterThan(Date value) {
            addCriterion("CHECK_END_TIME >", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_END_TIME >=", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeLessThan(Date value) {
            addCriterion("CHECK_END_TIME <", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_END_TIME <=", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIn(List<Date> values) {
            addCriterion("CHECK_END_TIME in", values, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotIn(List<Date> values) {
            addCriterion("CHECK_END_TIME not in", values, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeBetween(Date value1, Date value2) {
            addCriterion("CHECK_END_TIME between", value1, value2, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_END_TIME not between", value1, value2, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("CHECK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("CHECK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Integer value) {
            addCriterion("CHECK_TIME =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Integer value) {
            addCriterion("CHECK_TIME <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Integer value) {
            addCriterion("CHECK_TIME >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHECK_TIME >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Integer value) {
            addCriterion("CHECK_TIME <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Integer value) {
            addCriterion("CHECK_TIME <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Integer> values) {
            addCriterion("CHECK_TIME in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Integer> values) {
            addCriterion("CHECK_TIME not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Integer value1, Integer value2) {
            addCriterion("CHECK_TIME between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("CHECK_TIME not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceTimeIsNull() {
            addCriterion("PLAY_VOICE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceTimeIsNotNull() {
            addCriterion("PLAY_VOICE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceTimeEqualTo(Integer value) {
            addCriterion("PLAY_VOICE_TIME =", value, "playVoiceTime");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceTimeNotEqualTo(Integer value) {
            addCriterion("PLAY_VOICE_TIME <>", value, "playVoiceTime");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceTimeGreaterThan(Integer value) {
            addCriterion("PLAY_VOICE_TIME >", value, "playVoiceTime");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLAY_VOICE_TIME >=", value, "playVoiceTime");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceTimeLessThan(Integer value) {
            addCriterion("PLAY_VOICE_TIME <", value, "playVoiceTime");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceTimeLessThanOrEqualTo(Integer value) {
            addCriterion("PLAY_VOICE_TIME <=", value, "playVoiceTime");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceTimeIn(List<Integer> values) {
            addCriterion("PLAY_VOICE_TIME in", values, "playVoiceTime");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceTimeNotIn(List<Integer> values) {
            addCriterion("PLAY_VOICE_TIME not in", values, "playVoiceTime");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceTimeBetween(Integer value1, Integer value2) {
            addCriterion("PLAY_VOICE_TIME between", value1, value2, "playVoiceTime");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("PLAY_VOICE_TIME not between", value1, value2, "playVoiceTime");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceNumIsNull() {
            addCriterion("PLAY_VOICE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceNumIsNotNull() {
            addCriterion("PLAY_VOICE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceNumEqualTo(Integer value) {
            addCriterion("PLAY_VOICE_NUM =", value, "playVoiceNum");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceNumNotEqualTo(Integer value) {
            addCriterion("PLAY_VOICE_NUM <>", value, "playVoiceNum");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceNumGreaterThan(Integer value) {
            addCriterion("PLAY_VOICE_NUM >", value, "playVoiceNum");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLAY_VOICE_NUM >=", value, "playVoiceNum");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceNumLessThan(Integer value) {
            addCriterion("PLAY_VOICE_NUM <", value, "playVoiceNum");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceNumLessThanOrEqualTo(Integer value) {
            addCriterion("PLAY_VOICE_NUM <=", value, "playVoiceNum");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceNumIn(List<Integer> values) {
            addCriterion("PLAY_VOICE_NUM in", values, "playVoiceNum");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceNumNotIn(List<Integer> values) {
            addCriterion("PLAY_VOICE_NUM not in", values, "playVoiceNum");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceNumBetween(Integer value1, Integer value2) {
            addCriterion("PLAY_VOICE_NUM between", value1, value2, "playVoiceNum");
            return (Criteria) this;
        }

        public Criteria andPlayVoiceNumNotBetween(Integer value1, Integer value2) {
            addCriterion("PLAY_VOICE_NUM not between", value1, value2, "playVoiceNum");
            return (Criteria) this;
        }

        public Criteria andScoreTypeIsNull() {
            addCriterion("SCORE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andScoreTypeIsNotNull() {
            addCriterion("SCORE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andScoreTypeEqualTo(String value) {
            addCriterion("SCORE_TYPE =", value, "scoreType");
            return (Criteria) this;
        }

        public Criteria andScoreTypeNotEqualTo(String value) {
            addCriterion("SCORE_TYPE <>", value, "scoreType");
            return (Criteria) this;
        }

        public Criteria andScoreTypeGreaterThan(String value) {
            addCriterion("SCORE_TYPE >", value, "scoreType");
            return (Criteria) this;
        }

        public Criteria andScoreTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SCORE_TYPE >=", value, "scoreType");
            return (Criteria) this;
        }

        public Criteria andScoreTypeLessThan(String value) {
            addCriterion("SCORE_TYPE <", value, "scoreType");
            return (Criteria) this;
        }

        public Criteria andScoreTypeLessThanOrEqualTo(String value) {
            addCriterion("SCORE_TYPE <=", value, "scoreType");
            return (Criteria) this;
        }

        public Criteria andScoreTypeLike(String value) {
            addCriterion("SCORE_TYPE like", value, "scoreType");
            return (Criteria) this;
        }

        public Criteria andScoreTypeNotLike(String value) {
            addCriterion("SCORE_TYPE not like", value, "scoreType");
            return (Criteria) this;
        }

        public Criteria andScoreTypeIn(List<String> values) {
            addCriterion("SCORE_TYPE in", values, "scoreType");
            return (Criteria) this;
        }

        public Criteria andScoreTypeNotIn(List<String> values) {
            addCriterion("SCORE_TYPE not in", values, "scoreType");
            return (Criteria) this;
        }

        public Criteria andScoreTypeBetween(String value1, String value2) {
            addCriterion("SCORE_TYPE between", value1, value2, "scoreType");
            return (Criteria) this;
        }

        public Criteria andScoreTypeNotBetween(String value1, String value2) {
            addCriterion("SCORE_TYPE not between", value1, value2, "scoreType");
            return (Criteria) this;
        }

        public Criteria andResultStatusIsNull() {
            addCriterion("RESULT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andResultStatusIsNotNull() {
            addCriterion("RESULT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andResultStatusEqualTo(String value) {
            addCriterion("RESULT_STATUS =", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusNotEqualTo(String value) {
            addCriterion("RESULT_STATUS <>", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusGreaterThan(String value) {
            addCriterion("RESULT_STATUS >", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT_STATUS >=", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusLessThan(String value) {
            addCriterion("RESULT_STATUS <", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusLessThanOrEqualTo(String value) {
            addCriterion("RESULT_STATUS <=", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusLike(String value) {
            addCriterion("RESULT_STATUS like", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusNotLike(String value) {
            addCriterion("RESULT_STATUS not like", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusIn(List<String> values) {
            addCriterion("RESULT_STATUS in", values, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusNotIn(List<String> values) {
            addCriterion("RESULT_STATUS not in", values, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusBetween(String value1, String value2) {
            addCriterion("RESULT_STATUS between", value1, value2, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusNotBetween(String value1, String value2) {
            addCriterion("RESULT_STATUS not between", value1, value2, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andLastResultFlagIsNull() {
            addCriterion("LAST_RESULT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andLastResultFlagIsNotNull() {
            addCriterion("LAST_RESULT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andLastResultFlagEqualTo(String value) {
            addCriterion("LAST_RESULT_FLAG =", value, "lastResultFlag");
            return (Criteria) this;
        }

        public Criteria andLastResultFlagNotEqualTo(String value) {
            addCriterion("LAST_RESULT_FLAG <>", value, "lastResultFlag");
            return (Criteria) this;
        }

        public Criteria andLastResultFlagGreaterThan(String value) {
            addCriterion("LAST_RESULT_FLAG >", value, "lastResultFlag");
            return (Criteria) this;
        }

        public Criteria andLastResultFlagGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_RESULT_FLAG >=", value, "lastResultFlag");
            return (Criteria) this;
        }

        public Criteria andLastResultFlagLessThan(String value) {
            addCriterion("LAST_RESULT_FLAG <", value, "lastResultFlag");
            return (Criteria) this;
        }

        public Criteria andLastResultFlagLessThanOrEqualTo(String value) {
            addCriterion("LAST_RESULT_FLAG <=", value, "lastResultFlag");
            return (Criteria) this;
        }

        public Criteria andLastResultFlagLike(String value) {
            addCriterion("LAST_RESULT_FLAG like", value, "lastResultFlag");
            return (Criteria) this;
        }

        public Criteria andLastResultFlagNotLike(String value) {
            addCriterion("LAST_RESULT_FLAG not like", value, "lastResultFlag");
            return (Criteria) this;
        }

        public Criteria andLastResultFlagIn(List<String> values) {
            addCriterion("LAST_RESULT_FLAG in", values, "lastResultFlag");
            return (Criteria) this;
        }

        public Criteria andLastResultFlagNotIn(List<String> values) {
            addCriterion("LAST_RESULT_FLAG not in", values, "lastResultFlag");
            return (Criteria) this;
        }

        public Criteria andLastResultFlagBetween(String value1, String value2) {
            addCriterion("LAST_RESULT_FLAG between", value1, value2, "lastResultFlag");
            return (Criteria) this;
        }

        public Criteria andLastResultFlagNotBetween(String value1, String value2) {
            addCriterion("LAST_RESULT_FLAG not between", value1, value2, "lastResultFlag");
            return (Criteria) this;
        }

        public Criteria andErrorRankIsNull() {
            addCriterion("ERROR_RANK is null");
            return (Criteria) this;
        }

        public Criteria andErrorRankIsNotNull() {
            addCriterion("ERROR_RANK is not null");
            return (Criteria) this;
        }

        public Criteria andErrorRankEqualTo(String value) {
            addCriterion("ERROR_RANK =", value, "errorRank");
            return (Criteria) this;
        }

        public Criteria andErrorRankNotEqualTo(String value) {
            addCriterion("ERROR_RANK <>", value, "errorRank");
            return (Criteria) this;
        }

        public Criteria andErrorRankGreaterThan(String value) {
            addCriterion("ERROR_RANK >", value, "errorRank");
            return (Criteria) this;
        }

        public Criteria andErrorRankGreaterThanOrEqualTo(String value) {
            addCriterion("ERROR_RANK >=", value, "errorRank");
            return (Criteria) this;
        }

        public Criteria andErrorRankLessThan(String value) {
            addCriterion("ERROR_RANK <", value, "errorRank");
            return (Criteria) this;
        }

        public Criteria andErrorRankLessThanOrEqualTo(String value) {
            addCriterion("ERROR_RANK <=", value, "errorRank");
            return (Criteria) this;
        }

        public Criteria andErrorRankLike(String value) {
            addCriterion("ERROR_RANK like", value, "errorRank");
            return (Criteria) this;
        }

        public Criteria andErrorRankNotLike(String value) {
            addCriterion("ERROR_RANK not like", value, "errorRank");
            return (Criteria) this;
        }

        public Criteria andErrorRankIn(List<String> values) {
            addCriterion("ERROR_RANK in", values, "errorRank");
            return (Criteria) this;
        }

        public Criteria andErrorRankNotIn(List<String> values) {
            addCriterion("ERROR_RANK not in", values, "errorRank");
            return (Criteria) this;
        }

        public Criteria andErrorRankBetween(String value1, String value2) {
            addCriterion("ERROR_RANK between", value1, value2, "errorRank");
            return (Criteria) this;
        }

        public Criteria andErrorRankNotBetween(String value1, String value2) {
            addCriterion("ERROR_RANK not between", value1, value2, "errorRank");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIsNull() {
            addCriterion("BUSI_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIsNotNull() {
            addCriterion("BUSI_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusiTypeEqualTo(String value) {
            addCriterion("BUSI_TYPE =", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotEqualTo(String value) {
            addCriterion("BUSI_TYPE <>", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeGreaterThan(String value) {
            addCriterion("BUSI_TYPE >", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSI_TYPE >=", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLessThan(String value) {
            addCriterion("BUSI_TYPE <", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSI_TYPE <=", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLike(String value) {
            addCriterion("BUSI_TYPE like", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotLike(String value) {
            addCriterion("BUSI_TYPE not like", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIn(List<String> values) {
            addCriterion("BUSI_TYPE in", values, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotIn(List<String> values) {
            addCriterion("BUSI_TYPE not in", values, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeBetween(String value1, String value2) {
            addCriterion("BUSI_TYPE between", value1, value2, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotBetween(String value1, String value2) {
            addCriterion("BUSI_TYPE not between", value1, value2, "busiType");
            return (Criteria) this;
        }

        public Criteria andFinalScoreIsNull() {
            addCriterion("FINAL_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andFinalScoreIsNotNull() {
            addCriterion("FINAL_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andFinalScoreEqualTo(BigDecimal value) {
            addCriterion("FINAL_SCORE =", value, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreNotEqualTo(BigDecimal value) {
            addCriterion("FINAL_SCORE <>", value, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreGreaterThan(BigDecimal value) {
            addCriterion("FINAL_SCORE >", value, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FINAL_SCORE >=", value, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreLessThan(BigDecimal value) {
            addCriterion("FINAL_SCORE <", value, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FINAL_SCORE <=", value, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreIn(List<BigDecimal> values) {
            addCriterion("FINAL_SCORE in", values, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreNotIn(List<BigDecimal> values) {
            addCriterion("FINAL_SCORE not in", values, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FINAL_SCORE between", value1, value2, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FINAL_SCORE not between", value1, value2, "finalScore");
            return (Criteria) this;
        }

        public Criteria andCheckCommentIsNull() {
            addCriterion("CHECK_COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andCheckCommentIsNotNull() {
            addCriterion("CHECK_COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andCheckCommentEqualTo(String value) {
            addCriterion("CHECK_COMMENT =", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentNotEqualTo(String value) {
            addCriterion("CHECK_COMMENT <>", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentGreaterThan(String value) {
            addCriterion("CHECK_COMMENT >", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_COMMENT >=", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentLessThan(String value) {
            addCriterion("CHECK_COMMENT <", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentLessThanOrEqualTo(String value) {
            addCriterion("CHECK_COMMENT <=", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentLike(String value) {
            addCriterion("CHECK_COMMENT like", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentNotLike(String value) {
            addCriterion("CHECK_COMMENT not like", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentIn(List<String> values) {
            addCriterion("CHECK_COMMENT in", values, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentNotIn(List<String> values) {
            addCriterion("CHECK_COMMENT not in", values, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentBetween(String value1, String value2) {
            addCriterion("CHECK_COMMENT between", value1, value2, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentNotBetween(String value1, String value2) {
            addCriterion("CHECK_COMMENT not between", value1, value2, "checkComment");
            return (Criteria) this;
        }

        public Criteria andAbandonStatusIsNull() {
            addCriterion("ABANDON_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAbandonStatusIsNotNull() {
            addCriterion("ABANDON_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonStatusEqualTo(String value) {
            addCriterion("ABANDON_STATUS =", value, "abandonStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonStatusNotEqualTo(String value) {
            addCriterion("ABANDON_STATUS <>", value, "abandonStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonStatusGreaterThan(String value) {
            addCriterion("ABANDON_STATUS >", value, "abandonStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ABANDON_STATUS >=", value, "abandonStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonStatusLessThan(String value) {
            addCriterion("ABANDON_STATUS <", value, "abandonStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonStatusLessThanOrEqualTo(String value) {
            addCriterion("ABANDON_STATUS <=", value, "abandonStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonStatusLike(String value) {
            addCriterion("ABANDON_STATUS like", value, "abandonStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonStatusNotLike(String value) {
            addCriterion("ABANDON_STATUS not like", value, "abandonStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonStatusIn(List<String> values) {
            addCriterion("ABANDON_STATUS in", values, "abandonStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonStatusNotIn(List<String> values) {
            addCriterion("ABANDON_STATUS not in", values, "abandonStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonStatusBetween(String value1, String value2) {
            addCriterion("ABANDON_STATUS between", value1, value2, "abandonStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonStatusNotBetween(String value1, String value2) {
            addCriterion("ABANDON_STATUS not between", value1, value2, "abandonStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonIsNull() {
            addCriterion("ABANDON_REASON is null");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonIsNotNull() {
            addCriterion("ABANDON_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonEqualTo(String value) {
            addCriterion("ABANDON_REASON =", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonNotEqualTo(String value) {
            addCriterion("ABANDON_REASON <>", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonGreaterThan(String value) {
            addCriterion("ABANDON_REASON >", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonGreaterThanOrEqualTo(String value) {
            addCriterion("ABANDON_REASON >=", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonLessThan(String value) {
            addCriterion("ABANDON_REASON <", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonLessThanOrEqualTo(String value) {
            addCriterion("ABANDON_REASON <=", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonLike(String value) {
            addCriterion("ABANDON_REASON like", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonNotLike(String value) {
            addCriterion("ABANDON_REASON not like", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonIn(List<String> values) {
            addCriterion("ABANDON_REASON in", values, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonNotIn(List<String> values) {
            addCriterion("ABANDON_REASON not in", values, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonBetween(String value1, String value2) {
            addCriterion("ABANDON_REASON between", value1, value2, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonNotBetween(String value1, String value2) {
            addCriterion("ABANDON_REASON not between", value1, value2, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonCommentIsNull() {
            addCriterion("ABANDON_COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andAbandonCommentIsNotNull() {
            addCriterion("ABANDON_COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonCommentEqualTo(String value) {
            addCriterion("ABANDON_COMMENT =", value, "abandonComment");
            return (Criteria) this;
        }

        public Criteria andAbandonCommentNotEqualTo(String value) {
            addCriterion("ABANDON_COMMENT <>", value, "abandonComment");
            return (Criteria) this;
        }

        public Criteria andAbandonCommentGreaterThan(String value) {
            addCriterion("ABANDON_COMMENT >", value, "abandonComment");
            return (Criteria) this;
        }

        public Criteria andAbandonCommentGreaterThanOrEqualTo(String value) {
            addCriterion("ABANDON_COMMENT >=", value, "abandonComment");
            return (Criteria) this;
        }

        public Criteria andAbandonCommentLessThan(String value) {
            addCriterion("ABANDON_COMMENT <", value, "abandonComment");
            return (Criteria) this;
        }

        public Criteria andAbandonCommentLessThanOrEqualTo(String value) {
            addCriterion("ABANDON_COMMENT <=", value, "abandonComment");
            return (Criteria) this;
        }

        public Criteria andAbandonCommentLike(String value) {
            addCriterion("ABANDON_COMMENT like", value, "abandonComment");
            return (Criteria) this;
        }

        public Criteria andAbandonCommentNotLike(String value) {
            addCriterion("ABANDON_COMMENT not like", value, "abandonComment");
            return (Criteria) this;
        }

        public Criteria andAbandonCommentIn(List<String> values) {
            addCriterion("ABANDON_COMMENT in", values, "abandonComment");
            return (Criteria) this;
        }

        public Criteria andAbandonCommentNotIn(List<String> values) {
            addCriterion("ABANDON_COMMENT not in", values, "abandonComment");
            return (Criteria) this;
        }

        public Criteria andAbandonCommentBetween(String value1, String value2) {
            addCriterion("ABANDON_COMMENT between", value1, value2, "abandonComment");
            return (Criteria) this;
        }

        public Criteria andAbandonCommentNotBetween(String value1, String value2) {
            addCriterion("ABANDON_COMMENT not between", value1, value2, "abandonComment");
            return (Criteria) this;
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

        public Criteria andAppealNumIsNull() {
            addCriterion("APPEAL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andAppealNumIsNotNull() {
            addCriterion("APPEAL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andAppealNumEqualTo(Integer value) {
            addCriterion("APPEAL_NUM =", value, "appealNum");
            return (Criteria) this;
        }

        public Criteria andAppealNumNotEqualTo(Integer value) {
            addCriterion("APPEAL_NUM <>", value, "appealNum");
            return (Criteria) this;
        }

        public Criteria andAppealNumGreaterThan(Integer value) {
            addCriterion("APPEAL_NUM >", value, "appealNum");
            return (Criteria) this;
        }

        public Criteria andAppealNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("APPEAL_NUM >=", value, "appealNum");
            return (Criteria) this;
        }

        public Criteria andAppealNumLessThan(Integer value) {
            addCriterion("APPEAL_NUM <", value, "appealNum");
            return (Criteria) this;
        }

        public Criteria andAppealNumLessThanOrEqualTo(Integer value) {
            addCriterion("APPEAL_NUM <=", value, "appealNum");
            return (Criteria) this;
        }

        public Criteria andAppealNumIn(List<Integer> values) {
            addCriterion("APPEAL_NUM in", values, "appealNum");
            return (Criteria) this;
        }

        public Criteria andAppealNumNotIn(List<Integer> values) {
            addCriterion("APPEAL_NUM not in", values, "appealNum");
            return (Criteria) this;
        }

        public Criteria andAppealNumBetween(Integer value1, Integer value2) {
            addCriterion("APPEAL_NUM between", value1, value2, "appealNum");
            return (Criteria) this;
        }

        public Criteria andAppealNumNotBetween(Integer value1, Integer value2) {
            addCriterion("APPEAL_NUM not between", value1, value2, "appealNum");
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

        public Criteria andOperateStaffIdIsNull() {
            addCriterion("OPERATE_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperateStaffIdIsNotNull() {
            addCriterion("OPERATE_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperateStaffIdEqualTo(String value) {
            addCriterion("OPERATE_STAFF_ID =", value, "operateStaffId");
            return (Criteria) this;
        }

        public Criteria andOperateStaffIdNotEqualTo(String value) {
            addCriterion("OPERATE_STAFF_ID <>", value, "operateStaffId");
            return (Criteria) this;
        }

        public Criteria andOperateStaffIdGreaterThan(String value) {
            addCriterion("OPERATE_STAFF_ID >", value, "operateStaffId");
            return (Criteria) this;
        }

        public Criteria andOperateStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE_STAFF_ID >=", value, "operateStaffId");
            return (Criteria) this;
        }

        public Criteria andOperateStaffIdLessThan(String value) {
            addCriterion("OPERATE_STAFF_ID <", value, "operateStaffId");
            return (Criteria) this;
        }

        public Criteria andOperateStaffIdLessThanOrEqualTo(String value) {
            addCriterion("OPERATE_STAFF_ID <=", value, "operateStaffId");
            return (Criteria) this;
        }

        public Criteria andOperateStaffIdLike(String value) {
            addCriterion("OPERATE_STAFF_ID like", value, "operateStaffId");
            return (Criteria) this;
        }

        public Criteria andOperateStaffIdNotLike(String value) {
            addCriterion("OPERATE_STAFF_ID not like", value, "operateStaffId");
            return (Criteria) this;
        }

        public Criteria andOperateStaffIdIn(List<String> values) {
            addCriterion("OPERATE_STAFF_ID in", values, "operateStaffId");
            return (Criteria) this;
        }

        public Criteria andOperateStaffIdNotIn(List<String> values) {
            addCriterion("OPERATE_STAFF_ID not in", values, "operateStaffId");
            return (Criteria) this;
        }

        public Criteria andOperateStaffIdBetween(String value1, String value2) {
            addCriterion("OPERATE_STAFF_ID between", value1, value2, "operateStaffId");
            return (Criteria) this;
        }

        public Criteria andOperateStaffIdNotBetween(String value1, String value2) {
            addCriterion("OPERATE_STAFF_ID not between", value1, value2, "operateStaffId");
            return (Criteria) this;
        }

        public Criteria andOperateReasonIsNull() {
            addCriterion("OPERATE_REASON is null");
            return (Criteria) this;
        }

        public Criteria andOperateReasonIsNotNull() {
            addCriterion("OPERATE_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andOperateReasonEqualTo(String value) {
            addCriterion("OPERATE_REASON =", value, "operateReason");
            return (Criteria) this;
        }

        public Criteria andOperateReasonNotEqualTo(String value) {
            addCriterion("OPERATE_REASON <>", value, "operateReason");
            return (Criteria) this;
        }

        public Criteria andOperateReasonGreaterThan(String value) {
            addCriterion("OPERATE_REASON >", value, "operateReason");
            return (Criteria) this;
        }

        public Criteria andOperateReasonGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE_REASON >=", value, "operateReason");
            return (Criteria) this;
        }

        public Criteria andOperateReasonLessThan(String value) {
            addCriterion("OPERATE_REASON <", value, "operateReason");
            return (Criteria) this;
        }

        public Criteria andOperateReasonLessThanOrEqualTo(String value) {
            addCriterion("OPERATE_REASON <=", value, "operateReason");
            return (Criteria) this;
        }

        public Criteria andOperateReasonLike(String value) {
            addCriterion("OPERATE_REASON like", value, "operateReason");
            return (Criteria) this;
        }

        public Criteria andOperateReasonNotLike(String value) {
            addCriterion("OPERATE_REASON not like", value, "operateReason");
            return (Criteria) this;
        }

        public Criteria andOperateReasonIn(List<String> values) {
            addCriterion("OPERATE_REASON in", values, "operateReason");
            return (Criteria) this;
        }

        public Criteria andOperateReasonNotIn(List<String> values) {
            addCriterion("OPERATE_REASON not in", values, "operateReason");
            return (Criteria) this;
        }

        public Criteria andOperateReasonBetween(String value1, String value2) {
            addCriterion("OPERATE_REASON between", value1, value2, "operateReason");
            return (Criteria) this;
        }

        public Criteria andOperateReasonNotBetween(String value1, String value2) {
            addCriterion("OPERATE_REASON not between", value1, value2, "operateReason");
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