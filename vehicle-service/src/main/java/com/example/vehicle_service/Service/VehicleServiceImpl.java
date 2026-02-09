package com.example.vehicle_service.Service;

import com.example.vehicle_service.DTO.VehicleResponseDTO;
import com.example.vehicle_service.DTO.VehicleRequestDTO;
import com.example.vehicle_service.Model.Vehicle;
import com.example.vehicle_service.Repository.vehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final vehicleRepository vehicleRepository;

    @Override
    public VehicleResponseDTO registerVehicle(VehicleRequestDTO request) {

        Vehicle vehicle = Vehicle.builder()
                .make(request.getMake())
                .model(request.getModel())
                .licensePlate(request.getLicensePlate())
                .manufactureyear(request.getManufactureyear())
                .ownerId(request.getOwnerId())
                .price(request.getPrice())

                // 📍 GPS (CRITICAL)
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())

                // 🚗 availability
                .available(true)
                .build();

        Vehicle saved = vehicleRepository.save(vehicle);

        return new VehicleResponseDTO(
                saved.getId(),
                saved.getOwnerId(),
                saved.getMake(),
                saved.getModel(),
                saved.getManufactureyear(),
                saved.getLicensePlate(),
                saved.getPrice(),
                saved.getLatitude(),
                saved.getLongitude(),
                saved.isAvailable()
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
                        v.getManufactureyear(),
                        v.getLicensePlate(),
                        v.getPrice(),
                        v.getLatitude(),
                        v.getLongitude(),
                        v.isAvailable()
                ))
                .collect(Collectors.toList());
    }

}
