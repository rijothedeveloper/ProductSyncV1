package com.orangesoft.Inventory_service.service;

import com.orangesoft.Inventory_service.entity.Inventory;
import com.orangesoft.Inventory_service.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void updateInventory(String sku, Long quantity) {
        inventoryRepository.findBySku(sku).ifPresent(inventory -> {
            inventory.setQuantity(inventory.getQuantity() + quantity);
            inventoryRepository.save(inventory);
        });

    }

    public void deleteInventory(String sku) {
        inventoryRepository.deleteBySku(sku);
    }

    public void createInventory(String sku, Long quantity) {
        inventoryRepository.save(new Inventory(sku, quantity));
    }

    public boolean checkInventory(String sku, Long quantity) {
        return inventoryRepository.existsBySkuAndQuantityGreaterThanEqual(sku, quantity);
    }
}
