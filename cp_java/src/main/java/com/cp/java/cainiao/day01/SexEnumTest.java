package com.cp.java.cainiao.day01;

public class SexEnumTest {
    public static void main(String[] args){
        String descByCode = SexEnum.getDescByCode(1);
        System.out.println(descByCode);

        System.out.println(SexEnum.getSexEnumByCode(2));
        System.out.println(SexEnum.getSexEnumByCode(2)==SexEnum.MAN);

        System.out.println(SexEnum.getCodeByDesc("女"));
    }
}
