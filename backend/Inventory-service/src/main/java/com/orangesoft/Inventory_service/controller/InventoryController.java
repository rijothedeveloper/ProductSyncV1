package com.orangesoft.Inventory_service.controller;

import com.orangesoft.Inventory_service.entity.Inventory;
import com.orangesoft.Inventory_service.service.impl.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/inventory", produces = MediaType.APPLICATION_JSON_VALUE)
public class InventoryController {
    private final InventoryService inventoryService;
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public boolean checkInventory(@RequestBody String sku, @RequestBody Long quantity) {
        return inventoryService.checkInventory(sku, quantity);
    }
    @GetMapping("/all")
    public boolean checkInventoryForAll(@RequestBody List<Inventory> inventories) {
        return inventoryService.checkInventoryForAll(inventories);
    }

    @PutMapping
    public void updateInventory(@RequestBody String sku, @RequestBody Long quantity) {
        inventoryService.updateInventory(sku, quantity);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createInventory(@RequestParam String sku, @RequestParam Long quantity) {
        inventoryService.createInventory(sku, quantity);
    }

    @DeleteMapping
    public void deleteInventory(@RequestBody String sku) {
        inventoryService.deleteInventory(sku);
    }
}
