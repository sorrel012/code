package com.test.java;

import java.util.Arrays;
import java.util.Calendar;

public class Ex34_Array {

    public static void main(String[] args) {

//	m1();
//	m2();
//	m3();
//	m4();
//	m5();
//	m7();
//	m8();
//	m9();
//	m10();
//	m11();
//	m12();
//	m13();
//	m14();
//	m15();
//	m16();
//	m17();
//	m18();
//	m19();
//	m20();
	m21();

	// ***자바의 식별자는 조합해서 만들어낼 수 없다. > 한번에 만들어야 한다.


    } //main

    private static void m21() {

	//삭제
	// 배열의 원하는 위치의 요소 삭제
	// left shift

	String[] list = { "A", "B", "C", "D", "E" };

	int index = 1;

	for (int i = index; i < list.length - 1; i++) {

	    System.out.println(i);

	    list[i] = list[i+1];
	}

	list[list.length - 1] = null; //마지막 지우기 (빈 문자열""도 가능하지만, 나중에 보면 null이 더 깔끔할 것)

	System.out.println(Arrays.toString(list));



    } //m21

    private static void m20() {

	//★★★삽입
	// 배열의 원하는 위치에 요소 삽입
	// right shift

	String[] list = { "A", "B", "C", "D", "E" };

	int index = 1;
	String value = "F";

	for(int i = list.length - 2; i >= index ; i-- ) {

	    list[i+1] = list[i];

	}

	list[index] = value;

	System.out.println(Arrays.toString(list));




    } //m20

    private static void m19() {

	// 추출: 색상 colorAt(배열, 방번호)

	String[] colors = { "red", "yellow", "blue", "white", "black", "green", "purple", "gold", "silver" };

	System.out.println(colorAt(colors, 5));


	// 추출: subArray(배열, 시작 번호, 끝 번호)

	String[] sub = subArray(colors, 1, 7);
	System.out.println(Arrays.toString(sub));

	sub = subArray(colors, 5);
	System.out.println(Arrays.toString(sub));

    } //m19

    private static String[] subArray(String[] colors, int beginIndex) {

	String[] tmp = new String[colors.length - beginIndex];

	for(int i = beginIndex; i < colors.length; i ++) {

	    tmp[i - beginIndex] = colors[i];
	}

	return tmp;

    } //subArray without endIndex

    private static String[] subArray(String[] colors, int beginIndex, int endIndex) {

	String[] tmp = new String[endIndex - beginIndex];

	for(int i = beginIndex; i < endIndex; i ++) {

	    tmp[i - beginIndex] = colors[i];
	}

	return tmp;

    } //subArray


    private static String colorAt(String[] colors, int index) {

	return colors[index];

    } //colorAt



    private static void m18() {

	//깊은 복사 : 배열 deepCopy(배열)

	String[] colors = { "red", "yellow", "blue", "white", "black", "green", "purple", "gold", "silver" };

	String[] copy = deepCopy(colors);

	System.out.println("colors: " + Arrays.toString(colors));
	System.out.println("copy: " + Arrays.toString(copy));
	System.out.println();

	copy[0] = "skyblue";

	System.out.println("colors: " + Arrays.toString(colors));
	System.out.println("copy: " + Arrays.toString(copy));


    } //m18

    private static String[] deepCopy(String[] colors) {

	String[] tmp = new String[colors.length];

	for(int i = 0; i < colors.length; i++) {

	    tmp[i] = colors[i];
	}

	return tmp;

    } //deepCopo=y

    private static void m17() {

	//검색 : int indexOf(배열, 검색 대상)

	String[] colors = { "red", "yellow", "blue", "white", "black", "green", "purple", "gold", "silver" };

	System.out.println(indexOf(colors, "white"));
	System.out.println(indexOf(colors, "skyblue"));

    }

    private static int indexOf(String[] colors, String color) {

	for (int i = 0; i < colors.length; i++) {

	    if (colors[i].equals(color)) {

		return i;
	    }
	}

	return -1;

    } //indexOf

    private static void m16() {

	//배열을 대상으로 자주 하는 행동들

	//검색 : boolean contains(배열, 검색 대상)

	int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	int num = 5;

	if (contains(nums, num)) {
	    System.out.printf("%d는(은) 있습니다.\n", num);

	} else {
	    System.out.printf("%d는(은) 없습니다.\n", num);
	}
	System.out.println();


	String[] colors = { "red", "yellow", "blue", "white", "black", "green", "purple", "gold", "silver" };

	String color = "skyblue";


	if (contains(colors, color)) {
	    System.out.printf("%s는(은) 있습니다.\n", color);

	} else {
	    System.out.printf("%s는(은) 없습니다.\n", color);
	}
	System.out.println();


    } //m16


