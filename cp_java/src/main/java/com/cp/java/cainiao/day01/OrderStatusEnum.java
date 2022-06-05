package com.cp.java.cainiao.day01;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum OrderStatusEnum {

    CANCEL(1,"订单取消"),
    FINISH(2,"完成"),
    DELIVER(3,"发货");
    ;
    int code;
    String status;


    //根据 code找到枚举实例
    public static OrderStatusEnum getEnumByCode(int code){
        OrderStatusEnum[] values = OrderStatusEnum.values();
        for (OrderStatusEnum value : values){
            if(code==value.code){
                return value;
            }
        }
        return null;
    }

    //根据code 找到订单状态描述
    public static String getStatusByCode(int code){
        OrderStatusEnum orderStatusEnum = getEnumByCode(code);

        if(Objects.isNull(orderStatusEnum)){
            return null;
        }else{
            return orderStatusEnum.getStatus();
        }
    }

}
