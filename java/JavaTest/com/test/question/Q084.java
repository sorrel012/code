package com.test.question;

/*

요구사항]특정 단어가 문장내에 몇회 있어있는지 수를 세시오.

- 대상 문자열: String content = "안녕~ 길동아~ 잘가~ 길동아~";
- 검색 문자열: String word = "길동";

1. 변수 선언
2. 같은 문자 여러 번 찾을 수 있도록 indexOf + while 활용

*/

public class Q084 {

    public static void main(String[] args) {

	String content = "";
	String word = "";
	int index = 0;
	int count = 0;

	content = "안녕~ 길동아~ 잘가~ 길동아~";
	word = "길동";

	while(true) {

	    index = content.indexOf(word, index);

	    if(index == -1) {
		break;
	    }

	    count++;
	    index += 2; //word.length()

	}

	System.out.printf("'%s'을 총 %d회 발견했습니다.", word, count);

    } //main
}
