package com.asiainfo.qm.task.domain;

public class QmBindRlnKey {
    private String checkedObjectId;

    private String planId;

    private String checkStaffId;

    public String getCheckedObjectId() {
        return checkedObjectId;
    }

    public void setCheckedObjectId(String checkedObjectId) {
        this.checkedObjectId = checkedObjectId == null ? null : checkedObjectId.trim();
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
}