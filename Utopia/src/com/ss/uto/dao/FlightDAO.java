package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.Airplane;
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.Route;


public class FlightDAO extends BaseDAO<Flight> {

    public FlightDAO(Connection conn) {
        super(conn);
    }


    public Integer add(Flight flight) throws ClassNotFoundException, SQLException {

        return saveWithPK("INSERT INTO flight (route_id, airplane_id, departure_time, reserved_seats, seat_price) VALUES (?, ?, ?, ?, ?)",
                new Object[] { flight.getRoute().getId(), flight.getAirplane().getId(), flight.getDepartureTime(), flight.getReservedSeats(), flight.getSeatPrice()});

    }

    public void update(Flight flight) throws ClassNotFoundException, SQLException {
        save("UPDATE flight set route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? where id = ?", new Object[] {
                flight.getRoute().getId(), flight.getAirplane().getId(),flight.getDepartureTime(), flight.getReservedSeats(),flight.getSeatPrice(), flight.getId()});
    }

    public void delete(Flight flight) throws ClassNotFoundException, SQLException {
        save("DELETE FROM flight where id = ?", new Object[] { flight.getId() });
    }

    public List<Flight> getAll() throws ClassNotFoundException, SQLException {

        return read("select * from flight", null);

    }

    public void updateSpecificFlight(Flight flight) throws ClassNotFoundException, SQLException {
        save("UPDATE flight set route_id = ?, departure_time = ? where id = ?", new Object[] {
                flight.getRoute().getId(),flight.getDepartureTime(), flight.getId()});
    }

    @Override
    public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<Flight> flights = new ArrayList<>();
        Route routeId = new Route();
        Airplane airplaneId = new Airplane();
        while(rs.next()) {
            routeId.setId(5);
            airplaneId.setId(2);
            Flight flight = new Flight();
            flight.setId(rs.getInt("id"));
            flight.setRoute(routeId);
            flight.setAirplane(airplaneId);
            flight.setDepartureTime(rs.getString("departure_time"));
            flight.setReservedSeats(rs.getInt("reserved_seats"));
            flight.setSeatPrice(rs.getFloat("seat_price"));
            flights.add(flight);
        }
        return flights;
    }
}