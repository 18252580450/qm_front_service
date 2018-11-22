package com.asiainfo.qm.manage.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TemplateDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TemplateDetailExample() {
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

        public Criteria andPNodeIdIsNull() {
            addCriterion("P_NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPNodeIdIsNotNull() {
            addCriterion("P_NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPNodeIdEqualTo(String value) {
            addCriterion("P_NODE_ID =", value, "pNodeId");
            return (Criteria) this;
        }

        public Criteria andPNodeIdNotEqualTo(String value) {
            addCriterion("P_NODE_ID <>", value, "pNodeId");
            return (Criteria) this;
        }

        public Criteria andPNodeIdGreaterThan(String value) {
            addCriterion("P_NODE_ID >", value, "pNodeId");
            return (Criteria) this;
        }

        public Criteria andPNodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("P_NODE_ID >=", value, "pNodeId");
            return (Criteria) this;
        }

        public Criteria andPNodeIdLessThan(String value) {
            addCriterion("P_NODE_ID <", value, "pNodeId");
            return (Criteria) this;
        }

        public Criteria andPNodeIdLessThanOrEqualTo(String value) {
            addCriterion("P_NODE_ID <=", value, "pNodeId");
            return (Criteria) this;
        }

        public Criteria andPNodeIdLike(String value) {
            addCriterion("P_NODE_ID like", value, "pNodeId");
            return (Criteria) this;
        }

        public Criteria andPNodeIdNotLike(String value) {
            addCriterion("P_NODE_ID not like", value, "pNodeId");
            return (Criteria) this;
        }

        public Criteria andPNodeIdIn(List<String> values) {
            addCriterion("P_NODE_ID in", values, "pNodeId");
            return (Criteria) this;
        }

        public Criteria andPNodeIdNotIn(List<String> values) {
            addCriterion("P_NODE_ID not in", values, "pNodeId");
            return (Criteria) this;
        }

        public Criteria andPNodeIdBetween(String value1, String value2) {
            addCriterion("P_NODE_ID between", value1, value2, "pNodeId");
            return (Criteria) this;
        }

        public Criteria andPNodeIdNotBetween(String value1, String value2) {
            addCriterion("P_NODE_ID not between", value1, value2, "pNodeId");
            return (Criteria) this;
        }

        public Criteria andNodeStructIsNull() {
            addCriterion("NODE_STRUCT is null");
            return (Criteria) this;
        }

        public Criteria andNodeStructIsNotNull() {
            addCriterion("NODE_STRUCT is not null");
            return (Criteria) this;
        }

        public Criteria andNodeStructEqualTo(String value) {
            addCriterion("NODE_STRUCT =", value, "nodeStruct");
            return (Criteria) this;
        }

        public Criteria andNodeStructNotEqualTo(String value) {
            addCriterion("NODE_STRUCT <>", value, "nodeStruct");
            return (Criteria) this;
        }

        public Criteria andNodeStructGreaterThan(String value) {
            addCriterion("NODE_STRUCT >", value, "nodeStruct");
            return (Criteria) this;
        }

        public Criteria andNodeStructGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_STRUCT >=", value, "nodeStruct");
            return (Criteria) this;
        }

        public Criteria andNodeStructLessThan(String value) {
            addCriterion("NODE_STRUCT <", value, "nodeStruct");
            return (Criteria) this;
        }

        public Criteria andNodeStructLessThanOrEqualTo(String value) {
            addCriterion("NODE_STRUCT <=", value, "nodeStruct");
            return (Criteria) this;
        }

        public Criteria andNodeStructLike(String value) {
            addCriterion("NODE_STRUCT like", value, "nodeStruct");
            return (Criteria) this;
        }

        public Criteria andNodeStructNotLike(String value) {
            addCriterion("NODE_STRUCT not like", value, "nodeStruct");
            return (Criteria) this;
        }

        public Criteria andNodeStructIn(List<String> values) {
            addCriterion("NODE_STRUCT in", values, "nodeStruct");
            return (Criteria) this;
        }

        public Criteria andNodeStructNotIn(List<String> values) {
            addCriterion("NODE_STRUCT not in", values, "nodeStruct");
            return (Criteria) this;
        }

        public Criteria andNodeStructBetween(String value1, String value2) {
            addCriterion("NODE_STRUCT between", value1, value2, "nodeStruct");
            return (Criteria) this;
        }

        public Criteria andNodeStructNotBetween(String value1, String value2) {
            addCriterion("NODE_STRUCT not between", value1, value2, "nodeStruct");
            return (Criteria) this;
        }

        public Criteria andNodeScoreIsNull() {
            addCriterion("NODE_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andNodeScoreIsNotNull() {
            addCriterion("NODE_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andNodeScoreEqualTo(Integer value) {
            addCriterion("NODE_SCORE =", value, "nodeScore");
            return (Criteria) this;
        }

        public Criteria andNodeScoreNotEqualTo(Integer value) {
            addCriterion("NODE_SCORE <>", value, "nodeScore");
            return (Criteria) this;
        }

        public Criteria andNodeScoreGreaterThan(Integer value) {
            addCriterion("NODE_SCORE >", value, "nodeScore");
            return (Criteria) this;
        }

        public Criteria andNodeScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("NODE_SCORE >=", value, "nodeScore");
            return (Criteria) this;
        }

        public Criteria andNodeScoreLessThan(Integer value) {
            addCriterion("NODE_SCORE <", value, "nodeScore");
            return (Criteria) this;
        }

        public Criteria andNodeScoreLessThanOrEqualTo(Integer value) {
            addCriterion("NODE_SCORE <=", value, "nodeScore");
            return (Criteria) this;
        }

        public Criteria andNodeScoreIn(List<Integer> values) {
            addCriterion("NODE_SCORE in", values, "nodeScore");
            return (Criteria) this;
        }

        public Criteria andNodeScoreNotIn(List<Integer> values) {
            addCriterion("NODE_SCORE not in", values, "nodeScore");
            return (Criteria) this;
        }

        public Criteria andNodeScoreBetween(Integer value1, Integer value2) {
            addCriterion("NODE_SCORE between", value1, value2, "nodeScore");
            return (Criteria) this;
        }

        public Criteria andNodeScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("NODE_SCORE not between", value1, value2, "nodeScore");
            return (Criteria) this;
        }

        public Criteria andFormulaIsNull() {
            addCriterion("FORMULA is null");
            return (Criteria) this;
        }

        public Criteria andFormulaIsNotNull() {
            addCriterion("FORMULA is not null");
            return (Criteria) this;
        }

        public Criteria andFormulaEqualTo(String value) {
            addCriterion("FORMULA =", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaNotEqualTo(String value) {
            addCriterion("FORMULA <>", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaGreaterThan(String value) {
            addCriterion("FORMULA >", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaGreaterThanOrEqualTo(String value) {
            addCriterion("FORMULA >=", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaLessThan(String value) {
            addCriterion("FORMULA <", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaLessThanOrEqualTo(String value) {
            addCriterion("FORMULA <=", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaLike(String value) {
            addCriterion("FORMULA like", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaNotLike(String value) {
            addCriterion("FORMULA not like", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaIn(List<String> values) {
            addCriterion("FORMULA in", values, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaNotIn(List<String> values) {
            addCriterion("FORMULA not in", values, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaBetween(String value1, String value2) {
            addCriterion("FORMULA between", value1, value2, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaNotBetween(String value1, String value2) {
            addCriterion("FORMULA not between", value1, value2, "formula");
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

        public Criteria andErrorTypeIsNull() {
            addCriterion("ERROR_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andErrorTypeIsNotNull() {
            addCriterion("ERROR_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andErrorTypeEqualTo(String value) {
            addCriterion("ERROR_TYPE =", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeNotEqualTo(String value) {
            addCriterion("ERROR_TYPE <>", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeGreaterThan(String value) {
            addCriterion("ERROR_TYPE >", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ERROR_TYPE >=", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeLessThan(String value) {
            addCriterion("ERROR_TYPE <", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeLessThanOrEqualTo(String value) {
            addCriterion("ERROR_TYPE <=", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeLike(String value) {
            addCriterion("ERROR_TYPE like", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeNotLike(String value) {
            addCriterion("ERROR_TYPE not like", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeIn(List<String> values) {
            addCriterion("ERROR_TYPE in", values, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeNotIn(List<String> values) {
            addCriterion("ERROR_TYPE not in", values, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeBetween(String value1, String value2) {
            addCriterion("ERROR_TYPE between", value1, value2, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeNotBetween(String value1, String value2) {
            addCriterion("ERROR_TYPE not between", value1, value2, "errorType");
            return (Criteria) this;
        }

        public Criteria andScoreFlagIsNull() {
            addCriterion("SCORE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andScoreFlagIsNotNull() {
            addCriterion("SCORE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andScoreFlagEqualTo(String value) {
            addCriterion("SCORE_FLAG =", value, "scoreFlag");
            return (Criteria) this;
        }

        public Criteria andScoreFlagNotEqualTo(String value) {
            addCriterion("SCORE_FLAG <>", value, "scoreFlag");
            return (Criteria) this;
        }

        public Criteria andScoreFlagGreaterThan(String value) {
            addCriterion("SCORE_FLAG >", value, "scoreFlag");
            return (Criteria) this;
        }

        public Criteria andScoreFlagGreaterThanOrEqualTo(String value) {
            addCriterion("SCORE_FLAG >=", value, "scoreFlag");
            return (Criteria) this;
        }

        public Criteria andScoreFlagLessThan(String value) {
            addCriterion("SCORE_FLAG <", value, "scoreFlag");
            return (Criteria) this;
        }

        public Criteria andScoreFlagLessThanOrEqualTo(String value) {
            addCriterion("SCORE_FLAG <=", value, "scoreFlag");
            return (Criteria) this;
        }

        public Criteria andScoreFlagLike(String value) {
            addCriterion("SCORE_FLAG like", value, "scoreFlag");
            return (Criteria) this;
        }

        public Criteria andScoreFlagNotLike(String value) {
            addCriterion("SCORE_FLAG not like", value, "scoreFlag");
            return (Criteria) this;
        }

        public Criteria andScoreFlagIn(List<String> values) {
            addCriterion("SCORE_FLAG in", values, "scoreFlag");
            return (Criteria) this;
        }

        public Criteria andScoreFlagNotIn(List<String> values) {
            addCriterion("SCORE_FLAG not in", values, "scoreFlag");
            return (Criteria) this;
        }

        public Criteria andScoreFlagBetween(String value1, String value2) {
            addCriterion("SCORE_FLAG between", value1, value2, "scoreFlag");
            return (Criteria) this;
        }

        public Criteria andScoreFlagNotBetween(String value1, String value2) {
            addCriterion("SCORE_FLAG not between", value1, value2, "scoreFlag");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNull() {
            addCriterion("CRT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNotNull() {
            addCriterion("CRT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeEqualTo(Date value) {
            addCriterion("CRT_TIME =", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotEqualTo(Date value) {
            addCriterion("CRT_TIME <>", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThan(Date value) {
            addCriterion("CRT_TIME >", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CRT_TIME >=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThan(Date value) {
            addCriterion("CRT_TIME <", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThanOrEqualTo(Date value) {
            addCriterion("CRT_TIME <=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIn(List<Date> values) {
            addCriterion("CRT_TIME in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotIn(List<Date> values) {
            addCriterion("CRT_TIME not in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeBetween(Date value1, Date value2) {
            addCriterion("CRT_TIME between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotBetween(Date value1, Date value2) {
            addCriterion("CRT_TIME not between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andModfTimeIsNull() {
            addCriterion("MODF_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModfTimeIsNotNull() {
            addCriterion("MODF_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModfTimeEqualTo(Date value) {
            addCriterion("MODF_TIME =", value, "modfTime");
            return (Criteria) this;
        }

        public Criteria andModfTimeNotEqualTo(Date value) {
            addCriterion("MODF_TIME <>", value, "modfTime");
            return (Criteria) this;
        }

        public Criteria andModfTimeGreaterThan(Date value) {
            addCriterion("MODF_TIME >", value, "modfTime");
            return (Criteria) this;
        }

        public Criteria andModfTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODF_TIME >=", value, "modfTime");
            return (Criteria) this;
        }

        public Criteria andModfTimeLessThan(Date value) {
            addCriterion("MODF_TIME <", value, "modfTime");
            return (Criteria) this;
        }

        public Criteria andModfTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODF_TIME <=", value, "modfTime");
            return (Criteria) this;
        }

        public Criteria andModfTimeIn(List<Date> values) {
            addCriterion("MODF_TIME in", values, "modfTime");
            return (Criteria) this;
        }

        public Criteria andModfTimeNotIn(List<Date> values) {
            addCriterion("MODF_TIME not in", values, "modfTime");
            return (Criteria) this;
        }

        public Criteria andModfTimeBetween(Date value1, Date value2) {
            addCriterion("MODF_TIME between", value1, value2, "modfTime");
            return (Criteria) this;
        }

        public Criteria andModfTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODF_TIME not between", value1, value2, "modfTime");
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

        public Criteria andNodeOrderIsNull() {
            addCriterion("NODE_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andNodeOrderIsNotNull() {
            addCriterion("NODE_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andNodeOrderEqualTo(Integer value) {
            addCriterion("NODE_ORDER =", value, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderNotEqualTo(Integer value) {
            addCriterion("NODE_ORDER <>", value, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderGreaterThan(Integer value) {
            addCriterion("NODE_ORDER >", value, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("NODE_ORDER >=", value, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderLessThan(Integer value) {
            addCriterion("NODE_ORDER <", value, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderLessThanOrEqualTo(Integer value) {
            addCriterion("NODE_ORDER <=", value, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderIn(List<Integer> values) {
            addCriterion("NODE_ORDER in", values, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderNotIn(List<Integer> values) {
            addCriterion("NODE_ORDER not in", values, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderBetween(Integer value1, Integer value2) {
            addCriterion("NODE_ORDER between", value1, value2, "nodeOrder");
            return (Criteria) this;
        }

        public Criteria andNodeOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("NODE_ORDER not between", value1, value2, "nodeOrder");
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