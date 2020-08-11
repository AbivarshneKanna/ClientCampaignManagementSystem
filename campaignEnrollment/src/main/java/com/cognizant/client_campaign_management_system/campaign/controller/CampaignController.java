package com.cognizant.client_campaign_management_system.campaign.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.cognizant.client_campaign_management_system.campaign.model.Campaign;
import com.cognizant.client_campaign_management_system.campaign.service.CampaignService;

@RestController
@RequestMapping("/campaign")
public class CampaignController {
	@Autowired
	CampaignService campaignService;
	RestTemplate restTemplate;

	@GetMapping("/{campaignId}")
	private Optional<Campaign> getClient(@PathVariable("campaignId") int campaignId) {
		return campaignService.getCampaignById(campaignId);

	}

	@GetMapping("/campaignDetails")
	private List<Campaign> getAllCampaign() {
		return campaignService.getAllCampaign();
	}

	@PostMapping("/save")
	private int saveCampaign(@RequestBody Campaign campaign) {
		campaignService.saveOrUpdate(campaign);
		return campaign.getCampaignId();
	}

	@PutMapping("/update")
	private Campaign update(@RequestBody Campaign campaign) {
		campaignService.saveOrUpdate(campaign);
		return campaign;
	}

	@DeleteMapping("/delete/{campaignId}")
	private void deleteCampaign(@PathVariable("campaignId") int campaignId) {
		campaignService.delete(campaignId);
	}

	@GetMapping("/getCampaignsFromClient/{clientId}")
	private List<Campaign> getCampaignFromClient(@PathVariable("clientId") int clientId) {
		return campaignService.getCampaignFromClient(clientId);
	}

}
