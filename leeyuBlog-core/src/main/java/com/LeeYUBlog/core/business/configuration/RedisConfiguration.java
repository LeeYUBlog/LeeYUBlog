package com.LeeYUBlog.core.business.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories("com.LeeYUBlog.core.business.repositories")
public class RedisConfiguration {
	
	@Autowired
	private RedisConnectionFactory redisConnectionFactory;
	
	@Bean
	public StringRedisTemplate redisTemplate() {
	  StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory);
	  // explicitly enable transaction support
	  template.setEnableTransactionSupport(true);
	  return template;
	}
	
	/*@Bean
	public RedisCustomConversions redisCustomConversions(){
	    return new RedisCustomConversions(Arrays.asList(new AddressToBytesConverter(), new BytesToAddressConverter()));
	}
	
	@WritingConverter
	public static class AddressToBytesConverter implements Converter<Address, byte[]> {

	  private final Jackson2JsonRedisSerializer<Address> serializer;

	  public AddressToBytesConverter() {

	    serializer = new Jackson2JsonRedisSerializer<Address>(Address.class);
	    serializer.setObjectMapper(new ObjectMapper());
	  }

	  @Override
	  public byte[] convert(Address value) {
	    return serializer.serialize(value);
	  }
	}

	@ReadingConverter
	public static class BytesToAddressConverter implements Converter<byte[], Address> {

	  private final Jackson2JsonRedisSerializer<Address> serializer;

	  public BytesToAddressConverter() {

	    serializer = new Jackson2JsonRedisSerializer<Address>(Address.class);
	    serializer.setObjectMapper(new ObjectMapper());
	  }

	  @Override
	  public Address convert(byte[] value) {
	    return serializer.deserialize(value);
	  }
	}*/
}
