package com.tiago.microapps.simpleCalculator.models;

import com.tiago.microapps.simpleCalculator.models.interfaces.IOperation;

import java.math.BigDecimal;
import java.util.TreeMap;

public class Subtraction implements IOperation {
    @Override
    public BigDecimal Operation(TreeMap<String, BigDecimal> valueOptions) {
        return valueOptions.values().stream().reduce(BigDecimal::subtract).orElse(BigDecimal.ZERO);
    }
}
