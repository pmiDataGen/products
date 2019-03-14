package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author  boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class AgeVerification {

	public AgeVerification() {

	}
	private String AgeVerification_serial_number; // change it to "AgeVerification_codentify" Primary Key
	private String ageverification_id;
	private String identity_unique_identifier;
	private String persona_identifier;
	private String status;
	private String f2f_employee_id;
	private String type;
	private String country;
	private String region;
	private String request_channel;
	private String request_country;
	private String request_region;
	private String request_status;
	private long request_date;
	private long request_status_change_date;
	private String document_type;
	private String document_country;
	private String document_number;
	private long document_expiration_date;
	private String document_image_link;
	
	@JsonProperty("td:c360:operation")
	private String td_c360_operation;
	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;
	
	@Override
	public String toString() {
		return "AgeVerification [AgeVerification_serial_number=" + AgeVerification_serial_number
				+ ", ageverification_id=" + ageverification_id + ", identity_unique_identifier="
				+ identity_unique_identifier + ", persona_identifier=" + persona_identifier + ", status=" + status
				+ ", f2f_employee_id=" + f2f_employee_id + ", type=" + type + ", country=" + country + ", region="
				+ region + ", request_channel=" + request_channel + ", request_country=" + request_country
				+ ", request_region=" + request_region + ", request_status=" + request_status + ", request_date="
				+ request_date + ", request_status_change_date=" + request_status_change_date + ", document_type="
				+ document_type + ", document_country=" + document_country + ", document_number=" + document_number
				+ ", document_expiration_date=" + document_expiration_date + ", document_image_link="
				+ document_image_link + ", td_c360_operation=" + td_c360_operation + ", apiCallTimeTakenInMillis="
				+ apiCallTimeTakenInMillis + ", recordConsistencyTime=" + recordConsistencyTime + "]";
	}

	public String getAgeVerification_serial_number() {
		return AgeVerification_serial_number;
	}

	public void setAgeVerification_serial_number(String ageVerification_serial_number) {
		AgeVerification_serial_number = ageVerification_serial_number;
	}

	public String getAgeverification_id() {
		return ageverification_id;
	}

	public void setAgeverification_id(String ageverification_id) {
		this.ageverification_id = ageverification_id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getF2f_employee_id() {
		return f2f_employee_id;
	}

	public void setF2f_employee_id(String f2f_employee_id) {
		this.f2f_employee_id = f2f_employee_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRequest_channel() {
		return request_channel;
	}

	public void setRequest_channel(String request_channel) {
		this.request_channel = request_channel;
	}

	public String getRequest_country() {
		return request_country;
	}

	public void setRequest_country(String request_country) {
		this.request_country = request_country;
	}

	public String getRequest_region() {
		return request_region;
	}

	public void setRequest_region(String request_region) {
		this.request_region = request_region;
	}

	public String getRequest_status() {
		return request_status;
	}

	public void setRequest_status(String request_status) {
		this.request_status = request_status;
	}

	public long getRequest_date() {
		return request_date;
	}

	public void setRequest_date(long request_date) {
		this.request_date = request_date;
	}

	public long getRequest_status_change_date() {
		return request_status_change_date;
	}

	public void setRequest_status_change_date(long request_status_change_date) {
		this.request_status_change_date = request_status_change_date;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public String getDocument_country() {
		return document_country;
	}

	public void setDocument_country(String document_country) {
		this.document_country = document_country;
	}

	public String getDocument_number() {
		return document_number;
	}

	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}

	public long getDocument_expiration_date() {
		return document_expiration_date;
	}

	public void setDocument_expiration_date(long document_expiration_date) {
		this.document_expiration_date = document_expiration_date;
	}

	public String getDocument_image_link() {
		return document_image_link;
	}

	public void setDocument_image_link(String document_image_link) {
		this.document_image_link = document_image_link;
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