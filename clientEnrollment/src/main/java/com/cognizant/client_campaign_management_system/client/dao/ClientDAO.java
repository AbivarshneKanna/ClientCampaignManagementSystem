package com.cognizant.client_campaign_management_system.client.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cognizant.client_campaign_management_system.client.model.Client;
import com.cognizant.client_campaign_management_system.client.model.Clients;

@Repository
public class ClientDAO {
	private static Clients list = new Clients();
	private Map<Integer, Client> DB = new HashMap<>();

	public Clients getAllClients() {
		return list;
	}

	public void addClient(Client client) {
		DB.put(client.getClientId(), client);
	}
}
