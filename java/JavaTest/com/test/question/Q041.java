package com.test.question;

public class Q041 {

    /*

    요구사항] 누적값이 1000을 넘어가는 순간 루프를 종료하시오.

    1. 변수 선언
    2. for 문으로 sum에 합 누적하기
    3. if 사용하여 sum이 1000 넘으면 break로 for문 탈출

     */
    
    public static void main(String[] args) {
	
	int sum = 0;
	String txt = "";
	
	for(int i = 1; ; i++) {
	    
	    sum += i;
	    txt += i;
	    
	    if(sum > 1000) {
		break;
	    }
	    
	    txt += " + ";
	    
	}
		
	System.out.printf("%s = %d", txt, sum);
	

    } //main
    
}
