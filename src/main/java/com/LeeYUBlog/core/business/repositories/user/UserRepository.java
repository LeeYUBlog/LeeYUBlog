package com.LeeYUBlog.core.business.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.LeeYUBlog.core.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User as u inner join fetch u.roles ur where u.adminName = ?1")
	User findByUserName(String userName);

	@Query("select u from User as u inner join fetch u.roles ur where u.id = ?1")
	User findOne(Long id);
	
	@Query("select u from User as u inner join fetch u.roles ur order by u.id")
	List<User> findAll();
}
