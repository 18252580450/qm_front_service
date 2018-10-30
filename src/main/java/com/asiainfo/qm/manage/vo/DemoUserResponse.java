package com.asiainfo.qm.manage.vo;


import com.asiainfo.qm.manage.domain.DemoUser;
import com.asiainfo.qm.manage.util.WebUtil;
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
public class DemoUserResponse extends ResponseParent {

	@ApiModelProperty(name = "DATA", value = "", required = true, example = "")
	@JsonProperty(value = "DATA")
	private List<DemoUser> data = new ArrayList<DemoUser>();

	public DemoUserResponse() {}

	public List<DemoUser> getData() {
		return data;
	}

	public void setData(List<DemoUser> data) {
		this.data = data;
	}

	public DemoUserResponse(Page<DemoUser> pageResult) {
		this.setData(pageResult != null ? pageResult.getResult() : null);
		this.setAttach(new Attach(pageResult != null ? pageResult.getTotal() : 0L));
	}

	public DemoUserResponse getUserById(Integer id) throws Exception{
		DemoUserResponse userResponse = new DemoUserResponse();
		userResponse.setRspcode(WebUtil.SUCCESS);
		userResponse.setRspdesc("查询成功！*****");
		return userResponse;
	}

}
