package com.example.provider01.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/7 10:38
 */

@RestController
@RequestMapping("/config")
public class ClientController {

    @Value("${spring.application.name}")
    private String springApplicationName;

    @Value("${server.port}")
    private String serverPort;

    @Value("${eureka.client.service-url.defaultZone}")
    private String defaultEurekaZone;

    @GetMapping("/test")
    public String getConfig() {
        return "applicationName=" + springApplicationName
                + "; serverPort=" + serverPort
                + "; defaultEurekaZone=" + defaultEurekaZone;
    }

}
