package com.zzxx.game.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.zzxx.game.dao.UserDao;
import com.zzxx.game.domain.User;
import com.zzxx.game.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User checkUserExist(String username) {
        String sql ="select * from tab_user where username = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
        return user;
    }

    @Override
    public void registerUser(User user) {
        String sql = "insert into tab_user values(null,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getStatus(),user.getCode());
    }

    @Override
    public int updateUserStatus(String code) {
        String sql = "update tab_user set status = 'Y' where code = ?";
        int count = jdbcTemplate.update(sql, code);
        return count;
    }

    @Override
    public User login(String username, String password) {
        String sql = "select * from tab_user where username = ? and password = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        return user;
    }
}
