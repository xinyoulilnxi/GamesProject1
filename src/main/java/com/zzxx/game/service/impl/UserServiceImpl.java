package com.zzxx.game.service.impl;

import com.zzxx.game.dao.UserDao;
import com.zzxx.game.dao.impl.UserDaoImpl;
import com.zzxx.game.domain.User;
import com.zzxx.game.exception.LoginException;
import com.zzxx.game.service.UserService;
import com.zzxx.game.util.MailUtils;
import com.zzxx.game.util.UuidUtil;


public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    //检查用户名是否存在
    @Override
    public boolean checkUserExist(String username) {
        try {
            userDao.checkUserExist(username);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean registerUser(User user) {
        try {
            user.setStatus("N");
            user.setCode(UuidUtil.getUuid());
            userDao.registerUser(user);
            String text = "<a href='http://localhost:80/game/user/active?code=" + user.getCode() + "'>账号激活</a>";
            MailUtils.sendMail(user.getEmail(), text, "游戏网账号激活");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean active(String code) {
        int count = userDao.updateUserStatus(code);
        return count != 0;
    }

    @Override
    public User login(String username, String password) throws Exception {
        User user = userDao.login(username,password);
        if(user == null){
            throw new LoginException("账号密码错误");
        }else if(user.getStatus().equals("N")){
            throw new LoginException("账号未激活");
        }else{
            return user;
        }
    }
}
