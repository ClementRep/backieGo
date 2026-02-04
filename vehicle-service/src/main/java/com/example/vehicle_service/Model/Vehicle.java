package com.example.vehicle_service.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vehicles")
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

    @NotNull
    private Integer manufactureYear;

    @NotBlank
    @Column(unique = true)
    private String licensePlate;

    @NotNull
    @Positive
    private Integer price;

    // 📍 GPS (CORE FEATURE)
    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    // 🚗 Availability
    @Column(nullable = false)
    private boolean available = true;
}