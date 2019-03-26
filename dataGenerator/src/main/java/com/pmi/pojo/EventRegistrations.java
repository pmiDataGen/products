package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventRegistrations {

	public EventRegistrations() {

	}
	
	private String event_registration_id;
	private String identity_unique_identifier;
	private String persona_identifier;
	private String event_name;
	private long event_start_date;
	private String event_location;
	private String event_status_code;
	private String event_status_description;
	private long person_registration_date;
	private Boolean person_registration_attendance;
	
	@JsonProperty("td:c360:operation")
	private String td_c360_operation;
	
	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime; 
	@Override
	public String toString() {
		return "EventRegistrations [event_registration_id=" + event_registration_id + ", identity_unique_identifier="
				+ identity_unique_identifier + ", persona_identifier=" + persona_identifier + ", event_name="
				+ event_name + ", event_start_date=" + event_start_date + ", event_location=" + event_location
				+ ", event_status_code=" + event_status_code + ", event_status_description=" + event_status_description
				+ ", person_registration_date=" + person_registration_date + ", person_registration_attendance="
				+ person_registration_attendance + ", td_c360_operation=" + td_c360_operation
				+ ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis + ", recordConsistencyTime="
				+ recordConsistencyTime + "]";
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
	public String getEvent_registration_id() {
		return event_registration_id;
	}
	public void setEvent_registration_id(String event_registration_id) {
		this.event_registration_id = event_registration_id;
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
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public long getEvent_start_date() {
		return event_start_date;
	}
	public void setEvent_start_date(long event_start_date) {
		this.event_start_date = event_start_date;
	}
	public String getEvent_location() {
		return event_location;
	}
	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}
	public String getEvent_status_code() {
		return event_status_code;
	}
	public void setEvent_status_code(String event_status_code) {
		this.event_status_code = event_status_code;
	}
	public String getEvent_status_description() {
		return event_status_description;
	}
	public void setEvent_status_description(String event_status_description) {
		this.event_status_description = event_status_description;
	}

	
	public long getPerson_registration_date() {
		return person_registration_date;
	}
	public void setPerson_registration_date(long person_registration_date) {
		this.person_registration_date = person_registration_date;
	}
	public Boolean getPerson_registration_attendance() {
		return person_registration_attendance;
	}
	public void setPerson_registration_attendance(Boolean person_registration_attendance) {
		this.person_registration_attendance = person_registration_attendance;
	}
	
}