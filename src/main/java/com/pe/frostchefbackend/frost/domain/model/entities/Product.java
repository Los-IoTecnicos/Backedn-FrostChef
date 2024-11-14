package com.pe.frostchefbackend.frost.domain.model.entities;

import com.pe.frostchefbackend.frost.domain.model.valueObjects.ProductStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    private LocalDate entryDate;

    private String brand;

    private int quantity;

    private String category;

    private String details;

    private String photoUrl;

    //private boolean ExpiryDate;

    @ManyToOne
    @JoinColumn(name = "machine_id", nullable = false)
    private Machine machine;

    /*public boolean getExpiryDate() {
        return ExpiryDate;
    }*/
}

