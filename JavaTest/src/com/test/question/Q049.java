package com.test.question;

import java.util.Scanner;

public class Q049 {
    
    /*
    
    요구사항]아래와 같이 출력하시오.
    
    - 행의 갯수를 입력받으시오.
    
    1. 변수 선언
    2. 입력 도구 생성
    3. 라벨 출력 + 행 입력 받기
    4. 반복문으로 입력  행 수만큼 별 갯수가 줄어들게 출력
    
     */
    
    public static void main(String[] args) {

	int row = 0;
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("행: ");
	row = scan.nextInt();
	
	for(int i = 0; i < row; i++) {

	    for(int j = row - i; j > 0; j--) {
		System.out.print("*");

	    }
	    System.out.println();

	    for(int k = 0; k <= i; k++) {
		System.out.print(" ");
	    }
	}
	
	scan.close();
    
    } //main

}
