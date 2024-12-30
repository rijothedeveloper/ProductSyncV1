package com.orangesoft.ProductService.service.impl;

import com.orangesoft.ProductService.dto.ProductRequest;
import com.orangesoft.ProductService.dto.ProductResponse;
import com.orangesoft.ProductService.entity.Product;
import com.orangesoft.ProductService.exception.ProductNotFoundException;
import com.orangesoft.ProductService.mapper.MapToProductsDto;
import com.orangesoft.ProductService.repository.ProductRepository;
import com.orangesoft.ProductService.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = MapToProductsDto.productRequestToProduct(productRequest);
        productRepository.save(product);
        logger.info("Product added successfully");
        return MapToProductsDto.productToProductResponse(product);
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(MapToProductsDto::productToProductResponse)
                .toList();
    }

    public ProductResponse getProductById(String id)  {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found for id: " + id));
        return MapToProductsDto.productToProductResponse(product);
    }

    @Override
    public ProductResponse getProductBySku(String sku) {
        Product product = productRepository.findBySku(sku).orElseThrow(() -> new ProductNotFoundException("Product not found for Sku: " + sku));
        return MapToProductsDto.productToProductResponse(product);
    }

    @Override
    public ProductResponse updateProduct(String sku, ProductRequest productRequest) {
        Product product = productRepository.findBySku(sku).orElseThrow(() -> new ProductNotFoundException("Product not found for Sku: " + sku));
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        product.setSku(productRequest.sku());
        productRepository.save(product);
        return MapToProductsDto.productToProductResponse(product);
    }

    @Override
    public String deleteProduct(String sku) {
        Product product = productRepository.findById(sku).orElseThrow(() -> new ProductNotFoundException("Product not found for Sku: " + sku));
        productRepository.delete(product);
        return "Product with sku "+sku+" deleted successfully";
    }
}
