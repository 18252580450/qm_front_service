package com.asiainfo.qm.execution.vo;


import com.asiainfo.qm.execution.domain.WorkformPool;
import com.asiainfo.qm.manage.domain.TplOpLog;
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


@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class WorkformPoolResponse extends ResponseParent {

	@ApiModelProperty(name = "DATA", value = "", required = true, example = "")
	@JsonProperty(value = "DATA")
	private List<WorkformPool> data = new ArrayList<WorkformPool>();

	public WorkformPoolResponse() {}

	public List<WorkformPool> getData() {
		return data;
	}

	public void setData(List<WorkformPool> data) {
		this.data = data;
	}

	public WorkformPoolResponse(Page<WorkformPool> pageResult) {
		this.setData(pageResult != null ? pageResult.getResult() : null);
		this.setAttach(new Attach(pageResult != null ? pageResult.getTotal() : 0L));
	}


}
