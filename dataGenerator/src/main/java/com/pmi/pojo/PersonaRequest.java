package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonaRequest {

	
    private String td_c360_operation;
    private String persona_id;
    private String last_name;
    private String first_name;
    private String gender;
    private String home_country;
    
    
	public String getTd_c360_operation() {
		return td_c360_operation;
	}
	public void setTd_c360_operation(String td_c360_operation) {
		this.td_c360_operation = td_c360_operation;
	}
	public String getPersona_id() {
		return persona_id;
	}
	public void setPersona_id(String persona_id) {
		this.persona_id = persona_id;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
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
	@Override
	public String toString() {
		return "PersonaRequest [td_c360_operation=" + td_c360_operation + ", persona_id=" + persona_id + ", last_name="
				+ last_name + ", first_name=" + first_name + ", gender=" + gender + ", home_country=" + home_country
				+ "]";
	}
}
