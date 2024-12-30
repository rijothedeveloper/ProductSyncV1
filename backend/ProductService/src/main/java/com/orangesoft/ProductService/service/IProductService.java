package com.orangesoft.ProductService.service;

import com.orangesoft.ProductService.dto.ProductRequest;
import com.orangesoft.ProductService.dto.ProductResponse;

import java.util.List;

public interface IProductService {
    ProductResponse addProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProducts();
}
