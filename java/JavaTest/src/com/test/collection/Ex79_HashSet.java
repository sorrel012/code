package com.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Ex79_HashSet {
	
	public static void main(String[] args) {

//		m1();
//		m2();
		m3();

	} //main

	private static void m3() {
		
		/*
		
		롯데마트 > 경품행사
		1등: 아이패드
		2등: 에어팟
		3등: 참치세트
		4등: 김세트
		5등: 맥스봉
		
		 */
		
		String[] list = { "홍길동","아무개","하하하","호호호","후후후","유재석","강호동","박명수","정형동","조세호" };
		
		//1. 중복 당첨 허용	> ArrayList
		//2. 중복 당첨 비허용	> HashSet
		
		//1.
		for(int i = 0; i < 5; i++) {
			System.out.println(list[(int)(Math.random() * 10)]);
		}
		System.out.println();
		
		//2.
		
		HashSet<String> set = new HashSet<String>();
		
		while(set.size() < 5) {
			set.add(list[(int)(Math.random() * 10)]);
		}
		
		System.out.println(set);
		
	}

	private static void m2() {
		
		//로또 번호 > 중복되지 않는 난수
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		
		for(int i = 0; i < 6; i++) {
			
			int n = (int)(Math.random() * 45) + 1;
			
			if (!lotto.contains(n)) {
				lotto.add(n);
			} else {
				i--;
			}
			
		}
		
		System.out.println(lotto);
		System.out.println();
		
		HashSet<Integer> lotto2 = new HashSet<Integer>();
		
		while(lotto2.size() < 6) {
			
			int n = (int)(Math.random() * 45) + 1;
			lotto2.add(n);
			
		}
		
		System.out.println(lotto2);
		System.out.println();
		
		ArrayList<Integer> lotto3 = new ArrayList<Integer>(lotto2);
		
		Collections.sort(lotto3);
		System.out.println(lotto3);
		
	}

	private static void m1() {
		
		HashSet<String> set = new HashSet<String>();
		
		//1. 요소 추가하기
		set.add("사과");
		set.add("딸기");
		set.add("바나나");
		
		//2. 요소 개수
		System.out.println(set.size());
		
		//3. 덤프
		System.out.println(set);
		
		//4. 중복된 값 추가하기
		set.add("사과");
		System.out.println(set);
	
		//5. 검색
		System.out.println(set.contains("사과"));
		
		//6. 삭제
		set.remove("사과");
		System.out.println(set);
		
		//7. 요소 읽기 > 향상된 for문 사용
		for (String item : set) {
			System.out.println(item);
		}
		
		//이터레이터 > 데이터 집합을 탐색하는 도구 > 탐색기
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
	
}
