package com.pe.frostchefbackend.frost.aplication.commandservices;

import com.pe.frostchefbackend.frost.domain.model.entities.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<Machine, Long> {
}
