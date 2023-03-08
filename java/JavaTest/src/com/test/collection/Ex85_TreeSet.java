package com.test.collection;

import java.util.TreeSet;

public class Ex85_TreeSet {

	public static void main(String[] args) {

		m1();

	} //main

	private static void m1() {
				
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		for(int i = 1; i <= 30; i++) {
			set.add(i);
		}

		System.out.println(set);
		System.out.println(set.first());
		System.out.println(set.last());
		System.out.println(set.headSet(10));
		System.out.println(set.tailSet(20));
		System.out.println(set.subSet(15, 25));
		
	}
	
}
