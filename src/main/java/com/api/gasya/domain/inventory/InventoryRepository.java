package com.api.gasya.domain.inventory;

import com.api.gasya.domain.fuel.Fuel;
import com.api.gasya.domain.gasStation.GasStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByGasStationIdAndFuelId(Long gasStationId, Long fuelId);

    // Opcionalmente, si estás usando el método deleteByGasStationAndFuel
    void deleteByGasStationIdAndFuelId(Long gasStation, Long fuel);

    // Puedes agregar más métodos de consulta según tus necesidades
    List<Inventory> findByGasStation(GasStation gasStation);
    List<Inventory> findByFuel(Fuel fuel);
}
