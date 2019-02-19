package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Email {

	public Email() {
		System.out.println("This is D.C Email Class");
	}

	private String email_address;
	private String persona_identifier;
	private String identity_unique_identifier;
	private String comunication_opt_in;
	private String home_country;

	@Override
	public String toString() {
		return "Email [identity_unique_identifier=" + identity_unique_identifier 
				+", persona_identifier=" + persona_identifier 
				+",email_address="+ email_address
				+", comunication_opt_in=" + comunication_opt_in 
				+", home_country=" + home_country + "]";
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getPersona_identifier() {
		return persona_identifier;
	}

	public void setPersona_identifier(String persona_identifier) {
		this.persona_identifier = persona_identifier;
	}

	public String getIdentity_unique_identifier() {
		return identity_unique_identifier;
	}

	public void setIdentity_unique_identifier(String identity_unique_identifier) {
		this.identity_unique_identifier = identity_unique_identifier;
	}

	public String getComunication_opt_in() {
		return comunication_opt_in;
	}

	public void setComunication_opt_in(String comunication_opt_in) {
		this.comunication_opt_in = comunication_opt_in;
	}

	public String getHome_country() {
		return home_country;
	}

	public void setHome_country(String home_country) {
		this.home_country = home_country;
	}
	
	
}
