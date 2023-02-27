package com.test.obj.cast;

public class Ex61_Casting {
	
	public static void main(String[] args) {

		//전자제품 사용 > 배터리 필요
		
		Duracell b1 = new Duracell();
		
		setPower(b1); //업캐스팅
		
		//시간이 흘러....
		Neo b2 = new Neo();
		setPower(b2); //업캐스팅
		
		//건전지 자판기
		Duracell b3 = getPower();
		
		setPower(b3);
		
		//사용자 입장
		// - "건전지를 사용한다."라는 것이 중요(듀라셀이든 네오든 상관 x..) > 추상화 > 행동의 단순함
		Battery b4 = getPower(1); //1.듀라셀, 2. 네오
		
		setPower(b4);

	} //main

	private static Battery getPower(int sel) {
		
		if (sel == 1) {
			return new Duracell();
		} else {
			return new Neo();
		}
	}

	private static Duracell getPower() {
		
		Duracell b = new Duracell();
		
		return b;
	}

	private static void setPower(Battery b) {
		System.out.println("전자제품이 동작합니다.");
	}

}

class Battery {
	public int price;
	public int capacity;
}

class Duracell extends Battery {
	public String color;
}

class Neo extends Battery {
	public int weight;
}