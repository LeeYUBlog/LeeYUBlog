package com.LeeYUBlog.core.business.services.reference.language;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.business.services.common.generic.LeeYUBlogEntityService;
import com.LeeYUBlog.core.model.reference.language.Language;

public interface LanguageService extends LeeYUBlogEntityService<Integer, Language> {
	
	Language getByCode(String code) throws ServiceException;

	Map<String, Language> getLanguagesMap() throws ServiceException;

	List<Language> getLanguages() throws ServiceException;

	Locale toLocale(Language language);

	Language toLanguage(Locale locale);
	
	Language defaultLanguage();
}
