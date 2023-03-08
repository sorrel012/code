package com.test.question;
import java.util.Scanner;

public class Q038 {

    /*
    
    요구사항] 입력 횟수(N)와 숫자 N개를 입력받아 짝수의 합과 홀수의 합을 각각 출력하시오.
    
    1. 변수 선언
    2. 입력 도구 생성
    3. 라벨 출력 + 입력 횟수 입력 받기
    4. for문 사용하여 입력 횟수만큼 라벨 출력+숫자 입력 받기
    	- if 사용하여 짝수면 짝수 변수에 누적, 홀수면 홀수 변수에 누적
    5. 짝수와 홀수 합 각각 출력
    	
     */
    
    public static void main(String[] args) {

	int	numberOfInput = 0,
		evenSum = 0,
		evenCount = 0,
		oddSum = 0,
		oddCount = 0;
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("입력 횟수: ");
	numberOfInput = scan.nextInt();
	
	for (int i = 0; i < numberOfInput; i++) {
	    System.out.print("숫자: ");
	    int num = scan.nextInt();
	    
	    if (num % 2 == 0) {
		evenSum += num;
		evenCount++;
	    } else {
		oddSum += num;
		oddCount++;
	    }
	    
	}
	
	System.out.printf("짝수 %d개의 합: %d\n", evenCount, evenSum);
	System.out.printf("홀수 %d개의 합: %d", oddCount, oddSum);
	
	scan.close();

    } //main
}
