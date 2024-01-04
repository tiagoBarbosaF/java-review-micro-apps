package com.tiago.microapps.view;

import com.tiago.microapps.simpleCalculator.view.StartCalculator;
import com.tiago.microapps.tasklist.view.StartTaskList;

import java.util.Scanner;

public class GeneralMenu {
    private final static Scanner scanner = new Scanner(System.in);
    private final StartCalculator startCalculator;

    public GeneralMenu(StartCalculator startCalculator) {
        this.startCalculator = startCalculator;
    }

    public void start() {
        while (true) {
            menuOptions();
            System.out.print("\nEnter an option: ");
            String optionMenu = scanner.nextLine();

            if (optionMenu.equalsIgnoreCase("0")) {
                break;
            }

            switch (optionMenu) {
                case "1":
                    startCalculator.start();
                    break;
                case "2":
                    StartTaskList.start();
                    break;
                default:
                    System.out.println("Invalid operation...");
                    break;
            }
        }
    }

    private static void menuOptions() {
        String menuBar = "-".repeat(50);
        final String titleApp = "==== General Menu ====";
        String titleBar = "=".repeat(titleApp.length());

        System.out.println("\n" + menuBar + "\n" +
                titleApp + "\n" +
                "\t\t1 - Simple calculator\n" +
                "\t\t2 - Task list\n" +
                "\t\t0 - Exit\n\n" +
                titleBar + "\n\n" +
                menuBar);
    }
}
