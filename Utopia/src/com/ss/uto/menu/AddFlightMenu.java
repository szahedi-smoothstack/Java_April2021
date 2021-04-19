package com.ss.uto.menu;

import com.ss.uto.dao.AirportDAO;
import com.ss.uto.entity.Airport;
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.Route;
import com.ss.uto.service.AdminService;
import com.ss.uto.service.ConnectionUtil;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class AddFlightMenu {
    public static void show() throws SQLException, ClassNotFoundException {
        AdminService as = new AdminService();
        Boolean loop = true;
        AirportDAO aDao = new AirportDAO(new ConnectionUtil().getConnection());
        Flight flight = new Flight();
        Route route = new Route();
        List<Airport> airports = aDao.getAll();

        Scanner scanner = new Scanner(System.in);
        while(loop) {
            System.out.println("---------------------------------------------");
            System.out.println("Choose an origin airport: ");
            try {

                Integer count = 1;
                for (Airport a : airports) {
                    System.out.println(count + ".\t" + a.getIataId() + "\t" + a.getCity());
                    count++;
                }
//                System.out.println("---------------------------------");
                System.out.println();

                System.out.println("Select # of the airport or select " + count + " to create a new airport");
                System.out.println("Select 0 to cancel and go back");
                System.out.print("? ");
                Integer selection = scanner.nextInt();
                if (selection <= airports.size() && selection >= 1) {
//                    Route route = new Route();
//                    flight.getRoute().getOriginAirport().setIataId(airports.get(selection-1).getIataId());
                    route.getOriginAirport().setIataId(airports.get(selection-1).getIataId());
                    loop = false;
                }
                else if (selection == count) {
                    AddAirportMenu.show();
                    return;
                }
                else if (selection == 0) {
                    ManageFlightsMenu.show();
                    break;
                }
                else {
                    System.out.println("Try again");
                    scanner.next();
                    return;
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        loop = true;
        while (loop) {
            try {
                Integer count = 1;
                for (Airport a : airports) {
                    System.out.println(count + ".\t" + a.getIataId() + "\t" + a.getCity());
                    count++;
                }
                System.out.println("---------------------------------");
                System.out.println();
                System.out.println("Select an destination airport or select " + count + " to create a new airport");
                System.out.println("Select 0 to cancel and go back");

                Integer selection = scanner.nextInt();

                if (selection <= airports.size() && selection >= 1) {
//                    Route route = new Route();
//                    flight.getRoute().getDestinationAirport().setIataId(airports.get(selection-1).getIataId());
                    route.getDestinationAirport().setIataId(airports.get(selection-1).getIataId());
                    loop = false;
                }
                else if (selection == 0) {
                    ManageFlightsMenu.show();
                    break;
                }
                else {
                    System.out.println("Try again");
                    scanner.next();
                    return;
                }
            } catch (Exception e) {
                scanner.next();
                break;
            }
        }

        loop = true;
        while (loop) {
            try {
                System.out.print("Enter a departure datetime (yyyy-mm-dd hh:mm:ss): ");
                String date = scanner.nextLine();


                flight.setDepartureTime(date);
                loop = false;
            } catch (Exception e) {
                scanner.next();
                break;
            }
        }

        as.addFlight(flight);
        return;
    }
}
