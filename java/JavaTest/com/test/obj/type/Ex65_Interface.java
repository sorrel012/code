package com.test.obj.type;

public class Ex65_Interface {

	public static void main(String[] args) {

		//홍길동
		//1. 아빠 역할 > 집
		//2. 과장 역할 > 직장
		

	} //main
	
}

//아빠로서 갖춰야할 행동 규약
interface 아빠 {
	
	void 돈을번다();
	void 아이와놀아준다();
	void 가족을지킨다();
	
}

//과장으로서 갖춰야할 행동 규약
interface 과장 {
	
	void 직원을관리한다();
	void 영업을한다();
	void 결재를한다();
	
}


class 홍길동 implements 아빠, 과장 {
	
	@Override
	public void 돈을번다() {
		
	}
	
	@Override
	public void 아이와놀아준다() {
		
	}
	
	@Override
	public void 가족을지킨다() {
		
	}

	@Override
	public void 직원을관리한다() {
		
	}

	@Override
	public void 영업을한다() {
		
	}

	@Override
	public void 결재를한다() {
		
	}
}