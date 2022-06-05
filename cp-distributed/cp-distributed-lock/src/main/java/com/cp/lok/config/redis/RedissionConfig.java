package com.cp.lok.config.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissionConfig {

    @Autowired
    private RedisProperties redisProperties;

    public RedissonClient redissonClient(){
        Config config = new Config();

        /* 格式化 url=ip+端口*/
        String redisUrl = String.format("redis://%s:%s", redisProperties.getHost() + "", redisProperties.getPort() + "");

        config.useSingleServer().setAddress(redisUrl).setPassword(redisProperties.getPassword());
        config.useSingleServer().setDatabase(0);

        return Redisson.create(config);

    }
}
