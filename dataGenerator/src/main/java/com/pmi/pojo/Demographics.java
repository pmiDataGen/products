package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Demographics {

	public Demographics() {

	}
	
	private String demographic_id;
	private String identity_unique_identifier;
	private String persona_identifier;
	@Override
	public String toString() {
		return "Demographics [demographic_id=" + demographic_id + ", identity_unique_identifier="
				+ identity_unique_identifier + ", persona_identifier=" + persona_identifier + "]";
	}
	public String getDemographic_id() {
		return demographic_id;
	}
	public void setDemographic_id(String demographic_id) {
		this.demographic_id = demographic_id;
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
	
	
}