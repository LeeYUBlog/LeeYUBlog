package com.LeeYUBlog.core.business.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.LeeYUBlog.core.model"})
@ComponentScan({"com.LeeYUBlog.core.business.services","com.LeeYUBlog.core.business.utils"})
@EnableJpaRepositories("com.LeeYUBlog.core.business.repositories")
@PropertySource("classpath:db.properties")
public class CoreApplicationConfiguration {

}
