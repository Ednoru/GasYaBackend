package com.api.gasya.domain.gasStation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GasStationService {
    private final GasStationRepository gasStationRepository;

    @Autowired
    public GasStationService(GasStationRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
    }

    public List<GasStation> getAllGasStations() {
        return gasStationRepository.findAll();
    }

    public GasStation getGasStationById(Long id) {
        return gasStationRepository.findById(id).orElse(null);
    }

    public GasStation saveGasStation(GasStation gasStation) {
        return gasStationRepository.save(gasStation);
    }

    public void deleteGasStation(Long id) {
        gasStationRepository.deleteById(id);
    }
}

