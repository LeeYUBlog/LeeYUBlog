package com.LeeYUBlog.core.business.repositories.reference.language;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.model.reference.language.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
	
	Language findByCode(String code) throws ServiceException;

}
