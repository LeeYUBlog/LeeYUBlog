package com.LeeYUBlog.core.business.services.user;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.business.repositories.user.UserRepository;
import com.LeeYUBlog.core.business.services.common.generic.LeeYUBlogEntityServiceImpl;
import com.LeeYUBlog.core.model.user.User;

@Component("userService")
public class UserServiceImpl extends LeeYUBlogEntityServiceImpl<Long, User>
		implements UserService {


	private UserRepository userRepository;
	
	@Inject
	public UserServiceImpl(UserRepository userRepository) {
		super(userRepository);
		this.userRepository = userRepository;

	}
	
	@Override
	public User getByUserName(String userName) throws ServiceException {
		
		return userRepository.findByUserName(userName);
		
	}
	
	@Override
	public void delete(User user) throws ServiceException {
		
		User u = this.getById(user.getId());
		super.delete(u);
		
	}

	@Override
	public List<User> listUser() throws ServiceException {
		try {
			return userRepository.findAll();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	
	@Override
	public void saveOrUpdate(User user) throws ServiceException {
		
/*		if(user.getId()==null || user.getId().longValue()==0) {
			userDao.save(user);
		} else {
			userDao.update(user);
		}*/
		
		userRepository.save(user);
		
	}

}
