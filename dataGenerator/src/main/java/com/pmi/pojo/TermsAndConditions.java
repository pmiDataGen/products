package com.pmi.pojo;

public class TermsAndConditions {

	private String terms_and_conditions_version;
	private String terms_and_conditions_acceptance;

	@Override
	public String toString() {
		return "terms_and_conditions_version=" + terms_and_conditions_version + ", terms_and_conditions_acceptance="
				+ terms_and_conditions_acceptance + " |";
	}

	public String getTerms_and_conditions_version() {
		return terms_and_conditions_version;
	}

	public void setTerms_and_conditions_version(String terms_and_conditions_version) {
		this.terms_and_conditions_version = terms_and_conditions_version;
	}

	public String getTerms_and_conditions_acceptance() {
		return terms_and_conditions_acceptance;
	}

	public void setTerms_and_conditions_acceptance(String terms_and_conditions_acceptance) {
		this.terms_and_conditions_acceptance = terms_and_conditions_acceptance;
	}

}
