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
	private String case_identifier;
	private String identity_unique_identifier;
	private String persona_identifier;
	private String serial_numer;
	private String order_identifier;
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
	private String time; 							// "time": "1548928418229"
	private String td_c360_operation_time; 			// "td:c360:operation_time": "1548928418229.0"

	@Override
	public String toString() {
		return "Cases [identity_unique_identifier=" + identity_unique_identifier 
				+ ", persona_identifier=" + persona_identifier 
				+",time="+ time 
				+",td_c360_operation_time="+ td_c360_operation_time
				+ ",case_identifier=" + case_identifier  
				+ ", serial_numer=" + serial_numer 
				+ ", order_identifier=" + order_identifier 
				+ ",closing_date=" + closing_date 
				+ ",case_Channel="+ case_Channel 
				+",create_date="+ create_date 
				+",case_source="+ case_source 
				+ ",case_type=" + case_type  
				+ ", case_Subtype=" + case_Subtype 
				+ ", status=" + status 
				+ ",subject_code=" + subject_code 
				+ ",home_country="+ home_country 
				+",subject_description="+ subject_description 
				+",latest_update_date="+ latest_update_date + "]";
	}
	
	public String getCase_identifier() {
		return case_identifier;
	}

	public void setCase_identifier(String case_identifier) {
		this.case_identifier = case_identifier ;
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
		this.persona_identifier = persona_identifier ;
	}
	
	public String getSerial_numer() {
		return serial_numer;
	}

	public void setSerial_numer(String serial_numer) {
		this.serial_numer = serial_numer ;
	}
	
	public String getOrder_identifier() {
		return order_identifier;
	}

	public void setOrder_identifier(String order_identifier) {
		this.order_identifier = order_identifier ;
	}
	
	public String getClosing_date() {
		return closing_date;
	}

	public void setClosing_date(String closing_date) {
		this.closing_date = closing_date ;
	}
	
	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date ;
	}
	
	public String getCase_Channel() {
		return case_Channel;
	}

	public void setCase_Channel(String case_Channel) {
		this.case_Channel = case_Channel ;
	}
	
	public String getCase_source() {
		return case_source;
	}

	public void setCase_source(String case_source) {
		this.case_source = case_source ;
	}
	
	public String getCase_type() {
		return case_type;
	}

	public void setCase_type(String case_type) {
		this.case_type = case_type ;
	}
	
	public String getCase_Subtype() {
		return case_Subtype;
	}

	public void setCase_Subtype(String case_Subtype) {
		this.case_Subtype = case_Subtype ;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status ;
	}
	
	public int getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(int subject_code) {
		this.subject_code = subject_code ;
	}
	
	public int getSubject_description() {
		return subject_description;
	}

	public void setSubject_description(int subject_description) {
		this.subject_description = subject_description ;
	}
	
	public String getLatest_update_date() {
		return latest_update_date;
	}

	public void setLatest_update_date(String latest_update_date) {
		this.latest_update_date = latest_update_date ;
	}
	
	public String getHome_country() {
		return home_country;
	}

	public void setHome_country(String home_country) {
		this.home_country = home_country;
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