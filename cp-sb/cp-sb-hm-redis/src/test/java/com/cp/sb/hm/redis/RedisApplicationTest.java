package com.cp.sb.hm.redis;

import com.cp.sb.hm.redis.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisApplicationTest {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void redisString(){
        redisTemplate.opsForValue().set("caopei","美女");
        Object name = redisTemplate.opsForValue().get("caopei");
        System.out.println(name);
    }

    //存json
    @Test
    public void redisjson() {
        redisTemplate.opsForValue().set("wuliu",new UserEntity("吴柳",30));
        System.out.println(redisTemplate.opsForValue().get("wuliu"));
    }

    /**************************string*******************************/




}