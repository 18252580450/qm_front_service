package com.asiainfo.qm.execution.vo;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.vo.ResponseParent;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-30 17:28
 * @ Description：${description}
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class WrkfmDetailResponse extends ResponseParent {

    @ApiModelProperty(name = "DATA", value = "", required = true, example = "")
    @JsonProperty(value = "DATA")
    private JSONObject data = new JSONObject();

    public WrkfmDetailResponse() {
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

}
