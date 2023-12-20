package com.tiago.microapps.simpleCalculator.models.operations;

import com.tiago.microapps.simpleCalculator.models.interfaces.MathOperations;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.TreeMap;

public class SquareRoot implements MathOperations {
    @Override
    public BigDecimal Operation(TreeMap<String, BigDecimal> valueOptions) {
        return valueOptions.firstEntry().getValue().sqrt(MathContext.DECIMAL32);
    }
}
