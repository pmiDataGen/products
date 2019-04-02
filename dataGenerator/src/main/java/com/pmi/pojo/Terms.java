package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author vikas.e.mishra
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Terms {

	public Terms() {

	}
	
	private String terms_id;
	private String identity_unique_identifier;
	private String terms_version;
	private Boolean terms_acceptance;
	private long terms_acceptance_date;
	private String terms_type_code;
	private String terms_type_description;
	private String terms_code;
	private String terms_description;
	private String country_code;
	private String country_description;

	@JsonProperty("td:c360:operation")
	private String td_c360_operation;

	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;
	
	@Override
	public String toString() {
		return "Terms [terms_id=" + terms_id + ", identity_unique_identifier=" + identity_unique_identifier
				+ ", terms_version=" + terms_version + ", terms_acceptance=" + terms_acceptance
				+ ", terms_acceptance_date=" + terms_acceptance_date + ", terms_type_code=" + terms_type_code
				+ ", terms_type_description=" + terms_type_description + ", terms_code=" + terms_code
				+ ", terms_description=" + terms_description + ", country_code=" + country_code
				+ ", country_description=" + country_description + ", td_c360_operation=" + td_c360_operation
				+ ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis + ", recordConsistencyTime="
				+ recordConsistencyTime + "]";
	}

	public String getTerms_id() {
		return terms_id;
	}

	public void setTerms_id(String terms_id) {
		this.terms_id = terms_id;
	}

	public String getIdentity_unique_identifier() {
		return identity_unique_identifier;
	}

	public void setIdentity_unique_identifier(String identity_unique_identifier) {
		this.identity_unique_identifier = identity_unique_identifier;
	}

	public String getTerms_version() {
		return terms_version;
	}

	public void setTerms_version(String terms_version) {
		this.terms_version = terms_version;
	}

	public Boolean getTerms_acceptance() {
		return terms_acceptance;
	}

	public void setTerms_acceptance(Boolean terms_acceptance) {
		this.terms_acceptance = terms_acceptance;
	}

	public long getTerms_acceptance_date() {
		return terms_acceptance_date;
	}

	public void setTerms_acceptance_date(long terms_acceptance_date) {
		this.terms_acceptance_date = terms_acceptance_date;
	}

	public String getTerms_type_code() {
		return terms_type_code;
	}

	public void setTerms_type_code(String terms_type_code) {
		this.terms_type_code = terms_type_code;
	}

	public String getTerms_type_description() {
		return terms_type_description;
	}

	public void setTerms_type_description(String terms_type_description) {
		this.terms_type_description = terms_type_description;
	}

	public String getTerms_code() {
		return terms_code;
	}

	public void setTerms_code(String terms_code) {
		this.terms_code = terms_code;
	}

	public String getTerms_description() {
		return terms_description;
	}

	public void setTerms_description(String terms_description) {
		this.terms_description = terms_description;
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