package com.LeeYUBlog.core.business.services.user;

import java.util.List;

import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.business.services.common.generic.LeeYUBlogEntityService;
import com.LeeYUBlog.core.model.user.User;

public interface UserService extends LeeYUBlogEntityService<Long, User> {
	
	User getByUserName(String userName) throws ServiceException;
	
	List<User> listUser() throws ServiceException;
	
	/**
	 * Create or update a User
	 * @param user
	 * @throws ServiceException
	 */
	void saveOrUpdate(User user) throws ServiceException;

}
