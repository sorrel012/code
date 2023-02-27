package com.test.question;

import java.util.Arrays;
import java.util.Scanner;

/*

요구사항]배열의 요소를 삭제하시오.

- 배열 길이: 10
- 마지막 요소는 우측으로 옮겨질 공간이 없으면 삭제된다.

1. 변수 선언
2. 배열 생성 - {5,6,1,3,2,8,7,4,10,9} 로 초기화
3. 입력 도구 생성
4. 라벨 출력 + 삭제 위치 입력 받기
5. 원본 출력
6. 반복문 사용하여 좌측으로 옮기기 + 마지막 요소 0으로 채우기
7. 결과 출력

 */

public class Q068 {

    public static void main(String[] args) {

	int index = 0;

	int[] list = { 5, 6, 1, 3, 2, 8, 7, 4, 10, 9 };

	Scanner scan = new Scanner(System.in);

	System.out.print("삭제 위치: ");
	index = scan.nextInt();

	System.out.println("원본: " + Arrays.toString(list));

	remove(list, index);

	System.out.println("결과: " + Arrays.toString(list));

	scan.close();

    } //main

    private static int[] remove(int[] list, int index) {

	for(int i = index; i < list.length - 1; i++) {

	    list[i] = list[i+1];
	}

	list[list.length - 1] = 0;

	return list;

    } //remove

}
