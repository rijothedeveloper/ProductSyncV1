package com.orangesoft.ProductService.service.impl;

import com.orangesoft.ProductService.dto.ProductRequest;
import com.orangesoft.ProductService.dto.ProductResponse;
import com.orangesoft.ProductService.entity.Product;
import com.orangesoft.ProductService.exception.ProductNotFoundException;
import com.orangesoft.ProductService.mapper.Mapper;
import com.orangesoft.ProductService.repository.ProductRepository;
import com.orangesoft.ProductService.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = Mapper.productRequestToProduct(productRequest);
        productRepository.save(product);
        logger.info("Product added successfully");
        return Mapper.productToProductResponse(product);
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(Mapper::productToProductResponse)
                .toList();
    }

    public ProductResponse getProductById(String id) throws ProductNotFoundException {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found for id: " + id));
        return Mapper.productToProductResponse(product);
    }
}
