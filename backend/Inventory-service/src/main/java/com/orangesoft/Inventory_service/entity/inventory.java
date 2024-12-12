package com.orangesoft.Inventory_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class inventory {
    @Id
    private Long id;
    private String sku;
    private Long quantity;

    public inventory() {
    }
    public inventory(Long id, String sku, Long quantity) {
        this.id = id;
        this.sku = sku;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
