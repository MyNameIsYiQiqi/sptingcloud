package com.example.provider02.web;

import com.example.provider02.service.OrderService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import common.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/7 13:59
 */

@RestController
@RequestMapping("/provider/order")
public class OrderProviderController {

    @Resource
    private OrderService orderService;
    @Resource
    private EurekaClient client;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProviderController.class);

    @GetMapping("/get/{id}")
    public Order getOrder(@PathVariable Long id) {
        Order order = orderService.findById(id);
        order.setDbSource("cloud02");
        return order;
    }

    @GetMapping("/get/list")
    public List<Order> getAll() {
        return orderService.findAll();
    }

    @GetMapping("/discovery")
    public Object discovery() {
        // 获取Eureka中所有的服务节点
        List<Application> applications = client.getApplications().getRegisteredApplications();
        if (applications != null) {
            for (Application application : applications) {
                // 对外暴露的服务名称
                String name = application.getName();
                // 只看订单服务信息
                if ("CLOUD-ORDER".equals(name)) {
                    // 服务有多少个实例，比如订单服务可能部署了多个，有多个订单服务注册到了eureka
                    List<InstanceInfo> instances = application.getInstances();
                    LOGGER.info("所有的订单服务：{}", instances);
                    if (instances != null) {
                        for (InstanceInfo info : instances) {
                            LOGGER.info("服务id：{}", info.getInstanceId());
                            LOGGER.info("服务主机：{}", info.getHostName());
                            LOGGER.info("服务端口：{}", info.getPort());
                        }
                    }
                    return instances;
                }
            }
        }
        return "未找到服务";
    }

}
