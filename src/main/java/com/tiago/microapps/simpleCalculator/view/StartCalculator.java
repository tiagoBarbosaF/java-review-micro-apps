package com.tiago.microapps.simpleCalculator.view;

import com.tiago.microapps.simpleCalculator.handlers.OperationsHandler;
import com.tiago.microapps.simpleCalculator.models.Historic;
import com.tiago.microapps.simpleCalculator.models.enums.OperationTypes;
import com.tiago.microapps.simpleCalculator.models.interfaces.MathOperations;
import com.tiago.microapps.simpleCalculator.services.FileService;

import java.math.BigDecimal;

public class StartCalculator {

    public static void Start() {
        FileService.initializeFile();

        while (true) {
            MenuOptions.menu();
            OperationTypes getOptions = MenuOptions.menuGetOptions();

            if (getOptions.equals(OperationTypes.EXIT)) {
                break;
            }

            if (getOptions.equals(OperationTypes.ERROR)) {
                System.out.println("Enter a valid Option from menu!");
                continue;
            }

            if (getOptions.equals(OperationTypes.HISTORIC)) {
                System.out.println("\nHistoric:");
                Historic.getHistoric();
            } else if (getOptions.equals(OperationTypes.CLEAN_HISTORIC)) {
                Historic.clearHistoric();
                System.out.println("Historic cleaned!");
            } else {
                MathOperations operations = OperationsHandler.getOperations(getOptions);
                BigDecimal resultOperation = operations.Operation(MenuOptions.getNumberOptions(getOptions));
                System.out.printf("%nResult: %.2f", resultOperation);
            }
        }
    }
}
