package com.orangesoft.Inventory_service.service.impl;

import com.orangesoft.Inventory_service.entity.Inventory;
import com.orangesoft.Inventory_service.repository.InventoryRepository;
import com.orangesoft.Inventory_service.service.IInventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService implements IInventoryService {
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

    public boolean checkInventoryForAll(List<Inventory> inventories) {
        return inventories.stream().allMatch(inventory -> {
            return checkInventory(inventory.getSku(), inventory.getQuantity());
        });

    }
}
