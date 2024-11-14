package com.pe.frostchefbackend.frost.domain.services;

import com.pe.frostchefbackend.frost.domain.model.entities.Machine;

import java.util.List;

public interface MachineService {
    Machine saveMachine(Machine machine);
    Machine updateMachine(Long id, Machine machine);
    void deleteMachine(Long id);
    List<Machine> getAllMachines();
    Machine getMachineById(Long id);
}
