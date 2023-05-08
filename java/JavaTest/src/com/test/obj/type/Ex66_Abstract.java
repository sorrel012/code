package com.test.obj.type;

public class Ex66_Abstract {

	public static void main(String[] args) {

		

	} //main
	
} //Main


abstract class Keyboard {

	public int price;
	public int weight;
	
	abstract void typing(String txt);
	
}


class K810 extends Keyboard {
	
	public String color;
	
	@Override
	public void typing(String txt) {
		
	}
	
} //K810


class K380 extends Keyboard {
	
	public int size;
	
	@Override
	public void typing(String txt) {
		
	}
	
}