package com.test.lambda;

public class Ex87_Lambda {
	
	public static void main(String[] args) {

		//요구사항] MyInterface를 구현한 객체를 생성하시오/.

		//1. 일반 클래스 + 일반 객체
		MyInterface m1 = new MyClass();
		m1.test();
		
		//2. 익명 클래스 + 익명 객체
		MyInterface m2 = new MyInterface() {
			@Override
			public void test() {
				System.out.println("익명 클래스에서 구현한 메소드");
			}
		};
		m2.test();
		
		//3. 람다식
		MyInterface m3 = () -> {System.out.println("람다식으로 구현한 메소드");}; //test메소드 구현
		m3.test();
		
		System.out.println();
		
		
		//The target type of this expression must be a functional interface
//		TestInterface t2 = () -> {};
		
		
		//추상 메소드의 형식에 따라
		// - 매개변수 O, X
		// - 반환값 O, X
		
		//1. 매개변수 X, 반환값 X	//void call();
		NoParameterNoReturn pr1 = new NoParameterNoReturn() {
			@Override
			public void call() {
				System.out.println("pr1");
			}
		};
		pr1.call();
		
		NoParameterNoReturn pr2 = () -> {System.out.println("pr2");};
		pr2.call();
		
		NoParameterNoReturn pr3 = () -> System.out.println("pr3"); //★★람다식 구현부에 있는 실행 문장이 한 줄이면 {}을 생략할 수 있다.
		pr3.call();
		
		System.out.println();
		
		//2-1. 매개변수 한 개 O, 반환값 X	//void call(int n);
		ParameterNoReturn pr4 = (int n) -> {System.out.println("pr4: " + n);};
		pr4.call(100);
		pr4.call(200);
		pr4.call(300);

		ParameterNoReturn pr5 = (n) -> {System.out.println("pr5: " + n);};
		pr5.call(400);
		
		ParameterNoReturn pr6 = n ->  {System.out.println("pr6: " + n);};
		pr6.call(500);
		
		ParameterNoReturn pr7 = n -> System.out.println("pr7: " + n);
		pr7.call(600);
		
		System.out.println();
		
		//2-2. 매개변수 여러 개 O, 반환값 X //void call(String name, int age);
		MultiParameterNoReturn pr8 = (String name, int age) -> {System.out.println("pr8: " + name + ", " + age);};
		pr8.call("홍길동", 20);
		
		MultiParameterNoReturn pr9 = (name, age) -> {System.out.println("pr9: " + name + ", " + age);};
		pr9.call("아무개", 25);
		
		System.out.println();
		
		//3. 매개변수 X, 반환값 O	//int call();
		NoParameterReturn pr11 = () -> {return 100;};
		System.out.println("pr11: " + pr11.call());
		

		NoParameterReturn pr12 = () -> 200;
		System.out.println("pr12: " + pr12.call());
		
		System.out.println();
		
		//4. 매개변수 O, 반환값 O	//int call(int a, int b);
		ParameterReturn pr13 = (int a, int b) -> {return a + b;};
		System.out.println("pr13: " + pr13.call(10, 20));

		ParameterReturn pr14 = (a, b) -> a + b;
		System.out.println("pr14: " + pr14.call(20, 30));
		
		
				
	}//main

} //Main

interface NoParameterNoReturn {
	void call();
}

interface ParameterNoReturn {
	void call(int n);
}

interface MultiParameterNoReturn {
	void call(String name, int age);
}

interface NoParameterReturn {
	int call();
}

interface ParameterReturn {
	int call(int a, int b);
}


interface TestInterface {
	void aaa();
	void bbb();
}

interface MyInterface {
	void test();
}

class MyClass implements MyInterface{
	@Override
	public void test() {
		System.out.println("MyClass 클래스에서 구현한 메소드");
	}
}