package com.test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Ex78_HashpMap {

	public static void main(String[] args) {

//		m1();
//		m2();
		m3();

	} //main

	private static void m3() {
		
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("red", "빨강");
		map.put("yellow", "노랑");
		map.put("blue", "파랑");
		
		//HashMap을 루프 탐색하기
		Set<String> set = map.keySet(); //키값들만 모아놓은 배열을 반환
		
		for (String item:set) {
			System.out.println(item);
		}
		
		Collection<String> values = map.values();
		
		for (String value : values) {
			System.out.println(value);
		}
		
		Set<String> set2 = map.keySet();
		
		for(String item : set2) {
			System.out.println(item + ":" + map.get(item));
		}
		
		//HashMap을 탐색하는 가장 정석이자 권장하는 방법(루프)
		Set<Entry<String, String>> eset = map.entrySet();
		
		for(Entry<String, String> item : eset) {
			System.out.println(item.getKey() + ":" + item.getValue());
		}
		
		
	}

	private static void m2() {
		
		//HashpMap 사용법
		HashMap<String, String> map = new HashMap<String, String>();
		
		//1. 요소 추가
		map.put("red", "빨강");
		map.put("yellow", "노랑");
		map.put("blue", "파랑");
		
		//2. 요소 개수
		System.out.println(map.size());
		
		//3. 요소 읽기
		System.out.println(map.get("red"));
		System.out.println(map.get("yellow"));
		System.out.println(map.get("blue"));
		
		//4. 요소 수정
		map.put("yello", "샛노랑");
		System.out.println(map.get("yellow"));
		
		//5. 요소 검색
		System.out.println(map.containsKey("yello"));
		System.out.println(map.containsKey("green"));
		
		System.out.println(map.containsValue("빨강"));
		System.out.println(map.containsValue("노랑"));
		
		//6. 요소 삭제
		map.remove("yellow");
		System.out.println(map.get("yellow")); //없는 key 요청 > null (에러x)
		
		//빈 배열 확인
		System.out.println(map.isEmpty());
		
		map.clear();
		
		System.out.println(map.isEmpty());
		
	}

	private static void m1() {
		
		//요구사항] 학생 1명의 국, 영, 수 점수 저장
		
		// 1. 간편함, 비권장
		int kor = 100;
		int eng = 90;
		int math = 80;
		 
		//2. 배열
		int[] score = new int[3];
		score[0] = 100;
		score[1] = 90;
		score[2] = 80;
		
		//3. ArrayList
		ArrayList<Integer> score2 = new ArrayList<Integer>();
		score2.add(100);
		score2.add(90);
		score2.add(80);
		
		//4. Class
		Score score3 = new Score();
		score3.kor = 100;
		score3.eng = 90;
		score3.math = 80;
		
		//5. HashMap
		HashMap<String, Integer> score4 = new HashMap<String, Integer>();
		score4.put("국어", 100);
		score4.put("영어", 90);
		score4.put("수학", 80);
		
		System.out.println(score4);
		System.out.println(score4.get("국어"));
		System.out.println(score4.get("영어"));
		System.out.println(score4.get("수학"));
		
		
		HashMap<String, Integer> score5 = new HashMap<String, Integer>();
		score5.put("국어", 99);
		score5.put("영어", 88);
		score5.put("수학", 77);
		
	} // m1()
	
} //Main

class Score {
	public int kor;
	public int eng;
	public int math;
}
