package com.asiainfo.qm.task.domain;

public class QmBindRln {
    private String planId;

    private String checkStaffId;

    private String checkedObjectId;

    private String userType;

    private String checkStaffName;

    private String checkedDepartName;

    private String checkedObjectName;

    public String getCheckStaffName() {
        return checkStaffName;
    }

    public void setCheckStaffName(String checkStaffName) {
        this.checkStaffName = checkStaffName;
    }

    public String getCheckedDepartName() {
        return checkedDepartName;
    }

    public void setCheckedDepartName(String checkedDepartName) {
        this.checkedDepartName = checkedDepartName;
    }

    public String getCheckedObjectName() {
        return checkedObjectName;
    }

    public void setCheckedObjectName(String checkedObjectName) {
        this.checkedObjectName = checkedObjectName;
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

    public String getCheckedObjectId() {
        return checkedObjectId;
    }

    public void setCheckedObjectId(String checkedObjectId) {
        this.checkedObjectId = checkedObjectId == null ? null : checkedObjectId.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }
}