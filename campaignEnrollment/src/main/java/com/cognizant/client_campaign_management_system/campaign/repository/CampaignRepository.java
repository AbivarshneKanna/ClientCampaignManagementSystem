package com.cognizant.client_campaign_management_system.campaign.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.client_campaign_management_system.campaign.model.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
	List<Campaign> findByClientId(int clientId);

}
