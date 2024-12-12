package com.orangesoft.Inventory_service.service;

import com.orangesoft.Inventory_service.entity.inventory;
import com.orangesoft.Inventory_service.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void updateInventory(Long id, Long quantity) {
        inventoryRepository.findById(id).ifPresent(inventory -> {
            inventory.setQuantity(inventory.getQuantity() + quantity);
            inventoryRepository.save(inventory);
        });
    }

    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

    public void createInventory(Long id, String sku, Long quantity) {
        inventoryRepository.save(new inventory(id, sku, quantity));
    }

    public boolean checkInventory(String sku, Long quantity) {
        return inventoryRepository.existsBySkuAndQuantityGreaterThanEqual(sku, quantity);
    }
}
