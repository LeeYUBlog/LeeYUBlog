package com.LeeYUBlog.core.business.services.reference.init;

import com.LeeYUBlog.core.business.exception.ServiceException;

public interface InitializationDatabase {
	
	boolean isEmpty();
	
	void populate(String name) throws ServiceException;
	
}
