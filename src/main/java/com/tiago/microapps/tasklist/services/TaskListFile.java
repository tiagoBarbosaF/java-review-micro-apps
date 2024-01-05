package com.tiago.microapps.tasklist.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tiago.microapps.tasklist.models.adapters.TaskAdapter;
import com.tiago.microapps.tasklist.models.records.TaskDetails;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskListFile {
    private static final List<TaskDetails> taskList = new ArrayList<>();
    private static final Path path = Paths.get("TaskListFile.json");
    private static Gson gson;

    public TaskListFile() {
        gson = new Gson();
    }


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
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                TaskAdapter task = gson.fromJson(line, TaskAdapter.class);
                taskList.add(new TaskDetails(task));
            }
            return taskList;
//            return bufferedReader.lines().map(json -> gson.fromJson(json, TaskDetails.class)).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
