package com.pmi.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import com.pmi.util.TextToQuestions;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Surveys {

	public Surveys() {

	}

	@CsvBindByName
	private String survey_id;
	@CsvBindByName
	private String survey_template_id;
	@CsvBindByName
	private String identity_unique_identifier;
	@CsvBindByName
	private String persona_identifier;
	@CsvBindAndSplitByName(elementType = Questions.class, splitOn = "\\|", converter = TextToQuestions.class)
	private List<Questions> questions;

	@CsvBindByName
	private long date;
	@CsvBindByName
	private String apiCallTimeTakenInMillis;
	@CsvBindByName
	private String recordConsistencyTime;
	@JsonProperty("td:c360:operation")
	@CsvBindByName
	private String td_c360_operation;

	@Override
	public String toString() {
		return "Surveys [survey_id=" + survey_id + ", survey_template_id=" + survey_template_id
				+ ", identity_unique_identifier=" + identity_unique_identifier + ", persona_identifier="
				+ persona_identifier + ", questions=" + questions + ", date=" + date + ", apiCallTimeTakenInMillis="
				+ apiCallTimeTakenInMillis + ", recordConsistencyTime=" + recordConsistencyTime + ", td_c360_operation="
				+ td_c360_operation + "]";
	}

	public String getSurvey_id() {
		return survey_id;
	}

	public void setSurvey_id(String survey_id) {
		this.survey_id = survey_id;
	}

	public String getSurvey_template_id() {
		return survey_template_id;
	}

	public void setSurvey_template_id(String survey_template_id) {
		this.survey_template_id = survey_template_id;
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

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
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

	public String getTd_c360_operation() {
		return td_c360_operation;
	}

	public void setTd_c360_operation(String td_c360_operation) {
		this.td_c360_operation = td_c360_operation;
	}

}