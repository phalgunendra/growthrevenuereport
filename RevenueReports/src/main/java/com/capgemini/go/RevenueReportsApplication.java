package com.capgemini.go;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RevenueReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevenueReportsApplication.class, args);
	}

}
