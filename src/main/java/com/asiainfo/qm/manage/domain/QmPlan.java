package com.asiainfo.qm.manage.domain;

import java.util.Date;

public class QmPlan {
    private String planId;

    private String tenantId;

    private String provinceId;

    private String planName;

    private Date createTime;

    private String createStaffId;

    private Date modifiedTime;

    private String modifiedStaffId;

    private Date planStarttime;

    private Date planEndtime;

    private Date beginTime;

    private Date endTime;

    private String planType;

    private String templateName;

    private String templateId;

    private Byte recommendFlag;

    private Byte addFlag;

    private String manOrAuto;

    private String bindRelation;

    private String haltFlag;

    private String planStatus;

    private Byte deleteFlag;

    private String remark;

    private Integer planCount;

    private Integer extractCount;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
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

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateStaffId() {
        return createStaffId;
    }

    public void setCreateStaffId(String createStaffId) {
        this.createStaffId = createStaffId == null ? null : createStaffId.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifiedStaffId() {
        return modifiedStaffId;
    }

    public void setModifiedStaffId(String modifiedStaffId) {
        this.modifiedStaffId = modifiedStaffId == null ? null : modifiedStaffId.trim();
    }

    public Date getPlanStarttime() {
        return planStarttime;
    }

    public void setPlanStarttime(Date planStarttime) {
        this.planStarttime = planStarttime;
    }

    public Date getPlanEndtime() {
        return planEndtime;
    }

    public void setPlanEndtime(Date planEndtime) {
        this.planEndtime = planEndtime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType == null ? null : planType.trim();
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public Byte getRecommendFlag() {
        return recommendFlag;
    }

    public void setRecommendFlag(Byte recommendFlag) {
        this.recommendFlag = recommendFlag;
    }

    public Byte getAddFlag() {
        return addFlag;
    }

    public void setAddFlag(Byte addFlag) {
        this.addFlag = addFlag;
    }

    public String getManOrAuto() {
        return manOrAuto;
    }

    public void setManOrAuto(String manOrAuto) {
        this.manOrAuto = manOrAuto == null ? null : manOrAuto.trim();
    }

    public String getBindRelation() {
        return bindRelation;
    }

    public void setBindRelation(String bindRelation) {
        this.bindRelation = bindRelation == null ? null : bindRelation.trim();
    }

    public String getHaltFlag() {
        return haltFlag;
    }

    public void setHaltFlag(String haltFlag) {
        this.haltFlag = haltFlag == null ? null : haltFlag.trim();
    }

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus == null ? null : planStatus.trim();
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getPlanCount() {
        return planCount;
    }

    public void setPlanCount(Integer planCount) {
        this.planCount = planCount;
    }

    public Integer getExtractCount() {
        return extractCount;
    }

    public void setExtractCount(Integer extractCount) {
        this.extractCount = extractCount;
    }
}