package com.project.supply_chain_tracker.mapper;

import org.springframework.stereotype.Component;

import com.project.supply_chain_tracker.dto.SupplierDTO;
import com.project.supply_chain_tracker.entity.Supplier;

@Component
public class SupplierMapper {

    public SupplierDTO toDto(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        return new SupplierDTO(
            supplier.getId(),
            supplier.getName(),
            supplier.getLocation(),
            supplier.getCertLevel(),
            supplier.getSustainabilityMetrics()
        );
    }

    public Supplier toEntity(SupplierDTO supplierDTO) {
        if (supplierDTO == null) {
            return null;
        }
        Supplier supplier = new Supplier();
        supplier.setId(supplierDTO.id());
        supplier.setName(supplierDTO.name());
        supplier.setLocation(supplierDTO.location());
        supplier.setCertLevel(supplierDTO.certLevel());
        supplier.setSustainabilityMetrics(supplierDTO.sustainabilityMetrics());
        return supplier;
    }
}
