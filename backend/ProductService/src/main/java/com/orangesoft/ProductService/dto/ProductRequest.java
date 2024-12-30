package com.orangesoft.ProductService.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record ProductRequest(
        @NotEmpty
        String id,
        @NotEmpty(message = "Product Name is required")
        String name,
        @NotEmpty(message = "Product Description is required")
        String description,
        @NotEmpty(message = "Product Price is required")
        double price,
        @NotEmpty(message = "Product SKU is required")
        String sku,
        List<String> imgUrl
)


{
}
