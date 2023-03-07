package com.test.obj.cast;

public class Ex59_Casting {
	
	public static void main(String[] args) {

		/*
		Parent p1 = new Parent();
		p1.a = 10;
		p1.b = 20;
		
		Child c1 = new Child();
		c1.a = 10;
		c1.b = 20;
		c1.c = 30;
		c1.d = 40;
		
		// 부모클래스 = 자식클래스 > 업캐스팅
		Parent p2;
		Child c2;
		
		c2 = new Child(); //원본
		
		p2 = c2;  //p2 = (Parent)c2;
		
		//검증
		p2.a = 50;
		p2.b = 60;
		
		
		// 자식클래스 = 부모클래스 > 다운클래스
		Parent p3;
		Child c3;
		
		p3 = new Parent(); //원본
		
		c3 = (Child)p3;
		
		//검증
		c3.a = 10;
		c3.b = 20;
		c3.c = 30;
		c3.d = 40;
		*/
		
		//다운 클래스 예외
		Parent p4;
		Child c4;
		
		c4 = new Child(); //원본
		
		p4 = c4;
		
		
		Child c5;
		
		c5 = (Child)p4;  // 실제로는 Child 객체를 다시 Child 변수로 참조한 것
		
		c5.a = 10;
		c5.b = 20;
		c5.c = 30;
		c5.d = 40;
		
		System.out.println(c5.a);
		System.out.println(c5.b);
		System.out.println(c5.c);
		System.out.println(c5.d);

	} //main

} //Main


class Parent {
	public int a;
	public int b;
}


class Child extends Parent {
	public int c;
	public int d;
}