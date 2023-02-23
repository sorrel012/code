package com.test.collection;

import java.util.LinkedList;
import java.util.Queue;

public class Ex77_Queue {
	
	public static void main(String[] args) {

		//선입선출
		
		//1. 생성
		Queue<String> queue = new LinkedList<String>();
		
		//2. 요소 추가
		queue.add("red");
		queue.add("yellow");
		queue.add("blue");
		
		//3. 요소 개수
		System.out.println(queue.size());
		
		//4. 요소 읽기(= 꺼내기)
		System.out.println(queue.poll());
		System.out.println(queue.size());
		
		System.out.println(queue.poll());
		System.out.println(queue.size());
		
		System.out.println(queue.poll());
		System.out.println(queue.size());
		
		
		//5. 비었는지 확인
		System.out.println(queue.isEmpty());
		
		queue.add("green");
		
		// 6.요소 확인
		System.out.println(queue.peek());
		

	} //main
	
}
