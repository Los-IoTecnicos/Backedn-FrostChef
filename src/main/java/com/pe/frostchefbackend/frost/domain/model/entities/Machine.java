package com.pe.frostchefbackend.frost.domain.model.entities;

import com.pe.frostchefbackend.frost.domain.model.valueObjects.MachineStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MachineStatus status;

    private int capacityPercentage;

    private double temperature;

    private double humidity;

    private LocalDate lastMaintenanceDate;

    private LocalDate nextMaintenanceDate;

    private String model;

    private String serialNumber;

    private LocalDate installationDate;

    private String photoUrl;

    @OneToMany(mappedBy = "machine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;


}

