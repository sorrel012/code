package com.test.question;

import java.util.Calendar;

public class Item {
	
	private String name;
	private Calendar expiration;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getExpiration() {
		return String.format("%tF", this.expiration);
	}
	
	public void setExpiration(String expiration) {
		
		String year = expiration.substring(0, 4);
		String month = expiration.substring(5, 7);
		String date = expiration.substring(8, 10);
		
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.YEAR, Integer.parseInt(year));
		c.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		c.set(Calendar.DATE, Integer.parseInt(date));
		
		this.expiration = c;
	}
	

	
}
