package com.sc.portal.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * https://blog.csdn.net/qq_33375499/article/details/122279505
 */
@Log4j2
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadbalancerClient;

    /**
     * goodService.ribbon.listOfServers=http://localhost:9090,http://localhost:9093
     * @return
     */
    @RequestMapping("/test1")
    public String test1() {
        log.info("begin do order");
//        3、基于api的形式
        ServiceInstance si = loadbalancerClient.choose("goodService");
        String url = String.format("http://%s:%s/goods", si.getHost(), si.getPort());
        log.info("ribbon-url:{}", url);
        String goodsInfo = restTemplate.getForObject(url, String.class);

        return goodsInfo;
    }


    /**
     * # restTemplate 加@LoadBalanced注解
     * goodService1.ribbon.listOfServers=http://localhost:9090,http://localhost:9093
     * @return
     */
    @RequestMapping("/test2")
    public String test2() {
        log.info("begin do order");

        //4、RestTemplate配置加@LoadBalanced
        String url="http://goodService1/goods";
        String goodsInfo = restTemplate.getForObject(url, String.class);

        return goodsInfo;
    }


}
