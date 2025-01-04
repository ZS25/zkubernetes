package com.sooruth.zkubernetes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class ZkubernetesApplication {
	public static final LocalDateTime dateAppDeployed = LocalDateTime.now();

	public static void main(String[] args) {
		SpringApplication.run(ZkubernetesApplication.class, args);
	}

	@GetMapping("/displayMessage") //http://localhost:8080/displayMessage?message=test
	public String displayMessage(@RequestParam String message) {
		return "Application successfully deployed on: " + dateAppDeployed + " with message: " + message;
	}

}
