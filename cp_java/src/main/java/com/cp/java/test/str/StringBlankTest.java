package com.cp.java.test.str;


import cn.hutool.core.util.StrUtil;
import org.springframework.util.StringUtils;

/**
 * 百度： string判空的方法
 * 百度   string判空的工具类  https://blog.csdn.net/shaoming314/article/details/116064280
 */

public class StringBlankTest {

    public static void direct(){
        String a="";
        //1.效率高 最常用
        if(a ==null || a.length() ==0){
            System.out.println("a为空"+1);
        }
        //2.第二种 注意：为空判断 equals "" 中间没有空格
        if (a == null || a.equals("")){
            System.out.println("a为空"+2);
        }

        //3.第三种，使用Spring框架提供的方法来判断，代码比较简洁。 需要引入依赖 rg.apache.commons
        if(StringUtils.isEmpty(a)){
            System.out.println("a为空"+3);
        }

        //4.第四种，使用hutools,引入hutools包的StrUtil类
        if(StrUtil.hasEmpty(a)){
            System.out.println("a为空"+4);
        }
    }


    public static void main(String[] args) {
         StringBlankTest.direct();
    }
}
