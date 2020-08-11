package com.cognizant.client_campaign_management_system.campaign.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.client_campaign_management_system.campaign.model.Campaign;
import com.cognizant.client_campaign_management_system.campaign.repository.CampaignRepository;

@Service
public class CampaignService {
	@Autowired
	CampaignRepository campaignRepository;

	public Optional<Campaign> getCampaignById(int clientId) {

		Optional<Campaign> client = campaignRepository.findById(clientId);
		if (client != null) {

			return Optional.of(client.get());
		}

		return Optional.empty();

	}

	public List<Campaign> getAllCampaign() {
		List<Campaign> campaign = new ArrayList<Campaign>();
		campaignRepository.findAll().forEach(campaign1 -> campaign.add(campaign1));
		return campaign;
	}

	public String saveOrUpdate(Campaign campaign) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String effective_Date = sdf.format(campaign.getCampaignEffectiveDate());
			String end_Date = sdf.format(campaign.getCampaignEndDate());
			Date effectiveDate = sdf.parse(effective_Date);
			Date endDate = sdf.parse(end_Date);
			Date currentDate = new Date();
			if (!(effectiveDate.compareTo(endDate) < 0))
				return "Effective Date should be less than End Date";
			if (!(effectiveDate.compareTo(currentDate) >= 0))
				return "Effective Date should be greater than End Date";
			Campaign campaign1 = campaignRepository.save(campaign);
			return campaign1.toString();
		} catch (Exception e) {
			return "Enter Correct date format";
		}
	}

	public void update(Campaign campaign, int campaignId) {
		campaignRepository.save(campaign);

	}

	public void delete(int campaignId) {
		{
			campaignRepository.deleteById(campaignId);

		}

	}

	public List<Campaign> getCampaignFromClient(int clientId) {
		List<Campaign> campaignList1 = campaignRepository.findByClientId(clientId);

		return campaignList1;
	}

}
