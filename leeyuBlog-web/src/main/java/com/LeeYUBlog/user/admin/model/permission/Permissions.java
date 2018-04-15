package com.LeeYUBlog.user.admin.model.permission;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"permission"
})
public class Permissions implements Serializable {
	
	/**
	 * Permission 实体用于序列化Json数据
	 */
	private static final long serialVersionUID = 3689467077638897215L;
	
	@JsonProperty("permission")
	private List<BlogPermission> blogPermission = null;
	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@JsonProperty("permission")
	public List<BlogPermission> getBlogPermission() {
		return blogPermission;
	}
	
	@JsonProperty("permission")
	public void setBlogPermission(List<BlogPermission> blogPermission) {
		this.blogPermission = blogPermission;
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
