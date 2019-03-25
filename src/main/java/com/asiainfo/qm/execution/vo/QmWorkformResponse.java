package com.asiainfo.qm.execution.vo;

import com.asiainfo.qm.execution.domain.QmWorkForm;
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
 * @ Date       ：Created in 2019-03-20 19:49
 * @ Description：${description}
 */

@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class QmWorkformResponse extends ResponseParent {

    @ApiModelProperty(name = "DATA", value = "", required = true, example = "")
    @JsonProperty(value = "DATA")
    private List<QmWorkForm> data = new ArrayList<QmWorkForm>();

    public QmWorkformResponse() {
    }

    public List<QmWorkForm> getData() {
        return data;
    }

    public void setData(List<QmWorkForm> data) {
        this.data = data;
    }

    public QmWorkformResponse(Page<QmWorkForm> pageResult) {
        this.setData(pageResult != null ? pageResult.getResult() : null);
        this.setAttach(new Attach(pageResult != null ? pageResult.getTotal() : 0L));
    }
}
