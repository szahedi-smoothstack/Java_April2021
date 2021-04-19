package com.ss.uto.dao;

import com.ss.uto.entity.BookingPayment;
import com.ss.uto.entity.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingPaymentDAO extends BaseDAO<BookingPayment>{
    public BookingPaymentDAO(Connection conn) {
        super(conn);
    }

    public Integer add(BookingPayment bp) throws ClassNotFoundException, SQLException {
        return saveWithPK("INSERT INTO route (stripe_id, refunded_id) VALUES (?, ?)",
                new Object[] { bp.getStripeId(), bp.getRefunded() });
    }

    public void update(BookingPayment bp) throws ClassNotFoundException, SQLException {
        save("UPDATE route set stripe_id = ?, refunded = ? where booking_id = ?", new Object[] {
                bp.getStripeId(), bp.getRefunded(), bp.getBooking().getId() });
    }

    public void delete(BookingPayment bp) throws ClassNotFoundException, SQLException {
        save("DELETE FROM route where booking_id = ?", new Object[] { bp.getBooking().getId() });
    }

    public List<BookingPayment> getAll() throws ClassNotFoundException, SQLException {
        return read("select * from route", null);
    }


    @Override
    public List<BookingPayment> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<BookingPayment> bps = new ArrayList<>();
        while (rs.next()) {
            BookingPayment bp = new BookingPayment();
            bp.getBooking().setId(rs.getInt("booking_id"));
            bp.setStripeId(rs.getString("stripe_id"));
            bp.setRefunded(rs.getByte("refunded"));
            bps.add(bp);
        }
        return bps;
    }
}
