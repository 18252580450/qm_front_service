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
 * @ Date       ：Created in 2019-01-05 11:47
 * @ Description：${description}
 */

@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class OrderCheckServiceResponse extends ServiceResponseParent {

    private static Logger logger = LoggerFactory.getLogger(OrderCheckServiceResponse.class);

    @ApiModelProperty(name = "RSP", value = "服务返回业务数据", required = true)
    @JSONField(name = "RSP")
    @JsonProperty("RSP")
    private OrderCheckResponse response;

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        OrderCheckServiceResponse.logger = logger;
    }

    public OrderCheckResponse getResponse() {
        return response;
    }

    public void setResponse(OrderCheckResponse response) {
        this.response = response;
    }

    public OrderCheckServiceResponse() {
        try {
            this.txid = TxidUtils.generateTxid();
        } catch (Exception e) {
            logger.error("can not get PtxId:", e);
        }
    }

    public OrderCheckServiceResponse getSuccessResponse(OrderCheckResponse response) {
        this.setStatus(ServiceConstant.STATUS_SUCCESS);
        this.setMsg(ServiceConstant.MSG_SUCCESS);
        this.setResponse(response);
        this.setTxid(TxidUtils.generateTxid());
        return this;
    }

    public OrderCheckServiceResponse getErrorResponse(String errorStatus, String errorMsg, OrderCheckResponse response) {
        this.setStatus(errorStatus);
        this.setMsg(errorMsg);
        this.setResponse(response);
        this.setTxid(TxidUtils.generateTxid());
        return this;
    }
}
