package com.example.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/8 11:13
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderConsumerFeign {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerFeign.class, args);
    }

}
