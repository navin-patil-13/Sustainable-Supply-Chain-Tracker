package com.project.supply_chain_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.supply_chain_tracker.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long>{
    // Note: entity field is 'timeStamp' (camelCase) so method must match exactly
    List<Shipment> findByProductIdOrderByTimeStampAsc(Long productId);

    // Join to supplier through product (Shipment has product, Product has supplier)
    @Query("SELECT s FROM Shipment s JOIN s.product p JOIN p.supplier sup WHERE sup.id = :supplierId")
    List<Shipment> findChainBySupplierId(@Param("supplierId") Long supplierId);
}
