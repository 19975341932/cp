package com.sc.portal.test;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.loadbalancer.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class RibbonTest {

    public static void main(String[] args) throws InterruptedException {
//        serverListTest();

//        zoneTest();

//        ServerListUpdaterTest();

        IPingTest();
    }

    private static void IPingTest() {
        IPing ping = new PingUrl(false, "/sayHello");
        Server server = new Server("user-service", 9090);
        System.out.println(ping.isAlive(server));//测试一下服务
    }

    private static void ServerListUpdaterTest() throws InterruptedException {
        String instances = "localhost:9090,localohst:9093";
        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        config.set(CommonClientConfigKey.ListOfServers, instances);
        ConfigurationBasedServerList basedServerList = new ConfigurationBasedServerList();
        basedServerList.initWithNiwsConfig(config);//初始化配置

        ServerListUpdater updater = new PollingServerListUpdater();
        updater.start(new ServerListUpdater.UpdateAction() {
            @Override
            public void doUpdate() {
                System.out.println("最后更新时间:" + updater.getLastUpdate()+"" +
                        "上次更新间隔时长"+ updater.getDurationSinceLastUpdateMs());
            }
        });
        ZoneAwareLoadBalancer loadBalancer = new ZoneAwareLoadBalancer();
        loadBalancer.setServerListImpl(basedServerList);
        loadBalancer.setServerListUpdater(updater);//服务列表更新器

        TimeUnit.SECONDS.sleep(Long.MIN_VALUE);
    }

    private static void zoneTest() {
        ArrayList<Server> serverList = new ArrayList<>();
        serverList.add(createServer("shanghai", "goodServer", 9090));
        serverList.add(createServer("shanghai", "goodServer", 9093));
        serverList.add(createServer("hubei","goodServer", 9090));
        //设置完了区域数据之后，下面就需要进行负载均衡散发的配置
        ZoneAwareLoadBalancer loadBalancer = new ZoneAwareLoadBalancer();
        loadBalancer.addServers(serverList);
        LoadBalancerStats stats = loadBalancer.getLoadBalancerStats();//获取统计数据
        stats.updateServerList(serverList);//服务列表更新
        stats.getServerStats().keySet().forEach(currentServer -> {
            if(currentServer.getZone().equals("shanghai")){//区域算法
                loadBalancer.markServerDown(currentServer);//服务下线
            }
        });

        for (int i = 0; i < loadBalancer.getServerCount(true); i++) {
            System.out.println(loadBalancer.chooseServer(null));//服务筛选
        }
    }

    private static void serverListTest() {
        //通过字符串定义所有可以使用的服务实例数据，中间使用","分割
        String instances = "localhost:9090,localohst:9093";
        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        config.set(CommonClientConfigKey.ListOfServers, instances);


        ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
        serverList.initWithNiwsConfig(config);//初始化配置

        System.out.println(serverList.getUpdatedListOfServers());
    }

    private static Server createServer(String zone, String url, int index){
        Server server = new Server(url, index);//创建实例
        server.setZone(zone);//设置区域
        return server;
    }
}
