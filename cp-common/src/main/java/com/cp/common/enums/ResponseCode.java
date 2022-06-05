package com.cp.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 响应码枚举类
 */

@Getter
@AllArgsConstructor
public enum  ResponseCode {

    SUCCESS(200,"响应正常"),
    FAIL(403,"响应错误"),
    NOT_FOUND(404,"找不到地址")

    ;
    int code;
    String description;

    //根据响应码找拿到响应描述
    public static String getDescByCode(int code){
        ResponseCode[] values = ResponseCode.values();
        for (ResponseCode value:values){
            ResponseCode responByCode = getResponByCode(code);
            if(Objects.isNull(responByCode)){
                return null;
            }
            if(code==value.code){
                return value.description;
            }
        }
        return SUCCESS.description;
    }

    //根据code拿到实例
    public static ResponseCode getResponByCode(int code){
        ResponseCode[] values = ResponseCode.values();
        for (ResponseCode value:values){
            if(code==value.code){
                return value;
            }
        }
        return null;
    }

}
