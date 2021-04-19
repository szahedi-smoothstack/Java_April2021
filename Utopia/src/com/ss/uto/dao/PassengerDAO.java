package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.uto.entity.Booking;
import com.ss.uto.entity.Passenger;


public class PassengerDAO extends BaseDAO<Passenger>{

    public PassengerDAO(Connection conn) {
        super(conn);
    }

    public Integer add(Passenger passenger) throws ClassNotFoundException, SQLException {

        return saveWithPK("INSERT INTO passenger (booking_id, given_name, family_name, dob, gender, address) VALUES (?, ?, ?, ?, ?, ?)",
                new Object[] { passenger.getBooking().getId(), passenger.getGivenName(), passenger.getFamilyName(), passenger.getDob(), passenger.getGender(), passenger.getAddress()});

    }

    public void update(Passenger passenger) throws ClassNotFoundException, SQLException {
        save("UPDATE passenger set booking_id = ?, given_name = ?, family_name = ?, dob = ?, gender = ?, address = ? where id = ?", new Object[] {
                passenger.getBooking().getId(), passenger.getGivenName(),passenger.getFamilyName(), passenger.getDob(),passenger.getGender(),passenger.getAddress(), passenger.getId()});
    }

    public void delete(Passenger passenger) throws ClassNotFoundException, SQLException {
        save("DELETE FROM passenger where id = ?", new Object[] { passenger.getId() });
    }

    public List<Passenger> getAll() throws ClassNotFoundException, SQLException {
        return read("select * from passenger", null);

    }


    @Override
    public List<Passenger> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<Passenger> passengers = new ArrayList<>();
        Booking booking = new Booking();
        while(rs.next()) {
            booking.setId(5);
            Passenger passenger = new Passenger();
            passenger.setId(rs.getInt("id"));
            passenger.setBooking(booking);
            passenger.setGivenName(rs.getString("given_name"));
            passenger.setFamilyName(rs.getString("family_name"));
            passenger.setDob(rs.getString("dob"));
            passenger.setGender(rs.getString("gender"));
            passenger.setAddress(rs.getString("address"));
            passengers.add(passenger);
        }
        return passengers;
    }
}