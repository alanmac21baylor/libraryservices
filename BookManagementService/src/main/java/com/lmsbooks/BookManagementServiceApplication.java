package com.lmsbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//@EnableResourceServer
@EnableBinding(Source.class)
public class BookManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced  // Enables RestTemplate to use service discovery to resolve URLs
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
