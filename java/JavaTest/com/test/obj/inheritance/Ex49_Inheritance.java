package com.test.obj.inheritance;

public class Ex49_Inheritance {
	
	public static void main(String[] args) {

		Parent p = new Parent();
		
		p.a = 10;
		p.b = 20;
		p.ccc();
		
		
		Child c = new Child();
		
		c.a = 10;
		c.b = 20;
		c.ccc();
		
		c.d = 30;
		c.e = 40;
		c.fff();
		
	} //main
	
} //Main

class Parent {
	
	public int a;
	public int b;
	
	public void ccc() {
		System.out.println("ccc");
	}
	
} //Parent

class Child extends Parent { //클래스 상속(extends Parent)
	
	public int d;
	public int e;
	
	public void fff() {
		System.out.println("fff");
	}
	
	
} //Child

/*
1. 일반 회원
	- 이름
	- 아이디
	- 암호
	- 이메일
2. 관리자 회원
	- 이름
	- 아이디
	- 암호
	- 등급
3. 임시회원
	- 이름
	- 아이디
	- 암호
	- 유효기간

class User {
	
	public String name;
	public String id;
	public String pw;
	
	public String email;
	
}

class Administrator {
	
	public String name;
	public String id;
	public String pw;
	
	public String level;
	
}

 */

class Member {
	
	public String name;
	public String id;
	public String pw;
	
}

class User extends Member {
	
	public String email;
	
}

class Administrator extends Member {
	
	public String level;
	
}

class Temp extends Member {
	
	public String exDate;
	
}