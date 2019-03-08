package com.pmi.pojo;

public class Coaches {

	public Coaches() {

	}

	private String coach_id;

	private String coach_name;

	@Override
	public String toString() {
		return "coach_id=" + coach_id + ", coach_name=" + coach_name + " |";
	}

	public String getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(String coach_id) {
		this.coach_id = coach_id;
	}

	public String getCoach_name() {
		return coach_name;
	}

	public void setCoach_name(String coach_name) {
		this.coach_name = coach_name;
	}

}
