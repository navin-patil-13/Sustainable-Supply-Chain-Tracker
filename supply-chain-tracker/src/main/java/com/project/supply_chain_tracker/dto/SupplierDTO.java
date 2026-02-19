package com.project.supply_chain_tracker.dto;

public record SupplierDTO(
    Long id,
    String name,
    String location,
    String certLevel,
    Double sustainabilityMetrics
) {}