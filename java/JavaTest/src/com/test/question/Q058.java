package com.test.question;

public class Q058 {
    
    /*
    
    요구사항] 아래와 같이 출력하시오.
    
    1. 변수 선언하기
    2. for문으로 누적합 구하기
    	- 루프 변수 10씩 증가
    3. 결과 출력
    
     */
    
    public static void main(String[] args) {
	
	for(int i = 1; i <= 91; i += 10) {
	    
	    int sum = 0;
	    
	    for(int j = i; j <= i + 9; j++) {
		
		sum += j;
		
	    }
	    
	    System.out.printf("%2d ~ %3d: %3d\n", i, i + 9, sum);
	    
	}

    } //main

}