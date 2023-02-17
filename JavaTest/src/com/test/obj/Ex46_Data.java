package com.test.obj;

public class Ex46_Data {

	public static void main(String[] args) {

		//데이터 확보
		//1. 실제 데이터
		//2. 가상 데이터 > 직접 만들기


		//다량의 데이터 만들기

		/* 더미 데이터
		- 중학교
		- 1~3학년
		- 학년당 5학급
		- 학급당 30명
			- 이름
			- 나이
			- 학년
			- 반
			- 번호
			-주소
		-450명
		 */

		/*
		//이름
		String[] name1 = {"김", "이", "박", "최", "정", "연", "조", "정", "유", "양" };

		String[] name2 = { "수", "경", "동", "재", "진", "아", "지", "태", "재", "우",
							"소", "기", "연", "효", "정", "우", "현", "채", "수", "원", "민" };


		String name = "";

		name += name1[(int)(Math.random() * name1.length)];

		name += name2[(int)(Math.random() * name2.length)];
		name += name2[(int)(Math.random() * name2.length)];

		//나이
		int age = 0;
		age = 14;

		//주소
		String[] address1= { "서울시", "인천시", "대전시", "광주시", "부산시", "제주시" };
		String[] address2 = { "강남구" , "강동구", "강서구", "북구", "남구", "서대문구", "동작구", "은평구", "동대문구" };
		String[] address3 = { "역삼동", "대치동", "회기동", "휘경동", "이문동", "천호동", "둔촌동", "길동", "명일동" };

		String address = "";

		address += address1[(int)(Math.random() * address1.length)];
		address += " ";
		address += address2[(int)(Math.random() * address2.length)];
		address += " ";
		address += address3[(int)(Math.random() * address3.length)];
		address += " ";
		address += (int)(Math.random() * 40) + 10 + "번지"; // 10~49번지

		System.out.println(address);
		*/

		//학생 > 4학년 > 5학급 > 30명
		String[] name1 = {"김", "이", "박", "최", "정", "연", "조", "정", "유", "양" };
		String[] name2 = { "수", "경", "동", "재", "진", "아", "지", "태", "재", "우",
							"소", "기", "연", "효", "정", "우", "현", "채", "수", "원", "민" };

		String[] address1= { "서울시", "인천시", "대전시", "광주시", "부산시", "제주시" };
		String[] address2 = { "강남구" , "강동구", "강서구", "북구", "남구", "서대문구", "동작구", "은평구", "동대문구" };
		String[] address3 = { "역삼동", "대치동", "회기동", "휘경동", "이문동", "천호동", "둔촌동", "길동", "명일동" };

//		Student[] list = new Student[3 * 5 * 30];

		Student[][][] list = new Student[3][5][30];

		for (int i = 1; i <= 3; i++) {

			for(int j = 1; j <= 5; j++) {

				for(int k = 1; k <= 30; k++) {

					Student s = new Student();

					s.setName(name1[(int)(Math.random() * name1.length)]
								+ name2[(int)(Math.random() * name2.length)]
								+ name2[(int)(Math.random() * name2.length)] );
					s.setAge(13 + i);
					s.setGrade(i);
					s.setClassNo(j);
					s.setNum(k);
					s.setAddress(address1[(int)(Math.random() * address1.length)]
									+ " "
									+ address2[(int)(Math.random() * address2.length)]
									+ " "
									+ address3[(int)(Math.random() * address3.length)]
									+ " "
									+ (int)(Math.random() * 40) + 10 + "번지");

					list[i-1][j-1][k-1] = s;

				}
			}
		}

		/*
		//학생출력
		for (int i = 0; i <list.length; i++) {

			System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t\n"
								, list[i].getName()
								, list[i].getAge()
								, list[i].getGrade()
								, list[i].getClassNo()
								, list[i].getNum()
								, list[i].getAddress());
		}
		*/

		/*
		//요구사항 3-2 학생들
		for (int i = 0; i < list.length; i++) {

			if (list[i].getGrade() == 3 && list[i].getClassNo() == 2) {
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t\n"
									, list[i].getName()
									, list[i].getAge()
									, list[i].getGrade()
									, list[i].getClassNo()
									, list[i].getNum()
									, list[i].getAddress());

			}
		}
		*/

		/*
		//다차원배열 전교생 출력
		for(int i = 0; i < list.length; i++) {

			System.out.printf("■■■■■ %d학년 ■■■■■\n", i+1);

			for (int j = 0; j < list[0].length; j++) {

				System.out.printf("■■■■ %d반 ■■■■■\n", j+1);

				for (int k = 0; k < list[0][0].length; k++) {

					System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t\n"
							, list[i][j][k].getName()
							, list[i][j][k].getAge()
							, list[i][j][k].getGrade()
							, list[i][j][k].getClassNo()
							, list[i][j][k].getNum()
							, list[i][j][k].getAddress());

				}
			}
		}
		*/

		//요구사항] 3학년 2반 학생들
		for(int i = 0; i < 30; i++) {

			System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t\n"
					, list[2][1][i].getName()
					, list[2][1][i].getAge()
					, list[2][1][i].getGrade()
					, list[2][1][i].getClassNo()
					, list[2][1][i].getNum()
					, list[2][1][i].getAddress());

		}

	} //main
}
