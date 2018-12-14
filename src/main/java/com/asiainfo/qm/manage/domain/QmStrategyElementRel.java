package com.asiainfo.qm.manage.domain;

public class QmStrategyElementRel extends QmStrategyElementRelKey {
    private String tenantId;

    private String provinceId;

    private String cityId;

    private String elementValue1;

    private String elementValue2;

    private String paramsTypeId;

    private String paramsTypeName;

    private String elementCode;

    private String elementName;

    private String elementType;

    private String isValidate;

    private String isRegion;

    private String isNeed;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private String reserve4;

    private String reserve5;

    public String getParamsTypeId() {
        return paramsTypeId;
    }

    public void setParamsTypeId(String paramsTypeId) {
        this.paramsTypeId = paramsTypeId;
    }

    public String getParamsTypeName() {
        return paramsTypeName;
    }

    public void setParamsTypeName(String paramsTypeName) {
        this.paramsTypeName = paramsTypeName;
    }

    public String getElementCode() {
        return elementCode;
    }

    public void setElementCode(String elementCode) {
        this.elementCode = elementCode;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getIsValidate() {
        return isValidate;
    }

    public void setIsValidate(String isValidate) {
        this.isValidate = isValidate;
    }

    public String getIsRegion() {
        return isRegion;
    }

    public void setIsRegion(String isRegion) {
        this.isRegion = isRegion;
    }

    public String getIsNeed() {
        return isNeed;
    }

    public void setIsNeed(String isNeed) {
        this.isNeed = isNeed;
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

    public String getElementValue1() {
        return elementValue1;
    }

    public void setElementValue1(String elementValue1) {
        this.elementValue1 = elementValue1 == null ? null : elementValue1.trim();
    }

    public String getElementValue2() {
        return elementValue2;
    }

    public void setElementValue2(String elementValue2) {
        this.elementValue2 = elementValue2 == null ? null : elementValue2.trim();
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