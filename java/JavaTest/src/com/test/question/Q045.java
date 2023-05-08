package com.test.question;

import java.util.Scanner;

public class Q045 {

    /*

    요구사항] 사용자가 입력한 범위의 숫자까지 369 게임 과정을 출력하시오.
    
    - 최대 3자리까지만 입력하시오.

    1. 변수 선언
    2. 입력 도구 생성
    3. 라벨 출력 + 최대 숫자 입력하기
    4. for 반복(사용자가 입력한 숫자까지)
    	- 3, 6, 9가 들어간 수만큼 짝 출력
    	- 나머지 숫자는 숫자 출력

     */
    
    public static void main(String[] args) {

	int num = 0;
	
	String txt = "";
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("최대 숫자: ");
	num = scan.nextInt();
	
	
	if(num > 999) {
	    System.out.println("최대 3자리까지만 입력 가능합니다. 다시 입력해주세요. ");
	    System.out.print("최대 숫자: ");
	    num = scan.nextInt();
	}
	
	for(int i = 1; i <= num; i++) {
	    
	    if(clapOrNum(i).equals("")) {
		txt += i + " ";
		
	    } else {
		txt += clapOrNum(i) + " ";
	    }
	}
	
	System.out.println(txt);
	
	scan.close();
	
    } //main

    private static String clapOrNum(int num) {

	String clap = "";
	
	
	while (num > 0) {
            if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
        	clap += "짝";
            }
            num /= 10;
        }
	
	return clap;
	
    } //clapOrNum
    
}
