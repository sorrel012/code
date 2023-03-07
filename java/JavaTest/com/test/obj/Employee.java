package com.test.obj;

public class Employee {

	private String name;		//직원명
	private String position;	//직급(사원,대리,과장,차장,부장..)
	private String department;	//부서(영업부, 총무부, 인사부..)

	private Employee superior;	//상급자

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Employee getSuperior() {
		return superior;
	}

	public void setSuperior(Employee superior) {
		this.superior = superior;
	}

}
