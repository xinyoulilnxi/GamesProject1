package com.zzxx.game.dao;

import com.zzxx.game.domain.User;

public interface UserDao {
    User checkUserExist(String username);

    void registerUser(User user);

    int updateUserStatus(String code);

    User login(String username, String password);
}
