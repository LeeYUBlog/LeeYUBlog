package com.LeeYUBlog.core.business.services.common.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.LeeYUBlog.core.business.exception.ServiceException;


/**
 * <p>Service root for the management entities.</p>
 *
 * @param <T> type the entity
 */
public interface LeeYUBlogEntityService<K extends Serializable & Comparable<K>, E extends com.LeeYUBlog.core.model.generic.LeeYUBlogEntity<K, ?>> extends TransactionalAspectAwareService {
	
	void save(E entity) throws ServiceException;
	
	void update(E entity) throws ServiceException;
	
	void create(E entity) throws ServiceException;
	
	void delete(E entity) throws ServiceException;
	
	E getById(K id);
	
	List<E> list();
	
	Long count();
	
	void flush();
}
