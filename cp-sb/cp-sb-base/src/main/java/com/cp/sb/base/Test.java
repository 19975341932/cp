package com.cp.sb.base;

public class Test {
    public static void main(String[] args) {
        String a="123";
        String b="123";
        String c=new String("123");
        System.out.println(a==b); // true
        System.out.println(a==c); //faslse
    }
}
