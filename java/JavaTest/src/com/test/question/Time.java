package com.test.question;

public class Time {
	
	private int hour;
	private int minute;
	private int second;
	
	public Time() {
		this(0, 0, 0);
	}
	
	public Time(int second) {
		this(0, 0, second);
	}

	public Time(int minute, int second) {
		this(0, minute, second);
	}
	
	public Time(int hour, int minute, int second) {
		
		if(hour < 0) { return; }
		if(minute < 0) { return; }
		if(second < 0) { return; }
		
		this.second = second % 60;
		minute += second / 60;
		
		this.minute = minute % 60;
		hour += minute / 60;
		
		this.hour = hour;
		
	}
	
	public String info() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}

}
