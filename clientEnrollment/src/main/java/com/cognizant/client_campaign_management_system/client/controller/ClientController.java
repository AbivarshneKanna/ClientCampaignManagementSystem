package com.cognizant.client_campaign_management_system.client.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.client_campaign_management_system.client.model.Campaign;
import com.cognizant.client_campaign_management_system.client.model.Client;
import com.cognizant.client_campaign_management_system.client.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	ClientService clientService;
	@RolesAllowed({"ADMIN"})
	@GetMapping("/{clientId}")
	private Optional<Client> getClient(@PathVariable("clientId") int clientId) {
		return clientService.getClientById(clientId);

	}
	@RolesAllowed({"ADMIN"})
	@GetMapping("/clientDetails")
	private List<Client> getAllClients() {
		return clientService.getAllClients();
	}
	@RolesAllowed({"ADMIN"})
	@PostMapping("/save")
	private int saveClient(@RequestBody Client client) {
		clientService.save(client);
		return client.getClientId();
	}
	@RolesAllowed({"ADMIN"})
	@PutMapping("/update")
	private Client update(@RequestBody Client client) {
		clientService.save(client);
		return client;
	}
	@RolesAllowed({"ADMIN"})
	@DeleteMapping("/delete/{clientId}")
	private void deleteClient(@PathVariable("clientId") int clientId) {
		clientService.delete(clientId);
	}
	@RolesAllowed({"ADMIN"})
	@GetMapping("/getCampaigns/{clientId}")
	public List<Campaign> getCampaigns(@PathVariable("clientId") int clientId) {
		return clientService.getAllCampaigns(clientId);
	}

}
