package com.zzxx.game.domain;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private int oid; // 订单id，必输
    private String oname;// 订单名称，必输
    private double price;// 价格，必输
    private String orderIntroduce;// 订单介绍
    private int gid;// 所属分类，必输
    private String image;// 缩略图
    private int sid; // 所属商家
    private int sales; //销量

    private Game game;// 所属分类
    private Seller seller; // 所属商家
    private List<OrderImg> orderImgList;// 订单详情图片列表

    public Order() {
    }

    public Order(int oid, String oname, double price, String orderIntroduce, int gid, String image, int sid, int sales) {
        this.oid = oid;
        this.oname = oname;
        this.price = price;
        this.orderIntroduce = orderIntroduce;
        this.gid = gid;
        this.image = image;
        this.sid = sid;
        this.sales = sales;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrderIntroduce() {
        return orderIntroduce;
    }

    public void setOrderIntroduce(String orderIntroduce) {
        this.orderIntroduce = orderIntroduce;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public List<OrderImg> getOrderImgList() {
        return orderImgList;
    }

    public void setOrderImgList(List<OrderImg> orderImgList) {
        this.orderImgList = orderImgList;
    }
}
