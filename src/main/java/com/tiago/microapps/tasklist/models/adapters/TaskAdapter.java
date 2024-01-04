package com.tiago.microapps.tasklist.models.adapters;

import com.tiago.microapps.tasklist.models.enums.Priority;
import com.tiago.microapps.tasklist.models.records.Task;
import lombok.Getter;
import lombok.ToString;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@ToString
public class TaskAdapter {
    private String id;
    private String description;
    private String dateTime;
    private Priority priority;
    private boolean status;
    private List<CategoryAdapter> categories;

    public TaskAdapter(Task task) {
        this.id = task.id();
        this.description = task.description();
        this.dateTime = task.dateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
        this.priority = task.priority();
        this.status = task.status();
        this.categories = task.categories();
    }

    public void updateStatus(boolean newStatus) {
        this.status = newStatus;
    }
}
