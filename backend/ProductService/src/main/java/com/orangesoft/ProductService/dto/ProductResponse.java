package com.orangesoft.ProductService.dto;

import java.util.List;

public record ProductResponse(String name, String description, double price, String sku, List<String> imgUrl) {
}
