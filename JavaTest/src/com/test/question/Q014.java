package com.test.question;

import java.util.Scanner;

public class Q014 {
    /*

    요구사항] 지하철 탑승 소요 시간을 구하시오. 지나가는 역의 개수, 환승역의 횟수, 시간대를 전달 받아 총 걸리는 시간을 반환하는 메소드를 선언하시오.

    - int getTime(int station, int change, int time)
    - 각 역간 소요 시간: 2분 소요
    - 환승 소요 시간: N분 소요
    - 시간대에 따라 환승 소요 시간이 다르다.
    	- 평상시: 3분
    	- 출근시: 4분
    	- 퇴근시: 5분

    1. 메소드 선언
    	1-1. 역의 개수에 따른 소요 시간 구하기
    	1-2. 시간대에 따른 환승 소요 시간 구하기
    	1-3. 1-1과 1-2 값을 더해서 반환하기
    2. 입력 도구 생성
    3. 라벨 출력
    4. 역의 개수 입력 받기
    5. 라벨 출력
    6. 환승 횟수 입력 받기
    7. 라벨 출력
    8. 시간대 입력 받기
    9. 메소드 호출하기
    10. 결과 출력하기

     */

    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);

	System.out.print("역의 개수: ");
	int station = scan.nextInt();

	System.out.print("환승 횟수: ");
	int change = scan.nextInt();

	System.out.print("시간대(1.평상시, 2.출근시, 3.퇴근시): ");
	int time = scan.nextInt();

	int totalTime = getTime(station, change, time);

	System.out.printf("총 소요 시간은 %d분입니다.\n", totalTime);

	scan.close();

    } //main

    private static int getTime(int station, int change, int time) {

	int stationTime = station * 2;
	int transferTime = time == 1 ? change*3 : time == 2 ? change*4 : change*5;

	return stationTime + transferTime;

    } //getTime

}
