package com.test.question;

/*

요구사항]아래와 같이 출력하시오.

- 마지막 숫자가 100이 넘기 전까지 출력하시오.

 */

public class Q059 {

    public static void main(String[] args) {

	int sum = 0;
	String txt = "";

	for(int i = 0; ; i++) {

	    if(fib(i) > 100) {
		break;
	    }

	    sum += fib(i);
	    txt += fib(i) + " + ";

	}

	System.out.printf("%s = %d", txt, sum);

    } //main

    private static int fib(int num) {

	int fib = 1;

	if (num == 0) {
	    return fib;

	}

	for(int i = 1; i <= num; i++) {

	    fib += i;
	}

	return fib;

    } //fib

}
