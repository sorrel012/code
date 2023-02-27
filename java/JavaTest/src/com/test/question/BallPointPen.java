package com.test.question;

public class BallPointPen {
	
	private double thickness;
	private String color;
	
	public void setThickness(double thickness) {
		
		double[] thicknesses = { 0.3, 0.5, 0.7, 1, 1.5 };

		for(int i = 0; i < thicknesses.length; i++) {

			if(thickness == thicknesses[i]) {
				this.thickness = thickness;
				break;
			}
		}
		
	}

	public void setColor(String color) {
		
		String[] colors = { "red", "blue", "green", "black" };
		
		for(int i = 0; i < colors.length; i++) {

			if(color.equals(colors[i])) {
				this.color = color;
				break;
			}
		}
		
	}
	
	public String info() {
		if(this.thickness == 1) {
			return String.format("포장 전 검수 : %s 색상 %.0fmm 볼펜입니다.", this.color, this.thickness);
		}
		return String.format("포장 전 검수 : %s 색상 %.1fmm 볼펜입니다.", this.color, this.thickness);
	}
	
}
