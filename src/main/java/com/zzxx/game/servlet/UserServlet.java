package com.zzxx.game.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/user/*")
public class UserServlet extends BaseServlet {
    //注册账号
    //查询用户名是否存在
    public void checkUser(HttpServletRequest request,HttpServletResponse response){
    String username = request.getParameter("username");
    }

}
