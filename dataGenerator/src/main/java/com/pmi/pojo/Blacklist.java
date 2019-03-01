package com.pmi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author boja.p.ramalingam
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Blacklist {

	public Blacklist() {
		
	}

		private String blacklist_key;
		private String phone_first_name_key;
		private String first_name;
		private String phone_number;
		private String email;

		@Override
		public String toString() {
			return "Blacklist [blacklist_key=" + blacklist_key 
					+", phone_first_name_key=" + phone_first_name_key 
					+",first_name="+ first_name
					+", phone_number=" + phone_number 
					+", email=" + email + "]";
		}

		public String getBlacklist_key() {
			return blacklist_key;
		}

		public void setBlacklist_key(String blacklist_key) {
			this.blacklist_key = blacklist_key;
		}

		public String getPhone_first_name_key() {
			return phone_first_name_key;
		}

		public void setPhone_first_name_key(String phone_first_name_key) {
			this.phone_first_name_key = phone_first_name_key;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getPhone_number() {
			return phone_number;
		}

		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		
		
}