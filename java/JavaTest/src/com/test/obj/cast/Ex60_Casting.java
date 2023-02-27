package com.test.obj.cast;

public class Ex60_Casting {
	
	public static void main(String[] args) {

		//상황] 대리점 운영 > 프린터 판매
		//1. 재고 확보
		//2. 주기적으로 제품 점검
		
		//목적] 제품 점검 > 효율적
		
//		m1();
//		m2(); //변경사항] 재고 증가
		m3(); //변경사항] 브랜드 증가

	} //main

	private static void m3() {
		
		//Case3. > 형변환 사용
		
		Printer[] ps = new Printer[8];
		
		for(int i = 0; i < ps.length; i++ ) {
			
			if(i < 5) {
				ps[i] = new HP600("black", 25000, "ink");
				
			} else {
				ps[i] = new LG500("white", 35000, "lazer");
			}
			
		}

		for(int i = 0; i < ps.length; i++ ) {
			
			ps[i].print();
			
			//다운캐스팅
			if(ps[i] instanceof HP600) {  //ps[i]와 HP600의 자료형이 같은가?(형변환 가능한가?)
				HP600 hp1 = (HP600)ps[i];
				hp1.selfTest();

			} else if(ps[i] instanceof LG500){
				LG500 lg1 = (LG500)ps[i];
				lg1.call();
			}
			
		}
		
	}

	private static void m2() {
		
		//Case2. > 배열 사용
		
		//재고 확보
		HP600[] hps = new HP600[5];
		
		for(int i=0; i < hps.length; i++) {
			hps[i] = new HP600("black", 25000, "ink");
		}
		
		
		LG500[] lgs = new LG500[3];
		
		for(int i=0; i < lgs.length; i++) {
			lgs[i] = new LG500("white", 35000, "lazer");
		}
		
		
		//점검
		for (int i = 0; i < hps.length; i++) {
			hps[i].print();
			hps[i].selfTest();
		}
		
		for (int i = 0; i < lgs.length; i++) {
			lgs[i].print();
			lgs[i].call();
		}
		
	}

	private static void m1() {

		//Case1.
		
		//재고 확보
		HP600 hp1 = new HP600("black", 25000, "ink");
		HP600 hp2 = new HP600("black", 25000, "ink");
		HP600 hp3 = new HP600("black", 25000, "ink");
		HP600 hp4 = new HP600("black", 25000, "ink");
		HP600 hp5 = new HP600("black", 25000, "ink");
		
		LG500 lg1 = new LG500("white", 35000, "lazer");
		LG500 lg2 = new LG500("white", 35000, "lazer");
		LG500 lg3 = new LG500("white", 35000, "lazer");
		
		//점검 x 반복
		hp1.print();
		hp2.print();
		hp3.print();
		hp4.print();
		hp5.print();
		
		lg1.print();
		lg2.print();
		lg3.print();
		
	}
	
} //Main

class Printer {
	
	private String color;
	private int price;
	private String type;
	
	public Printer(String color, int price, String type) {
		this.color = color;
		this.price = price;
		this.type = type;
	}
	
	public void print(){
		
	}
	
}


class HP600 extends Printer {
	
//	private String color;
//	private int price;
//	private String type;
	
	public HP600(String color, int price, String type) {
		super(color, price, type);
//		this.color = color;
//		this.price = price;
//		this.type = type;
	}

//	@Override
//	public String toString() {
//		return "HP600 [color=" + color + ", price=" + price + ", type=" + type + "]";
//	}
	
	@Override
	public void print() {
		System.out.println("HP600으로 출력합니다.");
	}
	
	public void selfTest() {
		System.out.println("HP600 자가진단을 실시합니다.");
	}
	
}

class LG500 extends Printer {

//	private String color;
//	private int price;
//	private String type;
	
	public LG500(String color, int price, String type) {
		super(color, price, type);
//		this.color = color;
//		this.price = price;
//		this.type = type;
	}

//	@Override
//	public String toString() {
//		return "LG500 [color=" + color + ", price=" + price + ", type=" + type + "]";
//	}
	
	@Override
	public void print() {
		System.out.println("LG500으로 출력합니다.");
	}
	
	public void call() {
		System.out.println("인공지능 AI와 연결합니다.");
	}
	
}

