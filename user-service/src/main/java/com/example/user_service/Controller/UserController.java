package com.example.user_service.Controller;

import com.example.user_service.Model.User;
import com.example.user_service.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/register")
    public String showuser(Model model) {
        model.addAttribute("user", new User());
        return "UserRegistration";
    }

    // Endpoint to create a user
    @PostMapping("/register")
    public String createUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        userService.createUser(name, email, password);
        return "successfully registered";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("users", userService.getalluser());
        System.out.println("Users: " + userService.getalluser());
        return "dashboard";
    }
}
