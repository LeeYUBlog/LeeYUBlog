package com.LeeYUBlog.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.LeeYUBlog.core.business.configuration.CoreApplicationConfiguration;

@SuppressWarnings("deprecation")
@Configuration
@EnableAutoConfiguration
@Import(CoreApplicationConfiguration.class)
@ComponentScan({"com.LeeYUBlog.common","com.LeeYUBlog.user","com.LeeYUBlog.core.business"})
@EntityScan(basePackages = {"com.LeeYUBlog.core.model"})
public class ApplicationConfiguration extends WebMvcConfigurerAdapter{
	
}
