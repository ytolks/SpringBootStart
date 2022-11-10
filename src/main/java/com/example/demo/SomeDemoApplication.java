package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SomeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SomeDemoApplication.class, args);

	}
}
