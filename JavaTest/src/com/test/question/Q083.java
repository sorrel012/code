package com.test.question;

import java.util.Scanner;

/*

요구사항]파일명 10개를 입력 받아 각 확장자별로 총 개수를 출력하시오.

- 확장자는 다음으로 제한한다.
    ~ mp3
    ~ jpg
    ~ java
    ~ hwp
    ~ doc

1. 변수 선언
2. 입력 도구 생성
3. 라벨 출력 + 파일명 입력 받기(for - 10번 반복)
4. lastIndexOf 사용하여 확장자 추출 -> 해당 확장자에 누적
5. 결과 출력

*/

public class Q083 {

    public static void main(String[] args) {

	int mp3 = 0;
	int jpg = 0;
	int java = 0;
	int hwp = 0;
	int doc = 0;
	String filename = "";

	Scanner scan = new Scanner(System.in);

	for(int i = 0; i < 10; i++) {

	    System.out.print("파일명: ");
	    filename = scan.nextLine();

	    int index = filename.lastIndexOf(".") + 1;
	    String extension = filename.substring(index);

	    switch(extension)  {
	    case "mp3" :
		mp3++;
		break;

	    case "jpg" :
		jpg++;
		break;

	    case "java" :
		java++;
		break;

	    case "hwp" :
		hwp++;
		break;

	    case "doc" :
		doc++;
		break;
	    }

	}

	System.out.printf("mp3 : %d개\n", mp3);
	System.out.printf("jpg : %d개\n", jpg);
	System.out.printf("java : %d개\n", java);
	System.out.printf("hwp : %d개\n", hwp);
	System.out.printf("doc : %d개", doc);

	scan.close();

    } //main

}
