package com.test.aop1;

import java.util.Calendar;

//보조 업무 객체
public class Logger {
	
	//보조 업무 구현
	public void log() {
		
		Calendar now = Calendar.getInstance();
		System.out.printf("[LOG][%tF %tT] 로그를 기록합니다.\n", now, now) ;
		
	}

}
