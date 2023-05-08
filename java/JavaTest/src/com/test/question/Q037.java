package com.test.question;

import java.util.Scanner;

public class Q037 {
    
    /*
    
    요구사항] 숫자 1개를 입력받아 1부터 입력한 숫자까지의 합을 출력하시오.
    
    1. 변수 선언
    2. 입력 도구 생성
    3. 라벨 출력 + 원하는 숫자 입력 받기
    4. for문을 사용하여 sum에 숫자 누적하여 합 구하기
    
     */
    
    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);

	System.out.print("숫자: ");
	int num = scan.nextInt();
	
	int sum = 0;
	
	for(int i = 1 ; i < num + 1; i++) {
	    sum += i;
	}
	
	System.out.printf("1 ~ %d = %d\n", num, sum);
	
	scan.close();

    } //main
    
}
