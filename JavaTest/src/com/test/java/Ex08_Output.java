package com.test.java;

public class Ex08_Output {
    public static void main(String[] args) {
	//System.out.println();
	System.out.println(100);
	System.out.println(200);

	//System.out.print();
	System.out.print("하나");
	System.out.print("둘");

	System.out.println();

	//성적표 출력하기
	String name1 = "홍길동";
	int kor1 = 100;
	int eng1 = 90;
	int math1 = 80;

	String name2 = "아무개";
	int kor2 = 95;
	int eng2 = 77;
	int math2 = 89;

	System.out.println("=============================");
	System.out.println("           성적표");
	System.out.println("=============================");
	System.out.println("[이름]\t[국어]\t[영어]\t[수학]");

	System.out.print(name1 + "\t ");
	System.out.print(kor1 + "\t ");
	System.out.print(eng1 + "\t ");
	System.out.print(math1 + "\n");

	System.out.print(name2 + "\t ");
	System.out.print(kor2 + "\t ");
	System.out.print(eng2 + "\t ");
	System.out.print(math2 + "\n");


    }

}
