package com.cp.sb.hm.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

//@Configuration    //模拟手动的序列化方式 测试 StringRedisTemplate自带的，不扫这个类 用不上
public class RedisConfig {

   // @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConfiguration){
        //1.创建RedisTemplate对象
        RedisTemplate<String, Object> template =  new RedisTemplate<>();

        //2.设置链接工厂
        template.setConnectionFactory(redisConfiguration);

        //3.创建Json 序列化工具
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();

        //4.设置key序列化
        template.setKeySerializer(RedisSerializer.string());
        template.setHashKeySerializer(RedisSerializer.string());

        //5.设置value-json序列化
        template.setValueSerializer(genericJackson2JsonRedisSerializer);
        template.setHashValueSerializer(genericJackson2JsonRedisSerializer);

        return template;
    }

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
