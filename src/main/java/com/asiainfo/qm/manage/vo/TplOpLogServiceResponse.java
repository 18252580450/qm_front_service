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
public class TplOpLogServiceResponse extends ServiceResponseParent{
    private static Logger logger = LoggerFactory.getLogger(TplOpLogServiceResponse.class);

    @ApiModelProperty(name = "RSP", value = "服务返回业务数据", required = true)
    @JSONField(name = "RSP")
    @JsonProperty("RSP")
    private TplOpLogResponse response;

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        TplOpLogServiceResponse.logger = logger;
    }

    public TplOpLogResponse getResponse() {
        return response;
    }

    public void setResponse(TplOpLogResponse response) {
        this.response = response;
    }

    public TplOpLogServiceResponse() {
        try {
            this.txid = TxidUtils.generateTxid();
        } catch (Exception e) {
            logger.error("can not get PtxId:", e);
        }
    }

    public TplOpLogServiceResponse getSuccessResponse(TplOpLogResponse response) {
        this.setStatus(ServiceConstant.STATUS_SUCCESS);
        this.setMsg(ServiceConstant.MSG_SUCCESS);
        this.setResponse(response);
        this.setTxid(TxidUtils.generateTxid());
        return this;
    }

    public TplOpLogServiceResponse getErrorResponse(String errorStatus, String errorMsg, TplOpLogResponse response) {
        this.setStatus(errorStatus);
        this.setMsg(errorMsg);
        this.setResponse(response);
       this.setTxid(TxidUtils.generateTxid());
        return this;
    }
 

}
