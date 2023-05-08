package com.test.question;

public class Q053 {
    
    /*
    
    요구사항] 구구단을 출력하시오.
    
    1. for문을 사용하여 행별로 출력
    	- 2~5 * n
    	- 줄바꿈
    	- 6~9 * n
    
     */
    
    public static void main(String[] args) {

	int result = 0;
	
	for(int i = 1; i <= 9; i++) {
	    
	    for(int j = 2; j <= 5; j++) {
		
		result = i*j;
			
		System.out.printf("%d x %d = %2d\t", j, i, result);
	    }
	    System.out.println();

	}

	for(int i = 1; i <= 9; i++) {
	    System.out.println();

	    for(int j = 6; j <= 9; j++) {

		result = i*j;

		System.out.printf("%d x %d = %2d\t", j, i, result);
	    }

	}

    } //main

}
