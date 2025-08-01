package com.example.user_service.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Works with SQLite
    private Long id;
    private String name;
    private String email;
    private String password;

    public User(){
    }
    // Constructors, getters, and setters...
    // Constructor for easy dummy user creation
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
