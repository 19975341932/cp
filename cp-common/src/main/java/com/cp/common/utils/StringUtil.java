package com.cp.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类 StringUtils,pom中 引入org.apache.commons.lang3.StringUtils;
 *
 * StringUtils-----集合类
 */
public class StringUtil {
    public static void main(String[] args) {
        String a = " ";
        String b = null;
        System.out.println(StringUtils.isBlank(b));//StringUtils工具类 类.方法
        System.out.println(StringUtils.isEmpty(a));//false  isEmpty（）"  "不为空
        System.out.println(StringUtils.isEmpty(b));


    }
}
