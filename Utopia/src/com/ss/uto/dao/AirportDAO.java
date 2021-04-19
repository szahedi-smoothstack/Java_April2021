package com.ss.uto.dao;

import com.ss.uto.entity.Airport;
import com.ss.uto.entity.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO extends BaseDAO<Airport> {
    public AirportDAO(Connection conn) {
        super(conn);
    }

    public Integer add(Airport airport) throws ClassNotFoundException, SQLException {
        return saveWithPK("INSERT INTO airport (iata_id, city) VALUES (?, ?)",
                new Object[] { airport.getIataId(), airport.getCity() });
    }

    public void update(Airport airport) throws ClassNotFoundException, SQLException {
        save("UPDATE airport set city = ? where iata_id = ?", new Object[] {
                airport.getCity(), airport.getIataId() });
    }

    public void delete(Airport airport) throws ClassNotFoundException, SQLException {
        save("DELETE FROM airport where iata_id = ?", new Object[] { airport.getIataId() });
    }

    public List<Airport> getAll() throws SQLException, ClassNotFoundException {
        return read("select * from airport", null);
    }

    @Override
    public List<Airport> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<Airport> airports = new ArrayList<>();
        while (rs.next()) {
            Airport airport = new Airport();
            airport.setIataId(rs.getString("iata_id"));
            airport.setCity(rs.getString("city"));
            airports.add(airport);
        }
        return airports;
    }
}
