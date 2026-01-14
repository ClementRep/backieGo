package com.example.vehicle_service.Controller;

import com.example.vehicle_service.DTO.VehicleRequestDTO;
import com.example.vehicle_service.DTO.VehicleResponseDTO;
import com.example.vehicle_service.Service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/api/vehicles")
    public String register(@RequestBody VehicleRequestDTO request) {
        return "vehicle";
    }

    @GetMapping("api/getvehicles")
    public String getAll(Model model) {
        List<VehicleResponseDTO> vehicles= vehicleService.getAllVehicles();
        model.addAttribute("vehicle",vehicles);
        return "dashboard";
    }
}
