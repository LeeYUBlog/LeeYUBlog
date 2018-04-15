package com.LeeYUBlog.common.init.data;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.business.services.reference.language.LanguageService;

@Component
public class InitStoreData implements InitData {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InitStoreData.class);

	@Inject
	protected LanguageService languageService;
	
	public void initInitialData() throws ServiceException {
		

		LOGGER.info("Starting the initialization of test data");
		//Date date = new Date(System.currentTimeMillis());
		
		//2 languages by default
		/*Language en = languageService.getByCode("en");
		Language ch = languageService.getByCode("ch");*/
		
			
		LOGGER.info("Ending the initialization of test data");
		
	}

}
