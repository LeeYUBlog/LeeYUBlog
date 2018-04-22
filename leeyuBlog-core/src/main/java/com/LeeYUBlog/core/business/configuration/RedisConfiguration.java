package com.LeeYUBlog.core.business.configuration;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {
	
	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory){
		return RedisCacheManager.create(connectionFactory);
	}
	/*@Bean
	public RedisCustomConversions redisCustomConversions(){
	    return new RedisCustomConversions(Arrays.asList(new UserToBytesConverter(), new BytesToUserConverter()));
	}
	
	@WritingConverter
	public static class UserToBytesConverter implements Converter<User, byte[]> {

	  private final Jackson2JsonRedisSerializer<User> serializer;

	  public UserToBytesConverter() {

	    serializer = new Jackson2JsonRedisSerializer<User>(User.class);
	    serializer.setObjectMapper(new ObjectMapper());
	  }

	  @Override
	  public byte[] convert(User value) {
	    return serializer.serialize(value);
	  }
	}

	@ReadingConverter
	public static class BytesToUserConverter implements Converter<byte[], User> {

	  private final Jackson2JsonRedisSerializer<User> serializer;

	  public BytesToUserConverter() {

	    serializer = new Jackson2JsonRedisSerializer<User>(User.class);
	    serializer.setObjectMapper(new ObjectMapper());
	  }

	  @Override
	  public User convert(byte[] value) {
	    return serializer.deserialize(value);
	  }
	}*/
}
