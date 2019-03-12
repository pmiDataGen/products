package com.pmi.pojo;

/**
 * @author boja.p.ramalingam
 *
 */

public class Answers {

	public Answers() {
		
		
	}

	private String answer_number;
	private String answer_label;
	private String aswer_value;
	
	@Override
	public String toString() {
		return "answer_number=" + answer_number + ", answer_label=" + answer_label + ", aswer_value="
				+ aswer_value + " |";
	}

	public String getAnswer_number() {
		return answer_number;
	}

	public void setAnswer_number(String answer_number) {
		this.answer_number = answer_number;
	}

	public String getAnswer_label() {
		return answer_label;
	}

	public void setAnswer_label(String answer_label) {
		this.answer_label = answer_label;
	}

	public String getAswer_value() {
		return aswer_value;
	}

	public void setAswer_value(String aswer_value) {
		this.aswer_value = aswer_value;
	}
	
	
	
}