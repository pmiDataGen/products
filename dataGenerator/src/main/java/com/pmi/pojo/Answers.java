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
	private String answer_value;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * Override toString() as below. Necessary, as same format will be used in
	 * writing Answers object to Questions Object and then to Surveys Object.
	 * Finally Survey object will written to CSV file.
	 */
	@Override
	public String toString() {
		return "answer_number=" + answer_number + ", answer_label=" + answer_label + ", answer_value=" + answer_value;
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

	public String getAnswer_value() {
		return answer_value;
	}

	public void setAnswer_value(String answer_value) {
		this.answer_value = answer_value;
	}

}