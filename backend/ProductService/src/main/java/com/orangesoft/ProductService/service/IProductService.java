package com.orangesoft.ProductService.service;

import com.orangesoft.ProductService.dto.ProductRequest;
import com.orangesoft.ProductService.dto.ProductResponse;

import java.util.List;

public interface IProductService {
    ProductResponse addProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(String id);
    ProductResponse getProductBySku(String sku);

    ProductResponse updateProduct(String sku, ProductRequest productRequest) ;
    String deleteProduct(String sku) ;


}
