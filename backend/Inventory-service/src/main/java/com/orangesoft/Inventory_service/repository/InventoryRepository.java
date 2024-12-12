package com.orangesoft.Inventory_service.repository;

import com.orangesoft.Inventory_service.entity.inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<inventory, Long> {

    boolean existsBySkuAndQuantityGreaterThanEqual(String sku, Long quantity);
}
