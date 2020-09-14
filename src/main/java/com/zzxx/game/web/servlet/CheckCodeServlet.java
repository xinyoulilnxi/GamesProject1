package com.zzxx.game.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzxx.game.domain.ResultInfo;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");

        ResultInfo info = new ResultInfo();
        if (check != null &&check.equalsIgnoreCase(checkcode_server)){
            info.setFlag(true);
        }else {
            info.setFlag(false);
        }


        response.setContentType("application/json;charset=utf-8");

        // 将Java中的对象 -> 转换成json对象
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),info);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}