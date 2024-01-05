package com.tiago.microapps.simpleCalculator.view;

import com.tiago.microapps.simpleCalculator.models.Historic;
import com.tiago.microapps.simpleCalculator.models.enums.OperationTypes;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

public class MenuOptions {
    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() {
        String menuBar = "-".repeat(50);
        final String titleApp = "==== Simple Calculator ====";
        String titleBar = "=".repeat(titleApp.length());

        System.out.println("\n" + menuBar + "\n\n" +
                "\t" + titleApp + "\n\n" +
                "\tChoice your operation:\n" +
                "\t\t" + OperationTypes.SUM.getValue() + " - " + OperationTypes.SUM.name() + "\n" +
                "\t\t" + OperationTypes.SUBTRACTION.getValue() + " - " + OperationTypes.SUBTRACTION.name() + "\n" +
                "\t\t" + OperationTypes.MULTIPLY.getValue() + " - " + OperationTypes.MULTIPLY.name() + "\n" +
                "\t\t" + OperationTypes.DIVISION.getValue() + " - " + OperationTypes.DIVISION.name() + "\n" +
                "\t\t" + OperationTypes.MOD.getValue() + " - " + OperationTypes.MOD.name() + "\n" +
                "\t\t" + OperationTypes.SQUARE_ROOT.getValue() + " - " + OperationTypes.SQUARE_ROOT.name().replace("_", " ") + "\n" +
                "\t\t" + OperationTypes.HISTORIC.getValue() + " - " + OperationTypes.HISTORIC.name() + "\n" +
                "\t\t" + OperationTypes.CLEAN_HISTORIC.getValue() + " - " + OperationTypes.CLEAN_HISTORIC.name().replace("_", " ") + "\n" +
                "\t\t" + OperationTypes.EXIT.getValue() + " - " + OperationTypes.EXIT.name() + "\n\n" +
                "\t" + titleBar + "\n\n" +
                menuBar
        );
    }

    public static OperationTypes menuGetOptions() {
        final String pattern = "^[0-9]$";
        System.out.print("\nEnter the option: ");
        String option = scanner.nextLine();

        if (!Pattern.matches(pattern, option)) {
            System.out.println("Invalid operation. Please enter a valid option.");
            return OperationTypes.ERROR;
        }

        int optionParse = Integer.parseInt(option);

        if (optionParse == 0) {
            return OperationTypes.EXIT;
        }

        return OperationTypes.values()[optionParse - 1];
    }

    public static TreeMap<String, BigDecimal> getNumberOptions(OperationTypes option) {
        int i = 0;
        int indexType = 0;
        TreeMap<String, BigDecimal> numberOptions = new TreeMap<>();
        List<BigDecimal> listOfValues = new ArrayList<>();
        final String pattern = "^[0-9]+(\\.[0-9]+)?$";

        while (true) {
            BigDecimal num;
            if (option.equals(OperationTypes.SQUARE_ROOT)) {
                System.out.print("Enter the value: ");
                String readOption = scanner.nextLine();
                num = new BigDecimal(readOption);
                ++i;
                numberOptions.put("num" + i, num);
                listOfValues.add(num);
                break;
            }

            System.out.print("Enter the value (s - exit): ");
            String readOption = scanner.nextLine();

            if (readOption.equalsIgnoreCase("s")) {
                break;
            }

            if (!Pattern.matches(pattern, readOption)) {
                System.out.println("Enter a valid value. For decimal values, use \".\"");
                continue;
            }

            num = new BigDecimal(readOption);
            ++i;
            numberOptions.put(String.valueOf(i), num);
            listOfValues.add(num);
        }

        String values = String.join(", ", listOfValues.stream().map(BigDecimal::toString).toList());

        if (Historic.checkHistoricEmpty()) {
            Historic.addHistoric(Map.entry(++indexType, option.name()), values);
        } else {
            Map.Entry<Map.Entry<Integer, String>, String> lastHistoricKey = Historic.getLastHistoricKey();
            Historic.addHistoric(Map.entry(lastHistoricKey.getKey().getKey() + 1, option.name()), values);
        }

        listOfValues.clear();
        return numberOptions;
    }
}
