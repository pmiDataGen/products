package com.pmi.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import com.pmi.util.TextToOrderItems;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Orders {

	public Orders() {

	}

//	@CsvBindByName
//	private String order_id;// primary Key for database "c360"
	@CsvBindByName
	private String order_number;// primary Key for database "db_l0_adl"
	@CsvBindByName
	private String identity_unique_identifier;
	@CsvBindByName
	private String persona_identifier;
	@CsvBindByName
	private String total_price;
	@CsvBindByName
	private String status;
	@CsvBindByName
	private long date;
	@CsvBindByName
	private String link_to_invoice_file;
	@CsvBindAndSplitByName(elementType = OrderItems.class, splitOn = "\\|", converter = TextToOrderItems.class)
	private List<OrderItems> order_items;

	@JsonProperty("td:c360:operation")
	@CsvBindByName
	private String td_c360_operation;
	@CsvBindByName
	private String apiCallTimeTakenInMillis;
	@CsvBindByName
	private String recordConsistencyTime;

	@Override
	public String toString() {
		return "Orders [order_number=" + order_number + ", identity_unique_identifier=" + identity_unique_identifier
				+ ", persona_identifier=" + persona_identifier + ", total_price=" + total_price + ", status=" + status
				+ ", date=" + date + ", link_to_invoice_file=" + link_to_invoice_file + ", order_items=" + order_items
				+ ", td_c360_operation=" + td_c360_operation + ", apiCallTimeTakenInMillis=" + apiCallTimeTakenInMillis
				+ ", recordConsistencyTime=" + recordConsistencyTime + "]";
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public String getIdentity_unique_identifier() {
		return identity_unique_identifier;
	}

	public void setIdentity_unique_identifier(String identity_unique_identifier) {
		this.identity_unique_identifier = identity_unique_identifier;
	}

	public String getPersona_identifier() {
		return persona_identifier;
	}

	public void setPersona_identifier(String persona_identifier) {
		this.persona_identifier = persona_identifier;
	}

	public String getTotal_price() {
		return total_price;
	}

	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getLink_to_invoice_file() {
		return link_to_invoice_file;
	}

	public void setLink_to_invoice_file(String link_to_invoice_file) {
		this.link_to_invoice_file = link_to_invoice_file;
	}

	public List<OrderItems> getOrder_items() {
		return order_items;
	}

	public void setOrder_items(List<OrderItems> order_items) {
		this.order_items = order_items;
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
	 * private String order_id; private String order_item_identifier; private String
	 * identity_id; private String persona_id; private String country; private float
	 * order_amount; private float order_discount; private String order_type;
	 * private String order_status; // status private String order_date; private
	 * String order_currency; private String home_country; private String
	 * order_items; private String item_identifier; private String product_variant;
	 * private String item_description; private float item_price; private int
	 * item_quantity; // private String time; // "time": "1548928418229"//No need to
	 * pass the values // private String td_c360_operation_time; //
	 * "td:c360:operation_time": // "1548928418229.0"//No need to pass the values
	 * private String status;
	 */

}