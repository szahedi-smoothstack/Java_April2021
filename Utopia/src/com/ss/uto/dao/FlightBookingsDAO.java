package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.FlightBookings;

public class FlightBookingsDAO extends BaseDAO<FlightBookings> {

    public FlightBookingsDAO(Connection conn) {
        super(conn);
    }

    @Override
    public List<FlightBookings> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        return null;
    }





}