package com.LeeYUBlog.core.business.repositories.system;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeeYUBlog.core.model.system.SystemConfiguration;

public interface SystemConfigurationRepository extends JpaRepository<SystemConfiguration, Long> {
	
	SystemConfiguration findByKey(String key);

}
