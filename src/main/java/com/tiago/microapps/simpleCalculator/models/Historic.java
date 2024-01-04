package com.tiago.microapps.simpleCalculator.models;

import com.tiago.microapps.simpleCalculator.services.SimpleCalculatorFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Historic {
    private static final List<Map.Entry<Map.Entry<Integer, String>, String>> historicControl = new ArrayList<>();
    private final SimpleCalculatorFile simpleCalculatorFile;

    public Historic(SimpleCalculatorFile simpleCalculatorFile) {
        this.simpleCalculatorFile = simpleCalculatorFile;
    }


    public static boolean checkHistoricEmpty() {
        return historicControl.isEmpty();
    }

    public void clearHistoric() {
        historicControl.clear();
        simpleCalculatorFile.clearFileContent();
    }

    public static Map.Entry<Map.Entry<Integer, String>, String> getLastHistoricKey() {
        return historicControl.getLast();
    }

    public void addHistoric(Map.Entry<Integer, String> key, String value) {
        historicControl.add(Map.entry(key, value));

        Map.Entry<Map.Entry<Integer, String>, String> lastHistoricKey = getLastHistoricKey();
        simpleCalculatorFile.addContent("[" + lastHistoricKey
                .getKey()
                .toString()
                .replace("=", ",") + "]," + lastHistoricKey.getValue());
    }

    public void getHistoric() {
        if (checkHistoricEmpty()) {
            if (!simpleCalculatorFile.checkFileContainsContent()) {
                System.out.println("\nHistoric is empty.");
            } else {
                simpleCalculatorFile.readFromFile();
            }
        } else {
            historicControl.forEach(item -> System.out.printf("%n%s: %s", item.getKey().getValue(), item.getValue()));
        }
    }
}
