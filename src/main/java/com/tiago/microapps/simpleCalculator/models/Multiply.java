package com.tiago.microapps.simpleCalculator.models;

import com.tiago.microapps.simpleCalculator.models.interfaces.MathOperations;

import java.math.BigDecimal;
import java.util.TreeMap;

public class Multiply implements MathOperations {
    @Override
    public BigDecimal Operation(TreeMap<String, BigDecimal> valueOptions) {
        return valueOptions.values().stream().reduce(BigDecimal::multiply).orElse(BigDecimal.ZERO);
    }
}
