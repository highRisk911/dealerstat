package com.company.dealerstat.mapper.game;

import com.company.dealerstat.entity.Game;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameMapper implements RowMapper<Game> {

    @Override
    public Game mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Game(resultSet.getInt("id"),
                resultSet.getString("name"));
    }
}