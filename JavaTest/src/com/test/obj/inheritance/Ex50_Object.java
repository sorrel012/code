package com.test.obj.inheritance;

public class Ex50_Object {
	
	public static void main(String[] args) {

		Object o1 = new Object();
		
		Test2 t2 = new Test2();
		t2.a = 10;
		t2.b = 20;
		
		Test t1 = new Test();

	} //main

}

class Test {
	public int a;
}

class Test2 extends Test {
	public int b;
}