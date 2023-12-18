package com.tiago.microapps.simpleCalculator.models.enums;

public enum OperationTypes {
    SUM(1),
    SUBTRACTION(2),
    MULTIPLY(3),
    DIVISION(4),
    MOD(5),
    SQUARE_ROOT(6),
    HISTORIC(7),
    CLEAN_HISTORIC(8),
    ERROR(99),
    EXIT(0);

    private final int value;

    OperationTypes(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
