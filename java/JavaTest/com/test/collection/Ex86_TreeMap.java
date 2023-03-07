package com.test.collection;

import java.util.TreeMap;

public class Ex86_TreeMap {

	public static void main(String[] args) {

		TreeMap<String, String> map = new TreeMap<String, String>();
		
		map.put("white", "하양");
		map.put("black", "검정");
		map.put("yellow", "노랑");
		map.put("orange", "주황");
		map.put("green", "초록");
		map.put("red", "빨강");
		map.put("blue", "파랑");

		
		System.out.println(map); //key 자동 정렬
		System.out.println();
		
		System.out.println(map.firstKey());
		System.out.println(map.lastKey());
		System.out.println();
		
		System.out.println(map.get(map.firstKey()));
		System.out.println(map.firstEntry().getKey());
		System.out.println(map.firstEntry().getValue()); //권장
		System.out.println();
		
		System.out.println(map.headMap("m"));
		System.out.println(map.tailMap("m"));
		System.out.println(map.subMap("m", "t"));
		
	} //main
	
}
