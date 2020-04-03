package com.example.consumer;

import com.example.consumer.config.MyRibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/7 15:12
 */

// name 用来指定需要均衡的服务，即三个订单服务，configuration 用来指定所用的策略配置
@RibbonClient(name = "CLOUD-ORDER", configuration = MyRibbonRuleConfig.class)
@EnableEurekaClient
@SpringBootApplication
public class OrderConsumer {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumer.class, args);
    }
}
