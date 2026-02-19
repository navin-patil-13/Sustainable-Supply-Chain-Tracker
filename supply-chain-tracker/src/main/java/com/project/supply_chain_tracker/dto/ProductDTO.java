package com.project.supply_chain_tracker.dto;

public record ProductDTO(
    Long id,
    String name,
    Long supplierId,
    String category,
    Double baseCarbonFootprint
) {}