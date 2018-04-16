package com.LeeYUBlog.core.business.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.LeeYUBlog.core.business.repositories")
@EnableTransactionManagement
public class DataSourceConfiguration {
	
	@Autowired
	private LocalContainerEntityManagerFactoryBean LocalContainerEntityManagerFactoryBean;
	/*@Autowired
	private DataSource dataSource;*/
	
	
	@Bean
	public PlatformTransactionManager transactionManager() {
	
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(LocalContainerEntityManagerFactoryBean.getObject());
	    return txManager;
	}
}
