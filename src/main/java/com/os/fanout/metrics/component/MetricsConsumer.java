package com.os.fanout.metrics.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MetricsConsumer {

    @PostConstruct
    void init() {
        System.out.println("MetricsConsumer **************************");
    }
}
