package com.tiago.microapps.simpleCalculator.models.interfaces;

import java.math.BigDecimal;
import java.util.TreeMap;

public class Multiply implements IOperation {
    @Override
    public BigDecimal Operation(TreeMap<String, BigDecimal> valueOptions) {
        return valueOptions.values().stream().reduce(BigDecimal::multiply).orElse(BigDecimal.ZERO);
    }
}
