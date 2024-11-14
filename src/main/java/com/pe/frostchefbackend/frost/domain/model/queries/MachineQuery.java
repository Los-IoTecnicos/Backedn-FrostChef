package com.pe.frostchefbackend.frost.domain.model.queries;

import com.pe.frostchefbackend.frost.domain.model.entities.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MachineQuery extends JpaRepository<Machine, Long> {

    // Encuentra todas las máquinas con capacidad mayor a un cierto porcentaje
    @Query("SELECT m FROM Machine m WHERE m.capacityPercentage > :percentage")
    List<Machine> findMachinesWithCapacityAbove(@Param("percentage") int percentage);

    // Encuentra máquinas cuyo próximo mantenimiento es en una fecha específica o antes
    @Query("SELECT m FROM Machine m WHERE m.nextMaintenanceDate <= :date")
    List<Machine> findMachinesNeedingMaintenance(@Param("date") LocalDate date);

    // Encuentra máquinas por nombre (ignora mayúsculas/minúsculas)
    @Query("SELECT m FROM Machine m WHERE LOWER(m.name) = LOWER(:name)")
    List<Machine> findByNameIgnoreCase(@Param("name") String name);
}
