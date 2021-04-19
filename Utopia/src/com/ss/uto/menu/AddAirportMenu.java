package com.ss.uto.menu;

import com.ss.uto.dao.AirportDAO;
import com.ss.uto.entity.Airport;
import com.ss.uto.service.ConnectionUtil;

import java.util.Scanner;

public class AddAirportMenu {
    public static void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a new city and airport code");
        System.out.println();
        do {

            try {
                System.out.print("Airport code: ");
                String airportCode = scanner.nextLine();
                if (airportCode.length() > 3) {
                    System.out.println("Airport code must be less than 3 characters!");
                    scanner.next();
                    break;
                }
                System.out.print("City: ");
                String city = scanner.nextLine();
                Airport airport = new Airport();
                airport.setIataId(airportCode);
                airport.setCity(city);

//                AirportDAO aDao = new AirportDAO(new ConnectionUtil().getConnection());
//                try {
//                    aDao.addAirport(airport);
//                    aDao.conn.commit();
//                } catch (Exception e) {
//                    System.out.println("There was an error adding the airport. Try again.");
//                    aDao.conn.rollback();
//                    break;
//                } finally {
//                    aDao.conn.close();
//                    ManageAirportsMenu.show();
//                }

            } catch (Exception e) {
                System.out.println("There was an error.");
                scanner.next();
            }

        } while(true);

    }

}
