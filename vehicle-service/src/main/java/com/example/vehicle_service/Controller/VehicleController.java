package com.example.vehicle_service.Controller;

import com.example.vehicle_service.DTO.VehicleRequestDTO;
import com.example.vehicle_service.DTO.VehicleResponseDTO;
import com.example.vehicle_service.Service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    // Show registration form
    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("vehicle", new VehicleRequestDTO());
        return "vehicle_registration"; // Thymeleaf HTML form
    }

    // Handle form submission from Thymeleaf
    @PostMapping("/v1/register")
    public String registerVehicle(@ModelAttribute VehicleRequestDTO request,
                                  RedirectAttributes redirectAttributes,
                                  Model model) {

        // Save vehicle
        VehicleResponseDTO savedVehicle = vehicleService.registerVehicle(request);

        // Optionally, you can pass a success message
        redirectAttributes.addFlashAttribute("success", "Vehicle registered successfully!");

        // Redirect to dashboard view with all vehicles
        List<VehicleResponseDTO> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicles);

        return "dashboard"; // Thymeleaf dashboard view
    }

    // REST API: return JSON list of vehicles
    @GetMapping("/get")
    @ResponseBody
    public List<VehicleResponseDTO> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // HTML dashboard for browser (optional)
    @GetMapping("/dashboard")
    public String viewDashboard(Model model) {
        List<VehicleResponseDTO> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "dashboard"; // Thymeleaf view
    }
}
