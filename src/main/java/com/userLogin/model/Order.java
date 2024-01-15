package com.userLogin.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Order {

    private int id;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("order_date")
    private LocalDate orderDate;
    @JsonProperty("shipping_address")
    private String shippingAddress;
    @JsonProperty("total_price")
    private double totalPrice;
    @JsonProperty("order_status")
    private OrderType orderStatus;

    public Order(int id, Long userId, LocalDate orderDate, String shippingAddress, double totalPrice, OrderType orderStatus) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderType getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderType orderStatus) {
        this.orderStatus = orderStatus;
    }
}
