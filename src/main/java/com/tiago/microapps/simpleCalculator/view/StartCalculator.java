package com.tiago.microapps.simpleCalculator.view;

import com.tiago.microapps.simpleCalculator.models.Subtraction;
import com.tiago.microapps.simpleCalculator.models.Sum;
import com.tiago.microapps.simpleCalculator.models.enums.OperationTypes;
import com.tiago.microapps.simpleCalculator.models.interfaces.Multiply;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.TreeMap;

public class StartCalculator {

    public static void Start() {
        Sum sum = new Sum();
        Subtraction subtraction = new Subtraction();
        Multiply multiply = new Multiply();

        TreeMap<String, BigDecimal> values = new TreeMap<>();
        values.put("1", BigDecimal.valueOf(12));
        values.put("2", BigDecimal.valueOf(0));
        values.put("3", BigDecimal.valueOf(3.3));

//        BigDecimal reduce = values.values().stream().reduce(BigDecimal::divide).orElse(BigDecimal.ZERO);
//        System.out.println(reduce);
        BigDecimal operation = multiply.Operation(values);
        System.out.printf("Result: %.2f", operation);
    }
}
