package com.test.question;

import java.util.Arrays;
import java.util.Scanner;

/*

요구사항]배열에 요소를 삽입하시오.

- 배열 길이: 10
- 마지막 요소는 우측으로 옮겨질 공간이 없으면 삭제된다.

1. 변수 선언
2. 배열 생성 - {5,6,1,3,2,8,7,4,10,9} 로 초기화
3. 입력 도구 생성
4. 라벨 출력 + 삽입 위치 입력 받기
5. 라벨 출력 + 값 입력 받기
6. 원본 출력
7. 반복문 사용하여 우측으로 옮기기 + 입력 받은 위치에 값 삽입
8. 결과 출력

 */

public class Q067 {

    public static void main(String[] args) {

	int index = 0;
	int value = 0;

	int[] list = { 5, 6, 1, 3, 2, 8, 7, 4, 10, 9 };

	Scanner scan = new Scanner(System.in);

	System.out.print("삽입 위치: ");
	index = scan.nextInt();

	System.out.print("값: ");
	value = scan.nextInt();

	System.out.println("원본: " + Arrays.toString(list));

	insert(list, index, value);

	System.out.println("결과: " + Arrays.toString(list));

	scan.close();

    } //main

    private static int[] insert(int[] list, int index, int value) {

	for(int i = list.length - 1; i > index; i--) {

	    list[i] = list[i-1];
	}

	list[index] = value;

	return list;

    } //insert

}
