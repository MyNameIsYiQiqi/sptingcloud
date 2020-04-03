package com.example.hystrix;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/8 11:46
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.example.hystrix.repository.dao")
@EnableCircuitBreaker
public class OrderProvider01Hystrix {
    public static void main(String[] args) {
        SpringApplication.run(OrderProvider01Hystrix.class, args);
    }
}
