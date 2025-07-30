package com.example.vehicle_service.DTO;

import lombok.Data;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

@Data
public class VehicleRequestDTO {
    @NotBlank
    private String ownerId;

    @NotBlank
    private String make;

    @NotBlank
    private String model;

    private String year;

    @NotBlank
    private String licensePlate;
}
