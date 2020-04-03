package com.example.eureka01;

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
public class EurekaServer01 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer01.class, args);
    }
}
