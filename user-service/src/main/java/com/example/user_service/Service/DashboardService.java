package com.example.user_service.Service;

import com.example.user_service.Model.User;
import com.example.user_service.Repository.UserRepository;
import com.example.user_service.vehicleDtos.Vehicle;
import com.example.user_service.vehicleDtos.VehicleResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class DashboardService {

    private final RestTemplate restTemplate;
    private final UserRepository userRepository;

    private final String VEHICLE_SERVICE_URL =
            "http://localhost:8085/vehicles/nearby?lat={lat}&lng={lng}&radius={radius}";

    public List<VehicleResponseDTO> getNearbyVehicles(Long userId, double radiusKm) {

        // 1️⃣ Get user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 2️⃣ Call vehicle service for nearby vehicles
        ResponseEntity<VehicleResponseDTO[]> response =
                restTemplate.getForEntity(
                        VEHICLE_SERVICE_URL,
                        VehicleResponseDTO[].class,
                        user.getLatitude(),
                        user.getLongitude(),
                        radiusKm
                );

        if (response.getBody() == null) {
            return Collections.emptyList();
        }

        // 3️⃣ Filter only available vehicles
        return Arrays.stream(response.getBody())
                .filter(VehicleResponseDTO::isAvailable)
                .collect(Collectors.toList());
    }
}


