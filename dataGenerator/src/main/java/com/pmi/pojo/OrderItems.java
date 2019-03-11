package com.pmi.pojo;

public class OrderItems {

	private String item_identifier;
	private String product_variant;
	private String item_description;
	private float item_price;
	private int item_quantity;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() Override toString() in the way it is done
	 * here. The format should NOT change. This is very much important for write
	 * ORDER_ITEMS into CSV file; ORDERS object has LIST of ORDER_ITEMS
	 */
	@Override
	public String toString() {
		return "item_identifier=" + item_identifier + ", product_variant=" + product_variant + ", item_description="
				+ item_description + ", item_price=" + item_price + ", item_quantity=" + item_quantity + " |";
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

}
