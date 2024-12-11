package com.orangesoft.order_service.dto;

public record OrderResponse(String orderNo,
                            String name,
                            String description,
                            String status,
                            double total_price) {
}
