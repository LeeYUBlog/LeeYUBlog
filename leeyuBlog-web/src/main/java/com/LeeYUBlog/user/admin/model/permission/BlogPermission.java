package com.LeeYUBlog.user.admin.model.permission;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "role"
})
public class BlogPermission implements Serializable {

	/**
	 * BlogPermission 实体用于序列化Json数据
	 */
	private static final long serialVersionUID = 8338250607892621387L;
	
	@JsonProperty("type")
    private String type;
	@JsonProperty("role")
	private BLogRole blogRole;
	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@JsonProperty("type")
	public String getType() {
		return type;
	}
	
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}
	
	@JsonProperty("role")
	public BLogRole getBlogRole() {
		return blogRole;
	}
	
	@JsonProperty("role")
	public void setBlogRole(BLogRole blogRole) {
		this.blogRole = blogRole;
	}
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}
	
	@JsonAnySetter
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	
}
