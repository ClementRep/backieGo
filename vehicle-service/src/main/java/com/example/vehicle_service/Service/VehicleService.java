package com.example.vehicle_service.Service;


import com.example.vehicle_service.DTO.VehicleRequestDTO;
import com.example.vehicle_service.DTO.VehicleResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    VehicleResponseDTO registerVehicle(VehicleRequestDTO request);
    List<VehicleResponseDTO> getAllVehicles();
}

