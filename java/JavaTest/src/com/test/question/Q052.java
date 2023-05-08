package com.test.question;

import java.util.Scanner;

public class Q052 {
    
    /*
    
    요구사항]
    
    - 행의 갯수를 입력받으시오.
    
    1. 변수 선언
    2. 입력 도구 생성
    3. 라벨 출력 + 행 입력 받기
    4. 반복문으로 입력 - 메소드를 각각 선언하여 잇기
    
     */
    
    public static void main(String[] args) {

	int row = 0;
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("행 입력: ");
	row = scan.nextInt();
	
	for (int i = 0; i < row; i++) {
	    
	    for(int j = 0; j < row - i - 1; j++) {
		System.out.print(" ");
	    }
	    
	    for(int j = 97; j <= 97 + i ; j++) {
		System.out.print((char)j);
	    }
	    
	    for(int j = 97 + i; j >= 97 ; j--) {
		System.out.print((char)j);
	    }
	    
	    
	    System.out.println();
	}
	
	scan.close();

    } //main

}
