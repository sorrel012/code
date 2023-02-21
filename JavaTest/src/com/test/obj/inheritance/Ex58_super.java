package com.test.obj.inheritance;

public class Ex58_super {

	public static void main(String[] args) {

		TestChild c = new TestChild();
		
		c.a = 10;
		c.b = 20;
		c.bbb();

	} //main
	
}

class TestParent {
	
	public int a;

	public TestParent() {
		this.a = 100;
	}

	public void test() {
		System.out.println("부모 메소드");
	}
	
}

class TestChild extends TestParent {
	
	public int b;

//	public TestChild() {
//		super(); //생성자 호출
//		this.b = 200;
//	}
	
	public void bbb() {
		
//		System.out.println(b);
//		System.out.println(this.b);
		
		//부모로부터 상속받은 멤버 변수
		System.out.println(a);
		System.out.println(this.a);
		System.out.println(super.a);
		test();
		this.test();
		super.test(); //메소드 오버라이딩에 의해 감춰진 부모 메소드 호출
		System.out.println();
		
	}

	@Override
	public void test() {
		System.out.println("자식 메소드");
	}
	
}