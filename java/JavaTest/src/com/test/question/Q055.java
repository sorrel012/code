package com.test.question;

public class Q055 {
    
    /*
    
    요구사항]1부터 100사이의 완전수를 구하시오.
    
    - 완전수: 자기 자신을 제외한 나머지 약수들의 합이 자신과 동일한 수
    - 약수: 어떤 수나 식을 나누어 나머지가 없이 떨어지는 수
    
    1. 변수 선언하기
    2. for문으로 1~ 100까지 돌리기
    3. 약수 구하기
    4. if문으로 약수의 합이 자기 자신과 같은지 확인하기
    5. 완전수일 경우, 약수와 함께 출력하기
    
     */
    
    public static void main(String[] args) {

	for(int i = 1; i <= 100; i++) {
	    
	    printPerfect(i);
	}

    } //main

    private static void printPerfect(int num) {

	    
	int sum = 0;
		
	String txt = "[1";
	
	for(int i = 2; i < num; i++) {
	    
	    if(num % i == 0) {
		sum += i;
		txt += ", " + i;
	    }
	    	    
	}
	sum++;
	
	if(num > 1 && sum == num) {
	    System.out.printf("%d = %s]\n", num, txt);
	}
	
    }

}
