package com.asiainfo.qm.execution.domain;

import com.asiainfo.qm.manage.domain.QmPlan;

import java.util.Date;

public class WorkformPool extends WorkformPoolKey {
    private String tenantId;

    private QmPlan qmPlan;

    private String provinceId;

    private Integer handleDuration;

    private Integer actualHandleDuration;

    private String poolStatus;

    private String operateStaffId;

    private Date operateTime;

    private String staffId;

    private String departId;

    private Date beginTime;

    private Date endTime;

    private String callType;

    private Integer recordTime;

    private String callingNumber;

    private String acceptNumber;

    private String calledNumber;

    private String customerCity;

    private String customerLevel;

    private String hangupSide;

    private String businessType;

    private String workformId;

    private String customerBrand;

    private String checkStaffId;

    private String checkStaffName;

    private String recordPath;

    private String templateId;

    private String satisfyExtent;

    private String discontentReason;

    private String callReason;

    private String taskId;

    private String taskName;

    private String projectType;

    private String marketingResult;

    private String customerName;

    private Byte repeatCalls;

    private Date crtTime;

    private Date modfTime;

    private String srvReqstTypeId;

    private String srvReqstTypeNm;

    private String srvReqstTypeFullNm;

    private String checkLink;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private String reserve4;

    private String reserve5;

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

    public Integer getHandleDuration() {
        return handleDuration;
    }

    public void setHandleDuration(Integer handleDuration) {
        this.handleDuration = handleDuration;
    }

    public Integer getActualHandleDuration() {
        return actualHandleDuration;
    }

    public void setActualHandleDuration(Integer actualHandleDuration) {
        this.actualHandleDuration = actualHandleDuration;
    }

    public String getPoolStatus() {
        return poolStatus;
    }

    public void setPoolStatus(String poolStatus) {
        this.poolStatus = poolStatus == null ? null : poolStatus.trim();
    }

    public String getOperateStaffId() {
        return operateStaffId;
    }

    public void setOperateStaffId(String operateStaffId) {
        this.operateStaffId = operateStaffId == null ? null : operateStaffId.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId == null ? null : departId.trim();
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

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType == null ? null : callType.trim();
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

    public String getAcceptNumber() {
        return acceptNumber;
    }

    public void setAcceptNumber(String acceptNumber) {
        this.acceptNumber = acceptNumber == null ? null : acceptNumber.trim();
    }

    public String getCalledNumber() {
        return calledNumber;
    }

    public void setCalledNumber(String calledNumber) {
        this.calledNumber = calledNumber == null ? null : calledNumber.trim();
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity == null ? null : customerCity.trim();
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel == null ? null : customerLevel.trim();
    }

    public String getHangupSide() {
        return hangupSide;
    }

    public void setHangupSide(String hangupSide) {
        this.hangupSide = hangupSide == null ? null : hangupSide.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getWorkformId() {
        return workformId;
    }

    public void setWorkformId(String workformId) {
        this.workformId = workformId == null ? null : workformId.trim();
    }

    public String getCustomerBrand() {
        return customerBrand;
    }

    public void setCustomerBrand(String customerBrand) {
        this.customerBrand = customerBrand == null ? null : customerBrand.trim();
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

    public String getRecordPath() {
        return recordPath;
    }

    public void setRecordPath(String recordPath) {
        this.recordPath = recordPath == null ? null : recordPath.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getSatisfyExtent() {
        return satisfyExtent;
    }

    public void setSatisfyExtent(String satisfyExtent) {
        this.satisfyExtent = satisfyExtent == null ? null : satisfyExtent.trim();
    }

    public String getDiscontentReason() {
        return discontentReason;
    }

    public void setDiscontentReason(String discontentReason) {
        this.discontentReason = discontentReason == null ? null : discontentReason.trim();
    }

    public String getCallReason() {
        return callReason;
    }

    public void setCallReason(String callReason) {
        this.callReason = callReason == null ? null : callReason.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    public String getMarketingResult() {
        return marketingResult;
    }

    public void setMarketingResult(String marketingResult) {
        this.marketingResult = marketingResult == null ? null : marketingResult.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Byte getRepeatCalls() {
        return repeatCalls;
    }

    public void setRepeatCalls(Byte repeatCalls) {
        this.repeatCalls = repeatCalls;
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

    public String getCheckLink() {
        return checkLink;
    }

    public void setCheckLink(String checkLink) {
        this.checkLink = checkLink == null ? null : checkLink.trim();
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