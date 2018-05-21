package com.LeeYUBlog.core.business.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.LeeYUBlog.core.model"})
@ComponentScan({"com.LeeYUBlog.core.business.services","com.LeeYUBlog.core.business.utils"})
@PropertySource("classpath:db.properties")
@Import({DataSourceConfiguration.class,RedisConfiguration.class,GridFsConfiguration.class})
public class CoreApplicationConfiguration {

}
