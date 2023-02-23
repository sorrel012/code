package com.test.collection;

import java.util.ArrayList;
import java.util.Calendar;

public class Ex73_ArrayList {

	public static void main(String[] args) {

//		m1();
//		m2();
		m3();

	} //main

	private static void m3() {
		
		//정수 배열
		int[] ns1 = new int[3];
		ArrayList<Integer> ns2 = new ArrayList<Integer>();
		
		//실수 배열
		double[] fs1 = new double[3];
		ArrayList<Double> fs2 = new ArrayList<Double>();
		
		//논리 배열
		boolean[] bs1 = new boolean[3];
		ArrayList<Boolean> bs2 = new ArrayList<Boolean>();
		
		//문자열 배열
		String[] txt1 = new String[3];
		ArrayList<String> txt2 = new ArrayList<String>();
		
		//참조형(객체)배열
		Calendar[] cs1 = new Calendar[3];
		ArrayList<Calendar> cs2 = new ArrayList<Calendar>();
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//- add
		
		for(int i = 0; i < 10; i++) {
			list.add( (int)(Math.random() * 100) );
		}
		
		System.out.println(list);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("list.get(%d) = %d\n", i, list.get(i));
		}
		
		
		
		
	}

	private static void m2() {
		
		//ArrayList 사용법
		
		//1. 생성하기
		ArrayList<String> list = new ArrayList<String>(); //문자열 배열
		
		//2. 요소 추가하기
		list.add("바나나");
		list.add("딸기");
		list.add("귤");
		list.add("포도");
		list.add("파인애플");
		list.add("사과");
		
		//3. 요소의 개수
		System.out.println(list.size());
		
		//4. 요소 읽기
		System.out.println(list.get(0));
		System.out.println(list.get(4));
//		System.out.println(list.get(5)); //IndexOutOfBoundsException
		System.out.println(list.get(list.size() - 1));
		System.out.println();
		
		//5. 요소의 수정
		list.set(0, "사과");
		System.out.println(list);
		
		//6. 요소의 삭제
		list.remove(2);
		System.out.println(list.size());
		System.out.println(list);
		System.out.println();
		
		//7. 탐색
		for(String str:list) {
			System.out.println(str);
		}
		System.out.println();

		//8. 요소의 검색
		System.out.println(list.indexOf("사과"));
		System.out.println(list.indexOf("망고"));
		System.out.println(list.lastIndexOf("사과"));
		System.out.println(list.contains("망고"));
		System.out.println(list.contains("딸기"));
		System.out.println();
		
		//9. 초기화
		list.clear();
		System.out.println(list.size());
		System.out.println(list);
		System.out.println();
		
		//10. 빈 배열 확인
		System.out.println(list.isEmpty());
		System.out.println();
		
		//11. 요소 추가
		list.add("바나나");
		list.add("딸기");
		list.add("귤");
		list.add("포도");
		list.add("파인애플");
		System.out.println();
		System.out.println(list);
		
		list.add(2, "수박");
		System.out.println(list);
		
	}

	private static void m1() {
		
		//순수배열
		//- 타입 명시
		//- 길이 명시
		int[] nums1 = new int[3];
		
		//요소 접근 > 첨자(index) 사용
		nums1[0] = 10;
		nums1[1] = 20;
		nums1[2] = 30;
		
		System.out.println(nums1[0]); //[첨자] > 인덱서(Indexer)
		System.out.println(nums1[1]);
		System.out.println(nums1[2]);
		
		System.out.println(nums1.length);
		System.out.println();
		
		//컬렉션
		//- 타입 명시 > 제네릭
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		
		//요소 접근 > Append > 차례대로(순서대로) 넣어라
		nums2.add(10);
		nums2.add(20);
		nums2.add(30);
		
		for(int i:nums2) {
			System.out.println(i);
		}
		
		System.out.println(nums2.size());
		System.out.println();
		
		
		
		
		
		
	}
	
}
