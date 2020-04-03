package com.example.feign.controller;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/8 10:59
 */
public class CustomRule extends AbstractLoadBalancerRule {

    /**
     * 总共被调用的次数，目前要求每台被调用4次
     */
    private int total = 0;
    /**
     * 当前提供服务列表的索引
     */
    private int currentIndex = 0;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    /**
     * 在choose方法中，自定义我们自己的规则，返回的Server就是具体选择出来的服务
     * 自己的规则：按照轮询的规则，但是每个被轮询到的服务调用4次。
     * 每个被轮询到的服务，接下来访问4次（默认是1次），4次访问完之后，再切换到下一个服务，访问4次，以此类推
     *
     * @param o
     * @return
     */
    @Override
    public Server choose(Object o) {
        // 获取负载均衡器lb
        // 首先获取 ILoadBalancer 对象，该对象可以获取当前的服务
        // 我们需要获取当前可用的服务列表和当前所有的服务列表
        ILoadBalancer lb = getLoadBalancer();
        if (lb == null) {
            return null;
        }

        Server server = null;
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            // 获取可用服务列表
            List<Server> upList = lb.getReachableServers();
            // 获取所有服务列表
            List<Server> allList = lb.getAllServers();
            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            // 若调用次数小于4次，一直调用可用服务列表中索引为 currentIndex 的服务
            if(total < 4)
            {
                server = upList.get(currentIndex);
                total++;
            } else {
                // 到了4次之后，服务列表中的索引值++，表示下一个调用下一个服务
                total = 0;
                currentIndex++;
                // 当索引大于可用服务列表的size时，要重新从头开始
                currentIndex = currentIndex % upList.size();

                if (server == null) {
                    Thread.yield();
                    continue;
                }

                if (server.isAlive()) {
                    return (server);
                }

                server = null;
                Thread.yield();
            }
        }
        return server;
    }
}
