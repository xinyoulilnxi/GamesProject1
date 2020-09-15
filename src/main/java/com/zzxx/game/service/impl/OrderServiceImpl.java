package com.zzxx.game.service.impl;

import com.zzxx.game.dao.OrderDao;
import com.zzxx.game.dao.OrderImgDao;
import com.zzxx.game.dao.SellerDao;
import com.zzxx.game.dao.impl.OrderDaoImpl;
import com.zzxx.game.dao.impl.OrderImgDaoImpl;
import com.zzxx.game.dao.impl.SellerDaoImpl;
import com.zzxx.game.domain.Order;
import com.zzxx.game.domain.OrderImg;
import com.zzxx.game.domain.Seller;
import com.zzxx.game.service.OrderService;
import com.zzxx.game.util.PageBean;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao od = new OrderDaoImpl();
    @Override
    public PageBean<Order> findByPage(String gid, String _currentPage, String _pageSize, String oname) {
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Order> pageBean = new PageBean<>();

        int totalCount = od.findCount(gid,oname);
        List<Order> list = od.findByPage(gid,currentPage,pageSize,oname);
        int totalpage =  totalCount%pageSize== 0? totalCount/pageSize : totalCount/pageSize +1;

        pageBean.setList(list);
        pageBean.setTotalPage(totalpage);
        pageBean.setTotalCount(totalCount);
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        return pageBean;
    }

    @Override
    public Order findOne(String oid) {
        Order order = od.findById(oid);

        SellerDao sd = new SellerDaoImpl();
        int sid = order.getSid();
        Seller seller = sd.findById(sid);

        OrderImgDao orderImgDao = new OrderImgDaoImpl();
        List<OrderImg> list =orderImgDao.findById(oid);

        order.setSeller(seller);
        order.setOrderImgList(list);

        return order;
    }
}