    public static boolean contains(String[] colors, String color) {

	for(int i = 0; i < colors.length; i++) {

	    if(colors[i].equals(color)) {
		return true;

	    }
	}

	return false;

    } //contains - String


    public static boolean contains(int[] nums, int num) {

	for(int i = 0; i < nums.length; i++) {

	    if (nums[i] == num) {
		return true;

	    }

	}

	return false;

    } //contains - int


    private static void m15() {

	//자바의 정렬 기능 사용

	int[] nums = { 5, 3, 1, 4, 2 };

	Arrays.sort(nums); //정렬 > Quick 정렬 알고리즘

	System.out.println(Arrays.toString(nums));


	String[] names = {
		"홍길동",
		"아무개",
		"테스트",
		"유재성",
		"김철수",
		"나영희",
		"고길동"
	};

	Arrays.sort(names);
	System.out.println(Arrays.toString(names));



	Calendar[] list = new Calendar[5];

	list[0]	= Calendar.getInstance();
	list[0].add(Calendar.DATE, -2);

	list[1]	= Calendar.getInstance();
	list[1].add(Calendar.DATE, -1);

	list[2]	= Calendar.getInstance();
	list[2].add(Calendar.DATE, -7);

	list[3]	= Calendar.getInstance();
	list[3].add(Calendar.DATE, 3);

	list[4]	= Calendar.getInstance();

	Arrays.sort(list);

	for (int i = 0; i < list.length; i++) {
	    System.out.printf("%tF\n", list[i]);
	}
    }

    private static void m14() {

	Calendar c1 = Calendar.getInstance();
	c1.add(Calendar.DATE, -1); //어제

	Calendar c2 = Calendar.getInstance(); //오늘

	System.out.println(c1.getTimeInMillis() > c2.getTimeInMillis());

	//날짜 비교
	System.out.println(c1.compareTo(c2));
	System.out.println(c2.compareTo(c1));
	System.out.println(c1.compareTo(c1));

	Calendar[] list = new Calendar[5];

	list[0]	= Calendar.getInstance();
	list[0].add(Calendar.DATE, -2);

	list[1]	= Calendar.getInstance();
	list[1].add(Calendar.DATE, -1);

	list[2]	= Calendar.getInstance();
	list[2].add(Calendar.DATE, -7);

	list[3]	= Calendar.getInstance();
	list[3].add(Calendar.DATE, 3);

	list[4]	= Calendar.getInstance();


	//오름차순 정렬
	for (int i = 0; i < list.length - 1; i++) {

	    for (int j = 0; j < list.length - 1 - i; j++) {

		if (list[j].compareTo(list[j+1]) > 0) {

		    Calendar tmp = list[j];
		    list[j] = list[j+1];
		    list[j+1] = tmp;
		}
	    }
	}


    } //m14()

    private static void m13() {

	String[] names = {
		"홍길동",
		"아무개",
		"테스트",
		"유재성",
		"김철수",
		"나영희",
		"고길동"
	};

	for (int i = 0; i < names.length - 1; i ++) {

	    for (int j = 0; j < names.length - 1 - i; j++) {

		//if (compare(names[j], names[j+1]) > 0) {

		if (names[j].compareTo(names[j+1]) > 0) {
		    String tmp = names[j];
		    names[j] = names[j+1];
		    names[j+1] = tmp;

		}

	    }

	}

	System.out.println(Arrays.toString(names));


    } //m13

    /**
     * Logic for comparing the character codes of two strings
     * @return 1 : 앞의 문자가 더 큼
     * @return -1 : 뒤의 문자가 더 큼
     * @return 0 : 동일
     */
    private static int compare(String s1, String s2) {

	int length = s1.length() > s2.length() ? s2.length() : s1.length();

	for (int i = 0; i < length; i++) {

	    char c1 = s1.charAt(i);
	    char c2 = s2.charAt(i);

	    if(c1 > c2) {
		return 1;

	    } else if (c1 < c2) {
		return -1;

	    }
	}

	if (s1.length() > s2.length()) {
	    return 1;

	} else if (s1.length() < s2.length()) {
	    return -1;

	}

	return 0;

    }

