package com.test.question;

public class Pencil {
	
	private String hardness;

	public void setHardness(String hardness) {
		
		String[] hardnesses = { "4B", "3B", "2B", "B", "HB", "H", "2H", "3H", "4H" };
		
		for(int i = 0; i < hardnesses.length; i++) {
			
			if(hardness.equals(hardnesses[i])) {
				this.hardness = hardness;
				break;
			}
		}
		
	}
	
	public String info() {
		return String.format("포장 전 검수 : %s 진하기 연필입니다.", this.hardness);
	}
}
