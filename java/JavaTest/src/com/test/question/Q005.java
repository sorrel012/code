package com.test.question;

import java.util.Scanner;

public class Q005 {
    public static void main(String[] args) {
	//요구사항]자전거가 있다. 자전거의 바퀴는 지름(직경)이 26인치이다.
	//	사용자가 페달을 밟은 횟수를 입력하면 자전거가 총 몇 m를 달렸는지 출력하시오.

	//참고: 기어비 1:1 → 페달 1회전 == 자전거 바퀴 1회전
	//조건: 모든 출력 숫자는 천단위 표기하시오.

	//1. 라벨 출력
	//2. 횟수 입력 받기
	//3. 페달 한 번 밟을 때 몇 m 달리는지 계산 > 총 m 계산
	//4. 결과 출력

	Scanner scan = new Scanner(System.in);

	System.out.print("사용자가 페달을 밟은 횟수: ");//1.
	int numberOfPedal = scan.nextInt();//2.
	double round = 0.0254 * 3.14 * 26; //3-1. 2*pi*r
	double totalMeter = round * numberOfPedal;

	System.out.printf("사용자가 총 %,d회 페달을 밟아 자전거가 총 %,.3fm를 달렸습니다.\n",
		numberOfPedal, totalMeter);
	
	scan.close();

    }
}
