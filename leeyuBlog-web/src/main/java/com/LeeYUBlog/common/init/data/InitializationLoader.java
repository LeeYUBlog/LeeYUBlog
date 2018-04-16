package com.LeeYUBlog.common.init.data;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.LeeYUBlog.common.constants.ApplicationConstants;
import com.LeeYUBlog.core.business.constants.SystemConstants;
import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.business.services.reference.init.InitializationDatabase;
import com.LeeYUBlog.core.business.services.system.SystemConfigurationService;
import com.LeeYUBlog.core.business.services.user.PermissionService;
import com.LeeYUBlog.core.business.services.user.RoleService;
import com.LeeYUBlog.core.model.system.SystemConfiguration;
import com.LeeYUBlog.core.model.user.Permission;
import com.LeeYUBlog.core.model.user.Role;
import com.LeeYUBlog.core.model.user.RoleType;
import com.LeeYUBlog.user.admin.model.permission.BlogPermission;
import com.LeeYUBlog.user.admin.model.permission.Permissions;
import com.LeeYUBlog.user.admin.security.WebUserServices;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class InitializationLoader {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InitializationLoader.class);
	
	@Inject
	private InitializationDatabase initializationDatabase;
	
	@Inject
	private InitData initData;
	
	@Inject
	private SystemConfigurationService systemConfigurationService;
	
	@Inject
	private WebUserServices userDetailsService;
	
	@Inject
	protected PermissionService permissionService;
	
	@Inject
	protected RoleService roleService;
	
	@Autowired
	private Environment env;
	
	@Inject
    private ObjectMapper jacksonObjectMapper;
	
	@Inject
    private ResourceLoader resourceLoader;
	
	@Value("${POPULATE_TEST_DATA}")
	private String POPULATE_TEST_DATA;
	
	@PostConstruct
	public void init(){
		
		try {
			if(initializationDatabase.isEmpty()){
				
				File permissionXML = resourceLoader.getResource("classpath:/permission/permission.json").getFile();
				//StreamSource xmlSource = new StreamSource(permissionXML);
				
				Permissions permissions= jacksonObjectMapper.readValue(permissionXML,Permissions.class);
				
				//
				
				LOGGER.info(String.format("%s : LeeYUBlog database is empty, populate it....", "leeyuBlog-web"));
				
				initializationDatabase.populate("leeyuBlog-web");
				
				//security roles and permissions
				
				Map<String, Role> roleMap = new HashMap<String,Role>();
				if(CollectionUtils.isNotEmpty(permissions.getBlogPermission())){
					
					for (BlogPermission blogPermission : permissions.getBlogPermission()) {
						Permission permission = new Permission(blogPermission.getType());
						
						for (String roleName : blogPermission.getBlogRole().getName()) {
							if(roleMap.get(roleName) == null){
								Role role = new Role(roleName);
								role.setRoleType(RoleType.ADMIN);
								
								StringBuilder roleDESC = new StringBuilder();
								role.setDescription(roleDESC.append(roleName).append("角色").toString());
								
								roleService.create(role);
								roleMap.put(roleName, role);
								permission.getRoles().add(role);
							}else{
								permission.getRoles().add(roleMap.get(roleName));
							}
							permissionService.create(permission);
						}
					}
				}
			}
			
			userDetailsService.createDefaultAdmin();
			
			loadData();
			
		}catch (Exception e) {
			LOGGER.error("Error in the init method",e);
		}
	}
	
	private void loadData() throws ServiceException {
		
		String loadTestData = env.getProperty(ApplicationConstants.POPULATE_TEST_DATA);
		boolean loadData =  !StringUtils.isBlank(loadTestData) && loadTestData.equals(SystemConstants.CONFIG_VALUE_TRUE);
		
		if(loadData) {

			SystemConfiguration configuration = systemConfigurationService.getByKey(ApplicationConstants.TEST_DATA_LOADED);

			if(configuration!=null) {
				if(configuration.getKey().equals(ApplicationConstants.TEST_DATA_LOADED)) {
					if(configuration.getValue().equals(SystemConstants.CONFIG_VALUE_TRUE)) {
						return;
					}
				}
			}

			initData.initInitialData();

			configuration = new SystemConfiguration();
			configuration.getAuditSection().setModifiedBy(SystemConstants.SYSTEM_USER);
			configuration.setKey(ApplicationConstants.TEST_DATA_LOADED);
			configuration.setValue(SystemConstants.CONFIG_VALUE_TRUE);
			systemConfigurationService.create(configuration);


		}
	}
}
