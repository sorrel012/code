package com.test.question;

public class Q107_2 {

	public static void main(String[] args) {

		//배열 생성
		MyHashMap2 map = new MyHashMap2();

		//추가
		map.put("국어", "합격");
		map.put("영어", "불합격");
		map.put("수학", "보류");
		
		//읽기
		System.out.println(map.get("국어"));
		System.out.println(map.get("영어"));
		System.out.println(map.get("수학"));
		
		System.out.println();
		
		//개수
		System.out.println(map.size());
		
		System.out.println();

		//수정
		map.put("영어", "합격");
		System.out.println(map.get("영어"));
		System.out.println();

		//삭제
		map.remove("영어");
		System.out.println(map.get("영어"));
		
		System.out.println();
		
		//검색(key)
		if (map.containsKey("국어")) {
		      System.out.println("국어 점수 있음");
		} else {
		      System.out.println("국어 점수 없음");
		}
		
		System.out.println();

		//검색(value)
		if (map.containsValue("합격")) {
		      System.out.println("합격 과목 있음");
		} else {
		      System.out.println("합격 과목 없음");
		}

		System.out.println();
		
		//초기화
		map.clear();
		System.out.println(map.size());

	} //main
	
}
