package com.test.obj.type;

public class Ex64_Interface {

	public static void main(String[] args) {

		MacBook mb = new MacBook();
		mb.on();
		mb.off();
		
		LGGram lg = new LGGram();
		lg.on();
		lg.off();
		

	} //main
	
} //Main

/*
//클래스 부모 > 구현된 멤버를 상속해준다.
class Notebook {
	
	private int price;
	
	public void test() {
		
	}
}
*/

//인터페이스 부모 > 업격한 부모 > 자식에게 물려주는 것은 없고 시키기만 하는 부모
interface Notebook {
	void on();
	void off();
}

class MacBook implements Notebook {
	
	@Override
	public void on() {
		System.out.println("Power On");
	}
	
	@Override
	public void off() {
		System.out.println("Power Off");
	}
	
}

class LGGram implements Notebook {

	@Override
	public void on() {
		System.out.println("전원을 켭니다.");
	}

	@Override
	public void off() {
		System.out.println("전원을 끕니다.");
	}
	
}