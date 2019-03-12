package com.pmi.pojo;

/**
 * @author boja.p.ramalingam
 *
 */

public class Questions {

	public Questions() {
		
		
	}

	private String question_number;
	private String question_asked;
	
	@Override
	public String toString() {
		return "question_number=" + question_number + ", question_asked=" + question_asked + " |";
	}

	public String getQuestion_number() {
		return question_number;
	}

	public void setQuestion_number(String question_number) {
		this.question_number = question_number;
	}

	public String getQuestion_asked() {
		return question_asked;
	}

	public void setQuestion_asked(String question_asked) {
		this.question_asked = question_asked;
	}

	
	}