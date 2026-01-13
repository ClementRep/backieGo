package com.example.vehicle_service;

import com.example.vehicle_service.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehicleServiceApplication {

    @Autowired
    private VehicleService vehService;

	public static void main(String[] args) {

		SpringApplication.run(VehicleServiceApplication.class, args);
	}
}
