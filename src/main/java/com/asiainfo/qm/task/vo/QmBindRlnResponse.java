package com.asiainfo.qm.task.vo;

import com.asiainfo.qm.manage.vo.Attach;
import com.asiainfo.qm.manage.vo.ResponseParent;
import com.asiainfo.qm.task.domain.QmBindRln;
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
public class QmBindRlnResponse extends ResponseParent {

	@ApiModelProperty(name = "DATA", value = "", required = true, example = "")
	@JsonProperty(value = "DATA")
	private List<QmBindRln> data = new ArrayList<QmBindRln>();

	public QmBindRlnResponse() {}

	public List<QmBindRln> getData() {
		return data;
	}

	public void setData(List<QmBindRln> data) {
		this.data = data;
	}

	public QmBindRlnResponse(Page<QmBindRln> pageResult) {
		this.setData(pageResult != null ? pageResult.getResult() : null);
		this.setAttach(new Attach(pageResult != null ? pageResult.getTotal() : 0L));
	}


}
