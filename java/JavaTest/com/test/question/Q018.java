package com.test.question;

public class Q018 {
    /*

    요구사항] 인자로 받은 숫자들 중 양수의 갯수를 반환하는 메소드를 선언하시오.

    - int positive(int)
    - int positive(int, int)
    - int positive(int, int, int)
    - int positive(int, int, int, int)
    - int positive(int, int, int, int, int)

    1. positive(int) 메소드 생성
    	- 매개변수가 양수인지 음수인지 3항 연산자로 확인하여 개수 카운트
    2. 메소드 호출
    3. 결과 출력

     */

    public static void main(String[] args) {
	
	int count = 0;
	
	count = positive(10);
	System.out.printf("양수: %d개\n", count);

	count = positive(10, 20);
	System.out.printf("양수: %d개\n", count);

	count = positive(10, 20, -30);
	System.out.printf("양수: %d개\n", count);

	count = positive(10, 20, -30, 40);
	System.out.printf("양수: %d개\n", count);

	count = positive(10, 20, -30, 40, 50);
	System.out.printf("양수: %d개\n", count);

    } //main

    private static int positive(int num) {
	int cnt = 0;
	cnt += num > 0 ? 1 : 0;
	return cnt;
    }

    private static int positive(int num1, int num2) {
   	int cnt = 0;
   	cnt += num1> 0 ? 1 : 0;
   	cnt += num2> 0 ? 1 : 0;
   	return cnt;
    }

    private static int positive(int num1, int num2, int num3) {
   	int cnt = 0;
   	cnt += num1> 0 ? 1 : 0;
   	cnt += num2> 0 ? 1 : 0;
   	cnt += num3> 0 ? 1 : 0;
   	return cnt;
    }

    private static int positive(int num1, int num2, int num3, int num4) {
   	int cnt = 0;
   	cnt += num1> 0 ? 1 : 0;
   	cnt += num2> 0 ? 1 : 0;
   	cnt += num3> 0 ? 1 : 0;
   	cnt += num4> 0 ? 1 : 0;
   	return cnt;
    }

    private static int positive(int num1, int num2, int num3, int num4, int num5) {
   	int cnt = 0;
   	cnt += num1> 0 ? 1 : 0;
   	cnt += num2> 0 ? 1 : 0;
   	cnt += num3> 0 ? 1 : 0;
   	cnt += num4> 0 ? 1 : 0;
   	cnt += num5> 0 ? 1 : 0;
   	return cnt;
    }

}
