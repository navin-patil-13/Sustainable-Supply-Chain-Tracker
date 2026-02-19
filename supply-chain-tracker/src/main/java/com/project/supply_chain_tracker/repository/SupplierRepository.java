package com.project.supply_chain_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.supply_chain_tracker.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{
    List<Supplier> findBySustainabilityMetrics(Double sustainabilityMetrics);
}