package com.test.obj.type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Scanner;

public class Ex72_Exception {

	public static void main(String[] args) {

		//요구사항] 숫자를 입력받아 연산을 하시오.
//		m1();
//		m2();
//		m3();
//		try {
//			m4();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		m5();

	}

	private static void m5() {
		
		//요구사항] 숫자 1개 입력 > 처리
		//조건] 반드시 짝수만 입력
		//		홀수 > 에러
		
		int num = 5;
		
		try {
			
			if(num % 2 == 1) {
				throw new Exception(); //강제로 예외 발생 > 예외 던지기
			}
			
			System.out.println("업무 진행..");
			
		} catch (Exception e) {
			System.out.println("예외 처리..");
		}
	}

	private static void m4() throws IOException {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//Unhandled exception
		String name = reader.readLine();
	
	}

	private static void m3() {

		try {
			
//			int num = 0;
			int num = 10;
			System.out.println(100 / num); //throw new ArithmeticException()

			int[] nums = { 10, 20, 30 }; //throw new ArrayIndexOutOfBoundsException()
//			System.out.println(nums[5]);
			System.out.println(nums[1]);
			

//			Calendar now = null; //throw new NullPointerException()
			Calendar now = Calendar.getInstance();
			System.out.println(now.get(Calendar.HOUR_OF_DAY));

		} catch (ArithmeticException e) {
			System.out.println("0으로 나누기");
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 첨자 오류");
			
		} catch(NullPointerException e) {
			System.out.println("null 참조");
			
		} catch (Exception e) {				//나머지 모든 예외 > 조건문으로 따지자면 else같은 느낌 > 위로 올라가면 안 됨
			System.out.println("예외 처리");
		}
		
	}

	private static void m2() {

		int num = 0;
		
		try {
			System.out.println(100 / num);
		} catch (Exception e) {
			System.out.println("0으로 나누기");
		}
		
		
		int[] nums = { 10, 20, 30 };
		
		try {
			System.out.println(nums[5]);
		} catch (Exception e) {
			System.out.println("배열 첨자 오류");
		}
		
		
		Calendar now = null;
		
		try {
			System.out.println(now.get(Calendar.HOUR_OF_DAY));
		} catch (Exception e) {
			System.out.println("null 참조 오류");
		}
		
		System.out.println("종료");
		
	}

	private static void m1() {
		
		Scanner scan = new Scanner(System.in);

		System.out.print("숫자: ");
		int num = scan.nextInt();

		//권장
		if(num != 0) {
			System.out.printf("100 / %d = %d\n", num, 100 / num );	//비즈니스 코드(= 업무 코드)
		} else {
			System.out.println("0을 입력할 수 없습니다."); 				//예외 처리 코드
		}
		
		//비권장 > 가독성 낮음
		if(num == 0) {
			System.out.println("0을 입력할 수 없습니다."); 				//예외 처리 코드
		} else {
			System.out.printf("100 / %d = %d\n", num, 100 / num );	//비즈니스 코드(= 업무 코드)
		}
		
		
		//try
		//catch
		//finally
		try {
			System.out.printf("100 / %d = %d\n", num, 100 / num );	//비즈니스 코드(= 업무 코드)
		} catch(Exception e) {
			System.out.println("0을 입력할 수 없습니다."); 				//예외 처리 코드
		}
		
	} //main
	
}
