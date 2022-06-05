package com.cp.java.cainiao.day01;

public class OrderStatusEnumTest {

    public static void main(String[] args) {
        System.out.println(OrderStatusEnum.getStatusByCode(5));
        System.out.println(OrderStatusEnum.getEnumByCode(5));

        //枚举对象都是单例
        OrderStatusEnum enum3_1 = OrderStatusEnum.getEnumByCode(3);
        OrderStatusEnum enum3_2 = OrderStatusEnum.getEnumByCode(3);


        System.out.println(enum3_1 == enum3_2);


        OrderStatusEnum enum1_1 = OrderStatusEnum.getEnumByCode(1);
        System.out.println(enum1_1 == enum3_2);
    }
}
