package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Psychographics {

	public Psychographics() {

	}
	
	private String pyschographic_id;
	private String identity_unique_identifier;
	private String persona_identifier;
	private Boolean declared_flag;
	
	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime; 
	
	@JsonProperty("td:c360:operation")
	private String td_c360_operation;
	
	
	@Override
	public String toString() {
		return "Psychographics [pyschographic_id=" + pyschographic_id + ", identity_unique_identifier="
				+ identity_unique_identifier + ", persona_identifier=" + persona_identifier + ", declared_flag="
				+ declared_flag + ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis + ", recordConsistencyTime="
				+ recordConsistencyTime + ", td_c360_operation=" + td_c360_operation + "]";
	}
	
	public String getApiCallTimeTakenInMillis() {
		return apiCallTimeTakenInMillis;
	}


	public void setApiCallTimeTakenInMillis(String apiCallTimeTakenInMillis) {
		this.apiCallTimeTakenInMillis = apiCallTimeTakenInMillis;
	}

	public String getTd_c360_operation() {
		return td_c360_operation;
	}


	public void setTd_c360_operation(String td_c360_operation) {
		this.td_c360_operation = td_c360_operation;
	}
	public String getRecordConsistencyTime() {
		return recordConsistencyTime;
	}


	public void setRecordConsistencyTime(String recordConsistencyTime) {
		this.recordConsistencyTime = recordConsistencyTime;
	}
	public String getPyschographic_id() {
		return pyschographic_id;
	}
	public void setPyschographic_id(String pyschographic_id) {
		this.pyschographic_id = pyschographic_id;
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
	public Boolean getDeclared_flag() {
		return declared_flag;
	}
	public void setDeclared_flag(Boolean declared_flag) {
		this.declared_flag = declared_flag;
	}

	
}