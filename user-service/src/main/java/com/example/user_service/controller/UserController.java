package com.example.user_service.controller;

import com.example.user_service.Model.User;
import com.example.user_service.Repository.UserRepository;
import com.example.user_service.Service.DashboardService;
import com.example.user_service.Service.UserService;
import com.example.user_service.vehicleDtos.VehicleResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final DashboardService dashboardService;
    private final UserService userService;


    @GetMapping("/register")
    public String showuser(Model model) {
        model.addAttribute("user", new User());
        return "UserRegistration";
    }
    @PostMapping("/register")
    public String createUser(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam Double latitude,
                             @RequestParam Double longitude,
                             Model model) {

        // 1️⃣ Create user
        User user = userService.createUser(name, email, password, latitude, longitude);

        // 2️⃣ Get nearby vehicles for this user
        List<VehicleResponseDTO> nearbyVehicles = dashboardService.getNearbyVehicles(user.getId(), 5); // 5 km radius by default

        // 3️⃣ Add user and vehicles to the model
        model.addAttribute("user", user);
        model.addAttribute("vehicles", nearbyVehicles);

        // 4️⃣ Return the dashboard view directly
        return "dashboard";
    }


    // 2️⃣ User dashboard – get nearby vehicles
    @GetMapping("/dashboard/{userId}")
    public ResponseEntity<Map<String, Object>> dashboard(@PathVariable Long userId,
                                                         @RequestParam(defaultValue = "5") double radiusKm) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<VehicleResponseDTO> nearbyVehicles = dashboardService.getNearbyVehicles(userId, radiusKm);

        Map<String, Object> response = new HashMap<>();
        response.put("user", user);
        response.put("vehicles", nearbyVehicles);

        return ResponseEntity.ok(response);
    }
}


