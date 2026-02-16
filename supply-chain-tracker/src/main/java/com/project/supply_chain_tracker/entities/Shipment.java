package com.project.supply_chain_tracker.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productID;

    private String sourceLocation;

    private String destinationLocation;

    private String modeOfTransport;

    private String distanceInKm;

    private Date timeStamp;

    private String auditHash;
}
