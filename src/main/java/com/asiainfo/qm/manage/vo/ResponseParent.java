package com.asiainfo.qm.manage.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class ResponseParent {
	@ApiModelProperty(name = "RSP_CODE", value = "", required = true, example = "")
    @JsonProperty(value = "RSP_CODE")
    private String rspcode;
	@ApiModelProperty(name = "RSP_DESC", value = "", required = true, example = "")
    @JsonProperty(value = "RSP_DESC")
    private String rspdesc;
	
	@ApiModelProperty(name = "ATTACH", value = "", required = true, example = "")
	@JsonProperty(value = "ATTACH")
	private Attach attach;

	public String getRspcode() {
		return rspcode;
	}

	public void setRspcode(String rspcode) {
		this.rspcode = rspcode;
	}

	public String getRspdesc() {
		return rspdesc;
	}

	public void setRspdesc(String rspdesc) {
		this.rspdesc = rspdesc;
	}

	public Attach getAttach() {
		return attach;
	}

	public void setAttach(Attach attach) {
		this.attach = attach;
	}

	
	
	
	
}
