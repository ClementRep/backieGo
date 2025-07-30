package com.rentmycar.controller;

import com.example.vehicle_service.DTO.VehicleRequestDTO;
import com.example.vehicle_service.DTO.VehicleResponseDTO;
import com.example.vehicle_service.Service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> register(@RequestBody VehicleRequestDTO request) {
        return ResponseEntity.ok(vehicleService.registerVehicle(request));
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> getAll() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }
}
