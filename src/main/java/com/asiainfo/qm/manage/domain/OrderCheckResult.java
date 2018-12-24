package com.asiainfo.qm.manage.domain;

import java.math.BigDecimal;
import java.util.Date;

public class OrderCheckResult extends OrderCheckResultKey {
    private String tenantId;

    private String planName;

    private QmPlan qmPlan;

    private String acceptMonth;

    private String provinceId;

    private String cityId;

    private String callingNumber;

    private String acceptNumber;

    private String customerLevel;

    private String originInspectionId;

    private String planId;

    private String templateId;

    private String checkModel;

    private String checkedStaffId;

    private String checkedStaffName;

    private String checkedDepartId;

    private String checkedDepartName;

    private String checkStaffId;

    private String checkStaffName;

    private String checkDepartId;

    private String checkDepartName;

    private Date checkStartTime;

    private Date checkEndTime;

    private Integer checkTime;

    private Integer playVoiceTime;

    private Integer playVoiceNum;

    private String scoreType;

    private String resultStatus;

    private String lastResultFlag;

    private String errorRank;

    private String busiType;

    private BigDecimal finalScore;

    private String checkComment;

    private String abandonStatus;

    private String abandonReason;

    private String abandonComment;

    private String appealId;

    private Date appealTime;

    private Integer appealNum;

    private Date operateTime;

    private String operateStaffId;

    private String operateReason;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private String reserve4;

    private String reserve5;

    private String reserve6;

    private String reserve7;

    private String reserve8;

    private String reserve9;

    private String reserve10;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public QmPlan getQmPlan() {
        return qmPlan;
    }

