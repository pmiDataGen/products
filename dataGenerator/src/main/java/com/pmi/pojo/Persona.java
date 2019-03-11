package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author vikas.e.mishra
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Persona {

	public Persona() {

	}

	private String persona_id;// To be changed to "persona_identifier"
	private String last_name;
	private String first_name;
	private String gender;
	private String home_country;
	private String is_deleted;
	private String blocked_flag;
	private String consumer_type;
	private long date_of_birth;
	private int age;
	private String age_group;

	private String td_c360_operation;
	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;

	@Override
	public String toString() {
		return "Persona [persona_id=" + persona_id + ", last_name=" + last_name + ", first_name=" + first_name
				+ ", gender=" + gender + ", home_country=" + home_country + ", is_deleted=" + is_deleted
				+ ", blocked_flag=" + blocked_flag + ", consumer_type=" + consumer_type + ", date_of_birth="
				+ date_of_birth + ", age=" + age + ", age_group=" + age_group + ", td_c360_operation="
				+ td_c360_operation + ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis
				+ ", recordConsistencyTime=" + recordConsistencyTime + "]";
	}

	public String getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(String persona_id) {
		this.persona_id = persona_id;
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

	public long getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(long date_of_birth) {
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

	/*
	 * private boolean online_access_flag; // online access flag private String
	 * last_case_status_code; private int frequency_score; private float
	 * cnt_orders_l12m; // private String time; //No need to pass the values private
	 * String date_of_birth; private float nb_cases_close_3m; private float
	 * nb_of_devices_replaced; private float value_score; private float
	 * cnt_orders_l6m; private String persona_id; private float nb_cases_open_6m;
	 * private float nb_order; private float number_of_heet; private String segment;
	 * private float nb_cases_open_2m; private float nb_of_holders; private String
	 * first_login_date; private String system_last_update; // system last update
	 * private float revenue_l6m; private boolean blocked_flag; private String
	 * last_update_date; private String primary_log_in; // primary log in private
	 * float cnt_orders; private String first_name; private float revenue_l12m;
	 * private String latest_version_of_device; private String
	 * last_case_category_name; private float nb_cases_open_3m; private float
	 * number_of_accessories; private float nb_cases_close_1m; private int
	 * recency_score; private float last_Activity_since_months; private float
	 * nb_cases_close_12m; private String consumer_type; private String
	 * last_case_start_date; private float nb_active_chargers; // private String
	 * td_c360_operation_time; // "td:c360:operation_time": //
	 * "1550064529348.0",//No need to pass the values private float revenue_ytd;
	 * private float nb_of_devices; private float
	 * total_spending_per_month_in_average; private float last_order_date; private
	 * float nb_order_average_per_month; private float lifetime_revenue; private
	 * float nb_cases_open; private float second_order_difference_days; private
	 * float last_Activity_since_days; private String last_login_date; private int
	 * age; private float nb_cases_close_2m; private float
	 * registration_first_order_difference_day; private String limited_edition;
	 * private float nb_cases_open_12m; private float first_purchase_date; private
	 * String gender; private float nb_cases_close_6m; private float cnt_orders_l3m;
	 * private String last_name; private String home_country; private float
	 * nb_cases_close; private float revenue_l3m; private float nb_cases_open_1m;
	 * private String age_group; private boolean is_deleted;
	 * 
	 * // Adding Attribute from Postman results private float registration_date;
	 * private String name; private String full_name; private String phone; private
	 * String email;
	 */

}
