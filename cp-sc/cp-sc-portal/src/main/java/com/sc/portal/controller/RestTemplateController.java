package com.sc.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RequestMapping("/restTemplate")
@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;



    @Value("${goodsService.serverList}")
    String  url;

    /**
     * https://blog.csdn.net/qmqm011/article/details/118678495
     */
    @Value("#{'${goodsService.serverList}'.split(',')}")
//    @Value("#{'${goodsService.serverList:}'.empty ? null : '${goodsService.serverList:}'.split(',')}")  这种没有测试
    private List<String> goodsList;


    //http://localhost:8080/restTemplate/test
    @RequestMapping("/test")
    public Object test(){
        System.out.println("吴柳爱我");
       return restTemplate.getForObject(getGoodsUrl(),String.class);
    }


    public String getGoodsUrl(){
        Random random = new Random();
        int i = random.nextInt(30);
        i = i % goodsList.size();
        return  goodsList.get(i);
    }
}
