package com.asiainfo.qm.manage.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TypicalCaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TypicalCaseExample() {
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

        public Criteria andCaseIdIsNull() {
            addCriterion("CASE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNotNull() {
            addCriterion("CASE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCaseIdEqualTo(String value) {
            addCriterion("CASE_ID =", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotEqualTo(String value) {
            addCriterion("CASE_ID <>", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThan(String value) {
            addCriterion("CASE_ID >", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThanOrEqualTo(String value) {
            addCriterion("CASE_ID >=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThan(String value) {
            addCriterion("CASE_ID <", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThanOrEqualTo(String value) {
            addCriterion("CASE_ID <=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLike(String value) {
            addCriterion("CASE_ID like", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotLike(String value) {
            addCriterion("CASE_ID not like", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdIn(List<String> values) {
            addCriterion("CASE_ID in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotIn(List<String> values) {
            addCriterion("CASE_ID not in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdBetween(String value1, String value2) {
            addCriterion("CASE_ID between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotBetween(String value1, String value2) {
            addCriterion("CASE_ID not between", value1, value2, "caseId");
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

        public Criteria andCaseTypeIsNull() {
            addCriterion("CASE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIsNotNull() {
            addCriterion("CASE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeEqualTo(String value) {
            addCriterion("CASE_TYPE =", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotEqualTo(String value) {
            addCriterion("CASE_TYPE <>", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThan(String value) {
            addCriterion("CASE_TYPE >", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CASE_TYPE >=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThan(String value) {
            addCriterion("CASE_TYPE <", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThanOrEqualTo(String value) {
            addCriterion("CASE_TYPE <=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLike(String value) {
            addCriterion("CASE_TYPE like", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotLike(String value) {
            addCriterion("CASE_TYPE not like", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIn(List<String> values) {
            addCriterion("CASE_TYPE in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotIn(List<String> values) {
            addCriterion("CASE_TYPE not in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeBetween(String value1, String value2) {
            addCriterion("CASE_TYPE between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotBetween(String value1, String value2) {
            addCriterion("CASE_TYPE not between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTitleIsNull() {
            addCriterion("CASE_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andCaseTitleIsNotNull() {
            addCriterion("CASE_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andCaseTitleEqualTo(String value) {
            addCriterion("CASE_TITLE =", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleNotEqualTo(String value) {
            addCriterion("CASE_TITLE <>", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleGreaterThan(String value) {
            addCriterion("CASE_TITLE >", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleGreaterThanOrEqualTo(String value) {
            addCriterion("CASE_TITLE >=", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleLessThan(String value) {
            addCriterion("CASE_TITLE <", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleLessThanOrEqualTo(String value) {
            addCriterion("CASE_TITLE <=", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleLike(String value) {
            addCriterion("CASE_TITLE like", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleNotLike(String value) {
            addCriterion("CASE_TITLE not like", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleIn(List<String> values) {
            addCriterion("CASE_TITLE in", values, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleNotIn(List<String> values) {
            addCriterion("CASE_TITLE not in", values, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleBetween(String value1, String value2) {
            addCriterion("CASE_TITLE between", value1, value2, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleNotBetween(String value1, String value2) {
            addCriterion("CASE_TITLE not between", value1, value2, "caseTitle");
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

        public Criteria andCreateReasonIsNull() {
            addCriterion("CREATE_REASON is null");
            return (Criteria) this;
        }

        public Criteria andCreateReasonIsNotNull() {
            addCriterion("CREATE_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andCreateReasonEqualTo(String value) {
            addCriterion("CREATE_REASON =", value, "createReason");
            return (Criteria) this;
        }

        public Criteria andCreateReasonNotEqualTo(String value) {
            addCriterion("CREATE_REASON <>", value, "createReason");
            return (Criteria) this;
        }

        public Criteria andCreateReasonGreaterThan(String value) {
            addCriterion("CREATE_REASON >", value, "createReason");
            return (Criteria) this;
        }

        public Criteria andCreateReasonGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_REASON >=", value, "createReason");
            return (Criteria) this;
        }

        public Criteria andCreateReasonLessThan(String value) {
            addCriterion("CREATE_REASON <", value, "createReason");
            return (Criteria) this;
        }

        public Criteria andCreateReasonLessThanOrEqualTo(String value) {
            addCriterion("CREATE_REASON <=", value, "createReason");
            return (Criteria) this;
        }

        public Criteria andCreateReasonLike(String value) {
            addCriterion("CREATE_REASON like", value, "createReason");
            return (Criteria) this;
        }

        public Criteria andCreateReasonNotLike(String value) {
            addCriterion("CREATE_REASON not like", value, "createReason");
            return (Criteria) this;
        }

        public Criteria andCreateReasonIn(List<String> values) {
            addCriterion("CREATE_REASON in", values, "createReason");
            return (Criteria) this;
        }

        public Criteria andCreateReasonNotIn(List<String> values) {
            addCriterion("CREATE_REASON not in", values, "createReason");
            return (Criteria) this;
        }

        public Criteria andCreateReasonBetween(String value1, String value2) {
            addCriterion("CREATE_REASON between", value1, value2, "createReason");
            return (Criteria) this;
        }

        public Criteria andCreateReasonNotBetween(String value1, String value2) {
            addCriterion("CREATE_REASON not between", value1, value2, "createReason");
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

        public Criteria andCreateStaffNameIsNull() {
            addCriterion("CREATE_STAFF_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNameIsNotNull() {
            addCriterion("CREATE_STAFF_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNameEqualTo(String value) {
            addCriterion("CREATE_STAFF_NAME =", value, "createStaffName");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNameNotEqualTo(String value) {
            addCriterion("CREATE_STAFF_NAME <>", value, "createStaffName");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNameGreaterThan(String value) {
            addCriterion("CREATE_STAFF_NAME >", value, "createStaffName");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_STAFF_NAME >=", value, "createStaffName");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNameLessThan(String value) {
            addCriterion("CREATE_STAFF_NAME <", value, "createStaffName");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNameLessThanOrEqualTo(String value) {
            addCriterion("CREATE_STAFF_NAME <=", value, "createStaffName");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNameLike(String value) {
            addCriterion("CREATE_STAFF_NAME like", value, "createStaffName");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNameNotLike(String value) {
            addCriterion("CREATE_STAFF_NAME not like", value, "createStaffName");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNameIn(List<String> values) {
            addCriterion("CREATE_STAFF_NAME in", values, "createStaffName");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNameNotIn(List<String> values) {
            addCriterion("CREATE_STAFF_NAME not in", values, "createStaffName");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNameBetween(String value1, String value2) {
            addCriterion("CREATE_STAFF_NAME between", value1, value2, "createStaffName");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNameNotBetween(String value1, String value2) {
            addCriterion("CREATE_STAFF_NAME not between", value1, value2, "createStaffName");
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