package com.test.question;

public class Q054 {
    
    /*
    
    요구사항]2부터 100사이의 소수를 구하시오.
    
    - 소수: 1과 자기자신으로밖에 나눠지지 않는 수
    
    1. 소수를 구하는 메소드 선언
    2. for문으로 2~100 숫자를 메소드에 넣어 반복
    
     */
    
    public static void main(String[] args) {
	
	String txt = "";

	for(int i = 2; i <= 100; i++) {
	    
	    if(isPrime(i)) {
		txt += i + ", ";
	    }
	}
	
	System.out.println(txt);

    } //main

    private static boolean isPrime(int num) {
	
	for(int i = 2; i < num; i++) {
	    
	    if(num % i == 0) {
		return false;
	    }
	    
	}
	
	return true;
    }

}
