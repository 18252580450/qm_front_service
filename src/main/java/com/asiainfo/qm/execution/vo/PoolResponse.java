package com.asiainfo.qm.execution.vo;


import com.asiainfo.qm.execution.domain.Pool;
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
public class PoolResponse extends ResponseParent {

	@ApiModelProperty(name = "DATA", value = "", required = true, example = "")
	@JsonProperty(value = "DATA")
	private List<Pool> data = new ArrayList<Pool>();

	public PoolResponse() {}

	public List<Pool> getData() {
		return data;
	}

	public void setData(List<Pool> data) {
		this.data = data;
	}

	public PoolResponse(Page<Pool> pageResult) {
		this.setData(pageResult != null ? pageResult.getResult() : null);
		this.setAttach(new Attach(pageResult != null ? pageResult.getTotal() : 0L));
	}


}
