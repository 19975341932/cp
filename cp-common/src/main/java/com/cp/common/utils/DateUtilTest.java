package com.cp.common.utils;

import java.text.ParseException;
import java.util.Date;

import static com.cp.common.utils.DateUtil.getSystemTime;


public class DateUtilTest {
    public static void main(String[] args) throws ParseException {
        System.out.println(DateUtil.getYear());
        System.out.println(DateUtil.getYear(new Date()));
        Date start = new Date(System.currentTimeMillis()-3*24*60*60*1000);
        Date end = new Date();
        System.out.println(DateUtil.diffDays(start, end));

        System.out.println(DateUtil.getTimeStr(new Date(), DateUtil.FORMAT_YY_MM_DD));

        System.out.println(DateUtil.getDate("2022-04-13 22:33",DateUtil.FORMAT_YY_MM_DD_HH_MM));

        //当前时间减去5天
        Date end5= new Date(System.currentTimeMillis()-(5*24*60*60*1000));
        System.out.println(DateUtil.before(new Date(), end5));
        // 1649915911350  1649915936280
        System.out.println(getSystemTime(new Date()));

        System.out.println(DateUtil.diffTime("2022-03-14 14:15:27", "2022-04-10 14:15:27"));

        //1972-01-28 08:00:00 是以格林时间为基准的
        String s = DateUtil.tranLongByTime(DateUtil.diffTime("2020-03-14 14:15:27", "2022-04-10 14:15:27"));
        System.out.println(s);

    }
}
