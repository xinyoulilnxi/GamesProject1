package com.zzxx.game.service;

import com.zzxx.game.domain.Order;
import com.zzxx.game.util.PageBean;

public interface OrderService {
    PageBean<Order> findByPage(String gid, String currentPage, String pageSize, String oname);

    Order findOne(String oid);
}
