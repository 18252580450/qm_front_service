package com.asiainfo.qm.execution.domain;

import com.asiainfo.qm.manage.domain.QmPlan;

import java.util.Date;

public class VoicePool {
    private String touchId;

    private String tenantId;

    private QmPlan qmPlan;

    private String provinceId;

    private String inspectionId;

    private String planId;

    private String checkStaffId;

    private String checkStaffName;

    private String checkedStaffId;

    private String checkedStaffName;

    private String isOperate;

    private String hungupType;

    private String callType;

    private String voiceSatisfyExtent;

    private Integer recordTime;

    private String callingNumber;

    private String calledNumber;

    private String satisfyExtentType;

    private String vipSatisfyExtent;

    private String mediaType;

    private String srvReqstTypeId;

    private String srvReqstTypeNm;

    private String srvReqstTypeFullNm;

    private Date checkedTime;

    private Date operateTime;

    private String strategyName;

    private String orgType;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private String reserve4;

    private String reserve5;

    private String reserve6;

    private String reserve7;

    private String reserve8;

    public String getTouchId() {
        return touchId;
    }

    public void setTouchId(String touchId) {
        this.touchId = touchId == null ? null : touchId.trim();
    }

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


    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public String getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(String inspectionId) {
        this.inspectionId = inspectionId == null ? null : inspectionId.trim();
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
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

    public String getIsOperate() {
        return isOperate;
    }

    public void setIsOperate(String isOperate) {
        this.isOperate = isOperate == null ? null : isOperate.trim();
    }

    public String getHungupType() {
        return hungupType;
    }

    public void setHungupType(String hungupType) {
        this.hungupType = hungupType == null ? null : hungupType.trim();
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType == null ? null : callType.trim();
    }

    public String getVoiceSatisfyExtent() {
        return voiceSatisfyExtent;
    }

    public void setVoiceSatisfyExtent(String voiceSatisfyExtent) {
        this.voiceSatisfyExtent = voiceSatisfyExtent == null ? null : voiceSatisfyExtent.trim();
    }

    public Integer getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Integer recordTime) {
        this.recordTime = recordTime;
    }

    public String getCallingNumber() {
        return callingNumber;
    }

    public void setCallingNumber(String callingNumber) {
        this.callingNumber = callingNumber == null ? null : callingNumber.trim();
    }

    public String getCalledNumber() {
        return calledNumber;
    }

    public void setCalledNumber(String calledNumber) {
        this.calledNumber = calledNumber == null ? null : calledNumber.trim();
    }

    public String getSatisfyExtentType() {
        return satisfyExtentType;
    }

    public void setSatisfyExtentType(String satisfyExtentType) {
        this.satisfyExtentType = satisfyExtentType == null ? null : satisfyExtentType.trim();
    }

    public String getVipSatisfyExtent() {
        return vipSatisfyExtent;
    }

    public void setVipSatisfyExtent(String vipSatisfyExtent) {
        this.vipSatisfyExtent = vipSatisfyExtent == null ? null : vipSatisfyExtent.trim();
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType == null ? null : mediaType.trim();
    }

    public String getSrvReqstTypeId() {
        return srvReqstTypeId;
    }

    public void setSrvReqstTypeId(String srvReqstTypeId) {
        this.srvReqstTypeId = srvReqstTypeId == null ? null : srvReqstTypeId.trim();
    }

    public String getSrvReqstTypeNm() {
        return srvReqstTypeNm;
    }

    public void setSrvReqstTypeNm(String srvReqstTypeNm) {
        this.srvReqstTypeNm = srvReqstTypeNm == null ? null : srvReqstTypeNm.trim();
    }

    public String getSrvReqstTypeFullNm() {
        return srvReqstTypeFullNm;
    }

    public void setSrvReqstTypeFullNm(String srvReqstTypeFullNm) {
        this.srvReqstTypeFullNm = srvReqstTypeFullNm == null ? null : srvReqstTypeFullNm.trim();
    }

    public Date getCheckedTime() {
        return checkedTime;
    }

    public void setCheckedTime(Date checkedTime) {
        this.checkedTime = checkedTime;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName == null ? null : strategyName.trim();
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
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
}