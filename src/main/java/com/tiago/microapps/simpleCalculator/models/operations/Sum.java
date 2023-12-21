package com.tiago.microapps.simpleCalculator.models.operations;

import com.tiago.microapps.simpleCalculator.models.interfaces.MathOperations;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class Sum implements MathOperations {
    @Override
    public BigDecimal Operation(TreeMap<String, BigDecimal> valueOptions) {
        return valueOptions.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
