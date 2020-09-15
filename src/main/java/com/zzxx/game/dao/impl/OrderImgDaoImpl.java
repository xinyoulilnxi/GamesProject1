package com.zzxx.game.dao.impl;

import com.zzxx.game.dao.OrderImgDao;
import com.zzxx.game.domain.OrderImg;
import com.zzxx.game.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderImgDaoImpl implements OrderImgDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<OrderImg> findById(String oid) {
        String sql = "select * from tab_image where oid = ?";
        List<OrderImg> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(OrderImg.class), oid);
        return list;
    }
}
