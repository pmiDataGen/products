package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

	public Address() {
		
	}
	
	//private String address_identifier;
	//private String persona_identifier;
	//private String identity_unique_identifier;
	private String country;
	private String postal_code;
	private String address_type;
	private String additional_address_line_1;
	private String additional_address_line_2;
	private String additional_address_line_3;
	private String additional_address_line_4;
	private String additional_address_line_5;
	private Boolean preferred_shipping;
	private Boolean preferred_billing;
	private String communication_opt_in;
	//private String home_country;
	@Override
	public String toString() {
		return "Address [country=" + country + ", postal_code=" + postal_code + ", address_type=" + address_type
				+ ", additional_address_line_1=" + additional_address_line_1 + ", additional_address_line_2="
				+ additional_address_line_2 + ", additional_address_line_3=" + additional_address_line_3
				+ ", additional_address_line_4=" + additional_address_line_4 + ", additional_address_line_5="
				+ additional_address_line_5 + ", preferred_shipping=" + preferred_shipping + ", preferred_billing="
				+ preferred_billing + ", communication_opt_in=" + communication_opt_in + "]";
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getAddress_type() {
		return address_type;
	}
	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}
	public String getAdditional_address_line_1() {
		return additional_address_line_1;
	}
	public void setAdditional_address_line_1(String additional_address_line_1) {
		this.additional_address_line_1 = additional_address_line_1;
	}
	public String getAdditional_address_line_2() {
		return additional_address_line_2;
	}
	public void setAdditional_address_line_2(String additional_address_line_2) {
		this.additional_address_line_2 = additional_address_line_2;
	}
	public String getAdditional_address_line_3() {
		return additional_address_line_3;
	}
	public void setAdditional_address_line_3(String additional_address_line_3) {
		this.additional_address_line_3 = additional_address_line_3;
	}
	public String getAdditional_address_line_4() {
		return additional_address_line_4;
	}
	public void setAdditional_address_line_4(String additional_address_line_4) {
		this.additional_address_line_4 = additional_address_line_4;
	}
	public String getAdditional_address_line_5() {
		return additional_address_line_5;
	}
	public void setAdditional_address_line_5(String additional_address_line_5) {
		this.additional_address_line_5 = additional_address_line_5;
	}
	public Boolean getPreferred_shipping() {
		return preferred_shipping;
	}
	public void setPreferred_shipping(Boolean preferred_shipping) {
		this.preferred_shipping = preferred_shipping;
	}
	public Boolean getPreferred_billing() {
		return preferred_billing;
	}
	public void setPreferred_billing(Boolean preferred_billing) {
		this.preferred_billing = preferred_billing;
	}
	public String getCommunication_opt_in() {
		return communication_opt_in;
	}
	public void setCommunication_opt_in(String communication_opt_in) {
		this.communication_opt_in = communication_opt_in;
	}
	
	

	
}