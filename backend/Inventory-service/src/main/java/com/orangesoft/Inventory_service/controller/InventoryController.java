package com.orangesoft.Inventory_service.controller;

import com.orangesoft.Inventory_service.service.InventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public boolean checkInventory(@RequestBody String sku, @RequestBody Long quantity) {
        return inventoryService.checkInventory(sku, quantity);
    }

    @PutMapping
    public void updateInventory(@RequestBody Long id, @RequestBody Long quantity) {
        inventoryService.updateInventory(id, quantity);
    }

    @PostMapping
    public void createInventory(@RequestBody Long id, @RequestBody String sku, @RequestBody Long quantity) {
        inventoryService.createInventory(id, sku, quantity);
    }

    @DeleteMapping
    public void deleteInventory(@RequestBody Long id) {
        inventoryService.deleteInventory(id);
    }
}
