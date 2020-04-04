package com.sanhui.synitil.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
@Configuration
@EnableAutoConfiguration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableCaching
public class RedisConfig {
	@Bean
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		CacheManager cacheManager = new RedisCacheManager(redisTemplate);
		return cacheManager;
		/*
		 * RedisCacheManager rcm = new RedisCacheManager(redisTemplate); //
		 * 多个缓存的名称,目前只定义了一个 rcm.setCacheNames(Arrays.asList("thisredis"));
		 * //设置缓存默认过期时间(秒) rcm.setDefaultExpiration(600); return rcm;
		 */
	}
	@Bean(name = "redisTemplate")
	@SuppressWarnings("all")
	public RedisTemplate<String, Object> redisTemplate(
			RedisConnectionFactory factory) {

		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();

		template.setConnectionFactory(factory);

		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(
				Object.class);

		ObjectMapper om = new ObjectMapper();

		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

		jackson2JsonRedisSerializer.setObjectMapper(om);

		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

		// key采用String的序列化方式

		template.setKeySerializer(stringRedisSerializer);

		// hash的key也采用String的序列化方式

		template.setHashKeySerializer(stringRedisSerializer);

		// value序列化方式采用jackson

		template.setValueSerializer(jackson2JsonRedisSerializer);

		// hash的value序列化方式采用jackson
		template.setHashValueSerializer(jackson2JsonRedisSerializer);

		template.afterPropertiesSet();
		//template.setEnableTransactionSupport(true);
		return template;

	}
}
