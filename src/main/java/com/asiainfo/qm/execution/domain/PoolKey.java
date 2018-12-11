package com.asiainfo.qm.execution.domain;

public class PoolKey {
    private String touchId;

    private String planId;

    public String getTouchId() {
        return touchId;
    }

    public void setTouchId(String touchId) {
        this.touchId = touchId == null ? null : touchId.trim();
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }
}