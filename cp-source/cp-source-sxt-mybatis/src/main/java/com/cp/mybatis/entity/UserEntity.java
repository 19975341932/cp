package com.cp.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class  UserEntity {

    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String email;
}
