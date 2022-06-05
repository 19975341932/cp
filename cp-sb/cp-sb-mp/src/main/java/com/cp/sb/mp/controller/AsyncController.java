package com.cp.sb.mp.controller;

import com.cp.sb.mp.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    AsyncService async;

    @RequestMapping("/async")
    public void async(){
        async.testAsync();
    }




}
