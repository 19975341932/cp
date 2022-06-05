package com.cp.common.hutool.datatime;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;

public class TimeIntervals {
    /**
     * 计数器  TimeInterval实现计时器功能，即可以计算方法或过程执行的时间。
     */
    public static void main(String[] args) {

        TimeInterval timer = DateUtil.timer();
        System.out.println("执行中");
        int i= 2;
        i++;
        i= ++i;
        System.out.println(timer.interval()); //花费毫秒数
        System.out.println(timer.intervalRestart());
        System.out.println(timer.intervalMinute());//花费分钟数


        System.out.println("****************    分组计时       **********************");
        final TimeInterval time = new TimeInterval();
        // 分组1
        time.start("1");
        ThreadUtil.sleep(800);

        // 分组2
        time.start();
        ThreadUtil.sleep(900);

        Console.log("Timer 1 took {} ms", timer.intervalMs("1"));
        Console.log("Timer 2 took {} ms", timer.intervalMs("2"));

    }


}