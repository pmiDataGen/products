package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cases {

	public Cases() {

	}

	// private String case_id; // primary Key for database "c360"
	private String case_number;// primary Key for database "db_l0_adl"
	private String identity_unique_identifier;
	private long closing_date;
	private long create_date;
	private long update_date;
	private String status_code;
	private String status_description;
	private String subject_code;
	private String subject_description;
	private String resolution;
	private String case_description;
	private String case_consumable_complaint_reason;
	private String case_product_generation_code;
	private String case_product_generation_description;
	private String case_subtype_code;
	private String case_subtype_description;
	private String case_type_code;
	private String case_type_description;

	@JsonProperty("td:c360:operation")
	private String td_c360_operation;
	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;

	@Override
	public String toString() {
		return "Cases [case_number=" + case_number + ", identity_unique_identifier=" + identity_unique_identifier
				+ ", closing_date=" + closing_date + ", create_date=" + create_date + ", update_date=" + update_date
				+ ", status_code=" + status_code + ", status_description=" + status_description + ", subject_code="
				+ subject_code + ", subject_description=" + subject_description + ", resolution=" + resolution
				+ ", case_description=" + case_description + ", case_consumable_complaint_reason="
				+ case_consumable_complaint_reason + ", case_product_generation_code=" + case_product_generation_code
				+ ", case_product_generation_description=" + case_product_generation_description
				+ ", case_subtype_code=" + case_subtype_code + ", case_subtype_description=" + case_subtype_description
				+ ", case_type_code=" + case_type_code + ", case_type_description=" + case_type_description
				+ ", td_c360_operation=" + td_c360_operation + ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis
				+ ", recordConsistencyTime=" + recordConsistencyTime + "]";
	}

	public String getCase_number() {
		return case_number;
	}

	public void setCase_number(String case_number) {
		this.case_number = case_number;
	}

	public String getIdentity_unique_identifier() {
		return identity_unique_identifier;
	}

	public void setIdentity_unique_identifier(String identity_unique_identifier) {
		this.identity_unique_identifier = identity_unique_identifier;
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

	public long getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(long update_date) {
		this.update_date = update_date;
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

	public String getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}

	public String getSubject_description() {
		return subject_description;
	}

	public void setSubject_description(String subject_description) {
		this.subject_description = subject_description;
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

	public String getCase_consumable_complaint_reason() {
		return case_consumable_complaint_reason;
	}

	public void setCase_consumable_complaint_reason(String case_consumable_complaint_reason) {
		this.case_consumable_complaint_reason = case_consumable_complaint_reason;
	}

	public String getCase_product_generation_code() {
		return case_product_generation_code;
	}

	public void setCase_product_generation_code(String case_product_generation_code) {
		this.case_product_generation_code = case_product_generation_code;
	}

	public String getCase_product_generation_description() {
		return case_product_generation_description;
	}

	public void setCase_product_generation_description(String case_product_generation_description) {
		this.case_product_generation_description = case_product_generation_description;
	}

	public String getCase_subtype_code() {
		return case_subtype_code;
	}

	public void setCase_subtype_code(String case_subtype_code) {
		this.case_subtype_code = case_subtype_code;
	}

	public String getCase_subtype_description() {
		return case_subtype_description;
	}

	public void setCase_subtype_description(String case_subtype_description) {
		this.case_subtype_description = case_subtype_description;
	}

	public String getCase_type_code() {
		return case_type_code;
	}

	public void setCase_type_code(String case_type_code) {
		this.case_type_code = case_type_code;
	}

	public String getCase_type_description() {
		return case_type_description;
	}

	public void setCase_type_description(String case_type_description) {
		this.case_type_description = case_type_description;
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