
package com.cognizant.client_campaign_management_system.client.test;

import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.client_campaign_management_system.client.service.ClientService;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {
    @Autowired
	ClientService clientService;
	SimpleDateFormat sdf;

	@BeforeEach
	public void init() {
		clientService = new ClientService();
		sdf = new SimpleDateFormat("yyyy-MM-dd");

	}

	@Test
	public void testCompareEffectiveAndEndDates() throws ParseException {
		String effectiveDate = "2017-01-09";
		String endDate = "2020-03-14";
		assertTrue(clientService.compareEffectiveAndEndDates(sdf.parse(effectiveDate), sdf.parse(endDate)));
	}

	@Test
	public void testCompareEffectiveAndCurrentDate() throws ParseException {
		String effectiveDate = "2020-11-11";
		Date currentDate = new Date();
		String currentDate1 = sdf.format(currentDate);
		assertTrue(clientService.compareEffectiveAndCurrentDate(sdf.parse(effectiveDate), sdf.parse(currentDate1)));
	}

}