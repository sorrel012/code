package com.test.question;

import java.util.Scanner;

public class Q003 {
    public static void main(String[] args) {
	//요구사항]사각형의 너비와 높이를 입력받아 넓이와 둘레를 출력하시오.

	//1. 라벨 출력
	//2. 너비 입력 받기
	//3. 라벨 추력
	//4. 높이 입력 받기
	//5. 너비, 높이 계산하기
	//6. 결과 출력하기

	Scanner scan = new Scanner(System.in);

	//화면 설계
	System.out.print("너비(cm): ");				//1.
	int width = scan.nextInt();				//2.

	System.out.print("높이(cm): ");				//3.
	int height = scan.nextInt();				//4.

	int area = width * height;				//5-1.
	int perimeter = (width + height) * 2;			//5-2.

	System.out.printf("사각형의 넓이는 %d㎠입니다.\n",area);	//6-1.
	System.out.printf("사각형의 둘레는 %d㎝입니다.\n",perimeter);	//6-2.
    }
}
