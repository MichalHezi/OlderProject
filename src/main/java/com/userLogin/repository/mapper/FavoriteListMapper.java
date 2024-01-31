package com.userLogin.repository.mapper;

import com.userLogin.model.FavoriteList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoriteListMapper implements RowMapper<FavoriteList> {
    @Override
    public FavoriteList mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FavoriteList(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getLong("item_id")
        );
    }
}
