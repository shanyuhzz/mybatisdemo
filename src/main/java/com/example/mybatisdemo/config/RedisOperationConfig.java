package com.example.mybatisdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@Configuration
public class RedisOperationConfig {
    @Bean
    ValueOperations<String, String> valueOperation(RedisTemplate<String, String> strRedisTemplate){
        return strRedisTemplate.opsForValue();
    }
}
