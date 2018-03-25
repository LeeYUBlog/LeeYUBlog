package com.LeeYUBlog.core.business.services.system;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.business.repositories.system.SystemConfigurationRepository;
import com.LeeYUBlog.core.business.services.common.generic.LeeYUBlogEntityServiceImpl;
import com.LeeYUBlog.core.model.system.SystemConfiguration;

@Service("systemConfigurationService")
public class SystemConfigurationServiceImpl extends 
		LeeYUBlogEntityServiceImpl<Long, SystemConfiguration> implements 
		SystemConfigurationService {
	
	private SystemConfigurationRepository systemConfigurationReposotory;

	@Inject
	public SystemConfigurationServiceImpl(
			SystemConfigurationRepository systemConfigurationReposotory) {
			super(systemConfigurationReposotory);
			this.systemConfigurationReposotory = systemConfigurationReposotory;
	}
	
	public SystemConfiguration getByKey(String key) throws ServiceException {
		return systemConfigurationReposotory.findByKey(key);
	}
}
