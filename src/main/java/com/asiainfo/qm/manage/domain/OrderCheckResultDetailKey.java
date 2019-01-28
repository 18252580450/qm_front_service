package com.asiainfo.qm.manage.domain;

public class OrderCheckResultDetailKey {
    private String inspectionId;

    private String checkLink;

    private String nodeId;

    public String getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(String inspectionId) {
        this.inspectionId = inspectionId == null ? null : inspectionId.trim();
    }

    public String getCheckLink() {
        return checkLink;
    }

    public void setCheckLink(String checkLink) {
        this.checkLink = checkLink == null ? null : checkLink.trim();
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }
}