package com.asiainfo.qm.execution.vo;

import com.asiainfo.qm.execution.domain.VoiceCheckResult;
import com.asiainfo.qm.manage.vo.Attach;
import com.asiainfo.qm.manage.vo.ResponseParent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-11 16:31
 * @ Description：${description}
 */
public class VoiceCheckResponse extends ResponseParent {

    @ApiModelProperty(name = "DATA", value = "", required = true, example = "")
    @JsonProperty(value = "DATA")
    private List<VoiceCheckResult> data = new ArrayList<VoiceCheckResult>();

    public VoiceCheckResponse() {
    }

    public List<VoiceCheckResult> getData() {
        return data;
    }

    public void setData(List<VoiceCheckResult> data) {
        this.data = data;
    }

    public VoiceCheckResponse(Page<VoiceCheckResult> pageResult) {
        this.setData(pageResult != null ? pageResult.getResult() : null);
        this.setAttach(new Attach(pageResult != null ? pageResult.getTotal() : 0L));
    }

}
