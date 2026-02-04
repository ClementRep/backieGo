package com.example.user_service.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    // 📍 User location (CRITICAL for nearby vehicles)
    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    public User() {}

    public User(String name, String email, String password,
                Double latitude, Double longitude) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
}
