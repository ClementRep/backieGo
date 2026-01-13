package com.example.vehicle_service.Model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String ownerId;
    @NotBlank
    private String make;
    @NotBlank
    private String model;
    @NotBlank
    private String Manufacturedyear;
    @NotBlank
    private String licensePlate;
}
