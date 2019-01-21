package com.asiainfo.qm.manage.domain;

import java.util.Date;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-01-14 11:06
 * @ Description：${description}
 */
public class CheckItemDetail {

    private String nodeId;

    private String nodeType;

    private String templateId;

    private String tenantId;

    private String provinceId;

    private String cityId;

    private String nodeName;

    private String pNodeId;

    private Integer nodeScore;

    private Integer maxScore;

    private Integer minScore;

    private Integer weight;

    private String errorType;

    private String scoreFlag;

    private Date crtTime;

    private Date modfTime;

    private String createStaffId;

    private Integer nodeOrder;

    private String checkItemName;

    private String checkItemType;

    private String checkItemVitalType;

    private String nodeTypeCode;

    private String remark;

    private String scoreType;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType == null ? null : nodeType.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    public String getpNodeId() {
        return pNodeId;
    }

    public void setpNodeId(String pNodeId) {
        this.pNodeId = pNodeId == null ? null : pNodeId.trim();
    }

    public Integer getNodeScore() {
        return nodeScore;
    }

    public void setNodeScore(Integer nodeScore) {
        this.nodeScore = nodeScore;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType == null ? null : errorType.trim();
    }

    public String getScoreFlag() {
        return scoreFlag;
    }

    public void setScoreFlag(String scoreFlag) {
        this.scoreFlag = scoreFlag == null ? null : scoreFlag.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Date getModfTime() {
        return modfTime;
    }

    public void setModfTime(Date modfTime) {
        this.modfTime = modfTime;
    }

    public String getCreateStaffId() {
        return createStaffId;
    }

    public void setCreateStaffId(String createStaffId) {
        this.createStaffId = createStaffId == null ? null : createStaffId.trim();
    }

    public Integer getNodeOrder() {
        return nodeOrder;
    }

    public void setNodeOrder(Integer nodeOrder) {
        this.nodeOrder = nodeOrder;
    }

    public String getCheckItemName() {
        return checkItemName;
    }

    public void setCheckItemName(String checkItemName) {
        this.checkItemName = checkItemName;
    }

    public String getCheckItemType() {
        return checkItemType;
    }

    public void setCheckItemType(String checkItemType) {
        this.checkItemType = checkItemType;
    }

    public String getCheckItemVitalType() {
        return checkItemVitalType;
    }

    public void setCheckItemVitalType(String checkItemVitalType) {
        this.checkItemVitalType = checkItemVitalType;
    }

    public String getNodeTypeCode() {
        return nodeTypeCode;
    }

    public void setNodeTypeCode(String nodeTypeCode) {
        this.nodeTypeCode = nodeTypeCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }
}
