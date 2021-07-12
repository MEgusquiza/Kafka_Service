package com.bank.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.bank.model.CreditPayment;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;



//@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
//@EnableRedisRepositories

@Configuration
public class RedisConfig {
	      
        @Bean
		JedisConnectionFactory jedisConnectionFactory() {
			return new JedisConnectionFactory();      	
		}
        
    	@Bean
    	RedisTemplate<String, CreditPayment> redisTemplate() {
    		RedisTemplate<String, CreditPayment> redisTemplate = new RedisTemplate<>();
    		redisTemplate.setConnectionFactory(jedisConnectionFactory());
    		return redisTemplate;
     	}

    	
    /*	 @Bean(name = "template")
    	    public RedisTemplate<String, Object> template(RedisConnectionFactory factory) {
    	        // create RedisTemplate<String, Object>
    	        RedisTemplate<String, Object> template = new RedisTemplate<>();
    	        // Configuring the connection factory
    	        template.setConnectionFactory(factory);
    	        // Define the Jackson2JsonRedisSerializer serialization object
    	        Jackson2JsonRedisSerializer<Object> jacksonSeial = new Jackson2JsonRedisSerializer<>(Object.class);
    	        ObjectMapper om = new ObjectMapper();
    	        // Specify the fields to serialize, field, get and set, and the range of modifiers, ANY is both private and public
    	        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    	        // Specify the type of serialized input, the class must be non-final modified, final modified class, such as String, Integer, etc. will report an exception
    	        om.activateDefaultTyping(

    	                LaissezFaireSubTypeValidator.instance ,
    	                ObjectMapper.DefaultTyping.NON_FINAL,

    	                JsonTypeInfo.As.WRAPPER_ARRAY);
    	        jacksonSeial.setObjectMapper(om);
    	        StringRedisSerializer stringSerial = new StringRedisSerializer();
    	        // redis key Serialization method using stringSerial
    	        template.setKeySerializer(stringSerial);
    	        // redis value serialization method using jackson
    	        template.setValueSerializer(jacksonSeial);
    	        // redis hash key serialized using stringSerial
    	        template.setHashKeySerializer(stringSerial);
    	        // redis hash value serialized using jackson
    	        template.setHashValueSerializer(jacksonSeial);
    	        template.afterPropertiesSet();
    	        return template;
    	    }
    	*/
}
 