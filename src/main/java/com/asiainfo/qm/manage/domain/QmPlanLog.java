package com.asiainfo.qm.manage.domain;

import java.util.Date;

public class QmPlanLog {
    private String operateId;

    private String provinceId;

    private String planId;

    private String operateType;

    private String operateStaffId;

    private Date operateTime;

    public String getOperateId() {
        return operateId;
    }

    public void setOperateId(String operateId) {
        this.operateId = operateId == null ? null : operateId.trim();
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
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
}