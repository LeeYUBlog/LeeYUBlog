package com.LeeYUBlog.core.business.services.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.business.repositories.user.PermissionRepository;
import com.LeeYUBlog.core.business.services.common.generic.LeeYUBlogEntityServiceImpl;
import com.LeeYUBlog.core.model.user.Permission;
import com.LeeYUBlog.core.model.user.PermissionCriteria;
import com.LeeYUBlog.core.model.user.PermissionList;
import com.LeeYUBlog.core.model.user.Role;

@Service("permissionService")
public class PermissionServiceImpl extends LeeYUBlogEntityServiceImpl<Integer, Permission>
		implements PermissionService {
	
	private PermissionRepository permissionRepository;
	
	@Inject
	public PermissionServiceImpl(PermissionRepository permissionRepository) {
		super(permissionRepository);
		this.permissionRepository = permissionRepository;

	}

	@Override
	public List<Permission> getByName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Permission getById(Integer permissionId) {
		return permissionRepository.findOne(permissionId);
	}
	
	@Override
	public void deletePermission(Permission permission) throws ServiceException {
		permission = this.getById(permission.getId());//防止附带的实体报错
		permission.setRoles(null);
		
		this.delete(permission);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getPermissions(List<Integer> roleIds) throws ServiceException {
		@SuppressWarnings("rawtypes")
		Set ids = new HashSet(roleIds);
		return permissionRepository.findByRoles(ids);
	}
	
	@Override
	public PermissionList listByCriteria(PermissionCriteria criteria) throws ServiceException {
		return permissionRepository.listByCriteria(criteria);
	}
	
	@Override
	public void removePermission(Permission permission, Role role) throws ServiceException {
		permission = this.getById(permission.getId());//防止附带的实体报错
		
		permission.getRoles().remove(role);
		
	}
	
	@Override
	public List<Permission> listPermission() throws ServiceException {
		return permissionRepository.findAll();
	}

}
