package com.LeeYUBlog.user.admin.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.LeeYUBlog.common.constants.Constants;
import com.LeeYUBlog.core.business.constants.SystemConstants;
import com.LeeYUBlog.core.business.services.user.PermissionService;
import com.LeeYUBlog.core.business.services.user.RoleService;
import com.LeeYUBlog.core.business.services.user.UserService;
import com.LeeYUBlog.core.model.user.Permission;
import com.LeeYUBlog.core.model.user.Role;
import com.LeeYUBlog.core.model.user.RoleType;


/**
 * 
 * @author huinan
 *         
 */
@Service("userDetailsService")
public class UserServicesImpl implements WebUserServices {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServicesImpl.class);
	
	private static final String DEFAULT_INITIAL_PASSWORD = "admin";
	
	@Value("${POPULATE_TEST_DATA}")
	private String POPULATE_TEST_DATA;
	
	@Inject
	private UserService userService;
	
	//@Inject
	//@Named("passwordEncoder")
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
	
	@Inject
	protected PermissionService  permissionService;
	
	@Inject
	protected RoleService roleService;
	
	public final static String ROLE_PREFIX = "ROLE_";//Spring Security 4
	
	@Cacheable(value = "user")
	@Override
	public UserDetails loadUserByUsername(String userName) 
			throws UsernameNotFoundException, DataAccessException {
		
		com.LeeYUBlog.core.model.user.User user = null;
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		try{
			
			user = userService.getByUserName(userName);
			
			if(user==null) {
				return null;
			}
			
			GrantedAuthority authority = new SimpleGrantedAuthority(ROLE_PREFIX + Constants.PERMISSION_AUTHENTICATED);//required to login
			authorities.add(authority);
			
			List<Integer> rolesId = new ArrayList<Integer>();
			List<Role> roles = user.getRoles();
			for(Role role: roles){
				
				rolesId.add(role.getId());
				
			}
			
			List<Permission> permissions = permissionService.getPermissions(rolesId);
			for(Permission permission : permissions) {
	    		GrantedAuthority auth = new SimpleGrantedAuthority(ROLE_PREFIX + permission.getPermissionName());
	    		authorities.add(auth);
	    	}
			
		}catch (Exception e) {
			LOGGER.error("Exception while querrying user",e);
			throw new SecurityDataAccessException("Exception while querrying user",e);
		}
		
		User secUser = new User(userName, user.getAdminPassword(), user.isActive(), true,
				true, true, authorities);
		return secUser;
	}

	@Override
	public void createDefaultAdmin() throws Exception {
		
		//TODO create all groups and permissions
			
		String password = passwordEncoder.encode(DEFAULT_INITIAL_PASSWORD);
		
		List<Role> roles = roleService.listRole(RoleType.ADMIN);
		//creation of the super admin admin:admin)
		com.LeeYUBlog.core.model.user.User user = new com.LeeYUBlog.core.model.user.User("admin",password);
		user.setFirstName("Huinan");
		user.setLastName("LUO");
		
		for(Role role : roles) {
			if(role.getRoleName().equals(Constants.ROLE_SUPERADMIN) || role.getRoleName().equals(Constants.ROLE_ADMIN)) {
				user.getRoles().add(role);
			}
		}
		if(POPULATE_TEST_DATA.equals(SystemConstants.CONFIG_VALUE_TRUE)){			
			userService.create(user);
		}
	}

}
