package com.cp.sb.base.mapstruct;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PersonVo {

    String describ;

    private String id;

    private String name;

    private int age;

    private BigDecimal source;

    private double height;

    private String createTime;

}




