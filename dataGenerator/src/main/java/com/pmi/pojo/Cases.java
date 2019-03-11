package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cases {

	public Cases() {

	}

	private String case_id; // to be replaced by "case_number" primary key
	private String identity_unique_identifier;
	private String persona_identifier;
	private String serial_numer;
	private long closing_date;
	private long create_date;
	private String status;
	private int subject_code;
	private int subject;
	private String resolution;
	private String case_description;
	private String customer_comment;

	private String td_c360_operation;
	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;

	@Override
	public String toString() {
		return "Cases [case_id=" + case_id + ", identity_unique_identifier=" + identity_unique_identifier
				+ ", persona_identifier=" + persona_identifier + ", serial_numer=" + serial_numer + ", closing_date="
				+ closing_date + ", create_date=" + create_date + ", status=" + status + ", subject_code="
				+ subject_code + ", subject=" + subject + ", resolution=" + resolution + ", case_description="
				+ case_description + ", customer_comment=" + customer_comment + ", td_c360_operation="
				+ td_c360_operation + ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis
				+ ", recordConsistencyTime=" + recordConsistencyTime + "]";
	}

	public String getCase_id() {
		return case_id;
	}

	public void setCase_id(String case_id) {
		this.case_id = case_id;
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

	public String getSerial_numer() {
		return serial_numer;
	}

	public void setSerial_numer(String serial_numer) {
		this.serial_numer = serial_numer;
	}

	public long getClosing_date() {
		return closing_date;
	}

	public void setClosing_date(long closing_date) {
		this.closing_date = closing_date;
	}

	public long getCreate_date() {
		return create_date;
	}

	public void setCreate_date(long create_date) {
		this.create_date = create_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(int subject_code) {
		this.subject_code = subject_code;
	}

	public int getSubject() {
		return subject;
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getCase_description() {
		return case_description;
	}

	public void setCase_description(String case_description) {
		this.case_description = case_description;
	}

	public String getCustomer_comment() {
		return customer_comment;
	}

	public void setCustomer_comment(String customer_comment) {
		this.customer_comment = customer_comment;
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

	/*
	 * private String identity_id; private String persona_id; private String
	 * order_id; private String case_Channel; private String case_source; private
	 * String case_type; private String case_Subtype; private String
	 * subject_description; private String latest_update_date; private String
	 * home_country; private String description; // "description": "ORDER"
	 */
//	private String time; 							// "time": "1548928418229"//No need to pass the values
//	private String td_c360_operation_time; 			// "td:c360:operation_time": "1548928418229.0"//No need to pass the values

}