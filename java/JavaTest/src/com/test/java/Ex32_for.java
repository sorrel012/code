package com.test.java;

public class Ex32_for {
    
    public static void main(String[] args) {

	//중첩된 for문
	
//	m1();
//	m2();
//	m3();
	m4();

    } //main

    private static void m4() {
	
	//별찍기
	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 5 ; j++) {
		System.out.print("*");
	    }
	    System.out.println();
	}
	System.out.println();
	System.out.println();
	
	for (int i = 0; i < 5; i++) {
	    for (int j = i; j < 5 ; j++) {
		System.out.print("*");
	    }
	    System.out.println();
	}
	System.out.println();
	System.out.println();

    }

    private static void m3() {
	
	for(int i = 0; i < 10; i++) {
	    
	    for (int j = 0; j < 10; j++) {
		
		if(i == 5) {
		    break; //자신이 속한 제어문만 탈출
		}
		
		System.out.printf("i: %d, j: %d\n", i, j);
		
	    }
	    
	}
	
    }

    private static void m2() {
	
	//구구단 2~9단
	
	for(int i = 2; i < 10; i++) {
	    
	     System.out.println("==========");
	     System.out.printf("    %d단\n", i);
	     System.out.println("==========");
	    
	    for(int j = 1; j < 10; j++) {
		System.out.printf("%d x %d = %2d\n", i, j, i * j);
	    }
	    
	    System.out.println();
	}
	
    } //m2

    private static void m1() {
	
	//단일 for문
	for (int i = 0; i < 10; i++) {
	    System.out.println("i : " + i);
	}
	System.out.println();
	System.out.println();
	
	
	//2중 for문
	for (int i = 0; i < 10; i++) {
	    for (int j = 0; j < 10; j++) {
		System.out.printf("i : %d, j : %d\n", i, j);
	    }
	}
	
	System.out.println();
	System.out.println();
	
	
	//3중 for문
	//시계 바늘(시침, 분침, 초침)
	for (int hour = 0; hour < 24; hour++) {
	    
	    for (int min = 0; min < 60; min++) {
		
		for (int sec = 0; sec < 60; sec++) {
		    
		    System.out.printf("%2d:%2d:%2d\n", hour, min, sec);
		    
		}
	    }
	}
	
    } //m1
}
