package com.zzxx.game.dao.impl;

import com.zzxx.game.dao.SellerDao;
import com.zzxx.game.domain.Seller;
import com.zzxx.game.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SellerDaoImpl implements SellerDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Seller findById(int sid) {
        String sql ="select * from tab_seller where sid =?";
        List<Seller> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Seller.class), sid);
        return list.size() == 0 ? null:list.get(0);
    }
}
