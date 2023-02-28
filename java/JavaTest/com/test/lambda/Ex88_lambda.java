package com.test.lambda;

import java.util.ArrayList;

public class Ex88_lambda {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < 20; i++) {
			list.add((int)(Math.random() * 100) + 1);
		}
		
		System.out.println("정렬 전 : " + list);
		
		
//		list.sort(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2 - o1;
//			}
//		});
		
		list.sort((o1, o2) -> o2 - o1);
		
		System.out.println("내림차순 정렬 후 : " + list);
		
	} //main
	
}
