package com.example.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/7 15:13
 */

@Configuration
public class RestTemplateConfig {

    /**
     * '@LoadBalanced'注解表示使用Ribbon实现客户端负载均衡
     *
     * @return RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 指定其他负载均衡策略 注：使用自定义负载均衡时，该方法需要去掉
     *
     * @return IRule
     */
    //@Bean
    //public IRule myRule() {
    //    // RoundRibbonRule：轮询。人人有份，一个个来！
    //    // RetryRule：先轮询，如果获取失败则在指定时间内重试，重新轮询可用的服务
    //    // RandomRule：随机
    //    return new RetryRule();
    //}

}
