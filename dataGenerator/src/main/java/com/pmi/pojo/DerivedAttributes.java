package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author vikas.e.mishra
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class DerivedAttributes {

	public DerivedAttributes() {

	}
	
	private String derived_attribute_record_id;
	private String identity_unique_identifier;
	private long derived_attribute_time;
	private String derived_attribute_category;
	private String derived_attribute_code;
	private String derived_attribute_value;
	private String derived_attribute_home_country_code;
	private String derived_attribute_home_country_description;

	@JsonProperty("td:c360:operation")
	private String td_c360_operation;

	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;
	
	@Override
	public String toString() {
		return "DerivedAttributes [derived_attribute_record_id=" + derived_attribute_record_id
				+ ", identity_unique_identifier=" + identity_unique_identifier + ", derived_attribute_time="
				+ derived_attribute_time + ", derived_attribute_category=" + derived_attribute_category
				+ ", derived_attribute_code=" + derived_attribute_code + ", derived_attribute_value="
				+ derived_attribute_value + ", derived_attribute_home_country_code="
				+ derived_attribute_home_country_code + ", derived_attribute_home_country_description="
				+ derived_attribute_home_country_description + ", td_c360_operation=" + td_c360_operation
				+ ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis + ", recordConsistencyTime="
				+ recordConsistencyTime + "]";
	}

	public String getDerived_attribute_record_id() {
		return derived_attribute_record_id;
	}

	public void setDerived_attribute_record_id(String derived_attribute_record_id) {
		this.derived_attribute_record_id = derived_attribute_record_id;
	}

	public String getIdentity_unique_identifier() {
		return identity_unique_identifier;
	}

	public void setIdentity_unique_identifier(String identity_unique_identifier) {
		this.identity_unique_identifier = identity_unique_identifier;
	}

	public long getDerived_attribute_time() {
		return derived_attribute_time;
	}

	public void setDerived_attribute_time(long derived_attribute_time) {
		this.derived_attribute_time = derived_attribute_time;
	}

	public String getDerived_attribute_category() {
		return derived_attribute_category;
	}

	public void setDerived_attribute_category(String derived_attribute_category) {
		this.derived_attribute_category = derived_attribute_category;
	}

	public String getDerived_attribute_code() {
		return derived_attribute_code;
	}

	public void setDerived_attribute_code(String derived_attribute_code) {
		this.derived_attribute_code = derived_attribute_code;
	}

	public String getDerived_attribute_value() {
		return derived_attribute_value;
	}

	public void setDerived_attribute_value(String derived_attribute_value) {
		this.derived_attribute_value = derived_attribute_value;
	}

	public String getDerived_attribute_home_country_code() {
		return derived_attribute_home_country_code;
	}

	public void setDerived_attribute_home_country_code(String derived_attribute_home_country_code) {
		this.derived_attribute_home_country_code = derived_attribute_home_country_code;
	}

	public String getDerived_attribute_home_country_description() {
		return derived_attribute_home_country_description;
	}

	public void setDerived_attribute_home_country_description(String derived_attribute_home_country_description) {
		this.derived_attribute_home_country_description = derived_attribute_home_country_description;
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
	