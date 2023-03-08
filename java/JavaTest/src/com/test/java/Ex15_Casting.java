package com.test.java;

public class Ex15_Casting {
    public static void main(String[] args) {

	int n1;
	int n2;

	n1 = 100; // 100이라는 데이터를 n1이라는 공간에 넣어라(오른쪽에서 왼쪽으로 할당)
	n2 = n1; // n1이라는 공간의 데이터를 가져와서, n2라는 공간에 넣어라(변수끼리의 복사)

	System.out.println(n2);

	//암시적 형변환

	short a = 10;	//2byte, 원본
	int b;		//4byte, 복사본

	b = a; //b = (int)a; > short였던 a가 자동으로 int a로 바뀐 후 b에 대입
	System.out.printf("b = %d\n",b);


	int c = 200;
	long d;

	d = c;

	System.out.printf("d = %d\n", d);

	//명시적 형변환 > 형변환 연산자 생략 불가

	int e = 32767;	//4byte, 원본
	short f;	//2byte, 복사본

	f = (short) e;
	System.out.printf("f = %d\n", f);


	long g = 3000000000L;
	int h;

	h = (int) g;
	System.out.printf("h = %d\n", h);

    }
}
