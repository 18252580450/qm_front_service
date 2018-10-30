package com.asiainfo.qm.manage.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 对应表users的实体类
 */
@ApiModel
public class DemoUser{
	
	@ApiModelProperty(name = "ID", value = "用户的ID", required = true, example = "1")
	@JsonProperty("ID")
    private Integer id;
	
	
	
	@ApiModelProperty(name = "NAME", value = "用户名称", required = false, example = "张三")
	@JsonProperty("NAME")
    private String name;

	
	@ApiModelProperty(name = "DESCRIPTION", value = "描述信息", required = false, example = "张三时候软件工程师")
	@JsonProperty("DESCRIPTION")
    private String description;

	

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
