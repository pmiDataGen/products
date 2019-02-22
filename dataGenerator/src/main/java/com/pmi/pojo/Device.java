package com.pmi.pojo;

import java.util.Date;

public class Device {
	private String td_c360_operation;
	private String device_codentify; // this is primary key
	private String identity_unique_identifier;
	private String persona_identifier;
	private String device_type;
	private String device_version;
	private Date registration_device_date;
	private String status;
	private String component_Code;
	private Date status_date_change;
	private Date end_of_warranty_date;
	private String home_country;
	private String apiCallTimeTakenInMillis;

	// Below fields received from POSTMAN response
	private String identity_id;
	private String model;
	private String persona_id;
	private String device_serial_number;
	// private String time;
	// private String td_c360_operation_time; // td:c360:operation_time

	public Device() {
		System.out.println("This is Device - Default Constructor");
	}

	public Device(String device_codentify) {
		this.device_codentify = device_codentify;
	}

	@Override
	public String toString() {
		return "Device [td_c360_operation=" + td_c360_operation + ", device_codentify=" + device_codentify
				+ ", identity_unique_identifier=" + identity_unique_identifier + ", persona_identifier="
				+ persona_identifier + ", device_type=" + device_type + ", device_version=" + device_version
				+ ", registration_device_date=" + registration_device_date + ", status=" + status + ", component_Code="
				+ component_Code + ", status_date_change=" + status_date_change + ", end_of_warranty_date="
				+ end_of_warranty_date + ", home_country=" + home_country + ", apiCallTimeTakenInMillis="
				+ apiCallTimeTakenInMillis + ", identity_id=" + identity_id + ", model=" + model + ", persona_id="
				+ persona_id + ", device_serial_number=" + device_serial_number + "]";
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

	public Date getRegistration_device_date() {
		return registration_device_date;
	}

	public void setRegistration_device_date(Date registration_device_date) {
		this.registration_device_date = registration_device_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComponent_Code() {
		return component_Code;
	}

	public void setComponent_Code(String component_Code) {
		this.component_Code = component_Code;
	}

	public Date getStatus_date_change() {
		return status_date_change;
	}

	public void setStatus_date_change(Date status_date_change) {
		this.status_date_change = status_date_change;
	}

	public Date getEnd_of_warranty_date() {
		return end_of_warranty_date;
	}

	public void setEnd_of_warranty_date(Date end_of_warranty_date) {
		this.end_of_warranty_date = end_of_warranty_date;
	}

	public String getHome_country() {
		return home_country;
	}

	public void setHome_country(String home_country) {
		this.home_country = home_country;
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

	public String getIdentity_id() {
		return identity_id;
	}

	public void setIdentity_id(String identity_id) {
		this.identity_id = identity_id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(String persona_id) {
		this.persona_id = persona_id;
	}

	public String getDevice_serial_number() {
		return device_serial_number;
	}

	public void setDevice_serial_number(String device_serial_number) {
		this.device_serial_number = device_serial_number;
	}

}