package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author vikas.e.mishra
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Persona {

	public Persona() {
		System.out.println("This is D.C Persona Class");
	}

	private boolean online_access_flag; // online access flag
	private String last_case_status_code;
	private int frequency_score;
	private float cnt_orders_l12m;
	//private String time;	//No need to pass the values
	private String date_of_birth;
	private float nb_cases_close_3m;
	private float nb_of_devices_replaced;
	private float value_score;
	private float cnt_orders_l6m;
	private String persona_id;
	private float nb_cases_open_6m;
	private float nb_order;
	private float number_of_heet;
	private String segment;
	private float nb_cases_open_2m;
	private float nb_of_holders;
	private String first_login_date;
	private String system_last_update; // system last update
	private float revenue_l6m;
	private boolean blocked_flag;
	private String last_update_date;
	private String primary_log_in; // primary log in
	private float cnt_orders;
	private String first_name;
	private float revenue_l12m;
	private String latest_version_of_device;
	private String last_case_category_name;
	private float nb_cases_open_3m;
	private float number_of_accessories;
	private float nb_cases_close_1m;
	private int recency_score;
	private float last_Activity_since_months;
	private float nb_cases_close_12m;
	private String consumer_type;
	private String last_case_start_date;
	private float nb_active_chargers;
	//private String td_c360_operation_time; // "td:c360:operation_time": "1550064529348.0",//No need to pass the values
	private float revenue_ytd;
	private float nb_of_devices;
	private float total_spending_per_month_in_average;
	private float last_order_date;
	private float nb_order_average_per_month;
	private float lifetime_revenue;
	private float nb_cases_open;
	private float second_order_difference_days;
	private float last_Activity_since_days;
	private String last_login_date;
	private int age;
	private float nb_cases_close_2m;
	private float registration_first_order_difference_day;
	private String limited_edition;
	private float nb_cases_open_12m;
	private float first_purchase_date;
	private String gender;
	private float nb_cases_close_6m;
	private float cnt_orders_l3m;
	private String last_name;
	private String home_country;
	private float nb_cases_close;
	private float revenue_l3m;
	private float nb_cases_open_1m;
	private String age_group;
	private boolean is_deleted;

	//Adding Attribute from Postman results
	private float registration_date;
	private String name;
	private String full_name;
	private String phone;
	private String email;
	
	@Override
	public String toString() {
		return "Persona [online_access_flag=" + online_access_flag + ", last_case_status_code=" + last_case_status_code
				+ ", frequency_score=" + frequency_score + ", cnt_orders_l12m=" + cnt_orders_l12m 
				+ ", date_of_birth=" + date_of_birth + ", nb_cases_close_3m=" + nb_cases_close_3m
				+ ", nb_of_devices_replaced=" + nb_of_devices_replaced + ", value_score=" + value_score
				+ ", cnt_orders_l6m=" + cnt_orders_l6m + ", persona_id=" + persona_id + ", nb_cases_open_6m="
				+ nb_cases_open_6m + ", nb_order=" + nb_order + ", number_of_heet=" + number_of_heet + ", segment="
				+ segment + ", nb_cases_open_2m=" + nb_cases_open_2m + ", nb_of_holders=" + nb_of_holders
				+ ", first_login_date=" + first_login_date + ", system_last_update=" + system_last_update
				+ ", revenue_l6m=" + revenue_l6m + ", blocked_flag=" + blocked_flag + ", last_update_date="
				+ last_update_date + ", primary_log_in=" + primary_log_in + ", cnt_orders=" + cnt_orders
				+ ", first_name=" + first_name + ", revenue_l12m=" + revenue_l12m + ", latest_version_of_device="
				+ latest_version_of_device + ", last_case_category_name=" + last_case_category_name
				+ ", nb_cases_open_3m=" + nb_cases_open_3m + ", number_of_accessories=" + number_of_accessories
				+ ", nb_cases_close_1m=" + nb_cases_close_1m + ", recency_score=" + recency_score
				+ ", last_Activity_since_months=" + last_Activity_since_months + ", nb_cases_close_12m="
				+ nb_cases_close_12m + ", consumer_type=" + consumer_type + ", last_case_start_date="
				+ last_case_start_date + ", nb_active_chargers=" + nb_active_chargers  + ", revenue_ytd=" + revenue_ytd + ", nb_of_devices=" + nb_of_devices
				+ ", total_spending_per_month_in_average=" + total_spending_per_month_in_average + ", last_order_date="
				+ last_order_date + ", nb_order_average_per_month=" + nb_order_average_per_month + ", lifetime_revenue="
				+ lifetime_revenue + ", nb_cases_open=" + nb_cases_open + ", second_order_difference_days="
				+ second_order_difference_days + ", last_Activity_since_days=" + last_Activity_since_days
				+ ", last_login_date=" + last_login_date + ", age=" + age + ", nb_cases_close_2m=" + nb_cases_close_2m
				+ ", registration_first_order_difference_day=" + registration_first_order_difference_day
				+ ", limited_edition=" + limited_edition + ", nb_cases_open_12m=" + nb_cases_open_12m
				+ ", first_purchase_date=" + first_purchase_date + ", gender=" + gender + ", nb_cases_close_6m="
				+ nb_cases_close_6m + ", cnt_orders_l3m=" + cnt_orders_l3m + ", last_name=" + last_name
				+ ", home_country=" + home_country + ", nb_cases_close=" + nb_cases_close + ", revenue_l3m="
				+ revenue_l3m + ", nb_cases_open_1m=" + nb_cases_open_1m + ", age_group=" + age_group + ", is_deleted="
				+ is_deleted + ", registration_date=" + registration_date + ", name=" + name + ", full_name="
				+ full_name + ", phone=" + phone + ", email=" + email + "]";
	}

	public boolean isOnline_access_flag() {
		return online_access_flag;
	}

	public void setOnline_access_flag(boolean online_access_flag) {
		this.online_access_flag = online_access_flag;
	}

	public String getLast_case_status_code() {
		return last_case_status_code;
	}

	public void setLast_case_status_code(String last_case_status_code) {
		this.last_case_status_code = last_case_status_code;
	}

	public int getFrequency_score() {
		return frequency_score;
	}

	public void setFrequency_score(int frequency_score) {
		this.frequency_score = frequency_score;
	}

	public float getCnt_orders_l12m() {
		return cnt_orders_l12m;
	}

	public void setCnt_orders_l12m(float cnt_orders_l12m) {
		this.cnt_orders_l12m = cnt_orders_l12m;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public float getNb_cases_close_3m() {
		return nb_cases_close_3m;
	}

	public void setNb_cases_close_3m(float nb_cases_close_3m) {
		this.nb_cases_close_3m = nb_cases_close_3m;
	}

	public float getNb_of_devices_replaced() {
		return nb_of_devices_replaced;
	}

	public void setNb_of_devices_replaced(float nb_of_devices_replaced) {
		this.nb_of_devices_replaced = nb_of_devices_replaced;
	}

	public float getValue_score() {
		return value_score;
	}

	public void setValue_score(float value_score) {
		this.value_score = value_score;
	}

	public float getCnt_orders_l6m() {
		return cnt_orders_l6m;
	}

	public void setCnt_orders_l6m(float cnt_orders_l6m) {
		this.cnt_orders_l6m = cnt_orders_l6m;
	}

	public String getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(String persona_id) {
		this.persona_id = persona_id;
	}

	public float getNb_cases_open_6m() {
		return nb_cases_open_6m;
	}

	public void setNb_cases_open_6m(float nb_cases_open_6m) {
		this.nb_cases_open_6m = nb_cases_open_6m;
	}

	public float getNb_order() {
		return nb_order;
	}

	public void setNb_order(float nb_order) {
		this.nb_order = nb_order;
	}

	public float getNumber_of_heet() {
		return number_of_heet;
	}

	public void setNumber_of_heet(float number_of_heet) {
		this.number_of_heet = number_of_heet;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public float getNb_cases_open_2m() {
		return nb_cases_open_2m;
	}

	public void setNb_cases_open_2m(float nb_cases_open_2m) {
		this.nb_cases_open_2m = nb_cases_open_2m;
	}

	public float getNb_of_holders() {
		return nb_of_holders;
	}

	public void setNb_of_holders(float nb_of_holders) {
		this.nb_of_holders = nb_of_holders;
	}

	public String getFirst_login_date() {
		return first_login_date;
	}

	public void setFirst_login_date(String first_login_date) {
		this.first_login_date = first_login_date;
	}

	public String getSystem_last_update() {
		return system_last_update;
	}

	public void setSystem_last_update(String system_last_update) {
		this.system_last_update = system_last_update;
	}

	public float getRevenue_l6m() {
		return revenue_l6m;
	}

	public void setRevenue_l6m(float revenue_l6m) {
		this.revenue_l6m = revenue_l6m;
	}

	public boolean isBlocked_flag() {
		return blocked_flag;
	}

	public void setBlocked_flag(boolean blocked_flag) {
		this.blocked_flag = blocked_flag;
	}

	public String getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(String last_update_date) {
		this.last_update_date = last_update_date;
	}

	public String getPrimary_log_in() {
		return primary_log_in;
	}

	public void setPrimary_log_in(String primary_log_in) {
		this.primary_log_in = primary_log_in;
	}

	public float getCnt_orders() {
		return cnt_orders;
	}

	public void setCnt_orders(float cnt_orders) {
		this.cnt_orders = cnt_orders;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public float getRevenue_l12m() {
		return revenue_l12m;
	}

	public void setRevenue_l12m(float revenue_l12m) {
		this.revenue_l12m = revenue_l12m;
	}

	public String getLatest_version_of_device() {
		return latest_version_of_device;
	}

	public void setLatest_version_of_device(String latest_version_of_device) {
		this.latest_version_of_device = latest_version_of_device;
	}

	public String getLast_case_category_name() {
		return last_case_category_name;
	}

	public void setLast_case_category_name(String last_case_category_name) {
		this.last_case_category_name = last_case_category_name;
	}

	public float getNb_cases_open_3m() {
		return nb_cases_open_3m;
	}

	public void setNb_cases_open_3m(float nb_cases_open_3m) {
		this.nb_cases_open_3m = nb_cases_open_3m;
	}

	public float getNumber_of_accessories() {
		return number_of_accessories;
	}

	public void setNumber_of_accessories(float number_of_accessories) {
		this.number_of_accessories = number_of_accessories;
	}

	public float getNb_cases_close_1m() {
		return nb_cases_close_1m;
	}

	public void setNb_cases_close_1m(float nb_cases_close_1m) {
		this.nb_cases_close_1m = nb_cases_close_1m;
	}

	public int getRecency_score() {
		return recency_score;
	}

	public void setRecency_score(int recency_score) {
		this.recency_score = recency_score;
	}

	public float getLast_Activity_since_months() {
		return last_Activity_since_months;
	}

	public void setLast_Activity_since_months(float last_Activity_since_months) {
		this.last_Activity_since_months = last_Activity_since_months;
	}

	public float getNb_cases_close_12m() {
		return nb_cases_close_12m;
	}

	public void setNb_cases_close_12m(float nb_cases_close_12m) {
		this.nb_cases_close_12m = nb_cases_close_12m;
	}

	public String getConsumer_type() {
		return consumer_type;
	}

	public void setConsumer_type(String consumer_type) {
		this.consumer_type = consumer_type;
	}

	public String getLast_case_start_date() {
		return last_case_start_date;
	}

	public void setLast_case_start_date(String last_case_start_date) {
		this.last_case_start_date = last_case_start_date;
	}

	public float getNb_active_chargers() {
		return nb_active_chargers;
	}

	public void setNb_active_chargers(float nb_active_chargers) {
		this.nb_active_chargers = nb_active_chargers;
	}

	public float getRevenue_ytd() {
		return revenue_ytd;
	}

	public void setRevenue_ytd(float revenue_ytd) {
		this.revenue_ytd = revenue_ytd;
	}

	public float getNb_of_devices() {
		return nb_of_devices;
	}

	public void setNb_of_devices(float nb_of_devices) {
		this.nb_of_devices = nb_of_devices;
	}

	public float getTotal_spending_per_month_in_average() {
		return total_spending_per_month_in_average;
	}

	public void setTotal_spending_per_month_in_average(float total_spending_per_month_in_average) {
		this.total_spending_per_month_in_average = total_spending_per_month_in_average;
	}

	public float getLast_order_date() {
		return last_order_date;
	}

	public void setLast_order_date(float last_order_date) {
		this.last_order_date = last_order_date;
	}

	public float getNb_order_average_per_month() {
		return nb_order_average_per_month;
	}

	public void setNb_order_average_per_month(float nb_order_average_per_month) {
		this.nb_order_average_per_month = nb_order_average_per_month;
	}

	public float getLifetime_revenue() {
		return lifetime_revenue;
	}

	public void setLifetime_revenue(float lifetime_revenue) {
		this.lifetime_revenue = lifetime_revenue;
	}

	public float getNb_cases_open() {
		return nb_cases_open;
	}

	public void setNb_cases_open(float nb_cases_open) {
		this.nb_cases_open = nb_cases_open;
	}

	public float getSecond_order_difference_days() {
		return second_order_difference_days;
	}

	public void setSecond_order_difference_days(float second_order_difference_days) {
		this.second_order_difference_days = second_order_difference_days;
	}

	public float getLast_Activity_since_days() {
		return last_Activity_since_days;
	}

	public void setLast_Activity_since_days(float last_Activity_since_days) {
		this.last_Activity_since_days = last_Activity_since_days;
	}

	public String getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(String last_login_date) {
		this.last_login_date = last_login_date;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getNb_cases_close_2m() {
		return nb_cases_close_2m;
	}

	public void setNb_cases_close_2m(float nb_cases_close_2m) {
		this.nb_cases_close_2m = nb_cases_close_2m;
	}

	public float getRegistration_first_order_difference_day() {
		return registration_first_order_difference_day;
	}

	public void setRegistration_first_order_difference_day(float registration_first_order_difference_day) {
		this.registration_first_order_difference_day = registration_first_order_difference_day;
	}

	public String getLimited_edition() {
		return limited_edition;
	}

	public void setLimited_edition(String limited_edition) {
		this.limited_edition = limited_edition;
	}

	public float getNb_cases_open_12m() {
		return nb_cases_open_12m;
	}

	public void setNb_cases_open_12m(float nb_cases_open_12m) {
		this.nb_cases_open_12m = nb_cases_open_12m;
	}

	public float getFirst_purchase_date() {
		return first_purchase_date;
	}

	public void setFirst_purchase_date(float first_purchase_date) {
		this.first_purchase_date = first_purchase_date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getNb_cases_close_6m() {
		return nb_cases_close_6m;
	}

	public void setNb_cases_close_6m(float nb_cases_close_6m) {
		this.nb_cases_close_6m = nb_cases_close_6m;
	}

	public float getCnt_orders_l3m() {
		return cnt_orders_l3m;
	}

	public void setCnt_orders_l3m(float cnt_orders_l3m) {
		this.cnt_orders_l3m = cnt_orders_l3m;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getHome_country() {
		return home_country;
	}

	public void setHome_country(String home_country) {
		this.home_country = home_country;
	}

	public float getNb_cases_close() {
		return nb_cases_close;
	}

	public void setNb_cases_close(float nb_cases_close) {
		this.nb_cases_close = nb_cases_close;
	}

	public float getRevenue_l3m() {
		return revenue_l3m;
	}

	public void setRevenue_l3m(float revenue_l3m) {
		this.revenue_l3m = revenue_l3m;
	}

	public float getNb_cases_open_1m() {
		return nb_cases_open_1m;
	}

	public void setNb_cases_open_1m(float nb_cases_open_1m) {
		this.nb_cases_open_1m = nb_cases_open_1m;
	}

	public String getAge_group() {
		return age_group;
	}

	public void setAge_group(String age_group) {
		this.age_group = age_group;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public float getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(float registration_date) {
		this.registration_date = registration_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
