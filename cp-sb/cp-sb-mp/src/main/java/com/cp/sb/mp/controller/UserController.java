package com.cp.sb.mp.controller;

import com.cp.sb.mp.entity.UserEntity;
import com.cp.sb.mp.mapper.IUserMapper;
import com.cp.sb.mp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    IUserMapper userMapper;

    @RequestMapping("/test")
    public Map<String, Object> test() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "admin");
        hashMap.put("age", 18);

        return hashMap;
    }

    //Mp测试
    @RequestMapping("mpselect")
    public void select() {
        List<UserEntity> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    //新增
    @RequestMapping("mpadd")
    public int addUser(@RequestBody UserEntity userEntity) {
        int insert = userMapper.insert(userEntity);

        return insert;
    }

    //删除
    @RequestMapping("mpdeleter")
    public int mpdeleter(@RequestParam("id") Long id) {
        return userMapper.deleteById(id);
    }

    //Mp测试
    @RequestMapping("selectone")
    public UserEntity selectone(@RequestParam("id") Long id) {
        return userMapper.selectById(id);
    }


}
