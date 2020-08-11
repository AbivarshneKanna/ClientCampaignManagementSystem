package com.cognizant.client_campaign_management_system.client.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Campaign")
public class Campaign {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "campaign_Id")
	private int campaignId;
	@Column(name = "campaign_Name")
	@NonNull
	String campaignName;
	@Column(name = "description")
	@NonNull
	private String campaignDescription;
	@Column(name = "effective_Date")
	@NonNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date campaignEffectiveDate;
	@Column(name = "end_Date")
	@NonNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date campaignEndDate;
	private int clientId;

	public Campaign(int campaignId, String campaignName, String campaignDescription, Date campaignEffectiveDate,
			Date campaignEndDate, int clientId) {
		super();
		this.campaignId = campaignId;
		this.campaignName = campaignName;
		this.campaignDescription = campaignDescription;
		this.campaignEffectiveDate = campaignEffectiveDate;
		this.campaignEndDate = campaignEndDate;
		this.clientId = clientId;
	}

	public Campaign() {
		super();
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getCampaignDescription() {
		return campaignDescription;
	}

	public void setCampaignDescription(String campaignDescription) {
		this.campaignDescription = campaignDescription;
	}

	public Date getCampaignEffectiveDate() {
		return campaignEffectiveDate;
	}

	public void setCampaignEffectiveDate(Date campaignEffectiveDate) {
		this.campaignEffectiveDate = campaignEffectiveDate;
	}

	public Date getCampaignEndDate() {
		return campaignEndDate;
	}

	public void setCampaignEndDate(Date campaignEndDate) {
		this.campaignEndDate = campaignEndDate;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

}
