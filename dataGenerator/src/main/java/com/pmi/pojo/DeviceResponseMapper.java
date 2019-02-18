package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceResponseMapper {

	// Below fields received from POSTMAN response
	private String identity_id;
	private String model;
	private String persona_id;
	private String device_serial_number;
	private String time;
	private String td_c360_operation_time; // td:c360:operation_time

	public DeviceResponseMapper() {
		System.out.println("This is DeviceResponseMapper - Default Constructor");
	}

	public DeviceResponseMapper(String identity_id, String model, String persona_id, String device_serial_number,
			String time, String td_c360_operation_time) {
		super();
		this.identity_id = identity_id;
		this.model = model;
		this.persona_id = persona_id;
		this.device_serial_number = device_serial_number;
		this.time = time;
		this.td_c360_operation_time = td_c360_operation_time;
	}

	@Override
	public String toString() {
		return "Device [identity_id=" + identity_id + ", model=" + model + ", persona_id=" + persona_id
				+ ", device_serial_number=" + device_serial_number + ", time=" + time + ", td_c360_operation_time="
				+ td_c360_operation_time + "]";
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTd_c360_operation_time() {
		return td_c360_operation_time;
	}

	public void setTd_c360_operation_time(String td_c360_operation_time) {
		this.td_c360_operation_time = td_c360_operation_time;
	}

}
