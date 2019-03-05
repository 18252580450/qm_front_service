package com.asiainfo.qm.task.domain;

import java.util.Date;

public class QmWorkform {
    private Long wrkfmId;

    private String wrkfmShowSwftno;

    private Long srvReqstId;

    private String srvReqstTypeId;

    private String seqprcTmpltId;

    private String seqprcIstncId;

    private String wrkfmTypeCd;

    private String provCode;

    private Date crtTime;

    private Date modfTime;

    private Date arcTime;

    private String currWorkItemGroup;

    private String currWorkItemOwner;

    private String lastRouteLgIdSet;

    private String prstTskStsCd;

    private String latestSegRemainTmlen;

    private String latestSegTlmt;

    private String segTlmtStsCd;

    private Byte concrrTskFlag;

    private String dspsStaffOpList;

    private String opTypeList;

    private String lastOpType;

    private String dspsStaffList;

    private String wrkfmPtcptWorkGrpList;

    private String dspsComplteStaffId;

    private String prstNodeTypeCd;

    private String wrkfmStsCd;

    private Date exprTime;

    private Long tmlmtRuleId;

    private Integer tmoutTmlenCnt;

    private Date predctRslvTime;

    private String tlmtStsCd;

    private String dspsComplteWorkGrpId;

    private String arcModeCd;

    private Byte validFlag;

    private String arcStaffId;

    private String arcStaffWorkGrpId;

    private String arcStaffDeptId;

    private String arcOpinCntt;

    private Byte aformFlag;

    private String autoAformTgtWorkGrpId;

    private Byte aformTmsCnt;

    private Short haveRcdngCount;

    private Byte inactTmsCnt;

    private Date inactTime;

    private String actvtModeCd;

    private Byte dealRemedyFlag;

    private Long dealWrkfmSwftno;

    private String dealWrkfmShowSwftno;

    private Byte revstRemedyFlag;

    private Long revstWrkfmSwftno;

    private String revstWrkfmShowSwftno;

    private String fdbkModeCd;

    private Byte trsprtSmsIsudFlag;

    private String revstSatisDgrId;

    private String handleContactCustState;

    private String revstComplteStaffNum;

    private String smsFdbkSatisDgrId;

    private Byte isudSatisSmsFlag;

    private String smsFdbkNSatisRsnDesc;

    private Date fdbkTime;

    private Date lastConcTime;

    private Byte concTmsCnt;

    private String rmdrStsCd;

    private String nSatisRsnDesc;

    private Byte isudSatisDgrCollFlag;

    private Byte dplctCmplntsFlag;

    private Integer dplctCmplntsTmsCnt;

    private Integer hisWorkOrderNum;

    private Date expctFdbkTime;

    private Date actlFdbkTime;

    private Byte adtnInfoFlag;

    private Byte directDspsFlag;

    private String lastCustSatisDgrId;

    private String satisDgrRevstModeCd;

    private String artfRevstSatisDgrId;

    private String rmdrStaffNum;

    private Date rmdrTime;

    private Byte rmdrTmsCnt;

    private Byte urgeFlag;

    private Byte retnBlFlag;

    private Byte urgfrmFlag;

    private String respDeptId;

    private String respRsnDesc;

    private Integer handleDuration;

    private Integer actualHandleDuration;

    private String srvReqstTypeFullNm;

    private String srvReqstTypeNm;

    private String bizCntt;

    private String bizTitle;

    private String custEmail;

    private String custName;

    private String custNum;

    private String acptStaffId;

    private String acptStaffNum;

    public Long getWrkfmId() {
        return wrkfmId;
    }

    public void setWrkfmId(Long wrkfmId) {
        this.wrkfmId = wrkfmId;
    }

    public String getWrkfmShowSwftno() {
        return wrkfmShowSwftno;
    }

    public void setWrkfmShowSwftno(String wrkfmShowSwftno) {
        this.wrkfmShowSwftno = wrkfmShowSwftno == null ? null : wrkfmShowSwftno.trim();
    }

    public Long getSrvReqstId() {
        return srvReqstId;
    }

    public void setSrvReqstId(Long srvReqstId) {
        this.srvReqstId = srvReqstId;
    }

    public String getSrvReqstTypeId() {
        return srvReqstTypeId;
    }

