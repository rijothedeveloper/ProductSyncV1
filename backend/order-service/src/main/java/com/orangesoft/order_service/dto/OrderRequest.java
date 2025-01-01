package com.orangesoft.order_service.dto;

import com.orangesoft.order_service.entity.OrderItem;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

import java.util.List;

public record OrderRequest (
        @NotEmpty(message = "description is required")
        String description,
        String status,

        double totalPrice,
        @Size(min = 1, message = "orderItems is required")
        List<OrderItem> orderItems
){
}
