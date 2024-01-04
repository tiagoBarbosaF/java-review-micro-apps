package com.tiago.microapps.tasklist.models.adapters;

import com.tiago.microapps.tasklist.models.records.Category;
import lombok.Getter;

@Getter
public class CategoryAdapter {
    private String id;
    private String description;

    public CategoryAdapter(Category category){
        this.id = category.id();
        this.description = category.description();
    }
}
