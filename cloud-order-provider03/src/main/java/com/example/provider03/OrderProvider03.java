package com.example.provider03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/6 17:54
 */

@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = {"com.example.provider03.repository.dao"})
public class OrderProvider03 {
    public static void main(String[] args) {
        SpringApplication.run(OrderProvider03.class, args);
    }
}
