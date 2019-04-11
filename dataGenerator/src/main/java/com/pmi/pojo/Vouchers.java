package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vouchers {

	public Vouchers() {

	}

	private String voucher_code;// primary Key for database "db_l0_adl"
	private String identity_unique_identifier;
	private String country_of_issuing_code;
	private String country_of_issuing_description;
	private long valid_from;
	private long valid_to;
	private String Status_code;
	private String Status_description;
	private String promotion_identifier;
	private String promotion_name;
	private String voucher_description;

	@JsonProperty("td:c360:operation")
	private String td_c360_operation;
	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;

	@Override
	public String toString() {
		return "Vouchers [voucher_code=" + voucher_code + ", identity_unique_identifier=" + identity_unique_identifier
				+ ", country_of_issuing_code=" + country_of_issuing_code + ", country_of_issuing_description="
				+ country_of_issuing_description + ", valid_from=" + valid_from + ", valid_to=" + valid_to
				+ ", Status_code=" + Status_code + ", Status_description=" + Status_description
				+ ", promotion_identifier=" + promotion_identifier + ", promotion_name=" + promotion_name
				+ ", voucher_description=" + voucher_description + ", td_c360_operation=" + td_c360_operation
				+ ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis + ", recordConsistencyTime="
				+ recordConsistencyTime + "]";
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

	public String getCountry_of_issuing_code() {
		return country_of_issuing_code;
	}

	public void setCountry_of_issuing_code(String country_of_issuing_code) {
		this.country_of_issuing_code = country_of_issuing_code;
	}

	public String getCountry_of_issuing_description() {
		return country_of_issuing_description;
	}

	public void setCountry_of_issuing_description(String country_of_issuing_description) {
		this.country_of_issuing_description = country_of_issuing_description;
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

	public String getStatus_code() {
		return Status_code;
	}

	public void setStatus_code(String status_code) {
		Status_code = status_code;
	}

	public String getStatus_description() {
		return Status_description;
	}

	public void setStatus_description(String status_description) {
		Status_description = status_description;
	}

	public String getPromotion_identifier() {
		return promotion_identifier;
	}

	public void setPromotion_identifier(String promotion_identifier) {
		this.promotion_identifier = promotion_identifier;
	}

	public String getPromotion_name() {
		return promotion_name;
	}

	public void setPromotion_name(String promotion_name) {
		this.promotion_name = promotion_name;
	}

	public String getVoucher_description() {
		return voucher_description;
	}

	public void setVoucher_description(String voucher_description) {
		this.voucher_description = voucher_description;
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