package com.test.java;

public class Ex08_Output {
    public static void main(String[] args) {
	//System.out.println();
	System.out.println(100);
	System.out.println(200);
	System.out.println();

	//System.out.print();
	System.out.print("하나");
	System.out.print("둘");

	System.out.println();
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

	System.out.println();

	String name = "홍길동";
	System.out.printf("안녕하세요. %s님. 안녕히 가세요. %s님.\n", name, name);

	//요구사항] insert into tblMember (seq, name, age, address, tel) values (1, '홍길동', 20, '서울시 강남구 역삼동', '010-1234-5678');
	name = "홍길동";
	String seq = "1";
	String age = "20";
	String address = "서울시 강남구 역삼동";
	String tel = "010-1234-5678";

	System.out.printf("insert into tblMember (seq, name, age, address, tel) values (%s, '%s', %s, '%s', '%s')\n", seq, name, age, address, tel);
	System.out.println();

	int a = 100;
	double b = 3.14;
	char c = 'A';
	boolean d = true;

	System.out.printf("문자열: %s\n", name);
	System.out.printf("정수: %d\n", a);
	System.out.printf("실수: %f\n", b);
	System.out.printf("문자: %c\n", c);
	System.out.printf("논리: %b\n", d);

	System.out.println();


    }

}
