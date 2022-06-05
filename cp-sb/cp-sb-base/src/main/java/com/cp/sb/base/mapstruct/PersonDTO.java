package com.cp.sb.base.mapstruct;

import lombok.Data;

import java.util.Date;

@Data
public class PersonDTO {

    String describe;

    private Long id;

    private String personName;

    private String age;

    private String source;

    private String height;

    private Date createTime;

}