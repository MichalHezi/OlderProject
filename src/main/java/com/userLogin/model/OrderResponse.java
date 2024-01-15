package com.userLogin.model;

import java.util.List;

public class OrderResponse {
    private CustomUser customUser;
    private List<Order> orders;

    public OrderResponse(CustomUser customUser, List<Order> orders) {
        this.customUser = customUser;
        this.orders = orders;
    }

    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
