package com.ss.uto.menu;

import com.ss.uto.dao.AirportDAO;
import com.ss.uto.entity.Airport;
import com.ss.uto.service.ConnectionUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DeleteAirportMenu {
    public static void show() throws SQLException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Which existing airport do you want to delete?");
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

            Airport airport = new Airport();
            System.out.print("Type the 3-letter airport code: ");
            try {
                String code = scanner.nextLine();
                if (code.length() == 3) {
                    airport.setIataId(code);

                }
            } catch (NoSuchElementException e) {
                scanner.close();
                ManageAirportsMenu.show();
            }


            AirportDAO aDao = null;
            try {
                aDao = new AirportDAO(new ConnectionUtil().getConnection());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                aDao.delete(airport);
                aDao.conn.commit();
            } catch (Exception e) {
                System.out.println("There was an error deleting the airport. Try again.");
                aDao.conn.rollback();
            } finally {
                aDao.conn.close();
                ManageAirportsMenu.show();
            }

        }


    }
}
