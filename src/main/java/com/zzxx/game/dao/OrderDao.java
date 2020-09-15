package com.zzxx.game.dao;

import com.zzxx.game.domain.Order;

import java.util.List;

public interface OrderDao {
    int findCount(String gid, String oname);

    List<Order> findByPage(String gid, int currentPage, int pageSize, String oname);

    Order findById(String oid);
}
