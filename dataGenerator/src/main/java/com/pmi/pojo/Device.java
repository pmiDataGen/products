package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Device {

	public Device() {
	}

	// private String device_serial_number; // primary Key for database "c360"
	private String device_codentify;// primary Key for database "db_l0_adl"
	private String identity_unique_identifier;
	private String serial_number;
	private String device_type_code;
	private String device_type_description;
	private String device_version_code;
	private String device_version_description;
	private long purchase_date;
	private long registration_device_date;
	private String status_code;
	private String status_descritpion;
	private long status_date_change;
	private long warranty_starting_date;
	private long warranty_end_date;
	private long replacement_date;
	private String accidental_damage_coverage;
	private String accidental_damage_coverage_status_code;
	private String accidental_damage_coverage_status_description;

	@JsonProperty("td:c360:operation")
	private String td_c360_operation;
	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;

	@Override
	public String toString() {
		return "Device [device_codentify=" + device_codentify + ", identity_unique_identifier="
				+ identity_unique_identifier + ", serial_number=" + serial_number + ", device_type_code="
				+ device_type_code + ", device_type_description=" + device_type_description + ", device_version_code="
				+ device_version_code + ", device_version_description=" + device_version_description
				+ ", purchase_date=" + purchase_date + ", registration_device_date=" + registration_device_date
				+ ", status_code=" + status_code + ", status_descritpion=" + status_descritpion
				+ ", status_date_change=" + status_date_change + ", warranty_starting_date=" + warranty_starting_date
				+ ", warranty_end_date=" + warranty_end_date + ", replacement_date=" + replacement_date
				+ ", accidental_damage_coverage=" + accidental_damage_coverage
				+ ", accidental_damage_coverage_status_code=" + accidental_damage_coverage_status_code
				+ ", accidental_damage_coverage_status_description=" + accidental_damage_coverage_status_description
				+ ", td_c360_operation=" + td_c360_operation + ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis
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

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getDevice_type_code() {
		return device_type_code;
	}

	public void setDevice_type_code(String device_type_code) {
		this.device_type_code = device_type_code;
	}

	public String getDevice_type_description() {
		return device_type_description;
	}

	public void setDevice_type_description(String device_type_description) {
		this.device_type_description = device_type_description;
	}

	public String getDevice_version_code() {
		return device_version_code;
	}

	public void setDevice_version_code(String device_version_code) {
		this.device_version_code = device_version_code;
	}

	public String getDevice_version_description() {
		return device_version_description;
	}

	public void setDevice_version_description(String device_version_description) {
		this.device_version_description = device_version_description;
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

	public String getStatus_code() {
		return status_code;
	}

	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}

	public String getStatus_descritpion() {
		return status_descritpion;
	}

	public void setStatus_descritpion(String status_descritpion) {
		this.status_descritpion = status_descritpion;
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

	public String getAccidental_damage_coverage() {
		return accidental_damage_coverage;
	}

	public void setAccidental_damage_coverage(String accidental_damage_coverage) {
		this.accidental_damage_coverage = accidental_damage_coverage;
	}

	public String getAccidental_damage_coverage_status_code() {
		return accidental_damage_coverage_status_code;
	}

	public void setAccidental_damage_coverage_status_code(String accidental_damage_coverage_status_code) {
		this.accidental_damage_coverage_status_code = accidental_damage_coverage_status_code;
	}

	public String getAccidental_damage_coverage_status_description() {
		return accidental_damage_coverage_status_description;
	}

	public void setAccidental_damage_coverage_status_description(String accidental_damage_coverage_status_description) {
		this.accidental_damage_coverage_status_description = accidental_damage_coverage_status_description;
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