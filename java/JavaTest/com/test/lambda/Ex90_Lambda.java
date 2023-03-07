package com.test.lambda;

import java.util.Calendar;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Ex90_Lambda {

	public static void main(String[] args) {

//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
		m6();

	} //main

	private static void m6() {

		//함수형 인터페이스 중 일부 > 서로간의 결과를 결합(연결) > 람다식 연산
		User hong = new User("1", "홍길동", 20, "M", "서울", "010-1234-5678");
		
		//업무1.
		Consumer<User> c1 = user -> System.out.println("이름: " + user.getName());
		c1.accept(hong);
		
		//업무2.
		Consumer<User> c2 = user -> System.out.println("나이: " + user.getAge());
		c2.accept(hong);
		
		System.out.println();
		
		//업무3. 업무1 + 업무2 동시에 실행
		test(hong, c1, c2);
		
		System.out.println();
		
		Consumer<User> c3 = c1.andThen(c2); // 더하기 연산에 가까운 행동
		c3.accept(hong);
		System.out.println();
		
		Consumer<User> c4 = user -> System.out.println("전화번호: " + user.getTel());
		
		Consumer<User> c5 = c1.andThen(c2).andThen(c4);
		c5.accept(hong);
		System.out.println();
		
		Consumer<User> c6 = user -> {
			System.out.println("이름: " + user.getName());
			System.out.println("나이: " + user.getAge());
		};
		c6.accept(hong);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		Function<Integer, Boolean> f1 = num -> num > 0;
		System.out.println(f1.apply(10));
		
		Function<Boolean, String> f2 = result -> result ? "성공!" : "실패";
		System.out.println(f2.apply(true));
		
		System.out.println();
		
		//f1 + f2
		Function<Integer, String> f3 = f1.andThen(f2);
		System.out.println(f3.apply(10));
		
		Function<String, Integer> f4 = txt -> txt.length();
		
		Function<Integer, Integer> f5 = f1.andThen(f2).andThen(f4);
		System.out.println(f5.apply(-1));
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//2의 배수인지 판단
		Predicate<Integer> p1 = num -> num % 2 == 0;

		Predicate<Integer> p2 = num -> num % 3 == 0;
		
		int a = 4;
		
		System.out.println(p1.test(a));
		System.out.println(p2.test(a));
		
		System.out.println();
		
		//a가 2와 3의 공배수인지?
		Predicate<Integer> p3 = p1.and(p2);
		System.out.println(p3.test(a));
		
		//a가 2 또는 3의 배수인지?
		Predicate<Integer> p4 = p1.or(p2);
		System.out.println(p4.test(a));
		
		//a가 2의 배수가 아닌지?
		Predicate<Integer> p5 = p1.negate();
		System.out.println(p5.test(a));
		
	}

	private static void test(User hong, Consumer<User> c1, Consumer<User> c2) {
		
		c1.accept(hong);
		c2.accept(hong);
		
	}

	private static void m5() {
		
		Function<Integer, Boolean> f1 = num -> num > 0;
		System.out.println(f1.apply(10));
		System.out.println(f1.apply(-10));
		
		Predicate<Integer> p1 = num -> num > 0;
		System.out.println(p1.test(10));
		System.out.println(p1.test(-10));
		
		BiPredicate<Integer, Integer> p2 = (a,b) -> a > b;
		System.out.println(p2.test(10, 20));
		
	}

	private static void m4() {
		
		BiFunction<Integer, Integer, Integer> bf1 = (a,b) -> a + b;
		System.out.println(bf1.apply(10, 20));
		
		BinaryOperator<Integer> bo1 = (a,b) -> a + b;
		System.out.println(bo1.apply(10, 20));
		
		System.out.println();
		
		Function<Integer, Integer> bf2 = num -> num * num;
		System.out.println(bf2.apply(10));
		
		UnaryOperator<Integer> bo2 = num -> num * num;
		System.out.println(bo2.apply(20));
		
	}

	private static void m3() {
		
		Function<Integer, Boolean> f1 = num -> num > 0;
		System.out.println(f1.apply(10));
		System.out.println(f1.apply(-10));
		
		Function<String, Integer> f2 = txt -> txt.length();
		System.out.println(f2.apply("홍길동"));
		System.out.println(f2.apply("홍길동입니다."));
		
		User user = new User("1", "홍길동", 20, "M", "서울", "010-1234-5678");
		User user2 = new User("2", "호호호", 25, "F", "서울", "010-3456-7890");
		
		Function<User, String> f3= u -> u.getGender().equals("M") ? "남자" : "여자";
		System.out.println(f3.apply(user));
		System.out.println(f3.apply(user2));
		
		BiFunction<Integer, Integer, String> bf2 = (a, b) -> {
			if (a > b ) {
				return "크다";
			} else if (a < b) {
				return "작다";
			} else {
				return "같다";
			}
		};
		System.out.println(bf2.apply(10, 5));
		System.out.println(bf2.apply(5, 10));
		System.out.println(bf2.apply(10, 10));
		
	}

	private static void m2() {
		
		//Supplier
		
		Supplier<Integer> s1 = () -> { return 100; } ;
		System.out.println(s1.get());
		
		Supplier<Double> s2 = () -> Math.random();
		System.out.println(s2.get());
		
		Supplier<String> s3 = () -> "홍길동";
		System.out.println(s3.get());
		
		Supplier<Integer> s4 = () -> {
			
//			Calendar now = Calendar.getInstance(); 		> 추상 클래스
//			Calendar now = new GregorianCalendar();  	> 자식 클래스
			
			Calendar now = Calendar.getInstance();
			
			return now.get(Calendar.HOUR_OF_DAY);
		};
		System.out.println(s4.get());
		
	}

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