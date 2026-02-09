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
    private Integer manufactureyear;
    private String licensePlate;
    private Integer price;

    // 📍 GPS (for maps & distance)
    private Double latitude;
    private Double longitude;

    // 🚗 availability
    private boolean available;
}
