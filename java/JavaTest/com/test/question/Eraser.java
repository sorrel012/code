package com.test.question;

public class Eraser {
	
	private String size;

	public void setSize(String size) {
		
		String[] sizes = { "Large", "Medium", "Small" };

		for(int i = 0; i < sizes.length; i++) {

			if(size.equals(sizes[i])) {
				this.size = size;
				break;
			}
		}
		
	}

	
	public String info() {
		return String.format("포장 전 검수 : %s 사이즈 지우개입니다.", this.size);
	}

}
