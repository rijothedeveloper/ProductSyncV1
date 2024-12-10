package com.orangesoft.ProductService.service;

import com.orangesoft.ProductService.dto.ProductRequest;
import com.orangesoft.ProductService.dto.ProductResponse;
import com.orangesoft.ProductService.entity.Product;
import com.orangesoft.ProductService.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = new Product(productRequest.id(), productRequest.name(), productRequest.description(), productRequest.price());
        productRepository.save(product);
        logger.info("Product added successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
