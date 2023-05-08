package com.test.question;

import java.util.Scanner;

/*

요구사항]연산식을 입력받아 실제 연산을 하시오.

- 산술 연산자만 구현하시오.(+, -, *, /, %)
- 연산식의 공백은 자유롭게 입력 가능합니다.
- 산술 연산자가 반드시 존재하는지 체크하시오.
- 피연산자의 갯수가 2개인지 체크하시오.

1. 변수 선언
2. 산술 연산자 배열 생성
3. 입력 도구 생성
4. 라벨 출력 + 연산식 입력 받기
5. contains로 배열에 있는 연산자가 문장에 있는지 체크하기 - 일치하는 것 찾으면 op 변수에 저장
6. 산술 연산자 기준으로 split해서 배열에 담기
7. 숫자 배열의 문자열의 length가 2인지 체크하기
8. 숫자 배열 안의 숫자문자의 공백 제거하기
9. 연산자에 따라 연산하여 출력하기

*/

public class Q091 {

    public static void main(String[] args) {

	String input = "";
	String operator = "";
	int count = 0;
	int operand = 0;

	String[] operators = { "+", "-", "*", "/", "%" };

	Scanner scan = new Scanner(System.in);

	System.out.print("입력: ");
	input = scan.nextLine();

	input = input.replace(" ", "");

	for(int i = 0; i < operators.length; i++) { //산술 연산자 존재하는지 체크

	    if(input.contains(operators[i])) {
		count++;
		operator = operators[i];
		break;

	    }
	}

	while(true) {

	    if(count == 0) { //산술 연산자 x
		System.out.println("연산자가 올바르지 않습니다.");
		break;

	    }

	    String[] nums = {};

	    if(operator.equals("+") || operator.equals("*")) { //에러 수정
		nums = input.split("\\" + operator);
	    } else {
		nums = input.split(operator);
	    }

	    operand = getOperand(nums);

	    if(operand != 2) { //피연산자의 갯수 2개 x
		System.out.println("피연산자가 부족합니다.");
		break;

	    }

	    printCalc(nums, operator);
	    break;
	}

	scan.close();

    } //main

    private static int getOperand(String[] nums) { //"" 제외하고 피연산자 개수 세기

	int count = 0;

	for(int i = 0; i < nums.length; i++) {
	    if(!nums[i].equals("")) {
		count++;
	    }
	}

	return count;
    }


    private static void printCalc(String[] nums, String op) {

	int result = 0;
	int num1 = Integer.parseInt(nums[0]);
	int num2 = Integer.parseInt(nums[1]);

	switch(op) {
	case "+" :
	    result = num1 + num2;
	    break;

	case "-" :
	    result = num1 - num2;
	    break;

	case "*" :
	    result = num1 * num2;
	    break;

	case "/" :
	    result = num1 / num2;
	    break;

	case "%" :
	    result = num1 % num2;
	    break;
	}

	System.out.printf("%d %s %d = %d", num1, op, num2, result);

    }

}
