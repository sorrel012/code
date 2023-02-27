package com.test.question;

public class Ruler {
	
	private int length;
	private String shape;
	
	public void setLength(int length) {
		
		int[] lengths = { 30, 50, 100 };

		for(int i = 0; i < lengths.length; i++) {

			if(length == lengths[i]) {
				this.length = length;
				break;
			}
		}
			
	}
	
	public void setShape(String shape) {

		String[] shpaes = { "줄자", "운형자", "삼각자" };

		for(int i = 0; i < shpaes.length; i++) {

			if(shape.equals(shpaes[i])) {
				this.shape = shape;
				break;
			}
		}
		
	}
	
	public String info() {
		return String.format("포장 전 검수 : %dcm %s입니다.", this.length ,this.shape);
	}
	
}
