package com.project.supply_chain_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.supply_chain_tracker.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findBySupplierId(Long supplierId);
}
