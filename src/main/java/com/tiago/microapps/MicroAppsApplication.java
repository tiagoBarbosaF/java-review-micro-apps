package com.tiago.microapps;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tiago.microapps.interfaces.FileService;
import com.tiago.microapps.tasklist.models.adapters.CategoryAdapter;
import com.tiago.microapps.tasklist.models.adapters.TaskAdapter;
import com.tiago.microapps.tasklist.models.records.Category;
import com.tiago.microapps.tasklist.models.records.Task;
import com.tiago.microapps.tasklist.models.enums.Priority;
import com.tiago.microapps.tasklist.services.TaskListFile;
import com.tiago.microapps.view.GeneralMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class MicroAppsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MicroAppsApplication.class, args);
    }

    @Override
    public void run(String... args) {
//		GeneralMenu.start();
        TaskListFile taskListFile = new TaskListFile();
        String randomId = UUID.randomUUID().toString().substring(0, 8);
        int option = 3;

        switch (option) {
            case 1:
                taskListFile.clearFileContent();
                break;
            case 2:
                LocalDateTime localDateTime = LocalDateTime.of(2024, 1, 10, 10, 0, 0);
                LocalDateTime localDateTime2 = LocalDateTime.of(2024, 1, 15, 22, 0, 0);
                Task academia = new Task(randomId, "academia", localDateTime, Priority.MEDIUM, false,
                        List.of(
                                new CategoryAdapter(new Category(randomId, "fitness")),
                                new CategoryAdapter(new Category(randomId, "lifestyle"))
                        ));
                Task show = new Task(randomId, "show", localDateTime2, Priority.HIGH, false,
                        List.of(new CategoryAdapter(new Category(randomId, "music"))));
                TaskAdapter taskAdapter1 = new TaskAdapter(academia);
                TaskAdapter taskAdapter2 = new TaskAdapter(show);
                Gson gson = new Gson();
                String json1 = gson.toJson(taskAdapter1);
                String json2 = gson.toJson(taskAdapter2);
                System.out.println(json1);
                System.out.println(json2);

                taskListFile.addContent(json1);
                taskListFile.addContent(json2);
                break;
            case 3:
                taskListFile.readFromFile();
                break;
        }

    }
}
