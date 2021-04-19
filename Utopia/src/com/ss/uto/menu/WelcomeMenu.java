package com.ss.uto.menu;

import com.ss.uto.service.AdminService;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class WelcomeMenu {
    public static void welcome() {

        AdminService admin = new AdminService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Utopia Airlines Management System. Which category of user are you?");
        System.out.println();
        System.out.println("1) Employee");
        System.out.println("2) Administrator");
        System.out.println("3) Traveler");
        System.out.println("4) Exit");
        System.out.println();
        System.out.print("? ");

        Integer selection;

        do {
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    EmployeeMainMenu.show();
                    break;
                case 2:
                    AdminMainMenu.show();
                    break;
                case 3:
                    TravelerMainMenu.show();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Please select only the options above.");
            }
        } while(true);
    }


    public static void main(String[] args) {
        WelcomeMenu.welcome();
    }
}
