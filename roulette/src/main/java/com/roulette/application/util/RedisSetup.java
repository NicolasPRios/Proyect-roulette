package com.roulette.application.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * This class allow to setup the connection to Redis
 * @author Nicolas Palacios Rios
 * @version 1.0
 */
@Configuration
@EnableRedisRepositories
public class RedisSetup {
	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {

		return new LettuceConnectionFactory();
	}

	@Bean
	public RedisTemplate<?, ?> redisTemplate() {
		RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory());

		return template;
	}
}