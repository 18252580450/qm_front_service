package com.asiainfo.qm.manage.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckItemExample() {
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

        public Criteria andCheckitemIdIsNull() {
            addCriterion("CHECKITEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andCheckitemIdIsNotNull() {
            addCriterion("CHECKITEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCheckitemIdEqualTo(String value) {
            addCriterion("CHECKITEM_ID =", value, "checkitemId");
            return (Criteria) this;
        }

        public Criteria andCheckitemIdNotEqualTo(String value) {
            addCriterion("CHECKITEM_ID <>", value, "checkitemId");
            return (Criteria) this;
        }

        public Criteria andCheckitemIdGreaterThan(String value) {
            addCriterion("CHECKITEM_ID >", value, "checkitemId");
            return (Criteria) this;
        }

        public Criteria andCheckitemIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKITEM_ID >=", value, "checkitemId");
            return (Criteria) this;
        }

        public Criteria andCheckitemIdLessThan(String value) {
            addCriterion("CHECKITEM_ID <", value, "checkitemId");
            return (Criteria) this;
        }

        public Criteria andCheckitemIdLessThanOrEqualTo(String value) {
            addCriterion("CHECKITEM_ID <=", value, "checkitemId");
            return (Criteria) this;
        }

        public Criteria andCheckitemIdLike(String value) {
            addCriterion("CHECKITEM_ID like", value, "checkitemId");
            return (Criteria) this;
        }

        public Criteria andCheckitemIdNotLike(String value) {
            addCriterion("CHECKITEM_ID not like", value, "checkitemId");
            return (Criteria) this;
        }

        public Criteria andCheckitemIdIn(List<String> values) {
            addCriterion("CHECKITEM_ID in", values, "checkitemId");
            return (Criteria) this;
        }

        public Criteria andCheckitemIdNotIn(List<String> values) {
            addCriterion("CHECKITEM_ID not in", values, "checkitemId");
            return (Criteria) this;
        }

        public Criteria andCheckitemIdBetween(String value1, String value2) {
            addCriterion("CHECKITEM_ID between", value1, value2, "checkitemId");
            return (Criteria) this;
        }

        public Criteria andCheckitemIdNotBetween(String value1, String value2) {
            addCriterion("CHECKITEM_ID not between", value1, value2, "checkitemId");
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

        public Criteria andCheckitemNameIsNull() {
            addCriterion("CHECKITEM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCheckitemNameIsNotNull() {
            addCriterion("CHECKITEM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckitemNameEqualTo(String value) {
            addCriterion("CHECKITEM_NAME =", value, "checkitemName");
            return (Criteria) this;
        }

        public Criteria andCheckitemNameNotEqualTo(String value) {
            addCriterion("CHECKITEM_NAME <>", value, "checkitemName");
            return (Criteria) this;
        }

        public Criteria andCheckitemNameGreaterThan(String value) {
            addCriterion("CHECKITEM_NAME >", value, "checkitemName");
            return (Criteria) this;
        }

        public Criteria andCheckitemNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKITEM_NAME >=", value, "checkitemName");
            return (Criteria) this;
        }

        public Criteria andCheckitemNameLessThan(String value) {
            addCriterion("CHECKITEM_NAME <", value, "checkitemName");
            return (Criteria) this;
        }

        public Criteria andCheckitemNameLessThanOrEqualTo(String value) {
            addCriterion("CHECKITEM_NAME <=", value, "checkitemName");
            return (Criteria) this;
        }

        public Criteria andCheckitemNameLike(String value) {
            addCriterion("CHECKITEM_NAME like", value, "checkitemName");
            return (Criteria) this;
        }

        public Criteria andCheckitemNameNotLike(String value) {
            addCriterion("CHECKITEM_NAME not like", value, "checkitemName");
            return (Criteria) this;
        }

        public Criteria andCheckitemNameIn(List<String> values) {
            addCriterion("CHECKITEM_NAME in", values, "checkitemName");
            return (Criteria) this;
        }

        public Criteria andCheckitemNameNotIn(List<String> values) {
            addCriterion("CHECKITEM_NAME not in", values, "checkitemName");
            return (Criteria) this;
        }

        public Criteria andCheckitemNameBetween(String value1, String value2) {
            addCriterion("CHECKITEM_NAME between", value1, value2, "checkitemName");
            return (Criteria) this;
        }

        public Criteria andCheckitemNameNotBetween(String value1, String value2) {
            addCriterion("CHECKITEM_NAME not between", value1, value2, "checkitemName");
            return (Criteria) this;
        }

        public Criteria andParentCheckitemIdIsNull() {
            addCriterion("PARENT_CHECKITEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentCheckitemIdIsNotNull() {
            addCriterion("PARENT_CHECKITEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentCheckitemIdEqualTo(String value) {
            addCriterion("PARENT_CHECKITEM_ID =", value, "parentCheckitemId");
            return (Criteria) this;
        }

        public Criteria andParentCheckitemIdNotEqualTo(String value) {
            addCriterion("PARENT_CHECKITEM_ID <>", value, "parentCheckitemId");
            return (Criteria) this;
        }

        public Criteria andParentCheckitemIdGreaterThan(String value) {
            addCriterion("PARENT_CHECKITEM_ID >", value, "parentCheckitemId");
            return (Criteria) this;
        }

        public Criteria andParentCheckitemIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_CHECKITEM_ID >=", value, "parentCheckitemId");
            return (Criteria) this;
        }

        public Criteria andParentCheckitemIdLessThan(String value) {
            addCriterion("PARENT_CHECKITEM_ID <", value, "parentCheckitemId");
            return (Criteria) this;
        }

        public Criteria andParentCheckitemIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_CHECKITEM_ID <=", value, "parentCheckitemId");
            return (Criteria) this;
        }

        public Criteria andParentCheckitemIdLike(String value) {
            addCriterion("PARENT_CHECKITEM_ID like", value, "parentCheckitemId");
            return (Criteria) this;
        }

        public Criteria andParentCheckitemIdNotLike(String value) {
            addCriterion("PARENT_CHECKITEM_ID not like", value, "parentCheckitemId");
            return (Criteria) this;
        }

        public Criteria andParentCheckitemIdIn(List<String> values) {
            addCriterion("PARENT_CHECKITEM_ID in", values, "parentCheckitemId");
            return (Criteria) this;
        }

        public Criteria andParentCheckitemIdNotIn(List<String> values) {
            addCriterion("PARENT_CHECKITEM_ID not in", values, "parentCheckitemId");
            return (Criteria) this;
        }

        public Criteria andParentCheckitemIdBetween(String value1, String value2) {
            addCriterion("PARENT_CHECKITEM_ID between", value1, value2, "parentCheckitemId");
            return (Criteria) this;
        }

        public Criteria andParentCheckitemIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_CHECKITEM_ID not between", value1, value2, "parentCheckitemId");
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

        public Criteria andCurrentStatusIsNull() {
            addCriterion("CURRENT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusIsNotNull() {
            addCriterion("CURRENT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusEqualTo(String value) {
            addCriterion("CURRENT_STATUS =", value, "currentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusNotEqualTo(String value) {
            addCriterion("CURRENT_STATUS <>", value, "currentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusGreaterThan(String value) {
            addCriterion("CURRENT_STATUS >", value, "currentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENT_STATUS >=", value, "currentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusLessThan(String value) {
            addCriterion("CURRENT_STATUS <", value, "currentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusLessThanOrEqualTo(String value) {
            addCriterion("CURRENT_STATUS <=", value, "currentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusLike(String value) {
            addCriterion("CURRENT_STATUS like", value, "currentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusNotLike(String value) {
            addCriterion("CURRENT_STATUS not like", value, "currentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusIn(List<String> values) {
            addCriterion("CURRENT_STATUS in", values, "currentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusNotIn(List<String> values) {
            addCriterion("CURRENT_STATUS not in", values, "currentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusBetween(String value1, String value2) {
            addCriterion("CURRENT_STATUS between", value1, value2, "currentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusNotBetween(String value1, String value2) {
            addCriterion("CURRENT_STATUS not between", value1, value2, "currentStatus");
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

        public Criteria andCheckitemTypeIsNull() {
            addCriterion("CHECKITEM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCheckitemTypeIsNotNull() {
            addCriterion("CHECKITEM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckitemTypeEqualTo(String value) {
            addCriterion("CHECKITEM_TYPE =", value, "checkitemType");
            return (Criteria) this;
        }

        public Criteria andCheckitemTypeNotEqualTo(String value) {
            addCriterion("CHECKITEM_TYPE <>", value, "checkitemType");
            return (Criteria) this;
        }

        public Criteria andCheckitemTypeGreaterThan(String value) {
            addCriterion("CHECKITEM_TYPE >", value, "checkitemType");
            return (Criteria) this;
        }

        public Criteria andCheckitemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKITEM_TYPE >=", value, "checkitemType");
            return (Criteria) this;
        }

        public Criteria andCheckitemTypeLessThan(String value) {
            addCriterion("CHECKITEM_TYPE <", value, "checkitemType");
            return (Criteria) this;
        }

        public Criteria andCheckitemTypeLessThanOrEqualTo(String value) {
            addCriterion("CHECKITEM_TYPE <=", value, "checkitemType");
            return (Criteria) this;
        }

        public Criteria andCheckitemTypeLike(String value) {
            addCriterion("CHECKITEM_TYPE like", value, "checkitemType");
            return (Criteria) this;
        }

        public Criteria andCheckitemTypeNotLike(String value) {
            addCriterion("CHECKITEM_TYPE not like", value, "checkitemType");
            return (Criteria) this;
        }

        public Criteria andCheckitemTypeIn(List<String> values) {
            addCriterion("CHECKITEM_TYPE in", values, "checkitemType");
            return (Criteria) this;
        }

        public Criteria andCheckitemTypeNotIn(List<String> values) {
            addCriterion("CHECKITEM_TYPE not in", values, "checkitemType");
            return (Criteria) this;
        }

        public Criteria andCheckitemTypeBetween(String value1, String value2) {
            addCriterion("CHECKITEM_TYPE between", value1, value2, "checkitemType");
            return (Criteria) this;
        }

        public Criteria andCheckitemTypeNotBetween(String value1, String value2) {
            addCriterion("CHECKITEM_TYPE not between", value1, value2, "checkitemType");
            return (Criteria) this;
        }

        public Criteria andIsOrNoTscoreIsNull() {
            addCriterion("IS_OR_NO_TSCORE is null");
            return (Criteria) this;
        }

        public Criteria andIsOrNoTscoreIsNotNull() {
            addCriterion("IS_OR_NO_TSCORE is not null");
            return (Criteria) this;
        }

        public Criteria andIsOrNoTscoreEqualTo(String value) {
            addCriterion("IS_OR_NO_TSCORE =", value, "isOrNoTscore");
            return (Criteria) this;
        }

        public Criteria andIsOrNoTscoreNotEqualTo(String value) {
            addCriterion("IS_OR_NO_TSCORE <>", value, "isOrNoTscore");
            return (Criteria) this;
        }

        public Criteria andIsOrNoTscoreGreaterThan(String value) {
            addCriterion("IS_OR_NO_TSCORE >", value, "isOrNoTscore");
            return (Criteria) this;
        }

        public Criteria andIsOrNoTscoreGreaterThanOrEqualTo(String value) {
            addCriterion("IS_OR_NO_TSCORE >=", value, "isOrNoTscore");
            return (Criteria) this;
        }

        public Criteria andIsOrNoTscoreLessThan(String value) {
            addCriterion("IS_OR_NO_TSCORE <", value, "isOrNoTscore");
            return (Criteria) this;
        }

        public Criteria andIsOrNoTscoreLessThanOrEqualTo(String value) {
            addCriterion("IS_OR_NO_TSCORE <=", value, "isOrNoTscore");
            return (Criteria) this;
        }

        public Criteria andIsOrNoTscoreLike(String value) {
            addCriterion("IS_OR_NO_TSCORE like", value, "isOrNoTscore");
            return (Criteria) this;
        }

        public Criteria andIsOrNoTscoreNotLike(String value) {
            addCriterion("IS_OR_NO_TSCORE not like", value, "isOrNoTscore");
            return (Criteria) this;
        }

        public Criteria andIsOrNoTscoreIn(List<String> values) {
            addCriterion("IS_OR_NO_TSCORE in", values, "isOrNoTscore");
            return (Criteria) this;
        }

        public Criteria andIsOrNoTscoreNotIn(List<String> values) {
            addCriterion("IS_OR_NO_TSCORE not in", values, "isOrNoTscore");
            return (Criteria) this;
        }

        public Criteria andIsOrNoTscoreBetween(String value1, String value2) {
            addCriterion("IS_OR_NO_TSCORE between", value1, value2, "isOrNoTscore");
            return (Criteria) this;
        }

        public Criteria andIsOrNoTscoreNotBetween(String value1, String value2) {
            addCriterion("IS_OR_NO_TSCORE not between", value1, value2, "isOrNoTscore");
            return (Criteria) this;
        }

        public Criteria andTopLimitIsNull() {
            addCriterion("TOP_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andTopLimitIsNotNull() {
            addCriterion("TOP_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andTopLimitEqualTo(Integer value) {
            addCriterion("TOP_LIMIT =", value, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitNotEqualTo(Integer value) {
            addCriterion("TOP_LIMIT <>", value, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitGreaterThan(Integer value) {
            addCriterion("TOP_LIMIT >", value, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("TOP_LIMIT >=", value, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitLessThan(Integer value) {
            addCriterion("TOP_LIMIT <", value, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitLessThanOrEqualTo(Integer value) {
            addCriterion("TOP_LIMIT <=", value, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitIn(List<Integer> values) {
            addCriterion("TOP_LIMIT in", values, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitNotIn(List<Integer> values) {
            addCriterion("TOP_LIMIT not in", values, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitBetween(Integer value1, Integer value2) {
            addCriterion("TOP_LIMIT between", value1, value2, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("TOP_LIMIT not between", value1, value2, "topLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitIsNull() {
            addCriterion("LOW_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andLowLimitIsNotNull() {
            addCriterion("LOW_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andLowLimitEqualTo(Integer value) {
            addCriterion("LOW_LIMIT =", value, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitNotEqualTo(Integer value) {
            addCriterion("LOW_LIMIT <>", value, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitGreaterThan(Integer value) {
            addCriterion("LOW_LIMIT >", value, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOW_LIMIT >=", value, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitLessThan(Integer value) {
            addCriterion("LOW_LIMIT <", value, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitLessThanOrEqualTo(Integer value) {
            addCriterion("LOW_LIMIT <=", value, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitIn(List<Integer> values) {
            addCriterion("LOW_LIMIT in", values, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitNotIn(List<Integer> values) {
            addCriterion("LOW_LIMIT not in", values, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitBetween(Integer value1, Integer value2) {
            addCriterion("LOW_LIMIT between", value1, value2, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("LOW_LIMIT not between", value1, value2, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andTopWarnIsNull() {
            addCriterion("TOP_WARN is null");
            return (Criteria) this;
        }

        public Criteria andTopWarnIsNotNull() {
            addCriterion("TOP_WARN is not null");
            return (Criteria) this;
        }

        public Criteria andTopWarnEqualTo(Float value) {
            addCriterion("TOP_WARN =", value, "topWarn");
            return (Criteria) this;
        }

        public Criteria andTopWarnNotEqualTo(Float value) {
            addCriterion("TOP_WARN <>", value, "topWarn");
            return (Criteria) this;
        }

        public Criteria andTopWarnGreaterThan(Float value) {
            addCriterion("TOP_WARN >", value, "topWarn");
            return (Criteria) this;
        }

        public Criteria andTopWarnGreaterThanOrEqualTo(Float value) {
            addCriterion("TOP_WARN >=", value, "topWarn");
            return (Criteria) this;
        }

        public Criteria andTopWarnLessThan(Float value) {
            addCriterion("TOP_WARN <", value, "topWarn");
            return (Criteria) this;
        }

        public Criteria andTopWarnLessThanOrEqualTo(Float value) {
            addCriterion("TOP_WARN <=", value, "topWarn");
            return (Criteria) this;
        }

        public Criteria andTopWarnIn(List<Float> values) {
            addCriterion("TOP_WARN in", values, "topWarn");
            return (Criteria) this;
        }

        public Criteria andTopWarnNotIn(List<Float> values) {
            addCriterion("TOP_WARN not in", values, "topWarn");
            return (Criteria) this;
        }

        public Criteria andTopWarnBetween(Float value1, Float value2) {
            addCriterion("TOP_WARN between", value1, value2, "topWarn");
            return (Criteria) this;
        }

        public Criteria andTopWarnNotBetween(Float value1, Float value2) {
            addCriterion("TOP_WARN not between", value1, value2, "topWarn");
            return (Criteria) this;
        }

        public Criteria andLowWarnIsNull() {
            addCriterion("LOW_WARN is null");
            return (Criteria) this;
        }

        public Criteria andLowWarnIsNotNull() {
            addCriterion("LOW_WARN is not null");
            return (Criteria) this;
        }

        public Criteria andLowWarnEqualTo(Float value) {
            addCriterion("LOW_WARN =", value, "lowWarn");
            return (Criteria) this;
        }

        public Criteria andLowWarnNotEqualTo(Float value) {
            addCriterion("LOW_WARN <>", value, "lowWarn");
            return (Criteria) this;
        }

        public Criteria andLowWarnGreaterThan(Float value) {
            addCriterion("LOW_WARN >", value, "lowWarn");
            return (Criteria) this;
        }

        public Criteria andLowWarnGreaterThanOrEqualTo(Float value) {
            addCriterion("LOW_WARN >=", value, "lowWarn");
            return (Criteria) this;
        }

        public Criteria andLowWarnLessThan(Float value) {
            addCriterion("LOW_WARN <", value, "lowWarn");
            return (Criteria) this;
        }

        public Criteria andLowWarnLessThanOrEqualTo(Float value) {
            addCriterion("LOW_WARN <=", value, "lowWarn");
            return (Criteria) this;
        }

        public Criteria andLowWarnIn(List<Float> values) {
            addCriterion("LOW_WARN in", values, "lowWarn");
            return (Criteria) this;
        }

        public Criteria andLowWarnNotIn(List<Float> values) {
            addCriterion("LOW_WARN not in", values, "lowWarn");
            return (Criteria) this;
        }

        public Criteria andLowWarnBetween(Float value1, Float value2) {
            addCriterion("LOW_WARN between", value1, value2, "lowWarn");
            return (Criteria) this;
        }

        public Criteria andLowWarnNotBetween(Float value1, Float value2) {
            addCriterion("LOW_WARN not between", value1, value2, "lowWarn");
            return (Criteria) this;
        }

        public Criteria andInfluenceScopeIsNull() {
            addCriterion("INFLUENCE_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andInfluenceScopeIsNotNull() {
            addCriterion("INFLUENCE_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andInfluenceScopeEqualTo(String value) {
            addCriterion("INFLUENCE_SCOPE =", value, "influenceScope");
            return (Criteria) this;
        }

        public Criteria andInfluenceScopeNotEqualTo(String value) {
            addCriterion("INFLUENCE_SCOPE <>", value, "influenceScope");
            return (Criteria) this;
        }

        public Criteria andInfluenceScopeGreaterThan(String value) {
            addCriterion("INFLUENCE_SCOPE >", value, "influenceScope");
            return (Criteria) this;
        }

        public Criteria andInfluenceScopeGreaterThanOrEqualTo(String value) {
            addCriterion("INFLUENCE_SCOPE >=", value, "influenceScope");
            return (Criteria) this;
        }

        public Criteria andInfluenceScopeLessThan(String value) {
            addCriterion("INFLUENCE_SCOPE <", value, "influenceScope");
            return (Criteria) this;
        }

        public Criteria andInfluenceScopeLessThanOrEqualTo(String value) {
            addCriterion("INFLUENCE_SCOPE <=", value, "influenceScope");
            return (Criteria) this;
        }

        public Criteria andInfluenceScopeLike(String value) {
            addCriterion("INFLUENCE_SCOPE like", value, "influenceScope");
            return (Criteria) this;
        }

        public Criteria andInfluenceScopeNotLike(String value) {
            addCriterion("INFLUENCE_SCOPE not like", value, "influenceScope");
            return (Criteria) this;
        }

        public Criteria andInfluenceScopeIn(List<String> values) {
            addCriterion("INFLUENCE_SCOPE in", values, "influenceScope");
            return (Criteria) this;
        }

        public Criteria andInfluenceScopeNotIn(List<String> values) {
            addCriterion("INFLUENCE_SCOPE not in", values, "influenceScope");
            return (Criteria) this;
        }

        public Criteria andInfluenceScopeBetween(String value1, String value2) {
            addCriterion("INFLUENCE_SCOPE between", value1, value2, "influenceScope");
            return (Criteria) this;
        }

        public Criteria andInfluenceScopeNotBetween(String value1, String value2) {
            addCriterion("INFLUENCE_SCOPE not between", value1, value2, "influenceScope");
            return (Criteria) this;
        }

        public Criteria andCatalogFlagIsNull() {
            addCriterion("CATALOG_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCatalogFlagIsNotNull() {
            addCriterion("CATALOG_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogFlagEqualTo(String value) {
            addCriterion("CATALOG_FLAG =", value, "catalogFlag");
            return (Criteria) this;
        }

        public Criteria andCatalogFlagNotEqualTo(String value) {
            addCriterion("CATALOG_FLAG <>", value, "catalogFlag");
            return (Criteria) this;
        }

        public Criteria andCatalogFlagGreaterThan(String value) {
            addCriterion("CATALOG_FLAG >", value, "catalogFlag");
            return (Criteria) this;
        }

        public Criteria andCatalogFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CATALOG_FLAG >=", value, "catalogFlag");
            return (Criteria) this;
        }

        public Criteria andCatalogFlagLessThan(String value) {
            addCriterion("CATALOG_FLAG <", value, "catalogFlag");
            return (Criteria) this;
        }

        public Criteria andCatalogFlagLessThanOrEqualTo(String value) {
            addCriterion("CATALOG_FLAG <=", value, "catalogFlag");
            return (Criteria) this;
        }

        public Criteria andCatalogFlagLike(String value) {
            addCriterion("CATALOG_FLAG like", value, "catalogFlag");
            return (Criteria) this;
        }

        public Criteria andCatalogFlagNotLike(String value) {
            addCriterion("CATALOG_FLAG not like", value, "catalogFlag");
            return (Criteria) this;
        }

        public Criteria andCatalogFlagIn(List<String> values) {
            addCriterion("CATALOG_FLAG in", values, "catalogFlag");
            return (Criteria) this;
        }

        public Criteria andCatalogFlagNotIn(List<String> values) {
            addCriterion("CATALOG_FLAG not in", values, "catalogFlag");
            return (Criteria) this;
        }

        public Criteria andCatalogFlagBetween(String value1, String value2) {
            addCriterion("CATALOG_FLAG between", value1, value2, "catalogFlag");
            return (Criteria) this;
        }

        public Criteria andCatalogFlagNotBetween(String value1, String value2) {
            addCriterion("CATALOG_FLAG not between", value1, value2, "catalogFlag");
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

        public Criteria andRequiredFlagIsNull() {
            addCriterion("REQUIRED_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andRequiredFlagIsNotNull() {
            addCriterion("REQUIRED_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredFlagEqualTo(String value) {
            addCriterion("REQUIRED_FLAG =", value, "requiredFlag");
            return (Criteria) this;
        }

        public Criteria andRequiredFlagNotEqualTo(String value) {
            addCriterion("REQUIRED_FLAG <>", value, "requiredFlag");
            return (Criteria) this;
        }

        public Criteria andRequiredFlagGreaterThan(String value) {
            addCriterion("REQUIRED_FLAG >", value, "requiredFlag");
            return (Criteria) this;
        }

        public Criteria andRequiredFlagGreaterThanOrEqualTo(String value) {
            addCriterion("REQUIRED_FLAG >=", value, "requiredFlag");
            return (Criteria) this;
        }

        public Criteria andRequiredFlagLessThan(String value) {
            addCriterion("REQUIRED_FLAG <", value, "requiredFlag");
            return (Criteria) this;
        }

        public Criteria andRequiredFlagLessThanOrEqualTo(String value) {
            addCriterion("REQUIRED_FLAG <=", value, "requiredFlag");
            return (Criteria) this;
        }

        public Criteria andRequiredFlagLike(String value) {
            addCriterion("REQUIRED_FLAG like", value, "requiredFlag");
            return (Criteria) this;
        }

        public Criteria andRequiredFlagNotLike(String value) {
            addCriterion("REQUIRED_FLAG not like", value, "requiredFlag");
            return (Criteria) this;
        }

        public Criteria andRequiredFlagIn(List<String> values) {
            addCriterion("REQUIRED_FLAG in", values, "requiredFlag");
            return (Criteria) this;
        }

        public Criteria andRequiredFlagNotIn(List<String> values) {
            addCriterion("REQUIRED_FLAG not in", values, "requiredFlag");
            return (Criteria) this;
        }

        public Criteria andRequiredFlagBetween(String value1, String value2) {
            addCriterion("REQUIRED_FLAG between", value1, value2, "requiredFlag");
            return (Criteria) this;
        }

        public Criteria andRequiredFlagNotBetween(String value1, String value2) {
            addCriterion("REQUIRED_FLAG not between", value1, value2, "requiredFlag");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(Integer value) {
            addCriterion("ORDER_NO =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(Integer value) {
            addCriterion("ORDER_NO <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(Integer value) {
            addCriterion("ORDER_NO >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_NO >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(Integer value) {
            addCriterion("ORDER_NO <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_NO <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<Integer> values) {
            addCriterion("ORDER_NO in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<Integer> values) {
            addCriterion("ORDER_NO not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_NO between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_NO not between", value1, value2, "orderNo");
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