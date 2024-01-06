package com.tiago.microapps.tasklist.models.records;

import com.tiago.microapps.tasklist.models.adapters.TaskAdapter;
import com.tiago.microapps.tasklist.models.enums.Priority;

import java.util.List;

public record TaskDetails(
        String id,
        String description,
        String datetime,
        Priority priority,
        boolean status,
        List<String> categoryDetails
) {
    public TaskDetails(TaskAdapter task) {
        this(task.getId(), task.getDescription(), task.getDateTime(), task.getPriority(), task.isStatus(), task.getCategories());
    }
}
