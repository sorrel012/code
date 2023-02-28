package com.test.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;

public class Ex90_Lambda {

	public static void main(String[] args) {

		m1();

	} //main

	private static void m1() {
		
		//Consumer
		
		//사용자 정의 함수형 인터페이스
		MyConsumer m1 = num -> System.out.println(num);
		m1.test(10);
		
		//표준 API 함수형 인터페이스
		Consumer<Integer> c1 = new Consumer<Integer>() {
			@Override
			public void accept(Integer num) {
				System.out.println(num);
			}
		};
		c1.accept(20);
		
		Consumer<String> c2 = txt -> System.out.println(txt);
		c2.accept("홍길동");
		
		Consumer<String> c3 = txt -> System.out.println(txt.length());
		c3.accept("홍길동");
		
		Consumer<Integer> c4 = count -> {
			for(int i = 0; i < count; i++) {
				System.out.println(i);
			}
			System.out.println();
		};
		c4.accept(5);
		
		//BiConsumer
		BiConsumer<String, Integer> bc1 = (name, age) -> {
			System.out.printf("이름: %s, 나이: %d세\n", name, age);
		};
		bc1.accept("홍길동", 26);
		
		System.out.println();
		
		//전용
		IntConsumer ic1 = num -> System.out.println(num * num); // = Consumer<Integer> ic1
		ic1.accept(10);
		
		ObjIntConsumer<String> oic1 = (a, num) -> System.out.printf("%s, %d", a, num); // 첫 번째 자료형은 직접 지정
		oic1.accept("홍길동", 25);
		
	}
	
}

//람다식을 저장하고 싶다 > 인터페이스 필요 > 인터페이스 선언
interface MyConsumer {
	//인자O + 반환X
	void test(int num);
}