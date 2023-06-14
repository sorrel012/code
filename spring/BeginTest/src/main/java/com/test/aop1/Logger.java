package com.test.aop1;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;

//보조 업무 객체
public class Logger {
	
	//보조 업무 구현
	public void log() {
		
		Calendar now = Calendar.getInstance();
		System.out.printf("[LOG][%tF %tT] 로그를 기록합니다.\n", now, now) ;
		
	}
	
	public void time(ProceedingJoinPoint jp) {
		
		//주 업무를 실행하는 소요시간
		
		long begin = System.nanoTime();
		System.out.println("[LOG] 기록을 시작합니다.");
		
		//주 업무 실행
		//- 글쓰기 > 주 업무 객체의 가상 객체 참조
		try {
			
			jp.proceed(); //현재 실행되는 주 업무 메소드
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.nanoTime();
		System.out.println("[LOG] 기록을 종료합니다.");
		
		System.out.printf("[LOG] 소요 시간 %,dns\n", end - begin);
		
	}
	
	//매개변수 memo를 memo.xml의 <aop:after-returning method="history" pointcut-ref="p2" returning="memo"/> 에서 참조
	public void history(Object memo) {
		System.out.println("[LOG] 읽기 기록: " + memo);
	}
	
	public void check(Exception e) {
		System.out.println("[LOG] 예외 발생: " + e.getMessage());
		//DB insert..
		//담당자 메일 or 메시지
	}

}
