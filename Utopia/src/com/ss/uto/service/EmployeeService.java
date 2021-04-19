package com.ss.uto.service;

import com.ss.uto.dao.RouteDAO;
import com.ss.uto.entity.Route;

import java.sql.Connection;
import java.sql.SQLException;



public class EmployeeService {

    ConnectionUtil connUtil = new ConnectionUtil();

    public void getAllOriginFlightsWithCity(String airportCode) throws SQLException {
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            RouteDAO rDao = new RouteDAO(conn);
            rDao.getRoutesByOriginCity(airportCode);
            conn.commit();

        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }finally {
            conn.close();
        }
    }

    //For 1.1
    public void getAllDestFlightsWithCity(String airportCode) throws SQLException {
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            RouteDAO rDao = new RouteDAO(conn);
            rDao.getRoutesByDestinationCity(airportCode);
            conn.commit();

        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }finally {
            conn.close();
        }
    }

//    //For 1.1.1
//    public void getAllFlightDetail(String routeId) throws SQLException {
//        Connection conn = null;
//        try {
//            conn = connUtil.getConnection();
//            RouteDAO rDao = new RouteDAO(conn);
//            rDao.getFlightDetails(routeId);
//            conn.commit();
//
//        }catch (Exception e){
//            e.printStackTrace();
//            conn.rollback();
//        }finally {
//            conn.close();
//        }
//    }


    // for 1.2
    public void updateRoute(Route route, String oriAirportCode, String desAirportCode) throws SQLException {
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            RouteDAO rDao = new RouteDAO(conn);
            route.getOriginAirport().setIataId(oriAirportCode);
            route.getDestinationAirport().setIataId(desAirportCode);
            rDao.updateRoute(route);
            conn.commit();

        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }finally {
            conn.close();
        }
    }

//    //for 1.3
//    public void updateSeats(String input, SeatAvailability seatAvail) throws SQLException {
//        Connection conn = null;
//        try {
//            conn = connUtil.getConnection();
//            SeatAvailabilityDao seatDao = new SeatAvailabilityDao(conn);
//            seatDao.updateSeats(input,seatAvail);
//            conn.commit();
//
//        }catch (Exception e){
//            e.printStackTrace();
//            conn.rollback();
//        }finally {
//            conn.close();
//        }
//    }

//    //For 1.3
//    public void getSpecificSeat(String seatId, String input) throws SQLException {
//        Connection conn = null;
//        try {
//            conn = connUtil.getConnection();
//            SeatAvailabilityDao seatDao = new SeatAvailabilityDao(conn);
//            seatDao.getSpecificSeat(seatId, input);
//            conn.commit();
//
//        }catch (Exception e){
//            e.printStackTrace();
//            conn.rollback();
//        }finally {
//            conn.close();
//        }
//    }


//    public void getAllSeat() throws SQLException {
//        Connection conn = null;
//        try {
//            conn = connUtil.getConnection();
//            SeatAvailabilityDao seatDao = new SeatAvailabilityDao(conn);
//            seatDao.getAllSeats();
//            conn.commit();
//
//        }catch (Exception e){
//            e.printStackTrace();
//            conn.rollback();
//        }finally {
//            conn.close();
//        }
//    }



}