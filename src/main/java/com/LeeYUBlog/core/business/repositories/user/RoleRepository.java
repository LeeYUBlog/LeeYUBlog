package com.LeeYUBlog.core.business.repositories.user;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.LeeYUBlog.core.model.user.Role;
import com.LeeYUBlog.core.model.user.RoleType;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	@Query("select distinct r from Role as r where r.id in (?1) ")
	List<Role> findByIds(Set<Integer> roleIds);
	
	@Query("select distinct r from Role as r where r.roleType = ?1")
	List<Role> findByType(RoleType type);
}
