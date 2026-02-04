package com.example.user_service.vehicleDtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private Long id;
    private String make;
    private String model;
    private Integer price;

    // GPS
    private Double latitude;
    private Double longitude;

    // Availability
    private boolean available;
}