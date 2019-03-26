package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignEvents {

	public CampaignEvents() {

	}
	
	private String campaign_event_id;
	private String identity_unique_identifier;
	private String persona_identifier;
	private long campaign_event_date;
	private String campaign_event_type_code;
	private String campaign_event_type_description;
	private String campaign_activity;
	
	@JsonProperty("td:c360:operation")
	private String td_c360_operation;
	
	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime; 
	
	@Override
	public String toString() {
		return "CampaignEvents [campaign_event_id=" + campaign_event_id + ", identity_unique_identifier="
				+ identity_unique_identifier + ", persona_identifier=" + persona_identifier + ", campaign_event_date="
				+ campaign_event_date + ", campaign_event_type_code=" + campaign_event_type_code
				+ ", campaign_event_type_description=" + campaign_event_type_description + ", campaign_activity="
				+ campaign_activity + ", td_c360_operation=" + td_c360_operation + ", apiCallTimeTakenInMillis="
				+ apiCallTimeTakenInMillis + ", recordConsistencyTime=" + recordConsistencyTime + "]";
	}
	
	
	public String getTd_c360_operation() {
		return td_c360_operation;
	}


	public void setTd_c360_operation(String td_c360_operation) {
		this.td_c360_operation = td_c360_operation;
	}


	public String getApiCallTimeTakenInMillis() {
		return apiCallTimeTakenInMillis;
	}


	public void setApiCallTimeTakenInMillis(String apiCallTimeTakenInMillis) {
		this.apiCallTimeTakenInMillis = apiCallTimeTakenInMillis;
	}


	public String getRecordConsistencyTime() {
		return recordConsistencyTime;
	}


	public void setRecordConsistencyTime(String recordConsistencyTime) {
		this.recordConsistencyTime = recordConsistencyTime;
	}


	public String getCampaign_event_id() {
		return campaign_event_id;
	}
	public void setCampaign_event_id(String campaign_event_id) {
		this.campaign_event_id = campaign_event_id;
	}
	public String getIdentity_unique_identifier() {
		return identity_unique_identifier;
	}
	public void setIdentity_unique_identifier(String identity_unique_identifier) {
		this.identity_unique_identifier = identity_unique_identifier;
	}
	public String getPersona_identifier() {
		return persona_identifier;
	}
	public void setPersona_identifier(String persona_identifier) {
		this.persona_identifier = persona_identifier;
	}
	public long getCampaign_event_date() {
		return campaign_event_date;
	}
	public void setCampaign_event_date(long campaign_event_date) {
		this.campaign_event_date = campaign_event_date;
	}
	public String getCampaign_event_type_code() {
		return campaign_event_type_code;
	}
	public void setCampaign_event_type_code(String campaign_event_type_code) {
		this.campaign_event_type_code = campaign_event_type_code;
	}
	public String getCampaign_event_type_description() {
		return campaign_event_type_description;
	}
	public void setCampaign_event_type_description(String campaign_event_type_description) {
		this.campaign_event_type_description = campaign_event_type_description;
	}
	public String getCampaign_activity() {
		return campaign_activity;
	}
	public void setCampaign_activity(String campaign_activity) {
		this.campaign_activity = campaign_activity;
	}

}