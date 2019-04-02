package com.asiainfo.qm.execution.domain;

import java.util.Date;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-03-21 15:18
 * @ Description：${description}
 */
public class QmVoiceRecord {
    private String touchId;

    private String tenantId;

    private String provinceId;

    private String cityId;

    private String staffId;

    private String departId;

    private String staffName;

    private String departName;

    private String touchBeginTime;

    private String touchEndTime;

    private Date beginTime;

    private Date endTime;

    private String callType;

    private Integer ivrDuration;

    private Integer alertDuration;

    private Integer queueDuration;

    private Integer talkDuration;

    private Integer acwDuration;

    private String endType;

    private String staffNumber;

    private String customerNumber;

    private String recordPath;

    private String satisfyExtent;

    private String disconReason;

    private String callReason;

    private String notOneSlt;

    private String businessType;

    private String templateId;

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

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName == null ? null : departName.trim();
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

    public Integer getIvrDuration() {
        return ivrDuration;
    }

    public void setIvrDuration(Integer ivrDuration) {
        this.ivrDuration = ivrDuration;
    }

    public Integer getAlertDuration() {
        return alertDuration;
    }

    public void setAlertDuration(Integer alertDuration) {
        this.alertDuration = alertDuration;
    }

    public Integer getQueueDuration() {
        return queueDuration;
    }

    public void setQueueDuration(Integer queueDuration) {
        this.queueDuration = queueDuration;
    }

    public Integer getTalkDuration() {
        return talkDuration;
    }

    public void setTalkDuration(Integer talkDuration) {
        this.talkDuration = talkDuration;
    }

    public Integer getAcwDuration() {
        return acwDuration;
    }

    public void setAcwDuration(Integer acwDuration) {
        this.acwDuration = acwDuration;
    }

    public String getEndType() {
        return endType;
    }

    public void setEndType(String endType) {
        this.endType = endType == null ? null : endType.trim();
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber == null ? null : staffNumber.trim();
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber == null ? null : customerNumber.trim();
    }

    public String getRecordPath() {
        return recordPath;
    }

    public void setRecordPath(String recordPath) {
        this.recordPath = recordPath == null ? null : recordPath.trim();
    }

    public String getSatisfyExtent() {
        return satisfyExtent;
    }

    public void setSatisfyExtent(String satisfyExtent) {
        this.satisfyExtent = satisfyExtent == null ? null : satisfyExtent.trim();
    }

    public String getDisconReason() {
        return disconReason;
    }

    public void setDisconReason(String disconReason) {
        this.disconReason = disconReason == null ? null : disconReason.trim();
    }

    public String getCallReason() {
        return callReason;
    }

    public void setCallReason(String callReason) {
        this.callReason = callReason == null ? null : callReason.trim();
    }

    public String getNotOneSlt() {
        return notOneSlt;
    }

    public void setNotOneSlt(String notOneSlt) {
        this.notOneSlt = notOneSlt == null ? null : notOneSlt.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTouchBeginTime() {
        return touchBeginTime;
    }

    public void setTouchBeginTime(String touchBeginTime) {
        this.touchBeginTime = touchBeginTime;
    }

    public String getTouchEndTime() {
        return touchEndTime;
    }

    public void setTouchEndTime(String touchEndTime) {
        this.touchEndTime = touchEndTime;
    }
}
