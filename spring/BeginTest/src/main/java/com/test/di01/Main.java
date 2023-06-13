package com.test.di01;

public class Main {

	public static void main(String[] args) {

		//의존 관ㄱ:
		//Main > (의존) > Hong > (의존) > Pen
		//- Pen은 Hong의 의존객체이다.
		//- Hong은 Main의 의존객체이다.
		
		Hong hong = new Hong();
		hong.run();

	} //main
	
}
