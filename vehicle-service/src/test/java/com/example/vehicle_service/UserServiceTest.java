package com.example.vehicle_service;

import com.example.vehicle_service.Controller.VehicleController;
import com.example.vehicle_service.DTO.VehicleRequestDTO;
import com.example.vehicle_service.DTO.VehicleResponseDTO;
import com.example.vehicle_service.Service.VehicleService;
import com.example.vehicle_service.Repository.vehicleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private vehicleRepository vehicleRepository;

    @Mock
    private VehicleService vehicleService;

@InjectMocks
private VehicleController controller;

    @Test
        public void testController() throws Exception{

        VehicleRequestDTO request = new VehicleRequestDTO();
        VehicleResponseDTO response = new VehicleResponseDTO(
                1L,
                "12345",
                "toyota",
                "1",
                "2004",
                "CA123456"
        );

        request.setOwnerId("12345");
        request.setMake("toyota");
        request.setModel("1");
        request.setManufactureyear("2004");
        request.setLicensePlate("53pj4Nw");

when(vehicleService.registerVehicle(request)).thenReturn(response);

ResponseEntity<VehicleResponseDTO>result= controller.register(request);

assertEquals(HttpStatus.OK,result.getStatusCode());

assertEquals(response,result.getBody());

    }
}