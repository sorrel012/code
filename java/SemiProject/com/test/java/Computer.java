package com.test.java;

/**
 * 컴퓨터 클래스입니다.
 * @author HW
 *
 * @see Mouse 마우스 클래스
 * @see Mouse#click() 클릭 메소드
 * 
 * 
 */
public class Computer {
	
	/**
	 * 컴퓨터를 사용해 업무를 진행합니다.
	 */
	public void doSomething() {
		
		Mouse m = new Mouse(3, "무선마우스");
		m.click();
		m.drag();
		
	}

}
