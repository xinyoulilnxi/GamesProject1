package com.zzxx.game.dao.impl;

import com.zzxx.game.dao.OrderDao;
import com.zzxx.game.domain.Order;
import com.zzxx.game.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findCount(String gid, String oname) {
        StringBuilder _sql = new StringBuilder("select count(*) from tab_order where 1 = 1 ");
        if (gid!=null){
            _sql.append(" and gid = ? ");
            if (oname!=null){
                _sql.append(" and oname like ? ");
                Integer count = jdbcTemplate.queryForObject(_sql.toString(), Integer.class,gid,"%"+oname+"%");
                return count;
            }
            else {
                Integer count = jdbcTemplate.queryForObject(_sql.toString(), Integer.class,gid);
                return count;
            }
        }
        else {
            if (oname!=null){
                _sql.append(" and oname like ? ");
                Integer count = jdbcTemplate.queryForObject(_sql.toString(), Integer.class,"%"+oname+"%");
                return count;
            }else {
                Integer count = jdbcTemplate.queryForObject(_sql.toString(), Integer.class);
                return count;
            }
        }
    }

    @Override
    public List<Order> findByPage(String gid, int currentPage, int pageSize, String oname) {
        StringBuilder _sql = new StringBuilder("select * from tab_order where 1 = 1 ");
        int start = (currentPage-1)*pageSize;
        if (gid!=null){
            _sql.append(" and gid = ? ");
            if (oname!=null){
                _sql.append(" and oname like ? ");
                _sql.append(" limit ?,?");
                List<Order> list = jdbcTemplate.query(_sql.toString(), new BeanPropertyRowMapper<>(Order.class),gid,"%"+oname+"%",start,pageSize);
                return list;
            }
            else {
                _sql.append(" limit ?,?");
                List<Order> list = jdbcTemplate.query(_sql.toString(), new BeanPropertyRowMapper<>(Order.class),gid,start,pageSize);
                return list;
            }
        }
        else {
            if (oname!=null){
                _sql.append(" and oname like ? ");
                _sql.append(" limit ?,?");
                List<Order> list = jdbcTemplate.query(_sql.toString(), new BeanPropertyRowMapper<>(Order.class),"%"+oname+"%",start,pageSize);
                return list;
            }else {
                _sql.append(" limit ?,?");
                List<Order> list = jdbcTemplate.query(_sql.toString(), new BeanPropertyRowMapper<>(Order.class),start,pageSize);
                return list;
            }
        }
    }

    @Override
    public Order findById(String oid) {
        String sql ="select * from tab_order where oid = ?";
        List<Order> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class), oid);
        return list.size() == 0 ? null:list.get(0);
    }
}
