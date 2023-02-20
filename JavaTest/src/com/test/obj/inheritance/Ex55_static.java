package com.test.obj.inheritance;

public class Ex55_static {

	public static void main(String[] args) {

		

	} //main
	
} //Main

class StaticTest {
	
	private int a;			//객체 변수
	private static int b;	//정적 변수
	
	public void aaa() {
		
		//객체 메소드
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(this.a);
		System.out.println(StaticTest.b);
		
	}
	
	public static void bbb() {
		
		//정적 메소드
//		System.out.println(this.a);  // static 메소드 내에서는 this 키워드를 사용할 수 없다.
									 // 	> 객체 변수나 객체 메소드를 호출할 수 없다.
		System.out.println(StaticTest.b);
		
	}
	
}
