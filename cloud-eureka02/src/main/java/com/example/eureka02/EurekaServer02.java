package com.example.eureka02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/6 17:54
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer02 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer02.class, args);
    }
}
