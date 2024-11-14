package com.pe.frostchefbackend.frost.domain.model.queries;

import com.pe.frostchefbackend.frost.domain.model.entities.Machine;
import com.pe.frostchefbackend.frost.domain.model.valueObjects.MachineStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MachineRepositoryQuery extends JpaRepository<Machine, Long> {

    // Encuentra todas las máquinas que están activas
    List<Machine> findByStatus(MachineStatus status);

    // Encuentra máquinas que requieren mantenimiento pronto
    List<Machine> findByNextMaintenanceDateBefore(LocalDate date);

    // Encuentra máquinas por modelo
    List<Machine> findByModel(String model);
}
