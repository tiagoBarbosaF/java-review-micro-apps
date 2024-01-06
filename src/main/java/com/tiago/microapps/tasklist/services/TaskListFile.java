package com.tiago.microapps.tasklist.services;

import com.google.gson.Gson;
import com.tiago.microapps.tasklist.models.adapters.TaskAdapter;
import com.tiago.microapps.tasklist.models.records.TaskDetails;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskListFile {
    private static final List<TaskDetails> taskList = new ArrayList<>();
    private static final Path path = Paths.get("TaskListFile.json");
    private static Gson gson = new Gson();

    public static void initializeFile() {
        if (!Files.exists(path)) {
            clearFileContent();
        }
    }

    public static void addContent(String task) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toString(), true))) {
            bufferedWriter.append(task).append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkFileContainsContent() {
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
            System.out.println("Clean file error: " + e.getMessage());
        }
    }

    public static List<TaskDetails> readFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toString()))) {
            bufferedReader.lines()
                    .map(json -> gson.fromJson(json, TaskAdapter.class))
                    .forEach(task->taskList.add(new TaskDetails(task)));
            return taskList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
