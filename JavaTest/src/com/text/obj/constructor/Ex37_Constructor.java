package com.text.obj.constructor;

public class Ex37_Constructor {


	public static void main(String[] args) {

		Cup c1 = new Cup();

		c1.setColor("white");
		c1.setSize(500);

		System.out.println(c1.info());


		Cup c2 = new Cup("black");

		c2.setSize(600);

		System.out.println(c2.info());



		Cup c3 = new Cup(300);

		c3.setColor("green");

		System.out.println(c3.info());



		Cup c4 = new Cup("orange", 250);

		System.out.println(c4.info());

	} //main
}
