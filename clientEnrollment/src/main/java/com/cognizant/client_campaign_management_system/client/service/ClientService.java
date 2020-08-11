package com.cognizant.client_campaign_management_system.client.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.cognizant.client_campaign_management_system.client.dao.ClientDAO;
import com.cognizant.client_campaign_management_system.client.model.Campaign;
import com.cognizant.client_campaign_management_system.client.model.Client;
import com.cognizant.client_campaign_management_system.client.repository.ClientRepository;

@Transactional
@Service
public class ClientService {
	@Autowired
	ClientService clientService;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ClientDAO dao;
	Logger log = Logger.getLogger(ClientService.class.getName());

	public Optional<Client> getClientById(int clientId) {

		Optional<Client> client = clientRepository.findById(clientId);
		if (client != null) {

			return Optional.of(client.get());
		}

		return Optional.empty();

	}

	public List<Client> getAllClients() {
		List<Client> client = new ArrayList<Client>();
		clientRepository.findAll().forEach(client1 -> client.add(client1));
		return client;
	}

	public String save(Client client) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String effective_Date = sdf.format(client.getClientEffectiveDate());
			String end_Date = sdf.format(client.getClientEndDate());
			Date effectiveDate = sdf.parse(effective_Date);
			Date endDate = sdf.parse(end_Date);
			Date currentDate = new Date();
			Boolean result1 = clientService.compareEffectiveAndEndDates(effectiveDate, endDate);
			Boolean result2 = clientService.compareEffectiveAndCurrentDate(effectiveDate, currentDate);
			if (!result1)
				return "Effective Date should be less than End Date";
			if (!result2)
				return "Effective Date should be greater than End Date";
			Client client1 = clientRepository.save(client);
			return client1.toString();

		} catch (Exception e) {
			return "Enter Correct date format";
		}

	}

	public Boolean compareEffectiveAndEndDates(Date effectiveDate, Date endDate) {
		if ((effectiveDate.compareTo(endDate) < 0))
			return true;
		return false;

	}

	public Boolean compareEffectiveAndCurrentDate(Date effectiveDate, Date currentDate) {
		if ((effectiveDate.compareTo(currentDate) >= 0))
			return true;
		return false;

	}

	public void update(Client client, int clientId) {
		clientRepository.save(client);
		log.info("Client details are updated");
	}

	public void delete(int clientId) {
		{
			clientRepository.deleteById(clientId);
			
		}

	}

	public List<Campaign> getAllCampaigns(int clientId) {
		final String uri = "http://campaign-management/campaign/getCampaignsFromClient/{clientId}";
		Campaign[] campaignList = restTemplate.getForObject(uri, Campaign[].class, clientId);
		List<Campaign> campaignList1 = Arrays.asList(campaignList);
		return campaignList1;
	}

	public void addClient(Client client) {
		dao.addClient(client);
	}
}
