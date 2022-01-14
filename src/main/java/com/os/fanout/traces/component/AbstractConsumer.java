package com.os.fanout.traces.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AbstractConsumer {

    @PostConstruct
    void init() {
        System.out.println("starting consumer");
    }

}
