package com.zzxx.game.dao;

import com.zzxx.game.domain.Game;

import java.util.List;

public interface GameDao {
    List<Game> findAll();
}
