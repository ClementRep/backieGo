package com.example.vehicle_service.Service;

import com.example.vehicle_service.DTO.VehicleResponseDTO;
import com.example.vehicle_service.DTO.VehicleRequestDTO;
import com.example.vehicle_service.Model.Vehicle;
import com.example.vehicle_service.Repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository.vehicleRepository vehicleRepository;

    @Override
    public VehicleResponseDTO registerVehicle(VehicleRequestDTO request) {
        Vehicle vehicle = Vehicle.builder()
                .make(request.getMake())
                .model(request.getModel())
                .licensePlate(request.getLicensePlate())
                .year(request.getYear())
                .ownerId(request.getOwnerId())
                .build();

        Vehicle saved = vehicleRepository.save(vehicle);

        return new VehicleResponseDTO(
                saved.getId(),
                saved.getOwnerId(),
                saved.getMake(),
                saved.getModel(),
                saved.getLicensePlate(),
                saved.getYear()
        );
    }

    @Override
    public List<VehicleResponseDTO> getAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(v -> new VehicleResponseDTO(
                        v.getId(),
                        v.getOwnerId(),
                        v.getMake(),
                        v.getModel(),
                        v.getLicensePlate(),
                        v.getYear()
                ))
                .collect(Collectors.toList());
    }
}
