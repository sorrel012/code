package com.test.java;

public class Ex07_Escape {
    public static void main(String[] args) {
	//1. \n
	String msg = "안녕하세요.\n홍길동입니다.";

	System.out.println(msg + "\n");

	//2. \r
	msg = "안녕하세요.\r홍길동";

	System.out.println(msg + "\n"); //이클립스 콘솔창에서는 \n과 동일하게 동작

	//3. \t
	msg  = "하나\t둘\t셋";

	System.out.println(msg + "\n");

	//4. \b
	msg = "홍길동\b입니다.";

	System.out.println(msg + "\n");

	//5. \", \', \\
	msg = "홍길동: \"안녕하세요.\"";

	System.out.println(msg + "\n");
    }
}