    public void setSrvReqstTypeId(String srvReqstTypeId) {
        this.srvReqstTypeId = srvReqstTypeId == null ? null : srvReqstTypeId.trim();
    }

    public String getSeqprcTmpltId() {
        return seqprcTmpltId;
    }

    public void setSeqprcTmpltId(String seqprcTmpltId) {
        this.seqprcTmpltId = seqprcTmpltId == null ? null : seqprcTmpltId.trim();
    }

    public String getSeqprcIstncId() {
        return seqprcIstncId;
    }

    public void setSeqprcIstncId(String seqprcIstncId) {
        this.seqprcIstncId = seqprcIstncId == null ? null : seqprcIstncId.trim();
    }

    public String getWrkfmTypeCd() {
        return wrkfmTypeCd;
    }

    public void setWrkfmTypeCd(String wrkfmTypeCd) {
        this.wrkfmTypeCd = wrkfmTypeCd == null ? null : wrkfmTypeCd.trim();
    }

    public String getProvCode() {
        return provCode;
    }

    public void setProvCode(String provCode) {
        this.provCode = provCode == null ? null : provCode.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Date getModfTime() {
        return modfTime;
    }

    public void setModfTime(Date modfTime) {
        this.modfTime = modfTime;
    }

    public Date getArcTime() {
        return arcTime;
    }

    public void setArcTime(Date arcTime) {
        this.arcTime = arcTime;
    }

    public String getCurrWorkItemGroup() {
        return currWorkItemGroup;
    }

    public void setCurrWorkItemGroup(String currWorkItemGroup) {
        this.currWorkItemGroup = currWorkItemGroup == null ? null : currWorkItemGroup.trim();
    }

    public String getCurrWorkItemOwner() {
        return currWorkItemOwner;
    }

    public void setCurrWorkItemOwner(String currWorkItemOwner) {
        this.currWorkItemOwner = currWorkItemOwner == null ? null : currWorkItemOwner.trim();
    }

    public String getLastRouteLgIdSet() {
        return lastRouteLgIdSet;
    }

    public void setLastRouteLgIdSet(String lastRouteLgIdSet) {
        this.lastRouteLgIdSet = lastRouteLgIdSet == null ? null : lastRouteLgIdSet.trim();
    }

    public String getPrstTskStsCd() {
        return prstTskStsCd;
    }

    public void setPrstTskStsCd(String prstTskStsCd) {
        this.prstTskStsCd = prstTskStsCd == null ? null : prstTskStsCd.trim();
    }

    public String getLatestSegRemainTmlen() {
        return latestSegRemainTmlen;
    }

    public void setLatestSegRemainTmlen(String latestSegRemainTmlen) {
        this.latestSegRemainTmlen = latestSegRemainTmlen == null ? null : latestSegRemainTmlen.trim();
    }

    public String getLatestSegTlmt() {
        return latestSegTlmt;
    }

    public void setLatestSegTlmt(String latestSegTlmt) {
        this.latestSegTlmt = latestSegTlmt == null ? null : latestSegTlmt.trim();
    }

    public String getSegTlmtStsCd() {
        return segTlmtStsCd;
    }

    public void setSegTlmtStsCd(String segTlmtStsCd) {
        this.segTlmtStsCd = segTlmtStsCd == null ? null : segTlmtStsCd.trim();
    }

    public Byte getConcrrTskFlag() {
        return concrrTskFlag;
    }

    public void setConcrrTskFlag(Byte concrrTskFlag) {
        this.concrrTskFlag = concrrTskFlag;
    }

    public String getDspsStaffOpList() {
        return dspsStaffOpList;
    }

    public void setDspsStaffOpList(String dspsStaffOpList) {
        this.dspsStaffOpList = dspsStaffOpList == null ? null : dspsStaffOpList.trim();
    }

    public String getOpTypeList() {
        return opTypeList;
    }

    public void setOpTypeList(String opTypeList) {
        this.opTypeList = opTypeList == null ? null : opTypeList.trim();
    }

    public String getLastOpType() {
        return lastOpType;
    }

    public void setLastOpType(String lastOpType) {
        this.lastOpType = lastOpType == null ? null : lastOpType.trim();
    }

    public String getDspsStaffList() {
        return dspsStaffList;
    }

    public void setDspsStaffList(String dspsStaffList) {
        this.dspsStaffList = dspsStaffList == null ? null : dspsStaffList.trim();
    }

    public String getWrkfmPtcptWorkGrpList() {
        return wrkfmPtcptWorkGrpList;
    }

    public void setWrkfmPtcptWorkGrpList(String wrkfmPtcptWorkGrpList) {
        this.wrkfmPtcptWorkGrpList = wrkfmPtcptWorkGrpList == null ? null : wrkfmPtcptWorkGrpList.trim();
    }

    public String getDspsComplteStaffId() {
        return dspsComplteStaffId;
    }

    public void setDspsComplteStaffId(String dspsComplteStaffId) {
        this.dspsComplteStaffId = dspsComplteStaffId == null ? null : dspsComplteStaffId.trim();
    }

    public String getPrstNodeTypeCd() {
        return prstNodeTypeCd;
    }

    public void setPrstNodeTypeCd(String prstNodeTypeCd) {
        this.prstNodeTypeCd = prstNodeTypeCd == null ? null : prstNodeTypeCd.trim();
    }

    public String getWrkfmStsCd() {
        return wrkfmStsCd;
    }

    public void setWrkfmStsCd(String wrkfmStsCd) {
        this.wrkfmStsCd = wrkfmStsCd == null ? null : wrkfmStsCd.trim();
    }

    public Date getExprTime() {
        return exprTime;
    }

    public void setExprTime(Date exprTime) {
        this.exprTime = exprTime;
    }

    public Long getTmlmtRuleId() {
        return tmlmtRuleId;
    }

    public void setTmlmtRuleId(Long tmlmtRuleId) {
        this.tmlmtRuleId = tmlmtRuleId;
    }

    public Integer getTmoutTmlenCnt() {
        return tmoutTmlenCnt;
    }

    public void setTmoutTmlenCnt(Integer tmoutTmlenCnt) {
        this.tmoutTmlenCnt = tmoutTmlenCnt;
    }

    public Date getPredctRslvTime() {
        return predctRslvTime;
    }

    public void setPredctRslvTime(Date predctRslvTime) {
        this.predctRslvTime = predctRslvTime;
    }

    public String getTlmtStsCd() {
        return tlmtStsCd;
    }

    public void setTlmtStsCd(String tlmtStsCd) {
        this.tlmtStsCd = tlmtStsCd == null ? null : tlmtStsCd.trim();
    }

    public String getDspsComplteWorkGrpId() {
        return dspsComplteWorkGrpId;
    }

    public void setDspsComplteWorkGrpId(String dspsComplteWorkGrpId) {
        this.dspsComplteWorkGrpId = dspsComplteWorkGrpId == null ? null : dspsComplteWorkGrpId.trim();
    }

    public String getArcModeCd() {
        return arcModeCd;
    }

    public void setArcModeCd(String arcModeCd) {
        this.arcModeCd = arcModeCd == null ? null : arcModeCd.trim();
    }

    public Byte getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(Byte validFlag) {
        this.validFlag = validFlag;
    }

    public String getArcStaffId() {
        return arcStaffId;
    }

    public void setArcStaffId(String arcStaffId) {
        this.arcStaffId = arcStaffId == null ? null : arcStaffId.trim();
    }

    public String getArcStaffWorkGrpId() {
        return arcStaffWorkGrpId;
    }

    public void setArcStaffWorkGrpId(String arcStaffWorkGrpId) {
        this.arcStaffWorkGrpId = arcStaffWorkGrpId == null ? null : arcStaffWorkGrpId.trim();
    }

    public String getArcStaffDeptId() {
        return arcStaffDeptId;
    }

    public void setArcStaffDeptId(String arcStaffDeptId) {
        this.arcStaffDeptId = arcStaffDeptId == null ? null : arcStaffDeptId.trim();
    }

    public String getArcOpinCntt() {
        return arcOpinCntt;
    }

    public void setArcOpinCntt(String arcOpinCntt) {
        this.arcOpinCntt = arcOpinCntt == null ? null : arcOpinCntt.trim();
    }

    public Byte getAformFlag() {
        return aformFlag;
    }

    public void setAformFlag(Byte aformFlag) {
        this.aformFlag = aformFlag;
    }

    public String getAutoAformTgtWorkGrpId() {
        return autoAformTgtWorkGrpId;
    }

    public void setAutoAformTgtWorkGrpId(String autoAformTgtWorkGrpId) {
        this.autoAformTgtWorkGrpId = autoAformTgtWorkGrpId == null ? null : autoAformTgtWorkGrpId.trim();
    }

    public Byte getAformTmsCnt() {
        return aformTmsCnt;
    }

    public void setAformTmsCnt(Byte aformTmsCnt) {
        this.aformTmsCnt = aformTmsCnt;
    }

    public Short getHaveRcdngCount() {
        return haveRcdngCount;
    }

    public void setHaveRcdngCount(Short haveRcdngCount) {
        this.haveRcdngCount = haveRcdngCount;
    }

    public Byte getInactTmsCnt() {
        return inactTmsCnt;
    }

    public void setInactTmsCnt(Byte inactTmsCnt) {
        this.inactTmsCnt = inactTmsCnt;
    }

    public Date getInactTime() {
        return inactTime;
    }

    public void setInactTime(Date inactTime) {
        this.inactTime = inactTime;
    }

    public String getActvtModeCd() {
        return actvtModeCd;
    }

    public void setActvtModeCd(String actvtModeCd) {
        this.actvtModeCd = actvtModeCd == null ? null : actvtModeCd.trim();
    }

    public Byte getDealRemedyFlag() {
        return dealRemedyFlag;
    }

    public void setDealRemedyFlag(Byte dealRemedyFlag) {
        this.dealRemedyFlag = dealRemedyFlag;
    }

    public Long getDealWrkfmSwftno() {
        return dealWrkfmSwftno;
    }

    public void setDealWrkfmSwftno(Long dealWrkfmSwftno) {
        this.dealWrkfmSwftno = dealWrkfmSwftno;
    }

    public String getDealWrkfmShowSwftno() {
        return dealWrkfmShowSwftno;
    }

    public void setDealWrkfmShowSwftno(String dealWrkfmShowSwftno) {
        this.dealWrkfmShowSwftno = dealWrkfmShowSwftno == null ? null : dealWrkfmShowSwftno.trim();
    }

    public Byte getRevstRemedyFlag() {
        return revstRemedyFlag;
    }

    public void setRevstRemedyFlag(Byte revstRemedyFlag) {
        this.revstRemedyFlag = revstRemedyFlag;
    }

    public Long getRevstWrkfmSwftno() {
        return revstWrkfmSwftno;
    }

    public void setRevstWrkfmSwftno(Long revstWrkfmSwftno) {
        this.revstWrkfmSwftno = revstWrkfmSwftno;
    }

    public String getRevstWrkfmShowSwftno() {
        return revstWrkfmShowSwftno;
    }

    public void setRevstWrkfmShowSwftno(String revstWrkfmShowSwftno) {
        this.revstWrkfmShowSwftno = revstWrkfmShowSwftno == null ? null : revstWrkfmShowSwftno.trim();
    }

    public String getFdbkModeCd() {
        return fdbkModeCd;
    }

    public void setFdbkModeCd(String fdbkModeCd) {
        this.fdbkModeCd = fdbkModeCd == null ? null : fdbkModeCd.trim();
    }

    public Byte getTrsprtSmsIsudFlag() {
        return trsprtSmsIsudFlag;
    }

    public void setTrsprtSmsIsudFlag(Byte trsprtSmsIsudFlag) {
        this.trsprtSmsIsudFlag = trsprtSmsIsudFlag;
    }

    public String getRevstSatisDgrId() {
        return revstSatisDgrId;
    }

    public void setRevstSatisDgrId(String revstSatisDgrId) {
        this.revstSatisDgrId = revstSatisDgrId == null ? null : revstSatisDgrId.trim();
    }

    public String getHandleContactCustState() {
        return handleContactCustState;
    }

    public void setHandleContactCustState(String handleContactCustState) {
        this.handleContactCustState = handleContactCustState == null ? null : handleContactCustState.trim();
    }

    public String getRevstComplteStaffNum() {
        return revstComplteStaffNum;
    }

    public void setRevstComplteStaffNum(String revstComplteStaffNum) {
        this.revstComplteStaffNum = revstComplteStaffNum == null ? null : revstComplteStaffNum.trim();
    }

    public String getSmsFdbkSatisDgrId() {
        return smsFdbkSatisDgrId;
    }

    public void setSmsFdbkSatisDgrId(String smsFdbkSatisDgrId) {
        this.smsFdbkSatisDgrId = smsFdbkSatisDgrId == null ? null : smsFdbkSatisDgrId.trim();
    }

    public Byte getIsudSatisSmsFlag() {
        return isudSatisSmsFlag;
    }

    public void setIsudSatisSmsFlag(Byte isudSatisSmsFlag) {
        this.isudSatisSmsFlag = isudSatisSmsFlag;
    }

    public String getSmsFdbkNSatisRsnDesc() {
        return smsFdbkNSatisRsnDesc;
    }

    public void setSmsFdbkNSatisRsnDesc(String smsFdbkNSatisRsnDesc) {
        this.smsFdbkNSatisRsnDesc = smsFdbkNSatisRsnDesc == null ? null : smsFdbkNSatisRsnDesc.trim();
    }

    public Date getFdbkTime() {
        return fdbkTime;
    }

    public void setFdbkTime(Date fdbkTime) {
        this.fdbkTime = fdbkTime;
    }

    public Date getLastConcTime() {
        return lastConcTime;
    }

    public void setLastConcTime(Date lastConcTime) {
        this.lastConcTime = lastConcTime;
    }

    public Byte getConcTmsCnt() {
        return concTmsCnt;
    }

    public void setConcTmsCnt(Byte concTmsCnt) {
        this.concTmsCnt = concTmsCnt;
    }

    public String getRmdrStsCd() {
        return rmdrStsCd;
    }

    public void setRmdrStsCd(String rmdrStsCd) {
        this.rmdrStsCd = rmdrStsCd == null ? null : rmdrStsCd.trim();
    }

    public String getnSatisRsnDesc() {
        return nSatisRsnDesc;
    }

    public void setnSatisRsnDesc(String nSatisRsnDesc) {
        this.nSatisRsnDesc = nSatisRsnDesc == null ? null : nSatisRsnDesc.trim();
    }

    public Byte getIsudSatisDgrCollFlag() {
        return isudSatisDgrCollFlag;
    }

    public void setIsudSatisDgrCollFlag(Byte isudSatisDgrCollFlag) {
        this.isudSatisDgrCollFlag = isudSatisDgrCollFlag;
    }

    public Byte getDplctCmplntsFlag() {
        return dplctCmplntsFlag;
    }

    public void setDplctCmplntsFlag(Byte dplctCmplntsFlag) {
        this.dplctCmplntsFlag = dplctCmplntsFlag;
    }

    public Integer getDplctCmplntsTmsCnt() {
        return dplctCmplntsTmsCnt;
    }

    public void setDplctCmplntsTmsCnt(Integer dplctCmplntsTmsCnt) {
        this.dplctCmplntsTmsCnt = dplctCmplntsTmsCnt;
    }

    public Integer getHisWorkOrderNum() {
        return hisWorkOrderNum;
    }

    public void setHisWorkOrderNum(Integer hisWorkOrderNum) {
        this.hisWorkOrderNum = hisWorkOrderNum;
    }

    public Date getExpctFdbkTime() {
        return expctFdbkTime;
    }

    public void setExpctFdbkTime(Date expctFdbkTime) {
        this.expctFdbkTime = expctFdbkTime;
    }

    public Date getActlFdbkTime() {
        return actlFdbkTime;
    }

    public void setActlFdbkTime(Date actlFdbkTime) {
        this.actlFdbkTime = actlFdbkTime;
    }

    public Byte getAdtnInfoFlag() {
        return adtnInfoFlag;
    }

    public void setAdtnInfoFlag(Byte adtnInfoFlag) {
        this.adtnInfoFlag = adtnInfoFlag;
    }

    public Byte getDirectDspsFlag() {
        return directDspsFlag;
    }

    public void setDirectDspsFlag(Byte directDspsFlag) {
        this.directDspsFlag = directDspsFlag;
    }

    public String getLastCustSatisDgrId() {
        return lastCustSatisDgrId;
    }

    public void setLastCustSatisDgrId(String lastCustSatisDgrId) {
        this.lastCustSatisDgrId = lastCustSatisDgrId == null ? null : lastCustSatisDgrId.trim();
    }

    public String getSatisDgrRevstModeCd() {
        return satisDgrRevstModeCd;
    }

    public void setSatisDgrRevstModeCd(String satisDgrRevstModeCd) {
        this.satisDgrRevstModeCd = satisDgrRevstModeCd == null ? null : satisDgrRevstModeCd.trim();
    }

    public String getArtfRevstSatisDgrId() {
        return artfRevstSatisDgrId;
    }

    public void setArtfRevstSatisDgrId(String artfRevstSatisDgrId) {
        this.artfRevstSatisDgrId = artfRevstSatisDgrId == null ? null : artfRevstSatisDgrId.trim();
    }

    public String getRmdrStaffNum() {
        return rmdrStaffNum;
    }

    public void setRmdrStaffNum(String rmdrStaffNum) {
        this.rmdrStaffNum = rmdrStaffNum == null ? null : rmdrStaffNum.trim();
    }

    public Date getRmdrTime() {
        return rmdrTime;
    }

    public void setRmdrTime(Date rmdrTime) {
        this.rmdrTime = rmdrTime;
    }

    public Byte getRmdrTmsCnt() {
        return rmdrTmsCnt;
    }

    public void setRmdrTmsCnt(Byte rmdrTmsCnt) {
        this.rmdrTmsCnt = rmdrTmsCnt;
    }

    public Byte getUrgeFlag() {
        return urgeFlag;
    }

    public void setUrgeFlag(Byte urgeFlag) {
        this.urgeFlag = urgeFlag;
    }

    public Byte getRetnBlFlag() {
        return retnBlFlag;
    }

    public void setRetnBlFlag(Byte retnBlFlag) {
        this.retnBlFlag = retnBlFlag;
    }

    public Byte getUrgfrmFlag() {
        return urgfrmFlag;
    }

    public void setUrgfrmFlag(Byte urgfrmFlag) {
        this.urgfrmFlag = urgfrmFlag;
    }

    public String getRespDeptId() {
        return respDeptId;
    }

    public void setRespDeptId(String respDeptId) {
        this.respDeptId = respDeptId == null ? null : respDeptId.trim();
    }

    public String getRespRsnDesc() {
        return respRsnDesc;
    }

    public void setRespRsnDesc(String respRsnDesc) {
        this.respRsnDesc = respRsnDesc == null ? null : respRsnDesc.trim();
    }

    public Integer getHandleDuration() {
        return handleDuration;
    }

    public void setHandleDuration(Integer handleDuration) {
        this.handleDuration = handleDuration;
    }

    public Integer getActualHandleDuration() {
        return actualHandleDuration;
    }

    public void setActualHandleDuration(Integer actualHandleDuration) {
        this.actualHandleDuration = actualHandleDuration;
    }

    public String getSrvReqstTypeFullNm() {
        return srvReqstTypeFullNm;
    }

    public void setSrvReqstTypeFullNm(String srvReqstTypeFullNm) {
        this.srvReqstTypeFullNm = srvReqstTypeFullNm == null ? null : srvReqstTypeFullNm.trim();
    }

    public String getSrvReqstTypeNm() {
        return srvReqstTypeNm;
    }

    public void setSrvReqstTypeNm(String srvReqstTypeNm) {
        this.srvReqstTypeNm = srvReqstTypeNm == null ? null : srvReqstTypeNm.trim();
    }

    public String getBizCntt() {
        return bizCntt;
    }

    public void setBizCntt(String bizCntt) {
        this.bizCntt = bizCntt == null ? null : bizCntt.trim();
    }

    public String getBizTitle() {
        return bizTitle;
    }

    public void setBizTitle(String bizTitle) {
        this.bizTitle = bizTitle == null ? null : bizTitle.trim();
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail == null ? null : custEmail.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustNum() {
        return custNum;
    }

    public void setCustNum(String custNum) {
        this.custNum = custNum == null ? null : custNum.trim();
    }

    public String getAcptStaffId() {
        return acptStaffId;
    }

    public void setAcptStaffId(String acptStaffId) {
        this.acptStaffId = acptStaffId == null ? null : acptStaffId.trim();
    }

    public String getAcptStaffNum() {
        return acptStaffNum;
    }

    public void setAcptStaffNum(String acptStaffNum) {
        this.acptStaffNum = acptStaffNum == null ? null : acptStaffNum.trim();
    }
}