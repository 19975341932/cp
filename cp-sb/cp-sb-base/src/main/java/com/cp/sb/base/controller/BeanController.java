package com.cp.sb.base.controller;


import com.cp.sb.base.pojo.UserDTO;
import com.cp.sb.base.pojo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bean")
public class BeanController {


    @RequestMapping("/test")
    public Object test(@RequestBody UserVO userVO){
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(userVO, dto);
        System.out.println(dto);
        return dto;
    }
}
