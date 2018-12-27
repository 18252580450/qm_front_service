package com.asiainfo.qm.execution.domain;

public class WorkformPoolKey {
    private Long wrkfmId;

    private String planId;


    public Long getWrkfmId() {
        return wrkfmId;
    }

    public void setWrkfmId(Long wrkfmId) {
        this.wrkfmId = wrkfmId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }
}