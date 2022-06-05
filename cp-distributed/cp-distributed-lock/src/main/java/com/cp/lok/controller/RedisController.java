package com.cp.lok.controller;


import com.cp.lok.service.RedissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/redission")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedissionService redissionService;

    @RequestMapping("/save")
    public String save(){
       stringRedisTemplate.opsForValue().set("cao","redission");
       return "save ok";
    }
    @RequestMapping("/get")
    public String get(){
        return stringRedisTemplate.opsForValue().get("cao");
    }

    /**
     * localhost:5656/redission/1/10
     * 设置库存
     * @return
     */
    @RequestMapping("/{productId}/{stock}")
    public String save(@PathVariable("productId")Long productId, @PathVariable("stock") Long stock){
        String key = "dec_store_" + productId;
        stringRedisTemplate.opsForValue().set(key, String.valueOf(stock));
        System.out.println(stringRedisTemplate.opsForValue().get(key));
        return "save ok";
    }

    /**
     * localhost:5656/redission/createOrderTest/1
     * 秒杀
     * @return
     */
    @RequestMapping("/createOrderTest/{productId}")
    public Map<String, Object> createOrderTest(@PathVariable("productId")Long productId){
        HashMap hashMap = new HashMap();
        hashMap.put("data", redissionService.createOrder(productId));
        return hashMap;
    }

}
