package com.test.obj;

import java.util.Calendar;

public class Member {

	private String name;		//회원명
	private String id;			//아이디

	private Calendar regedate;	//가입 날짜

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public Calendar getRegedate() {
//		return regedate;
//	}
//
//	public void setRegedate(Calendar regedate) {
//		this.regedate = regedate;
//	}

	public void setRegdate(int year, int month, int date) {

		Calendar regdate = Calendar.getInstance();

		regdate.set(year, month-1, date);

		this.regedate = regdate;

	}

	public String getRegdate() {

		return String.format("%tF\n", this.regedate);
	}

}
