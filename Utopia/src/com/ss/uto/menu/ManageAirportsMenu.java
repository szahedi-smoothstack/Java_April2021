package com.ss.uto.menu;

import com.ss.uto.dao.AirportDAO;
import com.ss.uto.entity.Airport;
import com.ss.uto.service.ConnectionUtil;

import java.util.List;
import java.util.Scanner;

public class ManageAirportsMenu {
    public static void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which of the following would you like to do?");
        System.out.println();
        System.out.println("---------------------------------");
        try {
            AirportDAO aDao = new AirportDAO(new ConnectionUtil().getConnection());
            List<Airport> airports = aDao.getAll();
            for (Airport a : airports) {
                System.out.println(a.getIataId() + "\t" + a.getCity());
            }
            System.out.println("---------------------------------");
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("1) Add Airports");
        System.out.println("2) Update Airports");
        System.out.println("3) Delete Airports");
        System.out.println("4) Go Back to Previous Menu");


        System.out.println();

        Integer selection;
        do {
            try {
                System.out.print("? ");
                selection = scanner.nextInt();

                if (selection == 1) {
                    AddAirportMenu.show();
                } else if (selection == 2) {
                    UpdateAirportMenu.show();
                } else if (selection == 3) {
                    DeleteAirportMenu.show();
                } else if (selection == 4) {
                    AdminMainMenu.show();
                } else {
                    System.out.println("Invalid selection. Please try again");
                }
            } catch (Exception e) {
                System.out.println("Error");
                scanner.next();
            }
        } while(true);
    }
}
