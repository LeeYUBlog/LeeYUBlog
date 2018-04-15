package com.LeeYUBlog.core.business.services.reference.init;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.business.services.reference.language.LanguageService;
import com.LeeYUBlog.core.constants.SchemaConstant;
import com.LeeYUBlog.core.model.reference.language.Language;

@Service("initializationDatabase")
public class InitializationDatabaseImpl implements InitializationDatabase {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InitializationDatabaseImpl.class);
	
	@Inject
	private LanguageService languageService;
	
	private String name;

	@Override
	public boolean isEmpty() {
		return languageService.count() == 0;
	}

	@Transactional
	public void populate(String contextName) throws ServiceException {
		this.name = contextName;
		
		createLanguages();
	}
	
	private void createLanguages() throws ServiceException{
		LOGGER.info(String.format("%s : Populating Languages ", name));
		for (String code : SchemaConstant.LANGUAGE_ISO_CODE) {
			Language language = new Language(code);
			languageService.create(language);
		}
	}
}
