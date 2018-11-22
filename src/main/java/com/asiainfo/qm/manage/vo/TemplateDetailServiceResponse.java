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

@EqualsAndHashCode(callSuper=false)
@Data
@ApiModel
public class TemplateDetailServiceResponse extends ServiceResponseParent{
    private static Logger logger = LoggerFactory.getLogger(TemplateDetailServiceResponse.class);

    @ApiModelProperty(name = "RSP", value = "服务返回业务数据", required = true)
    @JSONField(name = "RSP")
    @JsonProperty("RSP")
    private TemplateDetailResponse response;

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        TemplateDetailServiceResponse.logger = logger;
    }

    public TemplateDetailResponse getResponse() {
        return response;
    }

    public void setResponse(TemplateDetailResponse response) {
        this.response = response;
    }

    public TemplateDetailServiceResponse() {
        try {
            this.txid = TxidUtils.generateTxid();
        } catch (Exception e) {
            logger.error("can not get PtxId:", e);
        }
    }

    public TemplateDetailServiceResponse getSuccessResponse(TemplateDetailResponse response) {
        this.setStatus(ServiceConstant.STATUS_SUCCESS);
        this.setMsg(ServiceConstant.MSG_SUCCESS);
        this.setResponse(response);
        this.setTxid(TxidUtils.generateTxid());
        return this;
    }

    public TemplateDetailServiceResponse getErrorResponse(String errorStatus, String errorMsg, TemplateDetailResponse response) {
        this.setStatus(errorStatus);
        this.setMsg(errorMsg);
        this.setResponse(response);
       this.setTxid(TxidUtils.generateTxid());
        return this;
    }
 

}
