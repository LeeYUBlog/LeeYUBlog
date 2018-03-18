package com.LeeYUBlog.core.business.services.common.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeeYUBlog.core.business.exception.ServiceException;
import com.LeeYUBlog.core.model.generic.LeeYUBlogEntity;

/**
 * @param <T> entity type
 */
public abstract class LeeYUBlogEntityServiceImpl<K extends Serializable & Comparable<K>, E extends LeeYUBlogEntity<K, ?>> {
	
	/**
	 * a class of entity, based on six parameters.
	 */
	private Class<E> objectClass;
	
	private JpaRepository<E, K> repository;
	
	@SuppressWarnings("unchecked")
	public LeeYUBlogEntityServiceImpl(JpaRepository<E, K> repository){
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.objectClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
		this.repository = repository;
	}
	
	protected final Class<E> getObjectClass() {
		return objectClass;
	}


	public E getById(K id) {
		return repository.findOne(id);
	}

	
	public void save(E entity) throws ServiceException {
		repository.saveAndFlush(entity);
	}
	
	
	public void create(E entity) throws ServiceException {
		save(entity);
	}

	
	
	public void update(E entity) throws ServiceException {
		save(entity);
	}
	

	public void delete(E entity) throws ServiceException {
		repository.delete(entity);
	}
	
	
	public void flush() {
		repository.flush();
	}
	

	
	public List<E> list() {
		return repository.findAll();
	}
	

	public Long count() {
		return repository.count();
	}
	
}
