package com.asiainfo.qm.task.domain;

public class QmBindRln extends QmBindRlnKey {
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }
}