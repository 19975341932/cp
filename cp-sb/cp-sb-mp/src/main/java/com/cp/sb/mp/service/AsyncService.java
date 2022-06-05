package com.cp.sb.mp.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async("taskExecutor")  //不要忘记了哦
    public void testAsync(){
        System.out.println("我是异步执行，我叫:"+Thread.currentThread().getName());
    }
}
