package com.example.Santander;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SantanderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantanderApplication.class, args);
	}

}
