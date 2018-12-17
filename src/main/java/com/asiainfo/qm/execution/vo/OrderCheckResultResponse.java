package com.asiainfo.qm.execution.vo;

import com.asiainfo.qm.manage.domain.OrderCheckResult;
import com.asiainfo.qm.manage.vo.Attach;
import com.asiainfo.qm.manage.vo.ResponseParent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-11 16:26
 * @ Description：${description}
 */

@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class OrderCheckResultResponse extends ResponseParent {

    @ApiModelProperty(name = "DATA", value = "", required = true, example = "")
    @JsonProperty(value = "DATA")
    private List<OrderCheckResult> data = new ArrayList<OrderCheckResult>();

    public OrderCheckResultResponse() {
    }

    public List<OrderCheckResult> getData() {
        return data;
    }

    public void setData(List<OrderCheckResult> data) {
        this.data = data;
    }

    public OrderCheckResultResponse(Page<OrderCheckResult> pageResult) {
        this.setData(pageResult != null ? pageResult.getResult() : null);
        this.setAttach(new Attach(pageResult != null ? pageResult.getTotal() : 0L));
    }

}
