package com.test.java;

import java.util.Calendar;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {

		// 요구사항] 남녀 커플의 이름과 만난날을 입력받아 기념일을 출력하시오.
		String mname = "";
		String wname = "";

		int year = 0;
		int month = 0;
		int date = 0;

		Calendar anniversary = Calendar.getInstance();

		Scanner scan = new Scanner(System.in);

		System.out.print("남자 이름: ");
		mname = scan.nextLine();

		System.out.print("여자 이름: ");
		wname = scan.nextLine();

		System.out.print("만난날(년): ");
		year = scan.nextInt();

		System.out.print("만난날(월): ");
		month = scan.nextInt();

		System.out.print("만난날(일): ");
		date = scan.nextInt();

		anniversary.set(year, month, date);

		System.out.println();
		System.out.printf("'%s'과(와) '%s'의 기념일\n", mname, wname); //형식 지정자 수정

		anniversary.add(Calendar.DATE, 100);
		System.out.printf("100일: %tF\n", anniversary);

		anniversary.add(Calendar.DATE, 200);
		System.out.printf("200일: %tF\n", anniversary);

		anniversary.add(Calendar.DATE, 300);
		System.out.printf("300일: %tF\n", anniversary);

		anniversary.add(Calendar.DATE, 500);
		System.out.printf("500일: %tF\n", anniversary);

		anniversary.add(Calendar.DATE, 1000);
		System.out.printf("1000일: %tF\n", anniversary);

		scan.close();

	}

}
