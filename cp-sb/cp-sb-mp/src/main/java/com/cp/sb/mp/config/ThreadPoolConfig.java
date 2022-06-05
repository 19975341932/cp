package com.cp.sb.mp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class ThreadPoolConfig {


    /**
     * springboot定义ThreadpoolTaskExecutor
     * @return
     */
    @Bean("taskExecutor") //线程池名称
    public Executor asyncServiceExecutor() {

        //获取当前主机cpu核数
        final int cpuCount = Runtime.getRuntime().availableProcessors();
        //springboot基于ThreadPoolExecutor实现的一个线程池执行类
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //设置核心线程数量
        executor.setCorePoolSize(cpuCount);
        //设置最大线程数量
        executor.setMaxPoolSize(cpuCount * 2);
        //设置队列长度
        executor.setQueueCapacity(100);
        //设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(60);
        //设置默认线程名称前缀
        executor.setThreadNamePrefix("myBlog--");
        //等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //除此之外，还有许多可以配置的，比如拒绝策略等等
        //初始化
        executor.initialize();
        return executor;


    }


}
