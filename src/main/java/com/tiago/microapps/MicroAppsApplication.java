package com.tiago.microapps;

import com.google.gson.Gson;
import com.tiago.microapps.tasklist.models.adapters.TaskAdapter;
import com.tiago.microapps.tasklist.models.enums.Priority;
import com.tiago.microapps.tasklist.models.records.Category;
import com.tiago.microapps.tasklist.models.records.Task;
import com.tiago.microapps.tasklist.models.records.TaskDetails;
import com.tiago.microapps.tasklist.services.TaskListFile;
import com.tiago.microapps.tasklist.services.TaskListService;
import com.tiago.microapps.view.GeneralMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@SpringBootApplication
public class MicroAppsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MicroAppsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        GeneralMenu.start();
//        testCases();

    }

    private static void testCases() {
        List<String> randomIds = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomIds.add(UUID.randomUUID().toString().substring(0, 8));
        }
        int option = 4;

        switch (option) {
            case 1:
                TaskListFile.clearFileContent();
                break;
            case 2:
                LocalDateTime localDateTime = LocalDateTime.of(2024, 1, 10, 10, 0, 0);
                LocalDateTime localDateTime2 = LocalDateTime.of(2024, 1, 15, 22, 0, 0);
                Task academia = new Task(randomIds.get(0), "academia", localDateTime, Priority.MEDIUM, false,
                        List.of(
                                new Category(randomIds.get(1), "fitness"),
                                new Category(randomIds.get(2), "lifestyle")
                        ));
                Task show = new Task(randomIds.get(3), "show", localDateTime2, Priority.HIGH, false,
                        List.of(
                                new Category(randomIds.get(4), "music"),
                                new Category(randomIds.get(5), "lifestyle")));
                TaskAdapter taskAdapter1 = new TaskAdapter(academia);
                TaskAdapter taskAdapter2 = new TaskAdapter(show);
                Gson gson = new Gson();
                String json1 = gson.toJson(taskAdapter1);
                String json2 = gson.toJson(taskAdapter2);
                System.out.println();
                System.out.println(json1);
                System.out.println(json2);

                TaskListFile.addContent(json1);
                TaskListFile.addContent(json2);
                break;
            case 3:
                System.out.println();
                DateTimeFormatter dataPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                List<TaskDetails> taskDetails = TaskListFile.readFromFile();

                taskDetails.forEach(System.out::println);
                System.out.println();
                taskDetails.stream().map(task -> LocalDateTime.parse(task.datetime(),dataPattern))
                        .forEach(System.out::println);
                System.out.println();
                taskDetails.stream()
                        .filter(task-> LocalDateTime.parse(task.datetime(),dataPattern).getDayOfMonth() == 15)
                        .forEach(System.out::println);

                break;
            case 4:
                TaskListService taskListService = new TaskListService();
                System.out.println("\nGet by month");
                taskListService.getListByMonth(1);
                System.out.println("\nGet by day");
                taskListService.getListByDay(10);
                System.out.println("\nGet by Year");
                taskListService.getListByYear(2024);
                System.out.println("\nGet by priority");
                taskListService.getListByPriority(3);
                System.out.println("\nGet by category");
                taskListService.getListByCategory("Music");
                break;
        }
    }
}
