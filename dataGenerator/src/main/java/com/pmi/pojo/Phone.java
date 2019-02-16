package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Phone {

	public Phone() {
		System.out.println("This is D.C Phone Class");
	}

	private String phone_identifier;
	private String persona_identifier;
	private String identity_unique_identifier;
	private String country_code_number;
	private String phone_number;
	private String comunication_opt_in;
	private String home_country;

	@Override
	public String toString() {
		return "Phone [identity_unique_identifier=" + identity_unique_identifier 
				+", persona_identifier=" + persona_identifier 
				+",phone_identifier="+ phone_identifier 
				+",country_code_number="+ country_code_number
				+",phone_number=" + phone_number  
				+", comunication_opt_in=" + comunication_opt_in 
				+", home_country=" + home_country + "]";
	}
	
	public String getPhone_identifiers() {
		return phone_identifier;
	}

	public void setPhone_identifier(String phone_identifier) {
		this.phone_identifier = phone_identifier ;
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
	
	public String getCountry_code_number() {
		return country_code_number;
	}

	public void setCountry_code_number(String country_code_number) {
		this.country_code_number = country_code_number;
	}
	
	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public String getHome_country() {
		return home_country;
	}

	public void setHome_country(String home_country) {
		this.home_country = home_country;
	}
	
	public String getComunication_opt_in() {
		return comunication_opt_in;
	}

	public void setComunication_opt_in(String comunication_opt_in) {
		this.comunication_opt_in = comunication_opt_in;
	}
}

