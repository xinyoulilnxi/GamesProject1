package com.zzxx.game.domain;

import java.io.Serializable;

public class OrderImg implements Serializable {
    private int iid; // 订单图片id
    private int oid; // 订单id
    private String image_big; // 详情订单大图
    private String image_small; // 详情订单小图

    public OrderImg() {
    }

    public OrderImg(int iid, int oid, String image_big, String image_small) {
        this.iid = iid;
        this.oid = oid;
        this.image_big = image_big;
        this.image_small = image_small;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getImage_big() {
        return image_big;
    }

    public void setImage_big(String image_big) {
        this.image_big = image_big;
    }

    public String getImage_small() {
        return image_small;
    }

    public void setImage_small(String image_small) {
        this.image_small = image_small;
    }
}
