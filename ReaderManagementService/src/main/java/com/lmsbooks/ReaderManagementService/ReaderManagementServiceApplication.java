package com.lmsbooks.ReaderManagementService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ReaderManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReaderManagementServiceApplication.class, args);
	}

}
