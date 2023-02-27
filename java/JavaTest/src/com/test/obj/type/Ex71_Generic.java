package com.test.obj.type;

public class Ex71_Generic {

	public static void main(String[] args) {

		Item item1 = new Item();
		
		Item<String> item2 = new Item<String>();
		item2.c = "나무";
		
		Item<Integer> item3 = new Item<Integer>();
		item3.c = 10;
		
		
		Desk<Double> d = new Desk<Double>();
		d.set(3.14);
		System.out.println(d.get() * 2);
		System.out.println();
		
		Cup<Integer, String> cup = new Cup<Integer, String>(100, "문자열");
		
		System.out.println(cup.getA());
		System.out.println(cup.getB());
		

	} //main
	
} //Main

class Item<T> {
	
	public int a;
	public int b;
	public T c;	//클래스 설계 당시에는 c의 자료형이 결정되지 않음.
				// > 객체 생성할 때 결정
	
}

class Desk<T> {
	
	public T a; //멤버변수 자료형
	 
	public void set(T a) { //매개변수 자료형
		this.a = a;
		
//		T b; //지역변수 자료형 > 비권장
	}
	
	public T get() { //반환값 자료형
		return this.a;
	}
	
}

class Cup<T, U> {
	
	public T a;
	public U b;
	
	public Cup(T a, U b) {
		this.a = a;
		this.b = b;
	}

	public T getA() {
		return a;
	}

	public U getB() {
		return b;
	}
	
}
