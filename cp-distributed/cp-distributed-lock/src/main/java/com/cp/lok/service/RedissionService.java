package com.cp.lok.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class RedissionService {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //创建订单
    public Boolean createOrder(Long productid) {
        String key_lock = "dec_store_lock_" + productid;
        String key_stock = "dec_store_" + productid;
        RLock lock = redissonClient.getLock(key_lock);
        //加锁
        try {
            lock.lock();
            //校验
            String s = stringRedisTemplate.opsForValue().get(key_stock);
            if (StringUtils.isEmpty(s)) {
                log.warn("下单失败");
                return false;
            }
            int stock = Integer.parseInt(s);
            if (stock <= 0) {
                log.warn("下单失败");
                return false;
            }
            //减库存
            stock = stock - 1;
            stringRedisTemplate.opsForValue().set(key_stock, String.valueOf(stock));
            System.out.println("下单成功");
        } finally {
            //释放锁
            lock.unlock();
        }
        return true;
    }

}
