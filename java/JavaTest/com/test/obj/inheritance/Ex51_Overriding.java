package com.test.obj.inheritance;

public class Ex51_Overriding {
	
	public static void main(String[] args) {

		OverridingParent hong = new OverridingParent();
		
		hong.name = "홍길동";
		hong.hello();
		
		OverridingChild jhong = new OverridingChild();
		
		jhong.name = "홍철수";
		jhong.hello();

	} //main
	
}

class OverridingParent {
	
	public String name;
	
	public void hello() {
		System.out.printf("안녕하세요. 좋은 아침입니다. 저는 %s입니다.\n",  this.name);
	}
}

class OverridingChild extends OverridingParent {

	@Override
	public void hello() {
		System.out.printf("Hello~~ My name is %s.\n",  this.name);
	}
	
}