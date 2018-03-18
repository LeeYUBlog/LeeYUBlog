package com.LeeYUBlog.core.business.services.user;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.business.repositories.user.RoleRepository;
import com.LeeYUBlog.core.business.services.common.generic.LeeYUBlogEntityServiceImpl;
import com.LeeYUBlog.core.model.user.Role;
import com.LeeYUBlog.core.model.user.RoleType;

@Service("roleService")
public class RoleServiceImpl extends 
		LeeYUBlogEntityServiceImpl<Integer, Role> implements RoleService {
	
	RoleRepository roleRepository;

	@Inject
	public RoleServiceImpl(RoleRepository roleRepository) {
		super(roleRepository);
		this.roleRepository = roleRepository;

	}

	@Override
	public List<Role> listRole(RoleType roleType) throws ServiceException {
		try {
			return roleRepository.findByType(roleType);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Role> listRoleByIds(Set<Integer> ids) throws ServiceException {
		try {
			return roleRepository.findByIds(ids);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
