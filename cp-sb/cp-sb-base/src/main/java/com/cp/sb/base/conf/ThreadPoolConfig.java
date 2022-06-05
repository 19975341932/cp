package com.cp.sb.base.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * 自定义线程池的配置类
 */

@Configuration
public class ThreadPoolConfig {

    /**
     * ThreadPoolExecutor这个是java里面的类，我不建议使用建议使用下面的ThreadPoolTaskExecutor
     * @param proper
     * @return
     */

/* @Bean
    public ThreadPoolExecutor threadPoolExecutor(ThreadPoolConfigProperties proper){

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                proper.getCore(),
                proper.getMaxThreads(),
                proper.getKeepAlive(),
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(100000),
                Executors.defaultThreadFactory(),
                new java.util.concurrent.ThreadPoolExecutor.AbortPolicy()
        );
      return threadPoolExecutor;
    }*/

    /**
     * https://www.jianshu.com/p/5256027f12c9
     * https://blog.csdn.net/weixin_43168010/article/details/97613895
     * @return
     */
    @Bean("taskExecutor")
    public Executor asyncServiceExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(5);
        // 设置最大线程数
        executor.setMaxPoolSize(20);
        //配置队列大小
        executor.setQueueCapacity(Integer.MAX_VALUE);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(60);
        // 设置默认线程名称
        executor.setThreadNamePrefix("获取旺旺信息");
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //执行初始化
        executor.initialize();
        return executor;
    }
}
