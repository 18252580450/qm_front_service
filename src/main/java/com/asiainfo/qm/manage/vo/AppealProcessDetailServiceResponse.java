package com.asiainfo.qm.manage.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.asiainfo.qm.manage.util.ServiceConstant;
import com.asiainfo.qm.manage.util.TxidUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-03-08 14:06
 * @ Description：${description}
 */
public class AppealProcessDetailServiceResponse extends ServiceResponseParent{

    private static Logger logger = LoggerFactory.getLogger(AppealProcessDetailServiceResponse.class);

    @ApiModelProperty(name = "RSP", value = "服务返回业务数据", required = true)
    @JSONField(name = "RSP")
    @JsonProperty("RSP")
    private AppealProcessDetailResponse response;

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        AppealProcessDetailServiceResponse.logger = logger;
    }

    public AppealProcessDetailResponse getResponse() {
        return response;
    }

    public void setResponse(AppealProcessDetailResponse response) {
        this.response = response;
    }

    public AppealProcessDetailServiceResponse() {
        try {
            this.txid = TxidUtils.generateTxid();
        } catch (Exception e) {
            logger.error("can not get PtxId:", e);
        }
    }

    public AppealProcessDetailServiceResponse getSuccessResponse(AppealProcessDetailResponse response) {
        this.setStatus(ServiceConstant.STATUS_SUCCESS);
        this.setMsg(ServiceConstant.MSG_SUCCESS);
        this.setResponse(response);
        this.setTxid(TxidUtils.generateTxid());
        return this;
    }

    public AppealProcessDetailServiceResponse getErrorResponse(String errorStatus, String errorMsg, AppealProcessDetailResponse response) {
        this.setStatus(errorStatus);
        this.setMsg(errorMsg);
        this.setResponse(response);
        this.setTxid(TxidUtils.generateTxid());
        return this;
    }
}
