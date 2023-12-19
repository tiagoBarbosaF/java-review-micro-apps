package com.tiago.microapps.simpleCalculator.view;

import com.tiago.microapps.simpleCalculator.models.*;

import java.math.BigDecimal;
import java.util.TreeMap;

public class StartCalculator {

    public static void Start() {
        Sum sum = new Sum();
        Subtraction subtraction = new Subtraction();
        Multiply multiply = new Multiply();
        Division division = new Division();
        Mod mod = new Mod();
        SquareRoot squareRoot = new SquareRoot();

        TreeMap<String, BigDecimal> values = new TreeMap<>();
        values.put("1", BigDecimal.valueOf(125));
        values.put("2", BigDecimal.valueOf(5));
        values.put("3", BigDecimal.valueOf(3.3));

        BigDecimal operation = squareRoot.Operation(values);
        System.out.printf("Result: %.2f%n", operation);
    }
}
