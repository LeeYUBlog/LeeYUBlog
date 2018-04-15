package com.LeeYUBlog.core.model.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PermissionList implements Serializable {

	private static final long serialVersionUID = 5659633019179766915L;
	private int totalCount;
	private List<Permission> permissions = new ArrayList<Permission>();
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
}
