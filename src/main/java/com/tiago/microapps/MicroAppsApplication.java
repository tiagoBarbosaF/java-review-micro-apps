package com.tiago.microapps;

import com.tiago.microapps.tasklist.models.adapters.TaskAdapter;
import com.tiago.microapps.tasklist.models.records.Category;
import com.tiago.microapps.tasklist.models.records.Task;
import com.tiago.microapps.tasklist.models.enums.Priority;
import com.tiago.microapps.view.GeneralMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MicroAppsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MicroAppsApplication.class, args);
    }

    @Override
    public void run(String... args) {
		GeneralMenu.start();
    }
}
