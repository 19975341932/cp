package com.cp.java.cainiao.day01;

import lombok.Data;

@Data
public class HelloWorld {
    //静态变量
    static int a=123;
    //成员变量
    int b;
  //  System.out.println(a); 打印一定要在方法里面

    public void  c(){
        //局部变量
        int c=5;
        System.out.println(c);
    }

    public static void main(String[] args) {
        System.out.println("helloworld");
        System.out.println(a);

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setB(5);
        System.out.println(helloWorld.getB());
        System.out.println();

    }




}
