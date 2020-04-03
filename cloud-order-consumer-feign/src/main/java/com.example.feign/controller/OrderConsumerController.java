package com.example.feign.controller;

import com.example.feign.service.OrderClientService;
import common.domain.Order;
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
 * @date :  2020/1/8 11:23
 */
@RestController
@RequestMapping("/consumer/order")
public class OrderConsumerController {

    /**
     * 上面定义的 Feign Client
     */
    @Resource
    private OrderClientService orderClientService;

    @GetMapping("/get/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderClientService.getOrder(id);
    }

    @GetMapping("/get/list")
    public List<Order> getAll() {
        return orderClientService.getAll();
    }

}
