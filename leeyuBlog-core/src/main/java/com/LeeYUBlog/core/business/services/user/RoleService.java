package com.LeeYUBlog.core.business.services.user;

import java.util.List;
import java.util.Set;

import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.business.services.common.generic.LeeYUBlogEntityService;
import com.LeeYUBlog.core.model.user.Role;
import com.LeeYUBlog.core.model.user.RoleType;

public interface RoleService extends LeeYUBlogEntityService<Integer, Role> {
	
	List<Role> listRole(RoleType roleType) throws ServiceException;
	List<Role> listRoleByIds(Set<Integer> ids) throws ServiceException;
	
}
