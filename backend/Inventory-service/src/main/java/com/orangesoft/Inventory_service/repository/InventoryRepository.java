package com.orangesoft.Inventory_service.repository;

import com.orangesoft.Inventory_service.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {

    Optional<Inventory> findBySku(String sku);
    void deleteBySku(String sku);
    boolean existsBySkuAndQuantityGreaterThanEqual(String sku, Long quantity);
}


