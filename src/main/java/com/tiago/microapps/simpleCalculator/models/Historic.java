package com.tiago.microapps.simpleCalculator.models;

import com.tiago.microapps.simpleCalculator.services.FileService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Historic {
    private static final List<Map.Entry<Map.Entry<Integer, String>, String>> historicControl = new ArrayList<>();

    public static boolean checkHistoricEmpty() {
        return historicControl.isEmpty();
    }

    public static void clearHistoric() {
        historicControl.clear();
        FileService.clearFileContent();
    }

    public static Map.Entry<Map.Entry<Integer, String>, String> getLastHistoricKey() {
        return historicControl.getLast();
    }

    public static void addHistoric(Map.Entry<Integer, String> key, String value) {
        historicControl.add(Map.entry(key, value));

        Map.Entry<Map.Entry<Integer, String>, String> lastHistoricKey = getLastHistoricKey();
        FileService.addContent("[" + lastHistoricKey
                .getKey()
                .toString()
                .replace("=", ",") + "]," + lastHistoricKey.getValue());
    }

    public static void getHistoric() {
        if (checkHistoricEmpty()) {
            if (!FileService.checkHistoricFileContainsContent()) {
                System.out.println("\nHistoric is empty.");
            } else {
                FileService.getHistoricFromFile();
            }
        } else {
            historicControl.forEach(item -> System.out.printf("%n%s: %s", item.getKey().getValue(), item.getValue()));
        }
    }
}
