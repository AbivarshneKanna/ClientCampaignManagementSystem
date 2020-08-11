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
@Table(name = "Client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_id")
	private int clientId;
	@Column(name = "client_Name")
	@NonNull
	private String clientName;
	@Column(name = "effective_Date")
	@NonNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date clientEffectiveDate;
	@Column(name = "end_Date")
	@NonNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date clientEndDate;

	public Client(int clientId, String clientName, Date clientEffectiveDate, Date clientEndDate) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientEffectiveDate = clientEffectiveDate;
		this.clientEndDate = clientEndDate;
	}

	public Client() {
		super();
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Date getClientEffectiveDate() {
		return clientEffectiveDate;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientEffectiveDate="
				+ clientEffectiveDate + ", clientEndDate=" + clientEndDate + "]";
	}

	public void setClientEffectiveDate(Date clientEffectiveDate) {
		this.clientEffectiveDate = clientEffectiveDate;
	}

	public Date getClientEndDate() {
		return clientEndDate;
	}

	public void setClientEndDate(Date clientEndDate) {
		this.clientEndDate = clientEndDate;
	}

}
