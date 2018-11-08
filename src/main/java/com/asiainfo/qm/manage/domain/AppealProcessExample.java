package com.asiainfo.qm.manage.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppealProcessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppealProcessExample() {
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

        public Criteria andProcessIdIsNull() {
            addCriterion("PROCESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNotNull() {
            addCriterion("PROCESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdEqualTo(String value) {
            addCriterion("PROCESS_ID =", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotEqualTo(String value) {
            addCriterion("PROCESS_ID <>", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThan(String value) {
            addCriterion("PROCESS_ID >", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESS_ID >=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThan(String value) {
            addCriterion("PROCESS_ID <", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThanOrEqualTo(String value) {
            addCriterion("PROCESS_ID <=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLike(String value) {
            addCriterion("PROCESS_ID like", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotLike(String value) {
            addCriterion("PROCESS_ID not like", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIn(List<String> values) {
            addCriterion("PROCESS_ID in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotIn(List<String> values) {
            addCriterion("PROCESS_ID not in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdBetween(String value1, String value2) {
            addCriterion("PROCESS_ID between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotBetween(String value1, String value2) {
            addCriterion("PROCESS_ID not between", value1, value2, "processId");
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

        public Criteria andProcessNameIsNull() {
            addCriterion("PROCESS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNotNull() {
            addCriterion("PROCESS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNameEqualTo(String value) {
            addCriterion("PROCESS_NAME =", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotEqualTo(String value) {
            addCriterion("PROCESS_NAME <>", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThan(String value) {
            addCriterion("PROCESS_NAME >", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESS_NAME >=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThan(String value) {
            addCriterion("PROCESS_NAME <", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThanOrEqualTo(String value) {
            addCriterion("PROCESS_NAME <=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLike(String value) {
            addCriterion("PROCESS_NAME like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotLike(String value) {
            addCriterion("PROCESS_NAME not like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameIn(List<String> values) {
            addCriterion("PROCESS_NAME in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotIn(List<String> values) {
            addCriterion("PROCESS_NAME not in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameBetween(String value1, String value2) {
            addCriterion("PROCESS_NAME between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotBetween(String value1, String value2) {
            addCriterion("PROCESS_NAME not between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andParentProcessIdIsNull() {
            addCriterion("PARENT_PROCESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentProcessIdIsNotNull() {
            addCriterion("PARENT_PROCESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentProcessIdEqualTo(String value) {
            addCriterion("PARENT_PROCESS_ID =", value, "parentProcessId");
            return (Criteria) this;
        }

        public Criteria andParentProcessIdNotEqualTo(String value) {
            addCriterion("PARENT_PROCESS_ID <>", value, "parentProcessId");
            return (Criteria) this;
        }

        public Criteria andParentProcessIdGreaterThan(String value) {
            addCriterion("PARENT_PROCESS_ID >", value, "parentProcessId");
            return (Criteria) this;
        }

        public Criteria andParentProcessIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_PROCESS_ID >=", value, "parentProcessId");
            return (Criteria) this;
        }

        public Criteria andParentProcessIdLessThan(String value) {
            addCriterion("PARENT_PROCESS_ID <", value, "parentProcessId");
            return (Criteria) this;
        }

        public Criteria andParentProcessIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_PROCESS_ID <=", value, "parentProcessId");
            return (Criteria) this;
        }

        public Criteria andParentProcessIdLike(String value) {
            addCriterion("PARENT_PROCESS_ID like", value, "parentProcessId");
            return (Criteria) this;
        }

        public Criteria andParentProcessIdNotLike(String value) {
            addCriterion("PARENT_PROCESS_ID not like", value, "parentProcessId");
            return (Criteria) this;
        }

        public Criteria andParentProcessIdIn(List<String> values) {
            addCriterion("PARENT_PROCESS_ID in", values, "parentProcessId");
            return (Criteria) this;
        }

        public Criteria andParentProcessIdNotIn(List<String> values) {
            addCriterion("PARENT_PROCESS_ID not in", values, "parentProcessId");
            return (Criteria) this;
        }

        public Criteria andParentProcessIdBetween(String value1, String value2) {
            addCriterion("PARENT_PROCESS_ID between", value1, value2, "parentProcessId");
            return (Criteria) this;
        }

        public Criteria andParentProcessIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_PROCESS_ID not between", value1, value2, "parentProcessId");
            return (Criteria) this;
        }

        public Criteria andMainProcessFlagIsNull() {
            addCriterion("MAIN_PROCESS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andMainProcessFlagIsNotNull() {
            addCriterion("MAIN_PROCESS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andMainProcessFlagEqualTo(String value) {
            addCriterion("MAIN_PROCESS_FLAG =", value, "mainProcessFlag");
            return (Criteria) this;
        }

        public Criteria andMainProcessFlagNotEqualTo(String value) {
            addCriterion("MAIN_PROCESS_FLAG <>", value, "mainProcessFlag");
            return (Criteria) this;
        }

        public Criteria andMainProcessFlagGreaterThan(String value) {
            addCriterion("MAIN_PROCESS_FLAG >", value, "mainProcessFlag");
            return (Criteria) this;
        }

        public Criteria andMainProcessFlagGreaterThanOrEqualTo(String value) {
            addCriterion("MAIN_PROCESS_FLAG >=", value, "mainProcessFlag");
            return (Criteria) this;
        }

        public Criteria andMainProcessFlagLessThan(String value) {
            addCriterion("MAIN_PROCESS_FLAG <", value, "mainProcessFlag");
            return (Criteria) this;
        }

        public Criteria andMainProcessFlagLessThanOrEqualTo(String value) {
            addCriterion("MAIN_PROCESS_FLAG <=", value, "mainProcessFlag");
            return (Criteria) this;
        }

        public Criteria andMainProcessFlagLike(String value) {
            addCriterion("MAIN_PROCESS_FLAG like", value, "mainProcessFlag");
            return (Criteria) this;
        }

        public Criteria andMainProcessFlagNotLike(String value) {
            addCriterion("MAIN_PROCESS_FLAG not like", value, "mainProcessFlag");
            return (Criteria) this;
        }

        public Criteria andMainProcessFlagIn(List<String> values) {
            addCriterion("MAIN_PROCESS_FLAG in", values, "mainProcessFlag");
            return (Criteria) this;
        }

        public Criteria andMainProcessFlagNotIn(List<String> values) {
            addCriterion("MAIN_PROCESS_FLAG not in", values, "mainProcessFlag");
            return (Criteria) this;
        }

        public Criteria andMainProcessFlagBetween(String value1, String value2) {
            addCriterion("MAIN_PROCESS_FLAG between", value1, value2, "mainProcessFlag");
            return (Criteria) this;
        }

        public Criteria andMainProcessFlagNotBetween(String value1, String value2) {
            addCriterion("MAIN_PROCESS_FLAG not between", value1, value2, "mainProcessFlag");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("DEPARTMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("DEPARTMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("DEPARTMENT_ID =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("DEPARTMENT_ID <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("DEPARTMENT_ID >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEPARTMENT_ID >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("DEPARTMENT_ID <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("DEPARTMENT_ID <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("DEPARTMENT_ID like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("DEPARTMENT_ID not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("DEPARTMENT_ID in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("DEPARTMENT_ID not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("DEPARTMENT_ID between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("DEPARTMENT_ID not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("DEPARTMENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("DEPARTMENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("DEPARTMENT_NAME =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("DEPARTMENT_NAME <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("DEPARTMENT_NAME >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEPARTMENT_NAME >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("DEPARTMENT_NAME <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("DEPARTMENT_NAME <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("DEPARTMENT_NAME like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("DEPARTMENT_NAME not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("DEPARTMENT_NAME in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("DEPARTMENT_NAME not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("DEPARTMENT_NAME between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("DEPARTMENT_NAME not between", value1, value2, "departmentName");
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

        public Criteria andProcessValidFlagIsNull() {
            addCriterion("PROCESS_VALID_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andProcessValidFlagIsNotNull() {
            addCriterion("PROCESS_VALID_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andProcessValidFlagEqualTo(String value) {
            addCriterion("PROCESS_VALID_FLAG =", value, "processValidFlag");
            return (Criteria) this;
        }

        public Criteria andProcessValidFlagNotEqualTo(String value) {
            addCriterion("PROCESS_VALID_FLAG <>", value, "processValidFlag");
            return (Criteria) this;
        }

        public Criteria andProcessValidFlagGreaterThan(String value) {
            addCriterion("PROCESS_VALID_FLAG >", value, "processValidFlag");
            return (Criteria) this;
        }

        public Criteria andProcessValidFlagGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESS_VALID_FLAG >=", value, "processValidFlag");
            return (Criteria) this;
        }

        public Criteria andProcessValidFlagLessThan(String value) {
            addCriterion("PROCESS_VALID_FLAG <", value, "processValidFlag");
            return (Criteria) this;
        }

        public Criteria andProcessValidFlagLessThanOrEqualTo(String value) {
            addCriterion("PROCESS_VALID_FLAG <=", value, "processValidFlag");
            return (Criteria) this;
        }

        public Criteria andProcessValidFlagLike(String value) {
            addCriterion("PROCESS_VALID_FLAG like", value, "processValidFlag");
            return (Criteria) this;
        }

        public Criteria andProcessValidFlagNotLike(String value) {
            addCriterion("PROCESS_VALID_FLAG not like", value, "processValidFlag");
            return (Criteria) this;
        }

        public Criteria andProcessValidFlagIn(List<String> values) {
            addCriterion("PROCESS_VALID_FLAG in", values, "processValidFlag");
            return (Criteria) this;
        }

        public Criteria andProcessValidFlagNotIn(List<String> values) {
            addCriterion("PROCESS_VALID_FLAG not in", values, "processValidFlag");
            return (Criteria) this;
        }

        public Criteria andProcessValidFlagBetween(String value1, String value2) {
            addCriterion("PROCESS_VALID_FLAG between", value1, value2, "processValidFlag");
            return (Criteria) this;
        }

        public Criteria andProcessValidFlagNotBetween(String value1, String value2) {
            addCriterion("PROCESS_VALID_FLAG not between", value1, value2, "processValidFlag");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIsNull() {
            addCriterion("PROCESS_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIsNotNull() {
            addCriterion("PROCESS_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andProcessStatusEqualTo(String value) {
            addCriterion("PROCESS_STATUS =", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotEqualTo(String value) {
            addCriterion("PROCESS_STATUS <>", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThan(String value) {
            addCriterion("PROCESS_STATUS >", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESS_STATUS >=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThan(String value) {
            addCriterion("PROCESS_STATUS <", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThanOrEqualTo(String value) {
            addCriterion("PROCESS_STATUS <=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLike(String value) {
            addCriterion("PROCESS_STATUS like", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotLike(String value) {
            addCriterion("PROCESS_STATUS not like", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIn(List<String> values) {
            addCriterion("PROCESS_STATUS in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotIn(List<String> values) {
            addCriterion("PROCESS_STATUS not in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusBetween(String value1, String value2) {
            addCriterion("PROCESS_STATUS between", value1, value2, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotBetween(String value1, String value2) {
            addCriterion("PROCESS_STATUS not between", value1, value2, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessUseStatusIsNull() {
            addCriterion("PROCESS_USE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andProcessUseStatusIsNotNull() {
            addCriterion("PROCESS_USE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andProcessUseStatusEqualTo(String value) {
            addCriterion("PROCESS_USE_STATUS =", value, "processUseStatus");
            return (Criteria) this;
        }

        public Criteria andProcessUseStatusNotEqualTo(String value) {
            addCriterion("PROCESS_USE_STATUS <>", value, "processUseStatus");
            return (Criteria) this;
        }

        public Criteria andProcessUseStatusGreaterThan(String value) {
            addCriterion("PROCESS_USE_STATUS >", value, "processUseStatus");
            return (Criteria) this;
        }

        public Criteria andProcessUseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESS_USE_STATUS >=", value, "processUseStatus");
            return (Criteria) this;
        }

        public Criteria andProcessUseStatusLessThan(String value) {
            addCriterion("PROCESS_USE_STATUS <", value, "processUseStatus");
            return (Criteria) this;
        }

        public Criteria andProcessUseStatusLessThanOrEqualTo(String value) {
            addCriterion("PROCESS_USE_STATUS <=", value, "processUseStatus");
            return (Criteria) this;
        }

        public Criteria andProcessUseStatusLike(String value) {
            addCriterion("PROCESS_USE_STATUS like", value, "processUseStatus");
            return (Criteria) this;
        }

        public Criteria andProcessUseStatusNotLike(String value) {
            addCriterion("PROCESS_USE_STATUS not like", value, "processUseStatus");
            return (Criteria) this;
        }

        public Criteria andProcessUseStatusIn(List<String> values) {
            addCriterion("PROCESS_USE_STATUS in", values, "processUseStatus");
            return (Criteria) this;
        }

        public Criteria andProcessUseStatusNotIn(List<String> values) {
            addCriterion("PROCESS_USE_STATUS not in", values, "processUseStatus");
            return (Criteria) this;
        }

        public Criteria andProcessUseStatusBetween(String value1, String value2) {
            addCriterion("PROCESS_USE_STATUS between", value1, value2, "processUseStatus");
            return (Criteria) this;
        }

        public Criteria andProcessUseStatusNotBetween(String value1, String value2) {
            addCriterion("PROCESS_USE_STATUS not between", value1, value2, "processUseStatus");
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

        public Criteria andSubProcessNumIsNull() {
            addCriterion("SUB_PROCESS_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSubProcessNumIsNotNull() {
            addCriterion("SUB_PROCESS_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSubProcessNumEqualTo(Integer value) {
            addCriterion("SUB_PROCESS_NUM =", value, "subProcessNum");
            return (Criteria) this;
        }

        public Criteria andSubProcessNumNotEqualTo(Integer value) {
            addCriterion("SUB_PROCESS_NUM <>", value, "subProcessNum");
            return (Criteria) this;
        }

        public Criteria andSubProcessNumGreaterThan(Integer value) {
            addCriterion("SUB_PROCESS_NUM >", value, "subProcessNum");
            return (Criteria) this;
        }

        public Criteria andSubProcessNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUB_PROCESS_NUM >=", value, "subProcessNum");
            return (Criteria) this;
        }

        public Criteria andSubProcessNumLessThan(Integer value) {
            addCriterion("SUB_PROCESS_NUM <", value, "subProcessNum");
            return (Criteria) this;
        }

        public Criteria andSubProcessNumLessThanOrEqualTo(Integer value) {
            addCriterion("SUB_PROCESS_NUM <=", value, "subProcessNum");
            return (Criteria) this;
        }

        public Criteria andSubProcessNumIn(List<Integer> values) {
            addCriterion("SUB_PROCESS_NUM in", values, "subProcessNum");
            return (Criteria) this;
        }

        public Criteria andSubProcessNumNotIn(List<Integer> values) {
            addCriterion("SUB_PROCESS_NUM not in", values, "subProcessNum");
            return (Criteria) this;
        }

        public Criteria andSubProcessNumBetween(Integer value1, Integer value2) {
            addCriterion("SUB_PROCESS_NUM between", value1, value2, "subProcessNum");
            return (Criteria) this;
        }

        public Criteria andSubProcessNumNotBetween(Integer value1, Integer value2) {
            addCriterion("SUB_PROCESS_NUM not between", value1, value2, "subProcessNum");
            return (Criteria) this;
        }

        public Criteria andSubNodeNumIsNull() {
            addCriterion("SUB_NODE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSubNodeNumIsNotNull() {
            addCriterion("SUB_NODE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSubNodeNumEqualTo(Integer value) {
            addCriterion("SUB_NODE_NUM =", value, "subNodeNum");
            return (Criteria) this;
        }

        public Criteria andSubNodeNumNotEqualTo(Integer value) {
            addCriterion("SUB_NODE_NUM <>", value, "subNodeNum");
            return (Criteria) this;
        }

        public Criteria andSubNodeNumGreaterThan(Integer value) {
            addCriterion("SUB_NODE_NUM >", value, "subNodeNum");
            return (Criteria) this;
        }

        public Criteria andSubNodeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUB_NODE_NUM >=", value, "subNodeNum");
            return (Criteria) this;
        }

        public Criteria andSubNodeNumLessThan(Integer value) {
            addCriterion("SUB_NODE_NUM <", value, "subNodeNum");
            return (Criteria) this;
        }

        public Criteria andSubNodeNumLessThanOrEqualTo(Integer value) {
            addCriterion("SUB_NODE_NUM <=", value, "subNodeNum");
            return (Criteria) this;
        }

        public Criteria andSubNodeNumIn(List<Integer> values) {
            addCriterion("SUB_NODE_NUM in", values, "subNodeNum");
            return (Criteria) this;
        }

        public Criteria andSubNodeNumNotIn(List<Integer> values) {
            addCriterion("SUB_NODE_NUM not in", values, "subNodeNum");
            return (Criteria) this;
        }

        public Criteria andSubNodeNumBetween(Integer value1, Integer value2) {
            addCriterion("SUB_NODE_NUM between", value1, value2, "subNodeNum");
            return (Criteria) this;
        }

        public Criteria andSubNodeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("SUB_NODE_NUM not between", value1, value2, "subNodeNum");
            return (Criteria) this;
        }

        public Criteria andMaxAppealNumIsNull() {
            addCriterion("MAX_APPEAL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andMaxAppealNumIsNotNull() {
            addCriterion("MAX_APPEAL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAppealNumEqualTo(Integer value) {
            addCriterion("MAX_APPEAL_NUM =", value, "maxAppealNum");
            return (Criteria) this;
        }

        public Criteria andMaxAppealNumNotEqualTo(Integer value) {
            addCriterion("MAX_APPEAL_NUM <>", value, "maxAppealNum");
            return (Criteria) this;
        }

        public Criteria andMaxAppealNumGreaterThan(Integer value) {
            addCriterion("MAX_APPEAL_NUM >", value, "maxAppealNum");
            return (Criteria) this;
        }

        public Criteria andMaxAppealNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAX_APPEAL_NUM >=", value, "maxAppealNum");
            return (Criteria) this;
        }

        public Criteria andMaxAppealNumLessThan(Integer value) {
            addCriterion("MAX_APPEAL_NUM <", value, "maxAppealNum");
            return (Criteria) this;
        }

        public Criteria andMaxAppealNumLessThanOrEqualTo(Integer value) {
            addCriterion("MAX_APPEAL_NUM <=", value, "maxAppealNum");
            return (Criteria) this;
        }

        public Criteria andMaxAppealNumIn(List<Integer> values) {
            addCriterion("MAX_APPEAL_NUM in", values, "maxAppealNum");
            return (Criteria) this;
        }

        public Criteria andMaxAppealNumNotIn(List<Integer> values) {
            addCriterion("MAX_APPEAL_NUM not in", values, "maxAppealNum");
            return (Criteria) this;
        }

        public Criteria andMaxAppealNumBetween(Integer value1, Integer value2) {
            addCriterion("MAX_APPEAL_NUM between", value1, value2, "maxAppealNum");
            return (Criteria) this;
        }

        public Criteria andMaxAppealNumNotBetween(Integer value1, Integer value2) {
            addCriterion("MAX_APPEAL_NUM not between", value1, value2, "maxAppealNum");
            return (Criteria) this;
        }

        public Criteria andAttachProvinceIdIsNull() {
            addCriterion("ATTACH_PROVINCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andAttachProvinceIdIsNotNull() {
            addCriterion("ATTACH_PROVINCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAttachProvinceIdEqualTo(String value) {
            addCriterion("ATTACH_PROVINCE_ID =", value, "attachProvinceId");
            return (Criteria) this;
        }

        public Criteria andAttachProvinceIdNotEqualTo(String value) {
            addCriterion("ATTACH_PROVINCE_ID <>", value, "attachProvinceId");
            return (Criteria) this;
        }

        public Criteria andAttachProvinceIdGreaterThan(String value) {
            addCriterion("ATTACH_PROVINCE_ID >", value, "attachProvinceId");
            return (Criteria) this;
        }

        public Criteria andAttachProvinceIdGreaterThanOrEqualTo(String value) {
            addCriterion("ATTACH_PROVINCE_ID >=", value, "attachProvinceId");
            return (Criteria) this;
        }

        public Criteria andAttachProvinceIdLessThan(String value) {
            addCriterion("ATTACH_PROVINCE_ID <", value, "attachProvinceId");
            return (Criteria) this;
        }

        public Criteria andAttachProvinceIdLessThanOrEqualTo(String value) {
            addCriterion("ATTACH_PROVINCE_ID <=", value, "attachProvinceId");
            return (Criteria) this;
        }

        public Criteria andAttachProvinceIdLike(String value) {
            addCriterion("ATTACH_PROVINCE_ID like", value, "attachProvinceId");
            return (Criteria) this;
        }

        public Criteria andAttachProvinceIdNotLike(String value) {
            addCriterion("ATTACH_PROVINCE_ID not like", value, "attachProvinceId");
            return (Criteria) this;
        }

        public Criteria andAttachProvinceIdIn(List<String> values) {
            addCriterion("ATTACH_PROVINCE_ID in", values, "attachProvinceId");
            return (Criteria) this;
        }

        public Criteria andAttachProvinceIdNotIn(List<String> values) {
            addCriterion("ATTACH_PROVINCE_ID not in", values, "attachProvinceId");
            return (Criteria) this;
        }

        public Criteria andAttachProvinceIdBetween(String value1, String value2) {
            addCriterion("ATTACH_PROVINCE_ID between", value1, value2, "attachProvinceId");
            return (Criteria) this;
        }

        public Criteria andAttachProvinceIdNotBetween(String value1, String value2) {
            addCriterion("ATTACH_PROVINCE_ID not between", value1, value2, "attachProvinceId");
            return (Criteria) this;
        }

        public Criteria andAttachCityIdIsNull() {
            addCriterion("ATTACH_CITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andAttachCityIdIsNotNull() {
            addCriterion("ATTACH_CITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAttachCityIdEqualTo(String value) {
            addCriterion("ATTACH_CITY_ID =", value, "attachCityId");
            return (Criteria) this;
        }

        public Criteria andAttachCityIdNotEqualTo(String value) {
            addCriterion("ATTACH_CITY_ID <>", value, "attachCityId");
            return (Criteria) this;
        }

        public Criteria andAttachCityIdGreaterThan(String value) {
            addCriterion("ATTACH_CITY_ID >", value, "attachCityId");
            return (Criteria) this;
        }

        public Criteria andAttachCityIdGreaterThanOrEqualTo(String value) {
            addCriterion("ATTACH_CITY_ID >=", value, "attachCityId");
            return (Criteria) this;
        }

        public Criteria andAttachCityIdLessThan(String value) {
            addCriterion("ATTACH_CITY_ID <", value, "attachCityId");
            return (Criteria) this;
        }

        public Criteria andAttachCityIdLessThanOrEqualTo(String value) {
            addCriterion("ATTACH_CITY_ID <=", value, "attachCityId");
            return (Criteria) this;
        }

        public Criteria andAttachCityIdLike(String value) {
            addCriterion("ATTACH_CITY_ID like", value, "attachCityId");
            return (Criteria) this;
        }

        public Criteria andAttachCityIdNotLike(String value) {
            addCriterion("ATTACH_CITY_ID not like", value, "attachCityId");
            return (Criteria) this;
        }

        public Criteria andAttachCityIdIn(List<String> values) {
            addCriterion("ATTACH_CITY_ID in", values, "attachCityId");
            return (Criteria) this;
        }

        public Criteria andAttachCityIdNotIn(List<String> values) {
            addCriterion("ATTACH_CITY_ID not in", values, "attachCityId");
            return (Criteria) this;
        }

        public Criteria andAttachCityIdBetween(String value1, String value2) {
            addCriterion("ATTACH_CITY_ID between", value1, value2, "attachCityId");
            return (Criteria) this;
        }

        public Criteria andAttachCityIdNotBetween(String value1, String value2) {
            addCriterion("ATTACH_CITY_ID not between", value1, value2, "attachCityId");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("MODIFY_TIME =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("MODIFY_TIME <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("MODIFY_TIME >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("MODIFY_TIME <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("MODIFY_TIME in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("MODIFY_TIME not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyStaffIdIsNull() {
            addCriterion("MODIFY_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andModifyStaffIdIsNotNull() {
            addCriterion("MODIFY_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModifyStaffIdEqualTo(String value) {
            addCriterion("MODIFY_STAFF_ID =", value, "modifyStaffId");
            return (Criteria) this;
        }

        public Criteria andModifyStaffIdNotEqualTo(String value) {
            addCriterion("MODIFY_STAFF_ID <>", value, "modifyStaffId");
            return (Criteria) this;
        }

        public Criteria andModifyStaffIdGreaterThan(String value) {
            addCriterion("MODIFY_STAFF_ID >", value, "modifyStaffId");
            return (Criteria) this;
        }

        public Criteria andModifyStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFY_STAFF_ID >=", value, "modifyStaffId");
            return (Criteria) this;
        }

        public Criteria andModifyStaffIdLessThan(String value) {
            addCriterion("MODIFY_STAFF_ID <", value, "modifyStaffId");
            return (Criteria) this;
        }

        public Criteria andModifyStaffIdLessThanOrEqualTo(String value) {
            addCriterion("MODIFY_STAFF_ID <=", value, "modifyStaffId");
            return (Criteria) this;
        }

        public Criteria andModifyStaffIdLike(String value) {
            addCriterion("MODIFY_STAFF_ID like", value, "modifyStaffId");
            return (Criteria) this;
        }

        public Criteria andModifyStaffIdNotLike(String value) {
            addCriterion("MODIFY_STAFF_ID not like", value, "modifyStaffId");
            return (Criteria) this;
        }

        public Criteria andModifyStaffIdIn(List<String> values) {
            addCriterion("MODIFY_STAFF_ID in", values, "modifyStaffId");
            return (Criteria) this;
        }

        public Criteria andModifyStaffIdNotIn(List<String> values) {
            addCriterion("MODIFY_STAFF_ID not in", values, "modifyStaffId");
            return (Criteria) this;
        }

        public Criteria andModifyStaffIdBetween(String value1, String value2) {
            addCriterion("MODIFY_STAFF_ID between", value1, value2, "modifyStaffId");
            return (Criteria) this;
        }

        public Criteria andModifyStaffIdNotBetween(String value1, String value2) {
            addCriterion("MODIFY_STAFF_ID not between", value1, value2, "modifyStaffId");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("DELETE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("DELETE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterion("DELETE_TIME =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterion("DELETE_TIME <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterion("DELETE_TIME >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DELETE_TIME >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterion("DELETE_TIME <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("DELETE_TIME <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Date> values) {
            addCriterion("DELETE_TIME in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Date> values) {
            addCriterion("DELETE_TIME not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("DELETE_TIME between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("DELETE_TIME not between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteStaffIdIsNull() {
            addCriterion("DELETE_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeleteStaffIdIsNotNull() {
            addCriterion("DELETE_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteStaffIdEqualTo(String value) {
            addCriterion("DELETE_STAFF_ID =", value, "deleteStaffId");
            return (Criteria) this;
        }

        public Criteria andDeleteStaffIdNotEqualTo(String value) {
            addCriterion("DELETE_STAFF_ID <>", value, "deleteStaffId");
            return (Criteria) this;
        }

        public Criteria andDeleteStaffIdGreaterThan(String value) {
            addCriterion("DELETE_STAFF_ID >", value, "deleteStaffId");
            return (Criteria) this;
        }

        public Criteria andDeleteStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("DELETE_STAFF_ID >=", value, "deleteStaffId");
            return (Criteria) this;
        }

        public Criteria andDeleteStaffIdLessThan(String value) {
            addCriterion("DELETE_STAFF_ID <", value, "deleteStaffId");
            return (Criteria) this;
        }

        public Criteria andDeleteStaffIdLessThanOrEqualTo(String value) {
            addCriterion("DELETE_STAFF_ID <=", value, "deleteStaffId");
            return (Criteria) this;
        }

        public Criteria andDeleteStaffIdLike(String value) {
            addCriterion("DELETE_STAFF_ID like", value, "deleteStaffId");
            return (Criteria) this;
        }

        public Criteria andDeleteStaffIdNotLike(String value) {
            addCriterion("DELETE_STAFF_ID not like", value, "deleteStaffId");
            return (Criteria) this;
        }

        public Criteria andDeleteStaffIdIn(List<String> values) {
            addCriterion("DELETE_STAFF_ID in", values, "deleteStaffId");
            return (Criteria) this;
        }

        public Criteria andDeleteStaffIdNotIn(List<String> values) {
            addCriterion("DELETE_STAFF_ID not in", values, "deleteStaffId");
            return (Criteria) this;
        }

        public Criteria andDeleteStaffIdBetween(String value1, String value2) {
            addCriterion("DELETE_STAFF_ID between", value1, value2, "deleteStaffId");
            return (Criteria) this;
        }

        public Criteria andDeleteStaffIdNotBetween(String value1, String value2) {
            addCriterion("DELETE_STAFF_ID not between", value1, value2, "deleteStaffId");
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