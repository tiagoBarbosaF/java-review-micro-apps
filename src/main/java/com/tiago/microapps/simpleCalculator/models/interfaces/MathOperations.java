package com.tiago.microapps.simpleCalculator.models.interfaces;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public interface MathOperations {
    BigDecimal Operation(TreeMap<String, BigDecimal> valueOptions);
}
