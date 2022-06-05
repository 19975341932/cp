package com.cp.commons.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("user")
@Data
public class User {

    private Integer id;
    private String name;
    private String pwd;



}
