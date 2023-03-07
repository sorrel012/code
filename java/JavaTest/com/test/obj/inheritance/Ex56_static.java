package com.test.obj.inheritance;

public class Ex56_static {

	public static void main(String[] args) {
		
		StaticStudent.setSchool("역삼 중학교");
		
		StaticStudent s1 = new StaticStudent();
		s1.setName("홍길동");
		s1.hello();
		
		System.out.println();
		
		StaticStudent.hi();
	

	} //main
	
}

class StaticStudent {
	
	private String name;			//개인 데이터
	private static String school;	//공용 데이터
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static String getSchool() {
		return school;
	}
	
	public static void setSchool(String school) {
		StaticStudent.school = school;
	}
	
	//학생 개개인이 인사하는 메소드(개별적)
	public void hello() {
		System.out.printf("안녕하세요. 저는 %s입니다.\n", this.name);
		System.out.printf("저는 %s에 다녀요.\n", StaticStudent.school);
	}
	
	//학생 전체가 인사하는 메소드(포괄적)
	public static void hi() {
		System.out.println("안녕하세요. 역삼중학교에 오신 걸 환영합니다.");
	}
	
}