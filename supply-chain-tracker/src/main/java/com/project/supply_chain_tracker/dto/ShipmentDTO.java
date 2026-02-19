package com.project.supply_chain_tracker.dto;

import java.time.LocalDateTime;

public record ShipmentDTO(
    Long id, 
    Long productId, 
    String sourceLocation, 
    String destinationLocation, 
    String modeOfTransport, 
    Double distanceInKm, 
    LocalDateTime timeStamp, 
    String auditHash
) {}