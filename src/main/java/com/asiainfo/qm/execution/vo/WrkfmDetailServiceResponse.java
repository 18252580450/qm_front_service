package com.asiainfo.qm.execution.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.asiainfo.qm.manage.util.ServiceConstant;
import com.asiainfo.qm.manage.util.TxidUtils;
import com.asiainfo.qm.manage.vo.ServiceResponseParent;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-30 17:28
 * @ Description：${description}
 */

@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class WrkfmDetailServiceResponse extends ServiceResponseParent {
    private static Logger logger = LoggerFactory.getLogger(WrkfmDetailServiceResponse.class);

    @ApiModelProperty(name = "RSP", value = "服务返回业务数据", required = true)
    @JSONField(name = "RSP")
    @JsonProperty("RSP")
    private WrkfmDetailResponse response;

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        WrkfmDetailServiceResponse.logger = logger;
    }

    public WrkfmDetailResponse getResponse() {
        return response;
    }

    public void setResponse(WrkfmDetailResponse response) {
        this.response = response;
    }

    public WrkfmDetailServiceResponse() {
        try {
            this.txid = TxidUtils.generateTxid();
        } catch (Exception e) {
            logger.error("can not get PtxId:", e);
        }
    }

    public WrkfmDetailServiceResponse getSuccessResponse(WrkfmDetailResponse response) {
        this.setStatus(ServiceConstant.STATUS_SUCCESS);
        this.setMsg(ServiceConstant.MSG_SUCCESS);
        this.setResponse(response);
        this.setTxid(TxidUtils.generateTxid());
        return this;
    }

    public WrkfmDetailServiceResponse getErrorResponse(String errorStatus, String errorMsg, WrkfmDetailResponse response) {
        this.setStatus(errorStatus);
        this.setMsg(errorMsg);
        this.setResponse(response);
        this.setTxid(TxidUtils.generateTxid());
        return this;
    }

}
