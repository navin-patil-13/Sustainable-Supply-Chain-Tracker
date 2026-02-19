package com.project.supply_chain_tracker.mapper;

import org.springframework.stereotype.Component;

import com.project.supply_chain_tracker.dto.ShipmentDTO;
import com.project.supply_chain_tracker.entity.Product;
import com.project.supply_chain_tracker.entity.Shipment;

@Component
public class ShipmentMapper {

    public ShipmentDTO toDto(Shipment shipment) {
        if (shipment == null) {
            return null;
        }
        return new ShipmentDTO(
            shipment.getId(),
            shipment.getProduct().getId(),
            shipment.getSourceLocation(),
            shipment.getDestinationLocation(),
            shipment.getModeOfTransport(),
            shipment.getDistanceInKm(),
            shipment.getTimeStamp(),
            shipment.getAuditHash()
        );
    }

    public Shipment toEntity(ShipmentDTO shipmentDTO) {
        if (shipmentDTO == null) {
            return null;
        }
        Shipment shipment = new Shipment();
        shipment.setId(shipmentDTO.id());
        if (shipmentDTO.productId() != null) {
            Product product = new Product();
            product.setId(shipmentDTO.productId());
            shipment.setProduct(product);
        } else {
            shipment.setProduct(null);
        }
        shipment.setSourceLocation(shipmentDTO.sourceLocation());
        shipment.setDestinationLocation(shipmentDTO.destinationLocation());
        shipment.setModeOfTransport(shipmentDTO.modeOfTransport());
        shipment.setDistanceInKm(shipmentDTO.distanceInKm());
        shipment.setTimeStamp(shipmentDTO.timeStamp());
        shipment.setAuditHash(shipmentDTO.auditHash());
        return shipment;
    }
}
