package com.test.java;

public class Ex37_String {

    public static void main(String[] args) {

//	m1();
//	m2();
//	m3();
	m4();


    } //main

    private static void m4() {

	//String vs StringBuilder

	long begin = System.nanoTime(); //tick  : 10억분의 1초

	String txt1 = "홍길동";

	for (int i = 0; i < 100000; i++) {
	    txt1 += "."; //잦은 수정
	}

	long end = System.nanoTime();

	System.out.println(txt1.length()); //100003
	System.out.println(end - begin + "ns");

	System.out.println();
	System.out.println();


	begin = System.nanoTime();

	StringBuilder txt2 = new StringBuilder("홍길동");

	for(int i = 0; i < 100000; i++) {
	    txt2.append(".");
	}

	end = System.nanoTime();

	System.out.println(txt2.length());
	System.out.println(end - begin + "ns");


    } //m4

    private static void m3() {

	String name1 = "홍길동";

	StringBuilder name2 = new StringBuilder("홍길동");

	System.out.println(name1);
	System.out.println(name2);

	System.out.println(name1.equals(name2));

    } //m3

    private static void m2() {

	//문자열 > 하면 안 되는 행동

	String txt1 = "홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동";

	txt1 += "님"; //메모리상에 큰 공간을 새로 생성해야 함..
	System.out.println(txt1);

    } //m2

    private static void m1() {

	//1.메모리의 공간은 한 번 할당되면 더이상 늘리거나 줄일 수 없다.
	//3.문자열은 참조형이다.

	//값형 > 자료형 > 메모리의 크기가 고정
	int a = 10;	//4byte
	char c = 'A';	//2byte


	//참조형 > 데이터의 크기에 따라 메모리 크기가 다르다 > ★★길이가 늘어나거나 줄어든다는 뜻 xxxxxxxx
	String b = "홍길동";	//6byte > 2byte * 3
	String d = "안녕하세요";	//10byte

	int[] ns1 = new int[3];	//12byte
	int[] ns2 = new int[5];	//20byte


	String name = "홍길동";

	name += "님";	//기존 홍길동에 님이 추가되는 것이 아니라 홍길동+님을 담는 새로운 주소의 name이 생성되는 것.
			//기존에 홍길동과 님을 담던 곳은 Garbage Colletor에서 처리

	System.out.println(name);

	System.out.println();

	String name1 = "홍길동";
	String name2 = "홍길동";	//name1과 같은 상수이기 때문에 새로운 공간을 만드는 것이 아니라 name1의 공간을 재사용 한다.
				//따라서 name1과 name2의 주소값이 같다!!!!!!!★★★(같은 곳을 가리킴)
	String name3 = "홍";

	name3 += "길동";	//연산의 결과로 만들어지는 상수는 기존 것을 재사용하지 않는다. nam1이나 name2와 주소값이 같지 않다.★★★

	System.out.println(name1 == name2);
	System.out.println(name1 == name3);

	System.out.println(name1.equals(name2));
	System.out.println(name1.equals(name3));

    } //m1

}
