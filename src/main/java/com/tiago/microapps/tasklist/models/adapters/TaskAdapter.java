package com.tiago.microapps.tasklist.models.adapters;

import com.tiago.microapps.tasklist.models.enums.Priority;
import com.tiago.microapps.tasklist.models.records.Category;
import com.tiago.microapps.tasklist.models.records.Task;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class TaskAdapter {
    private long id;
    private String description;
    private LocalDateTime dateTime;
    private Priority priority;
    private boolean status;
    private List<Category> categories;

    public TaskAdapter(Task task) {
        this.id = task.id();
        this.description = task.description();
        this.dateTime = task.dateTime();
        this.priority = task.priority();
        this.status = task.status();
        this.categories = task.categories();
    }

    public void test(boolean newStatus) {
        this.status = newStatus;
    }
}
