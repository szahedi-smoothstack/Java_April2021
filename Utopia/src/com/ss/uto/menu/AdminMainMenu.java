package com.ss.uto.menu;

import com.ss.uto.dao.AirportDAO;
import com.ss.uto.entity.Airport;
import com.ss.uto.service.ConnectionUtil;
import sun.security.x509.CertAttrSet;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AdminMainMenu {
    public static void show() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------------------------");
        System.out.println("Which of the following would you like to do?");
        System.out.println();
        System.out.println("1) Manage Flights");
        System.out.println("2) Manage Seats");
        System.out.println("3) Manage Tickets and Passengers");
        System.out.println("4) Manage Airports");
        System.out.println("5) Manage Travelers");
        System.out.println("6) Manage Employees");
        System.out.println("7) Override Trip Cancellation for a ticket");
        System.out.println("8) Go Back to Previous Menu");


        System.out.println();

        Integer selection = scanner.nextInt();
        do {
            switch (selection) {
                case 1:
                    ManageFlightsMenu.show();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Select only one of the given options!");
                    break;
            }
        } while(true);
    }


}
