package com.os.fanout;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.os.fanout.metrics")
@Profile("fanout.metrics")
public class MetricsConfig {

    @Bean
    public Map<String, String> stringStringMap() {
        return Map.of("hello", "world");
    }
}
