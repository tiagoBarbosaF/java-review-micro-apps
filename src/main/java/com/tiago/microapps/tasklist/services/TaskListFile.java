package com.tiago.microapps.tasklist.services;

import com.google.gson.Gson;
import com.tiago.microapps.tasklist.models.adapters.TaskAdapter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskListFile {
    private final List<TaskAdapter> taskList = new ArrayList<>();
    private final Path path = Paths.get("TaskListFile.json");
    private final Gson gson;

    public TaskListFile() {
        this.gson = new Gson();
    }


    public void initializeFile() {
        if (!Files.exists(path)) {
            clearFileContent();
        }
    }

    public void addContent(String task) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toString(), true))) {
            bufferedWriter.append(task).append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkFileContainsContent() {
        try {
            return Files.size(path) != 0;
        } catch (IOException e) {
            return true;
        }
    }

    public void clearFileContent() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toString(), false))) {
            bufferedWriter.write("");
        } catch (IOException e) {
            System.out.println("Clean file error: " + e.getMessage());
        }
    }

    public void readFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toString()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                TaskAdapter task = gson.fromJson(line, TaskAdapter.class);
                taskList.add(task);
            }

            taskList.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
