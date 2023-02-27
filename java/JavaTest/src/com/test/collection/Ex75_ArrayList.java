package com.test.collection;

import java.util.ArrayList;

public class Ex75_ArrayList {

	public static void main(String[] args) {

		//모든 컬렉션의 특징
//		m1();
		m2();

	} //main

	private static void m2() {
		
		//()안에 배열의 길이를 지정해줄 수 있다. > 잦은 배열 교체를 방지하여 효율을 높여준다.
		ArrayList<Integer> list = new ArrayList<Integer>(100);
		
		//숫자 100개 저장
		for(int i = 1; i <= 100; i++) {
			list.add(i);
		}
		
		System.out.println(list);
		
		list.add(101); // 숫자 1개 추가 > 더이상 숫자를 추가할 일이없음 > 나머지 공간 낭비
		
		list.trimToSize(); // 낭비되는 공간을 지워줌
		
	}

	private static void m1() {
		
		//ArrayList(컬렉션)의 특징
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		System.out.println(list.size());
		
		list.add(100); //첫 번째 요소 추가 > 길이 4 배열 생성
		
		System.out.println(list.size());
		
		list.add(200);
		list.add(300);
		list.add(400);
		
		System.out.println(list.size());
		
		list.add(500); //길이 4 배열 > 길이 8 배열 교체
		
	}
	
}
