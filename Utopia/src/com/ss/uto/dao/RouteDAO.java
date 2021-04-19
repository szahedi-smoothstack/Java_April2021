package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.Route;


public class RouteDAO extends BaseDAO<Route> {

    public RouteDAO(Connection conn) {
        super(conn);
    }

    public Integer addRoute(Route route) throws ClassNotFoundException, SQLException {
        return saveWithPK("INSERT INTO route (origin_id, destination_id) VALUES (?, ?)",
                new Object[] { route.getOriginAirport().getIataId(), route.getDestinationAirport().getIataId() });
    }

    public void updateRoute(Route route) throws ClassNotFoundException, SQLException {
        save("UPDATE route set origin_id = ?, destination_id = ? where id = ?", new Object[] {
                route.getOriginAirport().getIataId(), route.getDestinationAirport().getIataId(), route.getId() });
    }

    public void deleteRoute(Route route) throws ClassNotFoundException, SQLException {
        save("DELETE FROM route where id = ?", new Object[] { route.getId() });
    }

    public List<Route> getAllRoutes() throws ClassNotFoundException, SQLException {
        return read("select * from route", null);
    }

    public List<Route> getAllRoutesByAirport(String airportCode) throws ClassNotFoundException, SQLException {
        return read("select * from route where origin_id = ? OR destination_id = ?", new Object[] {airportCode, airportCode});
    }

    public List<Route> getSpecifiedRoutes(String originAirportCode, String destinationAirportCode) throws ClassNotFoundException, SQLException {
        return read("select * from route where origin_id = ? OR destination_id = ?", new Object[] {originAirportCode, destinationAirportCode});
    }

    public List<Route> getRoutesByOriginCity(String airportCode) throws ClassNotFoundException, SQLException {
        return read("select * from route where origin_id = ?", new Object[] {airportCode});

    }

    public List<Route> getRoutesByDestinationCity(String airportCode) throws ClassNotFoundException, SQLException {
        return read("select * from route where destination_id = ?", new Object[] {airportCode});

    }


    @Override
    public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<Route> routes = new ArrayList<>();
        while (rs.next()) {
            Route route = new Route();
            route.setId(rs.getInt("id"));
            route.getOriginAirport().setIataId(rs.getString("origin_id"));
            route.getDestinationAirport().setIataId(rs.getString("destination_id"));
            routes.add(route);
        }
        return routes;
    }
}