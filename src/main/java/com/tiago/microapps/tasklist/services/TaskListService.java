package com.tiago.microapps.tasklist.services;

import com.tiago.microapps.tasklist.models.enums.Priority;
import com.tiago.microapps.tasklist.models.records.TaskDetails;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskListService {
    private final DateTimeFormatter dataPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final List<TaskDetails> taskDetails = TaskListFile.readFromFile();

    public void getListByMonth(int month) {
        taskDetails.stream()
                .filter(task -> LocalDateTime.parse(task.datetime(), dataPattern).getMonth().getValue() == month)
                .forEach(task -> System.out.println(getResponseTemplateDataFilter(task)));
    }

    public void getListByDay(int day) {
        taskDetails.stream()
                .filter(task -> LocalDateTime.parse(task.datetime(), dataPattern).getDayOfMonth() == day)
                .forEach(task -> System.out.println(getResponseTemplateDataFilter(task)));
    }

    public void getListByYear(int year) {
        taskDetails.stream()
                .filter(task -> LocalDateTime.parse(task.datetime(), dataPattern).getYear() == year)
                .forEach(task -> System.out.println(getResponseTemplateDataFilter(task)));
    }

    public void getListByPriority(int priority) {
        taskDetails.stream()
                .filter(task -> task.priority() == Priority.values()[priority - 1])
                .forEach(task -> System.out.println(getResponseTemplateDataFilter(task)));
    }

    public void getListByCategory(String category) {
        taskDetails.stream()
                .filter(task -> task.categoryDetails().contains(category.toLowerCase()))
                .forEach(task -> System.out.println(getResponseTemplateDataFilter(task)));
    }

    private static String getResponseTemplateDataFilter(TaskDetails task) {
        return "\nTask" +
                "\nID: " + task.id() +
                "\nDescription: " + task.description() +
                "\nDate: " + task.datetime() +
                "\nPriority: " + task.priority() +
                "\nComplete: " + task.status() +
                "\nTags: " + String.join(", ", task.categoryDetails());
    }
}
