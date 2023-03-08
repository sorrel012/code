package com.test.question;

/*

요구사항]아래와 같이 출력하시오.

- 마지막 숫자가 100이 넘기 전까지 출력하시오.

 */

public class Q060 {

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

	if (num == 0 || num == 1) {
	    return 1;
	}

	return fib(num-1) + fib(num-2);

    } //fib
}
