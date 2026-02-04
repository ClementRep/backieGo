package com.example.vehicle_service.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Data
public class VehicleRequestDTO {

    @NotBlank
    private String ownerId;

    @NotBlank
    private String make;

    @NotBlank
    private String model;

    @NotBlank
    private Integer manufactureYear;

    @NotBlank
    private String licensePlate;
    @NotBlank
    @Positive
    private Integer price;
    // 📍 GPS (FREE, REQUIRED)
    @NotBlank
    private Double latitude;

    @NotBlank
    private Double longitude;

    // 🚗 Availability
    private boolean available = true;
}
