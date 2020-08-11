package com.cognizant.client_campaign_management_system.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springClient")
public class SpringController {
	public String getmsg() {
		return "Spring security - Role based access!";
	}

}
