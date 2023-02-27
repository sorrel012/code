package com.test.question;

import java.util.Scanner;

public class Q056 {
    
    /*
    
    요구사항] 숫자를 2개 입력받아 각각의 약수와 두 숫자의 공약수를 구하시오.
    
    - 공약수: 둘 이상의 정수에 공통된 약수
    
    1. 변수 선언
    2. 라벨 출력 + 첫 번째 숫자 입력 받기
    3. 라벨 출력 + 두 번째 숫자 입력 받기
    4. for문 + if문으로 약수 구하기
    5. if문으로 공약수 구하기
    
     */
    
    public static void main(String[] args) {

	int num1 = 0;
	int num2 = 0;
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("첫 번째 숫자: ");
	num1 = scan.nextInt();
	
	System.out.print("두 번째 숫자: ");
	num2 = scan.nextInt();
	
	printDiv(num1);
	printDiv(num2);
	printCoDiv(num1, num2);
	
	scan.close();

    } //main

    private static void printCoDiv(int num1, int num2) {

	String txt = "";
	
	for(int i = 1; i <= num1; i++) {
	    
	    if(num1 % i == 0 && num2 % i ==0) {
		txt += i + ", ";
	    }
	}
	
	System.out.printf("%d와 %d의 공약수: %s\n", num1, num2, txt);
	
    } //printCoDiv

    private static void printDiv(int num) {
	
	String txt = "";
	
	for(int i = 1; i <= num; i++) {
	    
	    if(num % i == 0) {
		txt += i + ", ";
	    }
	}
	
	System.out.printf("%d의 약수: %s\n", num, txt);
	
    } //printDiv

}
