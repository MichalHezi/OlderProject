package com.userLogin.model;

public class OrderRequest {
    private CustomUser customUser;
    private Order order;

    public OrderRequest(CustomUser customUser, Order order) {
        this.customUser = customUser;
        this.order = order;
    }

    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
