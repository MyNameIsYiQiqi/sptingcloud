package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/6 17:54
 */

@SpringBootApplication
@EnableConfigServer
public class CloudConfig {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfig.class, args);
    }
}
