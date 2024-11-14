package com.pe.frostchefbackend.services;

import com.pe.frostchefbackend.frost.domain.model.entities.Machine;

import java.time.LocalDate;
import java.util.List;

public interface MachineServicesIm {

    Machine saveMachine(Machine machine);
    Machine updateMachine(Long id, Machine machine);
    void deleteMachine(Long id);
    List<Machine> getAllMachines();
    Machine getMachineById(Long id);
    List<Machine> getActiveMachines();
    List<Machine> getMachinesNeedingMaintenance(LocalDate date);
    List<Machine> getMachinesWithCapacityAbove(int percentage);
}
