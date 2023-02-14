package com.test.java;

public class Ex35_Array {

    public static void main(String[] args) {

//	m1();
//	m2();
//	m3();
//	m4();
	m5();

    } //main

    private static void m5() {

	int[][] nums = new int[5][5];

	int n = 1;

	for(int i = 0; i < 5; i++) {
	    for (int j = i; j < 5; j++) {
		nums[i][j] = n;
		n++;
	    }
	}


	printArray(nums);

    } //m5

    private static void printArray(int[][] nums) {

	for(int i = 0; i < nums.length; i++) {

	    System.out.print("[");

	    for(int j = 0; j < nums[0].length; j++) {
		System.out.printf("%5d", nums[i][j]);
	    }
	    System.out.printf("%5s\n","]");
	}


    }

    private static void m4() {

	//성적표
	// 여러 명 국, 영, 수

	//int[]
	//String[] > 100 > "100" > Integer.parseInt("100")

	int[][] score = new int[10][3]; //10명 x 과목

	for (int i = 0; i < score.length; i++) {
	    for(int j = 0; j < score[0].length; j++) {
		score[i][j] = (int)(Math.random() * 41) + 60;
	    }
	}

	for (int i = 0; i < score.length; i++) {
	    for(int j = 0; j < score[0].length; j++) {
		System.out.printf("%5d\t", score[i][j]);
	    }

	    System.out.println();
	}

    } //m4

    private static void m3() {

	//초기화 리스트

	int[] nums1 = { 10, 20, 30 };

	int[][] nums2 = { {10, 20, 30}, {40, 50, 60} };

	int[][][] nums3 =  { {{10, 20, 30}, {40, 50, 60}}, {{10, 20, 30}, {40, 50, 60}} };

	int[][][] nums4 = {
				{
				    { 10, 20, 30 },
				    { 40, 50, 60 }
				},

				{
				    { 10, 20, 30 },
				    { 40, 50, 60 }
				},


			};

	System.out.println(nums1);
	System.out.println(nums2);
	System.out.println(nums3);
	System.out.println(nums4);

    } //m3

    private static void m2() {

	// int nums[] = new int[3]; //가능은 하다만 요즘 잘 안 씀. 비권장


	//배열의 길이
	int[] nums1 = new int[3];
	System.out.println(nums1.length);

	int[][] nums2 = new int[2][3];
	System.out.println(nums2.length);

	int[][][] nums3 = new int[5][2][3];
	System.out.println(nums3.length);

	//num3 자료형? > int[][][] > int 3차원 배열
	//num3[0] 자료형? > int[][] > int 2차원 배열
	//num3[0][0] 자료형? > int[] > int 배열
	//num3[0][0][0] 자료형? > int > int
    }

    private static void m1() {

	int[] nums1 = new int[3];

	int[][] nums2 = new int[2][3]; //행, 열

	int[][][] nums3 = new int[2][2][3]; //면, 행, 열

	//1차원 배열
	nums1[0] = 100;
	nums1[1] = 200;
	nums1[2] = 300;

	//2차원 배열
	nums2[0][0] = 100;
	nums2[0][1] = 200;
	nums2[0][2] = 300;

	nums2[1][0] = 400;
	nums2[1][1] = 500;
	nums2[1][2] = 600;


	//3차원 배열
	nums3[0][0][0] = 100;
	nums3[0][0][0] = 200;
	nums3[0][0][0] = 300;

	nums3[0][1][0] = 400;
	nums3[0][1][1] = 500;
	nums3[0][1][2] = 600;

	nums3[1][0][0] = 700;
	nums3[1][0][0] = 800;
	nums3[1][0][0] = 900;

	nums3[1][1][0] = 1000;
	nums3[1][1][1] = 1100;
	nums3[1][1][2] = 1200;


	//출력 > 배열 탐색

	//1차원 배열 탐색 > 단일 for문
	for(int i = 0; i < nums1.length; i++) {
	    System.out.printf("%5d" , nums1[i]);
	}
	System.out.println();
	System.out.println();


	//2차원 배열 탐색 > 2중 for문
	for(int i = 0; i < nums2.length; i++) {

	    for(int j = 0; j < nums2[0].length; j++) {

		System.out.printf("%5d", nums2[i][j]);

	    }
	    System.out.println();

	}
	System.out.println();
	System.out.println();


	//3차원 배열 탐색 > 3중 for문
	for(int i = 0; i < nums3.length; i++) {

	    for(int j = 0; j < nums3[0].length; j++) {

		for(int k = 0; k < nums3[0][0].length; k++) {

		    System.out.printf("%5d", nums3[i][j][k]);

		}
		System.out.println();

	    }
	    System.out.println();

	}

    } //m1

}
