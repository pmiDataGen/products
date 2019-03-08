
package com.pmi.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import com.pmi.util.TextToAddress;
import com.pmi.util.TextToCoaches;
import com.pmi.util.TextToTermsAndConditions;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Identities {

	public Identities() {

	}

	@CsvBindByName
	private String td_c360_operation;
	@CsvBindByName
	private String identity_id; // later change to "identity_unique_identifier"
	@CsvBindByName
	private String persona_identifier;
	@CsvBindByName
	private String login_name;
	@CsvBindByName
	private String last_name;
	@CsvBindByName
	private String first_name;
	@CsvBindByName
	private String gender;
	@CsvBindByName
	private String home_country;
	@CsvBindByName
	private String is_deleted;
	@CsvBindByName
	private String reason_of_deletion;
	@CsvBindByName
	private String reason_of_customer_lost;
	@CsvBindByName
	private String blocked_flag;
	@CsvBindByName
	private String consumer_type;
	@CsvBindByName
	private String date_of_birth;// long
	@CsvBindByName
	private int age;// int
	@CsvBindByName
	private String age_group;
	@CsvBindByName
	private String email_address;
	@CsvBindByName
	private String email_comunication_opt_in;
	@CsvBindByName
	private String phone_country_code_number;
	@CsvBindByName
	private String phone_number;
	@CsvBindByName
	private String phone_comunication_opt_in;
	@CsvBindByName
	private String privacy_policy_acceptance;
	@CsvBindByName
	private String loyalty_tier;
	@CsvBindByName
	private int loyalty_points;
	@CsvBindByName
	private int loyalty_erned_points;
	@CsvBindByName

	@CsvBindAndSplitByName(elementType = Address.class, splitOn = "\\|", converter = TextToAddress.class)
	private List<Address> addresses;

	@CsvBindAndSplitByName(elementType = Coaches.class, splitOn = "\\|", converter = TextToCoaches.class)
	private List<Coaches> coaches;

	@CsvBindAndSplitByName(elementType = TermsAndConditions.class, splitOn = "\\|", converter = TextToTermsAndConditions.class)
	private List<TermsAndConditions> termsAndConditions;

	@CsvBindByName
	private String apiCallTimeTakenInMillis;

	@CsvBindByName
	private String recordConsistencyTime;

	@Override
	public String toString() {
		return "Identities [td_c360_operation=" + td_c360_operation + ", identity_unique_identifier=" + identity_id
				+ ", persona_identifier=" + persona_identifier + ", login_name=" + login_name + ", last_name="
				+ last_name + ", first_name=" + first_name + ", gender=" + gender + ", home_country=" + home_country
				+ ", is_deleted=" + is_deleted + ", reason_of_deletion=" + reason_of_deletion
				+ ", reason_of_customer_lost=" + reason_of_customer_lost + ", blocked_flag=" + blocked_flag
				+ ", consumer_type=" + consumer_type + ", date_of_birth=" + date_of_birth + ", age=" + age
				+ ", age_group=" + age_group + ", email_address=" + email_address + ", email_comunication_opt_in="
				+ email_comunication_opt_in + ", phone_country_code_number=" + phone_country_code_number
				+ ", phone_number=" + phone_number + ", phone_comunication_opt_in=" + phone_comunication_opt_in
				+ ", privacy_policy_acceptance=" + privacy_policy_acceptance + ", loyalty_tier=" + loyalty_tier
				+ ", loyalty_points=" + loyalty_points + ", loyalty_erned_points=" + loyalty_erned_points + ", address="
				+ addresses + ", coaches=" + coaches + ", termsAndConditions=" + termsAndConditions
				+ ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis + ", recordConsistencyTime="
				+ recordConsistencyTime + "]";
	}

	public String getTd_c360_operation() {
		return td_c360_operation;
	}

	public void setTd_c360_operation(String td_c360_operation) {
		this.td_c360_operation = td_c360_operation;
	}

	public String getIdentity_id() {
		return identity_id;
	}

	public void setIdentity_id(String identity_id) {
		this.identity_id = identity_id;
	}

	public String getPersona_identifier() {
		return persona_identifier;
	}

	public void setPersona_identifier(String persona_identifier) {
		this.persona_identifier = persona_identifier;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHome_country() {
		return home_country;
	}

	public void setHome_country(String home_country) {
		this.home_country = home_country;
	}

	public String getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}

	public String getReason_of_deletion() {
		return reason_of_deletion;
	}

	public void setReason_of_deletion(String reason_of_deletion) {
		this.reason_of_deletion = reason_of_deletion;
	}

	public String getReason_of_customer_lost() {
		return reason_of_customer_lost;
	}

	public void setReason_of_customer_lost(String reason_of_customer_lost) {
		this.reason_of_customer_lost = reason_of_customer_lost;
	}

	public String getBlocked_flag() {
		return blocked_flag;
	}

	public void setBlocked_flag(String blocked_flag) {
		this.blocked_flag = blocked_flag;
	}

	public String getConsumer_type() {
		return consumer_type;
	}

	public void setConsumer_type(String consumer_type) {
		this.consumer_type = consumer_type;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAge_group() {
		return age_group;
	}

	public void setAge_group(String age_group) {
		this.age_group = age_group;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getEmail_comunication_opt_in() {
		return email_comunication_opt_in;
	}

	public void setEmail_comunication_opt_in(String email_comunication_opt_in) {
		this.email_comunication_opt_in = email_comunication_opt_in;
	}

	public String getPhone_country_code_number() {
		return phone_country_code_number;
	}

	public void setPhone_country_code_number(String phone_country_code_number) {
		this.phone_country_code_number = phone_country_code_number;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPhone_comunication_opt_in() {
		return phone_comunication_opt_in;
	}

	public void setPhone_comunication_opt_in(String phone_comunication_opt_in) {
		this.phone_comunication_opt_in = phone_comunication_opt_in;
	}

	public String getPrivacy_policy_acceptance() {
		return privacy_policy_acceptance;
	}

	public void setPrivacy_policy_acceptance(String privacy_policy_acceptance) {
		this.privacy_policy_acceptance = privacy_policy_acceptance;
	}

	public String getLoyalty_tier() {
		return loyalty_tier;
	}

	public void setLoyalty_tier(String loyalty_tier) {
		this.loyalty_tier = loyalty_tier;
	}

	public int getLoyalty_points() {
		return loyalty_points;
	}

	public void setLoyalty_points(int loyalty_points) {
		this.loyalty_points = loyalty_points;
	}

	public int getLoyalty_erned_points() {
		return loyalty_erned_points;
	}

	public void setLoyalty_erned_points(int loyalty_erned_points) {
		this.loyalty_erned_points = loyalty_erned_points;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Coaches> getCoaches() {
		return coaches;
	}

	public void setCoaches(List<Coaches> coaches) {
		this.coaches = coaches;
	}

	public List<TermsAndConditions> getTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(List<TermsAndConditions> termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
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

	/*
	 * @CsvBindByName private String identity_id;
	 * 
	 * @CsvBindByName private String persona_id;
	 * 
	 * @CsvBindByName private String preferred_language;
	 * 
	 * @CsvBindByName private String segment;
	 * 
	 * @CsvBindByName private String last_login_date;
	 * 
	 * @CsvBindByName private String registration_date; // private String time; //
	 * "time": "1548928418229"//No need to pass the values // private String
	 * td_c360_operation_time; // "td:c360:operation_time": // "1548928418229.0"//No
	 * need to pass the values
	 * 
	 * @CsvBindByName private String nick_name;
	 * 
	 * @CsvBindByName private String full_name;
	 * 
	 * @CsvBindByName private String email;
	 * 
	 * @CsvBindByName private String registration_source_app;
	 * 
	 * @CsvBindByName private String registration_country;
	 * 
	 * @CsvBindByName private String registration_referal_identifier;
	 * 
	 * @CsvBindByName private String apiCallTimeTakenInMillis;
	 * 
	 * @CsvBindByName private String recordConsistencyTime;
	 */

}