package com.orangesoft.ProductService.controller;

import com.orangesoft.ProductService.dto.ProductRequest;
import com.orangesoft.ProductService.dto.ProductResponse;
import com.orangesoft.ProductService.service.IProductService;
import com.orangesoft.ProductService.service.impl.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class ProductController {

    private final IProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@Valid  @RequestBody ProductRequest productRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productRequest));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }
    @GetMapping("/id/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String productId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(productId));
    }
    @GetMapping("/sku/{productSku}")
    public ResponseEntity<ProductResponse> getProductBySku(@PathVariable String productSku) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductBySku(productSku));
    }
    @PutMapping("/sku/{productSku}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable String productSku, @Valid @RequestBody ProductRequest productRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(productSku, productRequest));
    }
    @DeleteMapping("/sku/{productSku}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productSku) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(productSku));
    }

}
