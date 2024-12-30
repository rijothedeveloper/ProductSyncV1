package com.orangesoft.ProductService.dto;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import java.util.List;

public record ProductRequest(

        String id,
        @NotEmpty(message = "Product Name is required")
        String name,
        @NotEmpty(message = "Product Description is required")
        String description,
        @Range(min=0, max=90, message = "Product Price is required")
        double price,
        @NotEmpty(message = "Product SKU is required")
        String sku,
        List<String> imgUrl
)


{
}
