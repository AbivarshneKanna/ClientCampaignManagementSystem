package com.cognizant.client_campaign_management_system.campaign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CampaignEnrollmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampaignEnrollmentApplication.class, args);

	}

}
