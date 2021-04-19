package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.uto.entity.UserRole;


public class UserRoleDAO extends BaseDAO<UserRole> {
    public UserRoleDAO(Connection conn) {
        super(conn);
    }

    public Integer add(UserRole userRole) throws ClassNotFoundException, SQLException {
        return saveWithPK("INSERT INTO user_role (name) VALUES (?)",
                new Object[] { userRole.getName()});
    }

    public void update(UserRole userRole) throws ClassNotFoundException, SQLException {
        save("UPDATE user_role set name = ? where id = ?", new Object[] {
                userRole.getName(), userRole.getId()});
    }

    public void delete(UserRole userRole) throws ClassNotFoundException, SQLException {
        save("DELETE FROM user_role where id = ?", new Object[] { userRole.getId() });
    }

    public List<UserRole> getAll() throws ClassNotFoundException, SQLException {
        return read("select * from user_role", null);

    }

    @Override
    public List<UserRole> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<UserRole> userRoles = new ArrayList<>();
        while(rs.next()) {
            UserRole userRole = new UserRole();
            userRole.setName(rs.getString("name"));
            userRoles.add(userRole);
        }
        return userRoles;
    }

}
