package com.test.obj;

public class Ex45_Class {

	public static void main(String[] args) {

		Employee e1 = new Employee();

		e1.setName("홍길동");
		e1.setDepartment("영업부");
		e1.setPosition("과장");

		Employee e2 = new Employee();

		e2.setName("아무개");
		e2.setDepartment("영업부");
		e2.setPosition("대리");

		e2.setSuperior(e1); //e1 객체를 통채로 superior로 전달
		
		System.out.println(e2.getSuperior().getName()); //아무개의 상급자 이름을 알아낼 수 있음

	} //main
}
