package com.userLogin.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class OrderItems {
    private Long id;
    @JsonProperty("order_id")
    private Long orderId;
    @JsonProperty("item_id")
    private Long itemId;

    public OrderItems(Long id, Long orderId, Long itemId) {
        this.id = id;
        this.orderId = orderId;
        this.itemId = itemId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
