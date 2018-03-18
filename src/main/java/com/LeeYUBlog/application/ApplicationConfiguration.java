package com.LeeYUBlog.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.LeeYUBlog.common","com.LeeYUBlog.user","com.LeeYUBlog.core.business","com.LeeYUBlog.core.business.services","com.LeeYUBlog.core.business.utils"})
@EntityScan(basePackages = {"com.LeeYUBlog.core.model"})
@EnableJpaRepositories("com.LeeYUBlog.core.business.repositories")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter{
	
}
