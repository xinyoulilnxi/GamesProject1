package com.zzxx.game.domain;

import java.io.Serializable;

public class Game implements Serializable {

    private int gid; // 分类id
    private String gname; // 分类名称

    public Game() {
    }

    public Game(int gid, String gname) {
        this.gid = gid;
        this.gname = gname;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                '}';
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }
}
