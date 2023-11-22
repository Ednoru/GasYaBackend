package com.api.gasya.web.inventory;

import com.api.gasya.domain.inventory.Inventory;
import com.api.gasya.domain.inventory.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventories() {
        List<Inventory> inventories = inventoryService.getAllInventories();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    @GetMapping("/{gasStationId}/{fuelId}")
    public ResponseEntity<Inventory> getInventoryById(
            @PathVariable Long gasStationId,
            @PathVariable Long fuelId) {
        Inventory inventory = inventoryService.getInventoryById(gasStationId, fuelId);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Inventory> saveInventory(@RequestBody Inventory inventory) {
        Inventory savedInventory = inventoryService.saveInventory(inventory);
        return new ResponseEntity<>(savedInventory, HttpStatus.CREATED);
    }

    @DeleteMapping("/{gasStationId}/{fuelId}")
    public ResponseEntity<Void> deleteInventory(
            @PathVariable Long gasStationId,
            @PathVariable Long fuelId) {
        inventoryService.deleteInventory(gasStationId, fuelId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
