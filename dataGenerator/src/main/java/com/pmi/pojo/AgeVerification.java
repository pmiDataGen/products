package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class AgeVerification {

	public AgeVerification() {

	}

	private String av_id;// primary Key for database "db_l0_adl"
	private String identity_unique_identifier;
	private String status_code;
	private String status_description;
	private String av_type_code;
	private String av_type_description;
	private String av_subtype_code;
	private String av_subtype_description;
	private String country_code;
	private String country_description;
	private String state;

	@JsonProperty("td:c360:operation")
	private String td_c360_operation;
	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;

	@Override
	public String toString() {
		return "AgeVerification [av_id=" + av_id + ", identity_unique_identifier=" + identity_unique_identifier
				+ ", status_code=" + status_code + ", status_description=" + status_description + ", av_type_code="
				+ av_type_code + ", av_type_description=" + av_type_description + ", av_subtype_code=" + av_subtype_code
				+ ", av_subtype_description=" + av_subtype_description + ", country_code=" + country_code
				+ ", country_description=" + country_description + ", state=" + state + ", td_c360_operation="
				+ td_c360_operation + ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis
				+ ", recordConsistencyTime=" + recordConsistencyTime + "]";
	}

	public String getAv_id() {
		return av_id;
	}

	public void setAv_id(String av_id) {
		this.av_id = av_id;
	}

	public String getIdentity_unique_identifier() {
		return identity_unique_identifier;
	}

	public void setIdentity_unique_identifier(String identity_unique_identifier) {
		this.identity_unique_identifier = identity_unique_identifier;
	}

	public String getStatus_code() {
		return status_code;
	}

	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}

	public String getStatus_description() {
		return status_description;
	}

	public void setStatus_description(String status_description) {
		this.status_description = status_description;
	}

	public String getAv_type_code() {
		return av_type_code;
	}

	public void setAv_type_code(String av_type_code) {
		this.av_type_code = av_type_code;
	}

	public String getAv_type_description() {
		return av_type_description;
	}

	public void setAv_type_description(String av_type_description) {
		this.av_type_description = av_type_description;
	}

	public String getAv_subtype_code() {
		return av_subtype_code;
	}

	public void setAv_subtype_code(String av_subtype_code) {
		this.av_subtype_code = av_subtype_code;
	}

	public String getAv_subtype_description() {
		return av_subtype_description;
	}

	public void setAv_subtype_description(String av_subtype_description) {
		this.av_subtype_description = av_subtype_description;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getCountry_description() {
		return country_description;
	}

	public void setCountry_description(String country_description) {
		this.country_description = country_description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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