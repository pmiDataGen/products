package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Interaction {

	public Interaction() {

	}

	private String interaction_id;// primary Key for database "db_l0_adl"
	private String identity_unique_identifier;
	private String persona_identifier;
	private String interaction_type;
	private String trial_purpose;
	private String trial_platform;
	private String trial_type;
	private long trial_date;
	private int trial_duration;

	@JsonProperty("td:c360:operation")
	private String td_c360_operation;
	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;

	@Override
	public String toString() {
		return "Interaction [interaction_id=" + interaction_id + ", identity_unique_identifier="
				+ identity_unique_identifier + ", persona_identifier=" + persona_identifier + ", interaction_type="
				+ interaction_type + ", trial_purpose=" + trial_purpose + ", trial_platform=" + trial_platform
				+ ", trial_type=" + trial_type + ", trial_date=" + trial_date + ", trial_duration=" + trial_duration
				+ ", td_c360_operation=" + td_c360_operation + ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis
				+ ", recordConsistencyTime=" + recordConsistencyTime + "]";
	}

	public String getInteraction_id() {
		return interaction_id;
	}

	public void setInteraction_id(String interaction_id) {
		this.interaction_id = interaction_id;
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

	public String getInteraction_type() {
		return interaction_type;
	}

	public void setInteraction_type(String interaction_type) {
		this.interaction_type = interaction_type;
	}

	public String getTrial_purpose() {
		return trial_purpose;
	}

	public void setTrial_purpose(String trial_purpose) {
		this.trial_purpose = trial_purpose;
	}

	public String getTrial_platform() {
		return trial_platform;
	}

	public void setTrial_platform(String trial_platform) {
		this.trial_platform = trial_platform;
	}

	public String getTrial_type() {
		return trial_type;
	}

	public void setTrial_type(String trial_type) {
		this.trial_type = trial_type;
	}

	public long getTrial_date() {
		return trial_date;
	}

	public void setTrial_date(long trial_date) {
		this.trial_date = trial_date;
	}

	public int getTrial_duration() {
		return trial_duration;
	}

	public void setTrial_duration(int trial_duration) {
		this.trial_duration = trial_duration;
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

}