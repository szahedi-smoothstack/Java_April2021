package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.Booking;
import com.ss.uto.entity.BookingGuest;

public class BookingGuestDAO extends BaseDAO<BookingGuest> {

    public BookingGuestDAO(Connection conn) {
        super(conn);

    }


    public Integer add(BookingGuest bg) throws ClassNotFoundException, SQLException {

        return saveWithPK("INSERT INTO booking_guest (booking_id, contact_email, contact_phone) VALUES (?, ?, ?)",
                new Object[] { bg.getBooking().getId(), bg.getEmail(), bg.getPhone()});
    }

    public void update(BookingGuest bg) throws ClassNotFoundException, SQLException {
        save("UPDATE booking_guest set booking_id = ?, contact_email = ?, contact_phone = ? where booking_id = ?", new Object[] {
                bg.getBooking().getId(), bg.getEmail(), bg.getPhone(),bg.getBooking().getId()});
    }

    public void delete(BookingGuest bg) throws ClassNotFoundException, SQLException {
        save("DELETE FROM booking_guest where booking_id = ?", new Object[] { bg.getBooking().getId() });
    }

    public List<BookingGuest> getAll() throws ClassNotFoundException, SQLException {
        return read("select * from booking_guest", null);

    }


    @Override
    public List<BookingGuest> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<BookingGuest> bgs = new ArrayList<>();

        Booking booking = new Booking();

        while(rs.next()) {
            System.out.println(rs.getInt("booking_id") + " " + (rs.getString("contact_email")+" "+rs.getString("contact_phone")));
            booking.setId(9);

            BookingGuest bg = new BookingGuest();

            bg.setBooking(booking);
            bg.setEmail(rs.getString("contact_email"));
            bg.setPhone(rs.getString("contact_phone"));

            bgs.add(bg);

        }
        return bgs;
    }

}
