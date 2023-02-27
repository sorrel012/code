package com.test.question;

import java.util.Scanner;

public class Q035 {
    
    /*
    
    요구사항] 사용자의 이름과 인사할 횟수를 입력 받아 출력하시오.
    
    1. 변수 선언
    2. 라벨 출력 + 이름 입력 받기
    3. 라벨 출력 + 횟수 입력 받기
    4. for문으로 인삿말 출력하기
    
     */
    
    public static void main(String[] args) {

	String name = "";
	int num = 0;
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("이름: ");
	name = scan.nextLine();
	
	System.out.print("횟수: ");
	num = scan.nextInt();
	
	for (int i = 0; i < num; i++) {
	    System.out.printf("%s님 안녕하세요~\n", name);
	}
	
	scan.close();

    } //main
}
