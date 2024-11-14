package com.pe.frostchefbackend.frost.domain.services.Impl;

import com.pe.frostchefbackend.frost.aplication.commandservices.MachineRepository;
import com.pe.frostchefbackend.frost.domain.model.entities.Machine;
import com.pe.frostchefbackend.frost.domain.services.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {

    private final MachineRepository machineRepository;

    @Autowired
    public MachineServiceImpl(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public Machine saveMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    @Override
    public Machine updateMachine(Long id, Machine machine) {
        machine.setId(id);
        return machineRepository.save(machine);
    }

    @Override
    public void deleteMachine(Long id) {
        machineRepository.deleteById(id);
    }

    @Override
    public List<Machine> getAllMachines() {
        return machineRepository.findAll();
    }

    @Override
    public Machine getMachineById(Long id) {
        return machineRepository.findById(id).orElse(null);
    }
}
