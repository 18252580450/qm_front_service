package com.asiainfo.qm.manage.domain;

import java.util.Date;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-03-08 11:04
 * @ Description：${description}
 */
public class AppealProcessDetail {
    private String processId;

    private String tenantId;

    private String provinceId;

    private String processName;

    private String parentProcessId;

    private String mainProcessFlag;

    private String departmentId;

    private String departmentName;

    private String createStaffId;

    private Date createTime;

    private String checkType;

    private String processValidFlag;

    private String processStatus;

    private String processUseStatus;

    private Integer orderNo;

    private Integer maxAppealNum;

    private String nodeId;

    private String nodeName;

    private String userId;

    private String userName;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
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

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    public String getParentProcessId() {
        return parentProcessId;
    }

    public void setParentProcessId(String parentProcessId) {
        this.parentProcessId = parentProcessId == null ? null : parentProcessId.trim();
    }

    public String getMainProcessFlag() {
        return mainProcessFlag;
    }

    public void setMainProcessFlag(String mainProcessFlag) {
        this.mainProcessFlag = mainProcessFlag == null ? null : mainProcessFlag.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getCreateStaffId() {
        return createStaffId;
    }

    public void setCreateStaffId(String createStaffId) {
        this.createStaffId = createStaffId == null ? null : createStaffId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType == null ? null : checkType.trim();
    }

    public String getProcessValidFlag() {
        return processValidFlag;
    }

    public void setProcessValidFlag(String processValidFlag) {
        this.processValidFlag = processValidFlag == null ? null : processValidFlag.trim();
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
    }

    public String getProcessUseStatus() {
        return processUseStatus;
    }

    public void setProcessUseStatus(String processUseStatus) {
        this.processUseStatus = processUseStatus == null ? null : processUseStatus.trim();
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getMaxAppealNum() {
        return maxAppealNum;
    }

    public void setMaxAppealNum(Integer maxAppealNum) {
        this.maxAppealNum = maxAppealNum;
    }


    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}
