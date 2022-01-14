package com.os.fanout;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages = "com.os.fanout.logs")
@Profile("fanout.logs")
public class LogsConfig {

}
