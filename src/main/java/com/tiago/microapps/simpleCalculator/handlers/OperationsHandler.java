package com.tiago.microapps.simpleCalculator.handlers;

import com.tiago.microapps.simpleCalculator.models.enums.OperationTypes;
import com.tiago.microapps.simpleCalculator.models.interfaces.MathOperations;
import com.tiago.microapps.simpleCalculator.models.operations.*;

import java.util.Map;
import java.util.TreeMap;

public class OperationsHandler {
    private static final TreeMap<OperationTypes, MathOperations> operationTypes = new TreeMap<>(Map.of(
            OperationTypes.SUM, new Sum(),
            OperationTypes.SUBTRACTION, new Subtraction(),
            OperationTypes.MULTIPLY, new Multiply(),
            OperationTypes.DIVISION, new Division(),
            OperationTypes.MOD, new Mod(),
            OperationTypes.SQUARE_ROOT, new SquareRoot()
    ));

    public static MathOperations getOperations(OperationTypes operationTypes) {
        return OperationsHandler.operationTypes.get(operationTypes);
    }
}
