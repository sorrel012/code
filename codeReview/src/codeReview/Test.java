package codeReview;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
	int num = 0;

	Scanner scan = new Scanner(System.in);

	System.out.print("행: ");
	num = scan.nextInt();

	for(int i=0; i<num; ++i) {
		for(int j=0; j<=i; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
	scan.close();
    }
}
