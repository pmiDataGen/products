package com.pmi.pojo;

import java.util.List;

/**
 * @author boja.p.ramalingam
 *
 */

public class Questions {

	public Questions() {
	}

	private String question_number;
	private String question_asked;
	private List<Answers> answers;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * Carefully override toString() in below format only. Required for proper
	 * writing and reading from CSV
	 */
	@Override
	public String toString() {
		return "question_number=" + question_number + ", question_asked=" + question_asked + ", " + answers + " |";
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

	public List<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}
}