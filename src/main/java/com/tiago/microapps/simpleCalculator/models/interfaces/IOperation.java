package com.tiago.microapps.simpleCalculator.models.interfaces;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.TreeMap;

public interface IOperation {
    BigDecimal Operation(TreeMap<String, BigDecimal> valueOptions);
}
