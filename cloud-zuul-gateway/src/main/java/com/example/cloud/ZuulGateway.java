package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/9 10:10
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGateway {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateway.class, args);
    }
}
