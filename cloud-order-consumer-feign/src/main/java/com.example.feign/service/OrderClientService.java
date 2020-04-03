package com.example.feign.service;

import com.example.feign.controller.OrderClientServiceFallbackFactory;
import common.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/8 11:21
 */
//@FeignClient(value = "CLOUD-ORDER")
@FeignClient(value = "CLOUD-ORDER", fallbackFactory = OrderClientServiceFallbackFactory.class)
public interface OrderClientService {

    @GetMapping("/provider/order/get/{id}")
    Order getOrder(@PathVariable(value = "id") Long id);

    @GetMapping("/provider/order/get/list")
    List<Order> getAll();

}
