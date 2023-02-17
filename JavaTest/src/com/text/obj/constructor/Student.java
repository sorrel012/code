package com.text.obj.constructor;

public class Student {

	private String name;
	private int kor;
	private int eng;
	private int math;

	//A.
	public Student() {

//		this.name = null;
//		this.kor = 0;
//		this.eng = 0;
//		this.math = 0;
		
		this(null, 0, 0, 0);
		
		//B 생성자를 호출한다.
	}
	
	//B.
	public Student(int kor, int eng, int math) {

//		this.name = null;
//
//		//유효성 검사
//		if(kor >= 0 && kor <= 100) {
//			this.kor = kor;
//		}
//
//		if(eng >= 0 && eng <= 100) {
//			this.eng = eng;
//		}
//
//		if(math >= 0 && math <= 100) {
//			this.math = math;
//		}

		this(null, kor, eng, math);
	}
	
	//C.
	public Student(String name, int kor, int eng, int math) {

		this.name = name;
		
		//유효성 검사
		if(kor >= 0 && kor <= 100) {
			this.kor = kor;
		}

		if(eng >= 0 && eng <= 100) {
			this.eng = eng;
		}

		if(math >= 0 && math <= 100) {
			this.math = math;
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	//덤프
	public String info() {

		return String.format("%s(%d,%d,%d)"
								, this.name
								, this.kor
								, this.eng
								, this.math);
	}

}
