package com.cognizant.client_campaign_management_system.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableWebSecurity
@EnableEurekaClient
public class ClientEnrollmentApplication {
	// private final Logger logger =
	// LoggerFactory.getLogger(ClientEnrollmentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ClientEnrollmentApplication.class, args);
	}

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
