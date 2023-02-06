package com.test.question;

import java.util.Scanner;

public class Q004 {
    public static void main(String[] args) {
	//요구사항] 섭씨 온도를 입력받아서 화씨 온도로 변환하시오.

	//참고: ℉ = ℃ × 1.8 + 32
	//조건1: 소수 입력 가능
	//조건2: 소수점 이하 1자리까지 출력

	//1. 라벨 출력
	//2. 섭씨 입력 받기
	//3. 섭씨 온도를 화씨 온도로 변환하기
	//4. 출력하기

	Scanner scan = new Scanner(System.in);

	System.out.print("섭씨(°C): ");
	double temC = scan.nextDouble();
	double temP = temC * 1.8 + 32;

	System.out.printf("섭씨 %.1f°C는 화씨 %.1f°F입니다.\n", temC, temP);
    }
}
