package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author vikas.e.mishra
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Segmentations {

	public Segmentations() {

	}
	
	private String segmentation_record_id;
	private String identity_unique_identifier;
	private long segmentation_date;
	private String segment_category_code;
	private String segment_category_description;
	private String segment_type_code;
	private String segment_type_description;
	private String segment_value_code;
	private String segment_value_description;


	@JsonProperty("td:c360:operation")
	private String td_c360_operation;

	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;
	
	@Override
	public String toString() {
		return "Segmentations [segmentation_record_id=" + segmentation_record_id + ", identity_unique_identifier="
				+ identity_unique_identifier + ", segmentation_date=" + segmentation_date + ", segment_category_code="
				+ segment_category_code + ", segment_category_description=" + segment_category_description
				+ ", segment_type_code=" + segment_type_code + ", segment_type_description=" + segment_type_description
				+ ", segment_value_code=" + segment_value_code + ", segment_value_description="
				+ segment_value_description + ", td_c360_operation=" + td_c360_operation + ", apiCallTimeTakenInMillis="
				+ apiCallTimeTakenInMillis + ", recordConsistencyTime=" + recordConsistencyTime + "]";
	}

	public String getSegmentation_record_id() {
		return segmentation_record_id;
	}

	public void setSegmentation_record_id(String segmentation_record_id) {
		this.segmentation_record_id = segmentation_record_id;
	}

	public String getIdentity_unique_identifier() {
		return identity_unique_identifier;
	}

	public void setIdentity_unique_identifier(String identity_unique_identifier) {
		this.identity_unique_identifier = identity_unique_identifier;
	}

	public long getSegmentation_date() {
		return segmentation_date;
	}

	public void setSegmentation_date(long segmentation_date) {
		this.segmentation_date = segmentation_date;
	}

	public String getSegment_category_code() {
		return segment_category_code;
	}

	public void setSegment_category_code(String segment_category_code) {
		this.segment_category_code = segment_category_code;
	}

	public String getSegment_category_description() {
		return segment_category_description;
	}

	public void setSegment_category_description(String segment_category_description) {
		this.segment_category_description = segment_category_description;
	}

	public String getSegment_type_code() {
		return segment_type_code;
	}

	public void setSegment_type_code(String segment_type_code) {
		this.segment_type_code = segment_type_code;
	}

	public String getSegment_type_description() {
		return segment_type_description;
	}

	public void setSegment_type_description(String segment_type_description) {
		this.segment_type_description = segment_type_description;
	}

	public String getSegment_value_code() {
		return segment_value_code;
	}

	public void setSegment_value_code(String segment_value_code) {
		this.segment_value_code = segment_value_code;
	}

	public String getSegment_value_description() {
		return segment_value_description;
	}

	public void setSegment_value_description(String segment_value_description) {
		this.segment_value_description = segment_value_description;
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