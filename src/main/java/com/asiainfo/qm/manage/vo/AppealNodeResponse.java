package com.asiainfo.qm.manage.vo;

import com.asiainfo.qm.manage.domain.AppealNode;
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
 * @ Date       ：Created in 18:06 2018/11/8
 * @ Description：${description}
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class AppealNodeResponse extends ResponseParent{
    @ApiModelProperty(name = "DATA", value = "", required = true, example = "")
    @JsonProperty(value = "DATA")
    private List<AppealNode> data = new ArrayList<AppealNode>();

    public AppealNodeResponse() {}

    public List<AppealNode> getData() {
        return data;
    }

    public void setData(List<AppealNode> data) {
        this.data = data;
    }

    public AppealNodeResponse(Page<AppealNode> pageResult) {
        this.setData(pageResult != null ? pageResult.getResult() : null);
        this.setAttach(new Attach(pageResult != null ? pageResult.getTotal() : 0L));
    }
}
