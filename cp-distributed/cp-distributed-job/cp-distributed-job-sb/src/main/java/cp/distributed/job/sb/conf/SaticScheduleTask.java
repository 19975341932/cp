package cp.distributed.job.sb.conf;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;

/**
 *https://blog.csdn.net/qq_18432653/article/details/107810980
 * 基于注解
 */

@Configuration
public class SaticScheduleTask {

    //添加定时任务
    @Scheduled(cron = "0/5 * * * * ?")  //每5s执行一次，启动代码后 每5s执行一次
    private void configjob(){
        System.out.println("静态执行定时任务时间"+ LocalDate.now());

    }



}
