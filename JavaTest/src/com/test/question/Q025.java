package com.test.question;

import java.util.Scanner;

public class Q025 {
    
    /*
    
    요구사항] 숫자 2개를 입력받아 큰수와 작은수를 출력하시오.
    
    1. 입력 도구 생성
    2. 라벨 출력 + 첫 번째 숫자 입력 받기
    3. 라벨 출력 + 두 번째 숫자 입력 받기
    4. 조건문: 어떤 수가 더 큰지 | 동일한지 확인한지 체크
    	4-1. 두 수가 다를 경우 : 두 숫자가 얼마나 차이 나는지 계산하여 함께 출력
    	4-2. 두 수가 같을 경우 : "두 숫자는 동일합니다." 출력
    
     */
    
    public static void main(String[] args) {
	
	int 	num1 = 0,
		num2 = 0;
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("첫 번째 숫자: ");
	num1 = scan.nextInt();
	System.out.print("두 번째 숫자: ");
	num2 = scan.nextInt();
	
	if(num1 > num2) {
	    System.out.printf("큰 수는 %d이고, 작은 수는 %d입니다. 두 숫자는 %d이(가) 차이 납니다.\n"
		    						, num1, num2, num1 - num2);
	} else if(num1 < num2) {
	    System.out.printf("큰 수는 %d이고, 작은 수는 %d입니다. 두 숫자는 %d이(가) 차이 납니다.\n"
		    						, num2, num1, num2 - num1);
	} else {
	    System.out.println("두 숫자는 동일합니다.");
	}
	
	scan.close();

    } //main
    
}
