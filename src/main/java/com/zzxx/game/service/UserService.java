package com.zzxx.game.service;

import com.zzxx.game.domain.User;

import javax.security.auth.login.LoginException;

public interface UserService {
    boolean checkUserExist(String username);

    boolean registerUser(User user);

    boolean active(String code);

    User login(String username, String password) throws LoginException, Exception;
}
