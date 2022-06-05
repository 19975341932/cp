package com.cp.sb.hm.redis;


import com.cp.sb.hm.redis.entity.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

@SpringBootTest
public class SpringRedisTemplateTest {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void redisString() {
        stringRedisTemplate.opsForValue().set("caopei1234", "美女55");
        Object name = stringRedisTemplate.opsForValue().get("caopei1234");
        System.out.println(name);
    }

    @Test
    public void redisjson() throws JsonProcessingException {
        //创建对象
        UserEntity user = new UserEntity("wo", 12);
        //手动序列化
        String json = mapper.writeValueAsString(user);
        //写入数据
        stringRedisTemplate.opsForValue().set("xiha", json);
        //获取数据
        String value = stringRedisTemplate.opsForValue().get("xiha");
        //手动反序列化
        UserEntity userEntity = mapper.readValue(value, UserEntity.class);
        System.out.println("userEntity =" + userEntity);
    }


    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("user:student", "001", "张三");
        stringRedisTemplate.opsForHash().put("user:student", "002", "李四");
        stringRedisTemplate.opsForHash().put("user:teacher", "001", "王五");

        Map<Object, Object> student = stringRedisTemplate.opsForHash().entries("user:student");
        System.out.println(student);

    }


}
