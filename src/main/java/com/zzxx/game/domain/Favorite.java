package com.zzxx.game.domain;

import java.io.Serializable;

public class Favorite implements Serializable {
    private Order order;//订单对象
    private User user; //所属用户

    public Favorite() {
    }

    public Favorite(Order order, User user) {
        this.order = order;
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
