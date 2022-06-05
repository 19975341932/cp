package com.cp.java.test;

public class Test {
    private static int x=10;

    public static void updateValue(int value){
        value = 3 * value;
    }

    public static void main(String[] args) {
        System.out.println("调用前x的值："+x);
        updateValue(x);
        System.out.println("调用后x的值："+x);
    }

}

