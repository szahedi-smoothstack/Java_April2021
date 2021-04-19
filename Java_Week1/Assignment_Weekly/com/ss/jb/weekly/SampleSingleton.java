package com.ss.jb.weekly;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


// Fixed some errors in the code provided
public class SampleSingleton {

    private static Connection conn = null;

    private static SampleSingleton instance = null;

    private SampleSingleton(){}

    // Public method getting an instance of this class
    public static SampleSingleton getInstance() {
        if (instance == null) {
            instance = new SampleSingleton();
        }
        return instance;
    }

    public static void databaseQuery(BigDecimal input) {
        try {
            conn = DriverManager.getConnection("url of database");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select id from table");
            int x = 0;
            while(rs.next()) {
                x = rs.getInt(1) * input.intValue();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
