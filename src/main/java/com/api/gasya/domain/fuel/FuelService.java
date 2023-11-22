package com.api.gasya.domain.fuel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelService {
    private final FuelRepository fuelRepository;

    @Autowired
    public FuelService(FuelRepository fuelRepository) {
        this.fuelRepository = fuelRepository;
    }

    public List<Fuel> getAllFuels() {
        return fuelRepository.findAll();
    }

    public Fuel getFuelById(Long id) {
        return fuelRepository.findById(id).orElse(null);
    }

    public Fuel saveFuel(Fuel fuel) {
        return fuelRepository.save(fuel);
    }

    public void deleteFuel(Long id) {
        fuelRepository.deleteById(id);
    }
}
