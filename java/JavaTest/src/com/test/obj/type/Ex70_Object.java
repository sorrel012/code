package com.test.obj.type;

public class Ex70_Object {
	
	public static void main(String[] args) {
		
		AAAA a1 = new AAAA();
		
		AAAA a2 = new BBBB(); //업캐스팅
		
		AAAA a3 = new CCCC(); //업캐스팅
		
		
		//Object
		Object o9 = 10; //박싱(Boxing) > 10의 자료형: new Integer(10)
		
		System.out.println(o9); // o9 > o9.toString()
		System.out.println((Integer)o9 * 2); //정석
		System.out.println((int)o9 * 2);	 //서비스 문법

	} //main

}

class AAAA {
	public String name;
}

class BBBB extends AAAA {
	public int age;
}

class CCCC extends BBBB {
	public String address;
}
