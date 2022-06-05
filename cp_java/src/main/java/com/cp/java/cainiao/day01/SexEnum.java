package com.cp.java.cainiao.day01;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SexEnum {

    MAN(1,"男"),
    WOMAN(2,"女"),
    ;

    private int code;
    private String desc;

//    SexEnum(int code, String desc) {
//        this.code = code;
//        this.desc = desc;
//    }


    //根据code找实例
    public static SexEnum getSexEnumByCode(int code) {
        SexEnum[] values = SexEnum.values();
        for (SexEnum value : values) {
            if (value.code == code) {
                   return value;
            }
        }
        return null;
    }

    //根据code 找到描述
    public static String getDescByCode(int code) {
        SexEnum sexEnumByCode = getSexEnumByCode(code);
        if (sexEnumByCode == null){
            return null;
        }else{
            return sexEnumByCode.getDesc();
        }

    }




    //根据desc找到code
   public static int getCodeByDesc(String desc){
       SexEnum[] values = SexEnum.values();
       for (SexEnum value : values){
           if(value.desc== desc){
               return value.code;
           }
       }

       return 1;
   }









}
