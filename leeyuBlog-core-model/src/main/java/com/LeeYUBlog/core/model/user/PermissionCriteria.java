package com.LeeYUBlog.core.model.user;

import java.util.List;
import java.util.Set;

import com.LeeYUBlog.core.model.common.Criteria;

public class PermissionCriteria extends Criteria {
	
	private String permissionName;
	
	private Boolean available = null;
	
	private Set<Integer> roleIds;
	
	private List<String> availabilities;

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public List<String> getAvailabilities() {
		return availabilities;
	}

	public void setAvailabilities(List<String> availabilities) {
		this.availabilities = availabilities;
	}

	public Set<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Set<Integer> roleIds) {
		this.roleIds = roleIds;
	}
}
