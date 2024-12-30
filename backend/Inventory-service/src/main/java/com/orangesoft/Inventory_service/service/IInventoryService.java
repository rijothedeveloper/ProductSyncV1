package com.orangesoft.Inventory_service.service;

import com.orangesoft.Inventory_service.entity.Inventory;

import java.util.List;

public interface IInventoryService {
    void updateInventory(String sku, Long quantity);
    void deleteInventory(String sku);
    void createInventory(String sku, Long quantity);
    boolean checkInventory(String sku, Long quantity);
    boolean checkInventoryForAll(List<Inventory> inventories);
}
