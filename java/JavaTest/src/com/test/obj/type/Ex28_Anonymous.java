package com.test.obj.type;

public class Ex28_Anonymous {

	public static void main(String[] args) {

		//요구사항] 인터페이스를 구현한 클래스 선언하기 > 객체를 생성하기(목적)
		
//		//1. 본인 타입의 참조 변수
//		BB o1 = new BB();
//		o1.aaa();
//
//		//2. 부모 타입의 참조변수
//		AA o2 = new BB();
//		o2.aaa();
		
		//3. 추상 클래스. 인터페이스 > 추상 메소드 때문에 객체 생성 불가
//		AA o3 = new AA();
//		o3.aaa();
		
		AA o4 = new AA() {
			@Override
			public void aaa() {
				System.out.println("추상 메소드 구현");
			}
		};
		
		o4.aaa();
		
		AA o5 = new AA() {
			@Override
			public void aaa() {
				System.out.println("추상 메소드 구현2");
			}
		};
		
		o5.aaa();
		
	} //main
	
}

interface AA{
	void aaa();
}

class BB implements AA {
	
	@Override
	public void aaa() {
		System.out.println("추상메소드 구현");
	}
	
}