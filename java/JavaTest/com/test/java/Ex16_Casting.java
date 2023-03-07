package com.test.java;

public class Ex16_Casting {
    public static void main(String[] args) {

	//정수형 리터럴: int
	//실수형 리터럴: double
	//대입 연산자는 좌우 자료형이 동일해야 함

	byte m1 = 10;	//byte = int > 명시적 형변환을 해야하는 상황이지만 예외적으로 암시적 형변환이 되도록 처리해줌

	short m2 = 10;	//short = int > 명시적 형변환을 해야하는 상황이지만 예외적으로 암시적 형변환이 되도록 처리해줌

	int m3 = 10;	//int = int

	long m4 = 10;	//long = int > 암시적 형변환


	float f1 = 3.14F; //float f1 = (float)3.14;

	double f2 = 3.14; //double = double


	// 정수 <-> 실수
	long n1 = 100;	//원본 (8byte)
	float n2;	//복사 (4byte)

	n2 = n1 + 1F; //암시적 형변환 - float이 long보다 큼.
	System.out.printf("n2 = %f\n", n2);


	double n3 = 3.14;
	int n4;

	n4 = (int)n3; //소수점 이하 절삭

	System.out.println(n4);

	System.out.printf("A의 문자코드: %d\n",(int)'A');
	System.out.printf("Z의 문자코드: %d\n",(int)'Z');

	System.out.printf("a의 문자코드: %d\n",(int)'a');
	System.out.printf("z의 문자코드: %d\n",(int)'z');

	System.out.printf("0의 문자코드: %d\n",(int)'0');
	System.out.printf("9의 문자코드: %d\n",(int)'9');

    }
}
