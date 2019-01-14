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
 * @ Date       ：Created in 2019-01-14 13:56
 * @ Description：${description}
 */

@EqualsAndHashCode(callSuper=false)
@Data
@ApiModel
public class CheckItemDetailServiceResponse extends ServiceResponseParent{

    private static Logger logger = LoggerFactory.getLogger(CheckItemDetailServiceResponse.class);

    @ApiModelProperty(name = "RSP", value = "服务返回业务数据", required = true)
    @JSONField(name = "RSP")
    @JsonProperty("RSP")
    private CheckItemDetailResponse response;

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        CheckItemDetailServiceResponse.logger = logger;
    }

    public CheckItemDetailResponse getResponse() {
        return response;
    }

    public void setResponse(CheckItemDetailResponse response) {
        this.response = response;
    }

    public CheckItemDetailServiceResponse() {
        try {
            this.txid = TxidUtils.generateTxid();
        } catch (Exception e) {
            logger.error("can not get PtxId:", e);
        }
    }

    public CheckItemDetailServiceResponse getSuccessResponse(CheckItemDetailResponse response) {
        this.setStatus(ServiceConstant.STATUS_SUCCESS);
        this.setMsg(ServiceConstant.MSG_SUCCESS);
        this.setResponse(response);
        this.setTxid(TxidUtils.generateTxid());
        return this;
    }

    public CheckItemDetailServiceResponse getErrorResponse(String errorStatus, String errorMsg, CheckItemDetailResponse response) {
        this.setStatus(errorStatus);
        this.setMsg(errorMsg);
        this.setResponse(response);
        this.setTxid(TxidUtils.generateTxid());
        return this;
    }

}
