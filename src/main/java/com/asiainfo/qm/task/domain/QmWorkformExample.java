package com.asiainfo.qm.task.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QmWorkformExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QmWorkformExample() {
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

        public Criteria andWrkfmIdIsNull() {
            addCriterion("WRKFM_ID is null");
            return (Criteria) this;
        }

        public Criteria andWrkfmIdIsNotNull() {
            addCriterion("WRKFM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWrkfmIdEqualTo(Long value) {
            addCriterion("WRKFM_ID =", value, "wrkfmId");
            return (Criteria) this;
        }

        public Criteria andWrkfmIdNotEqualTo(Long value) {
            addCriterion("WRKFM_ID <>", value, "wrkfmId");
            return (Criteria) this;
        }

        public Criteria andWrkfmIdGreaterThan(Long value) {
            addCriterion("WRKFM_ID >", value, "wrkfmId");
            return (Criteria) this;
        }

        public Criteria andWrkfmIdGreaterThanOrEqualTo(Long value) {
            addCriterion("WRKFM_ID >=", value, "wrkfmId");
            return (Criteria) this;
        }

        public Criteria andWrkfmIdLessThan(Long value) {
            addCriterion("WRKFM_ID <", value, "wrkfmId");
            return (Criteria) this;
        }

        public Criteria andWrkfmIdLessThanOrEqualTo(Long value) {
            addCriterion("WRKFM_ID <=", value, "wrkfmId");
            return (Criteria) this;
        }

        public Criteria andWrkfmIdIn(List<Long> values) {
            addCriterion("WRKFM_ID in", values, "wrkfmId");
            return (Criteria) this;
        }

        public Criteria andWrkfmIdNotIn(List<Long> values) {
            addCriterion("WRKFM_ID not in", values, "wrkfmId");
            return (Criteria) this;
        }

        public Criteria andWrkfmIdBetween(Long value1, Long value2) {
            addCriterion("WRKFM_ID between", value1, value2, "wrkfmId");
            return (Criteria) this;
        }

        public Criteria andWrkfmIdNotBetween(Long value1, Long value2) {
            addCriterion("WRKFM_ID not between", value1, value2, "wrkfmId");
            return (Criteria) this;
        }

        public Criteria andWrkfmShowSwftnoIsNull() {
            addCriterion("WRKFM_SHOW_SWFTNO is null");
            return (Criteria) this;
        }

        public Criteria andWrkfmShowSwftnoIsNotNull() {
            addCriterion("WRKFM_SHOW_SWFTNO is not null");
            return (Criteria) this;
        }

        public Criteria andWrkfmShowSwftnoEqualTo(String value) {
            addCriterion("WRKFM_SHOW_SWFTNO =", value, "wrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andWrkfmShowSwftnoNotEqualTo(String value) {
            addCriterion("WRKFM_SHOW_SWFTNO <>", value, "wrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andWrkfmShowSwftnoGreaterThan(String value) {
            addCriterion("WRKFM_SHOW_SWFTNO >", value, "wrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andWrkfmShowSwftnoGreaterThanOrEqualTo(String value) {
            addCriterion("WRKFM_SHOW_SWFTNO >=", value, "wrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andWrkfmShowSwftnoLessThan(String value) {
            addCriterion("WRKFM_SHOW_SWFTNO <", value, "wrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andWrkfmShowSwftnoLessThanOrEqualTo(String value) {
            addCriterion("WRKFM_SHOW_SWFTNO <=", value, "wrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andWrkfmShowSwftnoLike(String value) {
            addCriterion("WRKFM_SHOW_SWFTNO like", value, "wrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andWrkfmShowSwftnoNotLike(String value) {
            addCriterion("WRKFM_SHOW_SWFTNO not like", value, "wrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andWrkfmShowSwftnoIn(List<String> values) {
            addCriterion("WRKFM_SHOW_SWFTNO in", values, "wrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andWrkfmShowSwftnoNotIn(List<String> values) {
            addCriterion("WRKFM_SHOW_SWFTNO not in", values, "wrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andWrkfmShowSwftnoBetween(String value1, String value2) {
            addCriterion("WRKFM_SHOW_SWFTNO between", value1, value2, "wrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andWrkfmShowSwftnoNotBetween(String value1, String value2) {
            addCriterion("WRKFM_SHOW_SWFTNO not between", value1, value2, "wrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andSrvReqstIdIsNull() {
            addCriterion("SRV_REQST_ID is null");
            return (Criteria) this;
        }

        public Criteria andSrvReqstIdIsNotNull() {
            addCriterion("SRV_REQST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSrvReqstIdEqualTo(Long value) {
            addCriterion("SRV_REQST_ID =", value, "srvReqstId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstIdNotEqualTo(Long value) {
            addCriterion("SRV_REQST_ID <>", value, "srvReqstId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstIdGreaterThan(Long value) {
            addCriterion("SRV_REQST_ID >", value, "srvReqstId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SRV_REQST_ID >=", value, "srvReqstId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstIdLessThan(Long value) {
            addCriterion("SRV_REQST_ID <", value, "srvReqstId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstIdLessThanOrEqualTo(Long value) {
            addCriterion("SRV_REQST_ID <=", value, "srvReqstId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstIdIn(List<Long> values) {
            addCriterion("SRV_REQST_ID in", values, "srvReqstId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstIdNotIn(List<Long> values) {
            addCriterion("SRV_REQST_ID not in", values, "srvReqstId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstIdBetween(Long value1, Long value2) {
            addCriterion("SRV_REQST_ID between", value1, value2, "srvReqstId");
            return (Criteria) this;
        }

        public Criteria andSrvReqstIdNotBetween(Long value1, Long value2) {
            addCriterion("SRV_REQST_ID not between", value1, value2, "srvReqstId");
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

        public Criteria andSeqprcTmpltIdIsNull() {
            addCriterion("SEQPRC_TMPLT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSeqprcTmpltIdIsNotNull() {
            addCriterion("SEQPRC_TMPLT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSeqprcTmpltIdEqualTo(String value) {
            addCriterion("SEQPRC_TMPLT_ID =", value, "seqprcTmpltId");
            return (Criteria) this;
        }

        public Criteria andSeqprcTmpltIdNotEqualTo(String value) {
            addCriterion("SEQPRC_TMPLT_ID <>", value, "seqprcTmpltId");
            return (Criteria) this;
        }

        public Criteria andSeqprcTmpltIdGreaterThan(String value) {
            addCriterion("SEQPRC_TMPLT_ID >", value, "seqprcTmpltId");
            return (Criteria) this;
        }

        public Criteria andSeqprcTmpltIdGreaterThanOrEqualTo(String value) {
            addCriterion("SEQPRC_TMPLT_ID >=", value, "seqprcTmpltId");
            return (Criteria) this;
        }

        public Criteria andSeqprcTmpltIdLessThan(String value) {
            addCriterion("SEQPRC_TMPLT_ID <", value, "seqprcTmpltId");
            return (Criteria) this;
        }

        public Criteria andSeqprcTmpltIdLessThanOrEqualTo(String value) {
            addCriterion("SEQPRC_TMPLT_ID <=", value, "seqprcTmpltId");
            return (Criteria) this;
        }

        public Criteria andSeqprcTmpltIdLike(String value) {
            addCriterion("SEQPRC_TMPLT_ID like", value, "seqprcTmpltId");
            return (Criteria) this;
        }

        public Criteria andSeqprcTmpltIdNotLike(String value) {
            addCriterion("SEQPRC_TMPLT_ID not like", value, "seqprcTmpltId");
            return (Criteria) this;
        }

        public Criteria andSeqprcTmpltIdIn(List<String> values) {
            addCriterion("SEQPRC_TMPLT_ID in", values, "seqprcTmpltId");
            return (Criteria) this;
        }

        public Criteria andSeqprcTmpltIdNotIn(List<String> values) {
            addCriterion("SEQPRC_TMPLT_ID not in", values, "seqprcTmpltId");
            return (Criteria) this;
        }

        public Criteria andSeqprcTmpltIdBetween(String value1, String value2) {
            addCriterion("SEQPRC_TMPLT_ID between", value1, value2, "seqprcTmpltId");
            return (Criteria) this;
        }

        public Criteria andSeqprcTmpltIdNotBetween(String value1, String value2) {
            addCriterion("SEQPRC_TMPLT_ID not between", value1, value2, "seqprcTmpltId");
            return (Criteria) this;
        }

        public Criteria andSeqprcIstncIdIsNull() {
            addCriterion("SEQPRC_ISTNC_ID is null");
            return (Criteria) this;
        }

        public Criteria andSeqprcIstncIdIsNotNull() {
            addCriterion("SEQPRC_ISTNC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSeqprcIstncIdEqualTo(String value) {
            addCriterion("SEQPRC_ISTNC_ID =", value, "seqprcIstncId");
            return (Criteria) this;
        }

        public Criteria andSeqprcIstncIdNotEqualTo(String value) {
            addCriterion("SEQPRC_ISTNC_ID <>", value, "seqprcIstncId");
            return (Criteria) this;
        }

        public Criteria andSeqprcIstncIdGreaterThan(String value) {
            addCriterion("SEQPRC_ISTNC_ID >", value, "seqprcIstncId");
            return (Criteria) this;
        }

        public Criteria andSeqprcIstncIdGreaterThanOrEqualTo(String value) {
            addCriterion("SEQPRC_ISTNC_ID >=", value, "seqprcIstncId");
            return (Criteria) this;
        }

        public Criteria andSeqprcIstncIdLessThan(String value) {
            addCriterion("SEQPRC_ISTNC_ID <", value, "seqprcIstncId");
            return (Criteria) this;
        }

        public Criteria andSeqprcIstncIdLessThanOrEqualTo(String value) {
            addCriterion("SEQPRC_ISTNC_ID <=", value, "seqprcIstncId");
            return (Criteria) this;
        }

        public Criteria andSeqprcIstncIdLike(String value) {
            addCriterion("SEQPRC_ISTNC_ID like", value, "seqprcIstncId");
            return (Criteria) this;
        }

        public Criteria andSeqprcIstncIdNotLike(String value) {
            addCriterion("SEQPRC_ISTNC_ID not like", value, "seqprcIstncId");
            return (Criteria) this;
        }

        public Criteria andSeqprcIstncIdIn(List<String> values) {
            addCriterion("SEQPRC_ISTNC_ID in", values, "seqprcIstncId");
            return (Criteria) this;
        }

        public Criteria andSeqprcIstncIdNotIn(List<String> values) {
            addCriterion("SEQPRC_ISTNC_ID not in", values, "seqprcIstncId");
            return (Criteria) this;
        }

        public Criteria andSeqprcIstncIdBetween(String value1, String value2) {
            addCriterion("SEQPRC_ISTNC_ID between", value1, value2, "seqprcIstncId");
            return (Criteria) this;
        }

        public Criteria andSeqprcIstncIdNotBetween(String value1, String value2) {
            addCriterion("SEQPRC_ISTNC_ID not between", value1, value2, "seqprcIstncId");
            return (Criteria) this;
        }

        public Criteria andWrkfmTypeCdIsNull() {
            addCriterion("WRKFM_TYPE_CD is null");
            return (Criteria) this;
        }

        public Criteria andWrkfmTypeCdIsNotNull() {
            addCriterion("WRKFM_TYPE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andWrkfmTypeCdEqualTo(String value) {
            addCriterion("WRKFM_TYPE_CD =", value, "wrkfmTypeCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmTypeCdNotEqualTo(String value) {
            addCriterion("WRKFM_TYPE_CD <>", value, "wrkfmTypeCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmTypeCdGreaterThan(String value) {
            addCriterion("WRKFM_TYPE_CD >", value, "wrkfmTypeCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmTypeCdGreaterThanOrEqualTo(String value) {
            addCriterion("WRKFM_TYPE_CD >=", value, "wrkfmTypeCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmTypeCdLessThan(String value) {
            addCriterion("WRKFM_TYPE_CD <", value, "wrkfmTypeCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmTypeCdLessThanOrEqualTo(String value) {
            addCriterion("WRKFM_TYPE_CD <=", value, "wrkfmTypeCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmTypeCdLike(String value) {
            addCriterion("WRKFM_TYPE_CD like", value, "wrkfmTypeCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmTypeCdNotLike(String value) {
            addCriterion("WRKFM_TYPE_CD not like", value, "wrkfmTypeCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmTypeCdIn(List<String> values) {
            addCriterion("WRKFM_TYPE_CD in", values, "wrkfmTypeCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmTypeCdNotIn(List<String> values) {
            addCriterion("WRKFM_TYPE_CD not in", values, "wrkfmTypeCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmTypeCdBetween(String value1, String value2) {
            addCriterion("WRKFM_TYPE_CD between", value1, value2, "wrkfmTypeCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmTypeCdNotBetween(String value1, String value2) {
            addCriterion("WRKFM_TYPE_CD not between", value1, value2, "wrkfmTypeCd");
            return (Criteria) this;
        }

        public Criteria andProvCodeIsNull() {
            addCriterion("PROV_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProvCodeIsNotNull() {
            addCriterion("PROV_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProvCodeEqualTo(String value) {
            addCriterion("PROV_CODE =", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeNotEqualTo(String value) {
            addCriterion("PROV_CODE <>", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeGreaterThan(String value) {
            addCriterion("PROV_CODE >", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROV_CODE >=", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeLessThan(String value) {
            addCriterion("PROV_CODE <", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeLessThanOrEqualTo(String value) {
            addCriterion("PROV_CODE <=", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeLike(String value) {
            addCriterion("PROV_CODE like", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeNotLike(String value) {
            addCriterion("PROV_CODE not like", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeIn(List<String> values) {
            addCriterion("PROV_CODE in", values, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeNotIn(List<String> values) {
            addCriterion("PROV_CODE not in", values, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeBetween(String value1, String value2) {
            addCriterion("PROV_CODE between", value1, value2, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeNotBetween(String value1, String value2) {
            addCriterion("PROV_CODE not between", value1, value2, "provCode");
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

        public Criteria andArcTimeIsNull() {
            addCriterion("ARC_TIME is null");
            return (Criteria) this;
        }

        public Criteria andArcTimeIsNotNull() {
            addCriterion("ARC_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andArcTimeEqualTo(Date value) {
            addCriterion("ARC_TIME =", value, "arcTime");
            return (Criteria) this;
        }

        public Criteria andArcTimeNotEqualTo(Date value) {
            addCriterion("ARC_TIME <>", value, "arcTime");
            return (Criteria) this;
        }

        public Criteria andArcTimeGreaterThan(Date value) {
            addCriterion("ARC_TIME >", value, "arcTime");
            return (Criteria) this;
        }

        public Criteria andArcTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ARC_TIME >=", value, "arcTime");
            return (Criteria) this;
        }

        public Criteria andArcTimeLessThan(Date value) {
            addCriterion("ARC_TIME <", value, "arcTime");
            return (Criteria) this;
        }

        public Criteria andArcTimeLessThanOrEqualTo(Date value) {
            addCriterion("ARC_TIME <=", value, "arcTime");
            return (Criteria) this;
        }

        public Criteria andArcTimeIn(List<Date> values) {
            addCriterion("ARC_TIME in", values, "arcTime");
            return (Criteria) this;
        }

        public Criteria andArcTimeNotIn(List<Date> values) {
            addCriterion("ARC_TIME not in", values, "arcTime");
            return (Criteria) this;
        }

        public Criteria andArcTimeBetween(Date value1, Date value2) {
            addCriterion("ARC_TIME between", value1, value2, "arcTime");
            return (Criteria) this;
        }

        public Criteria andArcTimeNotBetween(Date value1, Date value2) {
            addCriterion("ARC_TIME not between", value1, value2, "arcTime");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemGroupIsNull() {
            addCriterion("CURR_WORK_ITEM_GROUP is null");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemGroupIsNotNull() {
            addCriterion("CURR_WORK_ITEM_GROUP is not null");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemGroupEqualTo(String value) {
            addCriterion("CURR_WORK_ITEM_GROUP =", value, "currWorkItemGroup");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemGroupNotEqualTo(String value) {
            addCriterion("CURR_WORK_ITEM_GROUP <>", value, "currWorkItemGroup");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemGroupGreaterThan(String value) {
            addCriterion("CURR_WORK_ITEM_GROUP >", value, "currWorkItemGroup");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemGroupGreaterThanOrEqualTo(String value) {
            addCriterion("CURR_WORK_ITEM_GROUP >=", value, "currWorkItemGroup");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemGroupLessThan(String value) {
            addCriterion("CURR_WORK_ITEM_GROUP <", value, "currWorkItemGroup");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemGroupLessThanOrEqualTo(String value) {
            addCriterion("CURR_WORK_ITEM_GROUP <=", value, "currWorkItemGroup");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemGroupLike(String value) {
            addCriterion("CURR_WORK_ITEM_GROUP like", value, "currWorkItemGroup");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemGroupNotLike(String value) {
            addCriterion("CURR_WORK_ITEM_GROUP not like", value, "currWorkItemGroup");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemGroupIn(List<String> values) {
            addCriterion("CURR_WORK_ITEM_GROUP in", values, "currWorkItemGroup");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemGroupNotIn(List<String> values) {
            addCriterion("CURR_WORK_ITEM_GROUP not in", values, "currWorkItemGroup");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemGroupBetween(String value1, String value2) {
            addCriterion("CURR_WORK_ITEM_GROUP between", value1, value2, "currWorkItemGroup");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemGroupNotBetween(String value1, String value2) {
            addCriterion("CURR_WORK_ITEM_GROUP not between", value1, value2, "currWorkItemGroup");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemOwnerIsNull() {
            addCriterion("CURR_WORK_ITEM_OWNER is null");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemOwnerIsNotNull() {
            addCriterion("CURR_WORK_ITEM_OWNER is not null");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemOwnerEqualTo(String value) {
            addCriterion("CURR_WORK_ITEM_OWNER =", value, "currWorkItemOwner");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemOwnerNotEqualTo(String value) {
            addCriterion("CURR_WORK_ITEM_OWNER <>", value, "currWorkItemOwner");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemOwnerGreaterThan(String value) {
            addCriterion("CURR_WORK_ITEM_OWNER >", value, "currWorkItemOwner");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("CURR_WORK_ITEM_OWNER >=", value, "currWorkItemOwner");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemOwnerLessThan(String value) {
            addCriterion("CURR_WORK_ITEM_OWNER <", value, "currWorkItemOwner");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemOwnerLessThanOrEqualTo(String value) {
            addCriterion("CURR_WORK_ITEM_OWNER <=", value, "currWorkItemOwner");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemOwnerLike(String value) {
            addCriterion("CURR_WORK_ITEM_OWNER like", value, "currWorkItemOwner");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemOwnerNotLike(String value) {
            addCriterion("CURR_WORK_ITEM_OWNER not like", value, "currWorkItemOwner");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemOwnerIn(List<String> values) {
            addCriterion("CURR_WORK_ITEM_OWNER in", values, "currWorkItemOwner");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemOwnerNotIn(List<String> values) {
            addCriterion("CURR_WORK_ITEM_OWNER not in", values, "currWorkItemOwner");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemOwnerBetween(String value1, String value2) {
            addCriterion("CURR_WORK_ITEM_OWNER between", value1, value2, "currWorkItemOwner");
            return (Criteria) this;
        }

        public Criteria andCurrWorkItemOwnerNotBetween(String value1, String value2) {
            addCriterion("CURR_WORK_ITEM_OWNER not between", value1, value2, "currWorkItemOwner");
            return (Criteria) this;
        }

        public Criteria andLastRouteLgIdSetIsNull() {
            addCriterion("LAST_ROUTE_LG_ID_SET is null");
            return (Criteria) this;
        }

        public Criteria andLastRouteLgIdSetIsNotNull() {
            addCriterion("LAST_ROUTE_LG_ID_SET is not null");
            return (Criteria) this;
        }

        public Criteria andLastRouteLgIdSetEqualTo(String value) {
            addCriterion("LAST_ROUTE_LG_ID_SET =", value, "lastRouteLgIdSet");
            return (Criteria) this;
        }

        public Criteria andLastRouteLgIdSetNotEqualTo(String value) {
            addCriterion("LAST_ROUTE_LG_ID_SET <>", value, "lastRouteLgIdSet");
            return (Criteria) this;
        }

        public Criteria andLastRouteLgIdSetGreaterThan(String value) {
            addCriterion("LAST_ROUTE_LG_ID_SET >", value, "lastRouteLgIdSet");
            return (Criteria) this;
        }

        public Criteria andLastRouteLgIdSetGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_ROUTE_LG_ID_SET >=", value, "lastRouteLgIdSet");
            return (Criteria) this;
        }

        public Criteria andLastRouteLgIdSetLessThan(String value) {
            addCriterion("LAST_ROUTE_LG_ID_SET <", value, "lastRouteLgIdSet");
            return (Criteria) this;
        }

        public Criteria andLastRouteLgIdSetLessThanOrEqualTo(String value) {
            addCriterion("LAST_ROUTE_LG_ID_SET <=", value, "lastRouteLgIdSet");
            return (Criteria) this;
        }

        public Criteria andLastRouteLgIdSetLike(String value) {
            addCriterion("LAST_ROUTE_LG_ID_SET like", value, "lastRouteLgIdSet");
            return (Criteria) this;
        }

        public Criteria andLastRouteLgIdSetNotLike(String value) {
            addCriterion("LAST_ROUTE_LG_ID_SET not like", value, "lastRouteLgIdSet");
            return (Criteria) this;
        }

        public Criteria andLastRouteLgIdSetIn(List<String> values) {
            addCriterion("LAST_ROUTE_LG_ID_SET in", values, "lastRouteLgIdSet");
            return (Criteria) this;
        }

        public Criteria andLastRouteLgIdSetNotIn(List<String> values) {
            addCriterion("LAST_ROUTE_LG_ID_SET not in", values, "lastRouteLgIdSet");
            return (Criteria) this;
        }

        public Criteria andLastRouteLgIdSetBetween(String value1, String value2) {
            addCriterion("LAST_ROUTE_LG_ID_SET between", value1, value2, "lastRouteLgIdSet");
            return (Criteria) this;
        }

        public Criteria andLastRouteLgIdSetNotBetween(String value1, String value2) {
            addCriterion("LAST_ROUTE_LG_ID_SET not between", value1, value2, "lastRouteLgIdSet");
            return (Criteria) this;
        }

        public Criteria andPrstTskStsCdIsNull() {
            addCriterion("PRST_TSK_STS_CD is null");
            return (Criteria) this;
        }

        public Criteria andPrstTskStsCdIsNotNull() {
            addCriterion("PRST_TSK_STS_CD is not null");
            return (Criteria) this;
        }

        public Criteria andPrstTskStsCdEqualTo(String value) {
            addCriterion("PRST_TSK_STS_CD =", value, "prstTskStsCd");
            return (Criteria) this;
        }

        public Criteria andPrstTskStsCdNotEqualTo(String value) {
            addCriterion("PRST_TSK_STS_CD <>", value, "prstTskStsCd");
            return (Criteria) this;
        }

        public Criteria andPrstTskStsCdGreaterThan(String value) {
            addCriterion("PRST_TSK_STS_CD >", value, "prstTskStsCd");
            return (Criteria) this;
        }

        public Criteria andPrstTskStsCdGreaterThanOrEqualTo(String value) {
            addCriterion("PRST_TSK_STS_CD >=", value, "prstTskStsCd");
            return (Criteria) this;
        }

        public Criteria andPrstTskStsCdLessThan(String value) {
            addCriterion("PRST_TSK_STS_CD <", value, "prstTskStsCd");
            return (Criteria) this;
        }

        public Criteria andPrstTskStsCdLessThanOrEqualTo(String value) {
            addCriterion("PRST_TSK_STS_CD <=", value, "prstTskStsCd");
            return (Criteria) this;
        }

        public Criteria andPrstTskStsCdLike(String value) {
            addCriterion("PRST_TSK_STS_CD like", value, "prstTskStsCd");
            return (Criteria) this;
        }

        public Criteria andPrstTskStsCdNotLike(String value) {
            addCriterion("PRST_TSK_STS_CD not like", value, "prstTskStsCd");
            return (Criteria) this;
        }

        public Criteria andPrstTskStsCdIn(List<String> values) {
            addCriterion("PRST_TSK_STS_CD in", values, "prstTskStsCd");
            return (Criteria) this;
        }

        public Criteria andPrstTskStsCdNotIn(List<String> values) {
            addCriterion("PRST_TSK_STS_CD not in", values, "prstTskStsCd");
            return (Criteria) this;
        }

        public Criteria andPrstTskStsCdBetween(String value1, String value2) {
            addCriterion("PRST_TSK_STS_CD between", value1, value2, "prstTskStsCd");
            return (Criteria) this;
        }

        public Criteria andPrstTskStsCdNotBetween(String value1, String value2) {
            addCriterion("PRST_TSK_STS_CD not between", value1, value2, "prstTskStsCd");
            return (Criteria) this;
        }

        public Criteria andLatestSegRemainTmlenIsNull() {
            addCriterion("LATEST_SEG_REMAIN_TMLEN is null");
            return (Criteria) this;
        }

        public Criteria andLatestSegRemainTmlenIsNotNull() {
            addCriterion("LATEST_SEG_REMAIN_TMLEN is not null");
            return (Criteria) this;
        }

        public Criteria andLatestSegRemainTmlenEqualTo(String value) {
            addCriterion("LATEST_SEG_REMAIN_TMLEN =", value, "latestSegRemainTmlen");
            return (Criteria) this;
        }

        public Criteria andLatestSegRemainTmlenNotEqualTo(String value) {
            addCriterion("LATEST_SEG_REMAIN_TMLEN <>", value, "latestSegRemainTmlen");
            return (Criteria) this;
        }

        public Criteria andLatestSegRemainTmlenGreaterThan(String value) {
            addCriterion("LATEST_SEG_REMAIN_TMLEN >", value, "latestSegRemainTmlen");
            return (Criteria) this;
        }

        public Criteria andLatestSegRemainTmlenGreaterThanOrEqualTo(String value) {
            addCriterion("LATEST_SEG_REMAIN_TMLEN >=", value, "latestSegRemainTmlen");
            return (Criteria) this;
        }

        public Criteria andLatestSegRemainTmlenLessThan(String value) {
            addCriterion("LATEST_SEG_REMAIN_TMLEN <", value, "latestSegRemainTmlen");
            return (Criteria) this;
        }

        public Criteria andLatestSegRemainTmlenLessThanOrEqualTo(String value) {
            addCriterion("LATEST_SEG_REMAIN_TMLEN <=", value, "latestSegRemainTmlen");
            return (Criteria) this;
        }

        public Criteria andLatestSegRemainTmlenLike(String value) {
            addCriterion("LATEST_SEG_REMAIN_TMLEN like", value, "latestSegRemainTmlen");
            return (Criteria) this;
        }

        public Criteria andLatestSegRemainTmlenNotLike(String value) {
            addCriterion("LATEST_SEG_REMAIN_TMLEN not like", value, "latestSegRemainTmlen");
            return (Criteria) this;
        }

        public Criteria andLatestSegRemainTmlenIn(List<String> values) {
            addCriterion("LATEST_SEG_REMAIN_TMLEN in", values, "latestSegRemainTmlen");
            return (Criteria) this;
        }

        public Criteria andLatestSegRemainTmlenNotIn(List<String> values) {
            addCriterion("LATEST_SEG_REMAIN_TMLEN not in", values, "latestSegRemainTmlen");
            return (Criteria) this;
        }

        public Criteria andLatestSegRemainTmlenBetween(String value1, String value2) {
            addCriterion("LATEST_SEG_REMAIN_TMLEN between", value1, value2, "latestSegRemainTmlen");
            return (Criteria) this;
        }

        public Criteria andLatestSegRemainTmlenNotBetween(String value1, String value2) {
            addCriterion("LATEST_SEG_REMAIN_TMLEN not between", value1, value2, "latestSegRemainTmlen");
            return (Criteria) this;
        }

        public Criteria andLatestSegTlmtIsNull() {
            addCriterion("LATEST_SEG_TLMT is null");
            return (Criteria) this;
        }

        public Criteria andLatestSegTlmtIsNotNull() {
            addCriterion("LATEST_SEG_TLMT is not null");
            return (Criteria) this;
        }

        public Criteria andLatestSegTlmtEqualTo(String value) {
            addCriterion("LATEST_SEG_TLMT =", value, "latestSegTlmt");
            return (Criteria) this;
        }

        public Criteria andLatestSegTlmtNotEqualTo(String value) {
            addCriterion("LATEST_SEG_TLMT <>", value, "latestSegTlmt");
            return (Criteria) this;
        }

        public Criteria andLatestSegTlmtGreaterThan(String value) {
            addCriterion("LATEST_SEG_TLMT >", value, "latestSegTlmt");
            return (Criteria) this;
        }

        public Criteria andLatestSegTlmtGreaterThanOrEqualTo(String value) {
            addCriterion("LATEST_SEG_TLMT >=", value, "latestSegTlmt");
            return (Criteria) this;
        }

        public Criteria andLatestSegTlmtLessThan(String value) {
            addCriterion("LATEST_SEG_TLMT <", value, "latestSegTlmt");
            return (Criteria) this;
        }

        public Criteria andLatestSegTlmtLessThanOrEqualTo(String value) {
            addCriterion("LATEST_SEG_TLMT <=", value, "latestSegTlmt");
            return (Criteria) this;
        }

        public Criteria andLatestSegTlmtLike(String value) {
            addCriterion("LATEST_SEG_TLMT like", value, "latestSegTlmt");
            return (Criteria) this;
        }

        public Criteria andLatestSegTlmtNotLike(String value) {
            addCriterion("LATEST_SEG_TLMT not like", value, "latestSegTlmt");
            return (Criteria) this;
        }

        public Criteria andLatestSegTlmtIn(List<String> values) {
            addCriterion("LATEST_SEG_TLMT in", values, "latestSegTlmt");
            return (Criteria) this;
        }

        public Criteria andLatestSegTlmtNotIn(List<String> values) {
            addCriterion("LATEST_SEG_TLMT not in", values, "latestSegTlmt");
            return (Criteria) this;
        }

        public Criteria andLatestSegTlmtBetween(String value1, String value2) {
            addCriterion("LATEST_SEG_TLMT between", value1, value2, "latestSegTlmt");
            return (Criteria) this;
        }

        public Criteria andLatestSegTlmtNotBetween(String value1, String value2) {
            addCriterion("LATEST_SEG_TLMT not between", value1, value2, "latestSegTlmt");
            return (Criteria) this;
        }

        public Criteria andSegTlmtStsCdIsNull() {
            addCriterion("SEG_TLMT_STS_CD is null");
            return (Criteria) this;
        }

        public Criteria andSegTlmtStsCdIsNotNull() {
            addCriterion("SEG_TLMT_STS_CD is not null");
            return (Criteria) this;
        }

        public Criteria andSegTlmtStsCdEqualTo(String value) {
            addCriterion("SEG_TLMT_STS_CD =", value, "segTlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andSegTlmtStsCdNotEqualTo(String value) {
            addCriterion("SEG_TLMT_STS_CD <>", value, "segTlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andSegTlmtStsCdGreaterThan(String value) {
            addCriterion("SEG_TLMT_STS_CD >", value, "segTlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andSegTlmtStsCdGreaterThanOrEqualTo(String value) {
            addCriterion("SEG_TLMT_STS_CD >=", value, "segTlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andSegTlmtStsCdLessThan(String value) {
            addCriterion("SEG_TLMT_STS_CD <", value, "segTlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andSegTlmtStsCdLessThanOrEqualTo(String value) {
            addCriterion("SEG_TLMT_STS_CD <=", value, "segTlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andSegTlmtStsCdLike(String value) {
            addCriterion("SEG_TLMT_STS_CD like", value, "segTlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andSegTlmtStsCdNotLike(String value) {
            addCriterion("SEG_TLMT_STS_CD not like", value, "segTlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andSegTlmtStsCdIn(List<String> values) {
            addCriterion("SEG_TLMT_STS_CD in", values, "segTlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andSegTlmtStsCdNotIn(List<String> values) {
            addCriterion("SEG_TLMT_STS_CD not in", values, "segTlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andSegTlmtStsCdBetween(String value1, String value2) {
            addCriterion("SEG_TLMT_STS_CD between", value1, value2, "segTlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andSegTlmtStsCdNotBetween(String value1, String value2) {
            addCriterion("SEG_TLMT_STS_CD not between", value1, value2, "segTlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andConcrrTskFlagIsNull() {
            addCriterion("CONCRR_TSK_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andConcrrTskFlagIsNotNull() {
            addCriterion("CONCRR_TSK_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andConcrrTskFlagEqualTo(Byte value) {
            addCriterion("CONCRR_TSK_FLAG =", value, "concrrTskFlag");
            return (Criteria) this;
        }

        public Criteria andConcrrTskFlagNotEqualTo(Byte value) {
            addCriterion("CONCRR_TSK_FLAG <>", value, "concrrTskFlag");
            return (Criteria) this;
        }

        public Criteria andConcrrTskFlagGreaterThan(Byte value) {
            addCriterion("CONCRR_TSK_FLAG >", value, "concrrTskFlag");
            return (Criteria) this;
        }

        public Criteria andConcrrTskFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("CONCRR_TSK_FLAG >=", value, "concrrTskFlag");
            return (Criteria) this;
        }

        public Criteria andConcrrTskFlagLessThan(Byte value) {
            addCriterion("CONCRR_TSK_FLAG <", value, "concrrTskFlag");
            return (Criteria) this;
        }

        public Criteria andConcrrTskFlagLessThanOrEqualTo(Byte value) {
            addCriterion("CONCRR_TSK_FLAG <=", value, "concrrTskFlag");
            return (Criteria) this;
        }

        public Criteria andConcrrTskFlagIn(List<Byte> values) {
            addCriterion("CONCRR_TSK_FLAG in", values, "concrrTskFlag");
            return (Criteria) this;
        }

        public Criteria andConcrrTskFlagNotIn(List<Byte> values) {
            addCriterion("CONCRR_TSK_FLAG not in", values, "concrrTskFlag");
            return (Criteria) this;
        }

        public Criteria andConcrrTskFlagBetween(Byte value1, Byte value2) {
            addCriterion("CONCRR_TSK_FLAG between", value1, value2, "concrrTskFlag");
            return (Criteria) this;
        }

        public Criteria andConcrrTskFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("CONCRR_TSK_FLAG not between", value1, value2, "concrrTskFlag");
            return (Criteria) this;
        }

        public Criteria andDspsStaffOpListIsNull() {
            addCriterion("DSPS_STAFF_OP_LIST is null");
            return (Criteria) this;
        }

        public Criteria andDspsStaffOpListIsNotNull() {
            addCriterion("DSPS_STAFF_OP_LIST is not null");
            return (Criteria) this;
        }

        public Criteria andDspsStaffOpListEqualTo(String value) {
            addCriterion("DSPS_STAFF_OP_LIST =", value, "dspsStaffOpList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffOpListNotEqualTo(String value) {
            addCriterion("DSPS_STAFF_OP_LIST <>", value, "dspsStaffOpList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffOpListGreaterThan(String value) {
            addCriterion("DSPS_STAFF_OP_LIST >", value, "dspsStaffOpList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffOpListGreaterThanOrEqualTo(String value) {
            addCriterion("DSPS_STAFF_OP_LIST >=", value, "dspsStaffOpList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffOpListLessThan(String value) {
            addCriterion("DSPS_STAFF_OP_LIST <", value, "dspsStaffOpList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffOpListLessThanOrEqualTo(String value) {
            addCriterion("DSPS_STAFF_OP_LIST <=", value, "dspsStaffOpList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffOpListLike(String value) {
            addCriterion("DSPS_STAFF_OP_LIST like", value, "dspsStaffOpList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffOpListNotLike(String value) {
            addCriterion("DSPS_STAFF_OP_LIST not like", value, "dspsStaffOpList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffOpListIn(List<String> values) {
            addCriterion("DSPS_STAFF_OP_LIST in", values, "dspsStaffOpList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffOpListNotIn(List<String> values) {
            addCriterion("DSPS_STAFF_OP_LIST not in", values, "dspsStaffOpList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffOpListBetween(String value1, String value2) {
            addCriterion("DSPS_STAFF_OP_LIST between", value1, value2, "dspsStaffOpList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffOpListNotBetween(String value1, String value2) {
            addCriterion("DSPS_STAFF_OP_LIST not between", value1, value2, "dspsStaffOpList");
            return (Criteria) this;
        }

        public Criteria andOpTypeListIsNull() {
            addCriterion("OP_TYPE_LIST is null");
            return (Criteria) this;
        }

        public Criteria andOpTypeListIsNotNull() {
            addCriterion("OP_TYPE_LIST is not null");
            return (Criteria) this;
        }

        public Criteria andOpTypeListEqualTo(String value) {
            addCriterion("OP_TYPE_LIST =", value, "opTypeList");
            return (Criteria) this;
        }

        public Criteria andOpTypeListNotEqualTo(String value) {
            addCriterion("OP_TYPE_LIST <>", value, "opTypeList");
            return (Criteria) this;
        }

        public Criteria andOpTypeListGreaterThan(String value) {
            addCriterion("OP_TYPE_LIST >", value, "opTypeList");
            return (Criteria) this;
        }

        public Criteria andOpTypeListGreaterThanOrEqualTo(String value) {
            addCriterion("OP_TYPE_LIST >=", value, "opTypeList");
            return (Criteria) this;
        }

        public Criteria andOpTypeListLessThan(String value) {
            addCriterion("OP_TYPE_LIST <", value, "opTypeList");
            return (Criteria) this;
        }

        public Criteria andOpTypeListLessThanOrEqualTo(String value) {
            addCriterion("OP_TYPE_LIST <=", value, "opTypeList");
            return (Criteria) this;
        }

        public Criteria andOpTypeListLike(String value) {
            addCriterion("OP_TYPE_LIST like", value, "opTypeList");
            return (Criteria) this;
        }

        public Criteria andOpTypeListNotLike(String value) {
            addCriterion("OP_TYPE_LIST not like", value, "opTypeList");
            return (Criteria) this;
        }

        public Criteria andOpTypeListIn(List<String> values) {
            addCriterion("OP_TYPE_LIST in", values, "opTypeList");
            return (Criteria) this;
        }

        public Criteria andOpTypeListNotIn(List<String> values) {
            addCriterion("OP_TYPE_LIST not in", values, "opTypeList");
            return (Criteria) this;
        }

        public Criteria andOpTypeListBetween(String value1, String value2) {
            addCriterion("OP_TYPE_LIST between", value1, value2, "opTypeList");
            return (Criteria) this;
        }

        public Criteria andOpTypeListNotBetween(String value1, String value2) {
            addCriterion("OP_TYPE_LIST not between", value1, value2, "opTypeList");
            return (Criteria) this;
        }

        public Criteria andLastOpTypeIsNull() {
            addCriterion("LAST_OP_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLastOpTypeIsNotNull() {
            addCriterion("LAST_OP_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLastOpTypeEqualTo(String value) {
            addCriterion("LAST_OP_TYPE =", value, "lastOpType");
            return (Criteria) this;
        }

        public Criteria andLastOpTypeNotEqualTo(String value) {
            addCriterion("LAST_OP_TYPE <>", value, "lastOpType");
            return (Criteria) this;
        }

        public Criteria andLastOpTypeGreaterThan(String value) {
            addCriterion("LAST_OP_TYPE >", value, "lastOpType");
            return (Criteria) this;
        }

        public Criteria andLastOpTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_OP_TYPE >=", value, "lastOpType");
            return (Criteria) this;
        }

        public Criteria andLastOpTypeLessThan(String value) {
            addCriterion("LAST_OP_TYPE <", value, "lastOpType");
            return (Criteria) this;
        }

        public Criteria andLastOpTypeLessThanOrEqualTo(String value) {
            addCriterion("LAST_OP_TYPE <=", value, "lastOpType");
            return (Criteria) this;
        }

        public Criteria andLastOpTypeLike(String value) {
            addCriterion("LAST_OP_TYPE like", value, "lastOpType");
            return (Criteria) this;
        }

        public Criteria andLastOpTypeNotLike(String value) {
            addCriterion("LAST_OP_TYPE not like", value, "lastOpType");
            return (Criteria) this;
        }

        public Criteria andLastOpTypeIn(List<String> values) {
            addCriterion("LAST_OP_TYPE in", values, "lastOpType");
            return (Criteria) this;
        }

        public Criteria andLastOpTypeNotIn(List<String> values) {
            addCriterion("LAST_OP_TYPE not in", values, "lastOpType");
            return (Criteria) this;
        }

        public Criteria andLastOpTypeBetween(String value1, String value2) {
            addCriterion("LAST_OP_TYPE between", value1, value2, "lastOpType");
            return (Criteria) this;
        }

        public Criteria andLastOpTypeNotBetween(String value1, String value2) {
            addCriterion("LAST_OP_TYPE not between", value1, value2, "lastOpType");
            return (Criteria) this;
        }

        public Criteria andDspsStaffListIsNull() {
            addCriterion("DSPS_STAFF_LIST is null");
            return (Criteria) this;
        }

        public Criteria andDspsStaffListIsNotNull() {
            addCriterion("DSPS_STAFF_LIST is not null");
            return (Criteria) this;
        }

        public Criteria andDspsStaffListEqualTo(String value) {
            addCriterion("DSPS_STAFF_LIST =", value, "dspsStaffList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffListNotEqualTo(String value) {
            addCriterion("DSPS_STAFF_LIST <>", value, "dspsStaffList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffListGreaterThan(String value) {
            addCriterion("DSPS_STAFF_LIST >", value, "dspsStaffList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffListGreaterThanOrEqualTo(String value) {
            addCriterion("DSPS_STAFF_LIST >=", value, "dspsStaffList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffListLessThan(String value) {
            addCriterion("DSPS_STAFF_LIST <", value, "dspsStaffList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffListLessThanOrEqualTo(String value) {
            addCriterion("DSPS_STAFF_LIST <=", value, "dspsStaffList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffListLike(String value) {
            addCriterion("DSPS_STAFF_LIST like", value, "dspsStaffList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffListNotLike(String value) {
            addCriterion("DSPS_STAFF_LIST not like", value, "dspsStaffList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffListIn(List<String> values) {
            addCriterion("DSPS_STAFF_LIST in", values, "dspsStaffList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffListNotIn(List<String> values) {
            addCriterion("DSPS_STAFF_LIST not in", values, "dspsStaffList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffListBetween(String value1, String value2) {
            addCriterion("DSPS_STAFF_LIST between", value1, value2, "dspsStaffList");
            return (Criteria) this;
        }

        public Criteria andDspsStaffListNotBetween(String value1, String value2) {
            addCriterion("DSPS_STAFF_LIST not between", value1, value2, "dspsStaffList");
            return (Criteria) this;
        }

        public Criteria andWrkfmPtcptWorkGrpListIsNull() {
            addCriterion("WRKFM_PTCPT_WORK_GRP_LIST is null");
            return (Criteria) this;
        }

        public Criteria andWrkfmPtcptWorkGrpListIsNotNull() {
            addCriterion("WRKFM_PTCPT_WORK_GRP_LIST is not null");
            return (Criteria) this;
        }

        public Criteria andWrkfmPtcptWorkGrpListEqualTo(String value) {
            addCriterion("WRKFM_PTCPT_WORK_GRP_LIST =", value, "wrkfmPtcptWorkGrpList");
            return (Criteria) this;
        }

        public Criteria andWrkfmPtcptWorkGrpListNotEqualTo(String value) {
            addCriterion("WRKFM_PTCPT_WORK_GRP_LIST <>", value, "wrkfmPtcptWorkGrpList");
            return (Criteria) this;
        }

        public Criteria andWrkfmPtcptWorkGrpListGreaterThan(String value) {
            addCriterion("WRKFM_PTCPT_WORK_GRP_LIST >", value, "wrkfmPtcptWorkGrpList");
            return (Criteria) this;
        }

        public Criteria andWrkfmPtcptWorkGrpListGreaterThanOrEqualTo(String value) {
            addCriterion("WRKFM_PTCPT_WORK_GRP_LIST >=", value, "wrkfmPtcptWorkGrpList");
            return (Criteria) this;
        }

        public Criteria andWrkfmPtcptWorkGrpListLessThan(String value) {
            addCriterion("WRKFM_PTCPT_WORK_GRP_LIST <", value, "wrkfmPtcptWorkGrpList");
            return (Criteria) this;
        }

        public Criteria andWrkfmPtcptWorkGrpListLessThanOrEqualTo(String value) {
            addCriterion("WRKFM_PTCPT_WORK_GRP_LIST <=", value, "wrkfmPtcptWorkGrpList");
            return (Criteria) this;
        }

        public Criteria andWrkfmPtcptWorkGrpListLike(String value) {
            addCriterion("WRKFM_PTCPT_WORK_GRP_LIST like", value, "wrkfmPtcptWorkGrpList");
            return (Criteria) this;
        }

        public Criteria andWrkfmPtcptWorkGrpListNotLike(String value) {
            addCriterion("WRKFM_PTCPT_WORK_GRP_LIST not like", value, "wrkfmPtcptWorkGrpList");
            return (Criteria) this;
        }

        public Criteria andWrkfmPtcptWorkGrpListIn(List<String> values) {
            addCriterion("WRKFM_PTCPT_WORK_GRP_LIST in", values, "wrkfmPtcptWorkGrpList");
            return (Criteria) this;
        }

        public Criteria andWrkfmPtcptWorkGrpListNotIn(List<String> values) {
            addCriterion("WRKFM_PTCPT_WORK_GRP_LIST not in", values, "wrkfmPtcptWorkGrpList");
            return (Criteria) this;
        }

        public Criteria andWrkfmPtcptWorkGrpListBetween(String value1, String value2) {
            addCriterion("WRKFM_PTCPT_WORK_GRP_LIST between", value1, value2, "wrkfmPtcptWorkGrpList");
            return (Criteria) this;
        }

        public Criteria andWrkfmPtcptWorkGrpListNotBetween(String value1, String value2) {
            addCriterion("WRKFM_PTCPT_WORK_GRP_LIST not between", value1, value2, "wrkfmPtcptWorkGrpList");
            return (Criteria) this;
        }

        public Criteria andDspsComplteStaffIdIsNull() {
            addCriterion("DSPS_COMPLTE_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andDspsComplteStaffIdIsNotNull() {
            addCriterion("DSPS_COMPLTE_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDspsComplteStaffIdEqualTo(String value) {
            addCriterion("DSPS_COMPLTE_STAFF_ID =", value, "dspsComplteStaffId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteStaffIdNotEqualTo(String value) {
            addCriterion("DSPS_COMPLTE_STAFF_ID <>", value, "dspsComplteStaffId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteStaffIdGreaterThan(String value) {
            addCriterion("DSPS_COMPLTE_STAFF_ID >", value, "dspsComplteStaffId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("DSPS_COMPLTE_STAFF_ID >=", value, "dspsComplteStaffId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteStaffIdLessThan(String value) {
            addCriterion("DSPS_COMPLTE_STAFF_ID <", value, "dspsComplteStaffId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteStaffIdLessThanOrEqualTo(String value) {
            addCriterion("DSPS_COMPLTE_STAFF_ID <=", value, "dspsComplteStaffId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteStaffIdLike(String value) {
            addCriterion("DSPS_COMPLTE_STAFF_ID like", value, "dspsComplteStaffId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteStaffIdNotLike(String value) {
            addCriterion("DSPS_COMPLTE_STAFF_ID not like", value, "dspsComplteStaffId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteStaffIdIn(List<String> values) {
            addCriterion("DSPS_COMPLTE_STAFF_ID in", values, "dspsComplteStaffId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteStaffIdNotIn(List<String> values) {
            addCriterion("DSPS_COMPLTE_STAFF_ID not in", values, "dspsComplteStaffId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteStaffIdBetween(String value1, String value2) {
            addCriterion("DSPS_COMPLTE_STAFF_ID between", value1, value2, "dspsComplteStaffId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteStaffIdNotBetween(String value1, String value2) {
            addCriterion("DSPS_COMPLTE_STAFF_ID not between", value1, value2, "dspsComplteStaffId");
            return (Criteria) this;
        }

        public Criteria andPrstNodeTypeCdIsNull() {
            addCriterion("PRST_NODE_TYPE_CD is null");
            return (Criteria) this;
        }

        public Criteria andPrstNodeTypeCdIsNotNull() {
            addCriterion("PRST_NODE_TYPE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andPrstNodeTypeCdEqualTo(String value) {
            addCriterion("PRST_NODE_TYPE_CD =", value, "prstNodeTypeCd");
            return (Criteria) this;
        }

        public Criteria andPrstNodeTypeCdNotEqualTo(String value) {
            addCriterion("PRST_NODE_TYPE_CD <>", value, "prstNodeTypeCd");
            return (Criteria) this;
        }

        public Criteria andPrstNodeTypeCdGreaterThan(String value) {
            addCriterion("PRST_NODE_TYPE_CD >", value, "prstNodeTypeCd");
            return (Criteria) this;
        }

        public Criteria andPrstNodeTypeCdGreaterThanOrEqualTo(String value) {
            addCriterion("PRST_NODE_TYPE_CD >=", value, "prstNodeTypeCd");
            return (Criteria) this;
        }

        public Criteria andPrstNodeTypeCdLessThan(String value) {
            addCriterion("PRST_NODE_TYPE_CD <", value, "prstNodeTypeCd");
            return (Criteria) this;
        }

        public Criteria andPrstNodeTypeCdLessThanOrEqualTo(String value) {
            addCriterion("PRST_NODE_TYPE_CD <=", value, "prstNodeTypeCd");
            return (Criteria) this;
        }

        public Criteria andPrstNodeTypeCdLike(String value) {
            addCriterion("PRST_NODE_TYPE_CD like", value, "prstNodeTypeCd");
            return (Criteria) this;
        }

        public Criteria andPrstNodeTypeCdNotLike(String value) {
            addCriterion("PRST_NODE_TYPE_CD not like", value, "prstNodeTypeCd");
            return (Criteria) this;
        }

        public Criteria andPrstNodeTypeCdIn(List<String> values) {
            addCriterion("PRST_NODE_TYPE_CD in", values, "prstNodeTypeCd");
            return (Criteria) this;
        }

        public Criteria andPrstNodeTypeCdNotIn(List<String> values) {
            addCriterion("PRST_NODE_TYPE_CD not in", values, "prstNodeTypeCd");
            return (Criteria) this;
        }

        public Criteria andPrstNodeTypeCdBetween(String value1, String value2) {
            addCriterion("PRST_NODE_TYPE_CD between", value1, value2, "prstNodeTypeCd");
            return (Criteria) this;
        }

        public Criteria andPrstNodeTypeCdNotBetween(String value1, String value2) {
            addCriterion("PRST_NODE_TYPE_CD not between", value1, value2, "prstNodeTypeCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmStsCdIsNull() {
            addCriterion("WRKFM_STS_CD is null");
            return (Criteria) this;
        }

        public Criteria andWrkfmStsCdIsNotNull() {
            addCriterion("WRKFM_STS_CD is not null");
            return (Criteria) this;
        }

        public Criteria andWrkfmStsCdEqualTo(String value) {
            addCriterion("WRKFM_STS_CD =", value, "wrkfmStsCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmStsCdNotEqualTo(String value) {
            addCriterion("WRKFM_STS_CD <>", value, "wrkfmStsCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmStsCdGreaterThan(String value) {
            addCriterion("WRKFM_STS_CD >", value, "wrkfmStsCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmStsCdGreaterThanOrEqualTo(String value) {
            addCriterion("WRKFM_STS_CD >=", value, "wrkfmStsCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmStsCdLessThan(String value) {
            addCriterion("WRKFM_STS_CD <", value, "wrkfmStsCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmStsCdLessThanOrEqualTo(String value) {
            addCriterion("WRKFM_STS_CD <=", value, "wrkfmStsCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmStsCdLike(String value) {
            addCriterion("WRKFM_STS_CD like", value, "wrkfmStsCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmStsCdNotLike(String value) {
            addCriterion("WRKFM_STS_CD not like", value, "wrkfmStsCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmStsCdIn(List<String> values) {
            addCriterion("WRKFM_STS_CD in", values, "wrkfmStsCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmStsCdNotIn(List<String> values) {
            addCriterion("WRKFM_STS_CD not in", values, "wrkfmStsCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmStsCdBetween(String value1, String value2) {
            addCriterion("WRKFM_STS_CD between", value1, value2, "wrkfmStsCd");
            return (Criteria) this;
        }

        public Criteria andWrkfmStsCdNotBetween(String value1, String value2) {
            addCriterion("WRKFM_STS_CD not between", value1, value2, "wrkfmStsCd");
            return (Criteria) this;
        }

        public Criteria andExprTimeIsNull() {
            addCriterion("EXPR_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExprTimeIsNotNull() {
            addCriterion("EXPR_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExprTimeEqualTo(Date value) {
            addCriterion("EXPR_TIME =", value, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeNotEqualTo(Date value) {
            addCriterion("EXPR_TIME <>", value, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeGreaterThan(Date value) {
            addCriterion("EXPR_TIME >", value, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EXPR_TIME >=", value, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeLessThan(Date value) {
            addCriterion("EXPR_TIME <", value, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeLessThanOrEqualTo(Date value) {
            addCriterion("EXPR_TIME <=", value, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeIn(List<Date> values) {
            addCriterion("EXPR_TIME in", values, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeNotIn(List<Date> values) {
            addCriterion("EXPR_TIME not in", values, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeBetween(Date value1, Date value2) {
            addCriterion("EXPR_TIME between", value1, value2, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeNotBetween(Date value1, Date value2) {
            addCriterion("EXPR_TIME not between", value1, value2, "exprTime");
            return (Criteria) this;
        }

        public Criteria andTmlmtRuleIdIsNull() {
            addCriterion("TMLMT_RULE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTmlmtRuleIdIsNotNull() {
            addCriterion("TMLMT_RULE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTmlmtRuleIdEqualTo(Long value) {
            addCriterion("TMLMT_RULE_ID =", value, "tmlmtRuleId");
            return (Criteria) this;
        }

        public Criteria andTmlmtRuleIdNotEqualTo(Long value) {
            addCriterion("TMLMT_RULE_ID <>", value, "tmlmtRuleId");
            return (Criteria) this;
        }

        public Criteria andTmlmtRuleIdGreaterThan(Long value) {
            addCriterion("TMLMT_RULE_ID >", value, "tmlmtRuleId");
            return (Criteria) this;
        }

        public Criteria andTmlmtRuleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("TMLMT_RULE_ID >=", value, "tmlmtRuleId");
            return (Criteria) this;
        }

        public Criteria andTmlmtRuleIdLessThan(Long value) {
            addCriterion("TMLMT_RULE_ID <", value, "tmlmtRuleId");
            return (Criteria) this;
        }

        public Criteria andTmlmtRuleIdLessThanOrEqualTo(Long value) {
            addCriterion("TMLMT_RULE_ID <=", value, "tmlmtRuleId");
            return (Criteria) this;
        }

        public Criteria andTmlmtRuleIdIn(List<Long> values) {
            addCriterion("TMLMT_RULE_ID in", values, "tmlmtRuleId");
            return (Criteria) this;
        }

        public Criteria andTmlmtRuleIdNotIn(List<Long> values) {
            addCriterion("TMLMT_RULE_ID not in", values, "tmlmtRuleId");
            return (Criteria) this;
        }

        public Criteria andTmlmtRuleIdBetween(Long value1, Long value2) {
            addCriterion("TMLMT_RULE_ID between", value1, value2, "tmlmtRuleId");
            return (Criteria) this;
        }

        public Criteria andTmlmtRuleIdNotBetween(Long value1, Long value2) {
            addCriterion("TMLMT_RULE_ID not between", value1, value2, "tmlmtRuleId");
            return (Criteria) this;
        }

        public Criteria andTmoutTmlenCntIsNull() {
            addCriterion("TMOUT_TMLEN_CNT is null");
            return (Criteria) this;
        }

        public Criteria andTmoutTmlenCntIsNotNull() {
            addCriterion("TMOUT_TMLEN_CNT is not null");
            return (Criteria) this;
        }

        public Criteria andTmoutTmlenCntEqualTo(Integer value) {
            addCriterion("TMOUT_TMLEN_CNT =", value, "tmoutTmlenCnt");
            return (Criteria) this;
        }

        public Criteria andTmoutTmlenCntNotEqualTo(Integer value) {
            addCriterion("TMOUT_TMLEN_CNT <>", value, "tmoutTmlenCnt");
            return (Criteria) this;
        }

        public Criteria andTmoutTmlenCntGreaterThan(Integer value) {
            addCriterion("TMOUT_TMLEN_CNT >", value, "tmoutTmlenCnt");
            return (Criteria) this;
        }

        public Criteria andTmoutTmlenCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("TMOUT_TMLEN_CNT >=", value, "tmoutTmlenCnt");
            return (Criteria) this;
        }

        public Criteria andTmoutTmlenCntLessThan(Integer value) {
            addCriterion("TMOUT_TMLEN_CNT <", value, "tmoutTmlenCnt");
            return (Criteria) this;
        }

        public Criteria andTmoutTmlenCntLessThanOrEqualTo(Integer value) {
            addCriterion("TMOUT_TMLEN_CNT <=", value, "tmoutTmlenCnt");
            return (Criteria) this;
        }

        public Criteria andTmoutTmlenCntIn(List<Integer> values) {
            addCriterion("TMOUT_TMLEN_CNT in", values, "tmoutTmlenCnt");
            return (Criteria) this;
        }

        public Criteria andTmoutTmlenCntNotIn(List<Integer> values) {
            addCriterion("TMOUT_TMLEN_CNT not in", values, "tmoutTmlenCnt");
            return (Criteria) this;
        }

        public Criteria andTmoutTmlenCntBetween(Integer value1, Integer value2) {
            addCriterion("TMOUT_TMLEN_CNT between", value1, value2, "tmoutTmlenCnt");
            return (Criteria) this;
        }

        public Criteria andTmoutTmlenCntNotBetween(Integer value1, Integer value2) {
            addCriterion("TMOUT_TMLEN_CNT not between", value1, value2, "tmoutTmlenCnt");
            return (Criteria) this;
        }

        public Criteria andPredctRslvTimeIsNull() {
            addCriterion("PREDCT_RSLV_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPredctRslvTimeIsNotNull() {
            addCriterion("PREDCT_RSLV_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPredctRslvTimeEqualTo(Date value) {
            addCriterion("PREDCT_RSLV_TIME =", value, "predctRslvTime");
            return (Criteria) this;
        }

        public Criteria andPredctRslvTimeNotEqualTo(Date value) {
            addCriterion("PREDCT_RSLV_TIME <>", value, "predctRslvTime");
            return (Criteria) this;
        }

        public Criteria andPredctRslvTimeGreaterThan(Date value) {
            addCriterion("PREDCT_RSLV_TIME >", value, "predctRslvTime");
            return (Criteria) this;
        }

        public Criteria andPredctRslvTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PREDCT_RSLV_TIME >=", value, "predctRslvTime");
            return (Criteria) this;
        }

        public Criteria andPredctRslvTimeLessThan(Date value) {
            addCriterion("PREDCT_RSLV_TIME <", value, "predctRslvTime");
            return (Criteria) this;
        }

        public Criteria andPredctRslvTimeLessThanOrEqualTo(Date value) {
            addCriterion("PREDCT_RSLV_TIME <=", value, "predctRslvTime");
            return (Criteria) this;
        }

        public Criteria andPredctRslvTimeIn(List<Date> values) {
            addCriterion("PREDCT_RSLV_TIME in", values, "predctRslvTime");
            return (Criteria) this;
        }

        public Criteria andPredctRslvTimeNotIn(List<Date> values) {
            addCriterion("PREDCT_RSLV_TIME not in", values, "predctRslvTime");
            return (Criteria) this;
        }

        public Criteria andPredctRslvTimeBetween(Date value1, Date value2) {
            addCriterion("PREDCT_RSLV_TIME between", value1, value2, "predctRslvTime");
            return (Criteria) this;
        }

        public Criteria andPredctRslvTimeNotBetween(Date value1, Date value2) {
            addCriterion("PREDCT_RSLV_TIME not between", value1, value2, "predctRslvTime");
            return (Criteria) this;
        }

        public Criteria andTlmtStsCdIsNull() {
            addCriterion("TLMT_STS_CD is null");
            return (Criteria) this;
        }

        public Criteria andTlmtStsCdIsNotNull() {
            addCriterion("TLMT_STS_CD is not null");
            return (Criteria) this;
        }

        public Criteria andTlmtStsCdEqualTo(String value) {
            addCriterion("TLMT_STS_CD =", value, "tlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andTlmtStsCdNotEqualTo(String value) {
            addCriterion("TLMT_STS_CD <>", value, "tlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andTlmtStsCdGreaterThan(String value) {
            addCriterion("TLMT_STS_CD >", value, "tlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andTlmtStsCdGreaterThanOrEqualTo(String value) {
            addCriterion("TLMT_STS_CD >=", value, "tlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andTlmtStsCdLessThan(String value) {
            addCriterion("TLMT_STS_CD <", value, "tlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andTlmtStsCdLessThanOrEqualTo(String value) {
            addCriterion("TLMT_STS_CD <=", value, "tlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andTlmtStsCdLike(String value) {
            addCriterion("TLMT_STS_CD like", value, "tlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andTlmtStsCdNotLike(String value) {
            addCriterion("TLMT_STS_CD not like", value, "tlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andTlmtStsCdIn(List<String> values) {
            addCriterion("TLMT_STS_CD in", values, "tlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andTlmtStsCdNotIn(List<String> values) {
            addCriterion("TLMT_STS_CD not in", values, "tlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andTlmtStsCdBetween(String value1, String value2) {
            addCriterion("TLMT_STS_CD between", value1, value2, "tlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andTlmtStsCdNotBetween(String value1, String value2) {
            addCriterion("TLMT_STS_CD not between", value1, value2, "tlmtStsCd");
            return (Criteria) this;
        }

        public Criteria andDspsComplteWorkGrpIdIsNull() {
            addCriterion("DSPS_COMPLTE_WORK_GRP_ID is null");
            return (Criteria) this;
        }

        public Criteria andDspsComplteWorkGrpIdIsNotNull() {
            addCriterion("DSPS_COMPLTE_WORK_GRP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDspsComplteWorkGrpIdEqualTo(String value) {
            addCriterion("DSPS_COMPLTE_WORK_GRP_ID =", value, "dspsComplteWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteWorkGrpIdNotEqualTo(String value) {
            addCriterion("DSPS_COMPLTE_WORK_GRP_ID <>", value, "dspsComplteWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteWorkGrpIdGreaterThan(String value) {
            addCriterion("DSPS_COMPLTE_WORK_GRP_ID >", value, "dspsComplteWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteWorkGrpIdGreaterThanOrEqualTo(String value) {
            addCriterion("DSPS_COMPLTE_WORK_GRP_ID >=", value, "dspsComplteWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteWorkGrpIdLessThan(String value) {
            addCriterion("DSPS_COMPLTE_WORK_GRP_ID <", value, "dspsComplteWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteWorkGrpIdLessThanOrEqualTo(String value) {
            addCriterion("DSPS_COMPLTE_WORK_GRP_ID <=", value, "dspsComplteWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteWorkGrpIdLike(String value) {
            addCriterion("DSPS_COMPLTE_WORK_GRP_ID like", value, "dspsComplteWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteWorkGrpIdNotLike(String value) {
            addCriterion("DSPS_COMPLTE_WORK_GRP_ID not like", value, "dspsComplteWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteWorkGrpIdIn(List<String> values) {
            addCriterion("DSPS_COMPLTE_WORK_GRP_ID in", values, "dspsComplteWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteWorkGrpIdNotIn(List<String> values) {
            addCriterion("DSPS_COMPLTE_WORK_GRP_ID not in", values, "dspsComplteWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteWorkGrpIdBetween(String value1, String value2) {
            addCriterion("DSPS_COMPLTE_WORK_GRP_ID between", value1, value2, "dspsComplteWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andDspsComplteWorkGrpIdNotBetween(String value1, String value2) {
            addCriterion("DSPS_COMPLTE_WORK_GRP_ID not between", value1, value2, "dspsComplteWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andArcModeCdIsNull() {
            addCriterion("ARC_MODE_CD is null");
            return (Criteria) this;
        }

        public Criteria andArcModeCdIsNotNull() {
            addCriterion("ARC_MODE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andArcModeCdEqualTo(String value) {
            addCriterion("ARC_MODE_CD =", value, "arcModeCd");
            return (Criteria) this;
        }

        public Criteria andArcModeCdNotEqualTo(String value) {
            addCriterion("ARC_MODE_CD <>", value, "arcModeCd");
            return (Criteria) this;
        }

        public Criteria andArcModeCdGreaterThan(String value) {
            addCriterion("ARC_MODE_CD >", value, "arcModeCd");
            return (Criteria) this;
        }

        public Criteria andArcModeCdGreaterThanOrEqualTo(String value) {
            addCriterion("ARC_MODE_CD >=", value, "arcModeCd");
            return (Criteria) this;
        }

        public Criteria andArcModeCdLessThan(String value) {
            addCriterion("ARC_MODE_CD <", value, "arcModeCd");
            return (Criteria) this;
        }

        public Criteria andArcModeCdLessThanOrEqualTo(String value) {
            addCriterion("ARC_MODE_CD <=", value, "arcModeCd");
            return (Criteria) this;
        }

        public Criteria andArcModeCdLike(String value) {
            addCriterion("ARC_MODE_CD like", value, "arcModeCd");
            return (Criteria) this;
        }

        public Criteria andArcModeCdNotLike(String value) {
            addCriterion("ARC_MODE_CD not like", value, "arcModeCd");
            return (Criteria) this;
        }

        public Criteria andArcModeCdIn(List<String> values) {
            addCriterion("ARC_MODE_CD in", values, "arcModeCd");
            return (Criteria) this;
        }

        public Criteria andArcModeCdNotIn(List<String> values) {
            addCriterion("ARC_MODE_CD not in", values, "arcModeCd");
            return (Criteria) this;
        }

        public Criteria andArcModeCdBetween(String value1, String value2) {
            addCriterion("ARC_MODE_CD between", value1, value2, "arcModeCd");
            return (Criteria) this;
        }

        public Criteria andArcModeCdNotBetween(String value1, String value2) {
            addCriterion("ARC_MODE_CD not between", value1, value2, "arcModeCd");
            return (Criteria) this;
        }

        public Criteria andValidFlagIsNull() {
            addCriterion("VALID_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andValidFlagIsNotNull() {
            addCriterion("VALID_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andValidFlagEqualTo(Byte value) {
            addCriterion("VALID_FLAG =", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagNotEqualTo(Byte value) {
            addCriterion("VALID_FLAG <>", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagGreaterThan(Byte value) {
            addCriterion("VALID_FLAG >", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("VALID_FLAG >=", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagLessThan(Byte value) {
            addCriterion("VALID_FLAG <", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagLessThanOrEqualTo(Byte value) {
            addCriterion("VALID_FLAG <=", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagIn(List<Byte> values) {
            addCriterion("VALID_FLAG in", values, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagNotIn(List<Byte> values) {
            addCriterion("VALID_FLAG not in", values, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagBetween(Byte value1, Byte value2) {
            addCriterion("VALID_FLAG between", value1, value2, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("VALID_FLAG not between", value1, value2, "validFlag");
            return (Criteria) this;
        }

        public Criteria andArcStaffIdIsNull() {
            addCriterion("ARC_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andArcStaffIdIsNotNull() {
            addCriterion("ARC_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andArcStaffIdEqualTo(String value) {
            addCriterion("ARC_STAFF_ID =", value, "arcStaffId");
            return (Criteria) this;
        }

        public Criteria andArcStaffIdNotEqualTo(String value) {
            addCriterion("ARC_STAFF_ID <>", value, "arcStaffId");
            return (Criteria) this;
        }

        public Criteria andArcStaffIdGreaterThan(String value) {
            addCriterion("ARC_STAFF_ID >", value, "arcStaffId");
            return (Criteria) this;
        }

        public Criteria andArcStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("ARC_STAFF_ID >=", value, "arcStaffId");
            return (Criteria) this;
        }

        public Criteria andArcStaffIdLessThan(String value) {
            addCriterion("ARC_STAFF_ID <", value, "arcStaffId");
            return (Criteria) this;
        }

        public Criteria andArcStaffIdLessThanOrEqualTo(String value) {
            addCriterion("ARC_STAFF_ID <=", value, "arcStaffId");
            return (Criteria) this;
        }

        public Criteria andArcStaffIdLike(String value) {
            addCriterion("ARC_STAFF_ID like", value, "arcStaffId");
            return (Criteria) this;
        }

        public Criteria andArcStaffIdNotLike(String value) {
            addCriterion("ARC_STAFF_ID not like", value, "arcStaffId");
            return (Criteria) this;
        }

        public Criteria andArcStaffIdIn(List<String> values) {
            addCriterion("ARC_STAFF_ID in", values, "arcStaffId");
            return (Criteria) this;
        }

        public Criteria andArcStaffIdNotIn(List<String> values) {
            addCriterion("ARC_STAFF_ID not in", values, "arcStaffId");
            return (Criteria) this;
        }

        public Criteria andArcStaffIdBetween(String value1, String value2) {
            addCriterion("ARC_STAFF_ID between", value1, value2, "arcStaffId");
            return (Criteria) this;
        }

        public Criteria andArcStaffIdNotBetween(String value1, String value2) {
            addCriterion("ARC_STAFF_ID not between", value1, value2, "arcStaffId");
            return (Criteria) this;
        }

        public Criteria andArcStaffWorkGrpIdIsNull() {
            addCriterion("ARC_STAFF_WORK_GRP_ID is null");
            return (Criteria) this;
        }

        public Criteria andArcStaffWorkGrpIdIsNotNull() {
            addCriterion("ARC_STAFF_WORK_GRP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andArcStaffWorkGrpIdEqualTo(String value) {
            addCriterion("ARC_STAFF_WORK_GRP_ID =", value, "arcStaffWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andArcStaffWorkGrpIdNotEqualTo(String value) {
            addCriterion("ARC_STAFF_WORK_GRP_ID <>", value, "arcStaffWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andArcStaffWorkGrpIdGreaterThan(String value) {
            addCriterion("ARC_STAFF_WORK_GRP_ID >", value, "arcStaffWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andArcStaffWorkGrpIdGreaterThanOrEqualTo(String value) {
            addCriterion("ARC_STAFF_WORK_GRP_ID >=", value, "arcStaffWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andArcStaffWorkGrpIdLessThan(String value) {
            addCriterion("ARC_STAFF_WORK_GRP_ID <", value, "arcStaffWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andArcStaffWorkGrpIdLessThanOrEqualTo(String value) {
            addCriterion("ARC_STAFF_WORK_GRP_ID <=", value, "arcStaffWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andArcStaffWorkGrpIdLike(String value) {
            addCriterion("ARC_STAFF_WORK_GRP_ID like", value, "arcStaffWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andArcStaffWorkGrpIdNotLike(String value) {
            addCriterion("ARC_STAFF_WORK_GRP_ID not like", value, "arcStaffWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andArcStaffWorkGrpIdIn(List<String> values) {
            addCriterion("ARC_STAFF_WORK_GRP_ID in", values, "arcStaffWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andArcStaffWorkGrpIdNotIn(List<String> values) {
            addCriterion("ARC_STAFF_WORK_GRP_ID not in", values, "arcStaffWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andArcStaffWorkGrpIdBetween(String value1, String value2) {
            addCriterion("ARC_STAFF_WORK_GRP_ID between", value1, value2, "arcStaffWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andArcStaffWorkGrpIdNotBetween(String value1, String value2) {
            addCriterion("ARC_STAFF_WORK_GRP_ID not between", value1, value2, "arcStaffWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andArcStaffDeptIdIsNull() {
            addCriterion("ARC_STAFF_DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andArcStaffDeptIdIsNotNull() {
            addCriterion("ARC_STAFF_DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andArcStaffDeptIdEqualTo(String value) {
            addCriterion("ARC_STAFF_DEPT_ID =", value, "arcStaffDeptId");
            return (Criteria) this;
        }

        public Criteria andArcStaffDeptIdNotEqualTo(String value) {
            addCriterion("ARC_STAFF_DEPT_ID <>", value, "arcStaffDeptId");
            return (Criteria) this;
        }

        public Criteria andArcStaffDeptIdGreaterThan(String value) {
            addCriterion("ARC_STAFF_DEPT_ID >", value, "arcStaffDeptId");
            return (Criteria) this;
        }

        public Criteria andArcStaffDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("ARC_STAFF_DEPT_ID >=", value, "arcStaffDeptId");
            return (Criteria) this;
        }

        public Criteria andArcStaffDeptIdLessThan(String value) {
            addCriterion("ARC_STAFF_DEPT_ID <", value, "arcStaffDeptId");
            return (Criteria) this;
        }

        public Criteria andArcStaffDeptIdLessThanOrEqualTo(String value) {
            addCriterion("ARC_STAFF_DEPT_ID <=", value, "arcStaffDeptId");
            return (Criteria) this;
        }

        public Criteria andArcStaffDeptIdLike(String value) {
            addCriterion("ARC_STAFF_DEPT_ID like", value, "arcStaffDeptId");
            return (Criteria) this;
        }

        public Criteria andArcStaffDeptIdNotLike(String value) {
            addCriterion("ARC_STAFF_DEPT_ID not like", value, "arcStaffDeptId");
            return (Criteria) this;
        }

        public Criteria andArcStaffDeptIdIn(List<String> values) {
            addCriterion("ARC_STAFF_DEPT_ID in", values, "arcStaffDeptId");
            return (Criteria) this;
        }

        public Criteria andArcStaffDeptIdNotIn(List<String> values) {
            addCriterion("ARC_STAFF_DEPT_ID not in", values, "arcStaffDeptId");
            return (Criteria) this;
        }

        public Criteria andArcStaffDeptIdBetween(String value1, String value2) {
            addCriterion("ARC_STAFF_DEPT_ID between", value1, value2, "arcStaffDeptId");
            return (Criteria) this;
        }

        public Criteria andArcStaffDeptIdNotBetween(String value1, String value2) {
            addCriterion("ARC_STAFF_DEPT_ID not between", value1, value2, "arcStaffDeptId");
            return (Criteria) this;
        }

        public Criteria andArcOpinCnttIsNull() {
            addCriterion("ARC_OPIN_CNTT is null");
            return (Criteria) this;
        }

        public Criteria andArcOpinCnttIsNotNull() {
            addCriterion("ARC_OPIN_CNTT is not null");
            return (Criteria) this;
        }

        public Criteria andArcOpinCnttEqualTo(String value) {
            addCriterion("ARC_OPIN_CNTT =", value, "arcOpinCntt");
            return (Criteria) this;
        }

        public Criteria andArcOpinCnttNotEqualTo(String value) {
            addCriterion("ARC_OPIN_CNTT <>", value, "arcOpinCntt");
            return (Criteria) this;
        }

        public Criteria andArcOpinCnttGreaterThan(String value) {
            addCriterion("ARC_OPIN_CNTT >", value, "arcOpinCntt");
            return (Criteria) this;
        }

        public Criteria andArcOpinCnttGreaterThanOrEqualTo(String value) {
            addCriterion("ARC_OPIN_CNTT >=", value, "arcOpinCntt");
            return (Criteria) this;
        }

        public Criteria andArcOpinCnttLessThan(String value) {
            addCriterion("ARC_OPIN_CNTT <", value, "arcOpinCntt");
            return (Criteria) this;
        }

        public Criteria andArcOpinCnttLessThanOrEqualTo(String value) {
            addCriterion("ARC_OPIN_CNTT <=", value, "arcOpinCntt");
            return (Criteria) this;
        }

        public Criteria andArcOpinCnttLike(String value) {
            addCriterion("ARC_OPIN_CNTT like", value, "arcOpinCntt");
            return (Criteria) this;
        }

        public Criteria andArcOpinCnttNotLike(String value) {
            addCriterion("ARC_OPIN_CNTT not like", value, "arcOpinCntt");
            return (Criteria) this;
        }

        public Criteria andArcOpinCnttIn(List<String> values) {
            addCriterion("ARC_OPIN_CNTT in", values, "arcOpinCntt");
            return (Criteria) this;
        }

        public Criteria andArcOpinCnttNotIn(List<String> values) {
            addCriterion("ARC_OPIN_CNTT not in", values, "arcOpinCntt");
            return (Criteria) this;
        }

        public Criteria andArcOpinCnttBetween(String value1, String value2) {
            addCriterion("ARC_OPIN_CNTT between", value1, value2, "arcOpinCntt");
            return (Criteria) this;
        }

        public Criteria andArcOpinCnttNotBetween(String value1, String value2) {
            addCriterion("ARC_OPIN_CNTT not between", value1, value2, "arcOpinCntt");
            return (Criteria) this;
        }

        public Criteria andAformFlagIsNull() {
            addCriterion("AFORM_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andAformFlagIsNotNull() {
            addCriterion("AFORM_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andAformFlagEqualTo(Byte value) {
            addCriterion("AFORM_FLAG =", value, "aformFlag");
            return (Criteria) this;
        }

        public Criteria andAformFlagNotEqualTo(Byte value) {
            addCriterion("AFORM_FLAG <>", value, "aformFlag");
            return (Criteria) this;
        }

        public Criteria andAformFlagGreaterThan(Byte value) {
            addCriterion("AFORM_FLAG >", value, "aformFlag");
            return (Criteria) this;
        }

        public Criteria andAformFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("AFORM_FLAG >=", value, "aformFlag");
            return (Criteria) this;
        }

        public Criteria andAformFlagLessThan(Byte value) {
            addCriterion("AFORM_FLAG <", value, "aformFlag");
            return (Criteria) this;
        }

        public Criteria andAformFlagLessThanOrEqualTo(Byte value) {
            addCriterion("AFORM_FLAG <=", value, "aformFlag");
            return (Criteria) this;
        }

        public Criteria andAformFlagIn(List<Byte> values) {
            addCriterion("AFORM_FLAG in", values, "aformFlag");
            return (Criteria) this;
        }

        public Criteria andAformFlagNotIn(List<Byte> values) {
            addCriterion("AFORM_FLAG not in", values, "aformFlag");
            return (Criteria) this;
        }

        public Criteria andAformFlagBetween(Byte value1, Byte value2) {
            addCriterion("AFORM_FLAG between", value1, value2, "aformFlag");
            return (Criteria) this;
        }

        public Criteria andAformFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("AFORM_FLAG not between", value1, value2, "aformFlag");
            return (Criteria) this;
        }

        public Criteria andAutoAformTgtWorkGrpIdIsNull() {
            addCriterion("AUTO_AFORM_TGT_WORK_GRP_ID is null");
            return (Criteria) this;
        }

        public Criteria andAutoAformTgtWorkGrpIdIsNotNull() {
            addCriterion("AUTO_AFORM_TGT_WORK_GRP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAutoAformTgtWorkGrpIdEqualTo(String value) {
            addCriterion("AUTO_AFORM_TGT_WORK_GRP_ID =", value, "autoAformTgtWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andAutoAformTgtWorkGrpIdNotEqualTo(String value) {
            addCriterion("AUTO_AFORM_TGT_WORK_GRP_ID <>", value, "autoAformTgtWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andAutoAformTgtWorkGrpIdGreaterThan(String value) {
            addCriterion("AUTO_AFORM_TGT_WORK_GRP_ID >", value, "autoAformTgtWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andAutoAformTgtWorkGrpIdGreaterThanOrEqualTo(String value) {
            addCriterion("AUTO_AFORM_TGT_WORK_GRP_ID >=", value, "autoAformTgtWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andAutoAformTgtWorkGrpIdLessThan(String value) {
            addCriterion("AUTO_AFORM_TGT_WORK_GRP_ID <", value, "autoAformTgtWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andAutoAformTgtWorkGrpIdLessThanOrEqualTo(String value) {
            addCriterion("AUTO_AFORM_TGT_WORK_GRP_ID <=", value, "autoAformTgtWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andAutoAformTgtWorkGrpIdLike(String value) {
            addCriterion("AUTO_AFORM_TGT_WORK_GRP_ID like", value, "autoAformTgtWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andAutoAformTgtWorkGrpIdNotLike(String value) {
            addCriterion("AUTO_AFORM_TGT_WORK_GRP_ID not like", value, "autoAformTgtWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andAutoAformTgtWorkGrpIdIn(List<String> values) {
            addCriterion("AUTO_AFORM_TGT_WORK_GRP_ID in", values, "autoAformTgtWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andAutoAformTgtWorkGrpIdNotIn(List<String> values) {
            addCriterion("AUTO_AFORM_TGT_WORK_GRP_ID not in", values, "autoAformTgtWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andAutoAformTgtWorkGrpIdBetween(String value1, String value2) {
            addCriterion("AUTO_AFORM_TGT_WORK_GRP_ID between", value1, value2, "autoAformTgtWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andAutoAformTgtWorkGrpIdNotBetween(String value1, String value2) {
            addCriterion("AUTO_AFORM_TGT_WORK_GRP_ID not between", value1, value2, "autoAformTgtWorkGrpId");
            return (Criteria) this;
        }

        public Criteria andAformTmsCntIsNull() {
            addCriterion("AFORM_TMS_CNT is null");
            return (Criteria) this;
        }

        public Criteria andAformTmsCntIsNotNull() {
            addCriterion("AFORM_TMS_CNT is not null");
            return (Criteria) this;
        }

        public Criteria andAformTmsCntEqualTo(Byte value) {
            addCriterion("AFORM_TMS_CNT =", value, "aformTmsCnt");
            return (Criteria) this;
        }

        public Criteria andAformTmsCntNotEqualTo(Byte value) {
            addCriterion("AFORM_TMS_CNT <>", value, "aformTmsCnt");
            return (Criteria) this;
        }

        public Criteria andAformTmsCntGreaterThan(Byte value) {
            addCriterion("AFORM_TMS_CNT >", value, "aformTmsCnt");
            return (Criteria) this;
        }

        public Criteria andAformTmsCntGreaterThanOrEqualTo(Byte value) {
            addCriterion("AFORM_TMS_CNT >=", value, "aformTmsCnt");
            return (Criteria) this;
        }

        public Criteria andAformTmsCntLessThan(Byte value) {
            addCriterion("AFORM_TMS_CNT <", value, "aformTmsCnt");
            return (Criteria) this;
        }

        public Criteria andAformTmsCntLessThanOrEqualTo(Byte value) {
            addCriterion("AFORM_TMS_CNT <=", value, "aformTmsCnt");
            return (Criteria) this;
        }

        public Criteria andAformTmsCntIn(List<Byte> values) {
            addCriterion("AFORM_TMS_CNT in", values, "aformTmsCnt");
            return (Criteria) this;
        }

        public Criteria andAformTmsCntNotIn(List<Byte> values) {
            addCriterion("AFORM_TMS_CNT not in", values, "aformTmsCnt");
            return (Criteria) this;
        }

        public Criteria andAformTmsCntBetween(Byte value1, Byte value2) {
            addCriterion("AFORM_TMS_CNT between", value1, value2, "aformTmsCnt");
            return (Criteria) this;
        }

        public Criteria andAformTmsCntNotBetween(Byte value1, Byte value2) {
            addCriterion("AFORM_TMS_CNT not between", value1, value2, "aformTmsCnt");
            return (Criteria) this;
        }

        public Criteria andHaveRcdngCountIsNull() {
            addCriterion("HAVE_RCDNG_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andHaveRcdngCountIsNotNull() {
            addCriterion("HAVE_RCDNG_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andHaveRcdngCountEqualTo(Short value) {
            addCriterion("HAVE_RCDNG_COUNT =", value, "haveRcdngCount");
            return (Criteria) this;
        }

        public Criteria andHaveRcdngCountNotEqualTo(Short value) {
            addCriterion("HAVE_RCDNG_COUNT <>", value, "haveRcdngCount");
            return (Criteria) this;
        }

        public Criteria andHaveRcdngCountGreaterThan(Short value) {
            addCriterion("HAVE_RCDNG_COUNT >", value, "haveRcdngCount");
            return (Criteria) this;
        }

        public Criteria andHaveRcdngCountGreaterThanOrEqualTo(Short value) {
            addCriterion("HAVE_RCDNG_COUNT >=", value, "haveRcdngCount");
            return (Criteria) this;
        }

        public Criteria andHaveRcdngCountLessThan(Short value) {
            addCriterion("HAVE_RCDNG_COUNT <", value, "haveRcdngCount");
            return (Criteria) this;
        }

        public Criteria andHaveRcdngCountLessThanOrEqualTo(Short value) {
            addCriterion("HAVE_RCDNG_COUNT <=", value, "haveRcdngCount");
            return (Criteria) this;
        }

        public Criteria andHaveRcdngCountIn(List<Short> values) {
            addCriterion("HAVE_RCDNG_COUNT in", values, "haveRcdngCount");
            return (Criteria) this;
        }

        public Criteria andHaveRcdngCountNotIn(List<Short> values) {
            addCriterion("HAVE_RCDNG_COUNT not in", values, "haveRcdngCount");
            return (Criteria) this;
        }

        public Criteria andHaveRcdngCountBetween(Short value1, Short value2) {
            addCriterion("HAVE_RCDNG_COUNT between", value1, value2, "haveRcdngCount");
            return (Criteria) this;
        }

        public Criteria andHaveRcdngCountNotBetween(Short value1, Short value2) {
            addCriterion("HAVE_RCDNG_COUNT not between", value1, value2, "haveRcdngCount");
            return (Criteria) this;
        }

        public Criteria andInactTmsCntIsNull() {
            addCriterion("INACT_TMS_CNT is null");
            return (Criteria) this;
        }

        public Criteria andInactTmsCntIsNotNull() {
            addCriterion("INACT_TMS_CNT is not null");
            return (Criteria) this;
        }

        public Criteria andInactTmsCntEqualTo(Byte value) {
            addCriterion("INACT_TMS_CNT =", value, "inactTmsCnt");
            return (Criteria) this;
        }

        public Criteria andInactTmsCntNotEqualTo(Byte value) {
            addCriterion("INACT_TMS_CNT <>", value, "inactTmsCnt");
            return (Criteria) this;
        }

        public Criteria andInactTmsCntGreaterThan(Byte value) {
            addCriterion("INACT_TMS_CNT >", value, "inactTmsCnt");
            return (Criteria) this;
        }

        public Criteria andInactTmsCntGreaterThanOrEqualTo(Byte value) {
            addCriterion("INACT_TMS_CNT >=", value, "inactTmsCnt");
            return (Criteria) this;
        }

        public Criteria andInactTmsCntLessThan(Byte value) {
            addCriterion("INACT_TMS_CNT <", value, "inactTmsCnt");
            return (Criteria) this;
        }

        public Criteria andInactTmsCntLessThanOrEqualTo(Byte value) {
            addCriterion("INACT_TMS_CNT <=", value, "inactTmsCnt");
            return (Criteria) this;
        }

        public Criteria andInactTmsCntIn(List<Byte> values) {
            addCriterion("INACT_TMS_CNT in", values, "inactTmsCnt");
            return (Criteria) this;
        }

        public Criteria andInactTmsCntNotIn(List<Byte> values) {
            addCriterion("INACT_TMS_CNT not in", values, "inactTmsCnt");
            return (Criteria) this;
        }

        public Criteria andInactTmsCntBetween(Byte value1, Byte value2) {
            addCriterion("INACT_TMS_CNT between", value1, value2, "inactTmsCnt");
            return (Criteria) this;
        }

        public Criteria andInactTmsCntNotBetween(Byte value1, Byte value2) {
            addCriterion("INACT_TMS_CNT not between", value1, value2, "inactTmsCnt");
            return (Criteria) this;
        }

        public Criteria andInactTimeIsNull() {
            addCriterion("INACT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andInactTimeIsNotNull() {
            addCriterion("INACT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andInactTimeEqualTo(Date value) {
            addCriterion("INACT_TIME =", value, "inactTime");
            return (Criteria) this;
        }

        public Criteria andInactTimeNotEqualTo(Date value) {
            addCriterion("INACT_TIME <>", value, "inactTime");
            return (Criteria) this;
        }

        public Criteria andInactTimeGreaterThan(Date value) {
            addCriterion("INACT_TIME >", value, "inactTime");
            return (Criteria) this;
        }

        public Criteria andInactTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("INACT_TIME >=", value, "inactTime");
            return (Criteria) this;
        }

        public Criteria andInactTimeLessThan(Date value) {
            addCriterion("INACT_TIME <", value, "inactTime");
            return (Criteria) this;
        }

        public Criteria andInactTimeLessThanOrEqualTo(Date value) {
            addCriterion("INACT_TIME <=", value, "inactTime");
            return (Criteria) this;
        }

        public Criteria andInactTimeIn(List<Date> values) {
            addCriterion("INACT_TIME in", values, "inactTime");
            return (Criteria) this;
        }

        public Criteria andInactTimeNotIn(List<Date> values) {
            addCriterion("INACT_TIME not in", values, "inactTime");
            return (Criteria) this;
        }

        public Criteria andInactTimeBetween(Date value1, Date value2) {
            addCriterion("INACT_TIME between", value1, value2, "inactTime");
            return (Criteria) this;
        }

        public Criteria andInactTimeNotBetween(Date value1, Date value2) {
            addCriterion("INACT_TIME not between", value1, value2, "inactTime");
            return (Criteria) this;
        }

        public Criteria andActvtModeCdIsNull() {
            addCriterion("ACTVT_MODE_CD is null");
            return (Criteria) this;
        }

        public Criteria andActvtModeCdIsNotNull() {
            addCriterion("ACTVT_MODE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andActvtModeCdEqualTo(String value) {
            addCriterion("ACTVT_MODE_CD =", value, "actvtModeCd");
            return (Criteria) this;
        }

        public Criteria andActvtModeCdNotEqualTo(String value) {
            addCriterion("ACTVT_MODE_CD <>", value, "actvtModeCd");
            return (Criteria) this;
        }

        public Criteria andActvtModeCdGreaterThan(String value) {
            addCriterion("ACTVT_MODE_CD >", value, "actvtModeCd");
            return (Criteria) this;
        }

        public Criteria andActvtModeCdGreaterThanOrEqualTo(String value) {
            addCriterion("ACTVT_MODE_CD >=", value, "actvtModeCd");
            return (Criteria) this;
        }

        public Criteria andActvtModeCdLessThan(String value) {
            addCriterion("ACTVT_MODE_CD <", value, "actvtModeCd");
            return (Criteria) this;
        }

        public Criteria andActvtModeCdLessThanOrEqualTo(String value) {
            addCriterion("ACTVT_MODE_CD <=", value, "actvtModeCd");
            return (Criteria) this;
        }

        public Criteria andActvtModeCdLike(String value) {
            addCriterion("ACTVT_MODE_CD like", value, "actvtModeCd");
            return (Criteria) this;
        }

        public Criteria andActvtModeCdNotLike(String value) {
            addCriterion("ACTVT_MODE_CD not like", value, "actvtModeCd");
            return (Criteria) this;
        }

        public Criteria andActvtModeCdIn(List<String> values) {
            addCriterion("ACTVT_MODE_CD in", values, "actvtModeCd");
            return (Criteria) this;
        }

        public Criteria andActvtModeCdNotIn(List<String> values) {
            addCriterion("ACTVT_MODE_CD not in", values, "actvtModeCd");
            return (Criteria) this;
        }

        public Criteria andActvtModeCdBetween(String value1, String value2) {
            addCriterion("ACTVT_MODE_CD between", value1, value2, "actvtModeCd");
            return (Criteria) this;
        }

        public Criteria andActvtModeCdNotBetween(String value1, String value2) {
            addCriterion("ACTVT_MODE_CD not between", value1, value2, "actvtModeCd");
            return (Criteria) this;
        }

        public Criteria andDealRemedyFlagIsNull() {
            addCriterion("DEAL_REMEDY_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDealRemedyFlagIsNotNull() {
            addCriterion("DEAL_REMEDY_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDealRemedyFlagEqualTo(Byte value) {
            addCriterion("DEAL_REMEDY_FLAG =", value, "dealRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andDealRemedyFlagNotEqualTo(Byte value) {
            addCriterion("DEAL_REMEDY_FLAG <>", value, "dealRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andDealRemedyFlagGreaterThan(Byte value) {
            addCriterion("DEAL_REMEDY_FLAG >", value, "dealRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andDealRemedyFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("DEAL_REMEDY_FLAG >=", value, "dealRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andDealRemedyFlagLessThan(Byte value) {
            addCriterion("DEAL_REMEDY_FLAG <", value, "dealRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andDealRemedyFlagLessThanOrEqualTo(Byte value) {
            addCriterion("DEAL_REMEDY_FLAG <=", value, "dealRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andDealRemedyFlagIn(List<Byte> values) {
            addCriterion("DEAL_REMEDY_FLAG in", values, "dealRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andDealRemedyFlagNotIn(List<Byte> values) {
            addCriterion("DEAL_REMEDY_FLAG not in", values, "dealRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andDealRemedyFlagBetween(Byte value1, Byte value2) {
            addCriterion("DEAL_REMEDY_FLAG between", value1, value2, "dealRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andDealRemedyFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("DEAL_REMEDY_FLAG not between", value1, value2, "dealRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmSwftnoIsNull() {
            addCriterion("DEAL_WRKFM_SWFTNO is null");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmSwftnoIsNotNull() {
            addCriterion("DEAL_WRKFM_SWFTNO is not null");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmSwftnoEqualTo(Long value) {
            addCriterion("DEAL_WRKFM_SWFTNO =", value, "dealWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmSwftnoNotEqualTo(Long value) {
            addCriterion("DEAL_WRKFM_SWFTNO <>", value, "dealWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmSwftnoGreaterThan(Long value) {
            addCriterion("DEAL_WRKFM_SWFTNO >", value, "dealWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmSwftnoGreaterThanOrEqualTo(Long value) {
            addCriterion("DEAL_WRKFM_SWFTNO >=", value, "dealWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmSwftnoLessThan(Long value) {
            addCriterion("DEAL_WRKFM_SWFTNO <", value, "dealWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmSwftnoLessThanOrEqualTo(Long value) {
            addCriterion("DEAL_WRKFM_SWFTNO <=", value, "dealWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmSwftnoIn(List<Long> values) {
            addCriterion("DEAL_WRKFM_SWFTNO in", values, "dealWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmSwftnoNotIn(List<Long> values) {
            addCriterion("DEAL_WRKFM_SWFTNO not in", values, "dealWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmSwftnoBetween(Long value1, Long value2) {
            addCriterion("DEAL_WRKFM_SWFTNO between", value1, value2, "dealWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmSwftnoNotBetween(Long value1, Long value2) {
            addCriterion("DEAL_WRKFM_SWFTNO not between", value1, value2, "dealWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmShowSwftnoIsNull() {
            addCriterion("DEAL_WRKFM_SHOW_SWFTNO is null");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmShowSwftnoIsNotNull() {
            addCriterion("DEAL_WRKFM_SHOW_SWFTNO is not null");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmShowSwftnoEqualTo(String value) {
            addCriterion("DEAL_WRKFM_SHOW_SWFTNO =", value, "dealWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmShowSwftnoNotEqualTo(String value) {
            addCriterion("DEAL_WRKFM_SHOW_SWFTNO <>", value, "dealWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmShowSwftnoGreaterThan(String value) {
            addCriterion("DEAL_WRKFM_SHOW_SWFTNO >", value, "dealWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmShowSwftnoGreaterThanOrEqualTo(String value) {
            addCriterion("DEAL_WRKFM_SHOW_SWFTNO >=", value, "dealWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmShowSwftnoLessThan(String value) {
            addCriterion("DEAL_WRKFM_SHOW_SWFTNO <", value, "dealWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmShowSwftnoLessThanOrEqualTo(String value) {
            addCriterion("DEAL_WRKFM_SHOW_SWFTNO <=", value, "dealWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmShowSwftnoLike(String value) {
            addCriterion("DEAL_WRKFM_SHOW_SWFTNO like", value, "dealWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmShowSwftnoNotLike(String value) {
            addCriterion("DEAL_WRKFM_SHOW_SWFTNO not like", value, "dealWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmShowSwftnoIn(List<String> values) {
            addCriterion("DEAL_WRKFM_SHOW_SWFTNO in", values, "dealWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmShowSwftnoNotIn(List<String> values) {
            addCriterion("DEAL_WRKFM_SHOW_SWFTNO not in", values, "dealWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmShowSwftnoBetween(String value1, String value2) {
            addCriterion("DEAL_WRKFM_SHOW_SWFTNO between", value1, value2, "dealWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andDealWrkfmShowSwftnoNotBetween(String value1, String value2) {
            addCriterion("DEAL_WRKFM_SHOW_SWFTNO not between", value1, value2, "dealWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstRemedyFlagIsNull() {
            addCriterion("REVST_REMEDY_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andRevstRemedyFlagIsNotNull() {
            addCriterion("REVST_REMEDY_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andRevstRemedyFlagEqualTo(Byte value) {
            addCriterion("REVST_REMEDY_FLAG =", value, "revstRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andRevstRemedyFlagNotEqualTo(Byte value) {
            addCriterion("REVST_REMEDY_FLAG <>", value, "revstRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andRevstRemedyFlagGreaterThan(Byte value) {
            addCriterion("REVST_REMEDY_FLAG >", value, "revstRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andRevstRemedyFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("REVST_REMEDY_FLAG >=", value, "revstRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andRevstRemedyFlagLessThan(Byte value) {
            addCriterion("REVST_REMEDY_FLAG <", value, "revstRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andRevstRemedyFlagLessThanOrEqualTo(Byte value) {
            addCriterion("REVST_REMEDY_FLAG <=", value, "revstRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andRevstRemedyFlagIn(List<Byte> values) {
            addCriterion("REVST_REMEDY_FLAG in", values, "revstRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andRevstRemedyFlagNotIn(List<Byte> values) {
            addCriterion("REVST_REMEDY_FLAG not in", values, "revstRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andRevstRemedyFlagBetween(Byte value1, Byte value2) {
            addCriterion("REVST_REMEDY_FLAG between", value1, value2, "revstRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andRevstRemedyFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("REVST_REMEDY_FLAG not between", value1, value2, "revstRemedyFlag");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmSwftnoIsNull() {
            addCriterion("REVST_WRKFM_SWFTNO is null");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmSwftnoIsNotNull() {
            addCriterion("REVST_WRKFM_SWFTNO is not null");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmSwftnoEqualTo(Long value) {
            addCriterion("REVST_WRKFM_SWFTNO =", value, "revstWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmSwftnoNotEqualTo(Long value) {
            addCriterion("REVST_WRKFM_SWFTNO <>", value, "revstWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmSwftnoGreaterThan(Long value) {
            addCriterion("REVST_WRKFM_SWFTNO >", value, "revstWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmSwftnoGreaterThanOrEqualTo(Long value) {
            addCriterion("REVST_WRKFM_SWFTNO >=", value, "revstWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmSwftnoLessThan(Long value) {
            addCriterion("REVST_WRKFM_SWFTNO <", value, "revstWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmSwftnoLessThanOrEqualTo(Long value) {
            addCriterion("REVST_WRKFM_SWFTNO <=", value, "revstWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmSwftnoIn(List<Long> values) {
            addCriterion("REVST_WRKFM_SWFTNO in", values, "revstWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmSwftnoNotIn(List<Long> values) {
            addCriterion("REVST_WRKFM_SWFTNO not in", values, "revstWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmSwftnoBetween(Long value1, Long value2) {
            addCriterion("REVST_WRKFM_SWFTNO between", value1, value2, "revstWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmSwftnoNotBetween(Long value1, Long value2) {
            addCriterion("REVST_WRKFM_SWFTNO not between", value1, value2, "revstWrkfmSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmShowSwftnoIsNull() {
            addCriterion("REVST_WRKFM_SHOW_SWFTNO is null");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmShowSwftnoIsNotNull() {
            addCriterion("REVST_WRKFM_SHOW_SWFTNO is not null");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmShowSwftnoEqualTo(String value) {
            addCriterion("REVST_WRKFM_SHOW_SWFTNO =", value, "revstWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmShowSwftnoNotEqualTo(String value) {
            addCriterion("REVST_WRKFM_SHOW_SWFTNO <>", value, "revstWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmShowSwftnoGreaterThan(String value) {
            addCriterion("REVST_WRKFM_SHOW_SWFTNO >", value, "revstWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmShowSwftnoGreaterThanOrEqualTo(String value) {
            addCriterion("REVST_WRKFM_SHOW_SWFTNO >=", value, "revstWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmShowSwftnoLessThan(String value) {
            addCriterion("REVST_WRKFM_SHOW_SWFTNO <", value, "revstWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmShowSwftnoLessThanOrEqualTo(String value) {
            addCriterion("REVST_WRKFM_SHOW_SWFTNO <=", value, "revstWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmShowSwftnoLike(String value) {
            addCriterion("REVST_WRKFM_SHOW_SWFTNO like", value, "revstWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmShowSwftnoNotLike(String value) {
            addCriterion("REVST_WRKFM_SHOW_SWFTNO not like", value, "revstWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmShowSwftnoIn(List<String> values) {
            addCriterion("REVST_WRKFM_SHOW_SWFTNO in", values, "revstWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmShowSwftnoNotIn(List<String> values) {
            addCriterion("REVST_WRKFM_SHOW_SWFTNO not in", values, "revstWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmShowSwftnoBetween(String value1, String value2) {
            addCriterion("REVST_WRKFM_SHOW_SWFTNO between", value1, value2, "revstWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andRevstWrkfmShowSwftnoNotBetween(String value1, String value2) {
            addCriterion("REVST_WRKFM_SHOW_SWFTNO not between", value1, value2, "revstWrkfmShowSwftno");
            return (Criteria) this;
        }

        public Criteria andFdbkModeCdIsNull() {
            addCriterion("FDBK_MODE_CD is null");
            return (Criteria) this;
        }

        public Criteria andFdbkModeCdIsNotNull() {
            addCriterion("FDBK_MODE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andFdbkModeCdEqualTo(String value) {
            addCriterion("FDBK_MODE_CD =", value, "fdbkModeCd");
            return (Criteria) this;
        }

        public Criteria andFdbkModeCdNotEqualTo(String value) {
            addCriterion("FDBK_MODE_CD <>", value, "fdbkModeCd");
            return (Criteria) this;
        }

        public Criteria andFdbkModeCdGreaterThan(String value) {
            addCriterion("FDBK_MODE_CD >", value, "fdbkModeCd");
            return (Criteria) this;
        }

        public Criteria andFdbkModeCdGreaterThanOrEqualTo(String value) {
            addCriterion("FDBK_MODE_CD >=", value, "fdbkModeCd");
            return (Criteria) this;
        }

        public Criteria andFdbkModeCdLessThan(String value) {
            addCriterion("FDBK_MODE_CD <", value, "fdbkModeCd");
            return (Criteria) this;
        }

        public Criteria andFdbkModeCdLessThanOrEqualTo(String value) {
            addCriterion("FDBK_MODE_CD <=", value, "fdbkModeCd");
            return (Criteria) this;
        }

        public Criteria andFdbkModeCdLike(String value) {
            addCriterion("FDBK_MODE_CD like", value, "fdbkModeCd");
            return (Criteria) this;
        }

        public Criteria andFdbkModeCdNotLike(String value) {
            addCriterion("FDBK_MODE_CD not like", value, "fdbkModeCd");
            return (Criteria) this;
        }

        public Criteria andFdbkModeCdIn(List<String> values) {
            addCriterion("FDBK_MODE_CD in", values, "fdbkModeCd");
            return (Criteria) this;
        }

        public Criteria andFdbkModeCdNotIn(List<String> values) {
            addCriterion("FDBK_MODE_CD not in", values, "fdbkModeCd");
            return (Criteria) this;
        }

        public Criteria andFdbkModeCdBetween(String value1, String value2) {
            addCriterion("FDBK_MODE_CD between", value1, value2, "fdbkModeCd");
            return (Criteria) this;
        }

        public Criteria andFdbkModeCdNotBetween(String value1, String value2) {
            addCriterion("FDBK_MODE_CD not between", value1, value2, "fdbkModeCd");
            return (Criteria) this;
        }

        public Criteria andTrsprtSmsIsudFlagIsNull() {
            addCriterion("TRSPRT_SMS_ISUD_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andTrsprtSmsIsudFlagIsNotNull() {
            addCriterion("TRSPRT_SMS_ISUD_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andTrsprtSmsIsudFlagEqualTo(Byte value) {
            addCriterion("TRSPRT_SMS_ISUD_FLAG =", value, "trsprtSmsIsudFlag");
            return (Criteria) this;
        }

        public Criteria andTrsprtSmsIsudFlagNotEqualTo(Byte value) {
            addCriterion("TRSPRT_SMS_ISUD_FLAG <>", value, "trsprtSmsIsudFlag");
            return (Criteria) this;
        }

        public Criteria andTrsprtSmsIsudFlagGreaterThan(Byte value) {
            addCriterion("TRSPRT_SMS_ISUD_FLAG >", value, "trsprtSmsIsudFlag");
            return (Criteria) this;
        }

        public Criteria andTrsprtSmsIsudFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("TRSPRT_SMS_ISUD_FLAG >=", value, "trsprtSmsIsudFlag");
            return (Criteria) this;
        }

        public Criteria andTrsprtSmsIsudFlagLessThan(Byte value) {
            addCriterion("TRSPRT_SMS_ISUD_FLAG <", value, "trsprtSmsIsudFlag");
            return (Criteria) this;
        }

        public Criteria andTrsprtSmsIsudFlagLessThanOrEqualTo(Byte value) {
            addCriterion("TRSPRT_SMS_ISUD_FLAG <=", value, "trsprtSmsIsudFlag");
            return (Criteria) this;
        }

        public Criteria andTrsprtSmsIsudFlagIn(List<Byte> values) {
            addCriterion("TRSPRT_SMS_ISUD_FLAG in", values, "trsprtSmsIsudFlag");
            return (Criteria) this;
        }

        public Criteria andTrsprtSmsIsudFlagNotIn(List<Byte> values) {
            addCriterion("TRSPRT_SMS_ISUD_FLAG not in", values, "trsprtSmsIsudFlag");
            return (Criteria) this;
        }

        public Criteria andTrsprtSmsIsudFlagBetween(Byte value1, Byte value2) {
            addCriterion("TRSPRT_SMS_ISUD_FLAG between", value1, value2, "trsprtSmsIsudFlag");
            return (Criteria) this;
        }

        public Criteria andTrsprtSmsIsudFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("TRSPRT_SMS_ISUD_FLAG not between", value1, value2, "trsprtSmsIsudFlag");
            return (Criteria) this;
        }

        public Criteria andRevstSatisDgrIdIsNull() {
            addCriterion("REVST_SATIS_DGR_ID is null");
            return (Criteria) this;
        }

        public Criteria andRevstSatisDgrIdIsNotNull() {
            addCriterion("REVST_SATIS_DGR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRevstSatisDgrIdEqualTo(String value) {
            addCriterion("REVST_SATIS_DGR_ID =", value, "revstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andRevstSatisDgrIdNotEqualTo(String value) {
            addCriterion("REVST_SATIS_DGR_ID <>", value, "revstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andRevstSatisDgrIdGreaterThan(String value) {
            addCriterion("REVST_SATIS_DGR_ID >", value, "revstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andRevstSatisDgrIdGreaterThanOrEqualTo(String value) {
            addCriterion("REVST_SATIS_DGR_ID >=", value, "revstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andRevstSatisDgrIdLessThan(String value) {
            addCriterion("REVST_SATIS_DGR_ID <", value, "revstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andRevstSatisDgrIdLessThanOrEqualTo(String value) {
            addCriterion("REVST_SATIS_DGR_ID <=", value, "revstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andRevstSatisDgrIdLike(String value) {
            addCriterion("REVST_SATIS_DGR_ID like", value, "revstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andRevstSatisDgrIdNotLike(String value) {
            addCriterion("REVST_SATIS_DGR_ID not like", value, "revstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andRevstSatisDgrIdIn(List<String> values) {
            addCriterion("REVST_SATIS_DGR_ID in", values, "revstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andRevstSatisDgrIdNotIn(List<String> values) {
            addCriterion("REVST_SATIS_DGR_ID not in", values, "revstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andRevstSatisDgrIdBetween(String value1, String value2) {
            addCriterion("REVST_SATIS_DGR_ID between", value1, value2, "revstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andRevstSatisDgrIdNotBetween(String value1, String value2) {
            addCriterion("REVST_SATIS_DGR_ID not between", value1, value2, "revstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andHandleContactCustStateIsNull() {
            addCriterion("HANDLE_CONTACT_CUST_STATE is null");
            return (Criteria) this;
        }

        public Criteria andHandleContactCustStateIsNotNull() {
            addCriterion("HANDLE_CONTACT_CUST_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andHandleContactCustStateEqualTo(String value) {
            addCriterion("HANDLE_CONTACT_CUST_STATE =", value, "handleContactCustState");
            return (Criteria) this;
        }

        public Criteria andHandleContactCustStateNotEqualTo(String value) {
            addCriterion("HANDLE_CONTACT_CUST_STATE <>", value, "handleContactCustState");
            return (Criteria) this;
        }

        public Criteria andHandleContactCustStateGreaterThan(String value) {
            addCriterion("HANDLE_CONTACT_CUST_STATE >", value, "handleContactCustState");
            return (Criteria) this;
        }

        public Criteria andHandleContactCustStateGreaterThanOrEqualTo(String value) {
            addCriterion("HANDLE_CONTACT_CUST_STATE >=", value, "handleContactCustState");
            return (Criteria) this;
        }

        public Criteria andHandleContactCustStateLessThan(String value) {
            addCriterion("HANDLE_CONTACT_CUST_STATE <", value, "handleContactCustState");
            return (Criteria) this;
        }

        public Criteria andHandleContactCustStateLessThanOrEqualTo(String value) {
            addCriterion("HANDLE_CONTACT_CUST_STATE <=", value, "handleContactCustState");
            return (Criteria) this;
        }

        public Criteria andHandleContactCustStateLike(String value) {
            addCriterion("HANDLE_CONTACT_CUST_STATE like", value, "handleContactCustState");
            return (Criteria) this;
        }

        public Criteria andHandleContactCustStateNotLike(String value) {
            addCriterion("HANDLE_CONTACT_CUST_STATE not like", value, "handleContactCustState");
            return (Criteria) this;
        }

        public Criteria andHandleContactCustStateIn(List<String> values) {
            addCriterion("HANDLE_CONTACT_CUST_STATE in", values, "handleContactCustState");
            return (Criteria) this;
        }

        public Criteria andHandleContactCustStateNotIn(List<String> values) {
            addCriterion("HANDLE_CONTACT_CUST_STATE not in", values, "handleContactCustState");
            return (Criteria) this;
        }

        public Criteria andHandleContactCustStateBetween(String value1, String value2) {
            addCriterion("HANDLE_CONTACT_CUST_STATE between", value1, value2, "handleContactCustState");
            return (Criteria) this;
        }

        public Criteria andHandleContactCustStateNotBetween(String value1, String value2) {
            addCriterion("HANDLE_CONTACT_CUST_STATE not between", value1, value2, "handleContactCustState");
            return (Criteria) this;
        }

        public Criteria andRevstComplteStaffNumIsNull() {
            addCriterion("REVST_COMPLTE_STAFF_NUM is null");
            return (Criteria) this;
        }

        public Criteria andRevstComplteStaffNumIsNotNull() {
            addCriterion("REVST_COMPLTE_STAFF_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andRevstComplteStaffNumEqualTo(String value) {
            addCriterion("REVST_COMPLTE_STAFF_NUM =", value, "revstComplteStaffNum");
            return (Criteria) this;
        }

        public Criteria andRevstComplteStaffNumNotEqualTo(String value) {
            addCriterion("REVST_COMPLTE_STAFF_NUM <>", value, "revstComplteStaffNum");
            return (Criteria) this;
        }

        public Criteria andRevstComplteStaffNumGreaterThan(String value) {
            addCriterion("REVST_COMPLTE_STAFF_NUM >", value, "revstComplteStaffNum");
            return (Criteria) this;
        }

        public Criteria andRevstComplteStaffNumGreaterThanOrEqualTo(String value) {
            addCriterion("REVST_COMPLTE_STAFF_NUM >=", value, "revstComplteStaffNum");
            return (Criteria) this;
        }

        public Criteria andRevstComplteStaffNumLessThan(String value) {
            addCriterion("REVST_COMPLTE_STAFF_NUM <", value, "revstComplteStaffNum");
            return (Criteria) this;
        }

        public Criteria andRevstComplteStaffNumLessThanOrEqualTo(String value) {
            addCriterion("REVST_COMPLTE_STAFF_NUM <=", value, "revstComplteStaffNum");
            return (Criteria) this;
        }

        public Criteria andRevstComplteStaffNumLike(String value) {
            addCriterion("REVST_COMPLTE_STAFF_NUM like", value, "revstComplteStaffNum");
            return (Criteria) this;
        }

        public Criteria andRevstComplteStaffNumNotLike(String value) {
            addCriterion("REVST_COMPLTE_STAFF_NUM not like", value, "revstComplteStaffNum");
            return (Criteria) this;
        }

        public Criteria andRevstComplteStaffNumIn(List<String> values) {
            addCriterion("REVST_COMPLTE_STAFF_NUM in", values, "revstComplteStaffNum");
            return (Criteria) this;
        }

        public Criteria andRevstComplteStaffNumNotIn(List<String> values) {
            addCriterion("REVST_COMPLTE_STAFF_NUM not in", values, "revstComplteStaffNum");
            return (Criteria) this;
        }

        public Criteria andRevstComplteStaffNumBetween(String value1, String value2) {
            addCriterion("REVST_COMPLTE_STAFF_NUM between", value1, value2, "revstComplteStaffNum");
            return (Criteria) this;
        }

        public Criteria andRevstComplteStaffNumNotBetween(String value1, String value2) {
            addCriterion("REVST_COMPLTE_STAFF_NUM not between", value1, value2, "revstComplteStaffNum");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkSatisDgrIdIsNull() {
            addCriterion("SMS_FDBK_SATIS_DGR_ID is null");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkSatisDgrIdIsNotNull() {
            addCriterion("SMS_FDBK_SATIS_DGR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkSatisDgrIdEqualTo(String value) {
            addCriterion("SMS_FDBK_SATIS_DGR_ID =", value, "smsFdbkSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkSatisDgrIdNotEqualTo(String value) {
            addCriterion("SMS_FDBK_SATIS_DGR_ID <>", value, "smsFdbkSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkSatisDgrIdGreaterThan(String value) {
            addCriterion("SMS_FDBK_SATIS_DGR_ID >", value, "smsFdbkSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkSatisDgrIdGreaterThanOrEqualTo(String value) {
            addCriterion("SMS_FDBK_SATIS_DGR_ID >=", value, "smsFdbkSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkSatisDgrIdLessThan(String value) {
            addCriterion("SMS_FDBK_SATIS_DGR_ID <", value, "smsFdbkSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkSatisDgrIdLessThanOrEqualTo(String value) {
            addCriterion("SMS_FDBK_SATIS_DGR_ID <=", value, "smsFdbkSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkSatisDgrIdLike(String value) {
            addCriterion("SMS_FDBK_SATIS_DGR_ID like", value, "smsFdbkSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkSatisDgrIdNotLike(String value) {
            addCriterion("SMS_FDBK_SATIS_DGR_ID not like", value, "smsFdbkSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkSatisDgrIdIn(List<String> values) {
            addCriterion("SMS_FDBK_SATIS_DGR_ID in", values, "smsFdbkSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkSatisDgrIdNotIn(List<String> values) {
            addCriterion("SMS_FDBK_SATIS_DGR_ID not in", values, "smsFdbkSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkSatisDgrIdBetween(String value1, String value2) {
            addCriterion("SMS_FDBK_SATIS_DGR_ID between", value1, value2, "smsFdbkSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkSatisDgrIdNotBetween(String value1, String value2) {
            addCriterion("SMS_FDBK_SATIS_DGR_ID not between", value1, value2, "smsFdbkSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andIsudSatisSmsFlagIsNull() {
            addCriterion("ISUD_SATIS_SMS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIsudSatisSmsFlagIsNotNull() {
            addCriterion("ISUD_SATIS_SMS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIsudSatisSmsFlagEqualTo(Byte value) {
            addCriterion("ISUD_SATIS_SMS_FLAG =", value, "isudSatisSmsFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisSmsFlagNotEqualTo(Byte value) {
            addCriterion("ISUD_SATIS_SMS_FLAG <>", value, "isudSatisSmsFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisSmsFlagGreaterThan(Byte value) {
            addCriterion("ISUD_SATIS_SMS_FLAG >", value, "isudSatisSmsFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisSmsFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("ISUD_SATIS_SMS_FLAG >=", value, "isudSatisSmsFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisSmsFlagLessThan(Byte value) {
            addCriterion("ISUD_SATIS_SMS_FLAG <", value, "isudSatisSmsFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisSmsFlagLessThanOrEqualTo(Byte value) {
            addCriterion("ISUD_SATIS_SMS_FLAG <=", value, "isudSatisSmsFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisSmsFlagIn(List<Byte> values) {
            addCriterion("ISUD_SATIS_SMS_FLAG in", values, "isudSatisSmsFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisSmsFlagNotIn(List<Byte> values) {
            addCriterion("ISUD_SATIS_SMS_FLAG not in", values, "isudSatisSmsFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisSmsFlagBetween(Byte value1, Byte value2) {
            addCriterion("ISUD_SATIS_SMS_FLAG between", value1, value2, "isudSatisSmsFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisSmsFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("ISUD_SATIS_SMS_FLAG not between", value1, value2, "isudSatisSmsFlag");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkNSatisRsnDescIsNull() {
            addCriterion("SMS_FDBK_N_SATIS_RSN_DESC is null");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkNSatisRsnDescIsNotNull() {
            addCriterion("SMS_FDBK_N_SATIS_RSN_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkNSatisRsnDescEqualTo(String value) {
            addCriterion("SMS_FDBK_N_SATIS_RSN_DESC =", value, "smsFdbkNSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkNSatisRsnDescNotEqualTo(String value) {
            addCriterion("SMS_FDBK_N_SATIS_RSN_DESC <>", value, "smsFdbkNSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkNSatisRsnDescGreaterThan(String value) {
            addCriterion("SMS_FDBK_N_SATIS_RSN_DESC >", value, "smsFdbkNSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkNSatisRsnDescGreaterThanOrEqualTo(String value) {
            addCriterion("SMS_FDBK_N_SATIS_RSN_DESC >=", value, "smsFdbkNSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkNSatisRsnDescLessThan(String value) {
            addCriterion("SMS_FDBK_N_SATIS_RSN_DESC <", value, "smsFdbkNSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkNSatisRsnDescLessThanOrEqualTo(String value) {
            addCriterion("SMS_FDBK_N_SATIS_RSN_DESC <=", value, "smsFdbkNSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkNSatisRsnDescLike(String value) {
            addCriterion("SMS_FDBK_N_SATIS_RSN_DESC like", value, "smsFdbkNSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkNSatisRsnDescNotLike(String value) {
            addCriterion("SMS_FDBK_N_SATIS_RSN_DESC not like", value, "smsFdbkNSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkNSatisRsnDescIn(List<String> values) {
            addCriterion("SMS_FDBK_N_SATIS_RSN_DESC in", values, "smsFdbkNSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkNSatisRsnDescNotIn(List<String> values) {
            addCriterion("SMS_FDBK_N_SATIS_RSN_DESC not in", values, "smsFdbkNSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkNSatisRsnDescBetween(String value1, String value2) {
            addCriterion("SMS_FDBK_N_SATIS_RSN_DESC between", value1, value2, "smsFdbkNSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andSmsFdbkNSatisRsnDescNotBetween(String value1, String value2) {
            addCriterion("SMS_FDBK_N_SATIS_RSN_DESC not between", value1, value2, "smsFdbkNSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andFdbkTimeIsNull() {
            addCriterion("FDBK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFdbkTimeIsNotNull() {
            addCriterion("FDBK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFdbkTimeEqualTo(Date value) {
            addCriterion("FDBK_TIME =", value, "fdbkTime");
            return (Criteria) this;
        }

        public Criteria andFdbkTimeNotEqualTo(Date value) {
            addCriterion("FDBK_TIME <>", value, "fdbkTime");
            return (Criteria) this;
        }

        public Criteria andFdbkTimeGreaterThan(Date value) {
            addCriterion("FDBK_TIME >", value, "fdbkTime");
            return (Criteria) this;
        }

        public Criteria andFdbkTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FDBK_TIME >=", value, "fdbkTime");
            return (Criteria) this;
        }

        public Criteria andFdbkTimeLessThan(Date value) {
            addCriterion("FDBK_TIME <", value, "fdbkTime");
            return (Criteria) this;
        }

        public Criteria andFdbkTimeLessThanOrEqualTo(Date value) {
            addCriterion("FDBK_TIME <=", value, "fdbkTime");
            return (Criteria) this;
        }

        public Criteria andFdbkTimeIn(List<Date> values) {
            addCriterion("FDBK_TIME in", values, "fdbkTime");
            return (Criteria) this;
        }

        public Criteria andFdbkTimeNotIn(List<Date> values) {
            addCriterion("FDBK_TIME not in", values, "fdbkTime");
            return (Criteria) this;
        }

        public Criteria andFdbkTimeBetween(Date value1, Date value2) {
            addCriterion("FDBK_TIME between", value1, value2, "fdbkTime");
            return (Criteria) this;
        }

        public Criteria andFdbkTimeNotBetween(Date value1, Date value2) {
            addCriterion("FDBK_TIME not between", value1, value2, "fdbkTime");
            return (Criteria) this;
        }

        public Criteria andLastConcTimeIsNull() {
            addCriterion("LAST_CONC_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastConcTimeIsNotNull() {
            addCriterion("LAST_CONC_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastConcTimeEqualTo(Date value) {
            addCriterion("LAST_CONC_TIME =", value, "lastConcTime");
            return (Criteria) this;
        }

        public Criteria andLastConcTimeNotEqualTo(Date value) {
            addCriterion("LAST_CONC_TIME <>", value, "lastConcTime");
            return (Criteria) this;
        }

        public Criteria andLastConcTimeGreaterThan(Date value) {
            addCriterion("LAST_CONC_TIME >", value, "lastConcTime");
            return (Criteria) this;
        }

        public Criteria andLastConcTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_CONC_TIME >=", value, "lastConcTime");
            return (Criteria) this;
        }

        public Criteria andLastConcTimeLessThan(Date value) {
            addCriterion("LAST_CONC_TIME <", value, "lastConcTime");
            return (Criteria) this;
        }

        public Criteria andLastConcTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_CONC_TIME <=", value, "lastConcTime");
            return (Criteria) this;
        }

        public Criteria andLastConcTimeIn(List<Date> values) {
            addCriterion("LAST_CONC_TIME in", values, "lastConcTime");
            return (Criteria) this;
        }

        public Criteria andLastConcTimeNotIn(List<Date> values) {
            addCriterion("LAST_CONC_TIME not in", values, "lastConcTime");
            return (Criteria) this;
        }

        public Criteria andLastConcTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_CONC_TIME between", value1, value2, "lastConcTime");
            return (Criteria) this;
        }

        public Criteria andLastConcTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_CONC_TIME not between", value1, value2, "lastConcTime");
            return (Criteria) this;
        }

        public Criteria andConcTmsCntIsNull() {
            addCriterion("CONC_TMS_CNT is null");
            return (Criteria) this;
        }

        public Criteria andConcTmsCntIsNotNull() {
            addCriterion("CONC_TMS_CNT is not null");
            return (Criteria) this;
        }

        public Criteria andConcTmsCntEqualTo(Byte value) {
            addCriterion("CONC_TMS_CNT =", value, "concTmsCnt");
            return (Criteria) this;
        }

        public Criteria andConcTmsCntNotEqualTo(Byte value) {
            addCriterion("CONC_TMS_CNT <>", value, "concTmsCnt");
            return (Criteria) this;
        }

        public Criteria andConcTmsCntGreaterThan(Byte value) {
            addCriterion("CONC_TMS_CNT >", value, "concTmsCnt");
            return (Criteria) this;
        }

        public Criteria andConcTmsCntGreaterThanOrEqualTo(Byte value) {
            addCriterion("CONC_TMS_CNT >=", value, "concTmsCnt");
            return (Criteria) this;
        }

        public Criteria andConcTmsCntLessThan(Byte value) {
            addCriterion("CONC_TMS_CNT <", value, "concTmsCnt");
            return (Criteria) this;
        }

        public Criteria andConcTmsCntLessThanOrEqualTo(Byte value) {
            addCriterion("CONC_TMS_CNT <=", value, "concTmsCnt");
            return (Criteria) this;
        }

        public Criteria andConcTmsCntIn(List<Byte> values) {
            addCriterion("CONC_TMS_CNT in", values, "concTmsCnt");
            return (Criteria) this;
        }

        public Criteria andConcTmsCntNotIn(List<Byte> values) {
            addCriterion("CONC_TMS_CNT not in", values, "concTmsCnt");
            return (Criteria) this;
        }

        public Criteria andConcTmsCntBetween(Byte value1, Byte value2) {
            addCriterion("CONC_TMS_CNT between", value1, value2, "concTmsCnt");
            return (Criteria) this;
        }

        public Criteria andConcTmsCntNotBetween(Byte value1, Byte value2) {
            addCriterion("CONC_TMS_CNT not between", value1, value2, "concTmsCnt");
            return (Criteria) this;
        }

        public Criteria andRmdrStsCdIsNull() {
            addCriterion("RMDR_STS_CD is null");
            return (Criteria) this;
        }

        public Criteria andRmdrStsCdIsNotNull() {
            addCriterion("RMDR_STS_CD is not null");
            return (Criteria) this;
        }

        public Criteria andRmdrStsCdEqualTo(String value) {
            addCriterion("RMDR_STS_CD =", value, "rmdrStsCd");
            return (Criteria) this;
        }

        public Criteria andRmdrStsCdNotEqualTo(String value) {
            addCriterion("RMDR_STS_CD <>", value, "rmdrStsCd");
            return (Criteria) this;
        }

        public Criteria andRmdrStsCdGreaterThan(String value) {
            addCriterion("RMDR_STS_CD >", value, "rmdrStsCd");
            return (Criteria) this;
        }

        public Criteria andRmdrStsCdGreaterThanOrEqualTo(String value) {
            addCriterion("RMDR_STS_CD >=", value, "rmdrStsCd");
            return (Criteria) this;
        }

        public Criteria andRmdrStsCdLessThan(String value) {
            addCriterion("RMDR_STS_CD <", value, "rmdrStsCd");
            return (Criteria) this;
        }

        public Criteria andRmdrStsCdLessThanOrEqualTo(String value) {
            addCriterion("RMDR_STS_CD <=", value, "rmdrStsCd");
            return (Criteria) this;
        }

        public Criteria andRmdrStsCdLike(String value) {
            addCriterion("RMDR_STS_CD like", value, "rmdrStsCd");
            return (Criteria) this;
        }

        public Criteria andRmdrStsCdNotLike(String value) {
            addCriterion("RMDR_STS_CD not like", value, "rmdrStsCd");
            return (Criteria) this;
        }

        public Criteria andRmdrStsCdIn(List<String> values) {
            addCriterion("RMDR_STS_CD in", values, "rmdrStsCd");
            return (Criteria) this;
        }

        public Criteria andRmdrStsCdNotIn(List<String> values) {
            addCriterion("RMDR_STS_CD not in", values, "rmdrStsCd");
            return (Criteria) this;
        }

        public Criteria andRmdrStsCdBetween(String value1, String value2) {
            addCriterion("RMDR_STS_CD between", value1, value2, "rmdrStsCd");
            return (Criteria) this;
        }

        public Criteria andRmdrStsCdNotBetween(String value1, String value2) {
            addCriterion("RMDR_STS_CD not between", value1, value2, "rmdrStsCd");
            return (Criteria) this;
        }

        public Criteria andNSatisRsnDescIsNull() {
            addCriterion("N_SATIS_RSN_DESC is null");
            return (Criteria) this;
        }

        public Criteria andNSatisRsnDescIsNotNull() {
            addCriterion("N_SATIS_RSN_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andNSatisRsnDescEqualTo(String value) {
            addCriterion("N_SATIS_RSN_DESC =", value, "nSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andNSatisRsnDescNotEqualTo(String value) {
            addCriterion("N_SATIS_RSN_DESC <>", value, "nSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andNSatisRsnDescGreaterThan(String value) {
            addCriterion("N_SATIS_RSN_DESC >", value, "nSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andNSatisRsnDescGreaterThanOrEqualTo(String value) {
            addCriterion("N_SATIS_RSN_DESC >=", value, "nSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andNSatisRsnDescLessThan(String value) {
            addCriterion("N_SATIS_RSN_DESC <", value, "nSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andNSatisRsnDescLessThanOrEqualTo(String value) {
            addCriterion("N_SATIS_RSN_DESC <=", value, "nSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andNSatisRsnDescLike(String value) {
            addCriterion("N_SATIS_RSN_DESC like", value, "nSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andNSatisRsnDescNotLike(String value) {
            addCriterion("N_SATIS_RSN_DESC not like", value, "nSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andNSatisRsnDescIn(List<String> values) {
            addCriterion("N_SATIS_RSN_DESC in", values, "nSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andNSatisRsnDescNotIn(List<String> values) {
            addCriterion("N_SATIS_RSN_DESC not in", values, "nSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andNSatisRsnDescBetween(String value1, String value2) {
            addCriterion("N_SATIS_RSN_DESC between", value1, value2, "nSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andNSatisRsnDescNotBetween(String value1, String value2) {
            addCriterion("N_SATIS_RSN_DESC not between", value1, value2, "nSatisRsnDesc");
            return (Criteria) this;
        }

        public Criteria andIsudSatisDgrCollFlagIsNull() {
            addCriterion("ISUD_SATIS_DGR_COLL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIsudSatisDgrCollFlagIsNotNull() {
            addCriterion("ISUD_SATIS_DGR_COLL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIsudSatisDgrCollFlagEqualTo(Byte value) {
            addCriterion("ISUD_SATIS_DGR_COLL_FLAG =", value, "isudSatisDgrCollFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisDgrCollFlagNotEqualTo(Byte value) {
            addCriterion("ISUD_SATIS_DGR_COLL_FLAG <>", value, "isudSatisDgrCollFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisDgrCollFlagGreaterThan(Byte value) {
            addCriterion("ISUD_SATIS_DGR_COLL_FLAG >", value, "isudSatisDgrCollFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisDgrCollFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("ISUD_SATIS_DGR_COLL_FLAG >=", value, "isudSatisDgrCollFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisDgrCollFlagLessThan(Byte value) {
            addCriterion("ISUD_SATIS_DGR_COLL_FLAG <", value, "isudSatisDgrCollFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisDgrCollFlagLessThanOrEqualTo(Byte value) {
            addCriterion("ISUD_SATIS_DGR_COLL_FLAG <=", value, "isudSatisDgrCollFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisDgrCollFlagIn(List<Byte> values) {
            addCriterion("ISUD_SATIS_DGR_COLL_FLAG in", values, "isudSatisDgrCollFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisDgrCollFlagNotIn(List<Byte> values) {
            addCriterion("ISUD_SATIS_DGR_COLL_FLAG not in", values, "isudSatisDgrCollFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisDgrCollFlagBetween(Byte value1, Byte value2) {
            addCriterion("ISUD_SATIS_DGR_COLL_FLAG between", value1, value2, "isudSatisDgrCollFlag");
            return (Criteria) this;
        }

        public Criteria andIsudSatisDgrCollFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("ISUD_SATIS_DGR_COLL_FLAG not between", value1, value2, "isudSatisDgrCollFlag");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsFlagIsNull() {
            addCriterion("DPLCT_CMPLNTS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsFlagIsNotNull() {
            addCriterion("DPLCT_CMPLNTS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsFlagEqualTo(Byte value) {
            addCriterion("DPLCT_CMPLNTS_FLAG =", value, "dplctCmplntsFlag");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsFlagNotEqualTo(Byte value) {
            addCriterion("DPLCT_CMPLNTS_FLAG <>", value, "dplctCmplntsFlag");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsFlagGreaterThan(Byte value) {
            addCriterion("DPLCT_CMPLNTS_FLAG >", value, "dplctCmplntsFlag");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("DPLCT_CMPLNTS_FLAG >=", value, "dplctCmplntsFlag");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsFlagLessThan(Byte value) {
            addCriterion("DPLCT_CMPLNTS_FLAG <", value, "dplctCmplntsFlag");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsFlagLessThanOrEqualTo(Byte value) {
            addCriterion("DPLCT_CMPLNTS_FLAG <=", value, "dplctCmplntsFlag");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsFlagIn(List<Byte> values) {
            addCriterion("DPLCT_CMPLNTS_FLAG in", values, "dplctCmplntsFlag");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsFlagNotIn(List<Byte> values) {
            addCriterion("DPLCT_CMPLNTS_FLAG not in", values, "dplctCmplntsFlag");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsFlagBetween(Byte value1, Byte value2) {
            addCriterion("DPLCT_CMPLNTS_FLAG between", value1, value2, "dplctCmplntsFlag");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("DPLCT_CMPLNTS_FLAG not between", value1, value2, "dplctCmplntsFlag");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsTmsCntIsNull() {
            addCriterion("DPLCT_CMPLNTS_TMS_CNT is null");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsTmsCntIsNotNull() {
            addCriterion("DPLCT_CMPLNTS_TMS_CNT is not null");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsTmsCntEqualTo(Integer value) {
            addCriterion("DPLCT_CMPLNTS_TMS_CNT =", value, "dplctCmplntsTmsCnt");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsTmsCntNotEqualTo(Integer value) {
            addCriterion("DPLCT_CMPLNTS_TMS_CNT <>", value, "dplctCmplntsTmsCnt");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsTmsCntGreaterThan(Integer value) {
            addCriterion("DPLCT_CMPLNTS_TMS_CNT >", value, "dplctCmplntsTmsCnt");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsTmsCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("DPLCT_CMPLNTS_TMS_CNT >=", value, "dplctCmplntsTmsCnt");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsTmsCntLessThan(Integer value) {
            addCriterion("DPLCT_CMPLNTS_TMS_CNT <", value, "dplctCmplntsTmsCnt");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsTmsCntLessThanOrEqualTo(Integer value) {
            addCriterion("DPLCT_CMPLNTS_TMS_CNT <=", value, "dplctCmplntsTmsCnt");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsTmsCntIn(List<Integer> values) {
            addCriterion("DPLCT_CMPLNTS_TMS_CNT in", values, "dplctCmplntsTmsCnt");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsTmsCntNotIn(List<Integer> values) {
            addCriterion("DPLCT_CMPLNTS_TMS_CNT not in", values, "dplctCmplntsTmsCnt");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsTmsCntBetween(Integer value1, Integer value2) {
            addCriterion("DPLCT_CMPLNTS_TMS_CNT between", value1, value2, "dplctCmplntsTmsCnt");
            return (Criteria) this;
        }

        public Criteria andDplctCmplntsTmsCntNotBetween(Integer value1, Integer value2) {
            addCriterion("DPLCT_CMPLNTS_TMS_CNT not between", value1, value2, "dplctCmplntsTmsCnt");
            return (Criteria) this;
        }

        public Criteria andHisWorkOrderNumIsNull() {
            addCriterion("HIS_WORK_ORDER_NUM is null");
            return (Criteria) this;
        }

        public Criteria andHisWorkOrderNumIsNotNull() {
            addCriterion("HIS_WORK_ORDER_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andHisWorkOrderNumEqualTo(Integer value) {
            addCriterion("HIS_WORK_ORDER_NUM =", value, "hisWorkOrderNum");
            return (Criteria) this;
        }

        public Criteria andHisWorkOrderNumNotEqualTo(Integer value) {
            addCriterion("HIS_WORK_ORDER_NUM <>", value, "hisWorkOrderNum");
            return (Criteria) this;
        }

        public Criteria andHisWorkOrderNumGreaterThan(Integer value) {
            addCriterion("HIS_WORK_ORDER_NUM >", value, "hisWorkOrderNum");
            return (Criteria) this;
        }

        public Criteria andHisWorkOrderNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("HIS_WORK_ORDER_NUM >=", value, "hisWorkOrderNum");
            return (Criteria) this;
        }

        public Criteria andHisWorkOrderNumLessThan(Integer value) {
            addCriterion("HIS_WORK_ORDER_NUM <", value, "hisWorkOrderNum");
            return (Criteria) this;
        }

        public Criteria andHisWorkOrderNumLessThanOrEqualTo(Integer value) {
            addCriterion("HIS_WORK_ORDER_NUM <=", value, "hisWorkOrderNum");
            return (Criteria) this;
        }

        public Criteria andHisWorkOrderNumIn(List<Integer> values) {
            addCriterion("HIS_WORK_ORDER_NUM in", values, "hisWorkOrderNum");
            return (Criteria) this;
        }

        public Criteria andHisWorkOrderNumNotIn(List<Integer> values) {
            addCriterion("HIS_WORK_ORDER_NUM not in", values, "hisWorkOrderNum");
            return (Criteria) this;
        }

        public Criteria andHisWorkOrderNumBetween(Integer value1, Integer value2) {
            addCriterion("HIS_WORK_ORDER_NUM between", value1, value2, "hisWorkOrderNum");
            return (Criteria) this;
        }

        public Criteria andHisWorkOrderNumNotBetween(Integer value1, Integer value2) {
            addCriterion("HIS_WORK_ORDER_NUM not between", value1, value2, "hisWorkOrderNum");
            return (Criteria) this;
        }

        public Criteria andExpctFdbkTimeIsNull() {
            addCriterion("EXPCT_FDBK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExpctFdbkTimeIsNotNull() {
            addCriterion("EXPCT_FDBK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExpctFdbkTimeEqualTo(Date value) {
            addCriterion("EXPCT_FDBK_TIME =", value, "expctFdbkTime");
            return (Criteria) this;
        }

        public Criteria andExpctFdbkTimeNotEqualTo(Date value) {
            addCriterion("EXPCT_FDBK_TIME <>", value, "expctFdbkTime");
            return (Criteria) this;
        }

        public Criteria andExpctFdbkTimeGreaterThan(Date value) {
            addCriterion("EXPCT_FDBK_TIME >", value, "expctFdbkTime");
            return (Criteria) this;
        }

        public Criteria andExpctFdbkTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EXPCT_FDBK_TIME >=", value, "expctFdbkTime");
            return (Criteria) this;
        }

        public Criteria andExpctFdbkTimeLessThan(Date value) {
            addCriterion("EXPCT_FDBK_TIME <", value, "expctFdbkTime");
            return (Criteria) this;
        }

        public Criteria andExpctFdbkTimeLessThanOrEqualTo(Date value) {
            addCriterion("EXPCT_FDBK_TIME <=", value, "expctFdbkTime");
            return (Criteria) this;
        }

        public Criteria andExpctFdbkTimeIn(List<Date> values) {
            addCriterion("EXPCT_FDBK_TIME in", values, "expctFdbkTime");
            return (Criteria) this;
        }

        public Criteria andExpctFdbkTimeNotIn(List<Date> values) {
            addCriterion("EXPCT_FDBK_TIME not in", values, "expctFdbkTime");
            return (Criteria) this;
        }

        public Criteria andExpctFdbkTimeBetween(Date value1, Date value2) {
            addCriterion("EXPCT_FDBK_TIME between", value1, value2, "expctFdbkTime");
            return (Criteria) this;
        }

        public Criteria andExpctFdbkTimeNotBetween(Date value1, Date value2) {
            addCriterion("EXPCT_FDBK_TIME not between", value1, value2, "expctFdbkTime");
            return (Criteria) this;
        }

        public Criteria andActlFdbkTimeIsNull() {
            addCriterion("ACTL_FDBK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andActlFdbkTimeIsNotNull() {
            addCriterion("ACTL_FDBK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andActlFdbkTimeEqualTo(Date value) {
            addCriterion("ACTL_FDBK_TIME =", value, "actlFdbkTime");
            return (Criteria) this;
        }

        public Criteria andActlFdbkTimeNotEqualTo(Date value) {
            addCriterion("ACTL_FDBK_TIME <>", value, "actlFdbkTime");
            return (Criteria) this;
        }

        public Criteria andActlFdbkTimeGreaterThan(Date value) {
            addCriterion("ACTL_FDBK_TIME >", value, "actlFdbkTime");
            return (Criteria) this;
        }

        public Criteria andActlFdbkTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ACTL_FDBK_TIME >=", value, "actlFdbkTime");
            return (Criteria) this;
        }

        public Criteria andActlFdbkTimeLessThan(Date value) {
            addCriterion("ACTL_FDBK_TIME <", value, "actlFdbkTime");
            return (Criteria) this;
        }

        public Criteria andActlFdbkTimeLessThanOrEqualTo(Date value) {
            addCriterion("ACTL_FDBK_TIME <=", value, "actlFdbkTime");
            return (Criteria) this;
        }

        public Criteria andActlFdbkTimeIn(List<Date> values) {
            addCriterion("ACTL_FDBK_TIME in", values, "actlFdbkTime");
            return (Criteria) this;
        }

        public Criteria andActlFdbkTimeNotIn(List<Date> values) {
            addCriterion("ACTL_FDBK_TIME not in", values, "actlFdbkTime");
            return (Criteria) this;
        }

        public Criteria andActlFdbkTimeBetween(Date value1, Date value2) {
            addCriterion("ACTL_FDBK_TIME between", value1, value2, "actlFdbkTime");
            return (Criteria) this;
        }

        public Criteria andActlFdbkTimeNotBetween(Date value1, Date value2) {
            addCriterion("ACTL_FDBK_TIME not between", value1, value2, "actlFdbkTime");
            return (Criteria) this;
        }

        public Criteria andAdtnInfoFlagIsNull() {
            addCriterion("ADTN_INFO_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andAdtnInfoFlagIsNotNull() {
            addCriterion("ADTN_INFO_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andAdtnInfoFlagEqualTo(Byte value) {
            addCriterion("ADTN_INFO_FLAG =", value, "adtnInfoFlag");
            return (Criteria) this;
        }

        public Criteria andAdtnInfoFlagNotEqualTo(Byte value) {
            addCriterion("ADTN_INFO_FLAG <>", value, "adtnInfoFlag");
            return (Criteria) this;
        }

        public Criteria andAdtnInfoFlagGreaterThan(Byte value) {
            addCriterion("ADTN_INFO_FLAG >", value, "adtnInfoFlag");
            return (Criteria) this;
        }

        public Criteria andAdtnInfoFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("ADTN_INFO_FLAG >=", value, "adtnInfoFlag");
            return (Criteria) this;
        }

        public Criteria andAdtnInfoFlagLessThan(Byte value) {
            addCriterion("ADTN_INFO_FLAG <", value, "adtnInfoFlag");
            return (Criteria) this;
        }

        public Criteria andAdtnInfoFlagLessThanOrEqualTo(Byte value) {
            addCriterion("ADTN_INFO_FLAG <=", value, "adtnInfoFlag");
            return (Criteria) this;
        }

        public Criteria andAdtnInfoFlagIn(List<Byte> values) {
            addCriterion("ADTN_INFO_FLAG in", values, "adtnInfoFlag");
            return (Criteria) this;
        }

        public Criteria andAdtnInfoFlagNotIn(List<Byte> values) {
            addCriterion("ADTN_INFO_FLAG not in", values, "adtnInfoFlag");
            return (Criteria) this;
        }

        public Criteria andAdtnInfoFlagBetween(Byte value1, Byte value2) {
            addCriterion("ADTN_INFO_FLAG between", value1, value2, "adtnInfoFlag");
            return (Criteria) this;
        }

        public Criteria andAdtnInfoFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("ADTN_INFO_FLAG not between", value1, value2, "adtnInfoFlag");
            return (Criteria) this;
        }

        public Criteria andDirectDspsFlagIsNull() {
            addCriterion("DIRECT_DSPS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDirectDspsFlagIsNotNull() {
            addCriterion("DIRECT_DSPS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDirectDspsFlagEqualTo(Byte value) {
            addCriterion("DIRECT_DSPS_FLAG =", value, "directDspsFlag");
            return (Criteria) this;
        }

        public Criteria andDirectDspsFlagNotEqualTo(Byte value) {
            addCriterion("DIRECT_DSPS_FLAG <>", value, "directDspsFlag");
            return (Criteria) this;
        }

        public Criteria andDirectDspsFlagGreaterThan(Byte value) {
            addCriterion("DIRECT_DSPS_FLAG >", value, "directDspsFlag");
            return (Criteria) this;
        }

        public Criteria andDirectDspsFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("DIRECT_DSPS_FLAG >=", value, "directDspsFlag");
            return (Criteria) this;
        }

        public Criteria andDirectDspsFlagLessThan(Byte value) {
            addCriterion("DIRECT_DSPS_FLAG <", value, "directDspsFlag");
            return (Criteria) this;
        }

        public Criteria andDirectDspsFlagLessThanOrEqualTo(Byte value) {
            addCriterion("DIRECT_DSPS_FLAG <=", value, "directDspsFlag");
            return (Criteria) this;
        }

        public Criteria andDirectDspsFlagIn(List<Byte> values) {
            addCriterion("DIRECT_DSPS_FLAG in", values, "directDspsFlag");
            return (Criteria) this;
        }

        public Criteria andDirectDspsFlagNotIn(List<Byte> values) {
            addCriterion("DIRECT_DSPS_FLAG not in", values, "directDspsFlag");
            return (Criteria) this;
        }

        public Criteria andDirectDspsFlagBetween(Byte value1, Byte value2) {
            addCriterion("DIRECT_DSPS_FLAG between", value1, value2, "directDspsFlag");
            return (Criteria) this;
        }

        public Criteria andDirectDspsFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("DIRECT_DSPS_FLAG not between", value1, value2, "directDspsFlag");
            return (Criteria) this;
        }

        public Criteria andLastCustSatisDgrIdIsNull() {
            addCriterion("LAST_CUST_SATIS_DGR_ID is null");
            return (Criteria) this;
        }

        public Criteria andLastCustSatisDgrIdIsNotNull() {
            addCriterion("LAST_CUST_SATIS_DGR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLastCustSatisDgrIdEqualTo(String value) {
            addCriterion("LAST_CUST_SATIS_DGR_ID =", value, "lastCustSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andLastCustSatisDgrIdNotEqualTo(String value) {
            addCriterion("LAST_CUST_SATIS_DGR_ID <>", value, "lastCustSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andLastCustSatisDgrIdGreaterThan(String value) {
            addCriterion("LAST_CUST_SATIS_DGR_ID >", value, "lastCustSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andLastCustSatisDgrIdGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_CUST_SATIS_DGR_ID >=", value, "lastCustSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andLastCustSatisDgrIdLessThan(String value) {
            addCriterion("LAST_CUST_SATIS_DGR_ID <", value, "lastCustSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andLastCustSatisDgrIdLessThanOrEqualTo(String value) {
            addCriterion("LAST_CUST_SATIS_DGR_ID <=", value, "lastCustSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andLastCustSatisDgrIdLike(String value) {
            addCriterion("LAST_CUST_SATIS_DGR_ID like", value, "lastCustSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andLastCustSatisDgrIdNotLike(String value) {
            addCriterion("LAST_CUST_SATIS_DGR_ID not like", value, "lastCustSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andLastCustSatisDgrIdIn(List<String> values) {
            addCriterion("LAST_CUST_SATIS_DGR_ID in", values, "lastCustSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andLastCustSatisDgrIdNotIn(List<String> values) {
            addCriterion("LAST_CUST_SATIS_DGR_ID not in", values, "lastCustSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andLastCustSatisDgrIdBetween(String value1, String value2) {
            addCriterion("LAST_CUST_SATIS_DGR_ID between", value1, value2, "lastCustSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andLastCustSatisDgrIdNotBetween(String value1, String value2) {
            addCriterion("LAST_CUST_SATIS_DGR_ID not between", value1, value2, "lastCustSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andSatisDgrRevstModeCdIsNull() {
            addCriterion("SATIS_DGR_REVST_MODE_CD is null");
            return (Criteria) this;
        }

        public Criteria andSatisDgrRevstModeCdIsNotNull() {
            addCriterion("SATIS_DGR_REVST_MODE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andSatisDgrRevstModeCdEqualTo(String value) {
            addCriterion("SATIS_DGR_REVST_MODE_CD =", value, "satisDgrRevstModeCd");
            return (Criteria) this;
        }

        public Criteria andSatisDgrRevstModeCdNotEqualTo(String value) {
            addCriterion("SATIS_DGR_REVST_MODE_CD <>", value, "satisDgrRevstModeCd");
            return (Criteria) this;
        }

        public Criteria andSatisDgrRevstModeCdGreaterThan(String value) {
            addCriterion("SATIS_DGR_REVST_MODE_CD >", value, "satisDgrRevstModeCd");
            return (Criteria) this;
        }

        public Criteria andSatisDgrRevstModeCdGreaterThanOrEqualTo(String value) {
            addCriterion("SATIS_DGR_REVST_MODE_CD >=", value, "satisDgrRevstModeCd");
            return (Criteria) this;
        }

        public Criteria andSatisDgrRevstModeCdLessThan(String value) {
            addCriterion("SATIS_DGR_REVST_MODE_CD <", value, "satisDgrRevstModeCd");
            return (Criteria) this;
        }

        public Criteria andSatisDgrRevstModeCdLessThanOrEqualTo(String value) {
            addCriterion("SATIS_DGR_REVST_MODE_CD <=", value, "satisDgrRevstModeCd");
            return (Criteria) this;
        }

        public Criteria andSatisDgrRevstModeCdLike(String value) {
            addCriterion("SATIS_DGR_REVST_MODE_CD like", value, "satisDgrRevstModeCd");
            return (Criteria) this;
        }

        public Criteria andSatisDgrRevstModeCdNotLike(String value) {
            addCriterion("SATIS_DGR_REVST_MODE_CD not like", value, "satisDgrRevstModeCd");
            return (Criteria) this;
        }

        public Criteria andSatisDgrRevstModeCdIn(List<String> values) {
            addCriterion("SATIS_DGR_REVST_MODE_CD in", values, "satisDgrRevstModeCd");
            return (Criteria) this;
        }

        public Criteria andSatisDgrRevstModeCdNotIn(List<String> values) {
            addCriterion("SATIS_DGR_REVST_MODE_CD not in", values, "satisDgrRevstModeCd");
            return (Criteria) this;
        }

        public Criteria andSatisDgrRevstModeCdBetween(String value1, String value2) {
            addCriterion("SATIS_DGR_REVST_MODE_CD between", value1, value2, "satisDgrRevstModeCd");
            return (Criteria) this;
        }

        public Criteria andSatisDgrRevstModeCdNotBetween(String value1, String value2) {
            addCriterion("SATIS_DGR_REVST_MODE_CD not between", value1, value2, "satisDgrRevstModeCd");
            return (Criteria) this;
        }

        public Criteria andArtfRevstSatisDgrIdIsNull() {
            addCriterion("ARTF_REVST_SATIS_DGR_ID is null");
            return (Criteria) this;
        }

        public Criteria andArtfRevstSatisDgrIdIsNotNull() {
            addCriterion("ARTF_REVST_SATIS_DGR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andArtfRevstSatisDgrIdEqualTo(String value) {
            addCriterion("ARTF_REVST_SATIS_DGR_ID =", value, "artfRevstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andArtfRevstSatisDgrIdNotEqualTo(String value) {
            addCriterion("ARTF_REVST_SATIS_DGR_ID <>", value, "artfRevstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andArtfRevstSatisDgrIdGreaterThan(String value) {
            addCriterion("ARTF_REVST_SATIS_DGR_ID >", value, "artfRevstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andArtfRevstSatisDgrIdGreaterThanOrEqualTo(String value) {
            addCriterion("ARTF_REVST_SATIS_DGR_ID >=", value, "artfRevstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andArtfRevstSatisDgrIdLessThan(String value) {
            addCriterion("ARTF_REVST_SATIS_DGR_ID <", value, "artfRevstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andArtfRevstSatisDgrIdLessThanOrEqualTo(String value) {
            addCriterion("ARTF_REVST_SATIS_DGR_ID <=", value, "artfRevstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andArtfRevstSatisDgrIdLike(String value) {
            addCriterion("ARTF_REVST_SATIS_DGR_ID like", value, "artfRevstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andArtfRevstSatisDgrIdNotLike(String value) {
            addCriterion("ARTF_REVST_SATIS_DGR_ID not like", value, "artfRevstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andArtfRevstSatisDgrIdIn(List<String> values) {
            addCriterion("ARTF_REVST_SATIS_DGR_ID in", values, "artfRevstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andArtfRevstSatisDgrIdNotIn(List<String> values) {
            addCriterion("ARTF_REVST_SATIS_DGR_ID not in", values, "artfRevstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andArtfRevstSatisDgrIdBetween(String value1, String value2) {
            addCriterion("ARTF_REVST_SATIS_DGR_ID between", value1, value2, "artfRevstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andArtfRevstSatisDgrIdNotBetween(String value1, String value2) {
            addCriterion("ARTF_REVST_SATIS_DGR_ID not between", value1, value2, "artfRevstSatisDgrId");
            return (Criteria) this;
        }

        public Criteria andRmdrStaffNumIsNull() {
            addCriterion("RMDR_STAFF_NUM is null");
            return (Criteria) this;
        }

        public Criteria andRmdrStaffNumIsNotNull() {
            addCriterion("RMDR_STAFF_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andRmdrStaffNumEqualTo(String value) {
            addCriterion("RMDR_STAFF_NUM =", value, "rmdrStaffNum");
            return (Criteria) this;
        }

        public Criteria andRmdrStaffNumNotEqualTo(String value) {
            addCriterion("RMDR_STAFF_NUM <>", value, "rmdrStaffNum");
            return (Criteria) this;
        }

        public Criteria andRmdrStaffNumGreaterThan(String value) {
            addCriterion("RMDR_STAFF_NUM >", value, "rmdrStaffNum");
            return (Criteria) this;
        }

        public Criteria andRmdrStaffNumGreaterThanOrEqualTo(String value) {
            addCriterion("RMDR_STAFF_NUM >=", value, "rmdrStaffNum");
            return (Criteria) this;
        }

        public Criteria andRmdrStaffNumLessThan(String value) {
            addCriterion("RMDR_STAFF_NUM <", value, "rmdrStaffNum");
            return (Criteria) this;
        }

        public Criteria andRmdrStaffNumLessThanOrEqualTo(String value) {
            addCriterion("RMDR_STAFF_NUM <=", value, "rmdrStaffNum");
            return (Criteria) this;
        }

        public Criteria andRmdrStaffNumLike(String value) {
            addCriterion("RMDR_STAFF_NUM like", value, "rmdrStaffNum");
            return (Criteria) this;
        }

        public Criteria andRmdrStaffNumNotLike(String value) {
            addCriterion("RMDR_STAFF_NUM not like", value, "rmdrStaffNum");
            return (Criteria) this;
        }

        public Criteria andRmdrStaffNumIn(List<String> values) {
            addCriterion("RMDR_STAFF_NUM in", values, "rmdrStaffNum");
            return (Criteria) this;
        }

        public Criteria andRmdrStaffNumNotIn(List<String> values) {
            addCriterion("RMDR_STAFF_NUM not in", values, "rmdrStaffNum");
            return (Criteria) this;
        }

        public Criteria andRmdrStaffNumBetween(String value1, String value2) {
            addCriterion("RMDR_STAFF_NUM between", value1, value2, "rmdrStaffNum");
            return (Criteria) this;
        }

        public Criteria andRmdrStaffNumNotBetween(String value1, String value2) {
            addCriterion("RMDR_STAFF_NUM not between", value1, value2, "rmdrStaffNum");
            return (Criteria) this;
        }

        public Criteria andRmdrTimeIsNull() {
            addCriterion("RMDR_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRmdrTimeIsNotNull() {
            addCriterion("RMDR_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRmdrTimeEqualTo(Date value) {
            addCriterion("RMDR_TIME =", value, "rmdrTime");
            return (Criteria) this;
        }

        public Criteria andRmdrTimeNotEqualTo(Date value) {
            addCriterion("RMDR_TIME <>", value, "rmdrTime");
            return (Criteria) this;
        }

        public Criteria andRmdrTimeGreaterThan(Date value) {
            addCriterion("RMDR_TIME >", value, "rmdrTime");
            return (Criteria) this;
        }

        public Criteria andRmdrTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RMDR_TIME >=", value, "rmdrTime");
            return (Criteria) this;
        }

        public Criteria andRmdrTimeLessThan(Date value) {
            addCriterion("RMDR_TIME <", value, "rmdrTime");
            return (Criteria) this;
        }

        public Criteria andRmdrTimeLessThanOrEqualTo(Date value) {
            addCriterion("RMDR_TIME <=", value, "rmdrTime");
            return (Criteria) this;
        }

        public Criteria andRmdrTimeIn(List<Date> values) {
            addCriterion("RMDR_TIME in", values, "rmdrTime");
            return (Criteria) this;
        }

        public Criteria andRmdrTimeNotIn(List<Date> values) {
            addCriterion("RMDR_TIME not in", values, "rmdrTime");
            return (Criteria) this;
        }

        public Criteria andRmdrTimeBetween(Date value1, Date value2) {
            addCriterion("RMDR_TIME between", value1, value2, "rmdrTime");
            return (Criteria) this;
        }

        public Criteria andRmdrTimeNotBetween(Date value1, Date value2) {
            addCriterion("RMDR_TIME not between", value1, value2, "rmdrTime");
            return (Criteria) this;
        }

        public Criteria andRmdrTmsCntIsNull() {
            addCriterion("RMDR_TMS_CNT is null");
            return (Criteria) this;
        }

        public Criteria andRmdrTmsCntIsNotNull() {
            addCriterion("RMDR_TMS_CNT is not null");
            return (Criteria) this;
        }

        public Criteria andRmdrTmsCntEqualTo(Byte value) {
            addCriterion("RMDR_TMS_CNT =", value, "rmdrTmsCnt");
            return (Criteria) this;
        }

        public Criteria andRmdrTmsCntNotEqualTo(Byte value) {
            addCriterion("RMDR_TMS_CNT <>", value, "rmdrTmsCnt");
            return (Criteria) this;
        }

        public Criteria andRmdrTmsCntGreaterThan(Byte value) {
            addCriterion("RMDR_TMS_CNT >", value, "rmdrTmsCnt");
            return (Criteria) this;
        }

        public Criteria andRmdrTmsCntGreaterThanOrEqualTo(Byte value) {
            addCriterion("RMDR_TMS_CNT >=", value, "rmdrTmsCnt");
            return (Criteria) this;
        }

        public Criteria andRmdrTmsCntLessThan(Byte value) {
            addCriterion("RMDR_TMS_CNT <", value, "rmdrTmsCnt");
            return (Criteria) this;
        }

        public Criteria andRmdrTmsCntLessThanOrEqualTo(Byte value) {
            addCriterion("RMDR_TMS_CNT <=", value, "rmdrTmsCnt");
            return (Criteria) this;
        }

        public Criteria andRmdrTmsCntIn(List<Byte> values) {
            addCriterion("RMDR_TMS_CNT in", values, "rmdrTmsCnt");
            return (Criteria) this;
        }

        public Criteria andRmdrTmsCntNotIn(List<Byte> values) {
            addCriterion("RMDR_TMS_CNT not in", values, "rmdrTmsCnt");
            return (Criteria) this;
        }

        public Criteria andRmdrTmsCntBetween(Byte value1, Byte value2) {
            addCriterion("RMDR_TMS_CNT between", value1, value2, "rmdrTmsCnt");
            return (Criteria) this;
        }

        public Criteria andRmdrTmsCntNotBetween(Byte value1, Byte value2) {
            addCriterion("RMDR_TMS_CNT not between", value1, value2, "rmdrTmsCnt");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagIsNull() {
            addCriterion("URGE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagIsNotNull() {
            addCriterion("URGE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagEqualTo(Byte value) {
            addCriterion("URGE_FLAG =", value, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagNotEqualTo(Byte value) {
            addCriterion("URGE_FLAG <>", value, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagGreaterThan(Byte value) {
            addCriterion("URGE_FLAG >", value, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("URGE_FLAG >=", value, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagLessThan(Byte value) {
            addCriterion("URGE_FLAG <", value, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagLessThanOrEqualTo(Byte value) {
            addCriterion("URGE_FLAG <=", value, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagIn(List<Byte> values) {
            addCriterion("URGE_FLAG in", values, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagNotIn(List<Byte> values) {
            addCriterion("URGE_FLAG not in", values, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagBetween(Byte value1, Byte value2) {
            addCriterion("URGE_FLAG between", value1, value2, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andUrgeFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("URGE_FLAG not between", value1, value2, "urgeFlag");
            return (Criteria) this;
        }

        public Criteria andRetnBlFlagIsNull() {
            addCriterion("RETN_BL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andRetnBlFlagIsNotNull() {
            addCriterion("RETN_BL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andRetnBlFlagEqualTo(Byte value) {
            addCriterion("RETN_BL_FLAG =", value, "retnBlFlag");
            return (Criteria) this;
        }

        public Criteria andRetnBlFlagNotEqualTo(Byte value) {
            addCriterion("RETN_BL_FLAG <>", value, "retnBlFlag");
            return (Criteria) this;
        }

        public Criteria andRetnBlFlagGreaterThan(Byte value) {
            addCriterion("RETN_BL_FLAG >", value, "retnBlFlag");
            return (Criteria) this;
        }

        public Criteria andRetnBlFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("RETN_BL_FLAG >=", value, "retnBlFlag");
            return (Criteria) this;
        }

        public Criteria andRetnBlFlagLessThan(Byte value) {
            addCriterion("RETN_BL_FLAG <", value, "retnBlFlag");
            return (Criteria) this;
        }

        public Criteria andRetnBlFlagLessThanOrEqualTo(Byte value) {
            addCriterion("RETN_BL_FLAG <=", value, "retnBlFlag");
            return (Criteria) this;
        }

        public Criteria andRetnBlFlagIn(List<Byte> values) {
            addCriterion("RETN_BL_FLAG in", values, "retnBlFlag");
            return (Criteria) this;
        }

        public Criteria andRetnBlFlagNotIn(List<Byte> values) {
            addCriterion("RETN_BL_FLAG not in", values, "retnBlFlag");
            return (Criteria) this;
        }

        public Criteria andRetnBlFlagBetween(Byte value1, Byte value2) {
            addCriterion("RETN_BL_FLAG between", value1, value2, "retnBlFlag");
            return (Criteria) this;
        }

        public Criteria andRetnBlFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("RETN_BL_FLAG not between", value1, value2, "retnBlFlag");
            return (Criteria) this;
        }

        public Criteria andUrgfrmFlagIsNull() {
            addCriterion("URGFRM_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andUrgfrmFlagIsNotNull() {
            addCriterion("URGFRM_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andUrgfrmFlagEqualTo(Byte value) {
            addCriterion("URGFRM_FLAG =", value, "urgfrmFlag");
            return (Criteria) this;
        }

        public Criteria andUrgfrmFlagNotEqualTo(Byte value) {
            addCriterion("URGFRM_FLAG <>", value, "urgfrmFlag");
            return (Criteria) this;
        }

        public Criteria andUrgfrmFlagGreaterThan(Byte value) {
            addCriterion("URGFRM_FLAG >", value, "urgfrmFlag");
            return (Criteria) this;
        }

        public Criteria andUrgfrmFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("URGFRM_FLAG >=", value, "urgfrmFlag");
            return (Criteria) this;
        }

        public Criteria andUrgfrmFlagLessThan(Byte value) {
            addCriterion("URGFRM_FLAG <", value, "urgfrmFlag");
            return (Criteria) this;
        }

        public Criteria andUrgfrmFlagLessThanOrEqualTo(Byte value) {
            addCriterion("URGFRM_FLAG <=", value, "urgfrmFlag");
            return (Criteria) this;
        }

        public Criteria andUrgfrmFlagIn(List<Byte> values) {
            addCriterion("URGFRM_FLAG in", values, "urgfrmFlag");
            return (Criteria) this;
        }

        public Criteria andUrgfrmFlagNotIn(List<Byte> values) {
            addCriterion("URGFRM_FLAG not in", values, "urgfrmFlag");
            return (Criteria) this;
        }

        public Criteria andUrgfrmFlagBetween(Byte value1, Byte value2) {
            addCriterion("URGFRM_FLAG between", value1, value2, "urgfrmFlag");
            return (Criteria) this;
        }

        public Criteria andUrgfrmFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("URGFRM_FLAG not between", value1, value2, "urgfrmFlag");
            return (Criteria) this;
        }

        public Criteria andRespDeptIdIsNull() {
            addCriterion("RESP_DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andRespDeptIdIsNotNull() {
            addCriterion("RESP_DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRespDeptIdEqualTo(String value) {
            addCriterion("RESP_DEPT_ID =", value, "respDeptId");
            return (Criteria) this;
        }

        public Criteria andRespDeptIdNotEqualTo(String value) {
            addCriterion("RESP_DEPT_ID <>", value, "respDeptId");
            return (Criteria) this;
        }

        public Criteria andRespDeptIdGreaterThan(String value) {
            addCriterion("RESP_DEPT_ID >", value, "respDeptId");
            return (Criteria) this;
        }

        public Criteria andRespDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("RESP_DEPT_ID >=", value, "respDeptId");
            return (Criteria) this;
        }

        public Criteria andRespDeptIdLessThan(String value) {
            addCriterion("RESP_DEPT_ID <", value, "respDeptId");
            return (Criteria) this;
        }

        public Criteria andRespDeptIdLessThanOrEqualTo(String value) {
            addCriterion("RESP_DEPT_ID <=", value, "respDeptId");
            return (Criteria) this;
        }

        public Criteria andRespDeptIdLike(String value) {
            addCriterion("RESP_DEPT_ID like", value, "respDeptId");
            return (Criteria) this;
        }

        public Criteria andRespDeptIdNotLike(String value) {
            addCriterion("RESP_DEPT_ID not like", value, "respDeptId");
            return (Criteria) this;
        }

        public Criteria andRespDeptIdIn(List<String> values) {
            addCriterion("RESP_DEPT_ID in", values, "respDeptId");
            return (Criteria) this;
        }

        public Criteria andRespDeptIdNotIn(List<String> values) {
            addCriterion("RESP_DEPT_ID not in", values, "respDeptId");
            return (Criteria) this;
        }

        public Criteria andRespDeptIdBetween(String value1, String value2) {
            addCriterion("RESP_DEPT_ID between", value1, value2, "respDeptId");
            return (Criteria) this;
        }

        public Criteria andRespDeptIdNotBetween(String value1, String value2) {
            addCriterion("RESP_DEPT_ID not between", value1, value2, "respDeptId");
            return (Criteria) this;
        }

        public Criteria andRespRsnDescIsNull() {
            addCriterion("RESP_RSN_DESC is null");
            return (Criteria) this;
        }

        public Criteria andRespRsnDescIsNotNull() {
            addCriterion("RESP_RSN_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andRespRsnDescEqualTo(String value) {
            addCriterion("RESP_RSN_DESC =", value, "respRsnDesc");
            return (Criteria) this;
        }

        public Criteria andRespRsnDescNotEqualTo(String value) {
            addCriterion("RESP_RSN_DESC <>", value, "respRsnDesc");
            return (Criteria) this;
        }

        public Criteria andRespRsnDescGreaterThan(String value) {
            addCriterion("RESP_RSN_DESC >", value, "respRsnDesc");
            return (Criteria) this;
        }

        public Criteria andRespRsnDescGreaterThanOrEqualTo(String value) {
            addCriterion("RESP_RSN_DESC >=", value, "respRsnDesc");
            return (Criteria) this;
        }

        public Criteria andRespRsnDescLessThan(String value) {
            addCriterion("RESP_RSN_DESC <", value, "respRsnDesc");
            return (Criteria) this;
        }

        public Criteria andRespRsnDescLessThanOrEqualTo(String value) {
            addCriterion("RESP_RSN_DESC <=", value, "respRsnDesc");
            return (Criteria) this;
        }

        public Criteria andRespRsnDescLike(String value) {
            addCriterion("RESP_RSN_DESC like", value, "respRsnDesc");
            return (Criteria) this;
        }

        public Criteria andRespRsnDescNotLike(String value) {
            addCriterion("RESP_RSN_DESC not like", value, "respRsnDesc");
            return (Criteria) this;
        }

        public Criteria andRespRsnDescIn(List<String> values) {
            addCriterion("RESP_RSN_DESC in", values, "respRsnDesc");
            return (Criteria) this;
        }

        public Criteria andRespRsnDescNotIn(List<String> values) {
            addCriterion("RESP_RSN_DESC not in", values, "respRsnDesc");
            return (Criteria) this;
        }

        public Criteria andRespRsnDescBetween(String value1, String value2) {
            addCriterion("RESP_RSN_DESC between", value1, value2, "respRsnDesc");
            return (Criteria) this;
        }

        public Criteria andRespRsnDescNotBetween(String value1, String value2) {
            addCriterion("RESP_RSN_DESC not between", value1, value2, "respRsnDesc");
            return (Criteria) this;
        }

        public Criteria andHandleDurationIsNull() {
            addCriterion("HANDLE_DURATION is null");
            return (Criteria) this;
        }

        public Criteria andHandleDurationIsNotNull() {
            addCriterion("HANDLE_DURATION is not null");
            return (Criteria) this;
        }

        public Criteria andHandleDurationEqualTo(Integer value) {
            addCriterion("HANDLE_DURATION =", value, "handleDuration");
            return (Criteria) this;
        }

        public Criteria andHandleDurationNotEqualTo(Integer value) {
            addCriterion("HANDLE_DURATION <>", value, "handleDuration");
            return (Criteria) this;
        }

        public Criteria andHandleDurationGreaterThan(Integer value) {
            addCriterion("HANDLE_DURATION >", value, "handleDuration");
            return (Criteria) this;
        }

        public Criteria andHandleDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("HANDLE_DURATION >=", value, "handleDuration");
            return (Criteria) this;
        }

        public Criteria andHandleDurationLessThan(Integer value) {
            addCriterion("HANDLE_DURATION <", value, "handleDuration");
            return (Criteria) this;
        }

        public Criteria andHandleDurationLessThanOrEqualTo(Integer value) {
            addCriterion("HANDLE_DURATION <=", value, "handleDuration");
            return (Criteria) this;
        }

        public Criteria andHandleDurationIn(List<Integer> values) {
            addCriterion("HANDLE_DURATION in", values, "handleDuration");
            return (Criteria) this;
        }

        public Criteria andHandleDurationNotIn(List<Integer> values) {
            addCriterion("HANDLE_DURATION not in", values, "handleDuration");
            return (Criteria) this;
        }

        public Criteria andHandleDurationBetween(Integer value1, Integer value2) {
            addCriterion("HANDLE_DURATION between", value1, value2, "handleDuration");
            return (Criteria) this;
        }

        public Criteria andHandleDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("HANDLE_DURATION not between", value1, value2, "handleDuration");
            return (Criteria) this;
        }

        public Criteria andActualHandleDurationIsNull() {
            addCriterion("ACTUAL_HANDLE_DURATION is null");
            return (Criteria) this;
        }

        public Criteria andActualHandleDurationIsNotNull() {
            addCriterion("ACTUAL_HANDLE_DURATION is not null");
            return (Criteria) this;
        }

        public Criteria andActualHandleDurationEqualTo(Integer value) {
            addCriterion("ACTUAL_HANDLE_DURATION =", value, "actualHandleDuration");
            return (Criteria) this;
        }

        public Criteria andActualHandleDurationNotEqualTo(Integer value) {
            addCriterion("ACTUAL_HANDLE_DURATION <>", value, "actualHandleDuration");
            return (Criteria) this;
        }

        public Criteria andActualHandleDurationGreaterThan(Integer value) {
            addCriterion("ACTUAL_HANDLE_DURATION >", value, "actualHandleDuration");
            return (Criteria) this;
        }

        public Criteria andActualHandleDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACTUAL_HANDLE_DURATION >=", value, "actualHandleDuration");
            return (Criteria) this;
        }

        public Criteria andActualHandleDurationLessThan(Integer value) {
            addCriterion("ACTUAL_HANDLE_DURATION <", value, "actualHandleDuration");
            return (Criteria) this;
        }

        public Criteria andActualHandleDurationLessThanOrEqualTo(Integer value) {
            addCriterion("ACTUAL_HANDLE_DURATION <=", value, "actualHandleDuration");
            return (Criteria) this;
        }

        public Criteria andActualHandleDurationIn(List<Integer> values) {
            addCriterion("ACTUAL_HANDLE_DURATION in", values, "actualHandleDuration");
            return (Criteria) this;
        }

        public Criteria andActualHandleDurationNotIn(List<Integer> values) {
            addCriterion("ACTUAL_HANDLE_DURATION not in", values, "actualHandleDuration");
            return (Criteria) this;
        }

        public Criteria andActualHandleDurationBetween(Integer value1, Integer value2) {
            addCriterion("ACTUAL_HANDLE_DURATION between", value1, value2, "actualHandleDuration");
            return (Criteria) this;
        }

        public Criteria andActualHandleDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("ACTUAL_HANDLE_DURATION not between", value1, value2, "actualHandleDuration");
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

        public Criteria andBizCnttIsNull() {
            addCriterion("BIZ_CNTT is null");
            return (Criteria) this;
        }

        public Criteria andBizCnttIsNotNull() {
            addCriterion("BIZ_CNTT is not null");
            return (Criteria) this;
        }

        public Criteria andBizCnttEqualTo(String value) {
            addCriterion("BIZ_CNTT =", value, "bizCntt");
            return (Criteria) this;
        }

        public Criteria andBizCnttNotEqualTo(String value) {
            addCriterion("BIZ_CNTT <>", value, "bizCntt");
            return (Criteria) this;
        }

        public Criteria andBizCnttGreaterThan(String value) {
            addCriterion("BIZ_CNTT >", value, "bizCntt");
            return (Criteria) this;
        }

        public Criteria andBizCnttGreaterThanOrEqualTo(String value) {
            addCriterion("BIZ_CNTT >=", value, "bizCntt");
            return (Criteria) this;
        }

        public Criteria andBizCnttLessThan(String value) {
            addCriterion("BIZ_CNTT <", value, "bizCntt");
            return (Criteria) this;
        }

        public Criteria andBizCnttLessThanOrEqualTo(String value) {
            addCriterion("BIZ_CNTT <=", value, "bizCntt");
            return (Criteria) this;
        }

        public Criteria andBizCnttLike(String value) {
            addCriterion("BIZ_CNTT like", value, "bizCntt");
            return (Criteria) this;
        }

        public Criteria andBizCnttNotLike(String value) {
            addCriterion("BIZ_CNTT not like", value, "bizCntt");
            return (Criteria) this;
        }

        public Criteria andBizCnttIn(List<String> values) {
            addCriterion("BIZ_CNTT in", values, "bizCntt");
            return (Criteria) this;
        }

        public Criteria andBizCnttNotIn(List<String> values) {
            addCriterion("BIZ_CNTT not in", values, "bizCntt");
            return (Criteria) this;
        }

        public Criteria andBizCnttBetween(String value1, String value2) {
            addCriterion("BIZ_CNTT between", value1, value2, "bizCntt");
            return (Criteria) this;
        }

        public Criteria andBizCnttNotBetween(String value1, String value2) {
            addCriterion("BIZ_CNTT not between", value1, value2, "bizCntt");
            return (Criteria) this;
        }

        public Criteria andBizTitleIsNull() {
            addCriterion("BIZ_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andBizTitleIsNotNull() {
            addCriterion("BIZ_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andBizTitleEqualTo(String value) {
            addCriterion("BIZ_TITLE =", value, "bizTitle");
            return (Criteria) this;
        }

        public Criteria andBizTitleNotEqualTo(String value) {
            addCriterion("BIZ_TITLE <>", value, "bizTitle");
            return (Criteria) this;
        }

        public Criteria andBizTitleGreaterThan(String value) {
            addCriterion("BIZ_TITLE >", value, "bizTitle");
            return (Criteria) this;
        }

        public Criteria andBizTitleGreaterThanOrEqualTo(String value) {
            addCriterion("BIZ_TITLE >=", value, "bizTitle");
            return (Criteria) this;
        }

        public Criteria andBizTitleLessThan(String value) {
            addCriterion("BIZ_TITLE <", value, "bizTitle");
            return (Criteria) this;
        }

        public Criteria andBizTitleLessThanOrEqualTo(String value) {
            addCriterion("BIZ_TITLE <=", value, "bizTitle");
            return (Criteria) this;
        }

        public Criteria andBizTitleLike(String value) {
            addCriterion("BIZ_TITLE like", value, "bizTitle");
            return (Criteria) this;
        }

        public Criteria andBizTitleNotLike(String value) {
            addCriterion("BIZ_TITLE not like", value, "bizTitle");
            return (Criteria) this;
        }

        public Criteria andBizTitleIn(List<String> values) {
            addCriterion("BIZ_TITLE in", values, "bizTitle");
            return (Criteria) this;
        }

        public Criteria andBizTitleNotIn(List<String> values) {
            addCriterion("BIZ_TITLE not in", values, "bizTitle");
            return (Criteria) this;
        }

        public Criteria andBizTitleBetween(String value1, String value2) {
            addCriterion("BIZ_TITLE between", value1, value2, "bizTitle");
            return (Criteria) this;
        }

        public Criteria andBizTitleNotBetween(String value1, String value2) {
            addCriterion("BIZ_TITLE not between", value1, value2, "bizTitle");
            return (Criteria) this;
        }

        public Criteria andCustEmailIsNull() {
            addCriterion("CUST_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andCustEmailIsNotNull() {
            addCriterion("CUST_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andCustEmailEqualTo(String value) {
            addCriterion("CUST_EMAIL =", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotEqualTo(String value) {
            addCriterion("CUST_EMAIL <>", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailGreaterThan(String value) {
            addCriterion("CUST_EMAIL >", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_EMAIL >=", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLessThan(String value) {
            addCriterion("CUST_EMAIL <", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLessThanOrEqualTo(String value) {
            addCriterion("CUST_EMAIL <=", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLike(String value) {
            addCriterion("CUST_EMAIL like", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotLike(String value) {
            addCriterion("CUST_EMAIL not like", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailIn(List<String> values) {
            addCriterion("CUST_EMAIL in", values, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotIn(List<String> values) {
            addCriterion("CUST_EMAIL not in", values, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailBetween(String value1, String value2) {
            addCriterion("CUST_EMAIL between", value1, value2, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotBetween(String value1, String value2) {
            addCriterion("CUST_EMAIL not between", value1, value2, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("CUST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("CUST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("CUST_NAME =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("CUST_NAME <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("CUST_NAME >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_NAME >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("CUST_NAME <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("CUST_NAME <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("CUST_NAME like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("CUST_NAME not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("CUST_NAME in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("CUST_NAME not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("CUST_NAME between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("CUST_NAME not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNumIsNull() {
            addCriterion("CUST_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCustNumIsNotNull() {
            addCriterion("CUST_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCustNumEqualTo(String value) {
            addCriterion("CUST_NUM =", value, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumNotEqualTo(String value) {
            addCriterion("CUST_NUM <>", value, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumGreaterThan(String value) {
            addCriterion("CUST_NUM >", value, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_NUM >=", value, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumLessThan(String value) {
            addCriterion("CUST_NUM <", value, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumLessThanOrEqualTo(String value) {
            addCriterion("CUST_NUM <=", value, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumLike(String value) {
            addCriterion("CUST_NUM like", value, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumNotLike(String value) {
            addCriterion("CUST_NUM not like", value, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumIn(List<String> values) {
            addCriterion("CUST_NUM in", values, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumNotIn(List<String> values) {
            addCriterion("CUST_NUM not in", values, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumBetween(String value1, String value2) {
            addCriterion("CUST_NUM between", value1, value2, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumNotBetween(String value1, String value2) {
            addCriterion("CUST_NUM not between", value1, value2, "custNum");
            return (Criteria) this;
        }

        public Criteria andAcptStaffIdIsNull() {
            addCriterion("ACPT_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andAcptStaffIdIsNotNull() {
            addCriterion("ACPT_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAcptStaffIdEqualTo(String value) {
            addCriterion("ACPT_STAFF_ID =", value, "acptStaffId");
            return (Criteria) this;
        }

        public Criteria andAcptStaffIdNotEqualTo(String value) {
            addCriterion("ACPT_STAFF_ID <>", value, "acptStaffId");
            return (Criteria) this;
        }

        public Criteria andAcptStaffIdGreaterThan(String value) {
            addCriterion("ACPT_STAFF_ID >", value, "acptStaffId");
            return (Criteria) this;
        }

        public Criteria andAcptStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("ACPT_STAFF_ID >=", value, "acptStaffId");
            return (Criteria) this;
        }

        public Criteria andAcptStaffIdLessThan(String value) {
            addCriterion("ACPT_STAFF_ID <", value, "acptStaffId");
            return (Criteria) this;
        }

        public Criteria andAcptStaffIdLessThanOrEqualTo(String value) {
            addCriterion("ACPT_STAFF_ID <=", value, "acptStaffId");
            return (Criteria) this;
        }

        public Criteria andAcptStaffIdLike(String value) {
            addCriterion("ACPT_STAFF_ID like", value, "acptStaffId");
            return (Criteria) this;
        }

        public Criteria andAcptStaffIdNotLike(String value) {
            addCriterion("ACPT_STAFF_ID not like", value, "acptStaffId");
            return (Criteria) this;
        }

        public Criteria andAcptStaffIdIn(List<String> values) {
            addCriterion("ACPT_STAFF_ID in", values, "acptStaffId");
            return (Criteria) this;
        }

        public Criteria andAcptStaffIdNotIn(List<String> values) {
            addCriterion("ACPT_STAFF_ID not in", values, "acptStaffId");
            return (Criteria) this;
        }

        public Criteria andAcptStaffIdBetween(String value1, String value2) {
            addCriterion("ACPT_STAFF_ID between", value1, value2, "acptStaffId");
            return (Criteria) this;
        }

        public Criteria andAcptStaffIdNotBetween(String value1, String value2) {
            addCriterion("ACPT_STAFF_ID not between", value1, value2, "acptStaffId");
            return (Criteria) this;
        }

        public Criteria andAcptStaffNumIsNull() {
            addCriterion("ACPT_STAFF_NUM is null");
            return (Criteria) this;
        }

        public Criteria andAcptStaffNumIsNotNull() {
            addCriterion("ACPT_STAFF_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andAcptStaffNumEqualTo(String value) {
            addCriterion("ACPT_STAFF_NUM =", value, "acptStaffNum");
            return (Criteria) this;
        }

        public Criteria andAcptStaffNumNotEqualTo(String value) {
            addCriterion("ACPT_STAFF_NUM <>", value, "acptStaffNum");
            return (Criteria) this;
        }

        public Criteria andAcptStaffNumGreaterThan(String value) {
            addCriterion("ACPT_STAFF_NUM >", value, "acptStaffNum");
            return (Criteria) this;
        }

        public Criteria andAcptStaffNumGreaterThanOrEqualTo(String value) {
            addCriterion("ACPT_STAFF_NUM >=", value, "acptStaffNum");
            return (Criteria) this;
        }

        public Criteria andAcptStaffNumLessThan(String value) {
            addCriterion("ACPT_STAFF_NUM <", value, "acptStaffNum");
            return (Criteria) this;
        }

        public Criteria andAcptStaffNumLessThanOrEqualTo(String value) {
            addCriterion("ACPT_STAFF_NUM <=", value, "acptStaffNum");
            return (Criteria) this;
        }

        public Criteria andAcptStaffNumLike(String value) {
            addCriterion("ACPT_STAFF_NUM like", value, "acptStaffNum");
            return (Criteria) this;
        }

        public Criteria andAcptStaffNumNotLike(String value) {
            addCriterion("ACPT_STAFF_NUM not like", value, "acptStaffNum");
            return (Criteria) this;
        }

        public Criteria andAcptStaffNumIn(List<String> values) {
            addCriterion("ACPT_STAFF_NUM in", values, "acptStaffNum");
            return (Criteria) this;
        }

        public Criteria andAcptStaffNumNotIn(List<String> values) {
            addCriterion("ACPT_STAFF_NUM not in", values, "acptStaffNum");
            return (Criteria) this;
        }

        public Criteria andAcptStaffNumBetween(String value1, String value2) {
            addCriterion("ACPT_STAFF_NUM between", value1, value2, "acptStaffNum");
            return (Criteria) this;
        }

        public Criteria andAcptStaffNumNotBetween(String value1, String value2) {
            addCriterion("ACPT_STAFF_NUM not between", value1, value2, "acptStaffNum");
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