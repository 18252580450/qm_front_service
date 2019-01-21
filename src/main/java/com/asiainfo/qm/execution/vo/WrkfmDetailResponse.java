package com.asiainfo.qm.execution.vo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.vo.ResponseParent;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    @ApiModelProperty(name = "DATAS", value = "", required = true, example = "")
    @JsonProperty(value = "DATAS")
    private JSONArray datas = new JSONArray();

    public WrkfmDetailResponse() {
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public JSONArray getDatas() {
        return datas;
    }

    public void setDatas(JSONArray datas) {
        this.datas = datas;
    }
}
