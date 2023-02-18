package com.sorrel012.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsRunner {
	
	//입력값을 입력받은 자료형, 값 그대로 돌려줌
	static <X> X doubleValue(X value) {
		return value;
	}
	
	static <X extends List> void duplicate(X list) {
		list.addAll(list);
	}
	
	static Number sumOfNumberList(List<? extends Number> numbers) {
		double sum= 0.0;
		for(Number number : numbers) {
			sum += number.doubleValue();
		}
		return sum;
		
	}
	
	static void addACoupleOfValues(List<? super Number> numbers) {
		numbers.add(1);
		numbers.add(1.0);
		numbers.add(1.0f);
		numbers.add(1L);
	}
	
	
	public static void main(String[] args) {
		
		List emptyList = new ArrayList<Number>();
		addACoupleOfValues(emptyList);
		System.out.println(emptyList);
		
		System.out.println();
		
		
		System.out.println(sumOfNumberList(List.of(1,2,3,4,5)));
		System.out.println(sumOfNumberList(List.of(1.1,2.1,3.1,4.1,5.1)));
		System.out.println(sumOfNumberList(List.of(1L,2L,3L,4L,5L)));
		
		System.out.println();
		
		
		
		String value1 = doubleValue(new String("하이"));
		Integer number1 = doubleValue(Integer.valueOf(5));
		ArrayList list1 = doubleValue(new ArrayList());
		System.out.println(value1);
		System.out.println(number1);
		System.out.println(list1);
		System.out.println();
		
		ArrayList numbers = new ArrayList<>(List.of(1,2,3));
		duplicate(numbers);
		System.out.println(numbers);
		System.out.println();
		
		
		MyCustomList<Long> list = new MyCustomList<>();
		list.addElement(15L);
		list.addElement(10L);
		Long value = list.get(0);
		
		System.out.println(list);
		System.out.println(value);
		
		System.out.println();
		
		MyCustomList<Integer> list2= new MyCustomList<>();
		list2.addElement(Integer.valueOf(5));
		list2.addElement(Integer.valueOf(7));
		Integer number= list2.get(0);
		
		System.out.println(list2);
		System.out.println(number);

	} //main

}