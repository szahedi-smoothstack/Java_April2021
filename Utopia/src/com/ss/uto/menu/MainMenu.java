package com.ss.uto.menu;

import java.sql.SQLException;
import java.util.Scanner;
import com.ss.uto.entity.Airplane;
import com.ss.uto.entity.Airport;
import com.ss.uto.entity.Booking;
import com.ss.uto.entity.BookingAgent;
import com.ss.uto.entity.BookingUser;
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.Passenger;
import com.ss.uto.entity.Route;
//import com.ss.uto.entity.SeatAvailability;
//import com.ss.uto.entity.Ticket;
import com.ss.uto.entity.User;
import com.ss.uto.entity.UserRole;
import com.ss.uto.service.AdminService;
import com.ss.uto.service.EmployeeService;
//import com.ss.uto.service.TravelerService;


public class MainMenu {


    public static void mainMenu() {

        System.out.println("Please choose your role");
        System.out.println("1) Employee " + "\n" +
                "2) Administrator " + "\n" +
                "3) Travelor");
    }

    public static void subMenu() {

        System.out.println("1) Enter Flights to Manage " + "\n" +
                "2) Quit to previous");
    }

    public static void subMenuTwo() {
        System.out.println("1) View More details about the flight " + "\n" +
                "2) Update the details about the flight " + "\n" +
                "3) Add Seats to flight" + "\n" +
                "4) Quit the application");
    }

    public static void subMenuThree(){
        System.out.println("Pick the Seat Class you want to add seats of, to your flight:");
        System.out.println("1) First " + "\n" +
                "2) Business " + "\n" +
                "3) Economy" + "\n" +
                "4) Quit to previous menu");
    }


    public static void travelerMainMenu() {
        System.out.println("1) Book a Ticket " + "\n" +
                "2) Cancel an Upcoming Trip " + "\n" +
                "3) Quit to Previous");
    }

    public static void travelerSubMenu() {
        System.out.println("\n");
        System.out.println("1) View Flight Details " + "\n" +
                "2) First " + "\n" +
                "3) Business " + "\n" +
                "4) Economy " + "\n" +
                "5) Quit to previous menu ");
    }

