package com.test.question;

public class Q057 {
    
    /*
    
    요구사항] 아래와 같이 출력하시오.
    
    1. 변수 선언하기
    2. for문으로 누적합 구하기
    	- 루프 변수 10씩 증가
    3. 결과 출력
    
     */
    
    public static void main(String[] args) {
	
	for(int i = 10; i <= 100; i += 10) {
	    
	    int sum = 0;
	    
	    for(int j = 1; j <= i; j++) {
		
		sum += j;
	    }
	    
	    System.out.printf("1 ~ %3d: %3d\n", i, sum);
	}

    } //main

}
