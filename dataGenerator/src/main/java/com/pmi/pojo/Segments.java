package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author  boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Segments {

	public Segments() {

	}

	private String segment_id;
	private String persona_identifier;
	private String segment;
	
	@JsonProperty("td:c360:operation")
	private String td_c360_operation;
	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;
	
	@Override
	public String toString() {
		return "Segments [segment_id=" + segment_id + ", persona_identifier=" + persona_identifier + ", segment="
				+ segment + ", td_c360_operation=" + td_c360_operation + ", apiCallTimeTakenInMillis="
				+ apiCallTimeTakenInMillis + ", recordConsistencyTime=" + recordConsistencyTime + "]";
	}
	
	
	public String getSegment_id() {
		return segment_id;
	}
	public void setSegment_id(String segment_id) {
		this.segment_id = segment_id;
	}
	public String getPersona_identifier() {
		return persona_identifier;
	}
	public void setPersona_identifier(String persona_identifier) {
		this.persona_identifier = persona_identifier;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
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