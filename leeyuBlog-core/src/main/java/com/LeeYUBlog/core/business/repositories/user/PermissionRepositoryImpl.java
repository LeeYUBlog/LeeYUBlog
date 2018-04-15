package com.LeeYUBlog.core.business.repositories.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.LeeYUBlog.core.model.user.Permission;
import com.LeeYUBlog.core.model.user.PermissionCriteria;
import com.LeeYUBlog.core.model.user.PermissionList;

public class PermissionRepositoryImpl implements PermissionRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public PermissionList listByCriteria(PermissionCriteria criteria) {
		PermissionList permissionList = new PermissionList();
		
		//使用StringBuilder可以提高字符串拼接效率
		StringBuilder countBuilderSelect = new StringBuilder();
		countBuilderSelect.append("select count(p) from Permission as p");
		
		StringBuilder countBuilderWhere = new StringBuilder();
		
		if(criteria.getRoleIds()!=null && criteria.getRoleIds().size()>0) {
			countBuilderSelect.append(" INNER JOIN p.roles rols");
			countBuilderWhere.append(" where rols.id in (:cid)");
		}
		
		StringBuilder countBuilderTotal = new StringBuilder();
		
		Query countQ = em.createQuery(
				countBuilderTotal.append(countBuilderSelect.toString()).append(countBuilderWhere.toString()).toString());
		
		if(criteria.getRoleIds()!=null && criteria.getRoleIds().size()>0) {
			countQ.setParameter("cid", criteria.getRoleIds());
		}
		
		Number count = (Number) countQ.getSingleResult();
		
		permissionList.setTotalCount(count.intValue());
		
		if(count.intValue()==0)
        	return permissionList;
		
		StringBuilder qs = new StringBuilder();
		qs.append("select p from Permission as p ");
		qs.append("join fetch p.roles rols ");
		
		if(criteria.getRoleIds()!=null && criteria.getRoleIds().size()>0) {
			qs.append(" where rols.id in (:cid)");
		}
		
		qs.append(" order by p.id asc ");
		
		String hql = qs.toString();
		Query q = em.createQuery(hql);
		
		if(criteria.getRoleIds()!=null && criteria.getRoleIds().size()>0) {
    		q.setParameter("cid", criteria.getRoleIds());
    	}
		
		if(criteria.getMaxCount()>0) {
			
			q.setFirstResult(criteria.getStartIndex());
			if(criteria.getMaxCount()<count.intValue()) {
	    		q.setMaxResults(criteria.getMaxCount());
	    		permissionList.setTotalCount(criteria.getMaxCount());
	    	}else{
	    		q.setMaxResults(count.intValue());
	    		permissionList.setTotalCount(count.intValue());
	    	}
		}
		
		List<Permission> permissions =  q.getResultList();
		permissionList.setPermissions(permissions);
		
		return permissionList;
	}

}
