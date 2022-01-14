package com.os.fanout;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages = "com.os.fanout.traces")
@Profile("fanout.traces")
public class TracesConfig {
}
