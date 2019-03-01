package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Orders {

	public Orders() {
		
	}

	private String td_c360_operation;
	private String order_id;
	private String order_item_identifier;
	private String identity_id;
	private String persona_id;
	private String country;
	private float order_amount;
	private float order_discount;
	private String order_type;
	private String order_status; // status
	private String order_date;
	private String order_currency;
	private String home_country;
	private String order_items;
	private String item_identifier;
	private String product_variant;
	private String item_description;
	private float item_price;
	private int item_quantity;
	// private String time; // "time": "1548928418229"//No need to pass the values
	// private String td_c360_operation_time; // "td:c360:operation_time":
	// "1548928418229.0"//No need to pass the values
	private String status;
	private String apiCallTimeTakenInMillis;
	private String recordConsistencyTime;

	@Override
	public String toString() {
		return "Orders [td_c360_operation=" + td_c360_operation + ", order_id=" + order_id + ", order_item_identifier="
				+ order_item_identifier + ", identity_id=" + identity_id + ", persona_id=" + persona_id + ", country="
				+ country + ", order_amount=" + order_amount + ", order_discount=" + order_discount + ", order_type="
				+ order_type + ", order_status=" + order_status + ", order_date=" + order_date + ", order_currency="
				+ order_currency + ", home_country=" + home_country + ", order_items=" + order_items
				+ ", item_identifier=" + item_identifier + ", product_variant=" + product_variant
				+ ", item_description=" + item_description + ", item_price=" + item_price + ", item_quantity="
				+ item_quantity + ", status=" + status + ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis
				+ ", recordConsistencyTime=" + recordConsistencyTime + "]";
	}

	public String getRecordConsistencyTime() {
		return recordConsistencyTime;
	}

	public void setRecordConsistencyTime(String recordConsistencyTime) {
		this.recordConsistencyTime = recordConsistencyTime;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getOrder_item_identifier() {
		return order_item_identifier;
	}

	public void setOrder_item_identifier(String order_item_identifier) {
		this.order_item_identifier = order_item_identifier;
	}

	public String getIdentity_id() {
		return identity_id;
	}

	public void setIdentity_id(String identity_id) {
		this.identity_id = identity_id;
	}

	public String getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(String persona_id) {
		this.persona_id = persona_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public float getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(float order_amount) {
		this.order_amount = order_amount;
	}

	public float getOrder_discount() {
		return order_discount;
	}

	public void setOrder_discount(float order_discount) {
		this.order_discount = order_discount;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getOrder_currency() {
		return order_currency;
	}

	public void setOrder_currency(String order_currency) {
		this.order_currency = order_currency;
	}

	public String getHome_country() {
		return home_country;
	}

	public void setHome_country(String home_country) {
		this.home_country = home_country;
	}

	public String getOrder_items() {
		return order_items;
	}

	public void setOrder_items(String order_items) {
		this.order_items = order_items;
	}

	public String getItem_identifier() {
		return item_identifier;
	}

	public void setItem_identifier(String item_identifier) {
		this.item_identifier = item_identifier;
	}

	public String getProduct_variant() {
		return product_variant;
	}

	public void setProduct_variant(String product_variant) {
		this.product_variant = product_variant;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public float getItem_price() {
		return item_price;
	}

	public void setItem_price(float item_price) {
		this.item_price = item_price;
	}

	public int getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}