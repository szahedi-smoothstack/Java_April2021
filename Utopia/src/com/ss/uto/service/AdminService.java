package com.ss.uto.service;

import com.ss.uto.dao.AirportDAO;
import com.ss.uto.dao.FlightDAO;
import com.ss.uto.dao.RouteDAO;
import com.ss.uto.entity.Airport;
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.Route;
import com.ss.uto.menu.ManageAirportsMenu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AdminService {
    ConnectionUtil connUtil = new ConnectionUtil();

    // Airport Methods
    public void addAirport(Airport airport) throws SQLException {
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            AirportDAO aDao = new AirportDAO(conn);
            aDao.add(airport);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    public void updateAirport(Airport airport) throws SQLException {
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            AirportDAO aDao = new AirportDAO(conn);
            aDao.update(airport);
            conn.commit();

        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }finally {
            conn.close();
        }
    }

    public void deleteAirport(Airport airport) throws SQLException {
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            AirportDAO aDao = new AirportDAO(conn);
            aDao.delete(airport);
            conn.commit();

        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }finally {
            conn.close();
        }
    }

    public void getAllAirports() throws SQLException {
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            AirportDAO aDao = new AirportDAO(conn);
            aDao.getAll();
            conn.commit();

        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }finally {
            conn.close();
        }
    }

    // Flight Methods
//    public static void addFlight(Flight flight, Route route) throws SQLException, ClassNotFoundException {
//        Connection conn = null;
//        try {
//            conn = new ConnectionUtil().getConnection();
//            RouteDAO rdao = new RouteDAO(conn);
//            List<Route> routes = rdao.getSpecifiedRoutes(route.getOriginAirport().getIataId(), route.getDestinationAirport().getIataId());
//            if (routes.isEmpty()) {
//                Integer routeId = rdao.addRoute(route);
//                flight.getRoute().setId(routeId);
//            }
//            else if (routes.size() == 1) {
//                // that route already exists
//                flight.setRoute(routes.get(0));
//
//            }
//            FlightDAO fdao = new FlightDAO(conn);
//            fdao.addFlight(flight);
//            conn.commit();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            conn.rollback();
//        } finally {
//            conn.close();
//        }
//    }
    public void addFlight(Flight flight) throws SQLException {
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            FlightDAO fDao = new FlightDAO(conn);
            fDao.add(flight);
            conn.commit();

        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }finally {
            conn.close();
        }
    }

    public void updateFlight(Flight flight) throws SQLException {
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            FlightDAO fDao = new FlightDAO(conn);
            fDao.update(flight);
            conn.commit();

        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }finally {
            conn.close();
        }
    }


    // for 1.2
    public void updateSpecificFlights(Flight flight) throws SQLException {
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            FlightDAO fDao = new FlightDAO(conn);
            fDao.updateSpecificFlight(flight);
            conn.commit();

        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }finally {
            conn.close();
        }
    }

    public void deleteFlight(Flight flight) throws SQLException {
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            FlightDAO fDao = new FlightDAO(conn);
            fDao.delete(flight);
            conn.commit();

        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }finally {
            conn.close();
        }
    }


    public void getAllFlights() throws SQLException {
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            FlightDAO fDao = new FlightDAO(conn);
            fDao.getAll();
            conn.commit();

        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }finally {
            conn.close();
        }
    }
}
