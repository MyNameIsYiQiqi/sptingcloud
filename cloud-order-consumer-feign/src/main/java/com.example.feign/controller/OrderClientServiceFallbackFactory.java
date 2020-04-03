package com.example.feign.controller;

import com.example.feign.service.OrderClientService;
import common.domain.Order;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/8 14:04
 */
@Component
public class OrderClientServiceFallbackFactory implements FallbackFactory<OrderClientService> {
    @Override
    public OrderClientService create(Throwable throwable) {
        return new OrderClientService() {

            /**
             * 当订单服务的getOrder()方法出异常后的熔断处理方法
             * @param id id
             * @return 返回信息
             */
            @Override
            public Order getOrder(Long id) {
                return new Order().setId(id)
                        .setName("未找到该ID的结果2")
                        .setPrice(0d)
                        .setDbSource("No this datasource");
            }

            @Override
            public List<Order> getAll() {
                return null;
            }
        };
    }
}
