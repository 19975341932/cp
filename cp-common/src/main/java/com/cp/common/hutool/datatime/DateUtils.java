package com.cp.common.hutool.datatime;


import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static void main(String[] args) {
        //当前时间    //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        DateTime date1 = DateUtil.date();
        System.out.println(date1);

        System.out.println(DateUtil.date(Calendar.getInstance()));

        DateTime date2 = DateUtil.date(System.currentTimeMillis());
        System.out.println(date2);

        System.out.println(DateUtil.now());

        //当前日期字符串，格式：yyyy-MM-dd
        System.out.println(DateUtil.today());

        System.out.println("**********************       字符串转日期        ******************************************");
        String dateStr1 = "2017-03-01 05:25:5";
        System.out.println(DateUtil.parse(dateStr1,"yyyy-MM-dd HH:mm:ss"));



        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr);

     //结果 2017/03/01
        String format = DateUtil.format(date, "yyyy/MM/dd");

      //常用格式的格式化，结果：2017-03-01
        String formatDate = DateUtil.formatDate(date);

          //结果：2017-03-01 00:00:00
        String formatDateTime = DateUtil.formatDateTime(date);

         //结果：00:00:00
        String formatTime = DateUtil.formatTime(date);



        System.out.println("**********************       获取Date对象的某个部分        ******************************************");
     //   获得月份，从0开始计数
        System.out.println(DateUtil.date().month());

        System.out.println(DateUtil.date().year());

        //获得月份枚举
        System.out.println(DateUtil.monthEnum(DateUtil.date()));

        System.out.println("***************** 有的时候我们需要获得每天的开始时间、结束时间，每月的开始和结束时间等等，DateUtil也提供了相关方法 ********");

        String dateStr2 = "2022-02-05 22:33:23";
        Date da = DateUtil.parse(dateStr2);

        System.out.println(DateUtil.beginOfMonth(da));
        System.out.println(DateUtil.endOfMonth(da));
        System.out.println(DateUtil.beginOfYear(da));
        System.out.println(DateUtil.beginOfDay(da));

        System.out.println("*******************日期或时间的偏移指针对某个日期增加或减少分、小时、天等等，达到日期变更的目的*******************");
        System.out.println(DateUtil.offset(da, DateField.DAY_OF_MONTH, 2)); //负数向前，正数向后 DAY_OF_MONTH 月中的天数往后移动2天
        //常用偏移，结果：2022-02-05 19:33:23
        System.out.println(DateUtil.offsetHour(da, -3));

        //针对当前时间，提供了简化的偏移方法（例如昨天、上周、上个月等）;
        System.out.println(DateUtil.lastMonth());
        System.out.println(DateUtil.nextWeek());
        System.out.println(DateUtil.yesterday());

        //相差一个月，31天
        long betweenDay = DateUtil.between(date1, da, DateUnit.DAY);
        System.out.println(betweenDay);

        //年龄
        System.out.println(DateUtil.ageOfNow("1995-8-30"));

        ////是否闰年
        System.out.println(DateUtil.isLeapYear(2017));

    }


}
