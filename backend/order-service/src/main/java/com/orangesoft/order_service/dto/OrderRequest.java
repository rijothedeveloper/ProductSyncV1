package com.orangesoft.order_service.dto;

public record OrderRequest (
        String name,
        String description,
        String status,
        double totalPrice
){
}
