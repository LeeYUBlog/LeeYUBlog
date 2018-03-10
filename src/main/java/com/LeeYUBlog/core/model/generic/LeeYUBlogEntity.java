package com.LeeYUBlog.core.model.generic;

import java.io.Serializable;
import java.text.Collator;
import java.util.Locale;

import org.hibernate.Hibernate;

import com.LeeYUBlog.core.model.generic.LeeYUBlogEntity;

/**
 * <p>Entity实体通过JPA持久化 </p>
 *
 * @param <E> type of entity
 */
public abstract class LeeYUBlogEntity<K extends Serializable & Comparable<K>, E extends LeeYUBlogEntity<K, ?>>
	implements Serializable, Comparable<E>{

	/**
	 * created by Huinan LUO
	 */
	private static final long serialVersionUID = -3283194803998562264L;
	
	public static final Collator DEFAULT_STRING_COLLATOR = Collator.getInstance(Locale.CHINA);
	
	static{
		DEFAULT_STRING_COLLATOR.setStrength(Collator.PRIMARY);
	}
	
	/**
	 * Return unique ID.
	 * 
	 * @return id
	 */
	public abstract K getId();

	/**
	 * Set unique ID.
	 * 
	 * @param id id
	 */
	public abstract void setId(K id);
	
	/**
	 * 
	 * 
	 * @return isNew or not
	 */
	public boolean isNew() {
		return getId() == null;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (object == this) {
			return true;
		}
		

		if (Hibernate.getClass(object) != Hibernate.getClass(this)) {
			return false;
		}

		LeeYUBlogEntity<K, E> entity = (LeeYUBlogEntity<K, E>) object;
		K id = getId();

		if (id == null) {
			return false;
		}

		return id.equals(entity.getId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		
		K id = getId();
		hash = 31 * hash + ((id == null) ? 0 : id.hashCode());

		return hash;
	}

	public int compareTo(E o) {
		if (this == o) {
			return 0;
		}
		return this.getId().compareTo(o.getId());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("entity.");
		builder.append(Hibernate.getClass(this).getSimpleName());
		builder.append("<");
		builder.append(getId());
		builder.append("-");
		builder.append(super.toString());
		builder.append(">");
		
		return builder.toString();
	}
}
