package com.test.question;

import java.util.Scanner;

/*

요구사항] 자판기 프로그램을 구현하시오.

1. 변수 선언
2. 자판기 화면 출력하기
3. 라벨 출력 + 투입 금액 입력 받기
4. 라벨 출력 + 원하는 음료 번호 입력 받기
5. if문으로 금액이 충분한지 판단하기
	- 충분: 원하는 음료 제공 메시지 출력 + 잔돈 메시지 출력
	- 충분x: 추가 금액 투입 메시지 출력

 */

public class Q047 {
       
    public static void main(String[] args) {
	
	boolean playing = true;
	
	Scanner scan = new Scanner(System.in);
	
	while(playing) {
	    vending();
	    
	    playing = false;
	    
	    if(scan.nextInt() == 1) {
		playing = true;
	    }
	}
	
	scan.close();

    } //main

    private static void vending() {
	
	int inputPrice = 0;
	int drink = 0;
	
	Scanner scan = new Scanner(System.in);
	
	System.out.println("====================");
	System.out.println("       자판기");
	System.out.println("====================");
	System.out.println("1. 콜라 : 700원");
	System.out.println("2. 사이다 : 600원");
	System.out.println("3. 비타500 : 500원");
	System.out.println("--------------------");
	
	System.out.print("금액 투입(원) : ");
	inputPrice = scan.nextInt();
	System.out.println("--------------------");
	
	System.out.print("음료 선택(번호) : ");
	drink = scan.nextInt();
	
	checkPrice(inputPrice, drink);
		
    } //

    private static void checkPrice(int inputPrice, int drink) {
	
	int drinkPrice = 0;
	int change = 0;
	
	String drinkName = "";
	
	switch(drink) {
	case 1 :
	    drinkPrice = 700;
	    drinkName = "콜라";
	    break;
	case 2 :
	    drinkPrice = 600;
	    drinkName = "사이다";
	    break;
	case 3 :
	    drinkPrice = 500;
	    drinkName = "비타500";
	    break;
	}
	
	if(inputPrice >= drinkPrice) {
	    change = inputPrice - drinkPrice;
	    
	    System.out.printf("+%s를 제공합니다.\n", drinkName);
	    System.out.printf("+잔돈 %d원을 제공합니다.\n\n", change);
	    System.out.print("계속하시려면 1을, 종료하시려면 2를 입력하세요. : ");

	} else {
	    System.out.printf("%d원이 부족합니다.\n", drinkPrice - inputPrice);
	    System.out.printf("투입 금액 %d원을 반환합니다.\n\n", inputPrice);
	    System.out.print("다시 이용하시려면 1을, 종료하시려면 2를 입력하세요. : ");
	}
	
    } //checkPrice
    
    
}
