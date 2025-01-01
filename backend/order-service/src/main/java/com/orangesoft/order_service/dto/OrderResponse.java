package com.orangesoft.order_service.dto;

import com.orangesoft.order_service.entity.OrderItem;

import java.util.List;

public record OrderResponse(String orderNo,
                            String description,
                            String status,
                            double total_price,
                            List<OrderItem> orderItems) {
}
