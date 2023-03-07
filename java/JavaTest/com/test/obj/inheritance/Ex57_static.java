package com.test.obj.inheritance;

public class Ex57_static {
	
	public static void main(String[] args) {

		/*
		
		요구사항]
		
		1. 펜을 생산하세요. > class Pen > new Pen(..
		2. 생산된 펜의 개수를 세주세요.
		
		*/
		
		/*
		//Case1.
		// - 간편함
		// - Pen과 count 간의 관계  약함 > 둘의 연관성이 낮다.
		int count = 0;	//누적 변수

		Pen p1 = new Pen("Monami", "Black");
		count++;
		
		Pen p2 = new Pen("Monami", "Black");
		count++;
		
		Pen p3 = new Pen("Monami", "Black");
		count++;
		
		System.out.println("볼펜 개수: " + count);
		*/
		
		/*
		//Case2.
		// - Pen 클래스와 count 변수간의 관계를 강하게 연결
		// - count 변수가 객체마다 존재 > count를 개인 데이터로 취급 > but count는 공용데이터!!
		Pen p1 = new Pen("Monami", "Black");
		p1.count++;
		
		Pen p2 = new Pen("Monami", "Black");
		p1.count++;

		Pen p3 = new Pen("Monami", "Black");
		p1.count++;

		System.out.println("볼펜 개수: " + p1.count);
		*/
		
		/*
		//Case 3.
		// - Pen 클래스와 count 변수 간의 관계를 강하게 연결
		// - 공용 데이터 성격으로 count를 만듦. > static
		Pen p1 = new Pen("Monami", "Black");
		Pen.count++;
		
		Pen p2 = new Pen("Monami", "Black");
		Pen.count++;

		Pen p3 = new Pen("Monami", "Black");
		Pen.count++;

		System.out.println("볼펜 개수: " + Pen.count);
		*/
		
		//Case4.
		// - count++ 누락 방지 > 생성자 활용
		Pen p1 = new Pen("Monami", "Black");
		
		Pen p2 = new Pen("Monami", "Black");

		Pen p3 = new Pen("Monami", "Black");

		System.out.println("볼펜 개수: " + Pen.count);
		
	} //main
	
} //Main

class Pen {
	
	private String model;
	private String color;
	
//	public int count; //Case2. 누적변수
	public static int count; //Case3. 정적 누적변수
	
	//정적 생성자 : static 있는 생성자
	
	
	//객체 생성자 : static 없는 생성자 > 객체 멤버 초기화
	public Pen(String model, String color) {
		
		this.model = model;
		this.color = color;
		
		Pen.count++; //Case4. 호출할 때마다 1 증가
	}

	@Override
	public String toString() {
		return "Pen [model=" + model + ", color=" + color + "]";
	}
	
} //Pen
