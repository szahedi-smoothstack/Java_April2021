package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.uto.entity.Booking;
import com.ss.uto.entity.BookingUser;
import com.ss.uto.entity.User;


public class BookingUserDAO extends BaseDAO<BookingUser> {

    public BookingUserDAO(Connection conn) {
        super(conn);
    }


    public Integer add(BookingUser bu) throws ClassNotFoundException, SQLException {

        return saveWithPK("INSERT INTO booking_user (booking_id, user_id) VALUES (?, ?)",
                new Object[] { bu.getBooking().getId(), bu.getUser().getId()});

    }

    public void update(BookingUser bu) throws ClassNotFoundException, SQLException {
        save("UPDATE booking_user set booking_id = ?, user_id = ? where booking_id = ?", new Object[] {
                bu.getBooking().getId(), bu.getUser().getId(),bu.getBooking().getId()});
    }

    public void delete(BookingUser bu) throws ClassNotFoundException, SQLException {
        save("DELETE FROM booking_user where booking_id = ?", new Object[] { bu.getBooking().getId() });
    }

    public List<BookingUser> getAll() throws ClassNotFoundException, SQLException {
        return read("select * from booking_user", null);

    }


    @Override
    public List<BookingUser> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<BookingUser> bookingUsers = new ArrayList<>();
        Booking booking = new Booking();
        User user = new User();

        while(rs.next()) {
            System.out.println(rs.getInt("booking_id") + " " + (rs.getString("user_id")));
            booking.setId(5);
            user.setId(5);

            BookingUser bookUser = new BookingUser();
            bookUser.setBooking(booking);
            bookUser.setUser(user);;
            bookingUsers.add(bookUser);

        }
        return bookingUsers;
    }


}