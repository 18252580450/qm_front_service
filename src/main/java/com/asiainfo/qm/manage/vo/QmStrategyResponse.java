package com.asiainfo.qm.manage.vo;


import com.asiainfo.qm.manage.domain.QmStrategy;
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
public class QmStrategyResponse extends ResponseParent {

	@ApiModelProperty(name = "DATA", value = "", required = true, example = "")
	@JsonProperty(value = "DATA")
	private List<QmStrategy> data = new ArrayList<QmStrategy>();

	public QmStrategyResponse() {}

	public List<QmStrategy> getData() {
		return data;
	}

	public void setData(List<QmStrategy> data) {
		this.data = data;
	}

	public QmStrategyResponse(Page<QmStrategy> pageResult) {
		this.setData(pageResult != null ? pageResult.getResult() : null);
		this.setAttach(new Attach(pageResult != null ? pageResult.getTotal() : 0L));
	}


}
