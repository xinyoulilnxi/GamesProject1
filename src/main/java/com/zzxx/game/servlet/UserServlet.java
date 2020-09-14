package com.zzxx.game.servlet;

import com.zzxx.game.domain.ResultInfo;
import com.zzxx.game.domain.User;
import com.zzxx.game.service.UserService;
import com.zzxx.game.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet( "/user/*")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    //注册账号
    //查询用户名是否存在
    public void checkUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        //用户名存在返回true，不存在返回false
        boolean isExist = userService.checkUserExist(username);
        ResultInfo info = new ResultInfo();
        //用户名存在返回前端为false，不存在为true
        info.setFlag(!isExist);
        writeValue(response, info);
    }

    //注册账号
    public void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean isRegister = userService.registerUser(user);
        ResultInfo info = new ResultInfo();
        info.setFlag(isRegister);
        if (!isRegister) {
            info.setErrorMsg("注册失败");
        } else {
            writeValue(response, info);

        }
        writeValue(response, info);
    }

    //邮箱激活
    public void active(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        boolean flag = userService.active(code);
        if (flag) {
            response.sendRedirect(request.getContextPath() + "/login.html");
        } else {
            response.getWriter().write("激活失败! 请联系管理员!");
        }
    }

    //登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String check = request.getParameter("check");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        ResultInfo info = new ResultInfo();
        if (check == null && !checkcode_server.equalsIgnoreCase(check)) {
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
        } else {
            try {
                User user = userService.login(username, password);
                request.getSession().setAttribute("loginUser", user);
                info.setFlag(true);
            } catch (Exception e) {
                info.setFlag(false);
                info.setErrorMsg(e.getMessage());
            }
        }
        writeValue(response, info);
    }
    //登陆信息
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object loginUser = request.getSession().getAttribute("loginUser");
        writeValue(response,loginUser);
    }
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("loginUser");
        response.sendRedirect(request.getContextPath()+"/login.html");
    }
}