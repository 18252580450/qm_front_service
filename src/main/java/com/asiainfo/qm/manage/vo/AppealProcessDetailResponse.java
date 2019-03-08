package com.asiainfo.qm.manage.vo;

import com.asiainfo.qm.manage.domain.AppealProcessDetail;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-03-08 14:06
 * @ Description：${description}
 */
public class AppealProcessDetailResponse extends ResponseParent{

    @ApiModelProperty(name = "DATA", value = "", required = true, example = "")
    @JsonProperty(value = "DATA")
    private List<AppealProcessDetail> data = new ArrayList<AppealProcessDetail>();

    public AppealProcessDetailResponse() {}

    public List<AppealProcessDetail> getData() {
        return data;
    }

    public void setData(List<AppealProcessDetail> data) {
        this.data = data;
    }

    public AppealProcessDetailResponse(Page<AppealProcessDetail> pageResult) {
        this.setData(pageResult != null ? pageResult.getResult() : null);
        this.setAttach(new Attach(pageResult != null ? pageResult.getTotal() : 0L));
    }

}
