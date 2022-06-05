package com.cp.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil {

    public static final String FORMAT_YY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_YY_MM_DD = "yyyy-MM-dd";


    /**
     * 获取当前时间 且制定的时间格式
     * @return
     */
    public static String getYear() {
        return formatDate(new Date(), FORMAT_YY_MM_DD_HH_MM_SS);
    }

    /**
     * 获取指定时间 且制定的时间格式SimpleDateFormat
     * @return
     */
    public static String getYear(Date date) {
        return formatDate(date, "yyyy");
    }

    /**
     * 获取指定时间 且制定的时间格式SimpleDateFormat
     * @return
     */
    public static String formatDate(Date date, String formatStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
        String format = simpleDateFormat.format(date);
        return format;
    }

    //相隔多少天 Date.getTime()拿到时间戳 /13位的毫秒数=多少天
    public static long diffDays(Date start,Date end){
        return (end.getTime()-start.getTime())/(24*60*60*1000);
    }

    /**
     * 把制定日期转化为指定格式
     * @param date
     * @param pattern
     * @return
     */
    public static String getTimeStr(Date date,String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String format = simpleDateFormat.format(date);
        return format;
    }

    /**
     * 把字符串转化为日期格式
     */

    public static Date getDate(String data,String pattern) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(data);
    }

    //时间前后
    public static boolean before(Date start, Date end){
        //start<end 整理就返回true
        return start.getTime()<end.getTime();
    }

    /**
     * 获取当前时间戳
     *
     */
    public static long getSystemTime(Date date){
         return date.getTime();
    }

    /**
     * 获得两个时间差
     */
    public static Long diffTime(String start, String end) throws ParseException {
       SimpleDateFormat format =new SimpleDateFormat(FORMAT_YY_MM_DD_HH_MM_SS);
        Date end1 = format.parse(end);
        Date start1=format.parse(start);
        return end1.getTime()-start1.getTime();
    }

    /**
     * 将long类型的值转化为制定格式FORMAT_YY_MM_DD_HH_MM_SS
     */
    public static String tranLongByTime(Long timestr) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YY_MM_DD_HH_MM_SS);
        //如果传入的是String类型就需要 new Date(Long.parseLong(timestr));
        Date date = new Date(timestr);
        return simpleDateFormat.format(date);



    }






}
