package com.asiainfo.qm.manage.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderCheckResultDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderCheckResultDetailExample() {
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

        public Criteria andNodeIdIsNull() {
            addCriterion("NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(String value) {
            addCriterion("NODE_ID =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(String value) {
            addCriterion("NODE_ID <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(String value) {
            addCriterion("NODE_ID >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_ID >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(String value) {
            addCriterion("NODE_ID <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(String value) {
            addCriterion("NODE_ID <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLike(String value) {
            addCriterion("NODE_ID like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotLike(String value) {
            addCriterion("NODE_ID not like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<String> values) {
            addCriterion("NODE_ID in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<String> values) {
            addCriterion("NODE_ID not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(String value1, String value2) {
            addCriterion("NODE_ID between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(String value1, String value2) {
            addCriterion("NODE_ID not between", value1, value2, "nodeId");
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

        public Criteria andNodeTypeIsNull() {
            addCriterion("NODE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andNodeTypeIsNotNull() {
            addCriterion("NODE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andNodeTypeEqualTo(String value) {
            addCriterion("NODE_TYPE =", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotEqualTo(String value) {
            addCriterion("NODE_TYPE <>", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeGreaterThan(String value) {
            addCriterion("NODE_TYPE >", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_TYPE >=", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeLessThan(String value) {
            addCriterion("NODE_TYPE <", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeLessThanOrEqualTo(String value) {
            addCriterion("NODE_TYPE <=", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeLike(String value) {
            addCriterion("NODE_TYPE like", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotLike(String value) {
            addCriterion("NODE_TYPE not like", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeIn(List<String> values) {
            addCriterion("NODE_TYPE in", values, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotIn(List<String> values) {
            addCriterion("NODE_TYPE not in", values, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeBetween(String value1, String value2) {
            addCriterion("NODE_TYPE between", value1, value2, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotBetween(String value1, String value2) {
            addCriterion("NODE_TYPE not between", value1, value2, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNull() {
            addCriterion("NODE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNotNull() {
            addCriterion("NODE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNameEqualTo(String value) {
            addCriterion("NODE_NAME =", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotEqualTo(String value) {
            addCriterion("NODE_NAME <>", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThan(String value) {
            addCriterion("NODE_NAME >", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_NAME >=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThan(String value) {
            addCriterion("NODE_NAME <", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThanOrEqualTo(String value) {
            addCriterion("NODE_NAME <=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLike(String value) {
            addCriterion("NODE_NAME like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotLike(String value) {
            addCriterion("NODE_NAME not like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameIn(List<String> values) {
            addCriterion("NODE_NAME in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotIn(List<String> values) {
            addCriterion("NODE_NAME not in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameBetween(String value1, String value2) {
            addCriterion("NODE_NAME between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotBetween(String value1, String value2) {
            addCriterion("NODE_NAME not between", value1, value2, "nodeName");
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

        public Criteria andWeightIsNull() {
            addCriterion("WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("WEIGHT =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("WEIGHT <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("WEIGHT >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("WEIGHT >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("WEIGHT <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("WEIGHT <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("WEIGHT in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("WEIGHT not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("WEIGHT between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("WEIGHT not between", value1, value2, "weight");
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

        public Criteria andScoreScopeIsNull() {
            addCriterion("SCORE_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andScoreScopeIsNotNull() {
            addCriterion("SCORE_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andScoreScopeEqualTo(Integer value) {
            addCriterion("SCORE_SCOPE =", value, "scoreScope");
            return (Criteria) this;
        }

        public Criteria andScoreScopeNotEqualTo(Integer value) {
            addCriterion("SCORE_SCOPE <>", value, "scoreScope");
            return (Criteria) this;
        }

        public Criteria andScoreScopeGreaterThan(Integer value) {
            addCriterion("SCORE_SCOPE >", value, "scoreScope");
            return (Criteria) this;
        }

        public Criteria andScoreScopeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCORE_SCOPE >=", value, "scoreScope");
            return (Criteria) this;
        }

        public Criteria andScoreScopeLessThan(Integer value) {
            addCriterion("SCORE_SCOPE <", value, "scoreScope");
            return (Criteria) this;
        }

        public Criteria andScoreScopeLessThanOrEqualTo(Integer value) {
            addCriterion("SCORE_SCOPE <=", value, "scoreScope");
            return (Criteria) this;
        }

        public Criteria andScoreScopeIn(List<Integer> values) {
            addCriterion("SCORE_SCOPE in", values, "scoreScope");
            return (Criteria) this;
        }

        public Criteria andScoreScopeNotIn(List<Integer> values) {
            addCriterion("SCORE_SCOPE not in", values, "scoreScope");
            return (Criteria) this;
        }

        public Criteria andScoreScopeBetween(Integer value1, Integer value2) {
            addCriterion("SCORE_SCOPE between", value1, value2, "scoreScope");
            return (Criteria) this;
        }

        public Criteria andScoreScopeNotBetween(Integer value1, Integer value2) {
            addCriterion("SCORE_SCOPE not between", value1, value2, "scoreScope");
            return (Criteria) this;
        }

        public Criteria andMinScoreIsNull() {
            addCriterion("MIN_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andMinScoreIsNotNull() {
            addCriterion("MIN_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andMinScoreEqualTo(Integer value) {
            addCriterion("MIN_SCORE =", value, "minScore");
            return (Criteria) this;
        }

        public Criteria andMinScoreNotEqualTo(Integer value) {
            addCriterion("MIN_SCORE <>", value, "minScore");
            return (Criteria) this;
        }

        public Criteria andMinScoreGreaterThan(Integer value) {
            addCriterion("MIN_SCORE >", value, "minScore");
            return (Criteria) this;
        }

        public Criteria andMinScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("MIN_SCORE >=", value, "minScore");
            return (Criteria) this;
        }

        public Criteria andMinScoreLessThan(Integer value) {
            addCriterion("MIN_SCORE <", value, "minScore");
            return (Criteria) this;
        }

        public Criteria andMinScoreLessThanOrEqualTo(Integer value) {
            addCriterion("MIN_SCORE <=", value, "minScore");
            return (Criteria) this;
        }

        public Criteria andMinScoreIn(List<Integer> values) {
            addCriterion("MIN_SCORE in", values, "minScore");
            return (Criteria) this;
        }

        public Criteria andMinScoreNotIn(List<Integer> values) {
            addCriterion("MIN_SCORE not in", values, "minScore");
            return (Criteria) this;
        }

        public Criteria andMinScoreBetween(Integer value1, Integer value2) {
            addCriterion("MIN_SCORE between", value1, value2, "minScore");
            return (Criteria) this;
        }

        public Criteria andMinScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("MIN_SCORE not between", value1, value2, "minScore");
            return (Criteria) this;
        }

        public Criteria andMaxScoreIsNull() {
            addCriterion("MAX_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andMaxScoreIsNotNull() {
            addCriterion("MAX_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andMaxScoreEqualTo(Integer value) {
            addCriterion("MAX_SCORE =", value, "maxScore");
            return (Criteria) this;
        }

        public Criteria andMaxScoreNotEqualTo(Integer value) {
            addCriterion("MAX_SCORE <>", value, "maxScore");
            return (Criteria) this;
        }

        public Criteria andMaxScoreGreaterThan(Integer value) {
            addCriterion("MAX_SCORE >", value, "maxScore");
            return (Criteria) this;
        }

        public Criteria andMaxScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAX_SCORE >=", value, "maxScore");
            return (Criteria) this;
        }

        public Criteria andMaxScoreLessThan(Integer value) {
            addCriterion("MAX_SCORE <", value, "maxScore");
            return (Criteria) this;
        }

        public Criteria andMaxScoreLessThanOrEqualTo(Integer value) {
            addCriterion("MAX_SCORE <=", value, "maxScore");
            return (Criteria) this;
        }

        public Criteria andMaxScoreIn(List<Integer> values) {
            addCriterion("MAX_SCORE in", values, "maxScore");
            return (Criteria) this;
        }

        public Criteria andMaxScoreNotIn(List<Integer> values) {
            addCriterion("MAX_SCORE not in", values, "maxScore");
            return (Criteria) this;
        }

        public Criteria andMaxScoreBetween(Integer value1, Integer value2) {
            addCriterion("MAX_SCORE between", value1, value2, "maxScore");
            return (Criteria) this;
        }

        public Criteria andMaxScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("MAX_SCORE not between", value1, value2, "maxScore");
            return (Criteria) this;
        }

        public Criteria andRealScoreIsNull() {
            addCriterion("REAL_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andRealScoreIsNotNull() {
            addCriterion("REAL_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andRealScoreEqualTo(BigDecimal value) {
            addCriterion("REAL_SCORE =", value, "realScore");
            return (Criteria) this;
        }

        public Criteria andRealScoreNotEqualTo(BigDecimal value) {
            addCriterion("REAL_SCORE <>", value, "realScore");
            return (Criteria) this;
        }

        public Criteria andRealScoreGreaterThan(BigDecimal value) {
            addCriterion("REAL_SCORE >", value, "realScore");
            return (Criteria) this;
        }

        public Criteria andRealScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REAL_SCORE >=", value, "realScore");
            return (Criteria) this;
        }

        public Criteria andRealScoreLessThan(BigDecimal value) {
            addCriterion("REAL_SCORE <", value, "realScore");
            return (Criteria) this;
        }

        public Criteria andRealScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REAL_SCORE <=", value, "realScore");
            return (Criteria) this;
        }

        public Criteria andRealScoreIn(List<BigDecimal> values) {
            addCriterion("REAL_SCORE in", values, "realScore");
            return (Criteria) this;
        }

        public Criteria andRealScoreNotIn(List<BigDecimal> values) {
            addCriterion("REAL_SCORE not in", values, "realScore");
            return (Criteria) this;
        }

        public Criteria andRealScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REAL_SCORE between", value1, value2, "realScore");
            return (Criteria) this;
        }

        public Criteria andRealScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REAL_SCORE not between", value1, value2, "realScore");
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