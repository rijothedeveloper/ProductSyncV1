package com.orangesoft.ProductService.mapper;

import com.orangesoft.ProductService.dto.ProductRequest;
import com.orangesoft.ProductService.dto.ProductResponse;
import com.orangesoft.ProductService.entity.Product;

public class Mapper {
    public static ProductResponse productToProductResponse(Product product) {
        return new ProductResponse(product.getName(), product.getDescription(), product.getPrice(), product.getSku(), product.getImgUrl());
    }
    public static Product productRequestToProduct(ProductRequest productRequest) {
        return new Product(null,productRequest.name(), productRequest.description(), productRequest.price(), productRequest.sku(), productRequest.imgUrl());
    }
}
