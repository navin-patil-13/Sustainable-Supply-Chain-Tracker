package com.project.supply_chain_tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.supply_chain_tracker.dto.SupplierDTO;
import com.project.supply_chain_tracker.entity.Supplier;
import com.project.supply_chain_tracker.mapper.SupplierMapper;
import com.project.supply_chain_tracker.repository.SupplierRepository;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SupplierMapper supplierMapper;

    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream()
            .map(supplierMapper::toDto)
            .toList();
    }

    public SupplierDTO getSupplierById(Long id) {
        return supplierRepository.findById(id)
            .map(supplierMapper::toDto)
            .orElse(null);
    }

    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        Supplier savedSupplier = supplierRepository.save(supplierMapper.toEntity(supplierDTO));
        return supplierMapper.toDto(savedSupplier);
    }

}
