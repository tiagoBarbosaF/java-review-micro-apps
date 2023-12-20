package com.tiago.microapps.simpleCalculator.services;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileService {
    private static final Path path = Paths.get("HistoricCalculator.txt");

    public static void initializeFile() {
        clearFileContent();
    }

    public static void addContent(String content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toString(), true))) {
            bufferedWriter.append(content).append("\n");
        } catch (IOException e) {
            System.out.println("Error to add content in file." + e.getMessage());
        }
    }

    public static boolean checkHistoricFileContainsContent() {
        try {
            return Files.size(path) != 0;
        } catch (IOException e) {
            return true;
        }
    }

    public static void clearFileContent() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toString(), false))) {
            bufferedWriter.write("");
        } catch (IOException e) {
            System.out.println("Clean file error." + e.getMessage());
        }
    }

    public static Map.Entry<Map.Entry<Integer, String>, String> mapFileToTreeMap(String line) {
        String[] elements = line.split(",");
        Integer key1 = Integer.parseInt(elements[0].trim().replace("[", ""));
        String key2 = elements[1].trim().replace("]", "");
        String value = String.join(", ", Arrays.copyOfRange(elements, 2, elements.length))
                .trim();

        return Map.entry(Map.entry(key1, key2), value);
    }

    public static void getHistoricFromFile() {
        List<Map.Entry<Map.Entry<Integer, String>, String>> listMaps = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toString()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    Map.Entry<Map.Entry<Integer, String>, String> map = mapFileToTreeMap(line);
                    listMaps.add(map);
                }
            }

            listMaps.forEach(item -> System.out.printf("%s:%n%s%n", item.getKey().getValue(), item.getValue()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
