package com.asiainfo.qm.manage.domain;

import java.util.Date;

public class CheckItem {
    private String checkItemId;

    private String provinceId;

    private String tenantId;

    private String cityId;

    private String checkItemName;

    private String parentCheckItemId;

    private Date createTime;

    private String createStaffId;

    private String currentStatus;

    private Date operateTime;

    private String operateStaffId;

    private String scoreType;

    private String checkItemType;

    private String checkItemVitalType;

    private String isOrNoTscore;

    private Integer topLimit;

    private Integer lowLimit;

    private Float topWarn;

    private Float lowWarn;

    private String influenceScope;

    private String catalogFlag;

    private String remark;

    private String requiredFlag;

    private Integer orderNo;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private String reserve4;

    private String reserve5;

    public String getCheckItemId() {
        return checkItemId;
    }

    public void setCheckItemId(String checkItemId) {
        this.checkItemId = checkItemId == null ? null : checkItemId.trim();
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getCheckItemName() {
        return checkItemName;
    }

    public void setCheckItemName(String checkItemName) {
        this.checkItemName = checkItemName == null ? null : checkItemName.trim();
    }

    public String getParentCheckItemId() {
        return parentCheckItemId;
    }

    public void setParentCheckItemId(String parentCheckItemId) {
        this.parentCheckItemId = parentCheckItemId == null ? null : parentCheckItemId.trim();
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

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus == null ? null : currentStatus.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateStaffId() {
        return operateStaffId;
    }

    public void setOperateStaffId(String operateStaffId) {
        this.operateStaffId = operateStaffId == null ? null : operateStaffId.trim();
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType == null ? null : scoreType.trim();
    }

    public String getCheckItemType() {
        return checkItemType;
    }

    public void setCheckItemType(String checkItemType) {
        this.checkItemType = checkItemType == null ? null : checkItemType.trim();
    }

    public String getCheckItemVitalType() {
        return checkItemVitalType;
    }

    public void setCheckItemVitalType(String checkItemVitalType) {
        this.checkItemVitalType = checkItemVitalType == null ? null : checkItemVitalType.trim();
    }

    public String getIsOrNoTscore() {
        return isOrNoTscore;
    }

    public void setIsOrNoTscore(String isOrNoTscore) {
        this.isOrNoTscore = isOrNoTscore == null ? null : isOrNoTscore.trim();
    }

    public Integer getTopLimit() {
        return topLimit;
    }

    public void setTopLimit(Integer topLimit) {
        this.topLimit = topLimit;
    }

    public Integer getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(Integer lowLimit) {
        this.lowLimit = lowLimit;
    }

    public Float getTopWarn() {
        return topWarn;
    }

    public void setTopWarn(Float topWarn) {
        this.topWarn = topWarn;
    }

    public Float getLowWarn() {
        return lowWarn;
    }

    public void setLowWarn(Float lowWarn) {
        this.lowWarn = lowWarn;
    }

    public String getInfluenceScope() {
        return influenceScope;
    }

    public void setInfluenceScope(String influenceScope) {
        this.influenceScope = influenceScope == null ? null : influenceScope.trim();
    }

    public String getCatalogFlag() {
        return catalogFlag;
    }

    public void setCatalogFlag(String catalogFlag) {
        this.catalogFlag = catalogFlag == null ? null : catalogFlag.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRequiredFlag() {
        return requiredFlag;
    }

    public void setRequiredFlag(String requiredFlag) {
        this.requiredFlag = requiredFlag == null ? null : requiredFlag.trim();
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }

    public String getReserve4() {
        return reserve4;
    }

    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4 == null ? null : reserve4.trim();
    }

    public String getReserve5() {
        return reserve5;
    }

    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5 == null ? null : reserve5.trim();
    }
}