package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.uto.entity.Booking;


public class BookingDAO extends BaseDAO<Booking> {

    public BookingDAO(Connection conn) {
        super(conn);
    }


    public Integer add(Booking booking) throws ClassNotFoundException, SQLException {
        return saveWithPK("INSERT INTO booking (is_active, confirmation_code) VALUES (?, ?)",
                new Object[] { booking.getIs_active(), booking.getConfirmationCode()});
    }

    public void update(Booking booking) throws ClassNotFoundException, SQLException {
        save("UPDATE booking set is_active = ?, confirmation_code = ? where id = ?", new Object[] {
                booking.getIs_active(), booking.getConfirmationCode(), booking.getId() });
    }

    public void delete(Booking booking) throws ClassNotFoundException, SQLException {
        save("DELETE FROM booking where id = ?", new Object[] { booking.getId()});
    }

    public List<Booking> getAll() throws ClassNotFoundException, SQLException {
        return read("select * from booking", null);
    }


    @Override
    public List<Booking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<Booking> bookings = new ArrayList<>();

        while(rs.next()) {
            System.out.println(rs.getString("id")+" "+rs.getInt("is_active")+ " " +rs.getString("confirmation_code"));
            Booking booking = new Booking();

            booking.setIs_active(rs.getByte("is_active"));
            booking.setConfirmationCode(rs.getString("confirmation_code"));
            bookings.add(booking);
        }

        return bookings;
    }


}