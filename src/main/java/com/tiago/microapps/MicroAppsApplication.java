package com.tiago.microapps;

import com.tiago.microapps.simpleCalculator.view.StartCalculator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroAppsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MicroAppsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StartCalculator.Start();
	}
}
