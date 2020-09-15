package com.zzxx.game.dao;

import com.zzxx.game.domain.OrderImg;

import java.util.List;

public interface OrderImgDao {
    List<OrderImg> findById(String oid);
}
