package com.test.obj.cast;

public class Ex62 {
	
	public static void main(String[] args) {

//		AAA a = new AAA();
//		a.test();
//
//		BBB b = new BBB();
//		b.test();
		
	} //main
	
} //Main


//상속 + 접근 지정자
class AAA {
	
	//★★접근 지정자와 상관 없이 모든 멤버는 상속된다.
	public int a;
	private int b;
	
//	public AAA() {
//
//	}
	
	public AAA(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	//같은 클래스 내에서는 접근 지정자 무의미
	public void test() {
		
		System.out.println(this.a);
		System.out.println(this.b);
	}
	
}

class BBB extends AAA {
	
	//상속
	//- a(public), b(private)
	// - private 상속: 부모님께 금은보화가 가득한 금고를 유산으로 받아서 내 방으로 가지고 왔지만 비밀번호를 모르는...
	
	public int c;
	private int d;
	
	public BBB(int c, int d) {
		super(10, 20);
		this.c = c;
		this.d = d;
	}

	@Override
	public void test() {
		
		//부모로부터 물려받은 a와 b 출력
		System.out.println(this.a);
//		System.out.println(this.b);
	}
	
}
