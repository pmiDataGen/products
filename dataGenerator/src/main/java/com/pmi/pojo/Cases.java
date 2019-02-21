package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cases {

	public Cases() {
		System.out.println("This is D.C Cases Class");
	}
	private String td_c360_operation;
	private String case_id;
	private String identity_id;
	private String persona_id;
	private String serial_numer;	
	private String order_id;
	private String closing_date;
	private String case_Channel;
	private String create_date;
	private String case_source;
	private String case_type;
	private String case_Subtype;
	private String status;
	private int subject_code;
	private int subject_description;
	private String latest_update_date;
	private String home_country;
	private String description;						// "description": "ORDER"
	private String apiCallTimeTakenInMillis;
//	private String time; 							// "time": "1548928418229"//No need to pass the values
//	private String td_c360_operation_time; 			// "td:c360:operation_time": "1548928418229.0"//No need to pass the values
	
	@Override
	public String toString() {
		return "Cases [td_c360_operation=" + td_c360_operation + ", case_id=" + case_id + ", identity_id=" + identity_id
				+ ", persona_id=" + persona_id + ", serial_numer=" + serial_numer + ", order_id=" + order_id
				+ ", closing_date=" + closing_date + ", case_Channel=" + case_Channel + ", create_date=" + create_date
				+ ", case_source=" + case_source + ", case_type=" + case_type + ", case_Subtype=" + case_Subtype
				+ ", status=" + status + ", subject_code=" + subject_code + ", subject_description="
				+ subject_description + ", latest_update_date=" + latest_update_date + ", home_country=" + home_country
				+ ", description=" + description + ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis + "]";
	}

	public String getCase_id() {
		return case_id;
	}

	public void setCase_id(String case_id) {
		this.case_id = case_id;
	}

	public String getIdentity_id() {
		return identity_id;
	}

	public void setIdentity_id(String identity_id) {
		this.identity_id = identity_id;
	}

	public String getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(String persona_id) {
		this.persona_id = persona_id;
	}

	public String getSerial_numer() {
		return serial_numer;
	}

	public void setSerial_numer(String serial_numer) {
		this.serial_numer = serial_numer;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getClosing_date() {
		return closing_date;
	}

	public void setClosing_date(String closing_date) {
		this.closing_date = closing_date;
	}

	public String getCase_Channel() {
		return case_Channel;
	}

	public void setCase_Channel(String case_Channel) {
		this.case_Channel = case_Channel;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getCase_source() {
		return case_source;
	}

	public void setCase_source(String case_source) {
		this.case_source = case_source;
	}

	public String getCase_type() {
		return case_type;
	}

	public void setCase_type(String case_type) {
		this.case_type = case_type;
	}

	public String getCase_Subtype() {
		return case_Subtype;
	}

	public void setCase_Subtype(String case_Subtype) {
		this.case_Subtype = case_Subtype;
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

	public int getSubject_description() {
		return subject_description;
	}

	public void setSubject_description(int subject_description) {
		this.subject_description = subject_description;
	}

	public String getLatest_update_date() {
		return latest_update_date;
	}

	public void setLatest_update_date(String latest_update_date) {
		this.latest_update_date = latest_update_date;
	}

	public String getHome_country() {
		return home_country;
	}

	public void setHome_country(String home_country) {
		this.home_country = home_country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	
	
}