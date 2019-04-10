package com.asiainfo.qm.manage.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.asiainfo.qm.manage.util.ServiceConstant;
import com.asiainfo.qm.manage.util.TxidUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-04-09 11:11
 * @ Description：${description}
 */
@EqualsAndHashCode(callSuper=false)
@Data
@ApiModel
public class TypicalCaseServiceResponse extends ServiceResponseParent{
    private static Logger logger = LoggerFactory.getLogger(TypicalCaseServiceResponse.class);

    @ApiModelProperty(name = "RSP", value = "服务返回业务数据", required = true)
    @JSONField(name = "RSP")
    @JsonProperty("RSP")
    private TypicalCaseResponse response;

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        TypicalCaseServiceResponse.logger = logger;
    }

    public TypicalCaseResponse getResponse() {
        return response;
    }

    public void setResponse(TypicalCaseResponse response) {
        this.response = response;
    }

    public TypicalCaseServiceResponse() {
        try {
            this.txid = TxidUtils.generateTxid();
        } catch (Exception e) {
            logger.error("can not get PtxId:", e);
        }
    }

    public TypicalCaseServiceResponse getSuccessResponse(TypicalCaseResponse response) {
        this.setStatus(ServiceConstant.STATUS_SUCCESS);
        this.setMsg(ServiceConstant.MSG_SUCCESS);
        this.setResponse(response);
        this.setTxid(TxidUtils.generateTxid());
        return this;
    }

    public TypicalCaseServiceResponse getErrorResponse(String errorStatus, String errorMsg, TypicalCaseResponse response) {
        this.setStatus(errorStatus);
        this.setMsg(errorMsg);
        this.setResponse(response);
        this.setTxid(TxidUtils.generateTxid());
        return this;
    }
}
