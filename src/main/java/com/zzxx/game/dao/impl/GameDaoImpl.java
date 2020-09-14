package com.zzxx.game.Dao.impl;

import com.zzxx.game.Dao.GameDao;
import com.zzxx.game.domain.Game;
import com.zzxx.game.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GameDaoImpl implements GameDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Game> findAll() {
        String sql = "select * from tab_game";
        List<Game> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Game.class));
        return list;
    }
}
