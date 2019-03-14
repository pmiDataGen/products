package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Device {

	public Device() {
	}

	// private String device_serial_number; // primary Key for database "c360"
	private String device_codentify;// primary Key for database "db_l0_adl"
	private String identity_unique_identifier;
	private String persona_identifier;
	private String barcode;
	private String device_type;
	private String device_version;
	private String device_description;
	private long purchase_date;
	private long registration_device_date;
	private String status;
	private long status_date_change;
	private long warranty_starting_date;
	private long warranty_end_date;
	private long replacement_date;
	private String url_picture_link;
	private long cleaning_date;
	private String cleaning_coach;

	@JsonProperty("td:c360:operation")
	private String td_c360_operation;

	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;

	@Override
	public String toString() {
		return "Device [device_codentify=" + device_codentify + ", identity_unique_identifier="
				+ identity_unique_identifier + ", persona_identifier=" + persona_identifier + ", barcode=" + barcode
				+ ", device_type=" + device_type + ", device_version=" + device_version + ", device_description="
				+ device_description + ", purchase_date=" + purchase_date + ", registration_device_date="
				+ registration_device_date + ", status=" + status + ", status_date_change=" + status_date_change
				+ ", warranty_starting_date=" + warranty_starting_date + ", warranty_end_date=" + warranty_end_date
				+ ", replacement_date=" + replacement_date + ", url_picture_link=" + url_picture_link
				+ ", cleaning_date=" + cleaning_date + ", cleaning_coach=" + cleaning_coach + ", td_c360_operation="
				+ td_c360_operation + ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis
				+ ", recordConsistencyTime=" + recordConsistencyTime + "]";
	}

	public String getDevice_codentify() {
		return device_codentify;
	}

	public void setDevice_codentify(String device_codentify) {
		this.device_codentify = device_codentify;
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

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}

	public String getDevice_version() {
		return device_version;
	}

	public void setDevice_version(String device_version) {
		this.device_version = device_version;
	}

	public String getDevice_description() {
		return device_description;
	}

	public void setDevice_description(String device_description) {
		this.device_description = device_description;
	}

	public long getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(long purchase_date) {
		this.purchase_date = purchase_date;
	}

	public long getRegistration_device_date() {
		return registration_device_date;
	}

	public void setRegistration_device_date(long registration_device_date) {
		this.registration_device_date = registration_device_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getStatus_date_change() {
		return status_date_change;
	}

	public void setStatus_date_change(long status_date_change) {
		this.status_date_change = status_date_change;
	}

	public long getWarranty_starting_date() {
		return warranty_starting_date;
	}

	public void setWarranty_starting_date(long warranty_starting_date) {
		this.warranty_starting_date = warranty_starting_date;
	}

	public long getWarranty_end_date() {
		return warranty_end_date;
	}

	public void setWarranty_end_date(long warranty_end_date) {
		this.warranty_end_date = warranty_end_date;
	}

	public long getReplacement_date() {
		return replacement_date;
	}

	public void setReplacement_date(long replacement_date) {
		this.replacement_date = replacement_date;
	}

	public String getUrl_picture_link() {
		return url_picture_link;
	}

	public void setUrl_picture_link(String url_picture_link) {
		this.url_picture_link = url_picture_link;
	}

	public long getCleaning_date() {
		return cleaning_date;
	}

	public void setCleaning_date(long cleaning_date) {
		this.cleaning_date = cleaning_date;
	}

	public String getCleaning_coach() {
		return cleaning_coach;
	}

	public void setCleaning_coach(String cleaning_coach) {
		this.cleaning_coach = cleaning_coach;
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
	 * private String device_codentify; // this is primary key private String
	 * identity_unique_identifier; private String persona_identifier; private String
	 * device_type; private String device_version; private String
	 * registration_device_date; private String status; private String
	 * component_Code; private String status_date_change; private String
	 * end_of_warranty_date; private String home_country;
	 * 
	 * // Below fields received from POSTMAN response private String identity_id;
	 * private String model; private String persona_id; private String
	 * device_serial_number; // private String time; // private String
	 * td_c360_operation_time; // td:c360:operation_time
	 */

}