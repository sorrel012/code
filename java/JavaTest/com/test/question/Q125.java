package com.test.question;

import java.io.FileReader;
import java.util.Stack;

public class Q125 {
	
	public static void main(String[] args) {

		try {
			
			FileReader reader = new FileReader("C:\\OneDrive\\쌍용\\과제\\120-126. 파일입출력\\문제 파일\\리소스\\괄호.java");
			
			Stack<Character> stack = new Stack<>();
			
			int code = -1;
			boolean check = true;
			
			while((code = reader.read()) != -1) {
				
				if((char)code == '(') {
					stack.add('(');
				}
				
				if((char)code == '{') {
					stack.add('{');
				}
				
				if((char)code == ')') {
					if(stack.pop() != '(') {
						check = false;
						break;
					}
				}
				
				if((char)code == '}') {
					if(stack.pop() != '{') {
						check = false;
						break;
					}
				}
				
			}
			
			if(check) {
				System.out.println("올바른 소스입니다.");
				
			} else {
				System.out.println("올바르지 않은 소스입니다.");
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} //main

}
