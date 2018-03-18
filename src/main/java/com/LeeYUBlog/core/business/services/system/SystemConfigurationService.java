package com.LeeYUBlog.core.business.services.system;

import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.business.services.common.generic.LeeYUBlogEntityService;
import com.LeeYUBlog.core.model.system.SystemConfiguration;

public interface SystemConfigurationService extends

	LeeYUBlogEntityService<Long, SystemConfiguration>{
	
	SystemConfiguration getByKey(String key) throws ServiceException;
	
}
