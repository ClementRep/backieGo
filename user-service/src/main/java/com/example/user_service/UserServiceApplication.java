package com.example.user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.example.user_service.service",
				"com.example.user_service.controller",
				"com.example.user_service.repository"
		},
		exclude = org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration.class
)
public class UserServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}