    private static void m12() {

	//버블 정렬

	int[] nums = { 5, 3, 1, 4, 2 };

	System.out.println(Arrays.toString(nums));
	System.out.println();

	for (int i = 0; i < nums.length - 1; i++) {

	    for (int j = 0; j < nums.length - i - 1; j++) {

		if (nums[j] > nums[j+1]) {

		    int tmp = nums[j];
		    nums[j] = nums[j+1];
		    nums[j+1] = tmp;
		}

	    }

	    System.out.printf("%d cycle\n", i + 1);
	    System.out.println(Arrays.toString(nums)+"\n");
	}

	System.out.println();
	System.out.println(Arrays.toString(nums));

	System.out.println();

	//문자열 정렬 + 버블 정렬
		String s1 = "홍길동입니다";
		String s2 = "아무개";

		System.out.println(compare(s1, s2));

    } //m12

    private static void m11() {

	//배열 자동 초기화 > 초기화 리스트

	int[] nums1 = new int[5];
	System.out.println(Arrays.toString(nums1));

	//직접 초기화 (정확히 말하자면 초기화는 아니고 수정, but 보통 초기화라고 함)
	nums1[0] = 96;
	nums1[1] = 79;
	nums1[2] = 99;
	nums1[3] = 85;
	nums1[4] = 65;
	System.out.println(Arrays.toString(nums1));

	//초기화 리스트
	int[] nums2 = new int[] { 96, 79, 99, 85, 65 };
	System.out.println(Arrays.toString(nums2));

	int[] nums3 = { 96, 79, 99, 85, 65 }; // > 가장 많이 사용
	System.out.println(Arrays.toString(nums3));

	String[] name1 = new String[3];
	name1[0] = "홍길동";
	name1[1] = "아무개";
	name1[2] = "하하하";

	String[] name2 = { "홍길동", "아무개", "하하하" };

	System.out.println(Arrays.toString(name1));
	System.out.println(Arrays.toString(name2));


    } //m11

    private static void m10() {

	//배열 초기화

	double[] nums2 = new double[3];
	System.out.println(Arrays.toString(nums2));

	char[] list1 = new char[3];
	System.out.println(Arrays.toString(list1));

	boolean[] list2 = new boolean[3];
	System.out.println(Arrays.toString(list2));

	String[] list3 = new String[3];
	System.out.println(Arrays.toString(list3));


    } //m10

    private static void m9() {

	//유틸리티 클래스
	//Arrays 클래스

	int[] nums = new int[3];

	nums[0] = 10;
	nums[1] = 20;
	nums[2] = 30;

	System.out.println(Arrays.toString(nums));
	System.out.println();

	int[] copy;

	copy = Arrays.copyOfRange(nums, 0, 3);

	System.out.println(Arrays.toString(copy));

    } //m9

    private static void m8() {

	int[] nums = new int[3];

	nums[0] = 10;
	nums[1] = 20;
	nums[2] = 30;

	//얕은복사
	int[] copy = nums;

	//깊은 복사
	int[] copy2 = new int[3];

	for(int i = 0; i < nums.length; i++) {
	    copy2[i] = nums[i];
	}

	System.out.println("nums: " + Arrays.toString(nums));
	System.out.println("copy: " + Arrays.toString(copy));
	System.out.println("copy2: " + Arrays.toString(copy2));
	System.out.println();


	nums[0] = 100;
	copy2[2] = 200;

	System.out.println("nums: " + Arrays.toString(nums));
	System.out.println("copy: " + Arrays.toString(copy));
	System.out.println("copy2: " + Arrays.toString(copy2));


    } //m8

    private static void m7() {

	//******************************
	//배열 복사(= 모든 참조형 복사)

	int a = 10;
	int b;

	b = a;

	a = 20; //원본 수정

	System.out.println(a);
	System.out.println(b);



	int[] nums = new int[3];
	nums[0] = 10;
	nums[1] = 20;
	nums[2] = 30;

	int[] copy;

	copy = nums;

	System.out.println("nums: " + Arrays.toString(nums));
	System.out.println("copy: " + Arrays.toString(copy));

	nums[0] = 100;
	copy[2] = 300;

	System.out.println("nums: " + Arrays.toString(nums));
	System.out.println("copy: " + Arrays.toString(copy));

    } //m7

