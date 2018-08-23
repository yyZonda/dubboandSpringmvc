package com.dubbo.yy.RedisConfig;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@ComponentScan(basePackages = "com.dubbo.yy.Hibernate")
@EnableCaching
public class RedisConfig {
    @Bean
    public RedisConnectionFactory redis(){
        return new JedisConnectionFactory();
    }

    @Bean(name = "stringRedisTemplate")
    public StringRedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        return new StringRedisTemplate(redisConnectionFactory);
    }

    @Bean
    public CacheManager cacheManager(StringRedisTemplate stringRedisTemplate){
        return new RedisCacheManager(stringRedisTemplate);
    }

}

