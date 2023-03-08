package com.test.collection;

import java.util.Stack;

public class Ex76_Stack {
	
	public static void main(String[] args) {

		//후입선출
		
		//1. 생성
		Stack<String> stack = new Stack<String>();
		
		//2. 요소 추가하기
		stack.push("빨강");
		stack.push("노랑");
		stack.push("파랑");
		
		//3. 요소 개수 확인
		System.out.println(stack.size());
		System.out.println();
		
		//4. 요소 읽기
		/*
		System.out.println(stack.pop());
		System.out.println(stack.size());

		System.out.println(stack.pop());
		System.out.println(stack.size());

		System.out.println(stack.pop());
		System.out.println(stack.size());
		*/
		
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
		
		//5. 빈 스택 확인
		System.out.println(stack.isEmpty());
		System.out.println();

		stack.push("빨강");
		stack.push("노랑");
		stack.push("파랑");
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println(stack.isEmpty());
		System.out.println();
		
		stack.push("빨강");
		stack.push("노랑");
		stack.push("파랑");
		
		//6. last 요소 확인
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println();
		
	} //main
	
}
