package com.ss.uto.dao;

import com.ss.uto.entity.Airplane;
import com.ss.uto.entity.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneDAO extends BaseDAO<Airplane>{
    public AirplaneDAO(Connection conn) {
        super(conn);
    }
    public Integer add(Airplane airplane) throws ClassNotFoundException, SQLException {
        return saveWithPK("INSERT INTO airplane (type_id) VALUES (?)",
                new Object[] { airplane.getAirplaneType().getId() });
    }

    public void update(Airplane airplane) throws ClassNotFoundException, SQLException {
        save("UPDATE airplane set type_id = ? where id = ?", new Object[] {
                airplane.getAirplaneType().getId(), airplane.getId() });
    }

    public void delete(Airplane airplane) throws ClassNotFoundException, SQLException {
        save("DELETE FROM airplane where id = ?", new Object[] { airplane.getId() });
    }

    public List<Airplane> getAll() throws ClassNotFoundException, SQLException {
        return read("select * from route", null);
    }
    @Override
    public List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<Airplane> airplanes = new ArrayList<>();
        while (rs.next()) {
            Airplane airplane = new Airplane();
            airplane.setId(rs.getInt("id"));
            airplane.getAirplaneType().setId(rs.getInt("type_id"));
            airplanes.add(airplane);
        }
        return airplanes;
    }
}
