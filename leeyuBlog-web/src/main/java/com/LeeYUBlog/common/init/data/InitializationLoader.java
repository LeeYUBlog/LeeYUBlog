package com.LeeYUBlog.common.init.data;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.LeeYUBlog.common.constants.ApplicationConstants;
import com.LeeYUBlog.common.constants.Constants;
import com.LeeYUBlog.core.business.constants.SystemConstants;
import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.business.services.system.SystemConfigurationService;
import com.LeeYUBlog.core.business.services.user.RoleService;
import com.LeeYUBlog.core.model.system.SystemConfiguration;
import com.LeeYUBlog.core.model.user.Role;
import com.LeeYUBlog.core.model.user.RoleType;
import com.LeeYUBlog.user.admin.security.WebUserServices;


@Component
public class InitializationLoader {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InitializationLoader.class);
	
	@Inject
	private InitData initData;
	
	@Inject
	private SystemConfigurationService systemConfigurationService;
	
	@Inject
	private WebUserServices userDetailsService;
	
	@Inject
	protected RoleService roleService;
	
	@Autowired
	private Environment env;
	
	@Value("${POPULATE_TEST_DATA}")
	private String POPULATE_TEST_DATA;
	
	@PostConstruct
	public void init(){
		
		try {
			if(POPULATE_TEST_DATA.equals(SystemConstants.CONFIG_VALUE_TRUE)){
				Role role = new Role(Constants.ROLE_ADMIN);
				role.setRoleType(RoleType.ADMIN);
	            roleService.create(role);
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
