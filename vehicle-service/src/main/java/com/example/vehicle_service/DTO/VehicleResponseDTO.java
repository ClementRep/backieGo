package com.example.vehicle_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleResponseDTO {
    private Long id;
    private String ownerId;
    private String make;
    private String model;
    private String Manufactureyear;
    private String licensePlate;
}
