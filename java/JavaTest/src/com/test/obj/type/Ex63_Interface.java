package com.test.obj.type;

public class Ex63_Interface {

	public static void main(String[] args) {

		Mouse m1;
		
		//구매 > 10년 동안
		HP600 hp = new HP600();
		hp.print();
		hp.print();
		hp.print();
		
		//교체 > 다른 프린터 구매
		LG500 lg = new LG500();
		

	} //main
	
} //Main

interface Mouse {
	
	void drag();
	void click();
	void dblclick();
	
}

class G300 implements Mouse {
	
	@Override
	public void drag() {
		
	}
	
	@Override
	public void click() {
		
	}
	
	@Override
	public void dblclick() {
		
	}
	
}

//규약의 집합 > 모든 상속 받은 클래스들의 행동을 강제로 이행 + 사용법 통일
interface Printer {
	
	//프린터 > 자격을 가지는 모든 실제 기기들의 공통된 사용법 정의
	void print();
	
}

class HP600 implements Printer {
	
	@Override
	public void print() {
		
	}
	
}

class LG500 implements Printer {

	@Override
	public void print() {

	}

}






