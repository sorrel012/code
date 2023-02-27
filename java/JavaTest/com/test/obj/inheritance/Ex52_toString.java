package com.test.obj.inheritance;

public class Ex52_toString {
	
	public static void main(String[] args) {

		Time t1 = new Time(2, 30);
		System.out.println(t1.info());
		System.out.println(t1.toString());
		
//		Calendar c1 = Calendar.getInstance();
//		System.out.println(c1);
//
//		Date d1 = new Date();
//		System.out.println(d1);
		
	} //main
	
} //Main

class Time {
	
	private int hour;
	private int min;
	
	public Time(int hour, int min) {
		this.hour = hour;
		this.min = min;
	}
	
	//덤프
	public String info() {
		return this.hour + ":" + this.min;
	}

	@Override
	public String toString() {
		return "Time [hour=" + hour + ", min=" + min + "]";
	}
	
	//덤프 전용 메소드
//	@Override
//	public String toString() {
//		return this.hour + ":" + this.min;
//	}
	
	
	
}
