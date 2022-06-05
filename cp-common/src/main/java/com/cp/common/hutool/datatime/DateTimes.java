package com.cp.common.hutool.datatime;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;

import java.util.Date;

public class DateTimes {
    public static void main(String[] args) {
        Date date = new Date();
        //new方式创建
        DateTime dateTime1 = new DateTime(date);
        System.out.println(dateTime1);

        DateTime now = DateTime.now();
        System.out.println(now);

        //of方式创建
        DateTime of = DateTime.of(date);
        System.out.println(of);

        /**
         * DateTime对象默认是可变对象（调用offset、setField、setTime方法默认变更自身），但是这种可变性有时候会引起很多问
         * 题（例如多个地方共用DateTime对象）。我们可以调用setMutable(false)方法使其变为不可变对象。在不可变模式下，offset、
         * setField方法返回一个新对象，setTime方法抛出异常。
         */

        DateTime dateTime = new DateTime("2017-01-05 12:34:23", DatePattern.NORM_DATETIME_FORMAT);
        //默认情况下DateTime为可变对象，此时offset == dateTime
        System.out.println(dateTime.offset(DateField.YEAR, 2));
        //设置为不可变对象后变动将返回新对象，此时offset != dateTime
        dateTime.setMutable(false);
        System.out.println(dateTime.offset(DateField.YEAR, 2));


    }

}
