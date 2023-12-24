package com.tiago.microapps.tasklist.view;

import java.util.Scanner;

public class StartTaskList {
    private final static Scanner scanner = new Scanner(System.in);

    public static void start() {
        while (true) {
            String pattern = "^[0-9]$";
            menuOptions();
            System.out.print("\nEnter an option: ");
            String optionMenu = scanner.nextLine();

            if (optionMenu.equalsIgnoreCase("0")) {
                break;
            }

            switch (optionMenu) {
                case "1":
                    break;
                case "2":
                    menuListOptions();
                    System.out.print("\nEnter an option: ");
                    String optionMenuList = scanner.nextLine();
                    if (optionMenuList.equalsIgnoreCase("0")) {
                        break;
                    }

                    break;
                default:
                    System.out.println("Invalid option...");
                    break;
            }
        }
    }

    private static void menuOptions() {
        String menuBar = "-".repeat(40);
        String titleApp = "***** Task List *****";
        String menuBarTitle = "*".repeat(titleApp.length());

        System.out.println(menuBar + "\n\n" +
                "\t" + titleApp + "\n\n" +
                "\t   1 - Add task\n" +
                "\t   2 - List tasks\n" +
                "\t   3 - Mark tasks as completed\n" +
                "\t   4 - Remove tasks\n" +
                "\t   0 - Exit\n\n" +
                "\t" + menuBarTitle + "\n\n" +
                menuBar);
    }

    private static void menuListOptions() {
        System.out.println("""
                \n\tList options:
                \t\t1 - List by Date
                \t\t2 - List by Priority
                \t\t3 - List by Category
                \t\t0 - Exit
                """);
    }
}
