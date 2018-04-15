package com.LeeYUBlog.core.business.services.user;

import java.util.List;

import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.business.services.common.generic.LeeYUBlogEntityService;
import com.LeeYUBlog.core.model.user.Permission;
import com.LeeYUBlog.core.model.user.PermissionCriteria;
import com.LeeYUBlog.core.model.user.PermissionList;
import com.LeeYUBlog.core.model.user.Role;

public interface PermissionService extends LeeYUBlogEntityService<Integer, Permission> {
	
	List<Permission> getByName();

	List<Permission> listPermission()  throws ServiceException;

	Permission getById(Integer permissionId);

	List<Permission> getPermissions(List<Integer> roleIds) throws ServiceException;

	void deletePermission(Permission permission) throws ServiceException;

	PermissionList listByCriteria(PermissionCriteria criteria) throws ServiceException ;

	void removePermission(Permission permission, Role role) throws ServiceException;
}
