package com.os.fanout.traces.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TracesConsumer {

    @PostConstruct
    void init() {
        System.out.println("TracesConsumer *************************");
    }

}
