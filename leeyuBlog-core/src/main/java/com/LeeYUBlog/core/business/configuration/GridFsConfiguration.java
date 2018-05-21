package com.LeeYUBlog.core.business.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.MongoClient;

@Configuration
public class GridFsConfiguration extends AbstractMongoConfiguration {

	@Override
	public @Bean MongoClient mongoClient() {
		return new MongoClient("localhost");
	}

	@Override
	protected String getDatabaseName() {
		return "database";
	}
	
	public @Bean MongoDbFactory mongoDbFactory() {
	    return new SimpleMongoDbFactory(mongoClient(), "database");
	}
	
	@Bean
    @Override
    public MappingMongoConverter mappingMongoConverter() throws Exception {
      MappingMongoConverter mmc = super.mappingMongoConverter();
      return mmc;
    }
	//GridFsTemplate配置
	@Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
      return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }
}
