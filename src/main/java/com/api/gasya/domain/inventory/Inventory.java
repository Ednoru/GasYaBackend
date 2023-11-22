package com.api.gasya.domain.inventory;

import com.api.gasya.domain.fuel.Fuel;
import com.api.gasya.domain.gasStation.GasStation;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inventories")
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gas_stations_id", nullable = false)
    private GasStation gasStation;

    @ManyToOne
    @JoinColumn(name = "fuels_id", nullable = false)
    private Fuel fuel;
}
