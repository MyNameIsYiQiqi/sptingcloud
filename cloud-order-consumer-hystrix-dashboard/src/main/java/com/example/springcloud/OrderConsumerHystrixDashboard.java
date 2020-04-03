package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/8 14:31
 */
@SpringBootApplication
@EnableHystrixDashboard
public class OrderConsumerHystrixDashboard {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerHystrixDashboard.class, args);
    }
}
