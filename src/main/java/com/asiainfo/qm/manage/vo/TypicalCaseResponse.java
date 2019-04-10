package com.asiainfo.qm.manage.vo;

import com.asiainfo.qm.manage.domain.TypicalCase;
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
 * @ Date       ：Created in 2019-04-09 11:10
 * @ Description：${description}
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class TypicalCaseResponse extends ResponseParent{
    @ApiModelProperty(name = "DATA", value = "", required = true, example = "")
    @JsonProperty(value = "DATA")
    private List<TypicalCase> data = new ArrayList<TypicalCase>();

    public TypicalCaseResponse() {}

    public List<TypicalCase> getData() {
        return data;
    }

    public void setData(List<TypicalCase> data) {
        this.data = data;
    }

    public TypicalCaseResponse(Page<TypicalCase> pageResult) {
        this.setData(pageResult != null ? pageResult.getResult() : null);
        this.setAttach(new Attach(pageResult != null ? pageResult.getTotal() : 0L));
    }
}
