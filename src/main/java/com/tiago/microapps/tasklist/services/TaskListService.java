package com.tiago.microapps.tasklist.services;

import com.tiago.microapps.tasklist.models.records.TaskDetails;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskListService {
    public void getListByMonth(int month) {
        DateTimeFormatter dataPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        List<TaskDetails> taskDetails = TaskListFile.readFromFile();
        taskDetails.stream()
                .filter(task -> LocalDateTime.parse(task.datetime(), dataPattern).getMonth().getValue() == month)
                .forEach(task -> System.out.println("\nTask\n" +
                        "Description: " + task.description() +
                        "\nDate: " + task.datetime() +
                        "\nPriority: " + task.priority() +
                        "\nTags: " + String.join(", ", task.categoryDetails())));
    }
}
