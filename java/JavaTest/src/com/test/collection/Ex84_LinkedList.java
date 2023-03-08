package com.test.collection;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex84_LinkedList {
	
	public static void main(String[] args) {

//		m1();
		m2();

	} //main

	private static void m2() {

		ArrayList<Integer> list1 = new ArrayList<Integer>();

		LinkedList<Integer> list2 = new LinkedList<Integer>();
		
		long begin = 0;
		long end = 0;
		
		//1. 순차적으로 데이터 추가하기, Append
		System.out.println("1. 순차적으로 데이터 추가하기");
		
		begin = System.currentTimeMillis();
		
		for(int i = 0; i < 10000000; i++) {
			list1.add(i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업 시간: %,dms\n", end - begin );
		
		
		begin = System.currentTimeMillis();
		
		for(int i = 0; i < 10000000; i++) {
			list2.add(i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업 시간: %,dms\n", end - begin );
		
		System.out.println();
		
		
		//2. 중간에 데이터 추가하기, Insert
		System.out.println("2. 중간에 데이터 추가하기");
		
		begin = System.currentTimeMillis();

		for(int i = 0; i < 1000; i++) {
			list1.add(0, i);
		}

		end = System.currentTimeMillis();

		System.out.printf("ArrayList 작업 시간: %,dms\n", end - begin );

		
		begin = System.currentTimeMillis();

		for(int i = 0; i < 500; i++) {
			list2.add(0, i);
		}

		end = System.currentTimeMillis();

		System.out.printf("LinkedList 작업 시간: %,dms\n", end - begin );
		
		System.out.println();
		
		//3. 중간에 있는 데이터 삭제하기
		System.out.println("3. 중간에 있는 데이터 삭제하기");
		
		begin = System.currentTimeMillis();

		for(int i = 0; i < 500; i++) {
			list1.remove(0);
		}

		end = System.currentTimeMillis();

		System.out.printf("ArrayList 작업 시간: %,dms\n", end - begin );
		
		begin = System.currentTimeMillis();

		for(int i = 0; i < 500; i++) {
			list2.remove(0);
		}

		end = System.currentTimeMillis();

		System.out.printf("LinkedList 작업 시간: %,dms\n", end - begin );
		System.out.println();
		
		//4. 순차적으로 데이터 삭제하기
		System.out.println("4. 순차적으로 데이터 삭제하기");
		
		begin = System.currentTimeMillis();

		for(int i = list1.size() - 1; i >= 0; i--) {
			list1.remove(i);
		}

		end = System.currentTimeMillis();

		System.out.printf("ArrayList 작업 시간: %,dms\n", end - begin );
		
				
		begin = System.currentTimeMillis();
		
		for(int i = list2.size() - 1; i >= 0; i--) {
			list2.remove(i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업 시간: %,dms\n", end - begin );
		
		
		
	}

	private static void m1() {
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		list1.add(100);
		list1.add(200);
		list1.add(300);
		
		System.out.println(list1.size());
		
		System.out.println(list1.get(0));
		System.out.println(list1.get(1));
		System.out.println(list1.get(2));
		
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		
		list2.add(100);
		list2.add(200);
		list2.add(300);
		
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		System.out.println(list2.get(2));
				
	}
	
}
