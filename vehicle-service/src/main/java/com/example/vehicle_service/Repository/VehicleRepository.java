package com.example.vehicle_service.Repository;

import com.example.vehicle_service.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleRepository {

    public interface vehicleRepository extends JpaRepository<Vehicle, Long> {
        List<Vehicle> findByOwnerId(String ownerId);
    }
}
