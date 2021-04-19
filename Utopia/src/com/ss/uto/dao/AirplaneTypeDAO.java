package com.ss.uto.dao;

import com.ss.uto.entity.AirplaneType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType>{

    public AirplaneTypeDAO(Connection conn) {
        super(conn);
    }

    public Integer add(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
        return saveWithPK("INSERT INTO airplane_type (max_capacity) VALUES (?)",
                new Object[] { airplaneType.getMaxCapacity()});
    }

    public void update(AirplaneType airplanType) throws ClassNotFoundException, SQLException {
        save("UPDATE airplane_type set max_capacity = ? where id = ? ", new Object[] {
                airplanType.getMaxCapacity(), airplanType.getId() });
    }

    public void delete(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
        save("DELETE FROM airplane_type where id = ?", new Object[] { airplaneType.getId() });
    }

    public List<AirplaneType> getAll() throws ClassNotFoundException, SQLException {
        return read("select * from airplane_type", null);

    }

    @Override
    public List<AirplaneType> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<AirplaneType> airplaneTypes = new ArrayList<>();

        while(rs.next()) {
            System.out.println(rs.getInt("id") + " " + (rs.getString("max_capacity")));
            AirplaneType airplaneType = new AirplaneType();
            airplaneType.setId(rs.getInt("id"));
            airplaneType.setMaxCapacity(rs.getInt("max_capacity"));
            airplaneTypes.add(airplaneType);
        }

        return airplaneTypes;
    }
}
