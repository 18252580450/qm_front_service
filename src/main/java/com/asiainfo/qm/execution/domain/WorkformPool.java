package com.asiainfo.qm.execution.domain;

import com.asiainfo.qm.manage.domain.QmPlan;

import java.util.Date;

public class WorkformPool extends WorkformPoolKey {
    private String tenantId;

    private String planName;

    private QmPlan qmPlan;

    private String workFormId;

    private String provinceId;

    private Integer handleDuration;

    private Integer actualHandleDuration;

    private Integer poolStatus;

    private String operateStaffId;

    private Date operateTime;

    private String staffId;

    private String departId;

    private Date beginTime;

    private Date endTime;

    private String customerCity;

    private String customerLevel;

    private String businessType;

    private String customerBrand;

    private String checkStaffName;

    private String templateId;

    private String projectType;

    private String marketingResult;

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

    private String wrkfmShowSwftno;

    private String bizCntt;

    private String bizTitle;

    private String custEmail;

    private String custName;

    private String custNum;

    private Date arcTime;

    private String acptStaffId;

    private String acptStaffNum;

    private String dspsComplteStaffId;

    private String isOperate;

    private String checkStaffId;

    private String checkedStaffId;

    private String checkedStaffName;

    private String cityId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public void setWorkFormId(String workFormId) {
        this.workFormId = workFormId == null ? null : workFormId.trim();
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
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

    public Integer getPoolStatus() {
        return poolStatus;
    }

    public void setPoolStatus(Integer poolStatus) {
        this.poolStatus = poolStatus;
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

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getCustomerBrand() {
        return customerBrand;
    }

    public void setCustomerBrand(String customerBrand) {
        this.customerBrand = customerBrand == null ? null : customerBrand.trim();
    }

    public String getCheckStaffName() {
        return checkStaffName;
    }

    public void setCheckStaffName(String checkStaffName) {
        this.checkStaffName = checkStaffName == null ? null : checkStaffName.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
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

    public String getWrkfmShowSwftno() {
        return wrkfmShowSwftno;
    }

    public void setWrkfmShowSwftno(String wrkfmShowSwftno) {
        this.wrkfmShowSwftno = wrkfmShowSwftno == null ? null : wrkfmShowSwftno.trim();
    }

    public String getBizCntt() {
        return bizCntt;
    }

    public void setBizCntt(String bizCntt) {
        this.bizCntt = bizCntt == null ? null : bizCntt.trim();
    }

    public String getBizTitle() {
        return bizTitle;
    }

    public void setBizTitle(String bizTitle) {
        this.bizTitle = bizTitle == null ? null : bizTitle.trim();
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail == null ? null : custEmail.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustNum() {
        return custNum;
    }

    public void setCustNum(String custNum) {
        this.custNum = custNum == null ? null : custNum.trim();
    }

    public Date getArcTime() {
        return arcTime;
    }

    public void setArcTime(Date arcTime) {
        this.arcTime = arcTime;
    }

    public String getAcptStaffId() {
        return acptStaffId;
    }

    public void setAcptStaffId(String acptStaffId) {
        this.acptStaffId = acptStaffId == null ? null : acptStaffId.trim();
    }

    public String getAcptStaffNum() {
        return acptStaffNum;
    }

    public void setAcptStaffNum(String acptStaffNum) {
        this.acptStaffNum = acptStaffNum == null ? null : acptStaffNum.trim();
    }

    public String getDspsComplteStaffId() {
        return dspsComplteStaffId;
    }

    public void setDspsComplteStaffId(String dspsComplteStaffId) {
        this.dspsComplteStaffId = dspsComplteStaffId == null ? null : dspsComplteStaffId.trim();
    }

    public String getIsOperate() {
        return isOperate;
    }

    public void setIsOperate(String isOperate) {
        this.isOperate = isOperate == null ? null : isOperate.trim();
    }

    public String getCheckStaffId() {
        return checkStaffId;
    }

    public void setCheckStaffId(String checkStaffId) {
        this.checkStaffId = checkStaffId == null ? null : checkStaffId.trim();
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

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }
}