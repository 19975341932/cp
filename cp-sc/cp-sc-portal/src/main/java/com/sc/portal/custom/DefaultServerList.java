package com.sc.portal.custom;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

//@Component
@Slf4j
public class DefaultServerList implements ServerList {
    @Override
    public List getInitialListOfServers() {
        return null;
    }

    @Override
    public List getUpdatedListOfServers() {
        List<Server> allServers = new ArrayList<Server>();

        allServers.add(new Server("127.0.0.1",9090));
        allServers.add(new Server("127.0.0.1",9093));
        log.info("更新服务列表:{}", allServers);
        return allServers;
    }
}
