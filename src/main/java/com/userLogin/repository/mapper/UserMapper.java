package com.userLogin.repository.mapper;

import com.userLogin.model.CustomUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<CustomUser> {

    @Override
    public CustomUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomUser(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("address"),
                rs.getString("roles"),
                rs.getString("permissions")
        );
    }
}
