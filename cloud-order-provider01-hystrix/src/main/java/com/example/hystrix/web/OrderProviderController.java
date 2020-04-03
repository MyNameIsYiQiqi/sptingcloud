package com.example.hystrix.web;

import com.example.hystrix.service.OrderService;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import common.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    /**
     * HystrixCommond注解中的fallbackMethod指示的是：当该方法出异常时，调用processGetOrderHystrix方法
     * @param id id
     * @return 订单信息
     */
    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "processGetOrderHystrix")
    public Order getOrder(@PathVariable Long id) {
        Order order = orderService.findById(id);
        if (order == null) {
            throw new RuntimeException("数据库没有对应的信息");
        }
        return order;
    }

    /**
     * 上面getOrder()方法出异常后的熔断处理方法
     * @param id id
     * @return 订单信息
     */
    public Order processGetOrderHystrix(@PathVariable Long id) {
        return new Order().setId(id)
                .setName("未找到该ID的结果")
                .setPrice(0d)
                .setDbSource("No this datasource");
    }

}
