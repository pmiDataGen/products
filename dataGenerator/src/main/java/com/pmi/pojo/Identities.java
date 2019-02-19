
package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Identities {

	public Identities() {
		System.out.println("This is D.C Identities Class");
	}
	private String identity_unique_identifier;
	private String persona_identifier;
	private String login_name;
	private String first_name;
	private String last_name;
	private String gender;
	private String home_country;
	private boolean is_deleted;
	private boolean blocked_flag;
	private String consumer_type;
	private String preferred_language;
	private String date_of_birth;
	private String segment;
	private String last_login_date;
	private String registration_date; 				// registration date
	private String time; 							// "time": "1548928418229"
	private String td_c360_operation_time; 			// "td:c360:operation_time": "1548928418229.0"
	private String nick_name; 						// "nickname": "SDoe"
	private String full_name; 						// "full_name": "Sue Doe"
	private String email; 							// "email": "sdoe1@pmi.com"
	private String address; 						// "address": "US, Los Angeles, 1st Alley"
	private String phone_name; 						// "phone_number": "501502503.0"
	private String registration_source_app;
	private String registration_country;
	private String registration_referal_identifier;
	
	@Override
	public String toString() {
		return "Identities [identity_unique_identifier=" + identity_unique_identifier 
				+ ", persona_identifier=" + persona_identifier 
				+ ",login_name=" + login_name  
				+ ", first_name=" + first_name 
				+ ", last_name=" + last_name 
				+ ",gender=" + gender 
				+ ",home_country="+ home_country 
				+",is_deleted="+ is_deleted 
				+",blocked_flag="+ blocked_flag 
				+",consumer_type="+ consumer_type 
				+",preferred_language="+ preferred_language 
				+",date_of_birth="+ date_of_birth 
				+",segment="+ segment 
				+",last_login_date="+ last_login_date
				+",registration_date="+ registration_date
				+",time="+ time 
				+",td_c360_operation_time="+ td_c360_operation_time
				+",nick_name="+ nick_name
				+",full_name="+ full_name
				+",email="+ email
				+",address="+ address
				+",phone_name="+ phone_name
				+",registration_source_app="+ registration_source_app
				+",registration_country="+ registration_country
				+",registration_referal_identifier="+ registration_referal_identifier + "]";
				
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

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHome_country() {
		return home_country;
	}

	public void setHome_country(String home_country) {
		this.home_country = home_country;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public boolean isBlocked_flag() {
		return blocked_flag;
	}

	public void setBlocked_flag(boolean blocked_flag) {
		this.blocked_flag = blocked_flag;
	}

	public String getConsumer_type() {
		return consumer_type;
	}

	public void setConsumer_type(String consumer_type) {
		this.consumer_type = consumer_type;
	}

	public String getPreferred_language() {
		return preferred_language;
	}

	public void setPreferred_language(String preferred_language) {
		this.preferred_language = preferred_language;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(String last_login_date) {
		this.last_login_date = last_login_date;
	}

	public String getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
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

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_name() {
		return phone_name;
	}

	public void setPhone_name(String phone_name) {
		this.phone_name = phone_name;
	}

	public String getRegistration_source_app() {
		return registration_source_app;
	}

	public void setRegistration_source_app(String registration_source_app) {
		this.registration_source_app = registration_source_app;
	}

	public String getRegistration_country() {
		return registration_country;
	}

	public void setRegistration_country(String registration_country) {
		this.registration_country = registration_country;
	}

	public String getRegistration_referal_identifier() {
		return registration_referal_identifier;
	}

	public void setRegistration_referal_identifier(String registration_referal_identifier) {
		this.registration_referal_identifier = registration_referal_identifier;
	}
	
	
}