    public void setQmPlan(QmPlan qmPlan) {
        this.qmPlan = qmPlan;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public String getAcceptMonth() {
        return acceptMonth;
    }

    public void setAcceptMonth(String acceptMonth) {
        this.acceptMonth = acceptMonth == null ? null : acceptMonth.trim();
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

    public String getCallingNumber() {
        return callingNumber;
    }

    public void setCallingNumber(String callingNumber) {
        this.callingNumber = callingNumber == null ? null : callingNumber.trim();
    }

    public String getAcceptNumber() {
        return acceptNumber;
    }

    public void setAcceptNumber(String acceptNumber) {
        this.acceptNumber = acceptNumber == null ? null : acceptNumber.trim();
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel == null ? null : customerLevel.trim();
    }

    public String getOriginInspectionId() {
        return originInspectionId;
    }

    public void setOriginInspectionId(String originInspectionId) {
        this.originInspectionId = originInspectionId == null ? null : originInspectionId.trim();
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getCheckModel() {
        return checkModel;
    }

    public void setCheckModel(String checkModel) {
        this.checkModel = checkModel == null ? null : checkModel.trim();
    }

    public String getCheckedStaffId() {
        return checkedStaffId;
    }

    public void setCheckedStaffId(String checkedStaffId) {
        this.checkedStaffId = checkedStaffId == null ? null : checkedStaffId.trim();
    }

    public String getCheckedStaffName() {
        return checkedStaffName;
    }

    public void setCheckedStaffName(String checkedStaffName) {
        this.checkedStaffName = checkedStaffName == null ? null : checkedStaffName.trim();
    }

    public String getCheckedDepartId() {
        return checkedDepartId;
    }

    public void setCheckedDepartId(String checkedDepartId) {
        this.checkedDepartId = checkedDepartId == null ? null : checkedDepartId.trim();
    }

    public String getCheckedDepartName() {
        return checkedDepartName;
    }

    public void setCheckedDepartName(String checkedDepartName) {
        this.checkedDepartName = checkedDepartName == null ? null : checkedDepartName.trim();
    }

    public String getCheckStaffId() {
        return checkStaffId;
    }

    public void setCheckStaffId(String checkStaffId) {
        this.checkStaffId = checkStaffId == null ? null : checkStaffId.trim();
    }

    public String getCheckStaffName() {
        return checkStaffName;
    }

    public void setCheckStaffName(String checkStaffName) {
        this.checkStaffName = checkStaffName == null ? null : checkStaffName.trim();
    }

    public String getCheckDepartId() {
        return checkDepartId;
    }

    public void setCheckDepartId(String checkDepartId) {
        this.checkDepartId = checkDepartId == null ? null : checkDepartId.trim();
    }

    public String getCheckDepartName() {
        return checkDepartName;
    }

    public void setCheckDepartName(String checkDepartName) {
        this.checkDepartName = checkDepartName == null ? null : checkDepartName.trim();
    }

    public Date getCheckStartTime() {
        return checkStartTime;
    }

    public void setCheckStartTime(Date checkStartTime) {
        this.checkStartTime = checkStartTime;
    }

    public Date getCheckEndTime() {
        return checkEndTime;
    }

    public void setCheckEndTime(Date checkEndTime) {
        this.checkEndTime = checkEndTime;
    }

    public Integer getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Integer checkTime) {
        this.checkTime = checkTime;
    }

    public Integer getPlayVoiceTime() {
        return playVoiceTime;
    }

    public void setPlayVoiceTime(Integer playVoiceTime) {
        this.playVoiceTime = playVoiceTime;
    }

    public Integer getPlayVoiceNum() {
        return playVoiceNum;
    }

    public void setPlayVoiceNum(Integer playVoiceNum) {
        this.playVoiceNum = playVoiceNum;
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType == null ? null : scoreType.trim();
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus == null ? null : resultStatus.trim();
    }

    public String getLastResultFlag() {
        return lastResultFlag;
    }

    public void setLastResultFlag(String lastResultFlag) {
        this.lastResultFlag = lastResultFlag == null ? null : lastResultFlag.trim();
    }

    public String getErrorRank() {
        return errorRank;
    }

    public void setErrorRank(String errorRank) {
        this.errorRank = errorRank == null ? null : errorRank.trim();
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType == null ? null : busiType.trim();
    }

    public BigDecimal getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(BigDecimal finalScore) {
        this.finalScore = finalScore;
    }

    public String getCheckComment() {
        return checkComment;
    }

    public void setCheckComment(String checkComment) {
        this.checkComment = checkComment == null ? null : checkComment.trim();
    }

    public String getAbandonStatus() {
        return abandonStatus;
    }

    public void setAbandonStatus(String abandonStatus) {
        this.abandonStatus = abandonStatus == null ? null : abandonStatus.trim();
    }

    public String getAbandonReason() {
        return abandonReason;
    }

    public void setAbandonReason(String abandonReason) {
        this.abandonReason = abandonReason == null ? null : abandonReason.trim();
    }

    public String getAbandonComment() {
        return abandonComment;
    }

    public void setAbandonComment(String abandonComment) {
        this.abandonComment = abandonComment == null ? null : abandonComment.trim();
    }

    public String getAppealId() {
        return appealId;
    }

    public void setAppealId(String appealId) {
        this.appealId = appealId == null ? null : appealId.trim();
    }

    public Date getAppealTime() {
        return appealTime;
    }

    public void setAppealTime(Date appealTime) {
        this.appealTime = appealTime;
    }

    public Integer getAppealNum() {
        return appealNum;
    }

    public void setAppealNum(Integer appealNum) {
        this.appealNum = appealNum;
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

    public String getOperateReason() {
        return operateReason;
    }

    public void setOperateReason(String operateReason) {
        this.operateReason = operateReason == null ? null : operateReason.trim();
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

    public String getReserve6() {
        return reserve6;
    }

    public void setReserve6(String reserve6) {
        this.reserve6 = reserve6 == null ? null : reserve6.trim();
    }

    public String getReserve7() {
        return reserve7;
    }

    public void setReserve7(String reserve7) {
        this.reserve7 = reserve7 == null ? null : reserve7.trim();
    }

    public String getReserve8() {
        return reserve8;
    }

    public void setReserve8(String reserve8) {
        this.reserve8 = reserve8 == null ? null : reserve8.trim();
    }

    public String getReserve9() {
        return reserve9;
    }

    public void setReserve9(String reserve9) {
        this.reserve9 = reserve9 == null ? null : reserve9.trim();
    }

    public String getReserve10() {
        return reserve10;
    }

    public void setReserve10(String reserve10) {
        this.reserve10 = reserve10 == null ? null : reserve10.trim();
    }
}