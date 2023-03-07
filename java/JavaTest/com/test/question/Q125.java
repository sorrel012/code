package com.test.question;

import java.io.FileReader;
import java.util.Stack;

public class Q125 {
	
	public static void main(String[] args) {

		try {
			
			FileReader reader = new FileReader("C:\\OneDrive\\쌍용\\과제\\120-126. 파일입출력\\문제 파일\\리소스\\괄호.java");
			int code = -1;
			String result = "";

			Stack<Character> stack = new Stack<>();
			
			while((code = reader.read()) != -1) {
				
				if(checkCompile(stack, (char)code)) {
					result = "올바른 소스입니다.";
					
				} else {
					result = "올바르지 않은 소스입니다.";
					break;
				}
				
			}
			
			System.out.println(result);
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} //main

	private static boolean checkCompile(Stack<Character> stack, char c) {
		
		if(c == '(') {
			stack.add('(');
		}
		
		if(c == '{') {
			stack.add('{');
		}
		
		if(c == ')') {
			if(stack.pop() != '(') {
				return false;
			}
		}
		
		if(c == '}') {
			if(stack.pop() != '{') {
				return false;
			}
		}
		
		return true;
		
	}
	
}
