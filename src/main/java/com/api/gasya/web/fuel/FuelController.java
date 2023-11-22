package com.api.gasya.web.fuel;

import com.api.gasya.domain.fuel.Fuel;
import com.api.gasya.domain.fuel.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuels")
public class FuelController {

    private final FuelService fuelService;

    @Autowired
    public FuelController(FuelService fuelService) {
        this.fuelService = fuelService;
    }

    @GetMapping
    public ResponseEntity<List<Fuel>> getAllFuels() {
        List<Fuel> fuels = fuelService.getAllFuels();
        return new ResponseEntity<>(fuels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fuel> getFuelById(@PathVariable Long id) {
        Fuel fuel = fuelService.getFuelById(id);
        return new ResponseEntity<>(fuel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Fuel> saveFuel(@RequestBody Fuel fuel) {
        Fuel savedFuel = fuelService.saveFuel(fuel);
        return new ResponseEntity<>(savedFuel, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuel(@PathVariable Long id) {
        fuelService.deleteFuel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
