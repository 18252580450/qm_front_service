package com.asiainfo.qm.manage.vo;

import com.asiainfo.qm.manage.domain.CheckItemDetail;
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
 * @ Date       ：Created in 2019-01-14 13:55
 * @ Description：${description}
 */

@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class CheckItemDetailResponse extends ResponseParent{

    @ApiModelProperty(name = "DATA", value = "", required = true, example = "")
    @JsonProperty(value = "DATA")
    private List<CheckItemDetail> data = new ArrayList<CheckItemDetail>();

    public CheckItemDetailResponse() {}

    public List<CheckItemDetail> getData() {
        return data;
    }

    public void setData(List<CheckItemDetail> data) {
        this.data = data;
    }

    public CheckItemDetailResponse(Page<CheckItemDetail> pageResult) {
        this.setData(pageResult != null ? pageResult.getResult() : null);
        this.setAttach(new Attach(pageResult != null ? pageResult.getTotal() : 0L));
    }

}
