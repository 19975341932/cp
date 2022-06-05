package com.cp.sb.hm.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate  redisTemplate;

    @RequestMapping("/test1")
    public Object test1(){
        redisTemplate.opsForValue().set("caopei111","美女");
        Object name = redisTemplate.opsForValue().get("caopei");
        System.out.println(name);
        return name;
    }




}
