package com.asiainfo.qm.manage.vo;


import com.asiainfo.qm.manage.domain.OrdinaryComment;
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
public class OrdinaryCommentResponse extends ResponseParent {

	@ApiModelProperty(name = "DATA", value = "", required = true, example = "")
	@JsonProperty(value = "DATA")
	private List<OrdinaryComment> data = new ArrayList<OrdinaryComment>();

	public OrdinaryCommentResponse() {}

	public List<OrdinaryComment> getData() {
		return data;
	}

	public void setData(List<OrdinaryComment> data) {
		this.data = data;
	}

	public OrdinaryCommentResponse(Page<OrdinaryComment> pageResult) {
		this.setData(pageResult != null ? pageResult.getResult() : null);
		this.setAttach(new Attach(pageResult != null ? pageResult.getTotal() : 0L));
	}


}
