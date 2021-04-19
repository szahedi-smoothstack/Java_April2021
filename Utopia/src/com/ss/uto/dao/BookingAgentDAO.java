package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.uto.entity.Booking;
import com.ss.uto.entity.BookingAgent;
import com.ss.uto.entity.User;


public class BookingAgentDAO extends BaseDAO<BookingAgent> {

    public BookingAgentDAO(Connection conn) {
        super(conn);

    }

    public Integer add(BookingAgent bookAgent) throws ClassNotFoundException, SQLException {
        return saveWithPK("INSERT INTO booking_agent (booking_id, agent_id) VALUES (?, ?)",
                new Object[] { bookAgent.getBooking().getId(), bookAgent.getAgent().getId()});
    }

    public void update(BookingAgent bookAgent) throws ClassNotFoundException, SQLException {
        save("UPDATE airport set booking_id = ?, agent_id = ? where booking_id = ?", new Object[] {
                bookAgent.getBooking().getId(), bookAgent.getAgent().getId()});
    }

    public void delete(BookingAgent bookAgent) throws ClassNotFoundException, SQLException {
        save("DELETE FROM booking_agent where booking_id = ?", new Object[] { bookAgent.getBooking().getId() });
    }

    public List<BookingAgent> getAll() throws ClassNotFoundException, SQLException {
        return read("select * from booking_agent", null);
    }


    @Override
    public List<BookingAgent> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<BookingAgent> bookingAgents = new ArrayList<>();
        Booking booking = new Booking();
        User user = new User();

//        while(rs.next()) {
//            booking.setId(5);
//            user.setId(5);
//
//            BookingAgent bookAgent = new BookingAgent();
//            bookAgent.setBookingId(booking);
//            bookAgent.setAgentId(user);
//
//            bookingAgents.add(bookAgent);
//
//        }


        return bookingAgents;
    }

//    @Override
//    public List<BookingAgent> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
//        return null;
//    }




}