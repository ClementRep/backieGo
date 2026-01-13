package com.example.vehicle_service.Controller;

import com.example.vehicle_service.DTO.VehicleRequestDTO;
import com.example.vehicle_service.DTO.VehicleResponseDTO;
import com.example.vehicle_service.Service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/api/vehicles")
    public ResponseEntity<VehicleResponseDTO> register(@RequestBody VehicleRequestDTO request) {
        return ResponseEntity.ok(vehicleService.registerVehicle(request));
    }

    @GetMapping("api/getvehicles")
    public ResponseEntity<List<VehicleResponseDTO>> getAll() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }
}
