package com.example.user_service.vehicleDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponseDTO {

    private Long id;
    private String ownerId;
    private String make;
    private String model;
    private Integer manufactureYear;
    private String licensePlate;
    private Integer price;

    // 📍 GPS coordinates
    private Double latitude;
    private Double longitude;

    // 🚗 availability
    private boolean available;
}