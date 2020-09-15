package com.zzxx.game.web.servlet;

import com.zzxx.game.domain.Order;
import com.zzxx.game.service.OrderService;
import com.zzxx.game.service.impl.OrderServiceImpl;
import com.zzxx.game.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order/*")
public class OrderServlet extends BaseServlet {
    private OrderService os = new OrderServiceImpl();

    //分页
    public void queryPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String gid = request.getParameter("gid");
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String oname = request.getParameter("oname");

        //判断参数是不是为空，是空赋默认值
        if (pageSize == null || "".equals(pageSize)){
            pageSize ="8";
        }
        if (currentPage == null || "".equals(currentPage)){
            currentPage ="1";
        }

        PageBean pageBean = os.findByPage(gid,currentPage,pageSize, oname);
        writeValue(response,pageBean);
    }

    //根据订单id获得订单详情
    public void detail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String oid = request.getParameter("oid");

        Order order = os.findOne(oid);

        writeValue(response,order);
    }




}