package codeReview;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

	String txt = "";
	String op = "";
	int result = 0;
	int n1 = 0;
	int n2 = 0;
	String[] temp = new String[2];

	Scanner scan = new Scanner(System.in);

	System.out.println("입력: ");
	txt = scan.nextLine();

	txt = txt.replace(" ", "");

	op = getOperator(txt);

	if(!op.equals("")) {

	    temp = txt.split( "\\" + op);

	    if (temp.length == 2) {

		n1 = Integer.parseInt(temp[0]);
		n2 = Integer.parseInt(temp[1]);

		if (op.equals("+")) {
		    result = n1 + n2;
		} else if (op.equals("-")) {
		    result = n1 - n2;
		} else if (op.equals("*")) {
		    result = n1 * n2;
		} else if (op.equals("/")) {
		    result = n1 / n2;
		} else if (op.equals("%")) {
		    result = n1 % n2;
		}

		System.out.printf("%d %s %d = %d\n", n1, op, n2, result);

	    } else {
		System.out.println("피연산자가 부족합니다.");
	    }

	} else {
	    System.out.println("연산자가 올바르지 않습니다.");
	}



    } //main

    private static String getOperator(String txt) {

	if (txt.contains("+")) {
	    return "+";
	} else if (txt.contains("-")) {
	    return "-";
	} else if (txt.contains("*")) {
	    return "*";
	}    else if (txt.contains("/")) {
	    return "/";
	}	    else if (txt.contains("%")) {
	    return "%";
	}

	return "";
    }

}
