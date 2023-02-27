package com.test.question;

public class Macaron {
	
	private int size;
	private String color;
	private int thickness;
	private int pass = 0;
	private String result = "불합격";
	
	
	public int getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		
		if(size >= 8 && size <= 14) {
			this.pass += 1;
		}
		
		this.size = size;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		
		if(!color.equals("black")) {
			this.pass += 1;
		}
		
		this.color = color;
	}
	
	public int getThickness() {
		return this.thickness;
	}
	
	public void setThickness(int thickness) {
		
		if(thickness >= 3 && thickness <= 18) {
			this.pass += 1;
		}
		
		this.thickness = thickness;
	}
	
	public int getPass() {
		return this.pass;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String info() {
		return String.format("%dcm(%s, %dmm) : %s", this.size, this.color, this.thickness, this.result);
	}
	
}
