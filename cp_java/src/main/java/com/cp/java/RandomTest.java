package com.cp.java;

import java.util.Random;

public class RandomTest {

    public static final String URL="url1,url2,url3";


    public static void main(String[] args) {
        String[] split = URL.split(",");

        Random random = new Random();
        //[0,30)的随机整数,即：[0,29]
        int i = random.nextInt(30);
        //生成89到152的随机数[89-152] 假设随机数为0 那么就是89 152-89=63，所以nextInt(63)+ 89范围【89，152）所以nextInt(64)
        int r= random.nextInt(64)+ 89;
        System.out.println(r);
        i =i%split.length;

        System.out.println(split[i]);

    }


}
