package com.LeeYUBlog.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.LeeYUBlog.common","com.LeeYUBlog.user"})
@EntityScan(basePackages = {"com.LeeYUBlog.core.model"})
public class ApplicationConfiguration extends WebMvcConfigurerAdapter{
	
}