    private static void m5() {

	//성적표
	// - 10명
	// - 국어, 영어, 수학 > 난수


	//데이터 저장 > 배열
	int size = 10;

	String[] name = new String[size]; //학생명
	int[] kor = new int[size]; //국어 점수
	int[] eng = new int[size]; //영어 점수
	int[] math = new int[size]; //수학 점수

		//데이터 확보
	name[0] = "김하니";
	name[1] = "정지유";
	name[2] = "정율";
	name[3] = "박소율";
	name[4] = "홍길동";
	name[5] = "고윤정";
	name[6] = "김제니";
	name[7] = "정재현";
	name[8] = "변백현";
	name[9] = "이강인";

	for (int i = 0; i < size; i++) {

	    kor[i] = (int)(Math.random() * 41) + 60;
	    eng[i] = (int)(Math.random() * 41) + 60;
	    math[i] = (int)(Math.random() * 41) + 60;

	}


	//화면 설계
	System.out.println("==============================================");
	System.out.println("                    성적표");
	System.out.println("==============================================");

	System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]");

	int total = 0;

	for (int i = 0; i < size; i++) {

	    System.out.printf("%s\t%4d\t%4d\t%4d\t%4d\t%4.1f\n"
			, name[i]
			, kor[i]
			, eng[i]
			, math[i]
			, kor[i] + eng[i] + math[i]
			, (kor[i] + eng[i] + math[i]) / 3.0);

	    total += kor[i] + eng[i] + math[i]; //모든 학생의 총점 누적

	}

	System.out.println("-----------------------------------------------");
	System.out.printf("반평균\t\t\t\t\t%4.1f\n", total / 3.0 / 10);

    } //m5

    private static void m4() {

	//정수 배열(byte, short, int, long)
	byte[] list1 = new byte[5];
	list1[0] = 10;
	System.out.println(list1[0]);

	//실수 배열(float, double)
	double[] list2 = new double[5];
	list2[0] = 3.14;
	System.out.println(list2[0]);

	//문자 배열(char)
	char[] list3 = new char[5];
	list3[0] = 'A';
	System.out.println(list3[0]);

	//논리 배열(boolean)
	boolean[] list4 = new boolean[5];
	list4[0] = true;
	list4[1] = false;
	System.out.println(list4[0]);
	System.out.println(list4[1]);

	//참조형
	String[] list5 = new String[5];
	list5[0] = "홍길동";
	System.out.println(list5[0]);

	//캘린더

//	Calendar c1; //변수
//	c1 = Calendar.getInstance(); // 값

	Calendar[] list6 = new Calendar[5]; //변수 x 5개
	list6[0] = Calendar.getInstance(); //값 할당

    } //m4

    private static void m3() {

	int[] nums = new int[10];

	nums[0] = 10;
	nums[4] = 50;
	nums[9] = 100;

	for (int i = 0; i < nums.length; i++) {

	    nums[i] = (int)(Math.random() * 10) + 1;
	}

	for (int i = 0; i < nums.length; i++) {

	    System.out.printf("nums[%d] = %d\n", i, nums[i]);
	}

    } //m3

    private static void m2() {

	//요구사항] 학생 3명 > 국어 점수 > 총점, 평균(소수 1자리)
	//추가사항] 학생 수 증가 > 300명

	//배열 선언하기(생성하기)
	// - 자료형[] 배열명 = new 자료형[길이];

//	int[] kors = new int[3]; //int 변수를 3개 만들어라! // kors의 자료형: int[]
	int[] kors = new int[300];


	//변수 : 필드(field) >>>> 프로퍼티(property), 속성(attribute)
	System.out.println(kors.length);

	kors[0] = 100;
	kors[1] = 90;
	kors[2] = 80;
	// ..
	kors[299] = 60;

	int total = 0;

	for(int i = 0; i < kors.length; i++) {
	    total += kors[i];
	}

	double avg = (double)total / kors.length;


	System.out.printf("총점: %d점\n", total);
	System.out.printf("평균: %.1f점\n", avg);

    } //m2

    private static void m1() {

	//요구사항] 학생 3명 > 국어 점수 > 총점, 평균(소수 1자리)
	//추가사항] 학생 수 증가 > 300명

	int kor1;
	int kor2;
	int kor3;

	kor1 = 100;
	kor2 = 90;
	kor3 = 80;

	int total = kor1 + kor2 + kor3; // + kor4 + ... + kor300;

	double avg = total / 300.0;

	System.out.printf("총점: %d점\n", total);
	System.out.printf("평균: %.1f점\n", avg);

    } //m1
}

