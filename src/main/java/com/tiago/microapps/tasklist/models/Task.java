package com.tiago.microapps.tasklist.models;

import com.tiago.microapps.tasklist.models.enums.Priority;

import java.util.Date;
import java.util.List;

public record Task(
        long id,
        String description,
        Date dateTime,
        Priority priority,
        boolean status,
        List<Category> categories
) {
}
