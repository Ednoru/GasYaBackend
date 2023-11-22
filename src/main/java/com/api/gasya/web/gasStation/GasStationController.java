package com.api.gasya.web.gasStation;

import com.api.gasya.domain.gasStation.GasStation;
import com.api.gasya.domain.gasStation.GasStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gasStations")
public class GasStationController {

    private final GasStationService gasStationService;

    @Autowired
    public GasStationController(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    @GetMapping
    public ResponseEntity<List<GasStation>> getAllGasStations() {
        List<GasStation> gasStations = gasStationService.getAllGasStations();
        return new ResponseEntity<>(gasStations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GasStation> getGasStationById(@PathVariable Long id) {
        GasStation gasStation = gasStationService.getGasStationById(id);
        return new ResponseEntity<>(gasStation, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GasStation> saveGasStation(@RequestBody GasStation gasStation) {
        GasStation savedGasStation = gasStationService.saveGasStation(gasStation);
        return new ResponseEntity<>(savedGasStation, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGasStation(@PathVariable Long id) {
        gasStationService.deleteGasStation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
