package com.asiainfo.qm.manage.domain;

public class StaticParamsKey {
    private String paramsTypeId;

    private String paramsCode;

    private String paramsPurposeId;

    public String getParamsTypeId() {
        return paramsTypeId;
    }

    public void setParamsTypeId(String paramsTypeId) {
        this.paramsTypeId = paramsTypeId == null ? null : paramsTypeId.trim();
    }

    public String getParamsCode() {
        return paramsCode;
    }

    public void setParamsCode(String paramsCode) {
        this.paramsCode = paramsCode == null ? null : paramsCode.trim();
    }

    public String getParamsPurposeId() {
        return paramsPurposeId;
    }

    public void setParamsPurposeId(String paramsPurposeId) {
        this.paramsPurposeId = paramsPurposeId == null ? null : paramsPurposeId.trim();
    }
}