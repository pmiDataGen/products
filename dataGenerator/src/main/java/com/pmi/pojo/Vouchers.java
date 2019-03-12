package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author  boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vouchers {

	public Vouchers() {

	}
	
	private String voucher_code;
	private String identity_unique_identifier;
	private String persona_identifier;
	private String type;
	private String name;
	private String country_of_issuing;
	private long valid_from;
	private long valid_to;
	private int value;
	private String corresponding_voucher_code;
	private String Status;
	
	@JsonProperty("td:c360:operation")
	private String td_c360_operation;
	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;
	
	@Override
	public String toString() {
		return "Vouchers [voucher_code=" + voucher_code + ", identity_unique_identifier=" + identity_unique_identifier
				+ ", persona_identifier=" + persona_identifier + ", type=" + type + ", name=" + name
				+ ", country_of_issuing=" + country_of_issuing + ", valid_from=" + valid_from + ", valid_to=" + valid_to
				+ ", value=" + value + ", corresponding_voucher_code=" + corresponding_voucher_code + ", Status="
				+ Status + ", td_c360_operation=" + td_c360_operation + ", apiCallTimeTakenInMillis="
				+ apiCallTimeTakenInMillis + ", recordConsistencyTime=" + recordConsistencyTime + "]";
	}

	public String getVoucher_code() {
		return voucher_code;
	}

	public void setVoucher_code(String voucher_code) {
		this.voucher_code = voucher_code;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry_of_issuing() {
		return country_of_issuing;
	}

	public void setCountry_of_issuing(String country_of_issuing) {
		this.country_of_issuing = country_of_issuing;
	}

	public long getValid_from() {
		return valid_from;
	}

	public void setValid_from(long valid_from) {
		this.valid_from = valid_from;
	}

	public long getValid_to() {
		return valid_to;
	}

	public void setValid_to(long valid_to) {
		this.valid_to = valid_to;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getCorresponding_voucher_code() {
		return corresponding_voucher_code;
	}

	public void setCorresponding_voucher_code(String corresponding_voucher_code) {
		this.corresponding_voucher_code = corresponding_voucher_code;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
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