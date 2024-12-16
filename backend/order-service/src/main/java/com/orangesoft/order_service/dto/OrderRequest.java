package com.orangesoft.order_service.dto;

import com.orangesoft.order_service.entity.OrderItem;

import java.util.List;

public record OrderRequest (
        String name,
        String description,
        String status,
        double totalPrice,
        List<OrderItem> orderItems
){
}
