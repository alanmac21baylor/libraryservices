package com.lmsloans;

import com.lmsloans.events.model.BookChangeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding(Sink.class)
public class LoanManagementServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(LoanManagementServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LoanManagementServiceApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void handleBookChange(BookChangeModel bookChange) {
		logger.debug("Received a {} event for book id {}", bookChange.getAction(), bookChange.getBookId());
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
