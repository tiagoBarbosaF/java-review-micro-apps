package com.tiago.microapps.tasklist.models.records;

import com.tiago.microapps.tasklist.models.enums.Priority;

import java.time.LocalDateTime;
import java.util.List;

public record Task(
        String id,
        String description,
        LocalDateTime dateTime,
        Priority priority,
        boolean status,
        List<Category> categories
) {
}
