package com.pe.frostchefbackend.frost.aplication.commandservices;

import com.pe.frostchefbackend.frost.domain.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
