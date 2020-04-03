package com.example.consumer.controller;

import common.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/7 15:15
 */

@RestController
@RequestMapping("/consumer/order")
public class OrderConsumerController {

    // 订单服务提供者模块的 url 前缀
    //private static final String ORDER_PROVIDER_URL_PREFIX = "http://localhost:8001";

    // 注释掉的那部分，是原来的访问方式，订单提供服务是8001端口，现在我们将ip+端口号这种访问方式，改成微服务名称，
    // 这个名称就是 Eureka 管理界面显示的注册进去的名称，也即服务提供方的application.yml配置文件中配置的服务名称
    private static final String ORDER_PROVIDER_URL_PREFIX = "http://CLOUD-ORDER";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public Order getOrder(@PathVariable Long id) {

        return restTemplate.getForObject(ORDER_PROVIDER_URL_PREFIX + "/provider/order/get/" + id, Order.class);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/get/list")
    public List<Order> getAll() {
        return restTemplate.getForObject(ORDER_PROVIDER_URL_PREFIX + "/provider/order/get/list", List.class);
    }

}
