package com.os.fanout.metrics.service;

import com.os.fanout.metrics.repo.MetricsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

    @Autowired
    MetricsRepo metricsRepo;
}
