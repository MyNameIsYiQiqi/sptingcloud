package com.example.consumer.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <注意：该配置所在的包不能和主启动类在同一个包下面，这是官方文档提到的注意事项>
 *
 * @author : 177
 * @date :  2020/1/8 10:54
 */
@Configuration
public class MyRibbonRuleConfig {

    @Bean
    public IRule myselfRule() {
        // 指定策略：我们自定义的策略
        return new CustomRule();
    }

}
