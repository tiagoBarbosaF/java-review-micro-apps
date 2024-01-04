package com.tiago.microapps.simpleCalculator.view;

import com.tiago.microapps.simpleCalculator.handlers.OperationsHandler;
import com.tiago.microapps.simpleCalculator.models.Historic;
import com.tiago.microapps.simpleCalculator.models.enums.OperationTypes;
import com.tiago.microapps.simpleCalculator.models.interfaces.MathOperations;
import com.tiago.microapps.simpleCalculator.services.SimpleCalculatorFile;

import java.math.BigDecimal;

public class StartCalculator {
    private final SimpleCalculatorFile simpleCalculatorFile;
    private final Historic historic;
    private final MenuOptions menuOptions;

    public StartCalculator(SimpleCalculatorFile simpleCalculatorFile, Historic historic, MenuOptions menuOptions) {
        this.simpleCalculatorFile = simpleCalculatorFile;
        this.historic = historic;
        this.menuOptions = menuOptions;
    }

    public void start() {
        simpleCalculatorFile.initializeFile();

        while (true) {
            MenuOptions.menu();
            OperationTypes getOptions = menuOptions.menuGetOptions();

            if (getOptions.equals(OperationTypes.EXIT)) {
                break;
            }

            if (getOptions.equals(OperationTypes.ERROR)) {
                System.out.println("Enter a valid Option from menu!");
                continue;
            }

            if (getOptions.equals(OperationTypes.HISTORIC)) {
                System.out.println("\nHistoric:");
                historic.getHistoric();
            } else if (getOptions.equals(OperationTypes.CLEAN_HISTORIC)) {
                historic.clearHistoric();
                System.out.println("Historic cleaned!");
            } else {
                MathOperations operations = OperationsHandler.getOperations(getOptions);
                BigDecimal resultOperation = operations.Operation(menuOptions.getNumberOptions(getOptions));
                System.out.printf("%nResult: %.2f", resultOperation);
            }
        }
    }
}
