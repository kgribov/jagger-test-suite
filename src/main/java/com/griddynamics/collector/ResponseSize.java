package com.griddynamics.collector;

import com.griddynamics.jagger.engine.e1.collector.MetricCalculator;

public class ResponseSize implements MetricCalculator {
    @Override
    public Integer calculate(Object response) {
        return ((String) response).length();
    }
}
