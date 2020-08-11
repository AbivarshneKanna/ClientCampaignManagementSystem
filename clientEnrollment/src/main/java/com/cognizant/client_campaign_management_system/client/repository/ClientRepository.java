package com.cognizant.client_campaign_management_system.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.client_campaign_management_system.client.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	public void deleteByClientId(int clientId);
}
