package com.project.supply_chain_tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));
    }

    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        Supplier savedSupplier = supplierRepository.save(supplierMapper.toEntity(supplierDTO));
        return supplierMapper.toDto(savedSupplier);
    }

    public SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO) {
        return supplierRepository.findById(id)
            .map(existingSupplier -> {
                existingSupplier.setName(supplierDTO.name());
                existingSupplier.setLocation(supplierDTO.location());
                existingSupplier.setCertLevel(supplierDTO.certLevel());
                existingSupplier.setSustainabilityMetrics(supplierDTO.sustainabilityMetrics());
                Supplier updatedSupplier = supplierRepository.save(existingSupplier);
                return supplierMapper.toDto(updatedSupplier);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));
    }

    public SupplierDTO deleteSupplier(Long id) {
        return supplierRepository.findById(id)
            .map(existingSupplier -> {
                supplierRepository.deleteById(id);
                return supplierMapper.toDto(existingSupplier);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));
    }
}
