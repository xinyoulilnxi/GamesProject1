package com.zzxx.game.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzxx.game.domain.Game;
import com.zzxx.game.service.GameService;
import com.zzxx.game.service.impl.GameServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/game/*")
public class GameServlet extends BaseServlet {
    private GameService gs = new GameServiceImpl();
    //查找所有
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Game> list = gs.findAll();
        writeValue(response,list);
    }
}
