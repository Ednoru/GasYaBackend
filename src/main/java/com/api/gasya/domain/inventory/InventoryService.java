package com.api.gasya.domain.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {

        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> getAllInventories() {

        return inventoryRepository.findAll();
    }

    public Inventory getInventoryById(Long gasStationId, Long fuelId) {
        return inventoryRepository.findByGasStationIdAndFuelId(gasStationId, fuelId).orElse(null);
    }

    public Inventory saveInventory(Inventory inventory) {

        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(Long gasStationId, Long fuelId) {
        inventoryRepository.deleteByGasStationIdAndFuelId(gasStationId, fuelId);
    }
}