    public static void main(String[] args) {


        Airport airport = new Airport();
        Flight flight = new Flight();
        Route route = new Route();
        Airplane airplane = new Airplane();
        Booking booking = new Booking();
        Passenger passenger = new Passenger();
        UserRole userRole = new UserRole();
//        Ticket ticket = new Ticket();
//        SeatAvailability seatAvail = new SeatAvailability();
        User user = new User();
        BookingAgent bookAgent = new BookingAgent();
        BookingUser bookUser = new BookingUser();

        AdminService as = new AdminService();
//        EmployeeService es = new EmployeeService();
//        TravelerService ts = new TravelerService();

        Scanner scan = new Scanner(System.in);


        boolean mainBack = false;

        do{
            mainMenu();

            String identityCode = scan.nextLine();

//            if(identityCode.charAt(0) == '1'){
//
//                subMenu();
//
//                String employeeInput = scan.nextLine();
//
//
//                if(employeeInput.charAt(0) == '1') {
//
//
//                    try {
//
//
//                        // IMPROVE THIS BY OUTPUTTING TABLE SIDE BY SIDE WHEN GET A CHANCE
//                        System.out.println("Select which flight you want to manage " + "\n");
//
//                        es.getAllOriginFlightsWithCity();
//                        System.out.print("\n");
//
//                        es.getAllDestFlightsWithCity();
//
//
//
//
//                        System.out.println("\n" + "Select id from above list to manage...");
//                        String routeId = scan.nextLine();
//
//                        System.out.println("Select option from below lists..." + "\n");
//
//                        subMenuTwo();
//
//                        boolean empBack = false;
//                        do{
//                            String option = scan.nextLine();
//
//                            if(option.charAt(0) == '1') {
//
//                                es.getAllFlightDetail(routeId);
//                                System.out.println("\n" + "Press 2 to return to previous menu");
//
//                                String input = scan.nextLine();
//
//                                if(input.equals("2")) {
//                                    subMenuTwo();
//                                    empBack = true;
//                                }
//
//                            }
//
//
//                            if(option.charAt(0) == '2') {
//
//                                System.out.println("You have choosen to update the below flight" + "\n");
//
//                                es.getAllFlightDetail(routeId);
//
//                                System.out.println("\n" + "Enter 'quit' at any prompt to cancel operation");
//
//
//                                System.out.println("\n");
//                                System.out.println("Please enter new 3 letter Origin airport code or N/A for no change)");
//                                String originCode = scan.nextLine();
//
//                                System.out.println("Please enter new 3 letter Destination airport code or N/A for no change)");
//                                String destCode = scan.nextLine();
//
//                                System.out.println("Please enter new departure date and time(YYYY-MM-DD HH:MM:SS) or N/A for no change");
//                                String departureDateTime = scan.nextLine();
//
//
//                                if(originCode.equals("quit") || destCode.equals("quit") || departureDateTime.equals("quit")) {
//                                    //scan.close();
//                                    return;
//                                }
//
//
//
//                                route.setId(Integer.parseInt(routeId));
//                                flight.setRouteId(route);
//                                flight.setId(Integer.parseInt(routeId));
//
//
//                                if(!(departureDateTime.equals("N/A"))) {
//                                    flight.setDepartTime(departureDateTime);
//                                    as.updateSpecificFlights(flight);
//                                }
//
//
//                                route.setOriginAirport(originCode);
//
//                                route.setDesAirport(destCode);
//
//                                if(!(originCode.equals("N/A") && destCode.equals("N/A"))) {
//                                    es.updateRoute(route,originCode,destCode);
//                                }
//
//                                System.out.println("Information Successfully Updated!");
//
//                                subMenuTwo();
//                                empBack = true;
//                            }
//
//                            if(option.charAt(0) == '3') {
//
//                                subMenuThree();
//
//                                String seatClass = scan.nextLine();
//                                if(seatClass.charAt(0) == '1') {
//                                    System.out.println("Exisiting number of seats: ");
//                                    es.getSpecificSeat(routeId, "1");
//                                    System.out.println("\n");
//
//
//                                    System.out.println("Enter a new number of seats: ");
//                                    String seats = scan.nextLine();
//                                    seatAvail.setId(Integer.parseInt(routeId));
//                                    flight.setId(Integer.parseInt(routeId));
//                                    seatAvail.setFlightId(flight);
//                                    seatAvail.setFirstClass(Integer.parseInt(seats));
//                                    es.updateSeats("1",seatAvail);
//
//                                    System.out.println("Seats updated!");
//                                    return;
//                                }
//
//                                if(seatClass.charAt(0) == '2') {
//                                    System.out.println("Exisiting number of seats: ");
//                                    System.out.println("\n");
//                                    es.getSpecificSeat(routeId,"2");
//                                    System.out.println("\n");
//
//
//                                    System.out.println("Enter a new number of seats: ");
//                                    String seats = scan.nextLine();
//                                    seatAvail.setId(Integer.parseInt(routeId));
//                                    flight.setId(Integer.parseInt(routeId));
//                                    seatAvail.setFlightId(flight);
//                                    seatAvail.setBusinessClass(Integer.parseInt(seats));
//                                    es.updateSeats("2",seatAvail);
//
//                                    System.out.println("Seats updated!");
//                                    return;
//                                }
//
//                                if(seatClass.charAt(0) == '3') {
//                                    System.out.println("Exisiting number of seats: ");
//                                    System.out.println("\n");
//                                    es.getSpecificSeat(routeId, "3");
//                                    System.out.println("\n");
//
//                                    System.out.println("Enter a new number of seats: ");
//                                    String seats = scan.nextLine();
//                                    seatAvail.setId(Integer.parseInt(routeId));
//                                    flight.setId(Integer.parseInt(routeId));
//                                    seatAvail.setFlightId(flight);
//                                    seatAvail.setEconomyClass(Integer.parseInt(seats));
//                                    es.updateSeats("3",seatAvail);
//
//                                    System.out.println("Seats updated!");
//                                    return;
//                                }
//
//                                if(seatClass.charAt(0) == '4') {
//
//                                    subMenuTwo();
//                                    empBack = true;
//                                }
//                            }
//
//                            if(option.charAt(0) == '4') {
//                                return;
//                            }
//                        }while(empBack);
//
//
//                    } catch (SQLException e) {
//                        System.out.println("Exception: " + e);
//                    }
//
//
//                }
//
//                if(employeeInput.charAt(0) == '2') {
//
//                    mainBack = true;
//                }
//
//
//            }
//


            //----------------------------------------------------------------------------------------------------------------------------------

            // FOR ADMINISTRATOR

            if(identityCode.charAt(0) == '2'){

                System.out.println("Select the number from this options: " + "\n" +
                        "1) Add/Update/Delete/Read Flights" + "\n" +
                        "2) Add/Update/Delete/Read Seats" + "\n" +
                        "3) Add/Update/Delete/Read Tickets and Passengers" + "\n" +
                        "4) Add/Update/Delete/Read Airports" + "\n" +
                        "5) Add/Update/Delete/Read Travelors" + "\n" +
                        "6) Add/Update/Delete/Read Employees" + "\n" +
                        "7) Over-ride Trip Cancellation for a ticket." + "\n");

                String subMenu = scan.nextLine();
                //---------------------------------------------------------------------------------------------------------------------
                // Flight Menu
                if(subMenu.charAt(0) == '1') {


                    System.out.println("Please Choose one of the number: ");

                    System.out.println("Flight " + "\n" +
                            "1) Add " + "\n" +
                            "2) Update " + "\n" +
                            "3) Delete " + "\n" +
                            "4) Read " + "\n");
                    String userOperation = scan.nextLine();

                    if(userOperation.charAt(0) == '1') {


                        try {
                            System.out.println("Please Choose what route to take from "
                                    + "one of the options below...");

                            as.getAllRoutes();

                            System.out.println("Enter route id... ");
                            String routeId = scan.nextLine();


                            System.out.println("Please Choose airplane id based "
                                    + "on your max capacity need..");

                            as.getAllAriplaneType();


                            System.out.println("Enter airplane id... ");
                            String airplaneId = scan.nextLine();

                            System.out.println("Enter departure time(YYYY-MM-DD HH:MM:SS");
                            String departureDateTime = scan.nextLine();

                            System.out.println("Enter total reserved seats");
                            String reservedSeats = scan.nextLine();

                            System.out.println("Enter total seat price");
                            String seatPrice = scan.nextLine();

                            route.setId(Integer.parseInt(routeId));
                            airplane.setId(Integer.parseInt(airplaneId));

                            flight.setRouteId(route);
                            flight.setAirplaneId(airplane);
                            flight.setDepartTime(departureDateTime);
                            flight.setReservedSeats(Integer.parseInt(reservedSeats));
                            flight.setSeatPrice(Double.parseDouble(seatPrice));
                        } catch (SQLException e1) {
                            System.out.println("Exception: " + e1);
                        }

                        try {
                            as.addFlight(flight);
                            System.out.println("Flight successfully added");
                            return;

                        } catch (SQLException e) {

                            System.out.println("Exception: " + e);
                        } finally {
                            //scan.close();
                        }
                    }

                    if(userOperation.charAt(0) == '2') {


                        try {

                            System.out.println("Please choose which flight id to update from options below...");
                            as.getAllFlights();
                            System.out.println("Enter flight code to update...");
                            String flightId = scan.nextLine();

                            System.out.println("Please ente new route id from options below...");
                            as.getAllRoutes();
                            System.out.println("Enter new route id...");
                            String routeId = scan.nextLine();

                            System.out.println("Please enter new airplane id from options below...");
                            as.getAllAriplaneType();
                            System.out.println("Please enter new airplane id...");
                            String airplaneId = scan.nextLine();

                            System.out.println("Please enter new departure date and time(YYYY-MM-DD HH:MM:SS...");
                            String departureDateTime = scan.nextLine();

                            System.out.println("Please enter new reserved seats...");
                            String reservedSeats = scan.nextLine();

                            System.out.println("Please enter new seat price($)....");
                            String seatPrice = scan.nextLine();

                            flight.setId(Integer.parseInt(flightId));
                            route.setId(Integer.parseInt(routeId));
                            flight.setRouteId(route);
                            airplane.setId(Integer.parseInt(airplaneId));
                            flight.setAirplaneId(airplane);
                            flight.setDepartTime(departureDateTime);
                            flight.setReservedSeats(Integer.parseInt(reservedSeats));
                            flight.setSeatPrice(Double.parseDouble(seatPrice));

                            as.updateFlight(flight);
                            System.out.println("Flight Successfully Updated!");
                            return;

                        }catch (SQLException e1) {
                            System.out.println("Exception: " + e1);
                        }

                        try {
                            as.updateAirport(airport);
                        } catch (SQLException e) {
                            System.out.println("Exception: " + e);
                        } finally {
                            //scan.close();
                        }
                    }

                    if(userOperation.charAt(0) == '3') {
                        try {
                            System.out.println("Please choose which flight id to delete form options from below...");
                            as.getAllFlights();
                            System.out.println("Enter flight id to delete...");
                            String flightId = scan.nextLine();

                            flight.setId(Integer.parseInt(flightId));

                            as.deleteFlight(flight);
                            System.out.println("Flight Successfully Deleted!");
                            return;

                        } catch (SQLException e1) {
                            System.out.println("Exception: " + e1);
                        }
                    }

                    if(userOperation.charAt(0) == '4') {

                        try {
                            as.getAllFlights();
                            return;
                        } catch (SQLException e) {

                            System.out.println("Exception: " + e);
                        } finally {
                            //scan.close();
                        }
                    }
                }

                //---------------------------------------------------------------------------------------------------------------------
                // Seats Menu
                if(subMenu.charAt(0) == '2') {
                    System.out.println("Please Choose one of the number: ");

                    System.out.println("Seats " + "\n" +
                            "1) Add " + "\n" +
                            "2) Update " + "\n" +
                            "3) Delete " + "\n" +
                            "4) Read " + "\n");
                    String userOperation = scan.nextLine();

                    if(userOperation.charAt(0) == '1') {


                        try {


                            System.out.println("Select what type of seat you want to add...");
                            System.out.println("1) First Class" + "\n" +
                                    "2) Business Class" + "\n" +
                                    "3) Economy Class");

                            String addSeatType = scan.nextLine();

                            if(addSeatType.equals("1")) {

                                System.out.println("Please choose seat id from below to add more seats...");
                                es.getAllSeat();

                                String selectSeatId = scan.nextLine();
                                seatAvail.setId(Integer.parseInt(selectSeatId));

                                System.out.println("Please choose flight id from below to add more seats...");
                                as.getAllFlights();

                                String selectFlightId = scan.nextLine();

                                System.out.println("Please enter how many First Class seats you want to add...");
                                String totalSeats = scan.nextLine();
                                flight.setId(Integer.parseInt(selectFlightId));
                                seatAvail.setFlightId(flight);
                                seatAvail.setFirstClass(Integer.parseInt(totalSeats));
                                es.updateSeats("1", seatAvail);

                                System.out.println("Seats successfully added!");
                                return;

                            }

                            if(addSeatType.equals("2")) {

                                System.out.println("Please choose seat id from below to add more seats...");
                                es.getAllSeat();

                                String selectSeatId = scan.nextLine();
                                seatAvail.setId(Integer.parseInt(selectSeatId));

                                System.out.println("Please choose flight id from below to add more seats...");
                                as.getAllFlights();

                                String selectFlightId = scan.nextLine();

                                System.out.println("Please enter how many Business Class seats you want to add...");
                                String totalSeats = scan.nextLine();
                                flight.setId(Integer.parseInt(selectFlightId));
                                seatAvail.setFlightId(flight);
                                seatAvail.setBusinessClass(Integer.parseInt(totalSeats));
                                es.updateSeats("2", seatAvail);

                                System.out.println("Seats successfully added!");
                                return;



                            }
                            if(addSeatType.equals("3")) {

                                System.out.println("Please choose seat id from below to add more seats...");
                                es.getAllSeat();

                                String selectSeatId = scan.nextLine();
                                seatAvail.setId(Integer.parseInt(selectSeatId));

                                System.out.println("Please choose flight id from below to add more seats...");
                                as.getAllFlights();

                                String selectFlightId = scan.nextLine();

                                System.out.println("Please enter how many Economy Class seats you want to add...");
                                String totalSeats = scan.nextLine();
                                flight.setId(Integer.parseInt(selectFlightId));
                                seatAvail.setFlightId(flight);
                                seatAvail.setEconomyClass(Integer.parseInt(totalSeats));
                                es.updateSeats("3", seatAvail);

                                System.out.println("Seats successfully added!");
                                return;


                            }



                        } catch (SQLException e1) {
                            System.out.println("Exception: " + e1);
                        }
                    }

                    if(userOperation.charAt(0) == '2') {
                        try {


                            System.out.println("Select what type of seat you want to update...");
                            System.out.println("1) First Class" + "\n" +
                                    "2) Business Class" + "\n" +
                                    "3) Economy Class");

                            String addSeatType = scan.nextLine();

                            if(addSeatType.equals("1")) {

                                System.out.println("Please choose seat id from below to update seats...");
                                es.getAllSeat();

                                String selectSeatId = scan.nextLine();
                                seatAvail.setId(Integer.parseInt(selectSeatId));

                                System.out.println("Please choose flight id from below to update seats...");
                                as.getAllFlights();

                                String selectFlightId = scan.nextLine();

                                System.out.println("Please enter how many First Class seats you want to add to update ...");
                                String totalSeats = scan.nextLine();
                                flight.setId(Integer.parseInt(selectFlightId));
                                seatAvail.setFlightId(flight);
                                seatAvail.setFirstClass(Integer.parseInt(totalSeats));
                                es.updateSeats("1", seatAvail);

                                System.out.println("Seats successfully added!");
                                return;

                            }

                            if(addSeatType.equals("2")) {

                                System.out.println("Please choose seat id from below to update seats...");
                                es.getAllSeat();

                                String selectSeatId = scan.nextLine();
                                seatAvail.setId(Integer.parseInt(selectSeatId));

                                System.out.println("Please choose flight id from below to update seats...");
                                as.getAllFlights();

                                String selectFlightId = scan.nextLine();

                                System.out.println("Please enter how many Business Class seats you want to add to update...");
                                String totalSeats = scan.nextLine();
                                flight.setId(Integer.parseInt(selectFlightId));
                                seatAvail.setFlightId(flight);
                                seatAvail.setBusinessClass(Integer.parseInt(totalSeats));
                                es.updateSeats("2", seatAvail);

                                System.out.println("Seats successfully added!");
                                return;



                            }
                            if(addSeatType.equals("3")) {

                                System.out.println("Please choose seat id from below to update seats...");
                                es.getAllSeat();

                                String selectSeatId = scan.nextLine();
                                seatAvail.setId(Integer.parseInt(selectSeatId));

                                System.out.println("Please choose flight id from below to update seats...");
                                as.getAllFlights();

                                String selectFlightId = scan.nextLine();

                                System.out.println("Please enter how many Economy Class seats you want to add to update...");
                                String totalSeats = scan.nextLine();
                                flight.setId(Integer.parseInt(selectFlightId));
                                seatAvail.setFlightId(flight);
                                seatAvail.setEconomyClass(Integer.parseInt(totalSeats));
                                es.updateSeats("3", seatAvail);

                                System.out.println("Seats successfully added!");
                                return;


                            }


                        } catch (SQLException e1) {
                            System.out.println("Exception: " + e1);
                        }
                    }


                    if(userOperation.charAt(0) == '3') {
                        try {
                            System.out.println("Please choose seat id to delete from options below...");

                            es.getAllSeat();

                            String deleteSeatId = scan.nextLine();
                            seatAvail.setId(Integer.parseInt(deleteSeatId));


                            as.deleteSeats(seatAvail);
                            System.out.println("Information Successfully Deleted!");
                            return;

                        } catch (SQLException e1) {
                            System.out.println("Exception: " + e1);
                        }
                    }

                    if(userOperation.charAt(0) == '4') {

                        try {
                            es.getAllSeat();
                            return;
                        } catch (SQLException e) {

                            System.out.println("Exception: " + e);
                        } finally {
                            //scan.close();
                        }
                    }
                }

                //---------------------------------------------------------------------------------------------------------------------
                // Booking/Ticket Menu
                if(subMenu.charAt(0) == '3' || subMenu.charAt(0) == '5') {

                    System.out.println("Please select what to manage from options below...");
                    System.out.println("1) Tickets" + "\n" + "2) Passenger");
                    String subMenuTwo = scan.nextLine();

                    if(subMenuTwo.charAt(0) == '1') {
                        System.out.println("Please Choose one of the number: ");

                        System.out.println("Tickets " + "\n" +
                                "1) Add " + "\n" +
                                "2) Update " + "\n" +
                                "3) Delete " + "\n" +
                                "4) Read " + "\n");
                        String userOperation = scan.nextLine();

                        if(userOperation.charAt(0) == '1') {


                            try {

                                System.out.println("Please enter 1 if you are booking a ticket...");
                                String isActive = scan.nextLine();

                                System.out.println("Please enter enter a 8 letter/digit confirmation num...");
                                String confirmNum = scan.nextLine();

                                booking.setBookingActive(Integer.parseInt(isActive));
                                booking.setConfirmCode(confirmNum);
                                as.addBookings(booking);


                                System.out.println("1) Add a Ticket for Agent" + "\n" +
                                        "2) Add a Ticket for Employee(user)");

                                String whosTicket = scan.nextLine();
                                if(whosTicket.equals("1")) {

                                    System.out.println("Please select the booking id corrsponding your confirmation code you entered");


                                    as.getAllBookings();
                                    String bookId = scan.nextLine();

                                    booking.setId(Integer.parseInt(bookId));
                                    bookAgent.setBookingId(booking);

                                    System.out.println("Lets now enter your information" + "\n");
                                    System.out.println("Please enter your role from options below..." + "\n");
                                    System.out.println("id name");
                                    as.getAllUserRole();
                                    String roleId = scan.nextLine();
                                    System.out.println("Please enter your given name...");
                                    String name = scan.nextLine();
                                    System.out.println("Please enter your family name...");
                                    String familyName = scan.nextLine();
                                    System.out.println("Please enter your userName...");
                                    String userName = scan.nextLine();
                                    System.out.println("Please enter your email...");
                                    String email = scan.nextLine();
                                    System.out.println("Please enter your password...");
                                    String password = scan.nextLine();
                                    System.out.println("Please enter your phone...");
                                    String phone = scan.nextLine();


                                    userRole.setId(Integer.parseInt(roleId));
                                    user.setRoleId(userRole);
                                    user.setGivenName(name);
                                    user.setFamilyName(familyName);
                                    user.setUserName(userName);
                                    user.setEmail(email);
                                    user.setPassword(password);
                                    user.setPhone(phone);


                                    as.addEmployee(user);
                                    System.out.println("Please select your user id from names below...");
                                    as.getAllUsers();
                                    String userId = scan.nextLine();
                                    user.setId(Integer.parseInt(userId));
                                    bookAgent.setAgentId(user);
                                    as.addBookingAgent(bookAgent);

                                    System.out.println("Now lests enter ticket information...");


                                    ticket.setBookingId(booking);
                                    System.out.println("Select what type of ticket you want to book...");
                                    System.out.println("1) First Class" + "\n" +
                                            "2) Business Class" + "\n" +
                                            "3) Economy Class");

                                    String chooseTicket = scan.nextLine();
                                    if(chooseTicket.equals("1")) {
                                        ticket.setTicketType("first");
                                    }
                                    if(chooseTicket.equals("2")) {
                                        ticket.setTicketType("business");
                                    }
                                    if(chooseTicket.equals("3")) {
                                        ticket.setTicketType("economy");
                                    }
                                    ts.addTicket(ticket);

                                    System.out.println("Ticket successfully added!");


                                    return;


                                }
                                if(whosTicket.equals("2")){
                                    System.out.println("Please select the booking id corrsponding your confirmation code you entered");

                                    System.out.println("id act confirmCode");
                                    as.getAllBookings();
                                    String bookId = scan.nextLine();

                                    booking.setId(Integer.parseInt(bookId));
                                    bookUser.setBookingId(booking);

                                    System.out.println("Lets now enter your information" + "\n");
                                    System.out.println("Please enter your role from options below..." + "\n");
                                    System.out.println("id name");
                                    as.getAllUserRole();
                                    String roleId = scan.nextLine();
                                    System.out.println("Please enter your given name...");
                                    String name = scan.nextLine();
                                    System.out.println("Please enter your family name...");
                                    String familyName = scan.nextLine();
                                    System.out.println("Please enter your userName...");
                                    String userName = scan.nextLine();
                                    System.out.println("Please enter your email...");
                                    String email = scan.nextLine();
                                    System.out.println("Please enter your password...");
                                    String password = scan.nextLine();
                                    System.out.println("Please enter your phone...");
                                    String phone = scan.nextLine();

                                    userRole.setId(Integer.parseInt(roleId));
                                    user.setRoleId(userRole);
                                    user.setGivenName(name);
                                    user.setFamilyName(familyName);
                                    user.setUserName(userName);
                                    user.setEmail(email);
                                    user.setPassword(password);
                                    user.setPhone(phone);


                                    as.addEmployee(user);
                                    System.out.println("Please select your user id from names below...");
                                    as.getAllUsers();
                                    String userId = scan.nextLine();
                                    user.setId(Integer.parseInt(userId));
                                    bookUser.setUserId(user);
                                    as.addBookingUser(bookUser);

                                    System.out.println("Now lests enter ticket information...");


                                    ticket.setBookingId(booking);
                                    System.out.println("Select what type of ticket you want to book...");
                                    System.out.println("1) First Class" + "\n" +
                                            "2) Business Class" + "\n" +
                                            "3) Economy Class");

                                    String chooseTicket = scan.nextLine();
                                    if(chooseTicket.equals("1")) {
                                        ticket.setTicketType("first");
                                    }
                                    if(chooseTicket.equals("2")) {
                                        ticket.setTicketType("business");
                                    }
                                    if(chooseTicket.equals("3")) {
                                        ticket.setTicketType("economy");
                                    }
                                    ts.addTicket(ticket);

                                    System.out.println("Ticket successfully added!");
                                    return;
                                }

                            } catch (SQLException e1) {
                                System.out.println("Exception: " + e1);
                            }
                        }

                        if(userOperation.charAt(0) == '2') {


                            try {

                                System.out.println("Please choose booking id to update from options below...");
                                as.getAllBookings();
                                String bookingId = scan.nextLine();

                                System.out.println("Please enter 1 if you are updating booking...");
                                String isActive = scan.nextLine();

                                System.out.println("Please enter your own updated 8 letter/digit confirmation code...");
                                String confirmCode = scan.nextLine();

                                System.out.println("Please choose ticket id to update...");
                                as.getAllTickets();

                                String ticketId = scan.nextLine();
                                ticket.setId(Integer.parseInt(ticketId));

                                booking.setId(Integer.parseInt(bookingId));
                                booking.setBookingActive(Integer.parseInt(isActive));
                                booking.setConfirmCode(confirmCode);


                                ticket.setBookingId(booking);

                                System.out.println("Please choose a new seat class...");

                                System.out.println("1) First Class" + "\n" +
                                        "2) Business Class" + "\n" +
                                        "3) Economy Class");

                                String chooseTicket = scan.nextLine();
                                if(chooseTicket.equals("1")) {
                                    ticket.setTicketType("first");
                                }
                                if(chooseTicket.equals("2")) {
                                    ticket.setTicketType("business");
                                }
                                if(chooseTicket.equals("3")) {
                                    ticket.setTicketType("economy");
                                }

                                ts.updateTicket(ticket);


                                as.updateBooking(booking);
                                System.out.println("Information Successfully Updated!");
                                return;

                            }catch (SQLException e1) {
                                System.out.println("Exception: " + e1);
                            }
                        }

                        if(userOperation.charAt(0) == '3') {
                            try {
                                System.out.println("Please choose booking id to delete from options from below...");
                                as.getAllBookings();
                                System.out.println("Enter booking id to delete...");
                                String bookingId = scan.nextLine();

                                booking.setId(Integer.parseInt(bookingId));

                                as.deleteBookings(booking);
                                System.out.println("Information Successfully Deleted!");
                                return;

                            } catch (SQLException e1) {
                                System.out.println("Exception: " + e1);
                            }
                        }

                        if(userOperation.charAt(0) == '4') {

                            try {

                                as.getAllBookings();
                                return;
                            } catch (SQLException e) {

                                System.out.println("Exception: " + e);
                            } finally {
                                //scan.close();
                            }
                        }
                    }


                    //---------------------------------------------------------------------------------------------------------------------
                    // Passenger Menu
                    if(subMenuTwo.charAt(0) == '2') {
                        System.out.println("Please Choose one of the number: ");

                        System.out.println("Passenger " + "\n" +
                                "1) Add " + "\n" +
                                "2) Update " + "\n" +
                                "3) Delete " + "\n" +
                                "4) Read " + "\n");
                        String userOperation = scan.nextLine();

                        if(userOperation.charAt(0) == '1') {


                            try {

                                System.out.println("Please enter booking id from below options...");
                                as.getAllBookings();
                                String bookingId = scan.nextLine();

                                System.out.println("Please enter your given name...");
                                String givenName = scan.nextLine();

                                System.out.println("Please enter your family name...");
                                String familyName = scan.nextLine();

                                System.out.println("Please enter your date of birth(YYYY-MM-DD)...");
                                String birthDay = scan.nextLine();

                                System.out.println("Please enter your gender...");
                                String gender = scan.nextLine();

                                System.out.println("Please enter your address...");
                                String address = scan.nextLine();

                                booking.setId(Integer.parseInt(bookingId));
                                passenger.setBookingId(booking);
                                passenger.setGivenName(givenName);
                                passenger.setFamilyName(familyName);
                                passenger.setBirthDay(birthDay);
                                passenger.setGender(gender);
                                passenger.setAddress(address);

                                as.addPassengers(passenger);
                                System.out.println("Passenger successfully added!");
                                return;

                            } catch (SQLException e1) {
                                System.out.println("Exception: " + e1);
                            }
                        }

                        if(userOperation.charAt(0) == '2') {


                            try {

                                System.out.println("Please choose passenger id to update from options below...");
                                as.getAllPassengers();
                                String passengerId = scan.nextLine();

                                System.out.println("Please enter new booking id to update from options below...");
                                as.getAllBookings();
                                String bookingId = scan.nextLine();

                                System.out.println("Please enter new given name to update...");
                                String givenName = scan.nextLine();

                                System.out.println("Please enter new family name to update...");
                                String familyName = scan.nextLine();

                                System.out.println("Please enter new date of birth(YYYY-MM-DD) to update...");
                                String birthDate = scan.nextLine();

                                System.out.println("Please enter new gender to update...");
                                String gender = scan.nextLine();

                                System.out.println("Please enter new address to update...");
                                String address = scan.nextLine();

                                passenger.setId(Integer.parseInt(passengerId));
                                booking.setId(Integer.parseInt(bookingId));
                                passenger.setBookingId(booking);
                                passenger.setGivenName(givenName);
                                passenger.setFamilyName(familyName);
                                passenger.setBirthDay(birthDate);
                                passenger.setGender(gender);
                                passenger.setAddress(address);

                                as.updatePassenger(passenger);
                                System.out.println("Information Successfully Updated!");
                                return;

                            }catch (SQLException e1) {
                                System.out.println("Exception: " + e1);
                            }
                        }

                        if(userOperation.charAt(0) == '3') {
                            try {
                                System.out.println("Please choose passenger id to delete from options from below...");
                                as.getAllPassengers();
                                System.out.println("Enter Passenger id to delete...");
                                String passengerId = scan.nextLine();

                                passenger.setId(Integer.parseInt(passengerId));

                                as.deletePassenger(passenger);
                                System.out.println("Information Successfully Deleted!");
                                return;

                            } catch (SQLException e1) {
                                System.out.println("Exception: " + e1);
                            }
                        }

                        if(userOperation.charAt(0) == '4') {

                            try {
                                as.getAllPassengers();
                                return;
                            } catch (SQLException e) {

                                System.out.println("Exception: " + e);
                            } finally {
                                //scan.close();
                            }
                        }
                    }

                }

                //---------------------------------------------------------------------------------------------------------------------
                // Airport Menu
                if(subMenu.charAt(0) == '4') {
                    System.out.println("Please Choose one of the number: ");

                    System.out.println("Airport " + "\n" +
                            "1) Add " + "\n" +
                            "2) Update " + "\n" +
                            "3) Delete " + "\n" +
                            "4) Read " + "\n");
                    String userOperation = scan.nextLine();

                    if(userOperation.charAt(0) == '1') {
                        System.out.println("Enter airport code");
                        String airportCode = scan.nextLine();

                        System.out.println("Enter city name");
                        String cityName = scan.nextLine();

                        airport.setAirportCode(airportCode);
                        airport.setCityName(cityName);

                        try {
                            as.addAirport(airport);
                            System.out.println("Airport succussfully added!");
                            return;
                        } catch (SQLException e) {

                            System.out.println("Exception: " + e);
                        } finally {
                            //scan.close();
                        }
                    }

                    if(userOperation.charAt(0) == '2') {


                        try {
                            System.out.println("Enter airport code to update from options below");

                            as.getAllAirports();

                            String airportCode = scan.nextLine();

                            System.out.println("Enter new city name");
                            String newCityName = scan.nextLine();

                            airport.setAirportCode(airportCode);
                            airport.setCityName(newCityName);

                            as.updateAirport(airport);
                            System.out.println("Airport Successfully Updated!");
                            return;

                        } catch (SQLException e) {

                            System.out.println("Exception: " + e);
                        } finally {
                            //scan.close();
                        }
                    }

                    if(userOperation.charAt(0) == '3') {

                        try {

                            System.out.println("Enter choose which airpote id to delete from options below...");
                            as.getAllAirports();
                            System.out.println("Please enter airport code to delete...");
                            String airportCode = scan.nextLine();

                            airport.setAirportCode(airportCode);

                            as.deleteAirport(airport);
                            System.out.println("Airport Successfully Deleted!");
                            return;

                        } catch (SQLException e) {

                            System.out.println("Exception: " + e);
                        } finally {
                            //scan.close();
                        }
                    }

                    if(userOperation.charAt(0) == '4') {

                        try {
                            as.getAllAirports();
                            return;
                        } catch (SQLException e) {

                            System.out.println("Exception: " + e);
                        } finally {
                            //scan.close();
                        }
                    }
                }


                //---------------------------------------------------------------------------------------------------------------------
                // Employee Menu
                if(subMenu.charAt(0) == '6') {
                    System.out.println("Please Choose one of the number: ");

                    System.out.println("Employee " + "\n" +
                            "1) Add " + "\n" +
                            "2) Update " + "\n" +
                            "3) Delete " + "\n" +
                            "4) Read " + "\n");
                    String userOperation = scan.nextLine();

                    if(userOperation.charAt(0) == '1') {


                        try {

                            System.out.println("Please select user role id from the options below...");
                            as.getAllUserRole();
                            String roleId = scan.nextLine();

                            System.out.println("Please enter given name...");
                            String givenName = scan.nextLine();

                            System.out.println("Please enter family name...");
                            String familyName = scan.nextLine();

                            System.out.println("Please enter username...");
                            String userName = scan.nextLine();

                            System.out.println("Please enter email...");
                            String email = scan.nextLine();

                            System.out.println("Please enter password...");
                            String password = scan.nextLine();

                            System.out.println("Please enter phone number(XXX-XXX-XXXX)...");
                            String phNum = scan.nextLine();

                            userRole.setId(Integer.parseInt(roleId));
                            user.setRoleId(userRole);
                            user.setGivenName(givenName);
                            user.setFamilyName(familyName);
                            user.setUserName(userName);
                            user.setEmail(email);
                            user.setPassword(password);
                            user.setPhone(phNum);

                            as.addEmployee(user);
                            System.out.println("Employee successfully added!");
                            return;

                        } catch (SQLException e1) {
                            System.out.println("Exception: " + e1);
                        }
                    }

                    if(userOperation.charAt(0) == '2') {


                        try {

                            System.out.println("Please choose user id from options below...");
                            as.getAllUsers();
                            String userId = scan.nextLine();

                            System.out.println("Please enter role id from options below to update...");
                            as.getAllUserRole();
                            String roleId = scan.nextLine();

                            System.out.println("Please enter new given name to update...");
                            String givenName = scan.nextLine();

                            System.out.println("Please enter new family name to update...");
                            String familyName = scan.nextLine();

                            System.out.println("Please enter new username to update...");
                            String userName = scan.nextLine();

                            System.out.println("Please enter new email to update...");
                            String email = scan.nextLine();

                            System.out.println("Please enter new password to update...");
                            String password = scan.nextLine();

                            System.out.println("Please enter new phone(XXX-XXX-XXXX) to update...");
                            String phNum = scan.nextLine();

                            user.setId(Integer.parseInt(userId));
                            userRole.setId(Integer.parseInt(roleId));
                            user.setRoleId(userRole);
                            user.setGivenName(givenName);
                            user.setFamilyName(familyName);
                            user.setUserName(userName);
                            user.setEmail(email);
                            user.setPassword(password);
                            user.setPhone(phNum);


                            as.updateEmployee(user);
                            System.out.println("Information Successfully Updated!");
                            return;

                        }catch (SQLException e1) {
                            System.out.println("Exception: " + e1);
                        }
                    }

                    if(userOperation.charAt(0) == '3') {
                        try {
                            System.out.println("Please choose user id to delete form options from below...");
                            as.getAllUsers();
                            System.out.println("Enter user id to delete...");
                            String userId = scan.nextLine();

                            user.setId(Integer.parseInt(userId));
                            as.deleteEmployee(user);
                            System.out.println("Information Successfully Deleted!");
                            return;

                        } catch (SQLException e1) {
                            System.out.println("Exception: " + e1);
                        }
                    }

                    if(userOperation.charAt(0) == '4') {

                        try {
                            as.getAllEmployee();
                            return;
                        } catch (SQLException e) {

                            System.out.println("Exception: " + e);
                        } finally {
                            //scan.close();
                        }
                    }
                }

                //---------------------------------------------------------------------------------------------------------------------
                // Over ride Ticket Cancellation Menu
                if(subMenu.charAt(0) == '7') {

                    try{
                        System.out.println("Please choose booking id to delete from options from below...");
                        as.getAllBookings();
                        System.out.println("Enter booking id to delete...");
                        String bookingId = scan.nextLine();

                        booking.setId(Integer.parseInt(bookingId));

                        as.deleteBookings(booking);
                        System.out.println("Information Successfully Deleted!");
                        return;

                    } catch (SQLException e1) {
                        System.out.println("Exception: " + e1);
                    }

                }


            }


            //-------------------------------------------------------------------------------------------------------------------------------------

            // FOR Traveler

//            if(identityCode.charAt(0) == '3'){
//                System.out.println("Enter your Membership Number...");
//                String memberId = scan.nextLine();
//
//
//                // checking if traveler entered their membership id then only proceeds
//                if(!(memberId.isBlank())) {
//                    travelerMainMenu();
//                    boolean subBack = false;
//
//
//                    do {
//
//                        String passenInput = scan.nextLine();
//
//
//                        if(passenInput.equals("1")) {
//                            try {
//
//
//                                es.getAllOriginFlightsWithCity(); // given in RouteDao
//                                System.out.print("\n");
//
//                                es.getAllDestFlightsWithCity(); // given in RouteDao
//
//                                System.out.println("\n");
//                                System.out.println("Pick the flight you want to book");
//                                String flightId = scan.nextLine();
//
//                                travelerSubMenu();
//
//
//                                System.out.println("Pick the seat you want to book");
//                                System.out.println("\n");
//
//                                boolean backTwo = false;
//                                do{
//                                    String seatType = scan.nextLine();
//
//                                    if(seatType.equals("1")) {
//
//                                        System.out.println("\n");
//
//                                        es.getAllFlightDetail(flightId);
//
//                                        travelerSubMenu();
//                                        subBack = true;
//                                        backTwo = true;
//
//
//                                    }
//
//
//                                    if(seatType.equals("2")) {
//
//                                        // for first class seat booking
//                                        System.out.println("Please enter 1 if you are booking a ticket");
//                                        String isActive = scan.nextLine();
//                                        System.out.println("Please enter 8 letter/degit confirmation code for your reference");
//                                        String confirmCode = scan.nextLine();
//
//                                        booking.setBookingActive(Integer.parseInt(isActive));
//                                        booking.setConfirmCode(confirmCode);
//                                        as.addBookings(booking);
//
//
//                                        as.getAllBookings();
//
//                                        System.out.println("Please select your booking id from above list based on your confirmation code you just entered");
//
//                                        String bookingId = scan.nextLine();
//
//                                        // Now use ticket() class to add a ticket type
//                                        booking.setId(Integer.parseInt(bookingId));
//                                        ticket.setBookingId(booking);
//                                        ticket.setTicketType("first");
//                                        ts.addTicket(ticket);
//
//
//
//                                        System.out.println("You Booked your ticket!" + "\n");
//                                        return;
//
//
//                                    }
//
//
//                                    if(seatType.equals("3")) {
//                                        // for business class seat booking
//                                        System.out.println("Please enter 1 if you are booking a ticket");
//                                        String isActive = scan.nextLine();
//                                        System.out.println("Please enter 8 letter/degit confirmation code for your reference");
//                                        String confirmCode = scan.nextLine();
//
//                                        booking.setBookingActive(Integer.parseInt(isActive));
//                                        booking.setConfirmCode(confirmCode);
//                                        as.addBookings(booking);
//
//
//                                        as.getAllBookings();
//
//                                        System.out.println("Please select your booking id from above list based on your confirmation code you just entered");
//
//                                        String bookingId = scan.nextLine();
//
//                                        booking.setId(Integer.parseInt(bookingId));
//                                        ticket.setBookingId(booking);
//                                        ticket.setTicketType("business");
//                                        ts.addTicket(ticket);
//
//
//
//                                        System.out.println("You Booked your ticket!" + "\n");
//                                        return;
//                                    }
//
//
//                                    if(seatType.equals("4")) {
//
//                                        // for economy class seat booking
//                                        System.out.println("Please enter 1 if you are booking a ticket");
//                                        String isActive = scan.nextLine();
//                                        System.out.println("Please enter 8 letter/degit confirmation code for your reference");
//                                        String confirmCode = scan.nextLine();
//
//                                        booking.setBookingActive(Integer.parseInt(isActive));
//                                        booking.setConfirmCode(confirmCode);
//                                        as.addBookings(booking);
//
//
//                                        as.getAllBookings();
//
//                                        System.out.println("Please select your booking id from above list based on your confirmation code you just entered");
//
//                                        String bookingId = scan.nextLine();
//
//                                        // Now use ticket() class to add a ticket type
//                                        booking.setId(Integer.parseInt(bookingId));
//                                        ticket.setBookingId(booking);
//                                        ticket.setTicketType("economy");
//                                        ts.addTicket(ticket);
//
//
//
//                                        System.out.println("You Booked your ticket!" + "\n");
//                                        return;
//                                    }
//                                    if(seatType.equals("5")) {
//                                        subBack = true;
//                                        travelerMainMenu();
//                                        backTwo = false;
//
//                                    }
//
//                                }while(backTwo);
//
//
//                            } catch (SQLException e) {
//                                System.out.println("Exception: " + e);e.printStackTrace();
//                            }
//
//                        }
//
//
//                        if(passenInput.equals("2")) {
//
//
//                            try {
//
//
//                                as.getAllBookings();
//                                System.out.println("\n");
//                                System.out.println("Select the id corresponding your confirmation code to cancel your trip... ");
//                                String cancelBooking = scan.nextLine();
//                                booking.setId(Integer.parseInt(cancelBooking));
//                                as.deleteBookings(booking);
//
//                                System.out.println("Your booking is successfully canceled!");
//                                return;
//
//                            } catch (SQLException e) {
//                                System.out.println("Exception: " + e);
//                            }
//                        }
//
//
//                        if(passenInput.equals("3")) {
//
//                            mainBack = true;
//                            subBack = false;
//
//
//                        }
//                    }while(subBack);
//
//                }
//                else {
//                    System.out.println("You entered nothing/wrong membership number, Good Bye!");
//                    return;
//                }
//
//            }

        }while(mainBack);


    }

}