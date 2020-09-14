package com.zzxx.game.service.impl;

import com.zzxx.game.Dao.GameDao;
import com.zzxx.game.Dao.impl.GameDaoImpl;
import com.zzxx.game.domain.Game;
import com.zzxx.game.service.GameService;
import com.zzxx.game.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameServiceImpl implements GameService {
    private GameDao gd = new GameDaoImpl();
    @Override
    public List<Game> findAll() {
        //1.从redis缓存中查询数据
        Jedis jedis = JedisUtil.getJedis();
        //1.1查到直接返回
        Set<Tuple> games = jedis.zrangeWithScores("game", 0, -1);
        if (games == null || games.size() == 0) {
            //1.2查不到，从数据库中查询
            List<Game> list = gd.findAll();
            //2.第一次从数据库中查询出来的数据，存储到redis缓存中
            for (Game g : list) {
                jedis.zadd("category", g.getGid(), g.getGname());
            }
            return list;
        } else {
            List<Game> games1 = new ArrayList<>();
            for (Tuple tuple : games) {
                Game game = new Game();
                game.setGid((int) tuple.getScore());
                game.setGname(tuple.getElement());
                games1.add(game);
            }
            return games1;
        }
    }
}
