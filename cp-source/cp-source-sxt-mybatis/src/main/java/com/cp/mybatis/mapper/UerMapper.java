package com.cp.mybatis.mapper;

import com.cp.mybatis.entity.UserEntity;

import java.util.List;

public interface UerMapper {

     //添加用户信息
     void insertUser();

    //修改用户信息
    void updateUser();

    void delectUser();

    UserEntity selectById();

    List <UserEntity> selectAll();

}
