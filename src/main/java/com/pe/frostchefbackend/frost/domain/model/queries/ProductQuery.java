package com.pe.frostchefbackend.frost.domain.model.queries;

import com.pe.frostchefbackend.frost.domain.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductQuery extends JpaRepository<Product, Long> {

    // Buscar productos por categoría específica
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> findByCategory(@Param("category") String category);

    // Buscar productos con detalles específicos (busca en texto)
    @Query("SELECT p FROM Product p WHERE p.details LIKE %:detail%")
    List<Product> findByDetailsContaining(@Param("detail") String detail);

    // Encuentra productos vinculados a una máquina específica
    @Query("SELECT p FROM Product p WHERE p.machine.id = :machineId")
    List<Product> findByMachineId(@Param("machineId") Long machineId);
}