package com.griddynamics.jagger.collector;

import com.griddynamics.jagger.engine.e1.collector.MetricCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseSize implements MetricCalculator<Integer> {

    private static final Logger log = LoggerFactory.getLogger(ResponseSize.class);

    @Override
    public Integer calculate(Integer response) {
        log.info("Calculate response="+response);
        return response;
    }
}
