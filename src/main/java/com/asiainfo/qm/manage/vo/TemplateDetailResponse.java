package com.asiainfo.qm.manage.vo;


import com.asiainfo.qm.manage.domain.CheckTemplate;
import com.asiainfo.qm.manage.domain.TemplateDetail;
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
public class TemplateDetailResponse extends ResponseParent {

	@ApiModelProperty(name = "DATA", value = "", required = true, example = "")
	@JsonProperty(value = "DATA")
	private List<TemplateDetail> data = new ArrayList<TemplateDetail>();

	public TemplateDetailResponse() {}

	public List<TemplateDetail> getData() {
		return data;
	}

	public void setData(List<TemplateDetail> data) {
		this.data = data;
	}

	public TemplateDetailResponse(Page<TemplateDetail> pageResult) {
		this.setData(pageResult != null ? pageResult.getResult() : null);
		this.setAttach(new Attach(pageResult != null ? pageResult.getTotal() : 0L));
	}


}
