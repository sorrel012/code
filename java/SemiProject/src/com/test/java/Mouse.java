package com.test.java;

/**
 * 마우스 클래스입니다. 사용자 업무를 보조합니다.
 * @author HW
 *
 */
public class Mouse {
	
	private int buttons;
	private String type;
	
	/**
	 * 마우스 생성자입니다.
	 * @param buttons 마우스 버튼의 개수
	 * @param type 마우스 종류
	 */
	public Mouse(int buttons, String type) {
		this.buttons = buttons;
		this.type = type;
	}

	public int getButtons() {
		return buttons;
	}

	public void setButtons(int buttons) {
		this.buttons = buttons;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Mouse [buttons=" + buttons + ", type=" + type + "]";
	}
	
	/**
	 * 마우스로 특정 좌표를 클릭합니다.
	 */
	public void click() {
		System.out.println("마우스 클릭");
	}
	
	/**
	 * 마우스로 특정 요소를 드래그합니다.
	 */
	public void drag() {
		System.out.println("마우스 드래그");
	}
	
}
