package com.orangesoft.order_service.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private String orderNo;
    private String description;
    private String status;
    private double totalPrice;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "orderNo")
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order() {
    }

    public Order(String orderNo, String description, String status, double totalPrice, List<OrderItem> orderItems) {
        this.orderNo = orderNo;
        this.description = description;
        this.status = status;
        this.totalPrice = totalPrice;
        this.orderItems = orderItems;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}


