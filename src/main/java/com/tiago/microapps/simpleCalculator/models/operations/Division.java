package com.tiago.microapps.simpleCalculator.models.operations;

import com.tiago.microapps.simpleCalculator.models.interfaces.MathOperations;

import java.math.BigDecimal;
import java.util.TreeMap;

public class Division implements MathOperations {
    @Override
    public BigDecimal Operation(TreeMap<String, BigDecimal> valueOptions) {
        try {
            return valueOptions.values().stream().reduce(BigDecimal::divide).orElse(BigDecimal.ZERO);
        } catch (ArithmeticException e) {
            System.out.printf("%nException: %s%n", e.getMessage());
            return null;
        }
    }
}
