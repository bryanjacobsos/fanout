package com.os.fanout.traces.service;

import com.os.fanout.traces.repo.TracesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TracesService {

    @Autowired
    TracesRepo tracesRepo;

    public Integer getInteger() {
        return tracesRepo.getInteger();
    }
}
