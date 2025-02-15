package com.zzxx.game.domain;

import java.io.Serializable;

public class User implements Serializable {
    private int uid; // 用户id
    private String username; // 用户名，账号
    private String password; // 密码
    private String name; // 真实姓名
    private String email; // 邮箱
    private String status; // 激活状态，Y代表激活，N代表未激活

    public User(){

    };

    public User(int uid, String username, String password, String name, String email, String status, String code) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.status = status;
        this.code = code;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code; // 激活码（要求唯一）
}
